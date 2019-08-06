package com.baidu.swan.apps.an;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.net.wifi.WifiManager;
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
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.m;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ac {
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
            return aa.is(str4);
        }
        Uri it = aa.it(str4);
        if (it == null) {
            return aa.is(str4);
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "buildPageUrl pageUrl: " + str4 + str3);
        }
        return it.buildUpon().query(str3).build().toString();
    }

    public static boolean a(com.baidu.swan.apps.ae.a.c cVar, com.baidu.swan.apps.model.b bVar, boolean z) {
        boolean z2 = true;
        if (cVar == null) {
            return false;
        }
        if (DEBUG) {
            Log.d("SwanAppUtils", "checkPageParam pageParam : " + bVar.azs);
            Log.d("SwanAppUtils", "checkPageParam allowTab : " + z);
        }
        if (z) {
            return cVar.gO(bVar.azs) || cVar.gP(bVar.azs);
        }
        if (!cVar.gO(bVar.azs) || cVar.gP(bVar.azs)) {
            z2 = false;
        }
        return z2;
    }

    public static boolean a(com.baidu.swan.apps.ae.a.c cVar, com.baidu.swan.apps.model.b bVar) {
        return cVar != null && cVar.Mz() && cVar.gP(bVar.azs);
    }

    public static void i(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        b(runnable, 0L);
    }

    public static void b(Runnable runnable, long j) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            sHandler.postDelayed(runnable, j);
        } else {
            runnable.run();
        }
    }

    public static void j(Runnable runnable) {
        sHandler.removeCallbacks(runnable);
    }

    public static void k(Runnable runnable) {
        c(runnable, 0L);
    }

    public static void c(Runnable runnable, long j) {
        sHandler.postDelayed(runnable, j);
    }

    public static String aO(String str, String str2) {
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

    public static String PJ() {
        return eC(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Nullable
    public static String eC(int i) {
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
    public static boolean PK() {
        return !a.Ph() || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static Uri iw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith(SkiaImageDecoder.FILE_PREFIX) || str.startsWith("res:/")) {
            return Uri.parse(str);
        }
        if (str.startsWith("/")) {
            return Uri.fromFile(new File(str));
        }
        return null;
    }

    public static AbsoluteLayout fe(String str) {
        com.baidu.swan.apps.b.c.d xt;
        com.baidu.swan.apps.b.c.e dY = com.baidu.swan.apps.w.e.GF().dY(str);
        if (dY == null || (xt = dY.xt()) == null) {
            return null;
        }
        return xt.getCurrentWebView();
    }

    public static com.baidu.swan.apps.view.container.a ix(String str) {
        com.baidu.swan.apps.b.c.e dY = com.baidu.swan.apps.w.e.GF().dY(str);
        if (dY instanceof com.baidu.swan.apps.b.c.c) {
            return ((com.baidu.swan.apps.b.c.c) dY).xr();
        }
        return null;
    }

    public static void PL() {
        if (DEBUG) {
            Log.d("SwanAppSlavePool", "onPreloadNextEnv()");
        }
        SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
        if (Gr != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "2");
            Gr.k(bundle);
            com.baidu.swan.apps.core.i.b.e(Gr, 600L);
        }
    }

    public static String PM() {
        com.baidu.swan.apps.core.d.d As = com.baidu.swan.apps.w.e.GF().As();
        if (As != null) {
            return As.Ac();
        }
        return null;
    }

    @Nullable
    public static String iy(@Nullable String str) {
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

    public static PackageInfo X(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", e.getMessage());
            }
            return null;
        }
    }

    public static String Y(Context context, String str) {
        PackageInfo X = X(context, str);
        if (X != null) {
            return X.versionName;
        }
        return null;
    }

    public static String getVersionName() {
        try {
            Application Ek = com.baidu.swan.apps.u.a.Ek();
            return Ek.getPackageManager().getPackageInfo(Ek.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String PN() {
        String str;
        if (a.Ph() && com.baidu.swan.apps.u.a.Ek().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.baidu.swan.apps.u.a.Ek().getSystemService("phone");
            str = telephonyManager != null ? telephonyManager.getDeviceId() : null;
        } catch (Exception e) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static Bitmap a(com.baidu.swan.apps.v.b.b bVar, String str, boolean z) {
        String str2 = "";
        if (bVar != null && !TextUtils.isEmpty(bVar.getIconUrl())) {
            str2 = bVar.getIconUrl();
        }
        return k(str2, str, z);
    }

    public static Bitmap k(String str, String str2, boolean z) {
        return a(str, str2, z, null);
    }

    public static Bitmap a(final String str, String str2, boolean z, final m.a aVar) {
        Uri iw = iw(str);
        if (m.i(iw)) {
            return m.b(iw, AppRuntime.getAppContext());
        }
        if (iw != null) {
            if (aVar != null) {
                com.facebook.drawee.a.a.c.cFR().e(ImageRequestBuilder.U(iw).cLX(), AppRuntime.getAppContext()).a(new com.facebook.imagepipeline.e.b() { // from class: com.baidu.swan.apps.an.ac.1
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
                                m.a.this.d(str, copy);
                                return;
                            } catch (Exception e) {
                                m.a.this.d(str, null);
                                return;
                            }
                        }
                        m.a.this.d(str, null);
                    }

                    @Override // com.facebook.datasource.a
                    protected void a(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                        m.a.this.d(str, null);
                    }

                    @Override // com.facebook.datasource.a, com.facebook.datasource.d
                    public void b(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.f.b>> bVar) {
                        super.b(bVar);
                        m.a.this.d(str, null);
                    }
                }, com.facebook.common.b.f.cEW());
            } else {
                m.a(iw, str2);
            }
        }
        return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? a.e.aiapps_default_icon : a.e.aiapps_default_grey_icon);
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.e("SwanAppUtils", str + " is not found");
                return false;
            }
            return false;
        }
    }

    public static boolean Z(Context context, String str) {
        boolean z = true;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
            parseUri.setFlags(268435456);
            if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null) {
                b.h(context, parseUri);
            } else {
                z = false;
            }
            return z;
        } catch (URISyntaxException e) {
            if (DEBUG) {
                Log.w("SwanAppUtils", Log.getStackTraceString(e));
                return false;
            }
            return false;
        }
    }

    public static boolean aa(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (DEBUG) {
            Log.i("SwanAppUtils", "downloadParams is " + str.toString());
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                return false;
            }
            return com.baidu.swan.apps.u.a.Eu().e(context, jSONObject);
        } catch (JSONException e) {
            if (!DEBUG) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public static String getWifiInfo(Context context) {
        String str;
        try {
            str = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            if (DEBUG) {
                Log.e("SwanAppUtils", "getWifiInfo fail!" + e.toString());
            }
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
