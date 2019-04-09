package com.baidu.swan.apps.an;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.ActivityChooserView;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.l;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class aa {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Handler sHandler = new Handler(Looper.getMainLooper());

    public static String x(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        String str4 = str + str2 + ".html";
        if (DEBUG) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4);
        }
        if (TextUtils.isEmpty(str3)) {
            return y.hI(str4);
        }
        Uri hJ = y.hJ(str4);
        if (hJ == null) {
            return y.hI(str4);
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
        }
        return hJ.buildUpon().query(str3).build().toString();
    }

    public static boolean a(com.baidu.swan.apps.ae.a.c cVar, com.baidu.swan.apps.model.b bVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "checkPageParam pageParam : " + bVar.axM);
            Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
        }
        if (z) {
            return cVar.gn(bVar.axM) || cVar.go(bVar.axM);
        }
        if (!cVar.gn(bVar.axM) || cVar.go(bVar.axM)) {
            z2 = false;
        }
        return z2;
    }

    public static boolean a(com.baidu.swan.apps.ae.a.c cVar, com.baidu.swan.apps.model.b bVar) {
        return cVar != null && cVar.Jq() && cVar.go(bVar.axM);
    }

    public static void i(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        a(runnable, 0L);
    }

    public static void a(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    public static void j(Runnable runnable) {
        b(runnable, 0L);
    }

    public static void b(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static String aL(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.w("SwanAppUtils", "openUrl && downloadUrl is empty");
            }
            return null;
        }
        StringBuilder append = new StringBuilder(SchemeConfig.getSchemeHead()).append("://v26/swan/openApp?upgrade=0");
        try {
            JSONObject jSONObject = new JSONObject();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("open", str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            jSONObject.put("download", str2);
            append.append("&params=");
            append.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
        } catch (UnsupportedEncodingException | JSONException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e));
            }
        }
        return append.toString();
    }

    public static String Ml() {
        return eo(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Nullable
    public static String eo(int i) {
        int i2 = 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (i2 >= i) {
                break;
            }
            if (stackTraceElement != null) {
                sb.append(stackTraceElement.toString()).append("\n");
                i2++;
            }
        }
        return sb.toString();
    }

    @RequiresApi(api = 23)
    public static boolean Mm() {
        return !a.LL() || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static Uri hM(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
            return Uri.parse(str);
        }
        if (str.startsWith("/")) {
            return Uri.fromFile(new File(str));
        }
        return null;
    }

    public static AbsoluteLayout eP(String str) {
        com.baidu.swan.apps.b.c.d wb;
        com.baidu.swan.apps.b.c.e eg = com.baidu.swan.apps.w.e.Ea().eg(str);
        if (eg == null || (wb = eg.wb()) == null) {
            return null;
        }
        return wb.getCurrentWebView();
    }

    public static com.baidu.swan.apps.view.container.a hN(String str) {
        com.baidu.swan.apps.b.c.e eg = com.baidu.swan.apps.w.e.Ea().eg(str);
        if (eg instanceof com.baidu.swan.apps.b.c.c) {
            return ((com.baidu.swan.apps.b.c.c) eg).vZ();
        }
        return null;
    }

    public static void Mn() {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
        }
        SwanAppActivity DM = com.baidu.swan.apps.w.e.Ea().DM();
        if (DM != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "2");
            DM.k(bundle);
            com.baidu.swan.apps.core.h.b.e(DM, 600L);
        }
    }

    public static String Mo() {
        com.baidu.swan.apps.core.c.d yO = com.baidu.swan.apps.w.e.Ea().yO();
        if (yO != null) {
            return yO.yA();
        }
        return null;
    }

    @Nullable
    public static String hO(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return str;
    }

    public static PackageInfo al(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", e.getMessage());
            }
            return null;
        }
    }

    public static String am(Context context, String str) {
        PackageInfo al = al(context, str);
        if (al != null) {
            return al.versionName;
        }
        return null;
    }

    public static String getVersionName() {
        try {
            Application Cw = com.baidu.swan.apps.u.a.Cw();
            return Cw.getPackageManager().getPackageInfo(Cw.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String Mp() {
        String str;
        if (a.LL() && com.baidu.swan.apps.u.a.Cw().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.baidu.swan.apps.u.a.Cw().getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static Bitmap a(com.baidu.swan.apps.v.b.b bVar, String str, boolean z) {
        String str2 = "";
        if (bVar != null && !TextUtils.isEmpty(bVar.axI)) {
            str2 = bVar.axI;
        }
        return j(str2, str, z);
    }

    public static Bitmap j(String str, String str2, boolean z) {
        return a(str, str2, z, null);
    }

    public static Bitmap a(final String str, String str2, boolean z, final l.a aVar) {
        Uri hM = hM(str);
        if (l.i(hM)) {
            return l.b(hM, AppRuntime.getAppContext());
        }
        if (hM != null) {
            if (aVar != null) {
                com.facebook.drawee.a.a.c.cuy().e(ImageRequestBuilder.O(hM).cAB(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.an.aa.1
                    @Override // com.facebook.imagepipeline.e.b
                    protected void f(Bitmap bitmap) {
                        Bitmap copy;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            try {
                                if (bitmap.getConfig() == null) {
                                    copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                                } else {
                                    copy = bitmap.copy(bitmap.getConfig(), true);
                                }
                                l.a.this.d(str, copy);
                                return;
                            } catch (Exception e) {
                                l.a.this.d(str, null);
                                return;
                            }
                        }
                        l.a.this.d(str, null);
                    }

                    @Override // com.facebook.datasource.a
                    protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                        l.a.this.d(str, null);
                    }

                    @Override // com.facebook.datasource.a, com.facebook.datasource.d
                    public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                        super.b(bVar);
                        l.a.this.d(str, null);
                    }
                }, com.facebook.common.b.f.ctC());
            } else {
                l.a(hM, str2);
            }
        }
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? a.e.aiapps_default_icon : a.e.aiapps_default_grey_icon);
    }
}
