package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class IMMarkMsgReadedMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMarkMsgReadedMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public long mCategory;
    public long mClientMaxMsgid;
    public Context mContext;
    public boolean mIsZHida;
    public long mMsgId;
    public long mPaid;
    public int mReSendCount;
    public long mTo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2040819896, "Lcom/baidu/android/imsdk/chatmessage/request/IMMarkMsgReadedMsg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2040819896, "Lcom/baidu/android/imsdk/chatmessage/request/IMMarkMsgReadedMsg;");
        }
    }

    public IMMarkMsgReadedMsg(Context context, long j2, long j3, long j4, long j5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mReSendCount = 0;
        this.mClientMaxMsgid = -1L;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(67);
        this.mCategory = j2;
        this.mTo = j3;
        this.mMsgId = j4;
        this.mContext = context;
        this.mClientMaxMsgid = j5;
        this.mPriority = 14;
        this.mIsZHida = z;
    }

    public static IMMarkMsgReadedMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
                long longExtra = intent.getLongExtra("contacter", -1L);
                long intExtra = intent.getIntExtra("category", -1);
                long longExtra2 = intent.getLongExtra("msgid", -1L);
                long longExtra3 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
                boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                if (-1 == longExtra || -1 == intExtra) {
                    return null;
                }
                IMMarkMsgReadedMsg iMMarkMsgReadedMsg = new IMMarkMsgReadedMsg(context, intExtra, longExtra, longExtra2, longExtra3, booleanExtra);
                if (IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
                    iMMarkMsgReadedMsg.setPaid(intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
                }
                Message.saveCmdMessage(context, iMMarkMsgReadedMsg, null, iMMarkMsgReadedMsg.getPriority());
                return iMMarkMsgReadedMsg;
            }
            return null;
        }
        return (IMMarkMsgReadedMsg) invokeLL.objValue;
    }

    public static IMMarkMsgReadedMsg parseBody(Context context, String str, String str2, String str3) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject(str2);
            IMMarkMsgReadedMsg iMMarkMsgReadedMsg = new IMMarkMsgReadedMsg(context, jSONObject.optLong("category"), jSONObject.optLong("to"), jSONObject.optLong("msgid"), jSONObject.optLong(Constants.EXTRA_CLIENT_MAX_MSGID, -1L), jSONObject.optInt("tpl") == Constants.getTplZhida(context));
            iMMarkMsgReadedMsg.setUUID(str);
            if (IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
                iMMarkMsgReadedMsg.setPaid(jSONObject.getLong("pa_uid"));
            }
            return iMMarkMsgReadedMsg;
        }
        return (IMMarkMsgReadedMsg) invokeLLLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 67);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("to", this.mTo);
                jSONObject.put("category", this.mCategory);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                if (this.mMsgId > 0) {
                    jSONObject.put("msgid", this.mMsgId);
                }
                if (this.mClientMaxMsgid > 0) {
                    jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgid);
                }
                if (this.mIsZHida) {
                    jSONObject.put("tpl", Constants.getTplZhida(this.mContext));
                }
                if (IMConfigInternal.getInstance().getIMConfig(this.mContext).isNeedPaid()) {
                    jSONObject.put("pa_uid", this.mPaid);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", this.mReSendCount);
                jSONObject.put("rpc", jSONObject2.toString());
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                LogUtils.e(TAG, "Exception ", e2);
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i2, str) == null) {
            if (i2 == 0) {
                DBManager.getInstance(context).deleteCmdMsg(getUUID());
                setNeedReSend(false);
            } else {
                if (i2 != 1004 && i2 != 1001 && i2 != 4001) {
                    int i3 = this.mReSendCount;
                    if (i3 >= 3) {
                        setNeedReSend(false);
                        DBManager.getInstance(context).deleteCmdMsg(getUUID());
                    } else {
                        this.mReSendCount = i3 + 1;
                        setNeedReSend(true);
                    }
                } else {
                    setNeedReSend(false);
                    LoginManager.getInstance(context).triggleLogoutListener(i2, str);
                }
                DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
            }
            super.handleMessageResult(context, jSONObject, i2, str);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            setSendingState(context);
        }
    }

    public void setPaid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.mPaid = j2;
        }
    }
}
