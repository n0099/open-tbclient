package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0504a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a cl(JSONObject jSONObject) {
        C0504a c0504a = new C0504a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0504a.type = jSONObject.optString("type");
        c0504a.cmd = jSONObject.optString("cmd");
        return new a(c0504a);
    }
}
