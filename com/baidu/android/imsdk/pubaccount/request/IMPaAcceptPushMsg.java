package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaManagerImpl;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
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
public class IMPaAcceptPushMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAcceptPush;
    public Context mContext;
    public long mPaId;

    public IMPaAcceptPushMsg(Context context, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = null;
        initCommonParameter(context);
        this.mContext = context;
        this.mPaId = j;
        this.mAcceptPush = z;
        setNeedReplay(true);
        setType(105);
    }

    public static IMPaAcceptPushMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_PA_ID) && intent.hasExtra(Constants.EXTRA_PA_ACCEPT_PUSH)) {
                return new IMPaAcceptPushMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L), intent.getBooleanExtra(Constants.EXTRA_PA_ACCEPT_PUSH, true));
            }
            return null;
        }
        return (IMPaAcceptPushMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 105);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("pa_uid", this.mPaId);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("is_accept_msg", this.mAcceptPush);
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(LogUtils.TAG, "buildBody:", e);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
            }
        }
    }

    public long getPaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mPaId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, i, str) == null) {
            if (i == 0) {
                try {
                    PaInfoDBManager.getInstance(context).acceptPaPush(this.mPaId, this.mAcceptPush);
                } catch (Exception e) {
                    LogUtils.e(LogUtils.TAG, "handleMessageResult:", e);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                }
            }
            super.handleMessageResult(context, jSONObject, i, str);
            PaManagerImpl.getInstance(context).onAcceptPaPushResult(getListenerKey(), i, str, this.mPaId);
        }
    }
}
