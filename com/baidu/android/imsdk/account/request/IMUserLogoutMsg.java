package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.ubc.MessageUbc;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUserLogoutMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMUserLogoutMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public String mDeviceId;
    public JSONArray mEventList;
    public final long mLoginId;

    public IMUserLogoutMsg(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initCommonParameter(context);
        this.mContext = context;
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(52);
        this.mLoginId = AccountManagerImpl.getInstance(context).getLoginId();
    }

    public static IMUserLogoutMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            IMUserLogoutMsg iMUserLogoutMsg = new IMUserLogoutMsg(context);
            iMUserLogoutMsg.parseEventList(intent.getStringExtra("event_list"));
            return iMUserLogoutMsg;
        }
        return (IMUserLogoutMsg) invokeLL.objValue;
    }

    private void parseEventList(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            try {
                this.mEventList = new JSONArray(str);
            } catch (Exception e) {
                LogUtils.e(TAG, "setEventList Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 52);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("device_id", this.mDeviceId);
                jSONObject.put(Constants.KEY_TRIGGER_ID, Utility.getTriggerId(this.mContext));
                jSONObject.put(Constants.EXTRA_LOGIN_ID, this.mLoginId);
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            String listenerKey = getListenerKey();
            Utility.logout(context, listenerKey, "logout :" + i);
            LogUtils.d(TAG, "handleMessageResult eventList :" + getEventList() + "， obj :" + jSONObject);
            try {
                JSONObject jSONObject2 = new JSONObject(getEventList());
                if (jSONObject2.has("event_list") && (optJSONArray = jSONObject2.optJSONArray("event_list")) != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject3 = new JSONObject(optJSONArray.get(i2).toString());
                        String optString = jSONObject3.optString("event");
                        if (optString.contains("CLCP")) {
                            jSONObject3.put("event", optString.replace("CLCP", "CNet"));
                        }
                        this.mEventList.put(jSONObject3);
                    }
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "logout event_list JSONException:" + e.getMessage());
            }
            Utility.addEventListMs(this.mEventList, "CIMResEnd");
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("event_list", this.mEventList);
                LogUtils.d(TAG, "logout final eventList :" + jSONObject4);
            } catch (Exception e2) {
                LogUtils.e(TAG, "logout final eventList JSONException:" + e2.getMessage());
            }
            if (!AccountManagerImpl.getInstance(this.mContext).isLogoutUpload()) {
                return;
            }
            MessageUbc.DebugInfo debugInfo = new MessageUbc.DebugInfo();
            debugInfo.methodId = 52L;
            debugInfo.eventList = jSONObject4.toString();
            debugInfo.loginId = this.mLoginId;
            debugInfo.protocolType = BIMManager.getProtocolType().toUpperCase();
            MessageUbc.uploadUbc(context, i, str, debugInfo);
        }
    }
}
