package com.baidu.live.data;

import android.text.TextUtils;
import java.io.Serializable;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaAvtsData implements Serializable {
    public String host;
    public long lineId;
    public int port;
    public long roomId;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.host = jSONObject.optString("host");
            this.port = jSONObject.optInt(ClientCookie.PORT_ATTR);
            this.roomId = jSONObject.optLong("room_id");
            this.lineId = jSONObject.optLong("line_id");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.host) && this.port > 0 && this.roomId > 0 && this.lineId > 0;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("host", this.host);
            jSONObject.put(ClientCookie.PORT_ATTR, this.port);
            jSONObject.put("room_id", this.roomId);
            jSONObject.put("line_id", this.lineId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
