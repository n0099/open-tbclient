package com.baidu.android.imsdk.ubc;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
/* loaded from: classes9.dex */
public class MessageUbc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_TYPE = "0";
    public static final String ID_TYPE = "1";
    public static String TAG = "MessageUbc";
    public static final String TYPE = "sendmessage";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public long mEndTime;
    public ChatMsg mSendMsg;
    public long mStartTime;
    public String mUbcId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1335331956, "Lcom/baidu/android/imsdk/ubc/MessageUbc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1335331956, "Lcom/baidu/android/imsdk/ubc/MessageUbc;");
        }
    }

    public MessageUbc(Context context, ChatMsg chatMsg, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mSendMsg = chatMsg;
        this.mStartTime = System.currentTimeMillis();
        this.mUbcId = str;
    }

    private JSONObject generateContent(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.mSendMsg != null && this.mStartTime > 0) {
                try {
                    jSONObject.put("type", TYPE);
                    jSONObject.put("value", str);
                    JSONObject generateExt = generateExt(str, str2);
                    if (generateExt != null) {
                        jSONObject.put("ext", generateExt);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private JSONObject generateDebugInfo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            ChatMsg chatMsg = this.mSendMsg;
            if (chatMsg != null) {
                try {
                    jSONObject.put("sendmsg", chatMsg.toJsonString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private JSONObject generateExt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.mSendMsg != null) {
                try {
                    jSONObject.put("role", AccountManager.getMediaRole(this.mContext) ? "2" : "1");
                    jSONObject.put("package_name", RetrieveReportRequest.APP_NAME);
                    jSONObject.put("appid", String.valueOf(AccountManager.getAppid(this.mContext)));
                    jSONObject.put(LaunchedTaskSpeedStats.KEY_START_TIME, String.valueOf(this.mStartTime));
                    jSONObject.put("endtime", String.valueOf(this.mEndTime));
                    jSONObject.put("cost_time", String.valueOf(this.mEndTime - this.mStartTime));
                    jSONObject.put("error_code", str);
                    jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str2);
                    jSONObject.put("sdk_version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext)));
                    jSONObject.put("res_type", String.valueOf(this.mSendMsg.getMsgType()));
                    jSONObject.put("isgroup", String.valueOf(this.mSendMsg.getCategory()));
                    if (!"0".equals(str)) {
                        jSONObject.put("debug_info", generateDebugInfo(str, str2));
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public JSONArray generateUBCData(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            JSONArray jSONArray = new JSONArray();
            this.mEndTime = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (this.mSendMsg != null && !TextUtils.isEmpty(this.mUbcId)) {
                try {
                    jSONObject.put("id", this.mUbcId);
                    jSONObject.put("timestamp", String.valueOf(this.mStartTime));
                    jSONObject.put(Constant.ID_TYPE, "1");
                    jSONObject.put("type", "0");
                    JSONObject generateContent = generateContent(str, str2);
                    if (generateContent == null) {
                        return null;
                    }
                    jSONObject.put("content", generateContent);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            String str3 = TAG;
            LogUtils.d(str3, "generateUBCData:" + jSONObject.toString());
            if (jSONObject.length() > 0) {
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }
}
