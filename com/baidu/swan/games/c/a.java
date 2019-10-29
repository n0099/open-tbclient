package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0242a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a aO(JSONObject jSONObject) {
        C0242a c0242a = new C0242a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0242a.type = jSONObject.optString("type");
        c0242a.cmd = jSONObject.optString("cmd");
        return new a(c0242a);
    }
}
