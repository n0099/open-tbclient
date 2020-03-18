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
        public String Yh;
        public String Yi;
        public String Yj;
        public String Yk;
        public String Yl;
        public String Ym;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.Yh = jSONObject.optString("chat_mcast_id");
                this.Yi = jSONObject.optString("ensure_mcast_id");
                this.Yj = jSONObject.optString("chat_msg_hls_url");
                this.Yk = jSONObject.optString("host_msg_hls_url");
                this.Yl = jSONObject.optString("reliable_msg_hls_url");
                this.Ym = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("chat_mcast_id", this.Yh);
                jSONObject.put("ensure_mcast_id", this.Yi);
                jSONObject.put("chat_msg_hls_url", this.Yj);
                jSONObject.put("host_msg_hls_url", this.Yk);
                jSONObject.put("reliable_msg_hls_url", this.Yl);
                jSONObject.put("msg_hls_pull_internal_in_second", this.Ym);
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
