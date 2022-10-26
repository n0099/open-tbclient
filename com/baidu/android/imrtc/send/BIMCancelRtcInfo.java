package com.baidu.android.imrtc.send;

import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMCancelRtcInfo extends BIMRtcInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMCancelRtcInfo";
    public transient /* synthetic */ FieldHolder $fh;
    public List mCancelUsers;

    /* loaded from: classes.dex */
    public class BIMCancelUser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long appId;
        public String cuid;
        public String thirdUserId;
        public long uk;

        public BIMCancelUser() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public BIMCancelRtcInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCancelUsers = new ArrayList();
    }

    public List getBIMCancelUsers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCancelUsers;
        }
        return (List) invokeV.objValue;
    }

    public BIMCancelRtcInfo(BIMRtcInfo bIMRtcInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bIMRtcInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCancelUsers = new ArrayList();
        setAction(bIMRtcInfo.getAction());
        setRtcRoomId(bIMRtcInfo.getRtcRoomId());
        setRtcExt(bIMRtcInfo.getRtcExt());
        setRtcDeviceId(bIMRtcInfo.getRtcDeviceId());
    }

    public void setBIMCancelUsers(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.mCancelUsers.clear();
            this.mCancelUsers.addAll(list);
        }
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public BIMRtcInfo toRtcInfo(int i, String str, String str2) {
        InterceptResult invokeILL;
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2)) == null) {
            BIMCancelRtcInfo bIMCancelRtcInfo = new BIMCancelRtcInfo(super.toRtcInfo(i, str, str2));
            try {
                optJSONArray = new JSONObject(str2).optJSONArray("user_list");
            } catch (Exception e) {
                LogUtils.e(TAG, "BBIMCancelRtcInfo toRtcInfo Exception ", e);
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
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
            return bIMCancelRtcInfo;
        }
        return (BIMRtcInfo) invokeILL.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toRtcInfoString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.BIMRtcInfo
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "BBIMCancelRtcInfo{" + super.toString() + ", mCancelUsers=" + this.mCancelUsers.size() + '}';
        }
        return (String) invokeV.objValue;
    }
}
