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
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final boolean dlW = com.baidu.swan.apps.t.a.awB().getSwitch("swan_white_screent_webview_progress_bar_switch", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.e aCl() {
        com.baidu.swan.apps.core.d.f afz;
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx != null && (afz = azx.afz()) != null) {
            com.baidu.swan.apps.core.d.c aoY = afz.aoY();
            if (aoY instanceof com.baidu.swan.apps.core.d.e) {
                return (com.baidu.swan.apps.core.d.e) aoY;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar != null) {
            com.baidu.swan.apps.runtime.config.c aol = eVar.aol();
            if (aol != null) {
                return aol.backgroundColor;
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
    public static String p(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 0, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject aCm() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aIr() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aIr().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.t.a.awK().ce(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.jA(com.baidu.swan.apps.runtime.d.aIn().afr()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gk(boolean z) {
        String aIt = com.baidu.swan.apps.runtime.e.aIt();
        Context azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx == null) {
            azx = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aIt)) {
            if (aIt.lastIndexOf("_dev") > 0 || aIt.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.u(azx, a.h.aiapps_swan_app_error_page_hint).jg(5).jc(3).aHZ();
            } else if (z) {
                cg("whiteScreen_L1", "检测到纯白屏");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cg(final String str, final String str2) {
        com.baidu.swan.apps.core.f.a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：正常");
                        com.baidu.swan.apps.core.d.K("white_screen", str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                    case 2:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：较差");
                        com.baidu.swan.apps.core.d.K("white_screen", str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：离线");
                        com.baidu.swan.apps.core.d.K("white_screen", str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：未知");
                        com.baidu.swan.apps.core.d.K("white_screen", str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aCn() {
        com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null && afz.aoY() != null) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap aNM = ah.aNM();
                    w awH = com.baidu.swan.apps.t.a.awH();
                    com.baidu.swan.apps.aj.a.aKP().aKT();
                    File[] aKX = com.baidu.swan.apps.aj.a.aKP().aKV().aKX();
                    File aa = com.baidu.swan.apps.t.a.axi().aa(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aIt());
                    if (aKX != null) {
                        int length = aKX.length;
                        fileArr = (File[]) Arrays.copyOf(aKX, length + 1);
                        fileArr[length] = aa;
                    } else {
                        fileArr = new File[]{aa};
                    }
                    if (awH != null) {
                        awH.a(aNM, (HashMap<String, String>) null, fileArr, new w.a() { // from class: com.baidu.swan.apps.y.c.2.1
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
    public static boolean aCo() {
        return com.baidu.swan.apps.v.f.azN().azx().afu().aHN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean afH() {
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        if (azx == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a afu = azx.afu();
        if (afu == null || !(afu.getView() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) afu.getView()).getChildAt(0) instanceof LoadingView;
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar aob = eVar.aob();
        if (aob != null) {
            int[] iArr2 = new int[2];
            aob.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + aob.getHeight() + 1);
            if (dlW) {
                if (DEBUG) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                com.baidu.swan.apps.adaptation.b.c aoN = eVar.aoN();
                if (aoN != null) {
                    com.baidu.swan.apps.adaptation.b.f air = aoN.air();
                    if (air instanceof SwanAppWebViewWidget) {
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int art = ((SwanAppWebViewWidget) air).art();
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + art);
                        }
                        if (art > 0) {
                            iArr[1] = art + iArr[1] + 1;
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
