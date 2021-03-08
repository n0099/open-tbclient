package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BIMFetchStateRtcInfo extends BIMRtcInfo {
    private static final String TAG = "BIMFetchStateRtcInfo";
    private List<UserState> mUkStates = new ArrayList();
    private String roomStateMsg;

    public List<UserState> getInviteUsers() {
        return this.mUkStates;
    }

    /* loaded from: classes3.dex */
    class UserState {
        public int status;
        public long uk;

        public UserState(long j, int i) {
            this.uk = j;
            this.status = i;
        }
    }

    public BIMFetchStateRtcInfo(String str) {
        try {
            this.roomStateMsg = str;
            this.mUkStates.clear();
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("msg");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject = (JSONObject) optJSONArray.opt(i2);
                        this.mUkStates.add(new UserState(jSONObject.optLong("uk"), jSONObject.optInt("status")));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "BIMFetchStateRtcInfo Exception:", e);
        }
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
