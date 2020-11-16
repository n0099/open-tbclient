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
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final boolean deP = com.baidu.swan.apps.t.a.avV().getSwitch("swan_white_screent_webview_progress_bar_switch", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.e aBB() {
        com.baidu.swan.apps.core.d.f afe;
        SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
        if (ayQ != null && (afe = ayQ.afe()) != null) {
            com.baidu.swan.apps.core.d.c aot = afe.aot();
            if (aot instanceof com.baidu.swan.apps.core.d.e) {
                return (com.baidu.swan.apps.core.d.e) aot;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar != null) {
            com.baidu.swan.apps.runtime.config.c anI = eVar.anI();
            if (anI != null) {
                return anI.backgroundColor;
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
    public static JSONObject aBC() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aGM() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aGM().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.t.a.awe().bs(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.kD(com.baidu.swan.apps.runtime.d.aGI().aeW()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fQ(boolean z) {
        String aGO = com.baidu.swan.apps.runtime.e.aGO();
        Context ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
        if (ayQ == null) {
            ayQ = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aGO)) {
            if (aGO.lastIndexOf("_dev") > 0 || aGO.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.k(ayQ, a.h.aiapps_swan_app_error_page_hint).ki(5).ke(3).showToast();
            } else if (z) {
                cb("whiteScreen_L1", "检测到纯白屏");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cb(final String str, final String str2) {
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
    public static void aBD() {
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null && afe.aot() != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap aMh = ah.aMh();
                    w awb = com.baidu.swan.apps.t.a.awb();
                    com.baidu.swan.apps.ak.a.aJk().aJo();
                    File[] aJs = com.baidu.swan.apps.ak.a.aJk().aJq().aJs();
                    File R = com.baidu.swan.apps.t.a.awC().R(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aGO());
                    if (aJs != null) {
                        int length = aJs.length;
                        fileArr = (File[]) Arrays.copyOf(aJs, length + 1);
                        fileArr[length] = R;
                    } else {
                        fileArr = new File[]{R};
                    }
                    if (awb != null) {
                        awb.a(aMh, (HashMap<String, String>) null, fileArr, new w.a() { // from class: com.baidu.swan.apps.y.c.2.1
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
    public static boolean aBE() {
        return com.baidu.swan.apps.v.f.azg().ayQ().aeZ().aGz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean afm() {
        SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
        if (ayQ == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a aeZ = ayQ.aeZ();
        if (aeZ == null || !(aeZ.getView() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) aeZ.getView()).getChildAt(0) instanceof LoadingView;
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar anB = eVar.anB();
        if (anB != null) {
            int[] iArr2 = new int[2];
            anB.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + anB.getHeight() + 1);
            if (deP) {
                if (DEBUG) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                com.baidu.swan.apps.adaptation.b.c aoi = eVar.aoi();
                if (aoi != null) {
                    com.baidu.swan.apps.adaptation.b.f ahS = aoi.ahS();
                    if (ahS instanceof SwanAppWebViewWidget) {
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int aqO = ((SwanAppWebViewWidget) ahS).aqO();
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + aqO);
                        }
                        if (aqO > 0) {
                            iArr[1] = aqO + iArr[1] + 1;
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
