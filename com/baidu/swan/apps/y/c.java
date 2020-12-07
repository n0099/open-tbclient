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
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final boolean dlN = com.baidu.swan.apps.t.a.azd().getSwitch("swan_white_screent_webview_progress_bar_switch", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.e aEK() {
        com.baidu.swan.apps.core.d.f aim;
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        if (aBZ != null && (aim = aBZ.aim()) != null) {
            com.baidu.swan.apps.core.d.c arB = aim.arB();
            if (arB instanceof com.baidu.swan.apps.core.d.e) {
                return (com.baidu.swan.apps.core.d.e) arB;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar != null) {
            com.baidu.swan.apps.runtime.config.c aqQ = eVar.aqQ();
            if (aqQ != null) {
                return aqQ.backgroundColor;
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
    public static JSONObject aEL() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aJU() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aJU().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.t.a.azm().bY(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.lb(com.baidu.swan.apps.runtime.d.aJQ().aie()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void gf(boolean z) {
        String aJW = com.baidu.swan.apps.runtime.e.aJW();
        Context aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        if (aBZ == null) {
            aBZ = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aJW)) {
            if (aJW.lastIndexOf("_dev") > 0 || aJW.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.t(aBZ, a.h.aiapps_swan_app_error_page_hint).kG(5).kC(3).showToast();
            } else if (z) {
                ci("whiteScreen_L1", "检测到纯白屏");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ci(final String str, final String str2) {
        com.baidu.swan.apps.core.f.a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：正常");
                        com.baidu.swan.apps.core.d.I("white_screen", str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                    case 2:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：较差");
                        com.baidu.swan.apps.core.d.I("white_screen", str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：离线");
                        com.baidu.swan.apps.core.d.I("white_screen", str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：未知");
                        com.baidu.swan.apps.core.d.I("white_screen", str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aEM() {
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null && aim.arB() != null) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap aPo = ah.aPo();
                    w azj = com.baidu.swan.apps.t.a.azj();
                    com.baidu.swan.apps.ak.a.aMs().aMw();
                    File[] aMA = com.baidu.swan.apps.ak.a.aMs().aMy().aMA();
                    File U = com.baidu.swan.apps.t.a.azK().U(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aJW());
                    if (aMA != null) {
                        int length = aMA.length;
                        fileArr = (File[]) Arrays.copyOf(aMA, length + 1);
                        fileArr[length] = U;
                    } else {
                        fileArr = new File[]{U};
                    }
                    if (azj != null) {
                        azj.a(aPo, (HashMap<String, String>) null, fileArr, new w.a() { // from class: com.baidu.swan.apps.y.c.2.1
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
    public static boolean aEN() {
        return com.baidu.swan.apps.v.f.aCp().aBZ().aih().aJH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean aiu() {
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        if (aBZ == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a aih = aBZ.aih();
        if (aih == null || !(aih.getView() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) aih.getView()).getChildAt(0) instanceof LoadingView;
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar aqJ = eVar.aqJ();
        if (aqJ != null) {
            int[] iArr2 = new int[2];
            aqJ.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + aqJ.getHeight() + 1);
            if (dlN) {
                if (DEBUG) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                com.baidu.swan.apps.adaptation.b.c arq = eVar.arq();
                if (arq != null) {
                    com.baidu.swan.apps.adaptation.b.f ala = arq.ala();
                    if (ala instanceof SwanAppWebViewWidget) {
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int atW = ((SwanAppWebViewWidget) ala).atW();
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + atW);
                        }
                        if (atW > 0) {
                            iArr[1] = atW + iArr[1] + 1;
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
