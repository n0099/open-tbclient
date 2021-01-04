package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl efe;
    private b eff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.efe = eventTargetImpl;
    }

    public void a(b bVar) {
        this.eff = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void h(String str, JSONObject jSONObject) {
        String optString = this.dlM.optString(str);
        if (this.eff != null) {
            this.eff.h(optString, jSONObject);
        }
        if (this.efe.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG && !"onTimeUpdate".equals(str)) {
                Log.d("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.efe.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean aEp() {
        return true;
    }
}
