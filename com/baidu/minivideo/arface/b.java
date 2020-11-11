package com.baidu.minivideo.arface;

import android.content.Context;
import android.opengl.EGLContext;
import android.os.Environment;
import android.util.Log;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.minivideo.arface.utils.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class b {
    private static c bZI;
    private static com.baidu.minivideo.arface.utils.c bZJ;
    private static f.a bZK;
    private static a bZL;
    private static JSONObject bZN;
    private static JSONObject bZO;
    private static Context mAppContext;
    private static boolean sDebug;
    public static final String bZF = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bZG = bZF + "/dataAR";
    public static final String bZH = bZG + "/dlModels/";
    private static File bZM = null;

    /* loaded from: classes15.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File aaa() {
        if (bZM == null) {
            bZM = new File(com.baidu.minivideo.arface.a.aK(mAppContext));
        }
        return bZM;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        if (isDebug()) {
            d("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
        }
        bZI = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bZL = aVar;
        if (!c.bZR) {
            bZJ = com.baidu.minivideo.arface.utils.d.aao();
        } else {
            com.baidu.minivideo.arface.utils.a aM = com.baidu.minivideo.arface.utils.a.aM(context);
            aab();
            aM.a("file:///android_asset/arsource/", new File(c.aah()), false);
            bZJ = aM;
        }
        bZJ.start(aL(context));
    }

    private static f.a aL(Context context) {
        if (bZK != null) {
            return bZK;
        }
        bZK = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bZJ == fVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.aab();
                        b.d(append.append(c.aah()).toString());
                    }
                    if (i == 2) {
                        if (b.bZL != null) {
                            b.bZL.onResult(true, b.G(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bZL = null;
                        }
                    } else if (i == 3 && b.bZL != null) {
                        b.bZL.onResult(false, b.G(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bZL = null;
                    }
                }
            }
        };
        return bZK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String G(String str, boolean z) {
        aab();
        File file = new File(c.aaj());
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

    public static c aab() {
        return bZI;
    }

    public static int getVersion() {
        return com.baidu.minivideo.arface.a.getVersion();
    }

    public static String getVersionName() {
        return com.baidu.minivideo.arface.a.getVersionName();
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bZI;
        String aai = c.aai();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + aai);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(aai);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bZN != null && bZN.length() > 0) {
            defaultParams.setGradingConfig(bZN);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + bZN.toString());
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
                bZN = jSONObject;
            }
        }
    }

    public static synchronized void ap(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                bZO = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b aac() {
        com.baidu.minivideo.arface.bean.b aq;
        synchronized (b.class) {
            aq = (bZO == null || bZO.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.aq(bZO);
        }
        return aq;
    }

    public static synchronized JSONObject aad() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bZO;
        }
        return jSONObject;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
