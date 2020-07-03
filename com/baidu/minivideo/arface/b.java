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
/* loaded from: classes3.dex */
public final class b {
    private static c bvB;
    private static com.baidu.minivideo.arface.utils.c bvC;
    private static f.a bvD;
    private static a bvE;
    private static JSONObject bvG;
    private static JSONObject bvH;
    private static Context mAppContext;
    public static final String bvy = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bvz = bvy + "/dataAR";
    public static final String bvA = bvz + "/dlModels/";
    private static File bvF = null;

    /* loaded from: classes3.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File MY() {
        if (bvF == null) {
            bvF = new File(com.baidu.minivideo.arface.a.aB(mAppContext));
        }
        return bvF;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bvB = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bvE = aVar;
        if (!c.bvK) {
            bvC = com.baidu.minivideo.arface.utils.d.Nm();
        } else {
            com.baidu.minivideo.arface.utils.a aD = com.baidu.minivideo.arface.utils.a.aD(context);
            MZ();
            aD.a("file:///android_asset/arsource/", new File(c.Nf()), false);
            bvC = aD;
        }
        bvC.a(aC(context));
    }

    private static f.a aC(Context context) {
        if (bvD != null) {
            return bvD;
        }
        bvD = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bvC == fVar) {
                    if (i == 2) {
                        if (b.bvE != null) {
                            b.bvE.onResult(true, b.w(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bvE = null;
                        }
                    } else if (i == 3 && b.bvE != null) {
                        b.bvE.onResult(false, b.w(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bvE = null;
                    }
                }
            }
        };
        return bvD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(String str, boolean z) {
        MZ();
        File file = new File(c.Nh());
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

    public static c MZ() {
        return bvB;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bvB;
        String Ng = c.Ng();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Ng);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bvG != null && bvG.length() > 0) {
            defaultParams.setGradingConfig(bvG);
        }
        return defaultParams;
    }

    public static synchronized void setGradingConfig(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bvG = jSONObject;
                }
            }
        }
    }

    public static synchronized void Y(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bvH = jSONObject;
                }
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b Na() {
        com.baidu.minivideo.arface.bean.b Z;
        synchronized (b.class) {
            Z = (bvH == null || bvH.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.Z(bvH);
        }
        return Z;
    }

    public static synchronized JSONObject Nb() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bvH;
        }
        return jSONObject;
    }
}
