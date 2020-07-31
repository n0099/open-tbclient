package com.baidu.swan.videoplayer.b.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void aOx() {
        try {
            JSONObject aOz = aOz();
            aOz.put("type", "first_frame");
            aOz.put("ext", aOA().toString());
            e.onEvent("322", aOz);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void g(int i, int i2, String str) {
        try {
            JSONObject aOz = aOz();
            JSONObject aOA = aOA();
            aOA.put("errorNo", i);
            aOA.put("sub_errorNo", i2);
            aOA.put("errorInfo", str);
            aOz.put("ext", aOA.toString());
            e.onEvent("36", aOz);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject aOz() {
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
    private JSONObject aOA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.arx());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
            if (arv != null) {
                str = arv.arO() ? "swangame" : "swan";
                b.a Se = arv.Se();
                if (Se != null && Se.aja() > 0) {
                    jSONObject.put("ext_start", Se.aja());
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
}
