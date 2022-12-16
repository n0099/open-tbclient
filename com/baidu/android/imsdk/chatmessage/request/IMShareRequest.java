package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMShareRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMShareRequest";
    public static Random mRandom;
    public transient /* synthetic */ FieldHolder $fh;
    public String mExtTransInfo;
    public String mKey;
    public String mLeaveComments;
    public int mMsgType;
    public String mOriginShareContent;
    public String mShareContent;
    public String mShareIconUrl;
    public String mShareLinkUrl;
    public String mShareSchema;
    public int mShareStiType;
    public String mShareTarget;
    public String mShareTitle;
    public String mSrc;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1755058176, "Lcom/baidu/android/imsdk/chatmessage/request/IMShareRequest;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1755058176, "Lcom/baidu/android/imsdk/chatmessage/request/IMShareRequest;");
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
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

    public IMShareRequest(Context context, String str, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3, Integer.valueOf(i), str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMsgType = -1;
        this.mExtTransInfo = "";
        this.mShareContent = "";
        this.mShareTitle = "";
        this.mShareIconUrl = "";
        this.mShareSchema = "";
        this.mShareLinkUrl = "";
        this.mShareStiType = 2;
        this.mSrc = "";
        this.mContext = context;
        this.mShareTarget = str;
        this.mLeaveComments = str2;
        this.mOriginShareContent = str3;
        this.mMsgType = i;
        this.mKey = str4;
    }

    private String createMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (mRandom == null) {
                synchronized (ChatMsg.class) {
                    if (mRandom == null) {
                        mRandom = new Random(System.currentTimeMillis());
                    }
                }
            }
            return Utility.byte2Hex(long2bytes(((System.nanoTime() & 1048575) << 20) + ((Utility.getTriggerId(this.mContext) & 1023) << 10) + (mRandom.nextInt(1024) & 1023), 5));
        }
        return (String) invokeV.objValue;
    }

    private String generateContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.mShareTitle);
                jSONObject.put("content", this.mShareContent);
                jSONObject.put(IMConstants.SHARE_ICON_URL, this.mShareIconUrl);
                jSONObject.put("sti_command", this.mShareSchema);
                jSONObject.put("linkurl", this.mShareLinkUrl);
                jSONObject.put("sti_type", this.mShareStiType);
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateContent Exception ", e);
            }
            String str = TAG;
            LogUtils.d(str, "generateContent：" + jSONObject.toString());
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    private byte[] long2bytes(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            for (int i2 = i - 1; i2 >= 0; i2--) {
                bArr[i2] = (byte) (255 & j);
                j >>= 8;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    private void parseShareContent() {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, this) != null) || this.mOriginShareContent == null) {
            return;
        }
        try {
            String str = TAG;
            LogUtils.d(str, "mOriginShareContent:" + this.mOriginShareContent.toString());
            JSONObject jSONObject = new JSONObject(this.mOriginShareContent);
            this.mShareTitle = jSONObject.optString("title");
            this.mShareIconUrl = jSONObject.optString("icon_url");
            this.mShareLinkUrl = jSONObject.optString("link_url");
            this.mSrc = jSONObject.optString("source");
            this.mShareContent = jSONObject.optString("content");
            String optString = jSONObject.optString("user_info_scheme");
            if (!TextUtils.isEmpty(optString) && (optJSONObject = new JSONObject(optString).optJSONObject(IMConstants.SHARE_IN_IM)) != null) {
                this.mMsgType = optJSONObject.optInt(IMConstants.SHARE_MSG_TYPE, -1);
                this.mSrc = optJSONObject.optString("src");
                String optString2 = optJSONObject.optString("title");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = this.mShareTitle;
                }
                this.mShareTitle = optString2;
                String optString3 = optJSONObject.optString(IMConstants.SHARE_ICON_URL);
                if (TextUtils.isEmpty(optString3)) {
                    optString3 = this.mShareIconUrl;
                }
                this.mShareIconUrl = optString3;
                String optString4 = optJSONObject.optString("linkurl");
                if (TextUtils.isEmpty(optString4)) {
                    optString4 = this.mShareLinkUrl;
                }
                this.mShareLinkUrl = optString4;
                String optString5 = optJSONObject.optString("content");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = this.mShareContent;
                }
                this.mShareContent = optString5;
                String optString6 = optJSONObject.optString("schema");
                if (TextUtils.isEmpty(optString6)) {
                    optString6 = this.mShareSchema;
                }
                this.mShareSchema = optString6;
                this.mExtTransInfo = optJSONObject.optString(IMConstants.SHARE_EXT_TRANS_INFO);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "Exception ", e);
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            parseShareContent();
            JSONObject jSONObject = new JSONObject();
            try {
                String createMsgKey = createMsgKey();
                jSONObject.put("appid", AccountManager.getAppid(this.mContext));
                jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
                jSONObject.put("app_version", BIMManager.getAppVersion(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("cuid", BIMManager.getCuid(this.mContext));
                jSONObject.put("share_target", this.mShareTarget);
                jSONObject.put("msg_type", this.mMsgType);
                jSONObject.put("content", generateContent());
                jSONObject.put("msg_key", createMsgKey);
                if (!TextUtils.isEmpty(this.mLeaveComments)) {
                    jSONObject.put("leaving_message", this.mLeaveComments);
                    jSONObject.put("msg_key_leaving", createMsgKey());
                }
                if (!TextUtils.isEmpty(this.mExtTransInfo)) {
                    jSONObject.put(IMConstants.SHARE_EXT_TRANS_INFO, this.mExtTransInfo);
                }
                jSONObject.put("src", this.mSrc);
                jSONObject.put("sign", generateSign(jSONObject));
            } catch (Exception e) {
                LogUtils.e(TAG, "Exception ", e);
            }
            String str = TAG;
            LogUtils.d(str, "getRequestParameter :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        }
        return (byte[]) invokeV.objValue;
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
            String hostUrl = BaseHttpRequest.getHostUrl(this.mContext);
            if (hostUrl == null) {
                return null;
            }
            return hostUrl + "rest/3.0/im/share_msg";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onFailure(int i, byte[] bArr, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048581, this, i, bArr, th) == null) {
            Pair<Integer, String> transErrorCode = transErrorCode(i, bArr, th);
            String str = new String(bArr);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack)) {
                ((BIMValueCallBack) removeListener).onResult(((Integer) transErrorCode.first).intValue(), (String) transErrorCode.second, str);
            }
        }
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.ResponseHandler
    public void onSuccess(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, bArr) == null) {
            String str = new String(bArr);
            IMListener removeListener = ListenerManager.getInstance().removeListener(this.mKey);
            if (removeListener != null && (removeListener instanceof BIMValueCallBack) && i == 200) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    ((BIMValueCallBack) removeListener).onResult(jSONObject.optInt("error_code", -1), jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG), str);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Exception on success:", e);
                }
            }
        }
    }
}
