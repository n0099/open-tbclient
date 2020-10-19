package com.baidu.swan.apps.ah;

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
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.v.g;
import com.baidu.swan.c.d;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    public static long dit;
    private static ContentObserver diu;
    private static PackageManager div;
    private static boolean diw;
    private static Runnable dix;
    private static ContentResolver mContentResolver;
    private static Uri mImageUri;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long mLastTime = System.currentTimeMillis() - 10000;
    private static List<com.baidu.swan.apps.ah.a> mCallbacks = new ArrayList();
    private static int mCount = 0;
    private static String diy = null;

    static /* synthetic */ int aEA() {
        int i = mCount;
        mCount = i + 1;
        return i;
    }

    private static boolean aEx() {
        return System.currentTimeMillis() - mLastTime <= 1000;
    }

    public static void cv(Context context) {
        div = context.getPackageManager();
        final Handler handler = new Handler(Looper.getMainLooper());
        mContentResolver = context.getContentResolver();
        diu = new ContentObserver(handler) { // from class: com.baidu.swan.apps.ah.c.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, final Uri uri) {
                super.onChange(z, uri);
                if (c.DEBUG) {
                    Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
                }
                ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.ah.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.a(handler, uri);
                    }
                }, "systemScreenShot", 1);
            }
        };
        if (cw(context)) {
            mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, diu);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [236=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    public static void a(final Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable = null;
        if (!uri.toString().matches(a.diB + ".*")) {
            return;
        }
        if (aEx() && diw) {
            mLastTime = System.currentTimeMillis();
            return;
        }
        mCount = 0;
        ?? currentTimeMillis = System.currentTimeMillis();
        mLastTime = currentTimeMillis;
        try {
            try {
                cursor = mContentResolver.query(uri, a.diC, null, null, "date_added DESC");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            final String string = cursor.getString(cursor.getColumnIndex("_data"));
                            long j = cursor.getLong(cursor.getColumnIndex("date_added"));
                            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                            mImageUri = uri;
                            if (com.baidu.swan.apps.ap.c.aHL()) {
                                mImageUri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_ROW_ID)));
                            }
                            if (DEBUG) {
                                Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + j);
                                Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + currentTimeMillis2);
                                Log.d("SYSTEM_SCREENSHOT", "imageUri: " + mImageUri.toString());
                            }
                            if (aEz()) {
                                d.closeSafely(cursor);
                                return;
                            }
                            diy = mImageUri.toString();
                            if (a.sd(string) && a.j(currentTimeMillis2, j)) {
                                diw = true;
                                final b bVar = new b(string, Long.valueOf(j), mImageUri);
                                dix = new Runnable() { // from class: com.baidu.swan.apps.ah.c.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.aEA();
                                        if (c.DEBUG) {
                                            Log.d("SYSTEM_SCREENSHOT", "mCount: " + c.mCount);
                                        }
                                        if (c.d(string, c.mImageUri) || c.mCount > 10) {
                                            if (c.d(string, c.mImageUri) && c.aEy() && !c.c(string, c.mImageUri)) {
                                                for (com.baidu.swan.apps.ah.a aVar : c.mCallbacks) {
                                                    if (aVar != null) {
                                                        aVar.a(bVar);
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        handler.postDelayed(c.dix, 100L);
                                    }
                                };
                                handler.post(dix);
                            } else {
                                diw = false;
                            }
                        }
                    } catch (RuntimeException e) {
                        if (div != null) {
                            List<ProviderInfo> queryContentProviders = div.queryContentProviders(null, 0, 131072);
                            HashMap hashMap = new HashMap();
                            hashMap.put("from", "SystemScreenshot");
                            hashMap.put("page", "SystemScreenshot");
                            hashMap.put("ext", queryContentProviders.toString());
                            com.baidu.swan.apps.statistic.b.onEvent(BdNetTypeUtil.NATION_CODE, hashMap);
                        }
                        d.closeSafely(cursor);
                        return;
                    }
                }
                d.closeSafely(cursor);
            } catch (Throwable th) {
                closeable = currentTimeMillis;
                th = th;
                d.closeSafely(closeable);
                throw th;
            }
        } catch (RuntimeException e2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.closeSafely(closeable);
            throw th;
        }
    }

    public static boolean aEy() {
        return g.avD().isForeground() && System.currentTimeMillis() - dit > 2000;
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
        double h = com.baidu.swan.apps.ap.c.aHL() ? h(uri) : 0.0d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i3 != 0) {
            h = i2 / (i3 * 1.0d);
        }
        return h > d;
    }

    private static int getNavigationBarHeight() {
        boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        if (hasPermanentMenuKey || deviceHasKey) {
            return 0;
        }
        Resources resources = AppRuntime.getAppContext().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, Uri uri) {
        if (com.baidu.swan.apps.ap.c.aHL()) {
            return g(uri);
        }
        new BitmapFactory.Options().inJustDecodeBounds = true;
        return BitmapFactory.decodeFile(str) != null;
    }

    private static boolean aEz() {
        return mImageUri == null || TextUtils.equals(diy, mImageUri.toString());
    }

    private static boolean g(Uri uri) {
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

    private static double h(Uri uri) {
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

    private static boolean cw(Context context) {
        return Build.VERSION.SDK_INT < 23 || com.baidu.swan.support.v4.a.a.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static void a(com.baidu.swan.apps.ah.a aVar) {
        if (aVar != null) {
            mCallbacks.add(aVar);
        }
    }

    public static void b(com.baidu.swan.apps.ah.a aVar) {
        if (aVar != null) {
            mCallbacks.remove(aVar);
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long diD;
        public Uri diE;
        public String mImagePath;

        private b(String str, Long l, Uri uri) {
            this.mImagePath = str;
            this.diD = l.longValue();
            this.diE = uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static String diB;
        private static String[] diC;

        static {
            diB = null;
            diC = null;
            diB = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            diC = new String[]{"_display_name", "_data", "date_added", IMConstants.MSG_ROW_ID};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean sd(String str) {
            if (str == null) {
                return false;
            }
            if (!str.toLowerCase().contains(StatisticConstants.SCREENSHOT) && !str.contains("截屏") && !str.contains("截图")) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean j(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }
}
