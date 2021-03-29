package com.baidu.android.imrtc.notify;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.send.BIMUser;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMKickReqSyncRtcInfo extends BIMSyncRtcInfo {
    public static final String TAG = "BIMKickReqSyncRtcInfo";
    public BIMUser mKickUser = null;
    public BIMUser mKickedUser = null;

    public BIMUser getBIMKickUsers() {
        return this.mKickUser;
    }

    public BIMUser getBIMKickedUsers() {
        return this.mKickedUser;
    }

    public void setBIMKickUser(@NonNull BIMUser bIMUser) {
        this.mKickUser = bIMUser;
    }

    public void setBIMKickedUser(@NonNull BIMUser bIMUser) {
        this.mKickedUser = bIMUser;
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appid", this.mKickUser.appId);
            jSONObject2.put("uk", this.mKickUser.uk);
            jSONObject2.put("cuid", this.mKickUser.cuid);
            jSONObject2.put("third_userid", IMJni.transBDUID(this.mKickUser.thirdUserId));
            jSONObject2.put("app_version", this.mKickUser.appVersion);
            jSONObject.put("kick_user", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("appid", this.mKickedUser.appId);
            jSONObject3.put("uk", this.mKickedUser.uk);
            jSONObject3.put("cuid", this.mKickedUser.cuid);
            jSONObject3.put("third_userid", IMJni.transBDUID(this.mKickedUser.thirdUserId));
            jSONObject3.put("app_version", this.mKickedUser.appVersion);
            jSONObject.put("kicked_user", jSONObject3);
            LogUtils.d(TAG, "BIMKickReqSyncRtcInfo :" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMKickReqSyncRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.notify.BIMSyncRtcInfo, com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMKickReqSyncRtcInfo{" + super.toString() + ", kickUser: uk:" + this.mKickUser.uk + ", appId: " + this.mKickUser.appId + ", cuid:" + this.mKickUser.cuid + ", thirdId: " + this.mKickUser.thirdUserId + ", kickUser: uk:" + this.mKickedUser.uk + ", appId: " + this.mKickedUser.appId + ", cuid:" + this.mKickedUser.cuid + ", thirdId: " + this.mKickedUser.thirdUserId + '}';
    }
}
