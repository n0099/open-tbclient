package com.baidu.swan.pms.node.b;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.e.j;
import com.baidu.swan.pms.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    private static e dmW;
    private a dmX = new a();
    private String dmY = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_dialog_msg);
    private String dmZ = AppRuntime.getAppContext().getString(e.a.swan_launch_failed_default_toast_msg);

    public static e aHh() {
        if (dmW == null) {
            synchronized (e.class) {
                if (dmW == null) {
                    dmW = new e();
                }
            }
        }
        return dmW;
    }

    private e() {
    }

    public String getVersion() {
        return this.dmX.getString("tips_config_version", "0");
    }

    public String bP(long j) {
        return this.dmX.getString(String.format("%04d", Long.valueOf(j)), this.dmY);
    }

    public String bQ(long j) {
        return this.dmX.getString(String.format("%04d", Long.valueOf(j)), this.dmZ);
    }

    public void b(HashMap<String, String> hashMap, String str) {
        if (hashMap != null && !hashMap.isEmpty() && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = this.dmX.edit();
            edit.clear();
            edit.putString("tips_config_version", str);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
        }
    }

    public void ch(JSONObject jSONObject) {
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
    /* loaded from: classes11.dex */
    public static class a extends j {
        a() {
            super("updatecore_node_tipmsgs");
        }
    }
}
