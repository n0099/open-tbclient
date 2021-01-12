package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BIMInviteSyncRtcInfo extends BIMSyncRtcInfo {
    private static final String TAG = "IMInviteRtcInfo";
    private int mMediaType;
    private String mRtcAppId;
    private String mRtcRoomDes;
    private String mRtcRoomName;
    private String mRtcRoomToken;
    private int mRtcRoomType;
    private long mRtcUserId;

    public String getRtcRoomName() {
        return this.mRtcRoomName;
    }

    public void setRtcRoomName(String str) {
        this.mRtcRoomName = str;
    }

    public String getRtcRoomToken() {
        return this.mRtcRoomToken;
    }

    public void setRtcRoomToken(String str) {
        this.mRtcRoomToken = str;
    }

    public String getRtcAppId() {
        return this.mRtcAppId;
    }

    public void setRtcAppId(String str) {
        this.mRtcAppId = str;
    }

    public String getRtcRoomDes() {
        return this.mRtcRoomDes;
    }

    public void setRtcRoomDes(String str) {
        this.mRtcRoomDes = str;
    }

    public int getRtcRoomType() {
        return this.mRtcRoomType;
    }

    public void setRtcRoomType(int i) {
        this.mRtcRoomType = i;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public void setMediaType(int i) {
        this.mMediaType = i;
    }

    public long getRtcUserId() {
        return this.mRtcUserId;
    }

    public void setRtcUserId(long j) {
        this.mRtcUserId = j;
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rtc_room_name", this.mRtcRoomName);
            jSONObject.put("rtc_room_token", this.mRtcRoomToken);
            jSONObject.put("rtc_room_desc", this.mRtcRoomDes);
            jSONObject.put("rtc_room_type", this.mRtcRoomType);
            jSONObject.put("media_type", this.mMediaType);
            jSONObject.put("uk", this.mInitiatorUk);
            jSONObject.put("invite_id", this.mInviteId);
            jSONObject.put("rtc_userid", this.mRtcUserId);
            jSONObject.put("ext", this.mRtcExt);
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, "IMInviteRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMInviteSyncRtcInfo{" + super.toString() + ", mRtcRoomName='" + this.mRtcRoomName + "', mRtcRoomToken='" + this.mRtcRoomToken + "', mRtcRoomDes='" + this.mRtcRoomDes + "', mRtcRoomType=" + this.mRtcRoomType + ", mMediaType=" + this.mMediaType + ", mInitiatorUk=" + this.mInitiatorUk + ", mInviteId=" + this.mInviteId + ", mRtcUserId=" + this.mRtcUserId + ", ext=" + this.mRtcExt + '}';
    }
}
