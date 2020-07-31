package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class o {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes4.dex */
    public static class a {
        public String ayO;
        public String ayP;
        public String ayQ;
        public String ayR;
        public String ayS;
        public String ayT;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.ayO = jSONObject.optString("chat_mcast_id");
                this.ayP = jSONObject.optString("ensure_mcast_id");
                this.ayQ = jSONObject.optString("chat_msg_hls_url");
                this.ayR = jSONObject.optString("host_msg_hls_url");
                this.ayS = jSONObject.optString("reliable_msg_hls_url");
                this.ayT = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.ayO);
                jSONObject.put("ensure_mcast_id", this.ayP);
                jSONObject.put("chat_msg_hls_url", this.ayQ);
                jSONObject.put("host_msg_hls_url", this.ayR);
                jSONObject.put("reliable_msg_hls_url", this.ayS);
                jSONObject.put("msg_hls_pull_internal_in_second", this.ayT);
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
