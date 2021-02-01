package com.baidu.swan.videoplayer.b.a.a;

import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bfW() {
        try {
            JSONObject bfY = bfY();
            bfY.put("type", "first_frame");
            bfY.put("ext", bfZ().toString());
            e.onEvent("322", bfY);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void h(int i, int i2, String str) {
        try {
            JSONObject bfY = bfY();
            JSONObject bfZ = bfZ();
            bfZ.put("errorNo", i);
            bfZ.put("sub_errorNo", i2);
            bfZ.put("errorInfo", str);
            bfY.put("ext", bfZ.toString());
            e.onEvent("36", bfY);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bfY() {
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
    private JSONObject bfZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aIM());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
            if (aIK != null) {
                str = aIK.aJd() ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                b.a afZ = aIK.afZ();
                if (afZ != null && afZ.ayU() > 0) {
                    jSONObject.put("ext_start", afZ.ayU());
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
    public void ot(String str) {
    }
}
