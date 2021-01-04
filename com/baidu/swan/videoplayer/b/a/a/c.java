package com.baidu.swan.videoplayer.b.a.a;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bjC() {
        try {
            JSONObject bjE = bjE();
            bjE.put("type", "first_frame");
            bjE.put("ext", bjF().toString());
            e.onEvent("322", bjE);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
        try {
            JSONObject bjE = bjE();
            JSONObject bjF = bjF();
            bjF.put("errorNo", i);
            bjF.put("sub_errorNo", i2);
            bjF.put("errorInfo", str);
            bjE.put("ext", bjF.toString());
            e.onEvent("36", bjE);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bjE() {
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
    private JSONObject bjF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aMm());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
            if (aMk != null) {
                str = aMk.aMD() ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                b.a aju = aMk.aju();
                if (aju != null && aju.aCp() > 0) {
                    jSONObject.put("ext_start", aju.aCp());
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
    public void pm(String str) {
    }
}
