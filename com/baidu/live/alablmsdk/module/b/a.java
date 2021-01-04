package com.baidu.live.alablmsdk.module.b;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public int aCZ;
    public int permission;
    public String roomId;

    public a(String str, int i, int i2) {
        this.roomId = str;
        this.permission = i;
        this.aCZ = i2;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("room_id", this.roomId);
            jSONObject.put("room_permission", this.permission);
            jSONObject.put("logically_hung_up", this.aCZ);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public static a fQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new a(jSONObject.getString("room_id"), jSONObject.getInt("room_permission"), jSONObject.getInt("logically_hung_up"));
        } catch (JSONException e) {
            return null;
        }
    }
}
