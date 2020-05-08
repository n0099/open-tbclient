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
    private static c bjh;
    private static com.baidu.minivideo.arface.utils.c bji;
    private static f.a bjj;
    private static a bjk;
    private static Context mAppContext;
    public static final String bje = Environment.getExternalStorageDirectory() + "/baidu/quanminvideo";
    public static final String bjf = bje + "/dataAR";
    public static final String bjg = bjf + "/dlModels/";
    private static File bjl = null;

    /* loaded from: classes3.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static File JW() {
        if (bjl == null) {
            bjl = new File(com.baidu.minivideo.arface.a.aq(mAppContext));
        }
        return bjl;
    }

    public static void a(Context context, String str, String str2, String str3, c cVar) {
        bjh = cVar;
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
    }

    public static void a(Context context, a aVar) {
        bjk = aVar;
        if (!c.bjo) {
            bji = com.baidu.minivideo.arface.utils.d.Ki();
        } else {
            com.baidu.minivideo.arface.utils.a as = com.baidu.minivideo.arface.utils.a.as(context);
            JX();
            as.a("file:///android_asset/arsource/", new File(c.Kb()), false);
            bji = as;
        }
        bji.a(ar(context));
    }

    private static f.a ar(Context context) {
        if (bjj != null) {
            return bjj;
        }
        bjj = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.bji == fVar) {
                    if (i == 2) {
                        if (b.bjk != null) {
                            b.bjk.onResult(true, b.q(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.bjk = null;
                        }
                    } else if (i == 3 && b.bjk != null) {
                        b.bjk.onResult(false, b.q(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.bjk = null;
                    }
                }
            }
        };
        return bjj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(String str, boolean z) {
        JX();
        File file = new File(c.Kd());
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

    public static c JX() {
        return bjh;
    }

    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = bjh;
        String Kc = c.Kc();
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(Kc);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        return defaultParams;
    }
}
