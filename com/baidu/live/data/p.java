package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes7.dex */
    public static class a {
        public String aDW;
        public String aDX;
        public String aDY;
        public String aDZ;
        public String aEa;
        public String aEb;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aDW = jSONObject.optString("chat_mcast_id");
                this.aDX = jSONObject.optString("ensure_mcast_id");
                this.aDY = jSONObject.optString("chat_msg_hls_url");
                this.aDZ = jSONObject.optString("host_msg_hls_url");
                this.aEa = jSONObject.optString("reliable_msg_hls_url");
                this.aEb = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.aDW);
                jSONObject.put("ensure_mcast_id", this.aDX);
                jSONObject.put("chat_msg_hls_url", this.aDY);
                jSONObject.put("host_msg_hls_url", this.aDZ);
                jSONObject.put("reliable_msg_hls_url", this.aEa);
                jSONObject.put("msg_hls_pull_internal_in_second", this.aEb);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.tbs = jSONObject.optString("tbs");
            this.mRoomId = jSONObject.optLong("room_id");
            JSONObject optJSONObject = jSONObject.optJSONObject(Constants.EXTRA_CAST_IDS);
            if (optJSONObject != null) {
                this.mCastIds = new a();
                this.mCastIds.parseJson(optJSONObject);
            }
        }
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tbs", this.tbs);
            jSONObject.put("room_id", this.mRoomId);
            if (this.mCastIds != null) {
                jSONObject.put(Constants.EXTRA_CAST_IDS, this.mCastIds.toJsonObject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
