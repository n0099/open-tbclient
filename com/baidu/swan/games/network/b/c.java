package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.picture.params.LaunchParams;
import com.baidu.searchbox.websocket.WebSocketRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private List<com.baidu.swan.games.binding.model.c> cqr = new ArrayList();

    public c(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (DEBUG) {
                Log.d("SwanGamePreloadConfig", "jsonArray:" + jSONArray);
            }
            int length = jSONArray.length();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("type");
                    char c = 65535;
                    switch (optString.hashCode()) {
                        case 1095692943:
                            if (optString.equals("request")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1427818632:
                            if (optString.equals(LaunchParams.SRC_TYPE_DOWNLOAD)) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            if (i2 < 3) {
                                this.cqr.add(bA(optJSONObject));
                                i2++;
                                break;
                            } else {
                                continue;
                            }
                        case 1:
                            if (i < 10) {
                                this.cqr.add(bB(optJSONObject));
                                i++;
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.swan.games.e.b bVar) {
        if (bVar != null) {
            if (DEBUG) {
                Log.d("SwanGamePreloadConfig", "startPreload objectMap:" + this.cqr);
            }
            for (com.baidu.swan.games.binding.model.c cVar : this.cqr) {
                if (cVar != null) {
                    String optString = cVar.optString("type");
                    char c = 65535;
                    switch (optString.hashCode()) {
                        case 1095692943:
                            if (optString.equals("request")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1427818632:
                            if (optString.equals(LaunchParams.SRC_TYPE_DOWNLOAD)) {
                                c = 1;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            new com.baidu.swan.games.network.b.a.b(bVar, cVar).start();
                            continue;
                        case 1:
                            new com.baidu.swan.games.network.b.a.a(bVar, cVar).start();
                            continue;
                    }
                }
            }
        }
    }

    private com.baidu.swan.games.binding.model.c bz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.baidu.swan.games.binding.model.c cVar = new com.baidu.swan.games.binding.model.c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            cVar.put(next, jSONObject.optString(next));
        }
        return cVar;
    }

    private com.baidu.swan.games.binding.model.c bA(@NonNull JSONObject jSONObject) {
        com.baidu.swan.games.binding.model.c cVar = new com.baidu.swan.games.binding.model.c();
        cVar.put("type", jSONObject.optString("type"));
        cVar.put("url", jSONObject.optString("url"));
        cVar.put("responseType", jSONObject.optString("responseType"));
        cVar.put(WebSocketRequest.PARAM_KEY_HEADER, bz(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
        return cVar;
    }

    private com.baidu.swan.games.binding.model.c bB(@NonNull JSONObject jSONObject) {
        com.baidu.swan.games.binding.model.c cVar = new com.baidu.swan.games.binding.model.c();
        cVar.put("type", jSONObject.optString("type"));
        cVar.put("url", jSONObject.optString("url"));
        cVar.put("filePath", jSONObject.optString("filePath"));
        cVar.put(WebSocketRequest.PARAM_KEY_HEADER, bz(jSONObject.optJSONObject(WebSocketRequest.PARAM_KEY_HEADER)));
        return cVar;
    }
}
