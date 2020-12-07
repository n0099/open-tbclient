package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0540a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a cq(JSONObject jSONObject) {
        C0540a c0540a = new C0540a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0540a.type = jSONObject.optString("type");
        c0540a.cmd = jSONObject.optString("cmd");
        return new a(c0540a);
    }
}
