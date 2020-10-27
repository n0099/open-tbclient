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
    public void bci() {
        try {
            JSONObject bck = bck();
            bck.put("type", "first_frame");
            bck.put("ext", bcl().toString());
            e.onEvent("322", bck);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
        try {
            JSONObject bck = bck();
            JSONObject bcl = bcl();
            bcl.put("errorNo", i);
            bcl.put("sub_errorNo", i2);
            bcl.put("errorInfo", str);
            bck.put("ext", bcl.toString());
            e.onEvent("36", bck);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bck() {
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
    private JSONObject bcl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aEW());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
            if (aEU != null) {
                str = aEU.aFn() ? "swangame" : "swan";
                b.a ado = aEU.ado();
                if (ado != null && ado.avX() > 0) {
                    jSONObject.put("ext_start", ado.avX());
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
    public void oE(String str) {
    }
}
