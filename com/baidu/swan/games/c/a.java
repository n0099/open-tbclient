package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0237a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a aP(JSONObject jSONObject) {
        C0237a c0237a = new C0237a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0237a.type = jSONObject.optString("type");
        c0237a.cmd = jSONObject.optString("cmd");
        return new a(c0237a);
    }
}
