package com.baidu.swan.videoplayer.b.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void bhg() {
        try {
            JSONObject bhi = bhi();
            bhi.put("type", "first_frame");
            bhi.put("ext", bhj().toString());
            e.onEvent("322", bhi);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void i(int i, int i2, String str) {
        try {
            JSONObject bhi = bhi();
            JSONObject bhj = bhj();
            bhj.put("errorNo", i);
            bhj.put("sub_errorNo", i2);
            bhj.put("errorInfo", str);
            bhi.put("ext", bhj.toString());
            e.onEvent("36", bhi);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bhi() {
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
    private JSONObject bhj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aJW());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
            if (aJU != null) {
                str = aJU.aKn() ? "swangame" : "swan";
                b.a aio = aJU.aio();
                if (aio != null && aio.aAY() > 0) {
                    jSONObject.put("ext_start", aio.aAY());
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
    public void pt(String str) {
    }
}
