package com.baidu.swan.apps.z;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.u;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.view.SwanAppActionBar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final boolean cwc = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_white_screent_webview_progress_bar_switch", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.e amz() {
        com.baidu.swan.apps.core.d.f Sc;
        SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
        if (akb != null && (Sc = akb.Sc()) != null) {
            com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
            if (aaZ instanceof com.baidu.swan.apps.core.d.e) {
                return (com.baidu.swan.apps.core.d.e) aaZ;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar != null) {
            com.baidu.swan.apps.runtime.config.c aar = eVar.aar();
            if (aar != null) {
                return aar.backgroundColor;
            }
            FrameLayout webViewContainer = eVar.getWebViewContainer();
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
    public static String o(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject amA() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.arv() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.arv().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.t.a.ahv().bh(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.hx(com.baidu.swan.apps.runtime.d.arr().RU()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void eF(boolean z) {
        String arx = com.baidu.swan.apps.runtime.e.arx();
        Context akb = com.baidu.swan.apps.v.f.akr().akb();
        if (akb == null) {
            akb = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(arx)) {
            if (arx.lastIndexOf("_dev") > 0 || arx.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.k(akb, a.h.aiapps_swan_app_error_page_hint).hc(5).gY(3).showToast();
            } else if (z) {
                com.baidu.swan.apps.core.b.showToast(a.h.swanapp_tip_load_fail);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void amB() {
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null && Sc.aaZ() != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.z.c.1
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap awT = ai.awT();
                    u ahs = com.baidu.swan.apps.t.a.ahs();
                    com.baidu.swan.apps.al.a.atW().aua();
                    File[] aue = com.baidu.swan.apps.al.a.atW().auc().aue();
                    File K = com.baidu.swan.apps.t.a.ahS().K(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.arx());
                    if (aue != null) {
                        int length = aue.length;
                        fileArr = (File[]) Arrays.copyOf(aue, length + 1);
                        fileArr[length] = K;
                    } else {
                        fileArr = new File[]{K};
                    }
                    if (ahs != null) {
                        ahs.a(awT, (HashMap<String, String>) null, fileArr, new u.a() { // from class: com.baidu.swan.apps.z.c.1.1
                            @Override // com.baidu.swan.apps.adaptation.a.u.a
                            public void onResult(String str) {
                                if (str != null && str.contains("success")) {
                                    for (File file : fileArr) {
                                        com.baidu.swan.d.d.safeDeleteFile(file);
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
    public static boolean amC() {
        return com.baidu.swan.apps.v.f.akr().akb().RX().ari();
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar aak = eVar.aak();
        if (aak != null) {
            int[] iArr2 = new int[2];
            aak.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + aak.getHeight() + 1);
            if (cwc) {
                if (DEBUG) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                com.baidu.swan.apps.adaptation.b.c aaQ = eVar.aaQ();
                if (aaQ != null) {
                    com.baidu.swan.apps.adaptation.b.f UI = aaQ.UI();
                    if (UI instanceof SwanAppWebViewWidget) {
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int adl = ((SwanAppWebViewWidget) UI).adl();
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + adl);
                        }
                        if (adl > 0) {
                            iArr[1] = adl + iArr[1] + 1;
                        }
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget newY=" + iArr[1]);
                        }
                    }
                }
            }
            return new Rect(iArr[0], iArr[1], min, min2);
        }
        return null;
    }
}
