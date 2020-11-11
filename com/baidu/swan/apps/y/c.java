package com.baidu.swan.apps.y;

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
import com.baidu.swan.apps.adaptation.a.w;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final boolean dgw = com.baidu.swan.apps.t.a.awD().getSwitch("swan_white_screent_webview_progress_bar_switch", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.e aCj() {
        com.baidu.swan.apps.core.d.f afM;
        SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
        if (azy != null && (afM = azy.afM()) != null) {
            com.baidu.swan.apps.core.d.c apb = afM.apb();
            if (apb instanceof com.baidu.swan.apps.core.d.e) {
                return (com.baidu.swan.apps.core.d.e) apb;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar != null) {
            com.baidu.swan.apps.runtime.config.c aoq = eVar.aoq();
            if (aoq != null) {
                return aoq.backgroundColor;
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
    public static JSONObject aCk() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aHu() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aHu().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.t.a.awM().bs(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.kH(com.baidu.swan.apps.runtime.d.aHq().afE()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fN(boolean z) {
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        Context azy = com.baidu.swan.apps.v.f.azO().azy();
        if (azy == null) {
            azy = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aHw)) {
            if (aHw.lastIndexOf("_dev") > 0 || aHw.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.k(azy, a.h.aiapps_swan_app_error_page_hint).km(5).ki(3).showToast();
            } else if (z) {
                cc("whiteScreen_L1", "检测到纯白屏");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cc(final String str, final String str2) {
        com.baidu.swan.apps.core.f.a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：正常");
                        com.baidu.swan.apps.core.d.F("white_screen", str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                    case 2:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：较差");
                        com.baidu.swan.apps.core.d.F("white_screen", str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：离线");
                        com.baidu.swan.apps.core.d.F("white_screen", str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：未知");
                        com.baidu.swan.apps.core.d.F("white_screen", str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aCl() {
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null && afM.apb() != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap aMP = ah.aMP();
                    w awJ = com.baidu.swan.apps.t.a.awJ();
                    com.baidu.swan.apps.ak.a.aJS().aJW();
                    File[] aKa = com.baidu.swan.apps.ak.a.aJS().aJY().aKa();
                    File U = com.baidu.swan.apps.t.a.axk().U(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aHw());
                    if (aKa != null) {
                        int length = aKa.length;
                        fileArr = (File[]) Arrays.copyOf(aKa, length + 1);
                        fileArr[length] = U;
                    } else {
                        fileArr = new File[]{U};
                    }
                    if (awJ != null) {
                        awJ.a(aMP, (HashMap<String, String>) null, fileArr, new w.a() { // from class: com.baidu.swan.apps.y.c.2.1
                            @Override // com.baidu.swan.apps.adaptation.a.w.a
                            public void onResult(String str) {
                                if (str != null && str.contains("success")) {
                                    for (File file : fileArr) {
                                        com.baidu.swan.c.d.safeDeleteFile(file);
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
    public static boolean aCm() {
        return com.baidu.swan.apps.v.f.azO().azy().afH().aHh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean afU() {
        SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
        if (azy == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a afH = azy.afH();
        if (afH == null || !(afH.getView() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) afH.getView()).getChildAt(0) instanceof LoadingView;
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar aoj = eVar.aoj();
        if (aoj != null) {
            int[] iArr2 = new int[2];
            aoj.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + aoj.getHeight() + 1);
            if (dgw) {
                if (DEBUG) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                com.baidu.swan.apps.adaptation.b.c aoQ = eVar.aoQ();
                if (aoQ != null) {
                    com.baidu.swan.apps.adaptation.b.f aiA = aoQ.aiA();
                    if (aiA instanceof SwanAppWebViewWidget) {
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int arw = ((SwanAppWebViewWidget) aiA).arw();
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + arw);
                        }
                        if (arw > 0) {
                            iArr[1] = arw + iArr[1] + 1;
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
