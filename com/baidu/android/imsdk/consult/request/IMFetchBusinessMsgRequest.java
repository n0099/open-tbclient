package com.baidu.android.imsdk.consult.request;

import android.content.Context;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.request.Type;
import com.baidu.android.imsdk.consult.db.BusinessMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMFetchBusinessMsgRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_MSG_BEGIN_MIN = 1;
    public static final String TAG = "IMFetchBusinessMsgRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public int mBusiType;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public IMediaFetchChatMsgsListener mListener;
    public long mMsgBegin;
    public long mMsgEnd;
    public int mSessionType;
    public String mSource;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMFetchBusinessMsgRequest(Context context, int i, int i2, int i3, long j, long j2, long j3, int i4, String str, IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), str, iMediaFetchChatMsgsListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSource = "";
        this.mContext = context;
        this.mBusiType = i;
        this.mCategory = i2;
        this.mSessionType = i3;
        this.mContacter = j;
        this.mMsgBegin = j2;
        this.mMsgEnd = j3;
        this.mCount = i4;
        this.mSource = str;
        this.mListener = iMediaFetchChatMsgsListener;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            hashMap.put("Cookie", "BDUSS=" + bduss);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (BaseHttpRequest.getHostUrl(this.mContext) == null) {
                return null;
            }
            return BaseHttpRequest.getHostUrl(this.mContext) + "rest/3.0/im/fetch_msg_by_contacter_client";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put("host_device_type", 2);
                jSONObject.put("contacter", this.mContacter);
                jSONObject.put("business_type", this.mBusiType);
                jSONObject.put("category", this.mCategory);
                jSONObject.put("session_type", this.mSessionType);
                jSONObject.put("timestamp", currentTimeMillis);
                long j = 1;
                if (this.mMsgBegin >= 1) {
                    j = this.mMsgBegin;
                }
                jSONObject.put(Constants.EXTRA_BEGIN_MSGID, j);
                jSONObject.put(Constants.EXTRA_END_MSGID, this.mMsgEnd);
                jSONObject.put("count", this.mCount);
                jSONObject.put("client_business_source", this.mSource);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException unused) {
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
            IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener = this.mListener;
            if (iMediaFetchChatMsgsListener != null) {
                iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, false, null);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.Long] */
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "onSuccess result = " + str);
            String str2 = Constants.ERROR_MSG_SUCCESS;
            JSONArray jSONArray = new JSONArray();
            boolean z = false;
            ArrayList<ChatMsg> arrayList = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.getInt("error_code");
                str2 = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "");
                if (i == 0) {
                    jSONArray = jSONObject.optJSONArray(NotificationCompat.CarExtender.KEY_MESSAGES);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        Type type = new Type();
                        type.t = 0L;
                        arrayList = MessageParser.parserMessage(this.mContext, jSONArray, type, true, true);
                    }
                    z = jSONObject.optBoolean("has_more", false);
                }
            } catch (JSONException unused) {
            }
            if (this.mBusiType == 27 && arrayList != null && arrayList.size() > 0) {
                BusinessMessageDBManager.getInstance(this.mContext).insertBusinessChatMsg(this.mBusiType, arrayList);
            }
            IMediaFetchChatMsgsListener iMediaFetchChatMsgsListener = this.mListener;
            if (iMediaFetchChatMsgsListener != null) {
                iMediaFetchChatMsgsListener.onMediaFetchChatMsgsResult(i, str2, z, arrayList);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                IMAckBusinessMsgRequest iMAckBusinessMsgRequest = new IMAckBusinessMsgRequest(this.mContext, jSONArray);
                HttpHelper.executor(this.mContext, iMAckBusinessMsgRequest, iMAckBusinessMsgRequest);
            }
        }
    }
}
