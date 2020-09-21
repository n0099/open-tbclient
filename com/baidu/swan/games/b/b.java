package com.baidu.swan.games.b;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends EventTargetImpl {
    public b(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        d.aLs().a(this);
    }

    public void aa(int i, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", i);
        jSONObject.put("msg", str);
        JSEvent jSEvent = new JSEvent("antiaddiction");
        jSEvent.data = jSONObject;
        if (com.baidu.swan.apps.b.DEBUG) {
            Log.d("AntiAddictionApi", "result: " + jSONObject.toString());
        }
        dispatchEvent(jSEvent);
    }
}
