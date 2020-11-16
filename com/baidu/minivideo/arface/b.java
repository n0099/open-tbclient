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
/* loaded from: classes14.dex */
public final class b {
    private static c bXX;
    private static com.baidu.minivideo.arface.utils.c bXY;
    private static f.a bXZ;
    private static a bYa;
    private static JSONObject bYc;
    private static JSONObject bYd;
    private static Context mAppContext;
    private static boolean sDebug;
    public static final String bXU = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bXV = bXU + "/dataAR";
    public static final String bXW = bXV + "/dlModels/";
    private static File bYb = null;

    /* loaded from: classes14.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File Zr() {
        if (bYb == null) {
            bYb = new File(com.baidu.minivideo.arface.a.aK(mAppContext));
        }
        return bYb;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        if (isDebug()) {
            d("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
        }
        bXX = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bYa = aVar;
        if (!c.bYg) {
            bXY = com.baidu.minivideo.arface.utils.d.ZF();
        } else {
            com.baidu.minivideo.arface.utils.a aM = com.baidu.minivideo.arface.utils.a.aM(context);
            Zs();
            aM.a("file:///android_asset/arsource/", new File(c.Zy()), false);
            bXY = aM;
        }
        bXY.start(aL(context));
    }

    private static f.a aL(Context context) {
        if (bXZ != null) {
            return bXZ;
        }
        bXZ = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bXY == fVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.Zs();
                        b.d(append.append(c.Zy()).toString());
                    }
                    if (i == 2) {
                        if (b.bYa != null) {
                            b.bYa.onResult(true, b.G(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bYa = null;
                        }
                    } else if (i == 3 && b.bYa != null) {
                        b.bYa.onResult(false, b.G(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bYa = null;
                    }
                }
            }
        };
        return bXZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String G(String str, boolean z) {
        Zs();
        File file = new File(c.ZA());
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

    public static c Zs() {
        return bXX;
    }

    public static int getVersion() {
        return com.baidu.minivideo.arface.a.getVersion();
    }

    public static String getVersionName() {
        return com.baidu.minivideo.arface.a.getVersionName();
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bXX;
        String Zz = c.Zz();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + Zz);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Zz);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bYc != null && bYc.length() > 0) {
            defaultParams.setGradingConfig(bYc);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + bYc.toString());
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
                bYc = jSONObject;
            }
        }
    }

    public static synchronized void aj(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                bYd = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b Zt() {
        com.baidu.minivideo.arface.bean.b ak;
        synchronized (b.class) {
            ak = (bYd == null || bYd.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ak(bYd);
        }
        return ak;
    }

    public static synchronized JSONObject Zu() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bYd;
        }
        return jSONObject;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
