package com.baidu.swan.videoplayer.b.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void aJD() {
        try {
            JSONObject aJF = aJF();
            aJF.put("type", "first_frame");
            aJF.put("ext", aJG().toString());
            e.onEvent("322", aJF);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void g(int i, int i2, String str) {
        try {
            JSONObject aJF = aJF();
            JSONObject aJG = aJG();
            aJG.put("errorNo", i);
            aJG.put("sub_errorNo", i2);
            aJG.put("errorInfo", str);
            aJF.put("ext", aJG.toString());
            e.onEvent("36", aJF);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject aJF() {
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
    private JSONObject aJG() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aoH());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
            if (aoF != null) {
                str = aoF.aoY() ? "swangame" : "swan";
                b.a QJ = aoF.QJ();
                if (QJ != null && QJ.agE() > 0) {
                    jSONObject.put("ext_start", QJ.agE());
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
