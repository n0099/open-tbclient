package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMKickRequestRtcInfo extends BIMRtcInfo {
    public static final String TAG = "BIMKickRequestRtcInfo";
    public BIMUser mKickUser = null;
    public BIMUser mKickedUser = null;

    public BIMKickRequestRtcInfo() {
    }

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

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        BIMKickRequestRtcInfo bIMKickRequestRtcInfo = new BIMKickRequestRtcInfo(super.toRtcInfo(i2, str, str2));
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject optJSONObject = jSONObject.optJSONObject("kick_user");
            if (optJSONObject != null) {
                BIMUser bIMUser = new BIMUser();
                bIMUser.appId = optJSONObject.optLong("appid");
                bIMUser.uk = optJSONObject.optLong("uk");
                bIMUser.cuid = optJSONObject.optString("cuid");
                bIMUser.thirdUserId = optJSONObject.optString("third_userid");
                bIMKickRequestRtcInfo.setBIMKickUser(bIMUser);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("kicked_user");
            if (optJSONObject2 != null) {
                BIMUser bIMUser2 = new BIMUser();
                bIMUser2.appId = optJSONObject2.optLong("appid");
                bIMUser2.uk = optJSONObject2.optLong("uk");
                bIMUser2.cuid = optJSONObject2.optString("cuid");
                bIMUser2.thirdUserId = optJSONObject2.optString("third_userid");
                bIMKickRequestRtcInfo.setBIMKickedUser(bIMUser2);
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMKickRequestRtcInfo toRtcInfo Exception ", e2);
        }
        return bIMKickRequestRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
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
            LogUtils.d(TAG, "BIMKickRequestRtcInfo :" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMKickRequestRtcInfo Exception ", e2);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMKickRequestRtcInfo{" + super.toString() + ", kickUser: uk:" + this.mKickUser.uk + ", appId: " + this.mKickUser.appId + ", cuid:" + this.mKickUser.cuid + ", thirdId: " + this.mKickUser.thirdUserId + ", kickUser: uk:" + this.mKickedUser.uk + ", appId: " + this.mKickedUser.appId + ", cuid:" + this.mKickedUser.cuid + ", thirdId: " + this.mKickedUser.thirdUserId + '}';
    }

    public BIMKickRequestRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }
}
