package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.CapsuleDataInfo;
import com.baidu.android.imsdk.chatmessage.IMGetBottomMenuListener;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBManualMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMGetBottomMenuRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchBottomMenuRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public final String mKey;
    public final long mOwnerId;
    public final int mOwnerType;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMGetBottomMenuRequest(Context context, String str, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Long.valueOf(j), Integer.valueOf(i)};
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
        this.mKey = str;
        this.mOwnerId = j;
        this.mOwnerType = i;
    }

    private List<CapsuleDataInfo> parseMenuArray(JSONArray jSONArray, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{jSONArray, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                CapsuleDataInfo capsuleDataInfo = new CapsuleDataInfo();
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    capsuleDataInfo.setVersion(j);
                    capsuleDataInfo.setButtonPos(String.valueOf(i2 + 1));
                    capsuleDataInfo.setName(jSONObject.getString("name"));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("act");
                    capsuleDataInfo.setActionType(jSONObject2.getInt("act_type"));
                    capsuleDataInfo.setActionValue(jSONObject2.getString("value"));
                    capsuleDataInfo.setCallbackStr(jSONObject2.getString(DuPaBManualMsg.B_CALLBACK_KEY));
                    capsuleDataInfo.setDayIconUrl(jSONObject2.optString("light_icon"));
                    capsuleDataInfo.setNightIconUrl(jSONObject2.optString("dark_icon"));
                } catch (JSONException e) {
                    LogUtils.d(TAG, e.getMessage());
                }
                arrayList.add(capsuleDataInfo);
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            hashMap.put("Cookie", "BDUSS=" + bduss);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            String str = "https://pim.baidu.com/";
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData == 3) {
                            str = Constants.URL_HTTP_BOX;
                        }
                    } else {
                        str = Constants.URL_HTTP_QA;
                    }
                } else {
                    str = "http://rd-im-server.bcc-szth.baidu.com:8080/";
                }
            }
            return str + "rest/3.0/im/get_menu_client";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("owner_id", this.mOwnerId);
                jSONObject.put("owner_type", this.mOwnerType);
                jSONObject.put("menus", "capsule");
                jSONObject.put(HttpConstants.DEVICE_TYPE, 1);
                jSONObject.put("cuid", BIMManager.getCuid(this.mContext));
                jSONObject.put("app_version", BIMManager.getAppVersion(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            LogUtils.d(TAG, "getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "errorCode = " + i + ", result is " + str);
            ListenerManager.getInstance().removeListener(this.mKey);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "errorCode = " + i + ", result is " + str);
            List<CapsuleDataInfo> list = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.getInt("error_code");
                if (i == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("capsule_menu_info");
                    long optLong = jSONObject2.optLong("version");
                    JSONArray jSONArray = jSONObject2.getJSONArray("capsule_menu");
                    list = parseMenuArray(jSONArray, jSONArray.length(), optLong);
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, e.getMessage());
            }
            IMGetBottomMenuListener iMGetBottomMenuListener = (IMGetBottomMenuListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (list != null && list.size() > 0 && iMGetBottomMenuListener != null) {
                iMGetBottomMenuListener.onFetchBottomMenuResult(i, list);
            }
        }
    }
}
