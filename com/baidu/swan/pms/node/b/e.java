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
/* loaded from: classes14.dex */
public class e {
    private static e dGJ;
    private a dGK = new a();
    private String dGL = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_dialog_msg);
    private String dGM = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_toast_msg);

    public static e aUE() {
        if (dGJ == null) {
            synchronized (e.class) {
                if (dGJ == null) {
                    dGJ = new e();
                }
            }
        }
        return dGJ;
    }

    private e() {
    }

    public String getVersion() {
        return this.dGK.getString("tips_config_version", "0");
    }

    public String co(long j) {
        return this.dGK.getString(String.format("%04d", Long.valueOf(j)), this.dGL);
    }

    public String cp(long j) {
        return this.dGK.getString(String.format("%04d", Long.valueOf(j)), this.dGM);
    }

    public void b(HashMap<String, String> hashMap, String str) {
        if (hashMap != null && !hashMap.isEmpty() && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.dGK.edit();
            edit.clear();
            edit.putString("tips_config_version", str);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    public void cz(JSONObject jSONObject) {
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
    /* loaded from: classes14.dex */
    public static class a extends i {
        a() {
            super("updatecore_node_tipmsgs");
        }
    }
}
