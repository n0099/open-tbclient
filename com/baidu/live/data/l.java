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
        public String aqq;
        public String aqr;
        public String aqs;
        public String aqt;
        public String aqu;
        public String aqv;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aqq = jSONObject.optString("chat_mcast_id");
                this.aqr = jSONObject.optString("ensure_mcast_id");
                this.aqs = jSONObject.optString("chat_msg_hls_url");
                this.aqt = jSONObject.optString("host_msg_hls_url");
                this.aqu = jSONObject.optString("reliable_msg_hls_url");
                this.aqv = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.aqq);
                jSONObject.put("ensure_mcast_id", this.aqr);
                jSONObject.put("chat_msg_hls_url", this.aqs);
                jSONObject.put("host_msg_hls_url", this.aqt);
                jSONObject.put("reliable_msg_hls_url", this.aqu);
                jSONObject.put("msg_hls_pull_internal_in_second", this.aqv);
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
