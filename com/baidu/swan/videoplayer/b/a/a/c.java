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
    public void bap() {
        try {
            JSONObject bar = bar();
            bar.put("type", "first_frame");
            bar.put("ext", bas().toString());
            e.onEvent("322", bar);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.videoplayer.b.a.a.a
    public void h(int i, int i2, String str) {
        try {
            JSONObject bar = bar();
            JSONObject bas = bas();
            bas.put("errorNo", i);
            bas.put("sub_errorNo", i2);
            bas.put("errorInfo", str);
            bar.put("ext", bas.toString());
            e.onEvent("36", bar);
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    private JSONObject bar() {
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
    private JSONObject bas() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ext_from", "aiapp");
            jSONObject.put("appid", com.baidu.swan.apps.runtime.e.aDc());
            jSONObject.put("url", this.mCurrentUrl);
            jSONObject.put("vid", this.mCurrentUrl);
            jSONObject.put("isInline", true);
            String str = "";
            com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
            if (aDa != null) {
                str = aDa.aDt() ? "swangame" : "swan";
                b.a abu = aDa.abu();
                if (abu != null && abu.aud() > 0) {
                    jSONObject.put("ext_start", abu.aud());
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
    public void ok(String str) {
    }
}
