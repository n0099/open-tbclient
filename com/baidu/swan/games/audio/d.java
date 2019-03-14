package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl aZX;
    private b aZY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.aZX = eventTargetImpl;
    }

    public void a(b bVar) {
        this.aZY = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void f(String str, JSONObject jSONObject) {
        String optString = this.aAi.optString(str);
        if (this.aZY != null) {
            this.aZY.f(optString, jSONObject);
        }
        if (this.aZX.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG) {
                Log.e("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.aZX.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean Ez() {
        return true;
    }
}
