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
    private static com.baidu.minivideo.arface.utils.c bBA;
    private static f.a bBB;
    private static a bBC;
    private static JSONObject bBE;
    private static JSONObject bBF;
    private static c bBz;
    private static Context mAppContext;
    public static final String bBw = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bBx = bBw + "/dataAR";
    public static final String bBy = bBx + "/dlModels/";
    private static File bBD = null;

    /* loaded from: classes6.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File SX() {
        if (bBD == null) {
            bBD = new File(com.baidu.minivideo.arface.a.aG(mAppContext));
        }
        return bBD;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bBz = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bBC = aVar;
        if (!c.bBI) {
            bBA = com.baidu.minivideo.arface.utils.d.Tl();
        } else {
            com.baidu.minivideo.arface.utils.a aI = com.baidu.minivideo.arface.utils.a.aI(context);
            SY();
            aI.a("file:///android_asset/arsource/", new File(c.Te()), false);
            bBA = aI;
        }
        bBA.a(aH(context));
    }

    private static f.a aH(Context context) {
        if (bBB != null) {
            return bBB;
        }
        bBB = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bBA == fVar) {
                    if (i == 2) {
                        if (b.bBC != null) {
                            b.bBC.onResult(true, b.B(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bBC = null;
                        }
                    } else if (i == 3 && b.bBC != null) {
                        b.bBC.onResult(false, b.B(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bBC = null;
                    }
                }
            }
        };
        return bBB;
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
        return bBz;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bBz;
        String Tf = c.Tf();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Tf);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bBE != null && bBE.length() > 0) {
            defaultParams.setGradingConfig(bBE);
        }
        return defaultParams;
    }

    public static synchronized void setGradingConfig(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bBE = jSONObject;
                }
            }
        }
    }

    public static synchronized void aa(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bBF = jSONObject;
                }
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b SZ() {
        com.baidu.minivideo.arface.bean.b ab;
        synchronized (b.class) {
            ab = (bBF == null || bBF.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ab(bBF);
        }
        return ab;
    }

    public static synchronized JSONObject Ta() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bBF;
        }
        return jSONObject;
    }
}
