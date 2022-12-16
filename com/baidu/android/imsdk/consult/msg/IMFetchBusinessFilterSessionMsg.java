package com.baidu.android.imsdk.consult.msg;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.consult.AdvisoryFilterSessionTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMFetchBusinessFilterSessionMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMFetchBusinessFilterSessionMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public final long mBeginTime;
    public final int mBusinessType;
    public final int mCategory;
    public final Context mContext;
    public final int mCount;
    public final long mEndTime;
    public final String mFilters;

    public IMFetchBusinessFilterSessionMsg(Context context, int i, long j, long j2, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCategory = 9;
        this.mContext = context;
        initCommonParameter(context);
        this.mBeginTime = j;
        this.mEndTime = j2;
        this.mBusinessType = i;
        this.mCount = i2;
        this.mFilters = str;
        setListenerKey(str2);
    }

    private String buildAdvisoryRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            String str = null;
            try {
                jSONObject.put("method", Constants.METHOD_IM_CONSULT_IM_FILTER_SESSION_MSG);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("business_type", this.mBusinessType);
                jSONObject.put("category", 9);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("sort_update_time_us_begin", this.mBeginTime);
                jSONObject.put("sort_update_time_us_end", this.mEndTime);
                jSONObject.put("count", this.mCount);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                jSONObject.put("filter_control", this.mFilters);
                str = jSONObject.toString();
                LogUtils.d(TAG, "拉取咨询会话" + str);
                return str;
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
                return str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static IMFetchBusinessFilterSessionMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            if (intent.hasExtra("count") && intent.hasExtra(Constants.EXTRA_BUSINESS_TYPE)) {
                int intExtra = intent.getIntExtra("count", -1);
                return new IMFetchBusinessFilterSessionMsg(context, intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1), intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L), intent.getLongExtra(Constants.EXTRA_END_MSGID, -1L), intExtra, intent.getStringExtra(Constants.EXTRA_BUSINESS_FILTER_INFO), intent.getStringExtra(Constants.EXTRA_LISTENER_ID));
            }
            return null;
        }
        return (IMFetchBusinessFilterSessionMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mBody = buildAdvisoryRequestParam();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            LogUtils.d(TAG, "handleMessageResult err : " + i + ", msg :" + str + " result = " + jSONObject);
            super.handleMessageResult(context, jSONObject, i, str);
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            TaskManager.getInstance(this.mContext).submitForNetWork(new AdvisoryFilterSessionTask(context, jSONObject2, getListenerKey(), 9, this.mBusinessType));
        }
    }
}
