package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMDelMsg extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMDelMsg";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCategory;
    public int mChatType;
    public long mClientMaxMsgid;
    public Context mContext;
    public boolean mIsZhida;
    public long[] mMsgIds;
    public long mPaid;
    public int mReSendCount;
    public long mToId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-745174342, "Lcom/baidu/android/imsdk/chatmessage/request/IMDelMsg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-745174342, "Lcom/baidu/android/imsdk/chatmessage/request/IMDelMsg;");
        }
    }

    public IMDelMsg(Context context, long j, int i2, long[] jArr, long j2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i2), jArr, Long.valueOf(j2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mClientMaxMsgid = -1L;
        this.mReSendCount = 0;
        initCommonParameter(context);
        this.mContext = context;
        this.mToId = j;
        setNeedReplay(true);
        this.mCategory = i2;
        setType(57);
        this.mMsgIds = jArr;
        this.mClientMaxMsgid = j2;
        this.mPriority = 14;
        this.mIsZhida = z;
    }

    public static IMDelMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
                long longExtra = intent.getLongExtra("contacter", -1L);
                int intExtra = intent.getIntExtra("category", -1);
                long[] longArrayExtra = intent.getLongArrayExtra(Constants.EXTRA_DEL_MSG_IDS);
                long longExtra2 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
                boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                int intExtra2 = intent.getIntExtra("chat_type", 0);
                long longExtra3 = IMConfigInternal.getInstance().getIMConfig(context).isNeedPaid() ? intent.getLongExtra(Constants.EXTRA_PA_ID, -1L) : -1L;
                if (-1 != longExtra && -1 != intExtra) {
                    IMDelMsg iMDelMsg = new IMDelMsg(context, longExtra, intExtra, longArrayExtra, longExtra2, booleanExtra);
                    iMDelMsg.setPaid(longExtra3);
                    iMDelMsg.setChatType(intExtra2);
                    Message.saveCmdMessage(context, iMDelMsg, null, iMDelMsg.getPriority());
                    return iMDelMsg;
                }
            }
            return null;
        }
        return (IMDelMsg) invokeLL.objValue;
    }

    private int updateDB(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            long[] jArr = this.mMsgIds;
            if (jArr != null && jArr.length > 0) {
                return ChatMessageDBManager.getInstance(context).deleteMsgBatch(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mMsgIds);
            }
            return ChatMessageDBManager.getInstance(context).delMsgsOfCertainContacter(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mClientMaxMsgid);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 57);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("uk", this.mUk);
                jSONObject.put("to", this.mToId);
                jSONObject.put("category", this.mCategory);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                if (this.mMsgIds != null && this.mMsgIds.length > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (long j : this.mMsgIds) {
                        jSONArray.put(Long.valueOf(j));
                    }
                    jSONObject.put("msgid", jSONArray);
                }
                if (this.mClientMaxMsgid > 0) {
                    jSONObject.put(Constants.EXTRA_CLIENT_MAX_MSGID, this.mClientMaxMsgid);
                }
                if (this.mIsZhida) {
                    jSONObject.put("tpl", Constants.getTplZhida(this.mContext));
                }
                if (IMConfigInternal.getInstance().getIMConfig(this.mContext).isNeedPaid()) {
                    jSONObject.put("pa_uid", this.mPaid);
                }
                if (this.mChatType == 57) {
                    jSONObject.put("group_type", 3);
                }
                this.mBody = jSONObject.toString();
            } catch (JSONException e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, e2.getMessage(), e2);
            }
        }
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCategory : invokeV.intValue;
    }

    public long getToUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mToId : invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, context, jSONObject, i2, str) == null) {
            try {
                if (TextUtils.isEmpty(this.mListenerKey)) {
                    if (i2 == 0) {
                        DBManager.getInstance(context).deleteCmdMsg(getUUID());
                        setNeedReSend(false);
                    } else {
                        if (i2 != 1004 && i2 != 1001) {
                            if (this.mReSendCount >= 3) {
                                setNeedReSend(false);
                                DBManager.getInstance(context).deleteCmdMsg(getUUID());
                            } else {
                                this.mReSendCount++;
                                setNeedReSend(true);
                            }
                            DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
                        }
                        setNeedReSend(false);
                        LoginManager.getInstance(this.mContext).triggleLogoutListener(i2, str);
                        DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
                    }
                } else if (i2 == 0) {
                    updateDB(context);
                }
                super.handleMessageResult(context, jSONObject, i2, str);
            } catch (Exception e2) {
                LogUtils.e(TAG, "handle IMDelMsg exception :", e2);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void onMsgSending(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            setSendingState(context);
        }
    }

    public void setChatType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mChatType = i2;
        }
    }

    public void setPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.mPaid = j;
        }
    }
}
