package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0519a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a cx(JSONObject jSONObject) {
        C0519a c0519a = new C0519a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0519a.type = jSONObject.optString("type");
        c0519a.cmd = jSONObject.optString("cmd");
        return new a(c0519a);
    }
}
