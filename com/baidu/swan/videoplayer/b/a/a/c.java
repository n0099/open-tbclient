package com.baidu.swan.videoplayer.b.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void beI() {
        try {
            JSONObject beK = beK();
            beK.put("type", "first_frame");
            beK.put("ext", beL().toString());
            e.onEvent("322", beK);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
        try {
            JSONObject beK = beK();
            JSONObject beL = beL();
            beL.put("errorNo", i);
            beL.put("sub_errorNo", i2);
            beL.put("errorInfo", str);
            beK.put("ext", beL.toString());
            e.onEvent("36", beK);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject beK() {
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
    private JSONObject beL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aHw());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
            if (aHu != null) {
                str = aHu.aHN() ? "swangame" : "swan";
                b.a afO = aHu.afO();
                if (afO != null && afO.ayx() > 0) {
                    jSONObject.put("ext_start", afO.ayx());
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
    public void oS(String str) {
    }
}
