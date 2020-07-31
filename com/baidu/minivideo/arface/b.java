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
    private static c bvQ;
    private static com.baidu.minivideo.arface.utils.c bvR;
    private static f.a bvS;
    private static a bvT;
    private static JSONObject bvV;
    private static JSONObject bvW;
    private static Context mAppContext;
    public static final String bvN = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bvO = bvN + "/dataAR";
    public static final String bvP = bvO + "/dlModels/";
    private static File bvU = null;

    /* loaded from: classes6.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File Nd() {
        if (bvU == null) {
            bvU = new File(com.baidu.minivideo.arface.a.aB(mAppContext));
        }
        return bvU;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bvQ = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bvT = aVar;
        if (!c.bvZ) {
            bvR = com.baidu.minivideo.arface.utils.d.Nr();
        } else {
            com.baidu.minivideo.arface.utils.a aD = com.baidu.minivideo.arface.utils.a.aD(context);
            Ne();
            aD.a("file:///android_asset/arsource/", new File(c.Nk()), false);
            bvR = aD;
        }
        bvR.a(aC(context));
    }

    private static f.a aC(Context context) {
        if (bvS != null) {
            return bvS;
        }
        bvS = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bvR == fVar) {
                    if (i == 2) {
                        if (b.bvT != null) {
                            b.bvT.onResult(true, b.w(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bvT = null;
                        }
                    } else if (i == 3 && b.bvT != null) {
                        b.bvT.onResult(false, b.w(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bvT = null;
                    }
                }
            }
        };
        return bvS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(String str, boolean z) {
        Ne();
        File file = new File(c.Nm());
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

    public static c Ne() {
        return bvQ;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bvQ;
        String Nl = c.Nl();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Nl);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bvV != null && bvV.length() > 0) {
            defaultParams.setGradingConfig(bvV);
        }
        return defaultParams;
    }

    public static synchronized void setGradingConfig(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bvV = jSONObject;
                }
            }
        }
    }

    public static synchronized void Y(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bvW = jSONObject;
                }
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b Nf() {
        com.baidu.minivideo.arface.bean.b Z;
        synchronized (b.class) {
            Z = (bvW == null || bvW.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.Z(bvW);
        }
        return Z;
    }

    public static synchronized JSONObject Ng() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bvW;
        }
        return jSONObject;
    }
}
