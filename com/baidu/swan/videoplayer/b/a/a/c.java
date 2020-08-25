package com.baidu.swan.videoplayer.b.a.a;

import android.support.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.ubc.e;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends a {
    public c(ZeusPluginFactory.Invoker invoker, String str) {
        super(invoker, str);
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void aWV() {
        try {
            JSONObject aWX = aWX();
            aWX.put("type", "first_frame");
            aWX.put("ext", aWY().toString());
            e.onEvent("322", aWX);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void f(int i, int i2, String str) {
        try {
            JSONObject aWX = aWX();
            JSONObject aWY = aWY();
            aWY.put("errorNo", i);
            aWY.put("sub_errorNo", i2);
            aWY.put("errorInfo", str);
            aWX.put("ext", aWY.toString());
            e.onEvent("36", aWX);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject aWX() {
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
    private JSONObject aWY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.azK());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
            if (azI != null) {
                str = azI.aAb() ? "swangame" : "swan";
                b.a XZ = azI.XZ();
                if (XZ != null && XZ.aqH() > 0) {
                    jSONObject.put("ext_start", XZ.aqH());
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
    public void nd(String str) {
    }
}
