package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0492a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a cb(JSONObject jSONObject) {
        C0492a c0492a = new C0492a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0492a.type = jSONObject.optString("type");
        c0492a.cmd = jSONObject.optString("cmd");
        return new a(c0492a);
    }
}
