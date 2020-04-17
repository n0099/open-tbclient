package com.baidu.swan.apps.ac;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.adaptation.a.s;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.SwanAppActionBar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.d agK() {
        com.baidu.swan.apps.core.d.e Ou;
        SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
        if (aev != null && (Ou = aev.Ou()) != null) {
            com.baidu.swan.apps.core.d.b We = Ou.We();
            if (We instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) We;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.runtime.config.c VA = dVar.VA();
            if (VA != null) {
                return VA.backgroundColor;
            }
            FrameLayout webViewContainer = dVar.getWebViewContainer();
            if (webViewContainer != null) {
                Drawable background = webViewContainer.getBackground();
                if (background instanceof ColorDrawable) {
                    return ((ColorDrawable) background).getColor();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String l(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject agL() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.akN() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.akN().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.w.a.aca().bg(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.gH(com.baidu.swan.apps.runtime.d.akK().Om()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fH(@StringRes int i) {
        String akP = com.baidu.swan.apps.runtime.e.akP();
        Context aev = com.baidu.swan.apps.y.f.aeK().aev();
        if (aev == null) {
            aev = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(akP)) {
            if (akP.lastIndexOf("_dev") > 0 || akP.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.k(aev, i).gp(5).gk(3).showToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void agM() {
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou != null && Ou.We() != null) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.ac.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap aph = af.aph();
                    s abX = com.baidu.swan.apps.w.a.abX();
                    File amS = com.baidu.swan.apps.an.a.amP().amS();
                    final File V = com.baidu.swan.apps.w.a.acx().V(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.akP());
                    File[] fileArr = {amS, V};
                    if (abX != null) {
                        abX.a(aph, (HashMap<String, String>) null, fileArr, new s.a() { // from class: com.baidu.swan.apps.ac.c.1.1
                            @Override // com.baidu.swan.apps.adaptation.a.s.a
                            public void onResult(String str) {
                                if (str != null && str.contains("success")) {
                                    com.baidu.swan.apps.an.a.amP().amT();
                                    com.baidu.swan.d.c.safeDeleteFile(V);
                                }
                            }
                        });
                    }
                }
            }, "feedback error page");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean agN() {
        return com.baidu.swan.apps.y.f.aeK().aev().Op().akC();
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.d dVar, View view) {
        if (bitmap == null || dVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar Vt = dVar.Vt();
        if (Vt != null) {
            int[] iArr2 = new int[2];
            Vt.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + Vt.getHeight() + 1);
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return null;
    }
}
