package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0487a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a ce(JSONObject jSONObject) {
        C0487a c0487a = new C0487a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0487a.type = jSONObject.optString("type");
        c0487a.cmd = jSONObject.optString("cmd");
        return new a(c0487a);
    }
}
