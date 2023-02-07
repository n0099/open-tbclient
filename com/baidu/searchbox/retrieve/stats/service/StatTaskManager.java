package com.baidu.searchbox.retrieve.stats.service;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class StatTaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FetchStatManager";
    public static volatile StatTaskManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public UBCManager mUBCManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(43804394, "Lcom/baidu/searchbox/retrieve/stats/service/StatTaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(43804394, "Lcom/baidu/searchbox/retrieve/stats/service/StatTaskManager;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public StatTaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public static StatTaskManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mInstance == null) {
                synchronized (StatTaskManager.class) {
                    if (mInstance == null) {
                        mInstance = new StatTaskManager();
                    }
                }
            }
            return mInstance;
        }
        return (StatTaskManager) invokeV.objValue;
    }

    private JSONObject generateActiveExtData(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("dataId", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(StatConstants.KEY_EXT_TASK_TYPE, str2);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private JSONObject generateRetrieveExtData(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, str2, str3, str4, str5, str6, jSONObject})) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("jobId", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put(StatConstants.KEY_EXT_TASK_TYPE, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("version", str3);
                }
                JSONObject jSONObject3 = new JSONObject();
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject3.put(StatConstants.KEY_EXT_ERR_CODE, str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject3.put(StatConstants.KEY_EXT_ERR_MSG, str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    jSONObject3.put(StatConstants.KEY_EXT_FILE_ID, str6);
                }
                if (jSONObject != null) {
                    jSONObject3.put("fileMeta", jSONObject);
                }
                if (jSONObject3.length() > 0) {
                    jSONObject2.put("detail", jSONObject3);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (jSONObject2.length() > 0) {
                return jSONObject2;
            }
            return null;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    private void recordRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4, str5, str6, str7, jSONObject}) != null) || this.mUBCManager == null) {
            return;
        }
        recordUBCData(StatConstants.STAT_RETRIEVE_ID, StatConstants.VALUE_FROM_RETRIEVE, str, null, z, generateRetrieveExtData(str2, str3, str4, str5, str6, str7, jSONObject));
    }

    private void recordUBCData(String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z), jSONObject}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", str2);
                jSONObject2.put("type", str3);
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("page", str4);
                }
                if (z) {
                    jSONObject2.put("value", "1");
                } else {
                    jSONObject2.put("value", "0");
                }
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            if (DEBUG) {
                Log.d(TAG, "id: " + str + ", content: " + jSONObject2.toString());
            }
            this.mUBCManager.onEvent(str, jSONObject2);
        }
    }

    public void recordActiveUploadData(boolean z, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4}) != null) || this.mUBCManager == null) {
            return;
        }
        recordUBCData(StatConstants.STAT_ACTIVE_ID, StatConstants.VALUE_FROM_AC_UPLOAD, str, str4, z, generateActiveExtData(str2, str3));
    }

    public void recordCheckRetrieveData(boolean z, boolean z2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, str3, str4}) != null) || this.mUBCManager == null) {
            return;
        }
        String str5 = StatConstants.VALUE_TYPE_CLIENT_CHECK;
        String str6 = "";
        if (!z) {
            str5 = StatConstants.VALUE_TYPE_SERVER_CHECK;
        } else if (!z2) {
            char c = 65535;
            switch (str4.hashCode()) {
                case 49:
                    if (str4.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str4.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str4.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        str6 = StatConstants.ERR_MSG_CLIENT_CHECK_EXPIRED;
                    }
                } else {
                    str6 = StatConstants.ERR_MSG_CLIENT_CHECK_WRONG;
                }
            } else {
                str6 = StatConstants.ERR_MSG_CLIENT_CHECK_EMPTY;
            }
        }
        recordRetrieveData(str5, z2, str, str2, str3, str4, str6, "", null);
    }

    public void recordDispatchRetrieveData(boolean z, String str, String str2, String str3, String str4) {
        String str5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, str2, str3, str4}) != null) || this.mUBCManager == null) {
            return;
        }
        if (!z) {
            char c = 65535;
            int hashCode = str4.hashCode();
            if (hashCode != 49) {
                if (hashCode == 50 && str4.equals("2")) {
                    c = 1;
                }
            } else if (str4.equals("1")) {
                c = 0;
            }
            if (c != 0) {
                if (c == 1) {
                    str5 = StatConstants.ERR_MSG_DISPATCH_NET_WRONG;
                }
            } else {
                str5 = StatConstants.ERR_MSG_DISPATCH_NOT_REGISTER;
            }
            recordRetrieveData(StatConstants.VALUE_TYPE_DISPATCH, z, str, str2, str3, str4, str5, "", null);
        }
        str5 = "";
        recordRetrieveData(StatConstants.VALUE_TYPE_DISPATCH, z, str, str2, str3, str4, str5, "", null);
    }

    public void recordReceiveRetrieveData(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || this.mUBCManager == null) {
            return;
        }
        recordRetrieveData(StatConstants.VALUE_TYPE_RECEIVE, z, "", "", "", "", "", "", null);
    }

    public void recordUploadRetrieveData(String str, boolean z, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4, str5, str6, jSONObject}) != null) || this.mUBCManager == null) {
            return;
        }
        recordRetrieveData(str, z, str2, str3, str4, "", str5, str6, jSONObject);
    }
}
