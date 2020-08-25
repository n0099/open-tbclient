package com.baidu.swan.games.audio;

import android.util.Log;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends com.baidu.swan.apps.media.audio.b.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private EventTargetImpl dot;
    private b dou;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventTargetImpl eventTargetImpl, JSONObject jSONObject) {
        super(null, jSONObject);
        this.dot = eventTargetImpl;
    }

    public void a(b bVar) {
        this.dou = bVar;
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public void e(String str, JSONObject jSONObject) {
        String optString = this.czc.optString(str);
        if (this.dou != null) {
            this.dou.e(optString, jSONObject);
        }
        if (this.dot.hasEventListener(optString)) {
            JSEvent jSEvent = new JSEvent(optString);
            if (jSONObject != null) {
                jSEvent.data = jSONObject;
            }
            if (DEBUG && !"onTimeUpdate".equals(str)) {
                Log.d("AudioCallbackForV8", "type = " + str + "  result = " + (jSONObject != null ? jSONObject.toString() : "null"));
            }
            this.dot.dispatchEvent(jSEvent);
        }
    }

    @Override // com.baidu.swan.apps.media.audio.b.a
    public boolean asI() {
        return true;
    }
}
