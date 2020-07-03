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
    public static com.baidu.swan.apps.core.d.d ali() {
        com.baidu.swan.apps.core.d.e RN;
        SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
        if (aiL != null && (RN = aiL.RN()) != null) {
            com.baidu.swan.apps.core.d.b ZV = RN.ZV();
            if (ZV instanceof com.baidu.swan.apps.core.d.d) {
                return (com.baidu.swan.apps.core.d.d) ZV;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar != null) {
            com.baidu.swan.apps.runtime.config.c Zn = dVar.Zn();
            if (Zn != null) {
                return Zn.backgroundColor;
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
    public static JSONObject alj() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.apM() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.apM().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.u.a.agj().bf(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.ho(com.baidu.swan.apps.runtime.d.apI().RF()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gj(@StringRes int i) {
        String apO = com.baidu.swan.apps.runtime.e.apO();
        Context aiL = com.baidu.swan.apps.w.f.ajb().aiL();
        if (aiL == null) {
            aiL = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(apO)) {
            if (apO.lastIndexOf("_dev") > 0 || apO.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.k(aiL, i).gT(5).gP(3).showToast();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void alk() {
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN != null && RN.ZV() != null) {
            n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.aa.c.1
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap auN = ag.auN();
                    u agg = com.baidu.swan.apps.u.a.agg();
                    com.baidu.swan.apps.al.a.arZ().asd();
                    File[] ash = com.baidu.swan.apps.al.a.arZ().asf().ash();
                    File K = com.baidu.swan.apps.u.a.agF().K(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.apO());
                    if (ash != null) {
                        int length = ash.length;
                        fileArr = (File[]) Arrays.copyOf(ash, length + 1);
                        fileArr[length] = K;
                    } else {
                        fileArr = new File[]{K};
                    }
                    if (agg != null) {
                        agg.a(auN, (HashMap<String, String>) null, fileArr, new u.a() { // from class: com.baidu.swan.apps.aa.c.1.1
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
    public static boolean all() {
        return com.baidu.swan.apps.w.f.ajb().aiL().RI().apz();
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.d dVar, View view) {
        if (bitmap == null || dVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar Zg = dVar.Zg();
        if (Zg != null) {
            int[] iArr2 = new int[2];
            Zg.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + Zg.getHeight() + 1);
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return null;
    }
}
