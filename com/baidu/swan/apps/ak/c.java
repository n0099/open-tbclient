package com.baidu.swan.apps.ak;

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
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.y.g;
import com.baidu.swan.ubc.s;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    public static long crt;
    private static ContentObserver cru;
    private static PackageManager crv;
    private static boolean crw;
    private static Runnable crx;
    private static ContentResolver mContentResolver;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static long mLastTime = System.currentTimeMillis() - 10000;
    private static List<com.baidu.swan.apps.ak.a> mCallbacks = new ArrayList();
    private static int mCount = 0;

    static /* synthetic */ int amb() {
        int i = mCount;
        mCount = i + 1;
        return i;
    }

    private static boolean ama() {
        return System.currentTimeMillis() - mLastTime <= 1000;
    }

    public static void bV(Context context) {
        crv = context.getPackageManager();
        final Handler handler = new Handler(Looper.getMainLooper());
        mContentResolver = context.getContentResolver();
        cru = new ContentObserver(handler) { // from class: com.baidu.swan.apps.ak.c.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                if (c.DEBUG) {
                    Log.d("SYSTEM_SCREENSHOT", "onChange(), uri: " + uri);
                }
                c.a(handler, uri);
            }
        };
        if (bW(context)) {
            mContentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, cru);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    public static void a(final Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable = null;
        if (uri.toString().matches(a.crz + ".*")) {
            if (ama() && crw) {
                mLastTime = System.currentTimeMillis();
                return;
            }
            mCount = 0;
            ?? currentTimeMillis = System.currentTimeMillis();
            mLastTime = currentTimeMillis;
            try {
                try {
                    cursor = mContentResolver.query(uri, a.crA, null, null, "date_added DESC");
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                final String string = cursor.getString(cursor.getColumnIndex("_data"));
                                Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("date_added")));
                                Long valueOf2 = Long.valueOf(System.currentTimeMillis() / 1000);
                                if (DEBUG) {
                                    Log.d("SYSTEM_SCREENSHOT", "imagepath: " + string);
                                    Log.d("SYSTEM_SCREENSHOT", "dateAdded: " + valueOf);
                                    Log.d("SYSTEM_SCREENSHOT", "nowSecs: " + valueOf2);
                                }
                                if (a.mK(string) && a.l(valueOf2.longValue(), valueOf.longValue())) {
                                    crw = true;
                                    final b bVar = new b(string, valueOf);
                                    crx = new Runnable() { // from class: com.baidu.swan.apps.ak.c.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            c.amb();
                                            if (c.DEBUG) {
                                                Log.d("SYSTEM_SCREENSHOT", "mCount: " + c.mCount);
                                            }
                                            if (c.mI(string) || c.mCount > 10) {
                                                if (c.mI(string) && c.bf(2000L) && !c.mH(string)) {
                                                    for (com.baidu.swan.apps.ak.a aVar : c.mCallbacks) {
                                                        if (aVar != null) {
                                                            aVar.a(bVar);
                                                        }
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            handler.postDelayed(c.crx, 100L);
                                        }
                                    };
                                    handler.post(crx);
                                } else {
                                    crw = false;
                                }
                            }
                        } catch (RuntimeException e) {
                            if (crv != null) {
                                List<ProviderInfo> queryContentProviders = crv.queryContentProviders(null, 0, 131072);
                                HashMap hashMap = new HashMap();
                                hashMap.put("from", "SystemScreenshot");
                                hashMap.put("page", "SystemScreenshot");
                                hashMap.put("ext", queryContentProviders.toString());
                                s.onEvent(BdNetTypeUtil.NATION_CODE, hashMap);
                            }
                            com.baidu.swan.d.c.closeSafely(cursor);
                            return;
                        }
                    }
                    com.baidu.swan.d.c.closeSafely(cursor);
                } catch (Throwable th) {
                    closeable = currentTimeMillis;
                    th = th;
                    com.baidu.swan.d.c.closeSafely(closeable);
                    throw th;
                }
            } catch (RuntimeException e2) {
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.swan.d.c.closeSafely(closeable);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean bf(long j) {
        return g.aeP().isForeground() && System.currentTimeMillis() - crt > j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean mH(String str) {
        Point point = new Point();
        ((WindowManager) AppRuntime.getAppContext().getSystemService("window")).getDefaultDisplay().getSize(point);
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
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean mI(String str) {
        new BitmapFactory.Options().inJustDecodeBounds = true;
        return BitmapFactory.decodeFile(str) != null;
    }

    private static boolean bW(Context context) {
        return Build.VERSION.SDK_INT < 23 || com.baidu.swan.support.v4.a.a.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static void a(com.baidu.swan.apps.ak.a aVar) {
        if (aVar != null) {
            mCallbacks.add(aVar);
        }
    }

    public static void b(com.baidu.swan.apps.ak.a aVar) {
        if (aVar != null) {
            mCallbacks.remove(aVar);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public Long crB;
        public String mImagePath;

        public b(String str, Long l) {
            this.mImagePath = str;
            this.crB = l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a {
        public static String[] crA;
        public static String crz;

        static {
            crz = null;
            crA = null;
            crz = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            crA = new String[]{"_display_name", "_data", "date_added"};
        }

        public static boolean mK(String str) {
            if (str == null) {
                return false;
            }
            if (!str.toLowerCase().contains(StatisticConstants.SCREENSHOT) && !str.contains("截屏") && !str.contains("截图")) {
                return false;
            }
            return true;
        }

        public static boolean l(long j, long j2) {
            return Math.abs(j - j2) <= 10;
        }
    }
}
