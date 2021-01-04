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
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final boolean dqM = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_white_screent_webview_progress_bar_switch", false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.core.d.e aGe() {
        com.baidu.swan.apps.core.d.f ajs;
        SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
        if (aDq != null && (ajs = aDq.ajs()) != null) {
            com.baidu.swan.apps.core.d.c asT = ajs.asT();
            if (asT instanceof com.baidu.swan.apps.core.d.e) {
                return (com.baidu.swan.apps.core.d.e) asT;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar != null) {
            com.baidu.swan.apps.runtime.config.c asf = eVar.asf();
            if (asf != null) {
                return asf.backgroundColor;
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
    public static JSONObject aGf() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.runtime.e.aMk() != null) {
                jSONObject.put("name", com.baidu.swan.apps.runtime.e.aMk().getName());
            } else {
                jSONObject.put("name", RomUtils.UNKNOWN);
            }
            jSONObject.put("zeus", com.baidu.swan.apps.t.a.aAD().cf(AppRuntime.getAppContext()));
            jSONObject.put("net", SwanAppNetworkUtils.getNetworkClass());
            jSONObject.put("swaninfo", com.baidu.swan.apps.swancore.b.lg(com.baidu.swan.apps.runtime.d.aMg().ajk()).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void go(boolean z) {
        String aMm = com.baidu.swan.apps.runtime.e.aMm();
        Context aDq = com.baidu.swan.apps.v.f.aDG().aDq();
        if (aDq == null) {
            aDq = AppRuntime.getAppContext();
        }
        if (!TextUtils.isEmpty(aMm)) {
            if (aMm.lastIndexOf("_dev") > 0 || aMm.lastIndexOf("_trial") > 0) {
                com.baidu.swan.apps.res.widget.b.d.u(aDq, a.h.aiapps_swan_app_error_page_hint).kM(5).kI(3).aLS();
            } else if (z) {
                ch("whiteScreen_L1", "检测到纯白屏");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ch(final String str, final String str2) {
        com.baidu.swan.apps.core.f.a(new SwanAppNetworkUtils.a() { // from class: com.baidu.swan.apps.y.c.1
            @Override // com.baidu.swan.apps.network.SwanAppNetworkUtils.a
            public void onResult(int i) {
                switch (i) {
                    case 1:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：正常");
                        com.baidu.swan.apps.core.d.L("white_screen", str, FrsActivityConfig.GOOD);
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                    case 2:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：较差");
                        com.baidu.swan.apps.core.d.L("white_screen", str, "bad");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    case 3:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：离线");
                        com.baidu.swan.apps.core.d.L("white_screen", str, "offline");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_net_unavailable);
                        return;
                    default:
                        com.baidu.swan.apps.core.f.log(str2 + "; 网络：未知");
                        com.baidu.swan.apps.core.d.L("white_screen", str, "unknown");
                        com.baidu.swan.apps.core.c.showToast(a.h.swanapp_tip_load_fail);
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aGg() {
        com.baidu.swan.apps.core.d.f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
        if (ajs != null && ajs.asT() != null) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.y.c.2
                @Override // java.lang.Runnable
                public void run() {
                    final File[] fileArr;
                    Bitmap aRF = ah.aRF();
                    w aAA = com.baidu.swan.apps.t.a.aAA();
                    com.baidu.swan.apps.aj.a.aOI().aOM();
                    File[] aOQ = com.baidu.swan.apps.aj.a.aOI().aOO().aOQ();
                    File aa = com.baidu.swan.apps.t.a.aBb().aa(AppRuntime.getAppContext(), com.baidu.swan.apps.runtime.e.aMm());
                    if (aOQ != null) {
                        int length = aOQ.length;
                        fileArr = (File[]) Arrays.copyOf(aOQ, length + 1);
                        fileArr[length] = aa;
                    } else {
                        fileArr = new File[]{aa};
                    }
                    if (aAA != null) {
                        aAA.a(aRF, (HashMap<String, String>) null, fileArr, new w.a() { // from class: com.baidu.swan.apps.y.c.2.1
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
    public static boolean aGh() {
        return com.baidu.swan.apps.v.f.aDG().aDq().ajn().aLG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ajA() {
        SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
        if (aDq == null) {
            return false;
        }
        com.baidu.swan.apps.res.widget.floatlayer.a ajn = aDq.ajn();
        if (ajn == null || !(ajn.getView() instanceof FrameLayout)) {
            return false;
        }
        return ((FrameLayout) ajn.getView()).getChildAt(0) instanceof LoadingView;
    }

    public static Rect a(Bitmap bitmap, com.baidu.swan.apps.core.d.e eVar, View view) {
        if (bitmap == null || eVar == null || view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int min = Math.min(iArr[0] + view.getMeasuredWidth(), bitmap.getWidth());
        int min2 = Math.min(iArr[1] + view.getMeasuredHeight(), bitmap.getHeight());
        SwanAppActionBar arV = eVar.arV();
        if (arV != null) {
            int[] iArr2 = new int[2];
            arV.getLocationOnScreen(iArr2);
            iArr[1] = Math.max(iArr[1], iArr2[1] + arV.getHeight() + 1);
            if (dqM) {
                if (DEBUG) {
                    Log.d("MonitorUtils", "getCheckRect: hit webview widget process bar calibrate");
                }
                com.baidu.swan.apps.adaptation.b.c asI = eVar.asI();
                if (asI != null) {
                    com.baidu.swan.apps.adaptation.b.f amk = asI.amk();
                    if (amk instanceof SwanAppWebViewWidget) {
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: hit webview widget");
                        }
                        int avn = ((SwanAppWebViewWidget) amk).avn();
                        if (DEBUG) {
                            Log.d("MonitorUtils", "getCheckRect: webview widget originY=" + iArr[1] + " , progressBarHeight=" + avn);
                        }
                        if (avn > 0) {
                            iArr[1] = avn + iArr[1] + 1;
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
