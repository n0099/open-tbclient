package com.baidu.minivideo.arface;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.minivideo.arface.b.h;
import com.baidu.minivideo.arface.utils.g;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b {
    private static c cka;
    private static com.baidu.minivideo.arface.a.b ckb;
    private static com.baidu.minivideo.arface.utils.d ckc;
    private static g.a ckd;
    private static a cke;
    private static JSONObject ckg;
    private static JSONObject ckh;
    private static Context mAppContext;
    private static boolean sDebug;
    private static File ckf = null;
    private static boolean cki = true;
    private static String ckj = "live";

    /* loaded from: classes6.dex */
    public interface a {
        void onProgress(int i, int i2);

        void onResult(boolean z, String str);
    }

    public static void init(Context context) {
        e(context, "10000", "2288883fb087c4a37fbaf12bce65916e", "");
    }

    public static void e(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, null);
    }

    @Deprecated
    public static void a(Context context, String str, String str2, String str3, c cVar) {
        if (isDebug()) {
            d("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
        }
        mAppContext = context.getApplicationContext();
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
        com.baidu.minivideo.arface.b.e.ael().init(mAppContext);
        a(cVar);
    }

    public static void a(e eVar) {
        com.baidu.minivideo.arface.c.a.b(eVar);
    }

    public static File adL() {
        if (ckf == null) {
            ckf = new File(com.baidu.minivideo.arface.a.bz(mAppContext));
        }
        return ckf;
    }

    public static void a(a aVar) {
        h.aeq().a(aVar);
    }

    public static com.baidu.minivideo.arface.a.b adM() {
        return ckb;
    }

    public static void a(com.baidu.minivideo.arface.a.b bVar) {
        ckb = bVar;
    }

    @Deprecated
    public static void a(Context context, a aVar) {
        cke = aVar;
        if (!c.ckm) {
            ckc = com.baidu.minivideo.arface.utils.e.aeK();
        } else {
            com.baidu.minivideo.arface.utils.a bF = com.baidu.minivideo.arface.utils.a.bF(context);
            adN();
            bF.a("file:///android_asset/arsource/", new File(c.adW()), false);
            ckc = bF;
        }
        ckc.a(bA(context));
    }

    private static g.a bA(Context context) {
        if (ckd != null) {
            return ckd;
        }
        ckd = new g.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.g.a
            public void a(int i, g gVar) {
                if (b.ckc == gVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.adN();
                        b.d(append.append(c.adW()).toString());
                    }
                    if (i == 2) {
                        if (b.cke != null) {
                            b.cke.onResult(true, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.cke = null;
                        }
                    } else if (i == 3 && b.cke != null) {
                        b.cke.onResult(false, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.cke = null;
                    }
                }
            }
        };
        return ckd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(String str, boolean z) {
        adN();
        File file = new File(c.adY());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loc", str);
            jSONObject.put("result", z);
            jSONObject.put("resFile", file.getAbsoluteFile());
            jSONObject.put("resExist", file.exists());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        Log.e("DuAr_DuController", "ar->" + str);
    }

    public static c adN() {
        return cka;
    }

    public static void a(c cVar) {
        File aet;
        cka = cVar;
        if (cka == null && (aet = h.aeq().aet()) != null) {
            cka = new c(aet.getAbsolutePath());
        }
    }

    public static boolean adO() {
        return cki;
    }

    public static String adP() {
        return ckj;
    }

    public static int getVersion() {
        return com.baidu.minivideo.arface.a.getVersion();
    }

    public static String getVersionName() {
        return com.baidu.minivideo.arface.a.getVersionName();
    }

    public static Context getContext() {
        return mAppContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = cka;
        String adX = c.adX();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + adX);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(adX);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (ckg != null && ckg.length() > 0) {
            defaultParams.setGradingConfig(ckg);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + ckg.toString());
            }
        }
        return defaultParams;
    }

    public static synchronized void setGradingConfig(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setGradingConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                ckg = jSONObject;
            }
        }
    }

    public static synchronized void at(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                ckh = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b adQ() {
        com.baidu.minivideo.arface.bean.b au;
        synchronized (b.class) {
            au = (ckh == null || ckh.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.au(ckh);
        }
        return au;
    }

    public static synchronized JSONObject adR() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = ckh;
        }
        return jSONObject;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
