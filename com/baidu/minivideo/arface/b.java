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
    private static c cfn;
    private static com.baidu.minivideo.arface.a.b cfo;
    private static com.baidu.minivideo.arface.utils.d cfp;
    private static g.a cfq;
    private static a cfr;
    private static JSONObject cft;
    private static JSONObject cfu;
    private static Context mAppContext;
    private static boolean sDebug;
    private static File cfs = null;
    private static boolean cfv = true;
    private static String cfw = "live";

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
        com.baidu.minivideo.arface.b.e.aas().init(mAppContext);
        a(cVar);
    }

    public static void a(e eVar) {
        com.baidu.minivideo.arface.c.a.b(eVar);
    }

    public static File ZS() {
        if (cfs == null) {
            cfs = new File(com.baidu.minivideo.arface.a.by(mAppContext));
        }
        return cfs;
    }

    public static void a(a aVar) {
        h.aax().a(aVar);
    }

    public static com.baidu.minivideo.arface.a.b ZT() {
        return cfo;
    }

    public static void a(com.baidu.minivideo.arface.a.b bVar) {
        cfo = bVar;
    }

    @Deprecated
    public static void a(Context context, a aVar) {
        cfr = aVar;
        if (!c.cfz) {
            cfp = com.baidu.minivideo.arface.utils.e.aaR();
        } else {
            com.baidu.minivideo.arface.utils.a bE = com.baidu.minivideo.arface.utils.a.bE(context);
            ZU();
            bE.a("file:///android_asset/arsource/", new File(c.aad()), false);
            cfp = bE;
        }
        cfp.a(bz(context));
    }

    private static g.a bz(Context context) {
        if (cfq != null) {
            return cfq;
        }
        cfq = new g.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.g.a
            public void a(int i, g gVar) {
                if (b.cfp == gVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.ZU();
                        b.d(append.append(c.aad()).toString());
                    }
                    if (i == 2) {
                        if (b.cfr != null) {
                            b.cfr.onResult(true, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.cfr = null;
                        }
                    } else if (i == 3 && b.cfr != null) {
                        b.cfr.onResult(false, b.H(gVar instanceof com.baidu.minivideo.arface.utils.e ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.cfr = null;
                    }
                }
            }
        };
        return cfq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(String str, boolean z) {
        ZU();
        File file = new File(c.aaf());
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

    public static c ZU() {
        return cfn;
    }

    public static void a(c cVar) {
        File aaA;
        cfn = cVar;
        if (cfn == null && (aaA = h.aax().aaA()) != null) {
            cfn = new c(aaA.getAbsolutePath());
        }
    }

    public static boolean ZV() {
        return cfv;
    }

    public static String ZW() {
        return cfw;
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
        c cVar = cfn;
        String aae = c.aae();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + aae);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(aae);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (cft != null && cft.length() > 0) {
            defaultParams.setGradingConfig(cft);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + cft.toString());
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
                cft = jSONObject;
            }
        }
    }

    public static synchronized void at(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                cfu = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b ZX() {
        com.baidu.minivideo.arface.bean.b au;
        synchronized (b.class) {
            au = (cfu == null || cfu.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.au(cfu);
        }
        return au;
    }

    public static synchronized JSONObject ZY() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = cfu;
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
