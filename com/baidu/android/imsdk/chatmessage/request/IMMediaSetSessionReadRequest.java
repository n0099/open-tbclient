package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMediaSetSessionReadListener;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMediaSetSessionReadRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaSetSessionReadRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public String mKey;
    public long mLastTime;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public IMMediaSetSessionReadRequest(Context context, long j, int i, long j2, String str, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Long.valueOf(j3), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -2;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mLastTime = j3;
        this.mKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }

    public IMMediaSetSessionReadRequest(Context context, long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -2;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContacter = j;
        this.mLastTime = j2;
        this.mKey = str;
    }

    private long getBusinessMaxMsgid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            List<ChatSession> busiChatSessions = BusinessMessageDBManager.getInstance(this.mContext).getBusiChatSessions(27, -1, 0L, 0L, Long.MAX_VALUE, -1, 1);
            if (busiChatSessions != null && busiChatSessions.size() > 0) {
                return busiChatSessions.get(0).getLastMsgId();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ Map getHeaders() {
        return super.getHeaders();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/mark_msg_read_status";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if ((!AccountManager.getMediaRole(this.mContext) && this.mContactorType != -1) || AccountManager.isCuidLogin(this.mContext)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                putCommonParams(jSONObject);
                if (this.mContacter > 0) {
                    jSONObject.put("contacter", Utility.transBDUID(String.valueOf(this.mContacter)));
                }
                if (this.mContactorType >= -1) {
                    jSONObject.put("contacter_type", this.mContactorType);
                }
                if (this.mContactorPauid > 0) {
                    jSONObject.put("contacter_pa_uid", this.mContactorPauid);
                }
                if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                    jSONObject.put("contacter_third_id", this.mContactorThirdid);
                }
                if (AccountManager.getMediaRole(this.mContext)) {
                    jSONObject.put("role", 2);
                } else {
                    jSONObject.put("role", 1);
                }
                long businessMaxMsgid = getBusinessMaxMsgid();
                if (businessMaxMsgid > 0) {
                    jSONObject.put("max_msgid", businessMaxMsgid);
                }
                jSONObject.put("lastmsg_time", this.mLastTime);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.e(TAG, "getRequestParameter Exception ", e);
            }
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            LogUtils.d(TAG, "onFailure error = " + transErrorCode.first + " errormsg = " + ((String) transErrorCode.second));
            IMediaSetSessionReadListener iMediaSetSessionReadListener = (IMediaSetSessionReadListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "onSuccess resultContent = " + str2);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                i2 = jSONObject.optInt("error_code", 0);
                str = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
                if (i2 == 0) {
                    boolean z = true;
                    if (this.mContactorType == -1) {
                        List<Integer> unreadChatTypesByAllClassType = ChatSessionManagerImpl.getInstance(this.mContext).getUnreadChatTypesByAllClassType();
                        ArrayList arrayList = new ArrayList();
                        if (unreadChatTypesByAllClassType != null) {
                            arrayList.addAll(unreadChatTypesByAllClassType);
                        }
                        arrayList.add(57);
                        ChatMsgManager.setMsgReadByChatTpyes(this.mContext, arrayList, 0L);
                        ChatSessionManagerImpl.getInstance(this.mContext).setAllBusinessSessionRead(27);
                    } else if (this.mContactorType == 2) {
                        ChatMsgManager.setAllMsgRead(this.mContext, 1, this.mContacter, false);
                    }
                    ChatSessionManagerImpl chatSessionManagerImpl = ChatSessionManagerImpl.getInstance(this.mContext);
                    if (this.mContactorType == -1) {
                        z = false;
                    }
                    chatSessionManagerImpl.writeServerUnreadnum(0, z);
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "IMMediaSetSessionReadRequest JSONException", e);
                i2 = 1010;
                str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
            }
            IMediaSetSessionReadListener iMediaSetSessionReadListener = (IMediaSetSessionReadListener) ListenerManager.getInstance().removeListener(this.mKey);
            if (iMediaSetSessionReadListener != null) {
                iMediaSetSessionReadListener.onMediaSetSessionReadResult(i2, str);
            }
        }
    }
}
