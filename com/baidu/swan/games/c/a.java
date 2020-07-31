package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0444a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a bV(JSONObject jSONObject) {
        C0444a c0444a = new C0444a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0444a.type = jSONObject.optString("type");
        c0444a.cmd = jSONObject.optString("cmd");
        return new a(c0444a);
    }
}
