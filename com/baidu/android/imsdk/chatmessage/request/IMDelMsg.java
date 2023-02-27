package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.chatmessage.IDelBusinessMsgListener;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.DataUtil;
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
    public long contacterBduid;
    public long contacterPaUid;
    public long contacterUk;
    public int contacterUserType;
    public int mBusinessType;
    public int mCategory;
    public int mChatType;
    public long mClientMaxMsgid;
    public Context mContext;
    public boolean mIsFromMedia;
    public boolean mIsZhida;
    public long[] mMsgIds;
    public long mPaid;
    public int mReSendCount;
    public int mSessionType;
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

    public IMDelMsg(Context context, long j, int i, int i2, int i3, long[] jArr, long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jArr, Long.valueOf(j2), Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        this.mCategory = i;
        this.mBusinessType = i3;
        this.mSessionType = i2;
        setType(57);
        this.mMsgIds = jArr;
        this.mClientMaxMsgid = j2;
        this.mPriority = 14;
        this.mIsZhida = z;
        setListenerKey(str);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [boolean] */
    private void appendMediaParams(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, jSONObject) == null) {
            try {
                long meidaPaid = MediaSessionManager.getInstance(this.mContext).getMeidaPaid();
                if (meidaPaid > 0) {
                    jSONObject.put(Constants.EXTRA_PAUID_TYPE, meidaPaid);
                }
                if (this.contacterUk > 0) {
                    jSONObject.put("contacter_uk", this.contacterUk);
                }
                if (this.contacterPaUid > 0) {
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_PA_UID, this.contacterPaUid);
                }
                if (this.contacterBduid > 0) {
                    jSONObject.put("contacter_bduid", this.contacterBduid);
                }
                if (this.contacterUserType > -1) {
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_USER_TYPE, this.contacterUserType);
                }
                ?? mediaRole = AccountManagerImpl.getInstance(this.mContext).getMediaRole();
                if (mediaRole > -1) {
                    jSONObject.put("user_type", mediaRole == true ? 1 : 0);
                }
                long bduid = AccountManagerImpl.getInstance(this.mContext).getBduid();
                if (bduid > 0) {
                    jSONObject.put("bduid", bduid);
                }
            } catch (Exception e) {
                LogUtils.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static IMDelMsg newInstance(Context context, Intent intent) {
        InterceptResult invokeLL;
        long j;
        long j2;
        long j3;
        long j4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, intent)) == null) {
            if (intent.hasExtra("contacter") && intent.hasExtra("category")) {
                boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_FROM_MEDIA, false);
                long longExtra = intent.getLongExtra("contacter", -1L);
                int intExtra = intent.getIntExtra("category", -1);
                long[] longArrayExtra = intent.getLongArrayExtra(Constants.EXTRA_DEL_MSG_IDS);
                long longExtra2 = intent.getLongExtra(Constants.EXTRA_CLIENT_MAX_MSGID, -1L);
                boolean booleanExtra2 = intent.getBooleanExtra(Constants.EXTRA_CONTACTER_IS_ZHIDA, false);
                int intExtra2 = intent.getIntExtra("chat_type", 0);
                int intExtra3 = intent.getIntExtra(Constants.EXTRA_BUSINESS_TYPE, -1);
                int intExtra4 = intent.getIntExtra("session_type", -1);
                String stringExtra = intent.getStringExtra(Constants.EXTRA_LISTENER_ID);
                long longExtra3 = intent.getLongExtra("contacter_uk", 0L);
                long longExtra4 = intent.getLongExtra(RequestContants.EXTRA_CONTACTER_PA_UID, 0L);
                long longExtra5 = intent.getLongExtra("contacter_bduid", 0L);
                int intExtra5 = intent.getIntExtra(RequestContants.EXTRA_CONTACTER_USER_TYPE, 0);
                if (intent.hasExtra(Constants.EXTRA_PA_ID)) {
                    j = longExtra3;
                    j2 = -1;
                    j4 = intent.getLongExtra(Constants.EXTRA_PA_ID, -1L);
                    j3 = longExtra5;
                } else {
                    j = longExtra3;
                    j2 = -1;
                    j3 = longExtra5;
                    j4 = -1;
                }
                if (j2 != longExtra && -1 != intExtra) {
                    IMDelMsg iMDelMsg = new IMDelMsg(context, longExtra, intExtra, intExtra4, intExtra3, longArrayExtra, longExtra2, booleanExtra2, stringExtra);
                    iMDelMsg.setPaid(j4);
                    iMDelMsg.setChatType(intExtra2);
                    iMDelMsg.setContacterUk(j);
                    iMDelMsg.setContacterPaUid(longExtra4);
                    iMDelMsg.setContacterUserType(intExtra5);
                    iMDelMsg.contacterBduid = j3;
                    iMDelMsg.mIsFromMedia = booleanExtra;
                    Message.saveCmdMessage(context, iMDelMsg, null, iMDelMsg.getPriority());
                    return iMDelMsg;
                }
                return null;
            }
            return null;
        }
        return (IMDelMsg) invokeLL.objValue;
    }

    private int updateDB(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            if (!this.mIsFromMedia) {
                long[] jArr = this.mMsgIds;
                if (jArr != null && jArr.length > 0) {
                    return ChatMessageDBManager.getInstance(context).deleteMsgBatch(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mMsgIds);
                }
                return ChatMessageDBManager.getInstance(context).delMsgsOfCertainContacter(new ChatObject(context, this.mCategory, this.mToId, this.mPaid, -1), this.mClientMaxMsgid);
            }
            return -1;
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
                if (this.mSessionType > 0) {
                    jSONObject.put("session_type", this.mSessionType);
                }
                if (this.mBusinessType > 0) {
                    jSONObject.put("business_type", this.mBusinessType);
                }
                jSONObject.put("category", this.mCategory);
                jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
                if (!DataUtil.isArrayEmpty(this.mMsgIds)) {
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
                    jSONObject.put(Constants.EXTRA_PAUID_TYPE, this.mPaid);
                }
                if (this.mChatType == 57) {
                    jSONObject.put("group_type", 3);
                }
                if (this.mIsFromMedia) {
                    appendMediaParams(jSONObject);
                }
                this.mBody = jSONObject.toString();
                LogUtils.d(TAG, "params:" + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(TAG, e.getMessage(), e);
            }
        }
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCategory;
        }
        return invokeV.intValue;
    }

    public long getToUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mToId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, context, jSONObject, i, str) == null) {
            LogUtils.d(TAG, "handleMessageResult: errorCode:" + i + ";errorMsg:" + str + ";obj:" + jSONObject.toString());
            try {
                if (TextUtils.isEmpty(this.mListenerKey)) {
                    if (i == 0) {
                        DBManager.getInstance(context).deleteCmdMsg(getUUID());
                        setNeedReSend(false);
                    } else {
                        if (i != 1004 && i != 1001) {
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
                        LoginManager.getInstance(this.mContext).triggleLogoutListener(i, str);
                        DBManager.getInstance(context).updateCmdMsgSendStatus(getUUID(), 1);
                    }
                } else if (i == 0) {
                    if (getCategory() == 9) {
                        IMListener removeListener = ListenerManager.getInstance().removeListener(getListenerKey());
                        BusinessMessageDBManager.getInstance(context).deleteLogicBusiMsgBatch(this.mToId, this.mBusinessType, this.mSessionType, this.mMsgIds);
                        if (removeListener instanceof IDelBusinessMsgListener) {
                            ((IDelBusinessMsgListener) removeListener).onResult(0, str);
                        }
                    } else {
                        updateDB(context);
                    }
                }
                super.handleMessageResult(context, jSONObject, i, str);
            } catch (Exception e) {
                LogUtils.e(TAG, "handle IMDelMsg exception :", e);
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

    public void setChatType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.mChatType = i;
        }
    }

    public void setContacterPaUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.contacterPaUid = j;
        }
    }

    public void setContacterUk(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.contacterUk = j;
        }
    }

    public void setContacterUserType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.contacterUserType = i;
        }
    }

    public void setPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mPaid = j;
        }
    }
}
