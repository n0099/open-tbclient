package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ResultTB;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMMediaFetchMsgHttpRequest extends IMMediaBaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMMediaFetchMsgHttpRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public long mBeginMsgTime;
    public long mContactor;
    public long mContactorPauid;
    public String mContactorThirdid;
    public int mContactorType;
    public int mCount;
    public long mEndMsgTime;
    public String mListenerKey;

    public IMMediaFetchMsgHttpRequest(Context context, long j, long j2, long j3, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mBeginMsgTime = j2;
        this.mEndMsgTime = j3;
        this.mCount = i2;
        this.mListenerKey = str;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.Long] */
    private void parserMsg(List<ChatMsg> list, JSONArray jSONArray, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, this, list, jSONArray, i2) == null) {
            try {
                LogUtils.d(TAG, "BC> parserMsg=" + jSONArray);
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                long optLong = jSONObject.optLong("contacter_im_uk", -1L);
                String transBDUK = Utility.transBDUK(jSONObject.optString("from_pass_uk", ""));
                long optLong2 = jSONObject.optLong("from_im_uk", -1L);
                String transBDUK2 = Utility.transBDUK(jSONObject.optString("to_pass_uk", ""));
                Type type = new Type();
                type.t = 0L;
                ChatMsg parserMessage = MessageParser.parserMessage(this.mContext, jSONObject, type, true);
                if (parserMessage != null) {
                    parserMessage.setMsgId(((Long) type.t).longValue());
                    parserMessage.setFromUser(optLong2);
                    parserMessage.setContacter(optLong);
                    parserMessage.setContacterBduid(transBDUK2);
                    parserMessage.setSenderUid(transBDUK);
                    parserMessage.setIsClicked(true);
                    parserMessage.setMsgReaded(1);
                    LogUtils.d(TAG, "BC> msg=" + parserMessage.toString());
                    parserMessage.setMediaRoleMsg(true);
                    parserMessage.setStatus(0);
                    list.add(parserMessage);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
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
            return getHostUrl() + "rest/3.0/im/fetch_msg";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ String getMethod() {
        return super.getMethod();
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                putCommonParams(jSONObject);
                if (this.mCount > 0) {
                    jSONObject.put("count", Math.abs(this.mCount));
                }
                if (this.mContactor > 0) {
                    jSONObject.put("contacter", Utility.transBDUID(this.mContactor + ""));
                }
                if (this.mContactorType >= 0) {
                    jSONObject.put("contacter_type", this.mContactorType);
                }
                if (this.mContactorPauid > 0) {
                    jSONObject.put("contacter_pa_uid", this.mContactorPauid);
                }
                if (!TextUtils.isEmpty(this.mContactorThirdid)) {
                    jSONObject.put("contacter_third_id", this.mContactorThirdid);
                }
                if (this.mBeginMsgTime > 0) {
                    jSONObject.put("begin_time", this.mBeginMsgTime);
                }
                if (this.mEndMsgTime > 0) {
                    jSONObject.put(ResultTB.ENDTIME, this.mEndMsgTime);
                }
                LogUtils.d(TAG, "BC> before genSign param=" + jSONObject);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LogUtils.d(TAG, "BC> param=" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i2, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i2, bArr, th) == null) {
            LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i2 + ", resultContent=" + new String(bArr));
            Pair<Integer, String> transErrorCode = transErrorCode(i2, bArr, th);
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaFetchChatMsgsResult(this.mListenerKey, ((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, false, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i2, byte[] bArr) {
        boolean z;
        String str;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, bArr) == null) {
            String str2 = new String(bArr);
            LogUtils.d(TAG, "BC> mListenerKey=" + this.mListenerKey + ", errorCode=" + i2 + ", result=" + str2);
            if (TextUtils.isEmpty(this.mListenerKey)) {
                return;
            }
            List<ChatMsg> arrayList = new ArrayList<>();
            int i4 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String str3 = "";
                if (i2 == 200) {
                    i2 = jSONObject.optInt("error_code", -1);
                    str3 = jSONObject.optString("error_msg", "");
                    int i5 = jSONObject.optInt("has_more", 0) != 1 ? 0 : 1;
                    if (i2 == 0) {
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("msgs");
                            LogUtils.d(TAG, "BC> msgArrJson=" + optJSONArray);
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                while (i4 < optJSONArray.length()) {
                                    parserMsg(arrayList, optJSONArray, i4);
                                    i4++;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            i4 = i5;
                            e.printStackTrace();
                            str = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
                            z = i4;
                            i3 = 1010;
                            ChatMsgManagerImpl.getInstance(this.mContext).onMediaFetchChatMsgsResult(this.mListenerKey, i3, str, z, arrayList);
                        }
                    }
                    i4 = i5;
                }
                i3 = i2;
                z = i4;
                str = str3;
            } catch (Exception e3) {
                e = e3;
            }
            ChatMsgManagerImpl.getInstance(this.mContext).onMediaFetchChatMsgsResult(this.mListenerKey, i3, str, z, arrayList);
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.request.IMMediaBaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public /* bridge */ /* synthetic */ boolean shouldAbort() {
        return super.shouldAbort();
    }

    public IMMediaFetchMsgHttpRequest(Context context, long j, int i2, long j2, String str, long j3, long j4, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), str, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContactorType = -1;
        this.mContactorPauid = -1L;
        this.mContext = context;
        this.mContactor = j;
        this.mBeginMsgTime = j3;
        this.mEndMsgTime = j4;
        this.mCount = i3;
        this.mListenerKey = str2;
        this.mContactorType = i2;
        this.mContactorPauid = j2;
        this.mContactorThirdid = str;
    }
}
