package com.baidu.swan.pms.node.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.c.i;
import com.baidu.swan.pms.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e {
    private static e dUO;
    private a dUP = new a();
    private String dUQ = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_dialog_msg);
    private String dUR = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_toast_msg);

    public static e aXZ() {
        if (dUO == null) {
            synchronized (e.class) {
                if (dUO == null) {
                    dUO = new e();
                }
            }
        }
        return dUO;
    }

    private e() {
    }

    public String getVersion() {
        return this.dUP.getString("tips_config_version", "0");
    }

    public String cx(long j) {
        return this.dUP.getString(String.format("%04d", Long.valueOf(j)), this.dUQ);
    }

    public String cy(long j) {
        return this.dUP.getString(String.format("%04d", Long.valueOf(j)), this.dUR);
    }

    public void b(HashMap<String, String> hashMap, String str) {
        if (hashMap != null && !hashMap.isEmpty() && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.dUP.edit();
            edit.clear();
            edit.putString("tips_config_version", str);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    public void cJ(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            String optString = jSONObject.optString("version");
            if (!TextUtils.isEmpty(optString) && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                HashMap<String, String> hashMap = new HashMap<>(optJSONArray.length());
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
                }
                b(hashMap, optString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a extends i {
        a() {
            super("updatecore_node_tipmsgs");
        }
    }
}
