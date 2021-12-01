package com.baidu.fsg.base.restnet.beans.business.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.restnet.beans.business.BeanConstants;
import com.baidu.fsg.base.restnet.fp.a;
import com.baidu.fsg.base.utils.SharedPreferencesUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.walletfacesdk.LightInvokerImpl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class BdWalletUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEVICE_FP = "rim_device_fp";
    public static final String PREF_FILE_NAME_FP = "__RIM_SDK_FP_V1";
    public static final String RIM_ALLCONFIG = "rim_allconfig";
    public static final String RIM_ALLCONFIG_CHANGESIGN = "rim_allconfig_changesign";
    public static final String RIM_EXPS = "rim_exps";
    public static final String RIM_SO_DOWN_LOAD = "rim_so_down_load_info";
    public transient /* synthetic */ FieldHolder $fh;

    public BdWalletUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void addFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            activity.getWindow().addFlags(8192);
        }
    }

    public static void cleanExps(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_EXPS, "");
        }
    }

    public static void clearFlagsSecure(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            activity.getWindow().clearFlags(8192);
        }
    }

    public static String getDeviceFP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            String str = (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, DEVICE_FP, "");
            return !TextUtils.isEmpty(str) ? RimArmor.getInstance().localDecrypt(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getExps(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_EXPS, "") : (String) invokeL.objValue;
    }

    public static String getFPFileLastModified(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            File file = new File("/data/data/" + context.getPackageName() + "/shared_prefs/" + PREF_FILE_NAME_FP + ActivityChooserModel.HISTORY_FILE_EXTENSION);
            if (file.exists()) {
                return "" + (file.lastModified() / 1000);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getRimAllConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG, "") : (String) invokeL.objValue;
    }

    public static String getRimAllConfigChangesign(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG_CHANGESIGN, "") : (String) invokeL.objValue;
    }

    public static String getRimSoDownLoad(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? (String) SharedPreferencesUtils.getParam(context, PREF_FILE_NAME_FP, RIM_SO_DOWN_LOAD, "") : (String) invokeL.objValue;
    }

    public static String getSpNo(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split2 = str.split("&");
                    if (split2 != null && split2.length > 0) {
                        for (String str2 : split2) {
                            if (str2 != null && (split = str2.split("=")) != null && split.length == 2) {
                                hashMap.put(split[0], split[1]);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return hashMap.containsKey("sp_no") ? (String) hashMap.get("sp_no") : "";
        }
        return (String) invokeL.objValue;
    }

    public static String getSpParams(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
            if (map != null) {
                if (map.get(LightInvokerImpl.SP_PARAMS) != null) {
                    return map.get(LightInvokerImpl.SP_PARAMS) + "";
                } else if (map.get("sp_params") != null) {
                    return map.get("sp_params") + "";
                } else if (map.get("supPro") != null) {
                    return "sp_no=" + map.get("supPro");
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isSpnoValidate(Map<String, Object> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, map)) == null) ? !BeanConstants.TestSpNo.equals(getSpNo(getSpParams(map))) || BeanConstants.TestRimId.equals(BeanConstants.RIMID) : invokeL.booleanValue;
    }

    public static void loadDeviceFP(Context context, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, context, map) == null) {
            a aVar = new a(context.getApplicationContext());
            aVar.a(getSpParams(map));
            aVar.setResponseCallback(new IBeanResponseCallback() { // from class: com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
                public void onBeanExecFailure(int i2, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str) == null) {
                    }
                }

                @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
                public void onBeanExecSuccess(int i2, Object obj, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), obj, str, str2}) == null) {
                    }
                }
            });
            aVar.execBean();
        }
    }

    public static void realTimeStatistics(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65550, null, context, str, str2, str3, str4) == null) {
            com.baidu.fsg.base.restnet.c.a aVar = new com.baidu.fsg.base.restnet.c.a(context);
            aVar.setSpParameter(str);
            aVar.a(str2, str3, str4);
            aVar.execBean();
        }
    }

    public static void setDeviceFP(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) || str == null) {
            return;
        }
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, DEVICE_FP, RimArmor.getInstance().localEncryptProxy(str));
    }

    public static void setExps(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_EXPS, str);
    }

    public static void setRimAllConfiChangeSign(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG_CHANGESIGN, str);
    }

    public static void setRimAllConfig(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65554, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_ALLCONFIG, str);
    }

    public static void setRimSoDownload(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65555, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.setParam(context, PREF_FILE_NAME_FP, RIM_SO_DOWN_LOAD, str);
    }
}
