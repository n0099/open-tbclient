package com.baidu.live.data;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaAvtsConfigInfo implements Serializable {
    public int closeTimeout;
    public int handshakeTimeout;
    public int heartInterval;
    public int heartTimeout;
    public int reduceDelay;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.handshakeTimeout = jSONObject.optInt("handshake_timeout");
            this.heartInterval = jSONObject.optInt("heart_interval");
            this.heartTimeout = jSONObject.optInt("heart_timeout");
            this.closeTimeout = jSONObject.optInt("close_timeout");
            this.reduceDelay = jSONObject.optInt("reduce_delay");
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("handshake_timeout", this.handshakeTimeout);
            jSONObject.put("heart_interval", this.heartInterval);
            jSONObject.put("heart_timeout", this.heartTimeout);
            jSONObject.put("close_timeout", this.closeTimeout);
            jSONObject.put("reduce_delay", this.reduceDelay);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
