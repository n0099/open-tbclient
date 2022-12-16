package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUserLogoutMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mClearAfterLogout;
    public Context mContext;
    public String mDeviceId;

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
        this.mContext = context;
        initCommonParameter(context);
        this.mDeviceId = Utility.getIMDeviceId(context);
        setNeedReplay(true);
        setType(52);
    }

    public static IMUserLogoutMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            new IMUserLogoutMsg(context).setClearAfterLogout(intent.getIntExtra(Constants.EXTRA_CLEAR_AFTER_LOGOUT, 0));
            return new IMUserLogoutMsg(context);
        }
        return (IMUserLogoutMsg) invokeLL.objValue;
    }

    private void setClearAfterLogout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            this.mClearAfterLogout = i;
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
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(IMUserLogoutMsg.class.getSimpleName(), "Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            String listenerKey = getListenerKey();
            Utility.logout(context, listenerKey, "logout :" + i);
        }
    }
}
