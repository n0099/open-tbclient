package com.baidu.swan.games.b;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f {
    public String msg;
    public int state;

    public static f bG(JSONObject jSONObject) {
        f fVar = new f();
        fVar.state = jSONObject.optInt("state");
        fVar.msg = jSONObject.optString("msg");
        return fVar;
    }

    public String toString() {
        return "CheckPayAuthModel{state=" + this.state + ", msg='" + this.msg + "'}";
    }
}
