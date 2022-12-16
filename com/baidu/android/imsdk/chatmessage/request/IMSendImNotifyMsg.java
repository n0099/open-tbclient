package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.chatmessage.IStatusNotifyListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMSendImNotifyMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSendImNotifyMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBusinessType;
    public int mCategory;
    public long mContacterUk;
    public Context mContext;
    public String mMsgExt;
    public int mNotifyType;
    public int mSessionType;

    public IMSendImNotifyMsg(Context context, int i, long j, int i2, int i3, String str, int i4, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initCommonParameter(context);
        this.mContext = context;
        setType(Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG);
        this.mNotifyType = i;
        this.mContacterUk = j;
        this.mBusinessType = i2;
        this.mSessionType = i3;
        this.mMsgExt = str;
        this.mCategory = i4;
        setNeedReplay(true);
        setListenerKey(str2);
    }

    public static IMSendImNotifyMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra(Constants.EXTRA_BUSINESS_TYPE) && intent.hasExtra("session_type") && intent.hasExtra("notify_type")) {
                return new IMSendImNotifyMsg(context, intent.getIntExtra("notify_type", -1), intent.getLongExtra("contacter", -1L), intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1), intent.getIntExtra("session_type", -1), intent.getStringExtra(Constants.EXTRA_BUSINESS_MSG_EXT), intent.getIntExtra("category", 0), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
            return null;
        }
        return (IMSendImNotifyMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", Constants.METHOD_IM_CONSULT_IM_UPDATE_MSG);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("contacter_uk", this.mContacterUk);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("session_type", this.mSessionType);
                jSONObject.put("im_notify_type", this.mNotifyType);
                jSONObject.put(Constants.EXTRA_BUSINESS_MSG_EXT, this.mMsgExt);
                jSONObject.put("category", this.mCategory);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "发送自定义通知消息 body = " + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            LogUtils.d(TAG, "handleMessageResult err : " + i + ", msg :" + str + " result = " + jSONObject);
            super.handleMessageResult(context, jSONObject, i, str);
            if (jSONObject != null) {
                i2 = jSONObject.optInt(PmsConstant.Statistic.STATISTIC_ERRCODE);
            } else {
                i2 = 0;
            }
            IMListener removeListener = ListenerManager.getInstance().removeListener(getListenerKey());
            if (removeListener instanceof IStatusNotifyListener) {
                ((IStatusNotifyListener) removeListener).onResult(i2, str);
            }
        }
    }
}
