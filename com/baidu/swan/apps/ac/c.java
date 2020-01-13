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
/* loaded from: classes10.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.d Wl() {
        com.baidu.swan.apps.core.d.e El;
        SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
        if (Un != null && (El = Un.El()) != null) {
            com.baidu.swan.apps.core.d.b LX = El.LX();
            if (LX instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) LX;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.runtime.config.c Lt = dVar.Lt();
            if (Lt != null) {
                return Lt.backgroundColor;
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
    public static JSONObject Wm() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aap() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aap().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.w.a.RS().bp(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.gj(com.baidu.swan.apps.runtime.d.aam().Ed()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fk(@StringRes int i) {
        String aar = com.baidu.swan.apps.runtime.e.aar();
        Context Un = com.baidu.swan.apps.y.f.UC().Un();
        if (Un == null) {
            Un = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aar)) {
            if (aar.lastIndexOf("_dev") > 0 || aar.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.q(Un, i).fR(5).fN(3).showToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Wn() {
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El != null && El.LX() != null) {
            m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.ac.c.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap aeH = af.aeH();
                    s RP = com.baidu.swan.apps.w.a.RP();
                    File acu = com.baidu.swan.apps.an.a.acr().acu();
                    final File ab = com.baidu.swan.apps.w.a.Sp().ab(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aar());
                    File[] fileArr = {acu, ab};
                    if (RP != null) {
                        RP.a(aeH, (HashMap<String, String>) null, fileArr, new s.a() { // from class: com.baidu.swan.apps.ac.c.1.1
                            @Override // com.baidu.swan.apps.adaptation.a.s.a
                            public void onResult(String str) {
                                if (str != null && str.contains("success")) {
                                    com.baidu.swan.apps.an.a.acr().acv();
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
    public static boolean Wo() {
        return com.baidu.swan.apps.y.f.UC().Un().Eg().aae();
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.d dVar, View view) {
        if (bitmap == null || dVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar Ln = dVar.Ln();
        if (Ln != null) {
            int[] iArr2 = new int[2];
            Ln.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + Ln.getHeight() + 1);
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return null;
    }
}
