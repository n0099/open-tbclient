package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl cfR;
    private b cfS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.cfR = eventTargetImpl;
    }

    public void a(b bVar) {
        this.cfS = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void d(String str, JSONObject jSONObject) {
        String optString = this.bxh.optString(str);
        if (this.cfS != null) {
            this.cfS.d(optString, jSONObject);
        }
        if (this.cfR.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG && !"onTimeUpdate".equals(str)) {
                Log.d("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.cfR.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean Va() {
        return true;
    }
}
