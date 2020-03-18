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
    public static com.baidu.swan.apps.core.d.d YE() {
        com.baidu.swan.apps.core.d.e GH;
        SwanAppActivity WG = com.baidu.swan.apps.y.f.WV().WG();
        if (WG != null && (GH = WG.GH()) != null) {
            com.baidu.swan.apps.core.d.b Oq = GH.Oq();
            if (Oq instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) Oq;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.runtime.config.c NM = dVar.NM();
            if (NM != null) {
                return NM.backgroundColor;
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
    public static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject YF() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.acI() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.acI().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.w.a.Ul().bs(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.gA(com.baidu.swan.apps.runtime.d.acF().Gz()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fA(@StringRes int i) {
        String acK = com.baidu.swan.apps.runtime.e.acK();
        Context WG = com.baidu.swan.apps.y.f.WV().WG();
        if (WG == null) {
            WG = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(acK)) {
            if (acK.lastIndexOf("_dev") > 0 || acK.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.q(WG, i).gh(5).gd(3).showToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void YG() {
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH != null && GH.Oq() != null) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.ac.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap aha = af.aha();
                    s Ui = com.baidu.swan.apps.w.a.Ui();
                    File aeN = com.baidu.swan.apps.an.a.aeK().aeN();
                    final File ab = com.baidu.swan.apps.w.a.UI().ab(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.acK());
                    File[] fileArr = {aeN, ab};
                    if (Ui != null) {
                        Ui.a(aha, (HashMap<String, String>) null, fileArr, new s.a() { // from class: com.baidu.swan.apps.ac.c.1.1
                            @Override // com.baidu.swan.apps.adaptation.a.s.a
                            public void onResult(String str) {
                                if (str != null && str.contains("success")) {
                                    com.baidu.swan.apps.an.a.aeK().aeO();
                                    com.baidu.swan.d.c.safeDeleteFile(ab);
                                }
                            }
                        });
                    }
                }
            }, "feedback error page");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean YH() {
        return com.baidu.swan.apps.y.f.WV().WG().GC().acx();
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.d dVar, View view) {
        if (bitmap == null || dVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar NG = dVar.NG();
        if (NG != null) {
            int[] iArr2 = new int[2];
            NG.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + NG.getHeight() + 1);
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return null;
    }
}
