package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class o {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes3.dex */
    public static class a {
        public String axB;
        public String axC;
        public String axD;
        public String axE;
        public String axF;
        public String axG;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.axB = jSONObject.optString("chat_mcast_id");
                this.axC = jSONObject.optString("ensure_mcast_id");
                this.axD = jSONObject.optString("chat_msg_hls_url");
                this.axE = jSONObject.optString("host_msg_hls_url");
                this.axF = jSONObject.optString("reliable_msg_hls_url");
                this.axG = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.axB);
                jSONObject.put("ensure_mcast_id", this.axC);
                jSONObject.put("chat_msg_hls_url", this.axD);
                jSONObject.put("host_msg_hls_url", this.axE);
                jSONObject.put("reliable_msg_hls_url", this.axF);
                jSONObject.put("msg_hls_pull_internal_in_second", this.axG);
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
