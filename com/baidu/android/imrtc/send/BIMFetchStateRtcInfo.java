package com.baidu.android.imrtc.send;

import androidx.annotation.NonNull;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class BIMFetchStateRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMFetchStateRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public List<UserState> mUkStates;
    public String roomStateMsg;

    /* loaded from: classes4.dex */
    public class UserState {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int status;
        public final /* synthetic */ BIMFetchStateRtcInfo this$0;
        public long uk;

        public UserState(BIMFetchStateRtcInfo bIMFetchStateRtcInfo, long j2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bIMFetchStateRtcInfo, Long.valueOf(j2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bIMFetchStateRtcInfo;
            this.uk = j2;
            this.status = i2;
        }
    }

    public BIMFetchStateRtcInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.mUkStates = arrayList;
        try {
            this.roomStateMsg = str;
            arrayList.clear();
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("msg");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.opt(i4);
                    this.mUkStates.add(new UserState(this, jSONObject.optLong("uk"), jSONObject.optInt("status")));
                }
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "BIMFetchStateRtcInfo Exception:", e2);
        }
    }

    public List<UserState> getInviteUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mUkStates : (List) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    @NonNull
    public BIMRtcInfo toRtcInfo(int i2, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2)) == null) {
            BIMRtcInfo rtcInfo = super.toRtcInfo(i2, str, str2);
            setAction(rtcInfo.getAction());
            setRtcRoomId(rtcInfo.getRtcRoomId());
            setRtcExt(rtcInfo.getRtcExt());
            setRtcDeviceId(rtcInfo.getRtcDeviceId());
            return this;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "BIMFetchStateRtcInfo{" + super.toString() + "roomStateMsg=" + this.roomStateMsg + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
