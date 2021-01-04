package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0533a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a cy(JSONObject jSONObject) {
        C0533a c0533a = new C0533a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0533a.type = jSONObject.optString("type");
        c0533a.cmd = jSONObject.optString("cmd");
        return new a(c0533a);
    }
}
