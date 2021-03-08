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
/* loaded from: classes5.dex */
public final class b {
    private static c ckX;
    private static com.baidu.minivideo.arface.a.b ckY;
    private static com.baidu.minivideo.arface.utils.d ckZ;
    private static g.a cla;
    private static a clb;
    private static JSONObject cld;
    private static JSONObject cle;
    private static Context mAppContext;
    private static boolean sDebug;
    private static File clc = null;
    private static boolean clf = true;
    private static String clg = "live";

    /* loaded from: classes5.dex */
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
        com.baidu.minivideo.arface.b.e.acj().init(mAppContext);
        a(cVar);
    }

    public static void a(e eVar) {
        com.baidu.minivideo.arface.c.a.b(eVar);
    }

    public static File abJ() {
        if (clc == null) {
            clc = new File(com.baidu.minivideo.arface.a.bA(mAppContext));
        }
        return clc;
    }

    public static void a(a aVar) {
        h.aco().a(aVar);
    }

    public static com.baidu.minivideo.arface.a.b abK() {
        return ckY;
    }

    public static void a(com.baidu.minivideo.arface.a.b bVar) {
        ckY = bVar;
    }

    @Deprecated
    public static void a(Context context, a aVar) {
        clb = aVar;
        if (!c.clj) {
            ckZ = com.baidu.minivideo.arface.utils.e.acI();
        } else {
            com.baidu.minivideo.arface.utils.a bG = com.baidu.minivideo.arface.utils.a.bG(context);
            abL();
            bG.a("file:///android_asset/arsource/", new File(c.abU()), false);
            ckZ = bG;
        }
        ckZ.a(bB(context));
    }

    private static g.a bB(Context context) {
        if (cla != null) {
            return cla;
        }
        cla = new g.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.g.a
            public void a(int i, g gVar) {
                if (b.ckZ == gVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.abL();
                        b.d(append.append(c.abU()).toString());
                    }
                    if (i == 2) {
                        if (b.clb != null) {
                            b.clb.onResult(true, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.clb = null;
                        }
                    } else if (i == 3 && b.clb != null) {
                        b.clb.onResult(false, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.clb = null;
                    }
                }
            }
        };
        return cla;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(String str, boolean z) {
        abL();
        File file = new File(c.abW());
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

    public static c abL() {
        return ckX;
    }

    public static void a(c cVar) {
        File acr;
        ckX = cVar;
        if (ckX == null && (acr = h.aco().acr()) != null) {
            ckX = new c(acr.getAbsolutePath());
        }
    }

    public static boolean abM() {
        return clf;
    }

    public static String abN() {
        return clg;
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
        c cVar = ckX;
        String abV = c.abV();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + abV);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(abV);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (cld != null && cld.length() > 0) {
            defaultParams.setGradingConfig(cld);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + cld.toString());
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
                cld = jSONObject;
            }
        }
    }

    public static synchronized void ax(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                cle = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b abO() {
        com.baidu.minivideo.arface.bean.b ay;
        synchronized (b.class) {
            ay = (cle == null || cle.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ay(cle);
        }
        return ay;
    }

    public static synchronized JSONObject abP() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = cle;
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
