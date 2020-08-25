package com.baidu.swan.pms.node;

import android.support.annotation.Nullable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class f {
    public static JSONObject b(@Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        return a(Node.values(), cVar, cVar2);
    }

    private static JSONObject a(Node[] nodeArr, @Nullable c<JSONArray> cVar, @Nullable c<JSONObject> cVar2) {
        e provider;
        if (nodeArr == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Node node : nodeArr) {
                if (node != null && (provider = Node.getProvider(node)) != null) {
                    if (node.isDataArray()) {
                        jSONObject.put(node.getName(), provider.a(cVar));
                    } else {
                        jSONObject.put(node.getName(), provider.b(cVar2));
                    }
                }
            }
            return jSONObject;
        } catch (JSONException e) {
            if (com.baidu.swan.pms.d.DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static void b(JSONObject jSONObject, com.baidu.swan.pms.a.g gVar, @Nullable com.baidu.swan.pms.a.g gVar2, @Nullable com.baidu.swan.pms.a.g gVar3) {
        d a;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Node nodeByConfigName = Node.getNodeByConfigName(next);
                if (nodeByConfigName != null && (a = g.a(nodeByConfigName)) != null) {
                    if (nodeByConfigName.isDataArray()) {
                        a.a(jSONObject.optJSONArray(next), gVar, gVar2, gVar3);
                    } else {
                        a.a(jSONObject.optJSONObject(next), gVar, gVar2, gVar3);
                    }
                }
            }
        }
    }
}
