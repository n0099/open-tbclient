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
    private static c bTY;
    private static com.baidu.minivideo.arface.utils.c bTZ;
    private static f.a bUa;
    private static a bUb;
    private static JSONObject bUd;
    private static JSONObject bUe;
    private static Context mAppContext;
    private static boolean sDebug;
    public static final String bTV = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bTW = bTV + "/dataAR";
    public static final String bTX = bTW + "/dlModels/";
    private static File bUc = null;

    /* loaded from: classes15.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File XB() {
        if (bUc == null) {
            bUc = new File(com.baidu.minivideo.arface.a.aK(mAppContext));
        }
        return bUc;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        if (isDebug()) {
            d("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
        }
        bTY = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bUb = aVar;
        if (!c.bUh) {
            bTZ = com.baidu.minivideo.arface.utils.d.XP();
        } else {
            com.baidu.minivideo.arface.utils.a aM = com.baidu.minivideo.arface.utils.a.aM(context);
            XC();
            aM.a("file:///android_asset/arsource/", new File(c.XI()), false);
            bTZ = aM;
        }
        bTZ.start(aL(context));
    }

    private static f.a aL(Context context) {
        if (bUa != null) {
            return bUa;
        }
        bUa = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bTZ == fVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.XC();
                        b.d(append.append(c.XI()).toString());
                    }
                    if (i == 2) {
                        if (b.bUb != null) {
                            b.bUb.onResult(true, b.G(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bUb = null;
                        }
                    } else if (i == 3 && b.bUb != null) {
                        b.bUb.onResult(false, b.G(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bUb = null;
                    }
                }
            }
        };
        return bUa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String G(String str, boolean z) {
        XC();
        File file = new File(c.XK());
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

    public static c XC() {
        return bTY;
    }

    public static int getVersion() {
        return com.baidu.minivideo.arface.a.getVersion();
    }

    public static String getVersionName() {
        return com.baidu.minivideo.arface.a.getVersionName();
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bTY;
        String XJ = c.XJ();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + XJ);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(XJ);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bUd != null && bUd.length() > 0) {
            defaultParams.setGradingConfig(bUd);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + bUd.toString());
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
                bUd = jSONObject;
            }
        }
    }

    public static synchronized void aj(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                bUe = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b XD() {
        com.baidu.minivideo.arface.bean.b ak;
        synchronized (b.class) {
            ak = (bUe == null || bUe.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ak(bUe);
        }
        return ak;
    }

    public static synchronized JSONObject XE() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bUe;
        }
        return jSONObject;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
