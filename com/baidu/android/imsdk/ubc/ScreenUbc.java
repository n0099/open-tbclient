package com.baidu.android.imsdk.ubc;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.retrieve.RetrieveReportRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.i80;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ScreenUbc {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EVENT_TYPE = "0";
    public static final String ID_TYPE = "1";
    public static final String TAG = "ScreenUbc";
    public static final String UBC_ID = "5735";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class MethodInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String clientLogId;
        public long endTime;
        public int errCode;
        public String errMsg;
        public JSONArray eventList;
        public String method;
        public long startTime;

        public MethodInfo() {
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
            this.method = "";
            this.clientLogId = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.errCode = -1;
            this.errMsg = "";
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "MethodInfo{method='" + this.method + "', clientLogId='" + this.clientLogId + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", errCode=" + this.errCode + ", errMsg='" + this.errMsg + "', eventList=" + this.eventList + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public ScreenUbc() {
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

    public static JSONObject generateContent(Context context, String str, MethodInfo methodInfo) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, methodInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", RetrieveReportRequest.APP_NAME);
                if (AccountManager.getMediaRole(context)) {
                    str2 = "bjh";
                } else {
                    str2 = "c_user";
                }
                jSONObject.put("type", str2);
                jSONObject.put("ext", generateExt(context, str, methodInfo));
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateContent:", e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject generateExt(Context context, String str, MethodInfo methodInfo) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, methodInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", String.valueOf(AccountManager.getAppid(context)));
                jSONObject.put("sdk_version", String.valueOf(IMConfigInternal.getInstance().getSDKVersionValue(context)));
                jSONObject.put("my_uk", String.valueOf(AccountManager.getUK(context)));
                if (BIMManager.isIMLogined(context)) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                jSONObject.put("im_status", str2);
                jSONObject.put("key", str);
                jSONObject.put("method", methodInfo.method);
                jSONObject.put("error_code", String.valueOf(methodInfo.errCode));
                jSONObject.put(GameCodeGetResponseMsg.PARAM_ERROR_MSG, methodInfo.errMsg);
                jSONObject.put("client_logid", methodInfo.clientLogId);
                jSONObject.put("start_time", String.valueOf(methodInfo.startTime));
                jSONObject.put("end_time", String.valueOf(methodInfo.endTime));
                if (methodInfo.eventList != null && methodInfo.eventList.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("event_list", methodInfo.eventList);
                    jSONObject.put("ext", jSONObject2.toString());
                }
            } catch (JSONException e) {
                LogUtils.e(TAG, "generateExt:", e);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static void onEvent(Context context, String str, MethodInfo methodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, methodInfo) == null) {
            if (!Utility.isScreenStatis(context, str)) {
                LogUtils.d(TAG, "onEvent isScreenStatis = false");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", UBC_ID);
                jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put(Constant.ID_TYPE, "1");
                jSONObject.put("type", "0");
                jSONObject.put("content", generateContent(context, str, methodInfo));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtils.d(TAG, "generateUBCData:" + jSONObject.toString());
            if (jSONObject.length() > 0) {
                jSONArray.put(jSONObject);
            }
            i80.d().f(jSONArray, UBCConstants.IS_REAL, UBCConstants.IS_SAVE_DB, UBCConstants.IS_ASYNC);
        }
    }
}
