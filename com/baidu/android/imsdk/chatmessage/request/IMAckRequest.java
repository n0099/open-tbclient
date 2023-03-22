package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.MessageParser;
import com.baidu.android.imsdk.request.NewAckMessage;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMAckRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMAckRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public JSONArray mAckList;
    public long mBeginid;
    public int mCategory;
    public long mContacter;
    public int mCount;
    public long mEndid;
    public boolean mIsReliable;
    public String mKey;
    public ArrayList<ChatMsg> mMsgList;
    public long mTriggerId;
    public long mUk;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMAckRequest(Context context, String str, long j, long j2, int i, int i2, long j3, long j4, boolean z, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r4;
            Object[] objArr = {context, str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAckList = new JSONArray();
        this.mContext = context;
        this.mKey = str;
        this.mUk = j;
        this.mContacter = j2;
        this.mCategory = i;
        this.mCount = i2;
        this.mBeginid = j3;
        this.mEndid = j4;
        this.mIsReliable = z;
        this.mMsgList = arrayList;
        this.mTriggerId = Utility.getTriggerId(context);
    }

    public IMAckRequest(Context context, boolean z, NewAckMessage newAckMessage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), newAckMessage};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAckList = new JSONArray();
        this.mContext = context;
        this.mIsReliable = z;
        if (newAckMessage != null) {
            this.mAckList = newAckMessage.getJsonArray();
        }
        this.mTriggerId = Utility.getTriggerId(this.mContext);
    }

    private void getShortAckMsgs(ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, arrayList) == null) {
            LogUtils.d(TAG, "getShortAckMsgs begin~~~");
            new LinkedList();
            List<NewAckMessage.Tripule> handleAck = MessageParser.handleAck(this.mContext, arrayList, false);
            if (handleAck != null && handleAck.size() > 0) {
                Context context = this.mContext;
                NewAckMessage newAckMessage = new NewAckMessage(context, AccountManager.getUK(context), this.mTriggerId, this.mIsReliable);
                newAckMessage.addTriples(handleAck);
                this.mAckList = newAckMessage.getJsonArray();
                LogUtils.d(TAG, "ack msgs: " + this.mAckList);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest
    public String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            TreeSet<String> treeSet = new TreeSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                treeSet.add(keys.next());
            }
            for (String str : treeSet) {
                sb.append(str);
                sb.append("=");
                sb.append(jSONObject.opt(str));
            }
            LogUtils.d(TAG, "sign string:" + ((Object) sb));
            return getMd5(sb.toString());
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return BaseHttpRequest.getHostUrl(this.mContext) + "imsapi/1.0/im_msg_ack/liveshow";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        String jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", Utility.readAppId(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("uk", Utility.getUK(this.mContext));
                jSONObject.put(Constants.KEY_TRIGGER_ID, this.mTriggerId);
                jSONObject.put("device_id", Utility.getDeviceId(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                if (this.mMsgList != null && this.mMsgList.size() > 0) {
                    LogUtils.d(TAG, "mMsgList.size:" + this.mMsgList.size());
                    getShortAckMsgs(this.mMsgList);
                }
                if (this.mAckList == null) {
                    jSONArray = "";
                } else {
                    jSONArray = this.mAckList.toString();
                }
                jSONObject.put("msgs", jSONArray);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (JSONException e) {
                LogUtils.d(TAG, "getRequestParameter error：" + e.toString());
            }
            LogUtils.d(TAG, "IMAckRequest getRequestParameter:" + jSONObject);
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, bArr, th) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + str);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, bArr) == null) {
            String str = new String(bArr);
            LogUtils.d(TAG, "errorCode：" + i + ", resultContent: " + str);
        }
    }
}
