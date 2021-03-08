package com.baidu.swan.videoplayer.b.a.a;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bfY() {
        try {
            JSONObject bga = bga();
            bga.put("type", "first_frame");
            bga.put("ext", bgb().toString());
            e.onEvent("322", bga);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void h(int i, int i2, String str) {
        try {
            JSONObject bga = bga();
            JSONObject bgb = bgb();
            bgb.put("errorNo", i);
            bgb.put("sub_errorNo", i2);
            bgb.put("errorInfo", str);
            bga.put("ext", bgb.toString());
            e.onEvent("36", bga);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bga() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "video");
            jSONObject.put("network", SwanAppNetworkUtils.getNetworkClass());
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @NonNull
    private JSONObject bgb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aIP());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
            if (aIN != null) {
                str = aIN.aJg() ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                b.a agc = aIN.agc();
                if (agc != null && agc.ayX() > 0) {
                    jSONObject.put("ext_start", agc.ayX());
                }
            }
            jSONObject.put("ext_page", str);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.apps.inlinewidget.f.c.a
    public void oA(String str) {
    }
}
