package com.baidu.android.imsdk.ubc;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.w60;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CaseUbc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_TYPE = "0";
    public static final String ID_TYPE = "1";
    public static final String TAG = "CaseUbc";
    public static final String UBC_ID = "4952";
    public static String caseType = "imcase_signalling";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(444600181, "Lcom/baidu/android/imsdk/ubc/CaseUbc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(444600181, "Lcom/baidu/android/imsdk/ubc/CaseUbc;");
        }
    }

    /* loaded from: classes.dex */
    public static class DebugInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ChatMsg> chatMsgs;
        public String curClassName;
        public String extInfo;

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
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LcpInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean imStatus;
        public int lcpStatus;
        public int type;

        public LcpInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public CaseUbc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void debugUbc(Context context, String str, int i, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, Integer.valueOf(i), str2, obj}) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", UBC_ID);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put(Constant.ID_TYPE, "1");
                jSONObject.put("type", "0");
                if (obj instanceof DebugInfo) {
                    jSONObject.put("content", generateContent(context, str, "" + i, str2, (DebugInfo) obj));
                } else if (obj instanceof LcpInfo) {
                    jSONObject.put("content", generateContentByLcp(context, str, "" + i, str2, (LcpInfo) obj));
                } else if (obj instanceof JSONObject) {
                    jSONObject.put("ext", obj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtils.d(TAG, "generateUBCData:" + jSONObject.toString());
            if (jSONObject.length() > 0) {
                jSONArray.put(jSONObject);
            }
            w60.d().f(jSONArray, UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
        }
    }

    public static JSONObject generateContent(Context context, String str, String str2, String str3, DebugInfo debugInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, context, str, str2, str3, debugInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                jSONObject.put("ext", generateExt(context, str2, str3, debugInfo));
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateContent:", e);
            }
            LogUtils.d(TAG, "generateContent:" + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    public static JSONObject generateContentByLcp(Context context, String str, String str2, String str3, LcpInfo lcpInfo) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3, lcpInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", str);
                jSONObject.put("ext", generateLcpExt(context, str2, str3, lcpInfo));
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateContent:", e);
            }
            LogUtils.d(TAG, "generateContent:" + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeLLLLL.objValue;
    }

    public static JSONObject generateExt(Context context, String str, String str2, DebugInfo debugInfo) {
        InterceptResult invokeLLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65541, null, context, str, str2, debugInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (AccountManager.getMediaRole(context)) {
                    obj = "2";
                } else {
                    obj = "1";
                }
                jSONObject.put("role", obj);
                jSONObject.put("appid", String.valueOf(AccountManager.getAppid(context)));
                jSONObject.put("error_code", str);
                jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str2);
                jSONObject.put("sdk_version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(context)));
                jSONObject.put(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER, -1);
                jSONObject.put("to_uk", -1);
                JSONObject jSONObject2 = new JSONObject();
                if (debugInfo != null) {
                    if (debugInfo.chatMsgs != null && debugInfo.chatMsgs.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (ChatMsg chatMsg : debugInfo.chatMsgs) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("msg_id", chatMsg.getMsgId());
                            jSONObject3.put("content", chatMsg.getMsgContent());
                            jSONObject3.put(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER, chatMsg.getFromUser());
                            jSONObject3.put("to_uk", chatMsg.getToBduid());
                            jSONArray.put(jSONObject3);
                        }
                        jSONObject2.put("msgs", jSONArray);
                    }
                    jSONObject2.put(DealIntentService.KEY_CLASS, debugInfo.curClassName);
                    jSONObject2.put("ext_info", debugInfo.extInfo);
                }
                jSONObject.put("debug_info", jSONObject2);
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateContent:", e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public static JSONObject generateLcpExt(Context context, String str, String str2, LcpInfo lcpInfo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, context, str, str2, lcpInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", String.valueOf(AccountManager.getAppid(context)));
                jSONObject.put("error_code", str);
                jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, str2);
                jSONObject.put("sdk_version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(context)));
                jSONObject.put("lcp_status", lcpInfo.lcpStatus);
                jSONObject.put("im_status", lcpInfo.imStatus);
                jSONObject.put("type", lcpInfo.type);
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateLcpExt:", e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public static JSONArray generateUBCData(Context context, String str, String str2, DebugInfo debugInfo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, context, str, str2, debugInfo)) == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", UBC_ID);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put(Constant.ID_TYPE, "1");
                jSONObject.put("type", "0");
                jSONObject.put("content", generateContent(context, caseType, str, str2, debugInfo));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtils.d(TAG, "generateUBCData:" + jSONObject.toString());
            if (jSONObject.length() > 0) {
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLLLL.objValue;
    }
}
