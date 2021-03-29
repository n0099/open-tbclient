package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMFetchStateRtcInfo extends BIMRtcInfo {
    public static final String TAG = "BIMFetchStateRtcInfo";
    public List<UserState> mUkStates;
    public String roomStateMsg;

    /* loaded from: classes.dex */
    public class UserState {
        public int status;
        public long uk;

        public UserState(long j, int i) {
            this.uk = j;
            this.status = i;
        }
    }

    public BIMFetchStateRtcInfo(String str) {
        ArrayList arrayList = new ArrayList();
        this.mUkStates = arrayList;
        try {
            this.roomStateMsg = str;
            arrayList.clear();
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("msg");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.opt(i);
                    this.mUkStates.add(new UserState(jSONObject.optLong("uk"), jSONObject.optInt("status")));
                }
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMFetchStateRtcInfo Exception:", e2);
        }
    }

    public List<UserState> getInviteUsers() {
        return this.mUkStates;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        BIMRtcInfo rtcInfo = super.toRtcInfo(i, str, str2);
        setAction(rtcInfo.getAction());
        setRtcRoomId(rtcInfo.getRtcRoomId());
        setRtcExt(rtcInfo.getRtcExt());
        setRtcDeviceId(rtcInfo.getRtcDeviceId());
        return this;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        return "BIMFetchStateRtcInfo{" + super.toString() + "roomStateMsg=" + this.roomStateMsg + '}';
    }
}
