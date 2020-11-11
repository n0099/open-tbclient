package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl dQR;
    private b dQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.dQR = eventTargetImpl;
    }

    public void a(b bVar) {
        this.dQS = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void g(String str, JSONObject jSONObject) {
        String optString = this.dbC.optString(str);
        if (this.dQS != null) {
            this.dQS.g(optString, jSONObject);
        }
        if (this.dQR.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG && !"onTimeUpdate".equals(str)) {
                Log.d("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.dQR.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean aAw() {
        return true;
    }
}
