package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0513a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a cv(JSONObject jSONObject) {
        C0513a c0513a = new C0513a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0513a.type = jSONObject.optString("type");
        c0513a.cmd = jSONObject.optString("cmd");
        return new a(c0513a);
    }
}
