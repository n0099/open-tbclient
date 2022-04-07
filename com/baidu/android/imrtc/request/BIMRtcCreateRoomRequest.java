package com.baidu.android.imrtc.request;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BIMRtcCreateRoomRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMRtcCreateRoomRequest";
    public static char[] hexDigits;
    public transient /* synthetic */ FieldHolder $fh;
    public BIMRtcTokenListener mListener;
    public String mResourceId;
    public String mSource;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185362338, "Lcom/baidu/android/imrtc/request/BIMRtcCreateRoomRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185362338, "Lcom/baidu/android/imrtc/request/BIMRtcCreateRoomRequest;");
                return;
            }
        }
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public BIMRtcCreateRoomRequest(Context context, String str, BIMRtcTokenListener bIMRtcTokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, bIMRtcTokenListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
    }

    public static String byte2Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                char[] cArr = hexDigits;
                char c = cArr[(b & 240) >> 4];
                char c2 = cArr[b & 15];
                sb.append(c);
                sb.append(c2);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return byte2Hex(messageDigest.digest());
        }
        return (String) invokeL.objValue;
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
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rtc/rest/1.0/room/create";
            }
            return "https://pim.baidu.com/rtc/rest/1.0/room/create";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                long appId = RtcUtility.getAppId(this.mContext);
                String cuid = RtcUtility.getCuid(this.mContext);
                long uk = Utility.getUK(this.mContext);
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appId);
                jSONObject.put("shoubai_uk", IMJni.transBDUID(Utility.readUid(this.mContext)));
                jSONObject.put("uk", uk);
                jSONObject.put("rtc_device_id", cuid);
                jSONObject.put("sdk_version", "" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("signal_sdk_version", 103050L);
                jSONObject.put("unique_key", "" + currentTimeMillis);
                jSONObject.put("source", this.mSource);
                jSONObject.put(TiebaStatic.Params.RESOURCE_ID, this.mResourceId);
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
                jSONObject.put("sign", getMd5("imrtc:" + appId + currentTimeMillis + uk));
                StringBuilder sb = new StringBuilder();
                sb.append("RtcGetTokenRequest msg :");
                sb.append(jSONObject.toString());
                LogUtils.d(TAG, sb.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception e) {
                LogUtils.e(TAG, "RtcGetTokenRequest exception :", e);
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || this.mListener == null) {
            return;
        }
        report(-10, i);
        this.mListener.onResult(i, str, new BIMRtcTokenListener.BIMRTCGetTokeResult());
        trackRequest(i, "room/create");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(byte[] bArr) {
        long j;
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            String str4 = "";
            String str5 = new String(bArr);
            LogUtils.e(TAG, "onSuccess :" + str5);
            int i = -1;
            long j2 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str5);
                int optInt = jSONObject.optInt("error_code", -1);
                str2 = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                j2 = jSONObject.optLong("rtc_userid", -1L);
                RtcUtility.setRtcUserId(this.mContext, j2);
                String optString = jSONObject.optString("rtc_room_id", "");
                this.mRtcRoomId = optString;
                RtcUtility.setRtcRoomId(this.mContext, optString);
                str3 = jSONObject.optString(RtcUtility.KEY_RTC_ROOM_TOKEN, "");
                try {
                    RtcUtility.setRtcRoomToken(this.mContext, str3);
                    str4 = jSONObject.optString("rtc_appid", "");
                    RtcUtility.setRtcAppId(this.mContext, str4);
                    i = optInt;
                } catch (JSONException e) {
                    j = j2;
                    jSONException = e;
                    str = str4;
                    str4 = str3;
                    LogUtils.e(TAG, "JSONException", jSONException);
                    str2 = "ERROR_MSG_JSON_PARSE_EXCEPTION";
                    str3 = str4;
                    str4 = str;
                    j2 = j;
                    if (this.mListener == null) {
                    }
                }
            } catch (JSONException e2) {
                j = j2;
                jSONException = e2;
                str = "";
            }
            if (this.mListener == null) {
                BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult = new BIMRtcTokenListener.BIMRTCGetTokeResult();
                bIMRTCGetTokeResult.roomId = this.mRtcRoomId;
                bIMRTCGetTokeResult.useId = j2;
                bIMRTCGetTokeResult.token = str3;
                bIMRTCGetTokeResult.rtcAppId = str4;
                report(-10, i);
                this.mListener.onResult(i, str2, bIMRTCGetTokeResult);
                trackRequest(i, "room/create");
            }
        }
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public BIMRtcCreateRoomRequest(Context context, String str, String str2, BIMRtcTokenListener bIMRtcTokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, bIMRtcTokenListener};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
        this.mResourceId = str2;
    }
}
