package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class s {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes4.dex */
    public static class a {
        public String aHY;
        public String aHZ;
        public String aIa;
        public String aIb;
        public String aIc;
        public String aId;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aHY = jSONObject.optString("chat_mcast_id");
                this.aHZ = jSONObject.optString("ensure_mcast_id");
                this.aIa = jSONObject.optString("chat_msg_hls_url");
                this.aIb = jSONObject.optString("host_msg_hls_url");
                this.aIc = jSONObject.optString("reliable_msg_hls_url");
                this.aId = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.aHY);
                jSONObject.put("ensure_mcast_id", this.aHZ);
                jSONObject.put("chat_msg_hls_url", this.aIa);
                jSONObject.put("host_msg_hls_url", this.aIb);
                jSONObject.put("reliable_msg_hls_url", this.aIc);
                jSONObject.put("msg_hls_pull_internal_in_second", this.aId);
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
