package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl bfr;
    private b bfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.bfr = eventTargetImpl;
    }

    public void a(b bVar) {
        this.bfs = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void f(String str, JSONObject jSONObject) {
        String optString = this.aCp.optString(str);
        if (this.bfs != null) {
            this.bfs.f(optString, jSONObject);
        }
        if (this.bfr.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG) {
                Log.e("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.bfr.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean Hh() {
        return true;
    }
}
