package com.baidu.minivideo.arface;

import android.content.Context;
import android.opengl.EGLContext;
import android.os.Environment;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.minivideo.arface.utils.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class b {
    private static c bBC;
    private static com.baidu.minivideo.arface.utils.c bBD;
    private static f.a bBE;
    private static a bBF;
    private static JSONObject bBH;
    private static JSONObject bBI;
    private static Context mAppContext;
    public static final String bBz = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bBA = bBz + "/dataAR";
    public static final String bBB = bBA + "/dlModels/";
    private static File bBG = null;

    /* loaded from: classes6.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File SX() {
        if (bBG == null) {
            bBG = new File(com.baidu.minivideo.arface.a.aG(mAppContext));
        }
        return bBG;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bBC = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bBF = aVar;
        if (!c.bBL) {
            bBD = com.baidu.minivideo.arface.utils.d.Tl();
        } else {
            com.baidu.minivideo.arface.utils.a aI = com.baidu.minivideo.arface.utils.a.aI(context);
            SY();
            aI.a("file:///android_asset/arsource/", new File(c.Te()), false);
            bBD = aI;
        }
        bBD.a(aH(context));
    }

    private static f.a aH(Context context) {
        if (bBE != null) {
            return bBE;
        }
        bBE = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bBD == fVar) {
                    if (i == 2) {
                        if (b.bBF != null) {
                            b.bBF.onResult(true, b.B(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bBF = null;
                        }
                    } else if (i == 3 && b.bBF != null) {
                        b.bBF.onResult(false, b.B(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bBF = null;
                    }
                }
            }
        };
        return bBE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String B(String str, boolean z) {
        SY();
        File file = new File(c.Tg());
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

    public static c SY() {
        return bBC;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bBC;
        String Tf = c.Tf();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Tf);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bBH != null && bBH.length() > 0) {
            defaultParams.setGradingConfig(bBH);
        }
        return defaultParams;
    }

    public static synchronized void setGradingConfig(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bBH = jSONObject;
                }
            }
        }
    }

    public static synchronized void aa(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bBI = jSONObject;
                }
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b SZ() {
        com.baidu.minivideo.arface.bean.b ab;
        synchronized (b.class) {
            ab = (bBI == null || bBI.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ab(bBI);
        }
        return ab;
    }

    public static synchronized JSONObject Ta() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bBI;
        }
        return jSONObject;
    }
}
