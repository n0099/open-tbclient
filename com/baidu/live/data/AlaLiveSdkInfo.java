package com.baidu.live.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveSdkInfo implements Serializable {
    public MCastIds mCastIds;
    public long mRoomId;
    public String tbs;

    /* loaded from: classes4.dex */
    public static class MCastIds implements Serializable {
        public String chatMCastId;
        public String chat_msg_hls_url;
        public String ensureMCastId;
        public String host_msg_hls_url;
        public String msg_hls_pull_internal_in_second;
        public String reliable_msg_hls_url;

        public void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.chatMCastId = jSONObject.optString(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID);
                this.ensureMCastId = jSONObject.optString("ensure_mcast_id");
                this.chat_msg_hls_url = jSONObject.optString("chat_msg_hls_url");
                this.host_msg_hls_url = jSONObject.optString("host_msg_hls_url");
                this.reliable_msg_hls_url = jSONObject.optString("reliable_msg_hls_url");
                this.msg_hls_pull_internal_in_second = jSONObject.optString("msg_hls_pull_internal_in_second");
            }
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.chatMCastId);
                jSONObject.put("ensure_mcast_id", this.ensureMCastId);
                jSONObject.put("chat_msg_hls_url", this.chat_msg_hls_url);
                jSONObject.put("host_msg_hls_url", this.host_msg_hls_url);
                jSONObject.put("reliable_msg_hls_url", this.reliable_msg_hls_url);
                jSONObject.put("msg_hls_pull_internal_in_second", this.msg_hls_pull_internal_in_second);
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
                this.mCastIds = new MCastIds();
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
