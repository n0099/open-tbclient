package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public a mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes3.dex */
    public static class a {
        public String XX;
        public String XY;
        public String XZ;
        public String Ya;
        public String Yb;
        public String Yc;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.XX = jSONObject.optString("chat_mcast_id");
                this.XY = jSONObject.optString("ensure_mcast_id");
                this.XZ = jSONObject.optString("chat_msg_hls_url");
                this.Ya = jSONObject.optString("host_msg_hls_url");
                this.Yb = jSONObject.optString("reliable_msg_hls_url");
                this.Yc = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.XX);
                jSONObject.put("ensure_mcast_id", this.XY);
                jSONObject.put("chat_msg_hls_url", this.XZ);
                jSONObject.put("host_msg_hls_url", this.Ya);
                jSONObject.put("reliable_msg_hls_url", this.Yb);
                jSONObject.put("msg_hls_pull_internal_in_second", this.Yc);
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
