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
    public void bfJ() {
        try {
            JSONObject bfL = bfL();
            bfL.put("type", "first_frame");
            bfL.put("ext", bfM().toString());
            e.onEvent("322", bfL);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
        try {
            JSONObject bfL = bfL();
            JSONObject bfM = bfM();
            bfM.put("errorNo", i);
            bfM.put("sub_errorNo", i2);
            bfM.put("errorInfo", str);
            bfL.put("ext", bfM.toString());
            e.onEvent("36", bfL);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bfL() {
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
    private JSONObject bfM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aIt());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
            if (aIr != null) {
                str = aIr.aIK() ? "swangame" : GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
                b.a afB = aIr.afB();
                if (afB != null && afB.ayw() > 0) {
                    jSONObject.put("ext_start", afB.ayw());
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
    public void nZ(String str) {
    }
}
