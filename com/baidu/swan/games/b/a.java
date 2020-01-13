package com.baidu.swan.games.b;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0322a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a bw(JSONObject jSONObject) {
        C0322a c0322a = new C0322a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0322a.type = jSONObject.optString("type");
        c0322a.cmd = jSONObject.optString("cmd");
        return new a(c0322a);
    }
}
