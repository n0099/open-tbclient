package com.baidu.swan.apps.aa;

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
import com.baidu.swan.apps.adaptation.a.u;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.SwanAppActionBar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.d akc() {
        com.baidu.swan.apps.core.d.e QH;
        SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
        if (ahF != null && (QH = ahF.QH()) != null) {
            com.baidu.swan.apps.core.d.b YP = QH.YP();
            if (YP instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) YP;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.runtime.config.c Yh = dVar.Yh();
            if (Yh != null) {
                return Yh.backgroundColor;
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
    public static JSONObject akd() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aoF() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aoF().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.afd().be(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.hd(com.baidu.swan.apps.runtime.d.aoB().Qz()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fY(@StringRes int i) {
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        Context ahF = com.baidu.swan.apps.w.f.ahV().ahF();
        if (ahF == null) {
            ahF = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aoH)) {
            if (aoH.lastIndexOf("_dev") > 0 || aoH.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.k(ahF, i).gI(5).gE(3).showToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ake() {
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH != null && QH.YP() != null) {
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.aa.c.1
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap atH = ag.atH();
                    u afa = com.baidu.swan.apps.u.a.afa();
                    com.baidu.swan.apps.al.a.aqT().aqX();
                    File[] arb = com.baidu.swan.apps.al.a.aqT().aqZ().arb();
                    File K = com.baidu.swan.apps.u.a.afz().K(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aoH());
                    if (arb != null) {
                        int length = arb.length;
                        fileArr = (File[]) Arrays.copyOf(arb, length + 1);
                        fileArr[length] = K;
                    } else {
                        fileArr = new File[]{K};
                    }
                    if (afa != null) {
                        afa.a(atH, (HashMap<String, String>) null, fileArr, new u.a() { // from class: com.baidu.swan.apps.aa.c.1.1
                            @Override // com.baidu.swan.apps.adaptation.a.u.a
                            public void onResult(String str) {
                                if (str != null && str.contains("success")) {
                                    for (File file : fileArr) {
                                        com.baidu.swan.e.d.safeDeleteFile(file);
                                    }
                                }
                            }
                        });
                    }
                }
            }, "feedback error page");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean akf() {
        return com.baidu.swan.apps.w.f.ahV().ahF().QC().aos();
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.d dVar, View view) {
        if (bitmap == null || dVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar Ya = dVar.Ya();
        if (Ya != null) {
            int[] iArr2 = new int[2];
            Ya.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + Ya.getHeight() + 1);
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return null;
    }
}
