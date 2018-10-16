package com.baidu.searchbox.ng.ai.apps.view.container.util;

import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsWebMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsEventHelper {

    /* loaded from: classes2.dex */
    private interface EventKeySet {
        public static final String SLAVE_ID = "slaveId";
        public static final String TYPE = "type";
        public static final String TYPE_VALUE = "abilityMessage";
        public static final String VALUE = "value";

        /* loaded from: classes2.dex */
        public interface ValueNode {
            public static final String PARAMS = "params";
            public static final String TYPE = "type";

            /* loaded from: classes2.dex */
            public interface ParamsNode {
                public static final String ACTION = "action";
                public static final String E = "e";
                public static final String ID = "id";
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void sendEventToSlave(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        AiAppsWebMessage aiAppsWebMessage = new AiAppsWebMessage();
        aiAppsWebMessage.mData = getEventJson(str, str2, str3, str4, jSONObject);
        AiAppsController.getInstance().sendJSMessage(str, aiAppsWebMessage);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public static void sendEventToMaster(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        AiAppsWebMessage aiAppsWebMessage = new AiAppsWebMessage();
        aiAppsWebMessage.mData = getEventJson(str, str2, str3, str4, jSONObject);
        AiAppsController.getInstance().sendJSMessage(aiAppsWebMessage);
    }

    public static JSONObject getEventJson(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", str2);
            jSONObject3.put("action", str4);
            jSONObject3.put("e", jSONObject);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", str3);
            jSONObject4.put("params", jSONObject3);
            jSONObject2.put("slaveId", str);
            jSONObject2.put("type", EventKeySet.TYPE_VALUE);
            jSONObject2.put("value", jSONObject4);
        } catch (JSONException e) {
        }
        return jSONObject2;
    }
}
