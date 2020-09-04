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
        public String aDY;
        public String aDZ;
        public String aEa;
        public String aEb;
        public String aEc;
        public String aEd;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.aDY = jSONObject.optString("chat_mcast_id");
                this.aDZ = jSONObject.optString("ensure_mcast_id");
                this.aEa = jSONObject.optString("chat_msg_hls_url");
                this.aEb = jSONObject.optString("host_msg_hls_url");
                this.aEc = jSONObject.optString("reliable_msg_hls_url");
                this.aEd = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.aDY);
                jSONObject.put("ensure_mcast_id", this.aDZ);
                jSONObject.put("chat_msg_hls_url", this.aEa);
                jSONObject.put("host_msg_hls_url", this.aEb);
                jSONObject.put("reliable_msg_hls_url", this.aEc);
                jSONObject.put("msg_hls_pull_internal_in_second", this.aEd);
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
