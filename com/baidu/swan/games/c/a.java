package com.baidu.swan.games.c;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends JSEvent {

    /* renamed from: com.baidu.swan.games.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0199a {
        @V8JavascriptField
        public String cmd;
        @V8JavascriptField
        public String type;
    }

    public a(Object obj) {
        super("sconsoleCmdMessage", obj);
    }

    public static a aq(JSONObject jSONObject) {
        C0199a c0199a = new C0199a();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        c0199a.type = jSONObject.optString("type");
        c0199a.cmd = jSONObject.optString(IntentConfig.CMD);
        return new a(c0199a);
    }
}
