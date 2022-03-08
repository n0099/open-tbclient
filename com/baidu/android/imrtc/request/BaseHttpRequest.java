package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.request.HttpExecutor;
import com.baidu.android.imrtc.upload.BIMRtcTrack;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class BaseHttpRequest implements HttpExecutor.HttpRequest, HttpExecutor.ResponseHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mRtcRoomId;

    public BaseHttpRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRtcRoomId = "";
    }

    private String trackExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_id", RtcUtility.getAppId(this.mContext));
                jSONObject.put("room_id", this.mRtcRoomId);
                jSONObject.put("uk", Utility.getUK(this.mContext));
                jSONObject.put("cseq_id", -1);
                jSONObject.put("sseq_id", -1);
                jSONObject.put(ShaderParams.VALUE_TYPE_STEP, "c_client_response");
                jSONObject.put("ext", "-1");
                return jSONObject.toString();
            } catch (Exception unused) {
                return "trackExt Exception";
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public abstract Map<String, String> getHeaders();

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public abstract String getHost();

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    public void report(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || BIMRtcManager.mBIMRtcEvent == null) {
            return;
        }
        BIMRtcManager.mBIMRtcEvent.sdkAction = i2;
        BIMRtcManager.mBIMRtcEvent.sdkRoomId = i3 == 0 ? this.mRtcRoomId : StatHelper.SENSOR_ERR_2;
        BIMRtcManager.mBIMRtcEvent.sdkSeqId = i3;
    }

    public void trackRequest(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, str) == null) {
            new BIMRtcTrack.RequestBuilder(this.mContext).method(str).requestId(str).requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).aliasId(501210L).errorCode(i2).ext(trackExt()).build();
        }
    }
}
