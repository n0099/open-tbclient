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
/* loaded from: classes6.dex */
public class e {
    private static e eox;
    private a eoy = new a();
    private String eoz = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_dialog_msg);
    private String eoA = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_toast_msg);

    public static e beQ() {
        if (eox == null) {
            synchronized (e.class) {
                if (eox == null) {
                    eox = new e();
                }
            }
        }
        return eox;
    }

    private e() {
    }

    public String getVersion() {
        return this.eoy.getString("tips_config_version", "0");
    }

    public String du(long j) {
        return this.eoy.getString(String.format("%04d", Long.valueOf(j)), this.eoz);
    }

    public String dv(long j) {
        return this.eoy.getString(String.format("%04d", Long.valueOf(j)), this.eoA);
    }

    public void b(HashMap<String, String> hashMap, String str) {
        if (hashMap != null && !hashMap.isEmpty() && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.eoy.edit();
            edit.clear();
            edit.putString("tips_config_version", str);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    public void cO(JSONObject jSONObject) {
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
    /* loaded from: classes6.dex */
    public static class a extends i {
        a() {
            super("updatecore_node_tipmsgs");
        }
    }
}
