package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes2.dex */
    public static class a {
        public String Wm;
        public String Wn;
        public String Wo;
        public String Wp;
        public String Wq;
        public String Wr;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.Wm = jSONObject.optString("chat_mcast_id");
                this.Wn = jSONObject.optString("ensure_mcast_id");
                this.Wo = jSONObject.optString("chat_msg_hls_url");
                this.Wp = jSONObject.optString("host_msg_hls_url");
                this.Wq = jSONObject.optString("reliable_msg_hls_url");
                this.Wr = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.Wm);
                jSONObject.put("ensure_mcast_id", this.Wn);
                jSONObject.put("chat_msg_hls_url", this.Wo);
                jSONObject.put("host_msg_hls_url", this.Wp);
                jSONObject.put("reliable_msg_hls_url", this.Wq);
                jSONObject.put("msg_hls_pull_internal_in_second", this.Wr);
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
            JSONObject optJSONObject = jSONObject.optJSONObject("mcast_ids");
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
                jSONObject.put("mcast_ids", this.mCastIds.toJsonObject());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
