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
/* loaded from: classes11.dex */
public final class b {
    private static c bEZ;
    private static com.baidu.minivideo.arface.utils.c bFa;
    private static f.a bFb;
    private static a bFc;
    private static JSONObject bFe;
    private static JSONObject bFf;
    private static Context mAppContext;
    public static final String bEW = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bEX = bEW + "/dataAR";
    public static final String bEY = bEX + "/dlModels/";
    private static File bFd = null;

    /* loaded from: classes11.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File TO() {
        if (bFd == null) {
            bFd = new File(com.baidu.minivideo.arface.a.aG(mAppContext));
        }
        return bFd;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bEZ = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bFc = aVar;
        if (!c.bFi) {
            bFa = com.baidu.minivideo.arface.utils.d.Uc();
        } else {
            com.baidu.minivideo.arface.utils.a aI = com.baidu.minivideo.arface.utils.a.aI(context);
            TP();
            aI.a("file:///android_asset/arsource/", new File(c.TV()), false);
            bFa = aI;
        }
        bFa.a(aH(context));
    }

    private static f.a aH(Context context) {
        if (bFb != null) {
            return bFb;
        }
        bFb = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bFa == fVar) {
                    if (i == 2) {
                        if (b.bFc != null) {
                            b.bFc.onResult(true, b.B(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bFc = null;
                        }
                    } else if (i == 3 && b.bFc != null) {
                        b.bFc.onResult(false, b.B(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bFc = null;
                    }
                }
            }
        };
        return bFb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String B(String str, boolean z) {
        TP();
        File file = new File(c.TX());
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

    public static c TP() {
        return bEZ;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bEZ;
        String TW = c.TW();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(TW);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (bFe != null && bFe.length() > 0) {
            defaultParams.setGradingConfig(bFe);
        }
        return defaultParams;
    }

    public static synchronized void setGradingConfig(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bFe = jSONObject;
                }
            }
        }
    }

    public static synchronized void ad(JSONObject jSONObject) {
        synchronized (b.class) {
            if (jSONObject != null) {
                if (jSONObject.length() != 0) {
                    bFf = jSONObject;
                }
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b TQ() {
        com.baidu.minivideo.arface.bean.b ae;
        synchronized (b.class) {
            ae = (bFf == null || bFf.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.ae(bFf);
        }
        return ae;
    }

    public static synchronized JSONObject TR() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = bFf;
        }
        return jSONObject;
    }
}
