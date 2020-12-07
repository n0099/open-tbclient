package com.baidu.minivideo.arface;

import android.content.Context;
import android.opengl.EGLContext;
import android.util.Log;
import com.baidu.ar.DefaultParams;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.minivideo.arface.b.g;
import com.baidu.minivideo.arface.utils.f;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    private static JSONObject cdB;
    private static JSONObject cdC;
    private static c cdv;
    private static com.baidu.minivideo.arface.a.a cdw;
    private static com.baidu.minivideo.arface.utils.c cdx;
    private static f.a cdy;
    private static a cdz;
    private static Context mAppContext;
    private static boolean sDebug;
    private static File cdA = null;
    private static boolean cdD = true;
    private static String cdE = "live";

    /* loaded from: classes8.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public static void d(Context context, String str, String str2, String str3) {
        a(context, str, str2, str3, null);
    }

    @Deprecated
    public static void a(Context context, String str, String str2, String str3, c cVar) {
        if (isDebug()) {
            d("sdk init with appId:" + str + ", apikey:" + str2 + ", secretKey:" + str3);
        }
        mAppContext = context.getApplicationContext();
        DuMixARConfig.setAppId(str);
        DuMixARConfig.setAPIKey(str2);
        DuMixARConfig.setSecretKey(str3);
        com.baidu.minivideo.arface.b.e.acv().init(mAppContext);
        a(cVar);
    }

    public static void a(e eVar) {
        com.baidu.minivideo.arface.c.a.b(eVar);
    }

    public static File abX() {
        if (cdA == null) {
            cdA = new File(com.baidu.minivideo.arface.a.bo(mAppContext));
        }
        return cdA;
    }

    public static void a(com.baidu.minivideo.arface.a.a aVar) {
        cdw = aVar;
    }

    @Deprecated
    public static void a(Context context, a aVar) {
        cdz = aVar;
        if (!c.cdH) {
            cdx = com.baidu.minivideo.arface.utils.d.acN();
        } else {
            com.baidu.minivideo.arface.utils.a bs = com.baidu.minivideo.arface.utils.a.bs(context);
            abY();
            bs.a("file:///android_asset/arsource/", new File(c.ach()), false);
            cdx = bs;
        }
        cdx.a(bp(context));
    }

    private static f.a bp(Context context) {
        if (cdy != null) {
            return cdy;
        }
        cdy = new f.a() { // from class: com.baidu.minivideo.arface.b.1
            @Override // com.baidu.minivideo.arface.utils.f.a
            public void a(int i, f fVar) {
                if (b.cdx == fVar) {
                    if (b.isDebug()) {
                        StringBuilder append = new StringBuilder().append(i).append(" loadFaceAssets with: ").append(i == 2).append(", (");
                        b.abY();
                        b.d(append.append(c.ach()).toString());
                    }
                    if (i == 2) {
                        if (b.cdz != null) {
                            b.cdz.onResult(true, b.H(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", true));
                            a unused = b.cdz = null;
                        }
                    } else if (i == 3 && b.cdz != null) {
                        b.cdz.onResult(false, b.H(fVar instanceof com.baidu.minivideo.arface.utils.d ? "soloaderChecker" : "assetsCopy", false));
                        a unused2 = b.cdz = null;
                    }
                }
            }
        };
        return cdy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String H(String str, boolean z) {
        abY();
        File file = new File(c.acj());
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

    public static c abY() {
        return cdv;
    }

    public static void a(c cVar) {
        File acC;
        cdv = cVar;
        if (cdv == null && (acC = g.acA().acC()) != null) {
            cdv = new c(acC.getAbsolutePath());
        }
    }

    public static boolean abZ() {
        return cdD;
    }

    public static String aca() {
        return cdE;
    }

    public static int getVersion() {
        return com.baidu.minivideo.arface.a.getVersion();
    }

    public static Context getContext() {
        return mAppContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DefaultParams b(EGLContext eGLContext) {
        c cVar = cdv;
        String aci = c.aci();
        if (isDebug()) {
            d("getDuMixDefaultParams EGLContext: " + eGLContext + ", modelPath: " + aci);
        }
        DefaultParams defaultParams = new DefaultParams();
        defaultParams.setFaceAlgoModelPath(aci);
        if (eGLContext != null) {
            defaultParams.setUseTextureIO(true);
            defaultParams.setShareContext(eGLContext);
        }
        if (cdB != null && cdB.length() > 0) {
            defaultParams.setGradingConfig(cdB);
            if (isDebug()) {
                d("getDuMixDefaultParams  " + cdB.toString());
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
                cdB = jSONObject;
            }
        }
    }

    public static synchronized void al(JSONObject jSONObject) {
        synchronized (b.class) {
            if (isDebug()) {
                d("sdk setQualityConfig:" + jSONObject);
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                cdC = jSONObject;
            }
        }
    }

    public static synchronized com.baidu.minivideo.arface.bean.b acb() {
        com.baidu.minivideo.arface.bean.b am;
        synchronized (b.class) {
            am = (cdC == null || cdC.length() <= 0) ? null : com.baidu.minivideo.arface.bean.b.am(cdC);
        }
        return am;
    }

    public static synchronized JSONObject acc() {
        JSONObject jSONObject;
        synchronized (b.class) {
            jSONObject = cdC;
        }
        return jSONObject;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static boolean isDebug() {
        return sDebug;
    }
}
