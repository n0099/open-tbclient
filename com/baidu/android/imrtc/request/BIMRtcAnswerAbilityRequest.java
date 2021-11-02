package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.request.BIMRtcAnswerAbilityListener;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class BIMRtcAnswerAbilityRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMRtcAnswerAbilityRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public BIMRtcAnswerAbilityListener mListener;
    public String mSource;

    public BIMRtcAnswerAbilityRequest(Context context, String str, String str2, BIMRtcAnswerAbilityListener bIMRtcAnswerAbilityListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, bIMRtcAnswerAbilityListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mListener = bIMRtcAnswerAbilityListener;
        this.mSource = str;
        this.mRtcRoomId = str2;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new HashMap() : (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0) != 0) {
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rtc/rest/1.0/room/check_answer_ability";
            }
            return "https://pim.baidu.com/rtc/rest/1.0/room/check_answer_ability";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long appId = RtcUtility.getAppId(this.mContext);
            long uk = Utility.getUK(this.mContext);
            String cuid = RtcUtility.getCuid(this.mContext);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", appId);
                jSONObject.put("uk", uk);
                jSONObject.put("cuid", cuid);
                jSONObject.put("room_id", this.mRtcRoomId);
                jSONObject.put("source", this.mSource);
                LogUtils.d(TAG, "RtcGetTokenRequest msg :" + jSONObject.toString());
                return jSONObject.toString().getBytes();
            } catch (JSONException e2) {
                LogUtils.e(TAG, "RtcGetTokenRequest exception :", e2);
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) {
            LogUtils.e(TAG, "onFailure : errorCOde = " + i2 + " , errorMsg =  " + str);
            this.mListener.onResult(i2, str, null);
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onSuccess(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            String str = new String(bArr);
            LogUtils.e(TAG, "onSuccess :" + str);
            BIMRtcAnswerAbilityListener.BIMRtcAnswerAbilityResult bIMRtcAnswerAbilityResult = new BIMRtcAnswerAbilityListener.BIMRtcAnswerAbilityResult();
            String str2 = "";
            int i2 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i2 = jSONObject.optInt("error_code");
                str2 = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                JSONObject optJSONObject = jSONObject.optJSONObject("payload");
                bIMRtcAnswerAbilityResult.ability = optJSONObject.optInt("ability");
                bIMRtcAnswerAbilityResult.rtcToken = optJSONObject.optString("token");
                bIMRtcAnswerAbilityResult.rtcAppId = optJSONObject.optString("rtc_appid");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.mListener.onResult(i2, str2, bIMRtcAnswerAbilityResult);
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
