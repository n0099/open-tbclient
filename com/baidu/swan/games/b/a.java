package com.baidu.swan.games.b;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0320a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a bw(JSONObject jSONObject) {
        C0320a c0320a = new C0320a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0320a.type = jSONObject.optString("type");
        c0320a.cmd = jSONObject.optString("cmd");
        return new a(c0320a);
    }
}
