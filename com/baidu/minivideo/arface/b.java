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
    private static c bLB;
    private static com.baidu.minivideo.arface.utils.c bLC;
    private static f.a bLD;
    private static a bLE;
    private static JSONObject bLG;
    private static JSONObject bLH;
    private static Context mAppContext;
    private static boolean sDebug;
    public static final String bLy = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bLz = bLy + "/dataAR";
    public static final String bLA = bLz + "/dlModels/";
    private static File bLF = null;

    /* loaded from: classes15.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File VH() {
        if (bLF == null) {
            bLF = new File(com.baidu.minivideo.arface.a.aK(mAppContext));
        }
        return bLF;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        if (isDebug()) {
            d("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
        }
        bLB = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bLE = aVar;
        if (!c.bLK) {
            bLC = com.baidu.minivideo.arface.utils.d.VV();
        } else {
            com.baidu.minivideo.arface.utils.a aM = com.baidu.minivideo.arface.utils.a.aM(context);
            VI();
            aM.a("file:///android_asset/arsource/", new File(c.VO()), false);
            bLC = aM;
        }
        bLC.start(aL(context));
    }

    private static f.a aL(Context context) {
        if (bLD != null) {
            return bLD;
        }
        bLD = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bLC == fVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.VI();
                        b.d(append.append(c.VO()).toString());
                    }
                    if (i == 2) {
                        if (b.bLE != null) {
                            b.bLE.onResult(true, b.E(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bLE = null;
                        }
                    } else if (i == 3 && b.bLE != null) {
                        b.bLE.onResult(false, b.E(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bLE = null;
                    }
                }
            }
        };
        return bLD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String E(String str, boolean z) {
        VI();
        File file = new File(c.VQ());
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

    public static c VI() {
        return bLB;
    }

    public static int getVersion() {
        return com.baidu.minivideo.arface.a.getVersion();
    }

    public static String getVersionName() {
        return com.baidu.minivideo.arface.a.getVersionName();
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bLB;
        String VP = c.VP();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + VP);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(VP);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bLG != null && bLG.length() > 0) {
            defaultParams.setGradingConfig(bLG);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + bLG.toString());
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
                bLG = jSONObject;
            }
        }
    }

    public static synchronized void ag(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                bLH = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b VJ() {
        com.baidu.minivideo.arface.bean.b ah;
        synchronized (b.class) {
            ah = (bLH == null || bLH.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ah(bLH);
        }
        return ah;
    }

    public static synchronized JSONObject VK() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bLH;
        }
        return jSONObject;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
