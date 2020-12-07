package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class e extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl dWh;
    private b dWi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.dWh = eventTargetImpl;
    }

    public void a(b bVar) {
        this.dWi = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void g(String str, JSONObject jSONObject) {
        String optString = this.dgS.optString(str);
        if (this.dWi != null) {
            this.dWi.g(optString, jSONObject);
        }
        if (this.dWh.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG && !"onTimeUpdate".equals(str)) {
                Log.d("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.dWh.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean aCX() {
        return true;
    }
}
