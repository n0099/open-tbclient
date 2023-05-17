package com.baidu.android.imsdk.ubc;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.launched.LaunchedTaskSpeedStats;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.h70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class MessageUbc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_TYPE = "0";
    public static final String ID_TYPE = "1";
    public static String TAG = "MessageUbc";
    public static final String TYPE = "sendmessage";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public DebugInfo mDebugInfo;
    public long mEndTime;
    public ChatMsg mSendMsg;
    public long mStartTime;

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

    /* loaded from: classes.dex */
    public static class DebugInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<String> ackMsgs;
        public String clientLogId;
        public String clientSource;
        public String eventList;
        public long loginId;
        public long methodId;
        public long msgId;
        public int msgSize;
        public long notifyId;
        public String protocolType;

        public DebugInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.msgSize = 1;
            this.eventList = "";
            this.clientLogId = "";
            this.clientSource = "";
            this.ackMsgs = new ArrayList<>();
        }
    }

    public MessageUbc(Context context, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatMsg};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mSendMsg = chatMsg;
        this.mStartTime = System.currentTimeMillis();
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
                    jSONObject.put("ext", generateExt(str, str2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private JSONObject generateDebugInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.mSendMsg != null) {
                try {
                    if (this.mDebugInfo != null) {
                        if (!TextUtils.isEmpty(this.mDebugInfo.eventList)) {
                            jSONObject.put("event_list", this.mDebugInfo.eventList);
                        }
                        if (!TextUtils.isEmpty(this.mDebugInfo.clientLogId)) {
                            jSONObject.put("client_logid", this.mDebugInfo.clientLogId);
                        }
                        if (!TextUtils.isEmpty(this.mDebugInfo.clientSource)) {
                            jSONObject.put("client_business_source", this.mDebugInfo.clientSource);
                        }
                        if (this.mDebugInfo.ackMsgs != null && this.mDebugInfo.ackMsgs.size() > 0) {
                            jSONObject.put("ack_msgs", this.mDebugInfo.ackMsgs.toString());
                        }
                        if (this.mDebugInfo.loginId > 0) {
                            jSONObject.put(Constants.EXTRA_LOGIN_ID, this.mDebugInfo.loginId);
                        }
                        if (!TextUtils.isEmpty(this.mDebugInfo.protocolType)) {
                            jSONObject.put("protocol_type", this.mDebugInfo.protocolType);
                        }
                    }
                    if (!"0".equals(str)) {
                        jSONObject.put(Constants.EXTRA_SEND_MSG, this.mSendMsg.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @NonNull
    private JSONObject generateExt(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.mSendMsg != null) {
                try {
                    if (AccountManager.getMediaRole(this.mContext)) {
                        str3 = "2";
                    } else {
                        str3 = "1";
                    }
                    jSONObject.put("role", str3);
                    jSONObject.put("package_name", RetrieveReportRequest.APP_NAME);
                    jSONObject.put("appid", String.valueOf(AccountManager.getAppid(this.mContext)));
                    jSONObject.put(LaunchedTaskSpeedStats.KEY_START_TIME, String.valueOf(this.mStartTime));
                    jSONObject.put("endtime", String.valueOf(this.mEndTime));
                    jSONObject.put(HiAnalyticsConstant.BI_KEY_COST_TIME, String.valueOf(this.mEndTime - this.mStartTime));
                    jSONObject.put("error_code", str);
                    jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str2);
                    jSONObject.put("sdk_version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext)));
                    jSONObject.put("res_type", String.valueOf(this.mSendMsg.getMsgType()));
                    jSONObject.put("isgroup", String.valueOf(this.mSendMsg.getCategory()));
                    jSONObject.put("category", this.mSendMsg.getCategory());
                    jSONObject.put("businessType", this.mSendMsg.getBusinessType());
                    jSONObject.put("my_imuk", AccountManager.getUK(this.mContext));
                    if (this.mDebugInfo != null) {
                        jSONObject.put("method_id", this.mDebugInfo.methodId);
                        jSONObject.put("msg_id", this.mDebugInfo.msgId);
                        jSONObject.put("msg_size", this.mDebugInfo.msgSize);
                        jSONObject.put(Constants.EXTRA_NOTIFY_ID, this.mDebugInfo.notifyId);
                    }
                    jSONObject.put("msg_key", this.mSendMsg.getMsgKey());
                    jSONObject.put("debug_info", generateDebugInfo(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void uploadUbc(Context context, int i, String str, DebugInfo debugInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65541, null, context, i, str, debugInfo) == null) {
            uploadUbc(context, i, str, debugInfo, new TextMsg());
        }
    }

    public static void uploadUbc(Context context, int i, String str, DebugInfo debugInfo, ChatMsg chatMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, Integer.valueOf(i), str, debugInfo, chatMsg}) == null) {
            MessageUbc messageUbc = new MessageUbc(context, chatMsg);
            messageUbc.setDebugInfo(debugInfo);
            h70.d().f(messageUbc.generateUBCData(String.valueOf(i), str), UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
        }
    }

    @NonNull
    public JSONArray generateUBCData(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            JSONArray jSONArray = new JSONArray();
            this.mEndTime = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (this.mSendMsg != null) {
                try {
                    jSONObject.put("id", UBCConstants.BCSEND_UBCID);
                    jSONObject.put("timestamp", String.valueOf(this.mStartTime));
                    jSONObject.put(Constant.ID_TYPE, "1");
                    jSONObject.put("type", "0");
                    jSONObject.put("content", generateContent(str, str2));
                } catch (JSONException e) {
                    e.printStackTrace();
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

    public ChatMsg getSendMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mSendMsg;
        }
        return (ChatMsg) invokeV.objValue;
    }

    public void setDebugInfo(DebugInfo debugInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, debugInfo) == null) {
            this.mDebugInfo = debugInfo;
        }
    }
}
