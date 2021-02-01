package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMCancelRtcInfo extends BIMRtcInfo {
    private static final String TAG = "BIMCancelRtcInfo";
    private List<BIMCancelUser> mCancelUsers = new ArrayList();

    /* loaded from: classes4.dex */
    public static class BIMCancelUser {
        public long appId;
        public String cuid;
        public String thirdUserId;
        public long uk;
    }

    public List<BIMCancelUser> getBIMCancelUsers() {
        return this.mCancelUsers;
    }

    public void setBIMCancelUsers(@NonNull List<BIMCancelUser> list) {
        this.mCancelUsers.clear();
        this.mCancelUsers.addAll(list);
    }

    public BIMCancelRtcInfo() {
    }

    private BIMCancelRtcInfo(BIMRtcInfo bIMRtcInfo) {
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public String toRtcInfoString() {
        try {
            JSONObject jSONObject = new JSONObject(super.toRtcInfoString());
            JSONArray jSONArray = new JSONArray();
            for (BIMCancelUser bIMCancelUser : this.mCancelUsers) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", bIMCancelUser.appId);
                jSONObject2.put("uk", bIMCancelUser.uk);
                jSONObject2.put("cuid", bIMCancelUser.cuid);
                jSONObject2.put("third_userid", IMJni.transBDUID(bIMCancelUser.thirdUserId));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("user_list", jSONArray);
            LogUtils.d(TAG, "BIMCancelRtcInfo :" + jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMCancelRtcInfo Exception ", e);
            return "";
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        JSONArray optJSONArray;
        BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo(super.toRtcInfo(i, str, str2));
        try {
            optJSONArray = new JSONObject(str2).optJSONArray("user_list");
        } catch (Exception e) {
            LogUtils.e(TAG, "BBIMCancelRtcInfo toRtcInfo Exception ", e);
        }
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return bIMCancelRtcInfo;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            BIMCancelUser bIMCancelUser = new BIMCancelUser();
            JSONObject jSONObject = (JSONObject) optJSONArray.opt(i2);
            bIMCancelUser.appId = jSONObject.optLong("appid");
            bIMCancelUser.uk = jSONObject.optLong("uk");
            bIMCancelUser.cuid = jSONObject.optString("cuid");
            bIMCancelUser.thirdUserId = jSONObject.optString("third_userid");
            arrayList.add(bIMCancelUser);
        }
        bIMCancelRtcInfo.setBIMCancelUsers(arrayList);
        return bIMCancelRtcInfo;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BBIMCancelRtcInfo{" + super.toString() + ", mCancelUsers=" + this.mCancelUsers.size() + '}';
    }
}
