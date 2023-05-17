package com.baidu.searchbox.cloudcontrol.data;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ConfigRequestInfo extends CloudControlRequestInfo {
    public static final String CONFIG = "config";

    public ConfigRequestInfo() {
        super("config", null, null, null);
    }

    public void setConfigModuleList(List<ConfigModule> list) {
        if (list != null) {
            JSONObject jSONObject = new JSONObject();
            for (ConfigModule configModule : list) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (ConfigAction configAction : configModule.getConfigActions()) {
                        jSONObject2.put(configAction.getAction(), configAction.getVersion());
                    }
                    jSONObject.put(configModule.getModule(), jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            setPostData(jSONObject);
        }
    }
}
