package com.baidu.rtc.signalling.play;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.Logging;
/* loaded from: classes4.dex */
public class RemoteSdpResponse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RemoteSdpRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String appId;
    public String feed;
    public String remoteHandleId;
    public String roomId;
    public String roomName;
    public String sdp;
    public String sessionId;
    public String userId;

    public RemoteSdpResponse() {
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

    public static RemoteSdpResponse newFromJsonStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            RemoteSdpResponse remoteSdpResponse = new RemoteSdpResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                remoteSdpResponse.sdp = jSONObject.optString("sdp");
                remoteSdpResponse.remoteHandleId = jSONObject.optString("handleid");
                remoteSdpResponse.sessionId = jSONObject.optString(BaseStatisContent.SESSIONID);
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
                remoteSdpResponse.appId = jSONObject2.optString("appid");
                remoteSdpResponse.roomId = jSONObject2.optString("room");
                remoteSdpResponse.roomName = jSONObject2.optString("roomname");
                remoteSdpResponse.userId = jSONObject2.optString("id");
                remoteSdpResponse.feed = jSONObject2.optString(ExternalTransferSpeedStats.FEED_PAGE);
            } catch (JSONException e2) {
                Logging.e("RemoteSdpRequest", "Caught error while play response parse" + e2.getMessage());
            }
            return remoteSdpResponse;
        }
        return (RemoteSdpResponse) invokeL.objValue;
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : (String) invokeV.objValue;
    }

    public String getFeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.feed : (String) invokeV.objValue;
    }

    public String getRemoteHandleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.remoteHandleId : (String) invokeV.objValue;
    }

    public String getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.roomId : (String) invokeV.objValue;
    }

    public String getRoomName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.roomName : (String) invokeV.objValue;
    }

    public String getSdp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sdp : (String) invokeV.objValue;
    }

    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.sessionId : (String) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.userId : (String) invokeV.objValue;
    }
}
