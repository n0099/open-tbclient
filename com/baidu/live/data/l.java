package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class l {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes3.dex */
    public static class a {
        public String aqA;
        public String aqB;
        public String aqw;
        public String aqx;
        public String aqy;
        public String aqz;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aqw = jSONObject.optString("chat_mcast_id");
                this.aqx = jSONObject.optString("ensure_mcast_id");
                this.aqy = jSONObject.optString("chat_msg_hls_url");
                this.aqz = jSONObject.optString("host_msg_hls_url");
                this.aqA = jSONObject.optString("reliable_msg_hls_url");
                this.aqB = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.aqw);
                jSONObject.put("ensure_mcast_id", this.aqx);
                jSONObject.put("chat_msg_hls_url", this.aqy);
                jSONObject.put("host_msg_hls_url", this.aqz);
                jSONObject.put("reliable_msg_hls_url", this.aqA);
                jSONObject.put("msg_hls_pull_internal_in_second", this.aqB);
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
