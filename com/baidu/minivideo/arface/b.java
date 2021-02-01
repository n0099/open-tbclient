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
/* loaded from: classes3.dex */
public final class b {
    private static g.a cjA;
    private static a cjB;
    private static JSONObject cjD;
    private static JSONObject cjE;
    private static c cjx;
    private static com.baidu.minivideo.arface.a.b cjy;
    private static com.baidu.minivideo.arface.utils.d cjz;
    private static Context mAppContext;
    private static boolean sDebug;
    private static File cjC = null;
    private static boolean cjF = true;
    private static String cjG = "live";

    /* loaded from: classes3.dex */
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
        com.baidu.minivideo.arface.b.e.acg().init(mAppContext);
        a(cVar);
    }

    public static void a(e eVar) {
        com.baidu.minivideo.arface.c.a.b(eVar);
    }

    public static File abG() {
        if (cjC == null) {
            cjC = new File(com.baidu.minivideo.arface.a.bB(mAppContext));
        }
        return cjC;
    }

    public static void a(a aVar) {
        h.acl().a(aVar);
    }

    public static com.baidu.minivideo.arface.a.b abH() {
        return cjy;
    }

    public static void a(com.baidu.minivideo.arface.a.b bVar) {
        cjy = bVar;
    }

    @Deprecated
    public static void a(Context context, a aVar) {
        cjB = aVar;
        if (!c.cjJ) {
            cjz = com.baidu.minivideo.arface.utils.e.acF();
        } else {
            com.baidu.minivideo.arface.utils.a bH = com.baidu.minivideo.arface.utils.a.bH(context);
            abI();
            bH.a("file:///android_asset/arsource/", new File(c.abR()), false);
            cjz = bH;
        }
        cjz.a(bC(context));
    }

    private static g.a bC(Context context) {
        if (cjA != null) {
            return cjA;
        }
        cjA = new g.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.g.a
            public void a(int i, g gVar) {
                if (b.cjz == gVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.abI();
                        b.d(append.append(c.abR()).toString());
                    }
                    if (i == 2) {
                        if (b.cjB != null) {
                            b.cjB.onResult(true, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.cjB = null;
                        }
                    } else if (i == 3 && b.cjB != null) {
                        b.cjB.onResult(false, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.cjB = null;
                    }
                }
            }
        };
        return cjA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(String str, boolean z) {
        abI();
        File file = new File(c.abT());
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

    public static c abI() {
        return cjx;
    }

    public static void a(c cVar) {
        File aco;
        cjx = cVar;
        if (cjx == null && (aco = h.acl().aco()) != null) {
            cjx = new c(aco.getAbsolutePath());
        }
    }

    public static boolean abJ() {
        return cjF;
    }

    public static String abK() {
        return cjG;
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
        c cVar = cjx;
        String abS = c.abS();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + abS);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(abS);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (cjD != null && cjD.length() > 0) {
            defaultParams.setGradingConfig(cjD);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + cjD.toString());
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
                cjD = jSONObject;
            }
        }
    }

    public static synchronized void av(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                cjE = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b abL() {
        com.baidu.minivideo.arface.bean.b aw;
        synchronized (b.class) {
            aw = (cjE == null || cjE.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.aw(cjE);
        }
        return aw;
    }

    public static synchronized JSONObject abM() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = cjE;
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
