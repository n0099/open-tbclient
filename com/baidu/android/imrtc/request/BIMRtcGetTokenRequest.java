package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.Utility;
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
/* loaded from: classes9.dex */
public class BIMRtcGetTokenRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BIMRtcGetTokenRequest";
    public static char[] hexDigits;
    public transient /* synthetic */ FieldHolder $fh;
    public BIMRtcTokenListener mListener;
    public String mRtcRoomId;
    public long mRtcUserId;
    public String mSource;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-679240342, "Lcom/baidu/android/imrtc/request/BIMRtcGetTokenRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-679240342, "Lcom/baidu/android/imrtc/request/BIMRtcGetTokenRequest;");
                return;
            }
        }
        hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public BIMRtcGetTokenRequest(Context context, String str, String str2, long j2, BIMRtcTokenListener bIMRtcTokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, Long.valueOf(j2), bIMRtcTokenListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSource = "";
        this.mRtcRoomId = "";
        this.mRtcUserId = -1L;
        this.mContext = context;
        this.mListener = bIMRtcTokenListener;
        this.mSource = str;
        this.mRtcRoomId = str2;
        this.mRtcUserId = j2;
    }

    public static String byte2Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                char[] cArr = hexDigits;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private String getMd5(String str) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            hashMap.put("Cookie", "BDUSS=" + bduss);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.BaseHttpRequest, com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0) != 0) {
                return "http://rd-im-server.bcc-szth.baidu.com:8080/rtc/rest/1.0/room/get_rtc_token";
            }
            return "https://pim.baidu.com/rtc/rest/1.0/room/get_rtc_token";
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
                int sDKVersionValue = IMConfigInternal.getInstance().getSDKVersionValue(this.mContext);
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appId);
                jSONObject.put("room_id", this.mRtcRoomId);
                RtcUtility.setRtcRoomId(this.mContext, this.mRtcRoomId);
                jSONObject.put(RtcUtility.KEY_RTC_USER_ID, this.mRtcUserId);
                RtcUtility.setRtcUserId(this.mContext, this.mRtcUserId);
                jSONObject.put("shoubai_uk", IMJni.transBDUID(Utility.readUid(this.mContext)));
                jSONObject.put("rtc_device_id", cuid);
                jSONObject.put("sdk_version", sDKVersionValue);
                jSONObject.put("signal_sdk_version", 103050L);
                jSONObject.put("unique_key", "" + currentTimeMillis);
                jSONObject.put("source", this.mSource);
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, currentTimeMillis);
                jSONObject.put("sign", getMd5("imrtc:" + appId + currentTimeMillis + uk));
                StringBuilder sb = new StringBuilder();
                sb.append("RtcGetTokenRequest msg :");
                sb.append(jSONObject.toString());
                LogUtils.d(TAG, sb.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception unused) {
                return new byte[0];
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || this.mListener == null) {
            return;
        }
        report(-11, i2);
        this.mListener.onResult(i2, str, new BIMRtcTokenListener.BIMRTCGetTokeResult());
        trackRequest(i2, "room/get_rtc_token");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.imrtc.request.HttpExecutor.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(byte[] bArr) {
        JSONException jSONException;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bArr) == null) {
            String str4 = "";
            String str5 = new String(bArr);
            LogUtils.e(TAG, "onSuccess :" + str5);
            int i2 = -1;
            try {
                JSONObject jSONObject = new JSONObject(str5);
                int optInt = jSONObject.optInt("error_code", -1);
                str2 = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                str3 = jSONObject.optString(RtcUtility.KEY_RTC_ROOM_TOKEN, "");
                try {
                    RtcUtility.setRtcRoomToken(this.mContext, str3);
                    str4 = jSONObject.optString("rtc_appid", "");
                    RtcUtility.setRtcAppId(this.mContext, str4);
                    i2 = optInt;
                } catch (JSONException e2) {
                    jSONException = e2;
                    str = str4;
                    str4 = str3;
                    LogUtils.e(TAG, "JSONException", jSONException);
                    str2 = "ERROR_MSG_JSON_PARSE_EXCEPTION";
                    str3 = str4;
                    str4 = str;
                    if (this.mListener == null) {
                    }
                }
            } catch (JSONException e3) {
                jSONException = e3;
                str = "";
            }
            if (this.mListener == null) {
                BIMRtcTokenListener.BIMRTCGetTokeResult bIMRTCGetTokeResult = new BIMRtcTokenListener.BIMRTCGetTokeResult();
                bIMRTCGetTokeResult.roomId = this.mRtcRoomId;
                bIMRTCGetTokeResult.useId = this.mRtcUserId;
                bIMRTCGetTokeResult.token = str3;
                bIMRTCGetTokeResult.rtcAppId = str4;
                report(-11, i2);
                this.mListener.onResult(i2, str2, bIMRTCGetTokeResult);
                trackRequest(i2, "room/get_rtc_token");
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
}
