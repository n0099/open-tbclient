package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.ChatSessionManagerImpl;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.group.GroupMessageManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMediaGetChatSessionRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int INTERACTIVE_MSG_CLASS_TYPE = 11;
    public static final String KEY_MEDIA_TOTAL_NUM_FROM_SERVER = "media_total_num_from_server";
    public static final int MAX_FETCH_COUNT = 20;
    public static final String TAG = "IMMediaGetChatSessionRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mContacter;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public int mCount;
    public long mEndTime;
    public String mKey;
    public int mNeedTop;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public IMMediaGetChatSessionRequest(Context context, long j, int i, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mNeedTop = -1;
        this.mContext = context;
        this.mContacter = j;
        this.mCount = i;
        this.mEndTime = j2;
        this.mKey = str;
    }

    public IMMediaGetChatSessionRequest(Context context, long j, int i, long j2, String str, int i2, long j3, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2), str, Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mNeedTop = -1;
        this.mContext = context;
        this.mContacter = j;
        this.mCount = i2;
        this.mEndTime = j3;
        this.mKey = str2;
        this.mContactorType = i;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
        this.mNeedTop = i3;
    }

    private int getClientUnreadnum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return ChatMessageDBManager.getInstance(this.mContext).getNewMsgCountOfClass(11);
        }
        return invokeV.intValue;
    }

    private boolean isUsefulUnreadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int i = this.mContactorType;
            if (i >= 0 && (i == 2 || i == 10 || i == 27)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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
            return getHostUrl() + "rest/3.0/im/fetch_session";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    private int readTotalUnreadnum(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            if (!isUsefulUnreadNum()) {
                i = ChatSessionManagerImpl.getInstance(this.mContext).readServerUnreadNum();
            }
            return i + getClientUnreadnum();
        }
        return invokeI.intValue;
    }

    private void writeServerUnreadnum(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65541, this, i) == null) && isUsefulUnreadNum()) {
            ChatSessionManagerImpl.getInstance(this.mContext).writeServerUnreadnum(i, false);
        }
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
                    if (this.mContactorType == 2) {
                        jSONObject.put("contacter_im_uk", this.mContacter);
                    } else {
                        jSONObject.put("contacter", Utility.transBDUID(String.valueOf(this.mContacter)));
                    }
                }
                if (this.mEndTime > 0) {
                    jSONObject.put("end_time", this.mEndTime);
                }
                if (this.mContactorType >= 0) {
                    jSONObject.put("contacter_type", this.mContactorType);
                }
                if (this.mContactorPauid > 0) {
                    jSONObject.put(RequestContants.EXTRA_CONTACTER_PA_UID, this.mContactorPauid);
                }
                if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                    jSONObject.put("contacter_third_id", this.mContactorThirdid);
                }
                jSONObject.put("need_top", this.mNeedTop);
                int i = 20;
                if (this.mCount <= 20) {
                    i = this.mCount;
                }
                jSONObject.put("count", i);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
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
            ChatSessionManagerImpl.getInstance(this.mContext).onMediaGetChatSessionRequest(((Integer) transErrorCode.first).intValue(), false, 0, 0, 0, null, null, null, this.mKey);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0326  */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess(int i, byte[] bArr) {
        String str;
        HashMap hashMap;
        HashMap hashMap2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest;
        int i7;
        JSONArray jSONArray;
        long j;
        int i8;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            IMMediaGetChatSessionRequest iMMediaGetChatSessionRequest2 = this;
            String str4 = new String(bArr);
            String str5 = TAG;
            LogUtils.d(TAG, "onSuccess resultContent = " + str4);
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str4);
                int optInt = jSONObject.optInt("error_code", 0);
                if (optInt == 0) {
                    i2 = jSONObject.optInt("has_more", 0);
                    try {
                        i3 = jSONObject.optInt("total_unread_num", 0);
                        try {
                            iMMediaGetChatSessionRequest2.writeServerUnreadnum(i3);
                            i4 = jSONObject.optInt("consult_unread_num", 0);
                        } catch (JSONException e) {
                            e = e;
                            str = TAG;
                            hashMap = hashMap3;
                            hashMap2 = hashMap5;
                            i4 = 0;
                            i5 = 0;
                            LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                            i6 = 1010;
                            iMMediaGetChatSessionRequest = this;
                            ChatSessionManagerImpl chatSessionManagerImpl = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                            boolean z = true;
                            if (i2 != 1) {
                            }
                            chatSessionManagerImpl.onMediaGetChatSessionRequest(i6, z, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                        }
                        try {
                            i5 = jSONObject.optInt("top_has_more");
                            try {
                                JSONArray optJSONArray = jSONObject.optJSONArray("sessions");
                                if (optJSONArray != null) {
                                    int i9 = 0;
                                    while (i9 < optJSONArray.length()) {
                                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i9);
                                        int optInt2 = jSONObject2.optInt("chat_type");
                                        try {
                                            jSONArray = optJSONArray;
                                            j = Long.parseLong(Utility.transBDUK(jSONObject2.optString("contacter_pass_uk")));
                                        } catch (NumberFormatException e2) {
                                            jSONArray = optJSONArray;
                                            LogUtils.e(LogUtils.TAG, "IMMediaGetChatSessionRequest NumberFormatException", e2);
                                            j = 0;
                                        } catch (JSONException e3) {
                                            e = e3;
                                            str = str5;
                                            hashMap = hashMap3;
                                            hashMap2 = hashMap5;
                                            LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                            i6 = 1010;
                                            iMMediaGetChatSessionRequest = this;
                                            ChatSessionManagerImpl chatSessionManagerImpl2 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                            boolean z2 = true;
                                            if (i2 != 1) {
                                            }
                                            chatSessionManagerImpl2.onMediaGetChatSessionRequest(i6, z2, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                        }
                                        long j2 = j;
                                        long optLong = jSONObject2.optLong(RequestContants.EXTRA_CONTACTER_PA_UID);
                                        int optInt3 = jSONObject2.optInt("content_type");
                                        String optString = jSONObject2.optString("content");
                                        int optInt4 = jSONObject2.optInt("unread_num");
                                        int i10 = optInt;
                                        int i11 = i2;
                                        try {
                                            long optLong2 = jSONObject2.optLong("last_time");
                                            int i12 = i3;
                                            try {
                                                long optLong3 = jSONObject2.optLong("contacter_im_uk");
                                                int i13 = i4;
                                                try {
                                                    int optInt5 = jSONObject2.optInt("is_top", 0);
                                                    int i14 = i5;
                                                    int i15 = i9;
                                                    try {
                                                        long optLong4 = jSONObject2.optLong("last_msg_bd_uid");
                                                        int optInt6 = jSONObject2.optInt("pa_classtype");
                                                        str = str5;
                                                        try {
                                                            String optString2 = jSONObject2.optString("pa_classtitle");
                                                            HashMap hashMap6 = hashMap4;
                                                            try {
                                                                String optString3 = jSONObject2.optString("pa_classavatar");
                                                                long optLong5 = jSONObject2.optLong("last_msg_im_uk");
                                                                HashMap hashMap7 = hashMap5;
                                                                try {
                                                                    int optInt7 = jSONObject2.optInt("contacter_type");
                                                                    HashMap hashMap8 = hashMap3;
                                                                    try {
                                                                        int optInt8 = jSONObject2.optInt("is_block");
                                                                        long optLong6 = jSONObject2.optLong("block_timestamp");
                                                                        int optInt9 = jSONObject2.optInt("do_not_disturb");
                                                                        if (optInt2 == 57) {
                                                                            j2 = optLong3;
                                                                            i8 = 1;
                                                                        } else {
                                                                            i8 = 0;
                                                                        }
                                                                        ChatMsg parseChatMsg = MessageParser.parseChatMsg(iMMediaGetChatSessionRequest2.mContext, i8, optInt3, optInt7, 0, optString);
                                                                        if (parseChatMsg == null) {
                                                                            str2 = "";
                                                                            str3 = str2;
                                                                        } else {
                                                                            if (optInt2 == 57) {
                                                                                try {
                                                                                    if (!GroupMessageManagerImpl.getInstance(iMMediaGetChatSessionRequest2.mContext).isValidGroup(parseChatMsg)) {
                                                                                        hashMap4 = hashMap6;
                                                                                        hashMap2 = hashMap7;
                                                                                        hashMap = hashMap8;
                                                                                        i9 = i15 + 1;
                                                                                        iMMediaGetChatSessionRequest2 = this;
                                                                                        hashMap5 = hashMap2;
                                                                                        hashMap3 = hashMap;
                                                                                        optJSONArray = jSONArray;
                                                                                        optInt = i10;
                                                                                        i2 = i11;
                                                                                        i3 = i12;
                                                                                        i4 = i13;
                                                                                        i5 = i14;
                                                                                        str5 = str;
                                                                                    }
                                                                                } catch (JSONException e4) {
                                                                                    e = e4;
                                                                                    i2 = i11;
                                                                                    i3 = i12;
                                                                                    i4 = i13;
                                                                                    i5 = i14;
                                                                                    hashMap4 = hashMap6;
                                                                                    hashMap2 = hashMap7;
                                                                                    hashMap = hashMap8;
                                                                                    LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                                                    i6 = 1010;
                                                                                    iMMediaGetChatSessionRequest = this;
                                                                                    ChatSessionManagerImpl chatSessionManagerImpl22 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                                                                    boolean z22 = true;
                                                                                    if (i2 != 1) {
                                                                                    }
                                                                                    chatSessionManagerImpl22.onMediaGetChatSessionRequest(i6, z22, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                                                                }
                                                                            }
                                                                            String recommendDescription = parseChatMsg.getRecommendDescription();
                                                                            str3 = parseChatMsg.getExtLog();
                                                                            str2 = recommendDescription;
                                                                        }
                                                                        if (TextUtils.isEmpty(str2) || StringUtil.NULL_STRING.equalsIgnoreCase(str2)) {
                                                                            str2 = IMConstants.IM_GROUP_MSG_DEFAULT_RECOMMEND_DESC;
                                                                        }
                                                                        ChatSession chatSession = new ChatSession(i8, optLong3, j2, "");
                                                                        chatSession.setNewMsgSum(optInt4);
                                                                        chatSession.setLastMsgTime(optLong2);
                                                                        chatSession.setLastOpenTime(optLong2);
                                                                        chatSession.setLastMsg(str2);
                                                                        chatSession.setMarkTop(optInt5);
                                                                        chatSession.setMarkTopTime(optLong2);
                                                                        chatSession.setSessionFrom(1);
                                                                        chatSession.setIsClicked(1);
                                                                        chatSession.setExt(str3);
                                                                        chatSession.setLastMsgUid(optLong4);
                                                                        chatSession.setChatType(optInt2);
                                                                        chatSession.setShield(optInt8);
                                                                        chatSession.setShieldTime(optLong6);
                                                                        chatSession.setDisturb(optInt9);
                                                                        if (optInt6 > 0) {
                                                                            try {
                                                                                chatSession.setClassShow(1);
                                                                                chatSession.setClassType(optInt6);
                                                                                chatSession.setClassTitle(optString2);
                                                                                chatSession.setName(optString2);
                                                                                chatSession.setClassAvatar(optString3);
                                                                                chatSession.setIconUrl(optString3);
                                                                                chatSession.setLastMsgUid(optLong5);
                                                                                chatSession.setBusinessType(optInt7);
                                                                                hashMap = hashMap8;
                                                                                try {
                                                                                    hashMap.put(Long.valueOf(optLong5), chatSession);
                                                                                    hashMap4 = hashMap6;
                                                                                    hashMap2 = hashMap7;
                                                                                } catch (JSONException e5) {
                                                                                    e = e5;
                                                                                    i2 = i11;
                                                                                    i3 = i12;
                                                                                    i4 = i13;
                                                                                    i5 = i14;
                                                                                    hashMap4 = hashMap6;
                                                                                    hashMap2 = hashMap7;
                                                                                    LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                                                    i6 = 1010;
                                                                                    iMMediaGetChatSessionRequest = this;
                                                                                    ChatSessionManagerImpl chatSessionManagerImpl222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                                                                    boolean z222 = true;
                                                                                    if (i2 != 1) {
                                                                                    }
                                                                                    chatSessionManagerImpl222.onMediaGetChatSessionRequest(i6, z222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                                                                }
                                                                            } catch (JSONException e6) {
                                                                                e = e6;
                                                                                hashMap = hashMap8;
                                                                            }
                                                                        } else {
                                                                            hashMap = hashMap8;
                                                                            if (optInt2 == 57) {
                                                                                try {
                                                                                    hashMap2 = hashMap7;
                                                                                } catch (JSONException e7) {
                                                                                    e = e7;
                                                                                    hashMap2 = hashMap7;
                                                                                }
                                                                                try {
                                                                                    hashMap2.put(String.valueOf(optLong3), chatSession);
                                                                                } catch (JSONException e8) {
                                                                                    e = e8;
                                                                                    i2 = i11;
                                                                                    i3 = i12;
                                                                                    i4 = i13;
                                                                                    i5 = i14;
                                                                                    hashMap4 = hashMap6;
                                                                                    LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                                                    i6 = 1010;
                                                                                    iMMediaGetChatSessionRequest = this;
                                                                                    ChatSessionManagerImpl chatSessionManagerImpl2222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                                                                    boolean z2222 = true;
                                                                                    if (i2 != 1) {
                                                                                    }
                                                                                    chatSessionManagerImpl2222.onMediaGetChatSessionRequest(i6, z2222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                                                                }
                                                                            } else {
                                                                                hashMap2 = hashMap7;
                                                                                if (optLong != 0) {
                                                                                    chatSession.setPaid(optLong);
                                                                                    hashMap.put(Long.valueOf(optLong), chatSession);
                                                                                } else if (j2 != 0) {
                                                                                    try {
                                                                                        hashMap4 = hashMap6;
                                                                                        try {
                                                                                            hashMap4.put(Long.valueOf(j2), chatSession);
                                                                                        } catch (JSONException e9) {
                                                                                            e = e9;
                                                                                            i2 = i11;
                                                                                            i3 = i12;
                                                                                            i4 = i13;
                                                                                            i5 = i14;
                                                                                            LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                                                            i6 = 1010;
                                                                                            iMMediaGetChatSessionRequest = this;
                                                                                            ChatSessionManagerImpl chatSessionManagerImpl22222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                                                                            boolean z22222 = true;
                                                                                            if (i2 != 1) {
                                                                                            }
                                                                                            chatSessionManagerImpl22222.onMediaGetChatSessionRequest(i6, z22222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                                                                        }
                                                                                    } catch (JSONException e10) {
                                                                                        e = e10;
                                                                                        hashMap4 = hashMap6;
                                                                                        i2 = i11;
                                                                                        i3 = i12;
                                                                                        i4 = i13;
                                                                                        i5 = i14;
                                                                                        LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                                                        i6 = 1010;
                                                                                        iMMediaGetChatSessionRequest = this;
                                                                                        ChatSessionManagerImpl chatSessionManagerImpl222222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                                                                        boolean z222222 = true;
                                                                                        if (i2 != 1) {
                                                                                        }
                                                                                        chatSessionManagerImpl222222.onMediaGetChatSessionRequest(i6, z222222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                                                                    }
                                                                                }
                                                                            }
                                                                            hashMap4 = hashMap6;
                                                                        }
                                                                        i9 = i15 + 1;
                                                                        iMMediaGetChatSessionRequest2 = this;
                                                                        hashMap5 = hashMap2;
                                                                        hashMap3 = hashMap;
                                                                        optJSONArray = jSONArray;
                                                                        optInt = i10;
                                                                        i2 = i11;
                                                                        i3 = i12;
                                                                        i4 = i13;
                                                                        i5 = i14;
                                                                        str5 = str;
                                                                    } catch (JSONException e11) {
                                                                        e = e11;
                                                                        hashMap4 = hashMap6;
                                                                        hashMap2 = hashMap7;
                                                                        hashMap = hashMap8;
                                                                    }
                                                                } catch (JSONException e12) {
                                                                    e = e12;
                                                                    hashMap = hashMap3;
                                                                    hashMap4 = hashMap6;
                                                                    hashMap2 = hashMap7;
                                                                }
                                                            } catch (JSONException e13) {
                                                                e = e13;
                                                                hashMap = hashMap3;
                                                                hashMap2 = hashMap5;
                                                            }
                                                        } catch (JSONException e14) {
                                                            e = e14;
                                                            hashMap = hashMap3;
                                                            hashMap2 = hashMap5;
                                                            i2 = i11;
                                                            i3 = i12;
                                                            i4 = i13;
                                                            i5 = i14;
                                                            LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                                                            i6 = 1010;
                                                            iMMediaGetChatSessionRequest = this;
                                                            ChatSessionManagerImpl chatSessionManagerImpl2222222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                                                            boolean z2222222 = true;
                                                            if (i2 != 1) {
                                                            }
                                                            chatSessionManagerImpl2222222.onMediaGetChatSessionRequest(i6, z2222222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                                                        }
                                                    } catch (JSONException e15) {
                                                        e = e15;
                                                        str = str5;
                                                    }
                                                } catch (JSONException e16) {
                                                    e = e16;
                                                    str = str5;
                                                    hashMap = hashMap3;
                                                    hashMap2 = hashMap5;
                                                    i2 = i11;
                                                    i3 = i12;
                                                    i4 = i13;
                                                }
                                            } catch (JSONException e17) {
                                                e = e17;
                                                str = str5;
                                                hashMap = hashMap3;
                                                hashMap2 = hashMap5;
                                                i2 = i11;
                                                i3 = i12;
                                            }
                                        } catch (JSONException e18) {
                                            e = e18;
                                            str = str5;
                                            hashMap = hashMap3;
                                            hashMap2 = hashMap5;
                                            i2 = i11;
                                        }
                                    }
                                }
                                i7 = optInt;
                                hashMap = hashMap3;
                                hashMap2 = hashMap5;
                                i2 = i2;
                                i3 = i3;
                                i4 = i4;
                                i5 = i5;
                            } catch (JSONException e19) {
                                e = e19;
                                str = str5;
                                hashMap = hashMap3;
                                hashMap2 = hashMap5;
                            }
                        } catch (JSONException e20) {
                            e = e20;
                            str = TAG;
                            hashMap = hashMap3;
                            hashMap2 = hashMap5;
                            i5 = 0;
                            LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                            i6 = 1010;
                            iMMediaGetChatSessionRequest = this;
                            ChatSessionManagerImpl chatSessionManagerImpl22222222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                            boolean z22222222 = true;
                            if (i2 != 1) {
                            }
                            chatSessionManagerImpl22222222.onMediaGetChatSessionRequest(i6, z22222222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                        }
                    } catch (JSONException e21) {
                        e = e21;
                        str = TAG;
                        hashMap = hashMap3;
                        hashMap2 = hashMap5;
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                        LogUtils.e(str, "IMMediaGetChatSessionRequest JSONException", e);
                        i6 = 1010;
                        iMMediaGetChatSessionRequest = this;
                        ChatSessionManagerImpl chatSessionManagerImpl222222222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
                        boolean z222222222 = true;
                        if (i2 != 1) {
                        }
                        chatSessionManagerImpl222222222.onMediaGetChatSessionRequest(i6, z222222222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
                    }
                } else {
                    i7 = optInt;
                    hashMap = hashMap3;
                    hashMap2 = hashMap5;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                }
                iMMediaGetChatSessionRequest = this;
                i6 = i7;
            } catch (JSONException e22) {
                e = e22;
                str = TAG;
                hashMap = hashMap3;
                hashMap2 = hashMap5;
                i2 = 0;
            }
            ChatSessionManagerImpl chatSessionManagerImpl2222222222 = ChatSessionManagerImpl.getInstance(iMMediaGetChatSessionRequest.mContext);
            boolean z2222222222 = true;
            if (i2 != 1) {
                z2222222222 = false;
            }
            chatSessionManagerImpl2222222222.onMediaGetChatSessionRequest(i6, z2222222222, iMMediaGetChatSessionRequest.readTotalUnreadnum(i3), i4, i5, hashMap, hashMap4, hashMap2, iMMediaGetChatSessionRequest.mKey);
        }
    }
}
