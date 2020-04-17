package com.baidu.swan.games.b;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0362a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a bH(JSONObject jSONObject) {
        C0362a c0362a = new C0362a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0362a.type = jSONObject.optString("type");
        c0362a.cmd = jSONObject.optString("cmd");
        return new a(c0362a);
    }
}
