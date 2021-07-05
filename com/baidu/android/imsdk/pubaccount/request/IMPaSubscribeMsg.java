package com.baidu.android.imsdk.pubaccount.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.pubaccount.PaInfo;
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
public class IMPaSubscribeMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public long mPaId;
    public PaInfo mPaInfo;

    public IMPaSubscribeMsg(Context context, long j, PaInfo paInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), paInfo};
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
        initCommonParameter(context);
        this.mPaId = j;
        this.mPaInfo = paInfo;
        setNeedReplay(true);
        setType(100);
    }

    public static IMPaSubscribeMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, intent)) == null) {
            if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
                return new IMPaSubscribeMsg(context, intent.getLongExtra(Constants.EXTRA_PA_ID, -1L), (PaInfo) intent.getParcelableExtra(Constants.EXTRA_PA_INFO));
            }
            return null;
        }
        return (IMPaSubscribeMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 100);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                jSONObject.put("pa_uid", this.mPaId);
                long triggerId = Utility.getTriggerId(this.mContext);
                if (triggerId > 0) {
                    jSONObject.put("origin_id", triggerId);
                }
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "buildBody:", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    public long getPaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPaId : invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, context, jSONObject, i2, str) == null) {
            if (i2 == 0) {
                try {
                    PaInfoDBManager.getInstance(context).subscribePa(this.mPaInfo);
                } catch (Exception e2) {
                    LogUtils.e(LogUtils.TAG, "handleMessageResult:", e2);
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                }
            }
            super.handleMessageResult(context, jSONObject, i2, str);
            PaManagerImpl.getInstance(context).onSubscribePaResult(getListenerKey(), i2, str, this.mPaId);
        }
    }
}
