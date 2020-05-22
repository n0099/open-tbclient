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
    private static c bqC;
    private static com.baidu.minivideo.arface.utils.c bqD;
    private static f.a bqE;
    private static a bqF;
    private static Context mAppContext;
    public static final String bqz = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bqA = bqz + "/dataAR";
    public static final String bqB = bqA + "/dlModels/";
    private static File bqG = null;

    /* loaded from: classes3.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File LP() {
        if (bqG == null) {
            bqG = new File(com.baidu.minivideo.arface.a.aA(mAppContext));
        }
        return bqG;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bqC = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bqF = aVar;
        if (!c.bqJ) {
            bqD = com.baidu.minivideo.arface.utils.d.Mb();
        } else {
            com.baidu.minivideo.arface.utils.a aC = com.baidu.minivideo.arface.utils.a.aC(context);
            LQ();
            aC.a("file:///android_asset/arsource/", new File(c.LU()), false);
            bqD = aC;
        }
        bqD.a(aB(context));
    }

    private static f.a aB(Context context) {
        if (bqE != null) {
            return bqE;
        }
        bqE = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bqD == fVar) {
                    if (i == 2) {
                        if (b.bqF != null) {
                            b.bqF.onResult(true, b.u(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bqF = null;
                        }
                    } else if (i == 3 && b.bqF != null) {
                        b.bqF.onResult(false, b.u(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bqF = null;
                    }
                }
            }
        };
        return bqE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(String str, boolean z) {
        LQ();
        File file = new File(c.LW());
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

    public static c LQ() {
        return bqC;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bqC;
        String LV = c.LV();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(LV);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        return defaultParams;
    }
}
