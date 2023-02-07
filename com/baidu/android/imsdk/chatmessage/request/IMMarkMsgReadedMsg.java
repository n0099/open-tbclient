package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import androidx.core.net.MailTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
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
/* loaded from: classes.dex */
public class IMMarkMsgReadedMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMarkMsgReadedMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCategory;
    public long mClientMaxMsgid;
    public long mClientMinMsgid;
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

    public IMMarkMsgReadedMsg(Context context, int i, long j, long j2, long j3, long j4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z)};
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
        this.mClientMinMsgid = -1L;
        this.mClientMaxMsgid = -1L;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(67);
        this.mCategory = i;
        this.mTo = j;
        this.mMsgId = j2;
        this.mContext = context;
        this.mClientMinMsgid = j3;
        this.mClientMaxMsgid = j4;
        this.mPriority = 14;
        this.mIsZHida = z;
    }

    private void deleteCmdMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            DBManager.getInstance(this.mContext).deleteCmdMsg(getUUID());
        }
    }

    private void updateCmdMsgSendStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            DBManager.getInstance(this.mContext).updateCmdMsgSendStatus(getUUID(), 1);
        }
    }

    public static IMMarkMsgReadedMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        IMMarkMsgReadedMsg iMMarkMsgReadedMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
                long longExtra = intent.getLongExtra("contacter", -1L);
                int intExtra = intent.getIntExtra("category", -1);
                long longExtra2 = intent.getLongExtra("msgid", -1L);
                long longExtra3 = intent.getLongExtra(Constants.EXTRA_BEGIN_MSGID, -1L);
                long longExtra4 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
                boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                String stringExtra = intent.getStringExtra(Constants.EXTRA_LISTENER_ID);
                if (-1 != longExtra && -1 != intExtra) {
                    IMMarkMsgReadedMsg iMMarkMsgReadedMsg2 = new IMMarkMsgReadedMsg(context, intExtra, longExtra, longExtra2, longExtra3, longExtra4, booleanExtra);
                    if (IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
                        iMMarkMsgReadedMsg = iMMarkMsgReadedMsg2;
                        iMMarkMsgReadedMsg.setPaid(intent.getLongExtra(Constants.EXTRA_PA_ID, -1L));
                    } else {
                        iMMarkMsgReadedMsg = iMMarkMsgReadedMsg2;
                    }
                    Message.saveCmdMessage(context, iMMarkMsgReadedMsg, null, iMMarkMsgReadedMsg.getPriority());
                    iMMarkMsgReadedMsg.setListenerKey(stringExtra);
                    return iMMarkMsgReadedMsg;
                }
                return null;
            }
            return null;
        }
        return (IMMarkMsgReadedMsg) invokeLL.objValue;
    }

    public static IMMarkMsgReadedMsg parseBody(Context context, String str, String str2, String str3) throws Exception {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject(str2);
            int optInt = jSONObject.optInt("category");
            long optLong = jSONObject.optLong(MailTo.TO);
            long optLong2 = jSONObject.optLong("msgid");
            long optLong3 = jSONObject.optLong(Constants.EXTRA_BEGIN_MSGID, -1L);
            long optLong4 = jSONObject.optLong(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
            if (jSONObject.optInt("tpl") == Constants.getTplZhida(context)) {
                z = true;
            } else {
                z = false;
            }
            IMMarkMsgReadedMsg iMMarkMsgReadedMsg = new IMMarkMsgReadedMsg(context, optInt, optLong, optLong2, optLong3, optLong4, z);
            iMMarkMsgReadedMsg.setUUID(str);
            if (IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid()) {
                iMMarkMsgReadedMsg.setPaid(jSONObject.getLong(Constants.EXTRA_PAUID_TYPE));
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
                jSONObject.put(MailTo.TO, this.mTo);
                jSONObject.put("category", this.mCategory);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                if (this.mMsgId > 0) {
                    jSONObject.put("msgid", this.mMsgId);
                }
                if (this.mClientMaxMsgid > 0) {
                    jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgid);
                }
                if (this.mClientMinMsgid > 0) {
                    jSONObject.put(Constants.EXTRA_BEGIN_MSGID, this.mClientMinMsgid);
                }
                if (this.mIsZHida) {
                    jSONObject.put("tpl", Constants.getTplZhida(this.mContext));
                }
                if (IMConfigInternal.getInstance().getIMConfig(this.mContext).isNeedPaid()) {
                    jSONObject.put(Constants.EXTRA_PAUID_TYPE, this.mPaid);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rpc_retry_time", this.mReSendCount);
                jSONObject.put("rpc", jSONObject2.toString());
                this.mBody = jSONObject.toString();
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            if (i == 0) {
                deleteCmdMsg();
                setNeedReSend(false);
            } else {
                if (i != 1004 && i != 1001 && i != 4001) {
                    int i2 = this.mReSendCount;
                    if (i2 >= 3) {
                        setNeedReSend(false);
                        deleteCmdMsg();
                    } else {
                        this.mReSendCount = i2 + 1;
                        setNeedReSend(true);
                    }
                } else {
                    setNeedReSend(false);
                    LoginManager.getInstance(context).triggleLogoutListener(i, str);
                }
                updateCmdMsgSendStatus();
            }
            super.handleMessageResult(context, jSONObject, i, str);
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            setSendingState(context);
        }
    }

    public void setPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.mPaid = j;
        }
    }
}
