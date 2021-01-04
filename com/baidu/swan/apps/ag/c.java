package com.baidu.swan.apps.ag;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.v.g;
import com.baidu.swan.c.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static long dKK;
    private static ContentObserver dKL;
    private static PackageManager dKM;
    private static boolean dKN;
    private static Runnable dKO;
    private static ContentResolver mContentResolver;
    private static Uri mImageUri;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long mLastTime = System.currentTimeMillis() - 10000;
    private static List<com.baidu.swan.apps.ag.a> mCallbacks = new ArrayList();
    private static int mCount = 0;
    private static String dKP = null;

    static /* synthetic */ int aNK() {
        int i = mCount;
        mCount = i + 1;
        return i;
    }

    private static boolean aNH() {
        return System.currentTimeMillis() - mLastTime <= 1000;
    }

    public static void dr(Context context) {
        dKM = context.getPackageManager();
        final Handler handler = new Handler(Looper.getMainLooper());
        mContentResolver = context.getContentResolver();
        dKL = new ContentObserver(handler) { // from class: com.baidu.swan.apps.ag.c.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, final Uri uri) {
                super.onChange(z, uri);
                if (c.DEBUG) {
                    Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
                }
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ag.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.a(handler, uri);
                    }
                }, "systemScreenShot", 1);
            }
        };
        if (ds(context)) {
            mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, dKL);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    public static void a(final Handler handler, Uri uri) {
        Throwable th;
        Cursor cursor;
        Closeable closeable = null;
        if (!uri.toString().matches(a.dKS + ".*")) {
            return;
        }
        if (aNH() && dKN) {
            mLastTime = System.currentTimeMillis();
            return;
        }
        mCount = 0;
        ?? currentTimeMillis = System.currentTimeMillis();
        mLastTime = currentTimeMillis;
        try {
            try {
                cursor = mContentResolver.query(uri, a.PROJECTION, null, null, "date_added DESC");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            final String string = cursor.getString(cursor.getColumnIndex("_data"));
                            long j = cursor.getLong(cursor.getColumnIndex("date_added"));
                            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                            mImageUri = uri;
                            if (com.baidu.swan.apps.ao.c.aQV()) {
                                mImageUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID)));
                            }
                            if (DEBUG) {
                                Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j);
                                Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis2);
                                Log.d("SYSTEM_SCREENSHOT", "imageUri: " + mImageUri.toString());
                            }
                            if (aNJ()) {
                                d.closeSafely(cursor);
                                return;
                            }
                            dKP = mImageUri.toString();
                            if (a.tk(string) && a.n(currentTimeMillis2, j)) {
                                dKN = true;
                                final b bVar = new b(string, Long.valueOf(j), mImageUri);
                                dKO = new Runnable() { // from class: com.baidu.swan.apps.ag.c.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.aNK();
                                        if (c.DEBUG) {
                                            Log.d("SYSTEM_SCREENSHOT", "mCount: " + c.mCount);
                                        }
                                        if (c.d(string, c.mImageUri) || c.mCount > 10) {
                                            if (c.d(string, c.mImageUri) && c.aNI() && !c.c(string, c.mImageUri)) {
                                                for (com.baidu.swan.apps.ag.a aVar : c.mCallbacks) {
                                                    if (aVar != null) {
                                                        aVar.a(bVar);
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        handler.postDelayed(c.dKO, 100L);
                                    }
                                };
                                handler.post(dKO);
                            } else {
                                dKN = false;
                            }
                        }
                    } catch (RuntimeException e) {
                        if (dKM != null) {
                            List<ProviderInfo> queryContentProviders = dKM.queryContentProviders(null, 0, 131072);
                            HashMap hashMap = new HashMap();
                            hashMap.put("from", "SystemScreenshot");
                            hashMap.put("page", "SystemScreenshot");
                            hashMap.put("ext", queryContentProviders.toString());
                            com.baidu.swan.apps.statistic.b.onEvent("460", hashMap);
                        }
                        d.closeSafely(cursor);
                        return;
                    }
                }
                d.closeSafely(cursor);
            } catch (Throwable th2) {
                th = th2;
                closeable = currentTimeMillis;
                d.closeSafely(closeable);
                throw th;
            }
        } catch (RuntimeException e2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            d.closeSafely(closeable);
            throw th;
        }
    }

    public static boolean aNI() {
        return g.aDP().isForeground() && System.currentTimeMillis() - dKK > 2000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str, Uri uri) {
        Point point = new Point();
        WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
        if (windowManager.getDefaultDisplay() != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int navigationBarHeight = point.y + getNavigationBarHeight();
        int i = point.x;
        double d = (i != 0 ? navigationBarHeight / (i * 1.0d) : 0.0d) * 1.2d;
        double j = com.baidu.swan.apps.ao.c.aQV() ? j(uri) : 0.0d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i3 != 0) {
            j = i2 / (i3 * 1.0d);
        }
        return j > d;
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
    public static boolean d(String str, Uri uri) {
        if (com.baidu.swan.apps.ao.c.aQV()) {
            return i(uri);
        }
        new BitmapFactory.Options().inJustDecodeBounds = true;
        return BitmapFactory.decodeFile(str) != null;
    }

    private static boolean aNJ() {
        return mImageUri == null || TextUtils.equals(dKP, mImageUri.toString());
    }

    private static boolean i(Uri uri) {
        if (uri != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContentResolver, uri);
                r0 = bitmap != null;
                if (bitmap != null) {
                }
            } catch (Exception e) {
                if (0 != 0) {
                }
            } catch (Throwable th) {
                if (0 != 0) {
                }
                throw th;
            }
        }
        return r0;
    }

    private static double j(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContentResolver, uri);
            if (bitmap == null) {
                return 0.0d;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width == 0) {
                return 0.0d;
            }
            return height / (width * 1.0d);
        } catch (Exception e) {
            return 0.0d;
        }
    }

    private static boolean ds(Context context) {
        return Build.VERSION.SDK_INT < 23 || com.baidu.swan.support.v4.a.a.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static void a(com.baidu.swan.apps.ag.a aVar) {
        if (aVar != null) {
            mCallbacks.add(aVar);
        }
    }

    public static void b(com.baidu.swan.apps.ag.a aVar) {
        if (aVar != null) {
            mCallbacks.remove(aVar);
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public long dKT;
        public Uri dKU;
        public String mImagePath;

        private b(String str, Long l, Uri uri) {
            this.mImagePath = str;
            this.dKT = l.longValue();
            this.dKU = uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private static String[] PROJECTION;
        private static String dKS;

        static {
            dKS = null;
            PROJECTION = null;
            dKS = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            PROJECTION = new String[]{"_display_name", "_data", "date_added", IMConstants.MSG_ROW_ID};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean tk(String str) {
            if (str == null) {
                return false;
            }
            if (!str.toLowerCase().contains(StatisticConstants.SCREENSHOT) && !str.contains("截屏") && !str.contains("截图")) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }
}
