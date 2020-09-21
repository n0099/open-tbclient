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
        public String aEU;
        public String aEV;
        public String aEW;
        public String aEX;
        public String aEY;
        public String aEZ;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aEU = jSONObject.optString("chat_mcast_id");
                this.aEV = jSONObject.optString("ensure_mcast_id");
                this.aEW = jSONObject.optString("chat_msg_hls_url");
                this.aEX = jSONObject.optString("host_msg_hls_url");
                this.aEY = jSONObject.optString("reliable_msg_hls_url");
                this.aEZ = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.aEU);
                jSONObject.put("ensure_mcast_id", this.aEV);
                jSONObject.put("chat_msg_hls_url", this.aEW);
                jSONObject.put("host_msg_hls_url", this.aEX);
                jSONObject.put("reliable_msg_hls_url", this.aEY);
                jSONObject.put("msg_hls_pull_internal_in_second", this.aEZ);
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
