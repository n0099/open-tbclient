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
    private static c bjc;
    private static com.baidu.minivideo.arface.utils.c bjd;
    private static f.a bje;
    private static a bjf;
    private static Context mAppContext;
    public static final String biZ = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bja = biZ + "/dataAR";
    public static final String bjb = bja + "/dlModels/";
    private static File bjg = null;

    /* loaded from: classes3.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File JX() {
        if (bjg == null) {
            bjg = new File(com.baidu.minivideo.arface.a.aC(mAppContext));
        }
        return bjg;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bjc = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bjf = aVar;
        if (!c.bjj) {
            bjd = com.baidu.minivideo.arface.utils.d.Kj();
        } else {
            com.baidu.minivideo.arface.utils.a aE = com.baidu.minivideo.arface.utils.a.aE(context);
            JY();
            aE.a("file:///android_asset/arsource/", new File(c.Kc()), false);
            bjd = aE;
        }
        bjd.a(aD(context));
    }

    private static f.a aD(Context context) {
        if (bje != null) {
            return bje;
        }
        bje = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bjd == fVar) {
                    if (i == 2) {
                        if (b.bjf != null) {
                            b.bjf.onResult(true, b.q(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bjf = null;
                        }
                    } else if (i == 3 && b.bjf != null) {
                        b.bjf.onResult(false, b.q(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bjf = null;
                    }
                }
            }
        };
        return bje;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(String str, boolean z) {
        JY();
        File file = new File(c.Ke());
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

    public static c JY() {
        return bjc;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bjc;
        String Kd = c.Kd();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Kd);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        return defaultParams;
    }
}
