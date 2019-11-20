package com.baidu.live.data;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes6.dex */
    public static class a {
        public String Pd;
        public String Pe;
        public String Pf;
        public String Pg;
        public String Ph;
        public String Pi;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.Pd = jSONObject.optString("chat_mcast_id");
                this.Pe = jSONObject.optString("ensure_mcast_id");
                this.Pf = jSONObject.optString("chat_msg_hls_url");
                this.Pg = jSONObject.optString("host_msg_hls_url");
                this.Ph = jSONObject.optString("reliable_msg_hls_url");
                this.Pi = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.Pd);
                jSONObject.put("ensure_mcast_id", this.Pe);
                jSONObject.put("chat_msg_hls_url", this.Pf);
                jSONObject.put("host_msg_hls_url", this.Pg);
                jSONObject.put("reliable_msg_hls_url", this.Ph);
                jSONObject.put("msg_hls_pull_internal_in_second", this.Pi);
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
