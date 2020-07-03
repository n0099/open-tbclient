package com.baidu.swan.pms.node;

import com.baidu.swan.pms.a.g;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e {
    public static JSONObject aIf() {
        return a(Node.values());
    }

    private static JSONObject a(Node[] nodeArr) {
        d provider;
        if (nodeArr == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (Node node : nodeArr) {
                if (node != null && (provider = Node.getProvider(node)) != null) {
                    if (node.isDataArray()) {
                        jSONObject.put(node.getName(), provider.aId());
                    } else {
                        jSONObject.put(node.getName(), provider.aIe());
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

    public static void b(JSONObject jSONObject, g gVar, g gVar2) {
        c a;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Node nodeByConfigName = Node.getNodeByConfigName(next);
                if (nodeByConfigName != null && (a = f.a(nodeByConfigName)) != null) {
                    if (nodeByConfigName.isDataArray()) {
                        a.a(jSONObject.optJSONArray(next), gVar, gVar2);
                    } else {
                        a.a(jSONObject.optJSONObject(next), gVar, gVar2);
                    }
                }
            }
        }
    }
}
