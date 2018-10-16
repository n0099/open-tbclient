package com.baidu.searchbox.ng.ai.apps.screenshot;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsLifecycle;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.ubc.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class SystemScreenshotManager {
    public static final boolean DEBUG = false;
    public static final long DELAY_TIME = 2000;
    public static final String EXT = "ext";
    public static final String FROM = "from";
    public static final String PAGE = "page";
    public static final String TAG = "SYSTEM_SCREENSHOT";
    public static final String UBC_SHARE_FAIL = "460";
    public static final String UBC_SYSTEM_SCREENSHOT = "SystemScreenshot";
    private static ContentObserver mContentObserver;
    private static ContentResolver mContentResolver;
    private static Runnable mFileExistsRunnable;
    private static boolean mIsMatched;
    public static long mWhenAppInForeground;
    private static PackageManager pm;
    private static long mLastTime = System.currentTimeMillis() - ErrDef.Feature.WEIGHT;
    private static List<IAiAppScreenshotCallback> mCallbacks = new ArrayList();
    private static int mCount = 0;

    static /* synthetic */ int access$108() {
        int i = mCount;
        mCount = i + 1;
        return i;
    }

    private static boolean tooShort() {
        return System.currentTimeMillis() - mLastTime <= 1000;
    }

    public static void registerScreenshotObserver(Context context) {
        pm = context.getPackageManager();
        final Handler handler = new Handler(Looper.getMainLooper());
        mContentResolver = context.getContentResolver();
        mContentObserver = new ContentObserver(handler) { // from class: com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                SystemScreenshotManager.processContentChange(handler, uri);
            }
        };
        if (isRuntimePermissionGranted(context)) {
            mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, mContentObserver);
        } else {
            UniversalToast.makeText(AppRuntime.getAppContext(), "WRITE_EXTERNAL_STORAGE permission denied").showToast();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processContentChange(final Handler handler, Uri uri) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (uri.toString().matches(ScreenshotDetector.EXTERNAL_CONTENT_URI_MATCHER + ".*")) {
            if (tooShort() && mIsMatched) {
                mLastTime = System.currentTimeMillis();
                return;
            }
            mCount = 0;
            mLastTime = System.currentTimeMillis();
            try {
                cursor = mContentResolver.query(uri, ScreenshotDetector.PROJECTION, null, null, "date_added DESC");
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                final String string = cursor.getString(cursor.getColumnIndex("_data"));
                                Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("date_added")));
                                Long valueOf2 = Long.valueOf(System.currentTimeMillis() / 1000);
                                if (ScreenshotDetector.matchPath(string) && ScreenshotDetector.matchTime(valueOf2.longValue(), valueOf.longValue())) {
                                    mIsMatched = true;
                                    final ScreenshotEvent screenshotEvent = new ScreenshotEvent(string, valueOf);
                                    mFileExistsRunnable = new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            SystemScreenshotManager.access$108();
                                            if (SystemScreenshotManager.isImageExists(string) || SystemScreenshotManager.mCount > 10) {
                                                if (SystemScreenshotManager.isImageExists(string) && SystemScreenshotManager.isAppInForegroundWithTime(SystemScreenshotManager.DELAY_TIME) && !SystemScreenshotManager.isLongImage(string)) {
                                                    for (IAiAppScreenshotCallback iAiAppScreenshotCallback : SystemScreenshotManager.mCallbacks) {
                                                        if (iAiAppScreenshotCallback != null) {
                                                            iAiAppScreenshotCallback.onScreenshot(screenshotEvent);
                                                        }
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            handler.postDelayed(SystemScreenshotManager.mFileExistsRunnable, 100L);
                                        }
                                    };
                                    handler.post(mFileExistsRunnable);
                                } else {
                                    mIsMatched = false;
                                }
                            }
                        } catch (RuntimeException e) {
                            if (pm != null) {
                                List<ProviderInfo> queryContentProviders = pm.queryContentProviders(null, 0, 131072);
                                HashMap hashMap = new HashMap();
                                hashMap.put("from", UBC_SYSTEM_SCREENSHOT);
                                hashMap.put(PAGE, UBC_SYSTEM_SCREENSHOT);
                                hashMap.put("ext", queryContentProviders.toString());
                                o.onEvent(UBC_SHARE_FAIL, hashMap);
                            }
                            AiAppsFileUtils.closeSafely(cursor);
                            return;
                        }
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        AiAppsFileUtils.closeSafely(cursor2);
                        throw th;
                    }
                }
                AiAppsFileUtils.closeSafely(cursor);
            } catch (RuntimeException e2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                AiAppsFileUtils.closeSafely(cursor2);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAppInForegroundWithTime(long j) {
        return AiAppsLifecycle.get().isForeground() && System.currentTimeMillis() - mWhenAppInForeground > j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLongImage(String str) {
        Point point = new Point();
        ((WindowManager) AppRuntime.getAppContext().getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getSize(point);
        int navigationBarHeight = (int) ((point.y + getNavigationBarHeight()) * 1.2d);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outHeight > navigationBarHeight;
    }

    private static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isImageExists(String str) {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        return BitmapFactory.decodeFile(str) != null;
    }

    private static boolean isRuntimePermissionGranted(Context context) {
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static void registerCallback(IAiAppScreenshotCallback iAiAppScreenshotCallback) {
        if (iAiAppScreenshotCallback != null) {
            mCallbacks.add(iAiAppScreenshotCallback);
        }
    }

    public static void unRegisterCallback(IAiAppScreenshotCallback iAiAppScreenshotCallback) {
        if (iAiAppScreenshotCallback != null) {
            mCallbacks.remove(iAiAppScreenshotCallback);
        }
    }

    /* loaded from: classes2.dex */
    public static class ScreenshotEvent {
        public Long mDateAdded;
        public String mImagePath;

        public ScreenshotEvent(String str, Long l) {
            this.mImagePath = str;
            this.mDateAdded = l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ScreenshotDetector {
        public static String EXTERNAL_CONTENT_URI_MATCHER;
        public static String[] PROJECTION;

        private ScreenshotDetector() {
        }

        static {
            EXTERNAL_CONTENT_URI_MATCHER = null;
            PROJECTION = null;
            EXTERNAL_CONTENT_URI_MATCHER = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            PROJECTION = new String[]{"_display_name", "_data", "date_added"};
        }

        public static boolean matchPath(String str) {
            if (str == null) {
                return false;
            }
            if (!str.toLowerCase().contains("screenshot") && !str.contains("截屏") && !str.contains("截图")) {
                return false;
            }
            return true;
        }

        public static boolean matchTime(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }
}
