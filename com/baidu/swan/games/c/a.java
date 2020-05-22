package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0425a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a bI(JSONObject jSONObject) {
        C0425a c0425a = new C0425a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0425a.type = jSONObject.optString("type");
        c0425a.cmd = jSONObject.optString("cmd");
        return new a(c0425a);
    }
}
