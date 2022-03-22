package com.baidu.sofire.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.BaiduLog;
import com.baidu.sofire.rp.config.ReportConfigInfo;
import com.baidu.sofire.utility.CommonMethods;
import com.baidu.sofire.utility.EncryptUtil;
import com.baidu.sofire.utility.LocalConstant;
import com.baidu.sofire.utility.ProviderAccessUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class SharedPreferenceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AES_KEY = "MzAyMTIxMDJkaWN1ZGlhYg==";
    public static final String MIN_HANDLE_VERSION = "3.5.8.0";
    public static final String OPERATION_GET_BOOLEAN = "getBoolean";
    public static final String OPERATION_GET_FLOAT = "getFloat";
    public static final String OPERATION_GET_INT = "getInt";
    public static final String OPERATION_GET_LONG = "getLong";
    public static final String OPERATION_GET_PERFIX = "get";
    public static final String OPERATION_GET_STRING = "getString";
    public static final String OPERATION_PUT_BOOLEAN = "putBoolean";
    public static final String OPERATION_PUT_FLOAT = "putFloat";
    public static final String OPERATION_PUT_INT = "putInt";
    public static final String OPERATION_PUT_LONG = "putLong";
    public static final String OPERATION_PUT_PERFIX = "put";
    public static final String OPERATION_PUT_STRING = "putString";
    public static final String OPERATION_QUERY = "querySharedHandler";
    public static final String PALTFORM_NAME_SOFIRE = "SOFIRE";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_DEFULT_VALUE = "defult_value";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_HANDLE_PLATFORM = "handle_platform";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_KEY = "key";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_NAME = "pref_name";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_OPERATION = "operation";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_RESULT = "result";
    public static final String PROVIDER_CALL_PREFERENCE_BUNDLE_VALUE = "value";
    public static final String PROVIDER_METHOD_CALL_PREFERENCE = "CallPreferences";
    public static final String SHARED_PREFERENCES_NAME = "leroadcfg";
    public static SharedPreferenceManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Map<String, SharedPreferences> mCustomSharedPreferencesMap;
    public SharedPreferences.Editor mEditor;
    public SharedPreferences.Editor mEditor1;
    public SharedPreferences.Editor mEditor2;
    public String mHandleSharedPlatformName;
    public int mIsMainProcess;
    public SharedPreferences mPref;
    public SharedPreferences mPref1;
    public SharedPreferences mPref2;

    public SharedPreferenceManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHandleSharedPlatformName = null;
        this.mCustomSharedPreferencesMap = new HashMap();
        this.mContext = context;
        int isMainProcess = CommonMethods.isMainProcess(context);
        this.mIsMainProcess = isMainProcess;
        SharedPreferencesWarpper sharedPreferencesWarpper = new SharedPreferencesWarpper(this.mContext, isMainProcess == 1 ? context.getSharedPreferences("leroadcfg", 0) : null, "leroadcfg", false, this.mIsMainProcess);
        this.mPref = sharedPreferencesWarpper;
        SharedPreferences.Editor edit = sharedPreferencesWarpper.edit();
        this.mEditor = edit;
        this.mPref1 = this.mPref;
        this.mEditor1 = edit;
        SharedPreferencesWarpper sharedPreferencesWarpper2 = new SharedPreferencesWarpper(this.mContext, this.mIsMainProcess == 1 ? context.getSharedPreferences("re_po_rt", 0) : null, "re_po_rt", false, this.mIsMainProcess);
        this.mPref2 = sharedPreferencesWarpper2;
        this.mEditor2 = sharedPreferencesWarpper2.edit();
    }

    private SharedPreferences chooseTargetPreferences(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (str.equals("leroadcfg")) {
                return this.mPref;
            }
            if (str.equals("leroadcfg")) {
                return this.mPref1;
            }
            if (str.equals("re_po_rt")) {
                return this.mPref2;
            }
            return getCustomMutiProcessSharedPreferences(str);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static synchronized SharedPreferenceManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (SharedPreferenceManager.class) {
                if (context == null) {
                    return mInstance;
                }
                if (mInstance == null) {
                    mInstance = new SharedPreferenceManager(context);
                }
                return mInstance;
            }
        }
        return (SharedPreferenceManager) invokeL.objValue;
    }

    public int getAesFailedCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPref.getInt("mo_ae_fa_ct", 0) : invokeV.intValue;
    }

    public boolean getAgreePolicy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPref1.getBoolean("s_a_pl", false) : invokeV.booleanValue;
    }

    public int getAlarmCheckTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPref.getInt("appal_te", 24) : invokeV.intValue;
    }

    public String getAliveData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SharedPreferences sharedPreferences = this.mPref2;
            return sharedPreferences.getString("al_da" + str, "");
        }
        return (String) invokeL.objValue;
    }

    public String getAlivePkgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPref2.getString("li_pk_s", "") : (String) invokeV.objValue;
    }

    public boolean getAllowActiveCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPref.getBoolean("a_a_c_b", false) : invokeV.booleanValue;
    }

    public String getAndroidIdTmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String string = this.mPref.getString("p_s_a_i_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(EncryptUtil.aesDecrypt(AES_KEY.getBytes(), Base64.decode(string, 10), true), "UTF-8");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public long getAndroidIdTmpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPref.getLong("p_s_a_i_t_t", 0L) : invokeV.longValue;
    }

    public String getAppKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPref2.getString("re_a_k", "") : (String) invokeV.objValue;
    }

    public int getAppKeySwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPref.getInt("appinv_ky", 1) : invokeV.intValue;
    }

    public int getAppListSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mPref.getInt("appinv_t", 0) : invokeV.intValue;
    }

    public String getCUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPref1.getString("xyus", "") : (String) invokeV.objValue;
    }

    public boolean getCanConn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mPref.getBoolean("s_c_c", true) : invokeV.booleanValue;
    }

    public String getClientVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mPref2.getString("re_a_cv", "") : (String) invokeV.objValue;
    }

    public List<ReportConfigInfo> getConfigInfos() {
        InterceptResult invokeV;
        String[] split;
        ReportConfigInfo stringToConfigInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            String string = this.mPref2.getString("re_con", "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : string.split("\\|\\|")) {
                if (!TextUtils.isEmpty(str) && (stringToConfigInfo = ReportConfigInfo.stringToConfigInfo(str)) != null) {
                    arrayList.add(stringToConfigInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public SharedPreferences getCustomMutiProcessSharedPreferences(String str) {
        InterceptResult invokeL;
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                synchronized (this.mCustomSharedPreferencesMap) {
                    sharedPreferences = this.mCustomSharedPreferencesMap.get(str);
                    if (sharedPreferences == null) {
                        SharedPreferencesWarpper sharedPreferencesWarpper = new SharedPreferencesWarpper(this.mContext, this.mIsMainProcess == 1 ? this.mContext.getSharedPreferences(str, 0) : null, str, false, this.mIsMainProcess);
                        this.mCustomSharedPreferencesMap.put(str, sharedPreferencesWarpper);
                        sharedPreferences = sharedPreferencesWarpper;
                    }
                }
                return sharedPreferences;
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return null;
            }
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public int getDayAlarmTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mPref.getInt("appal_daa", 24) : invokeV.intValue;
    }

    public String getEncodeCUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mPref1.getString("xyusec", "") : (String) invokeV.objValue;
    }

    public String getExternalCuidTmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String string = this.mPref.getString("p_s_e_c_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(EncryptUtil.aesDecrypt(AES_KEY.getBytes(), Base64.decode(string, 10), true), "UTF-8");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public long getExternalCuidTmpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mPref.getLong("p_s_e_c_t_t", 0L) : invokeV.longValue;
    }

    public String getGalaxyCUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mPref1.getString("xygls", "") : (String) invokeV.objValue;
    }

    public String getGalaxyCUIDNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            String string = this.mPref1.getString("xyglsn", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(EncryptUtil.aesDecrypt(AES_KEY.getBytes(), Base64.decode(string, 10), true), "UTF-8");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public List<Integer> getHostCarePluginKeys() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.mPref.getString("hcpk", "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e2) {
                        BaiduLog.logE(e2.getMessage(), e2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String getImeiTmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String string = this.mPref.getString("p_s_i_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(EncryptUtil.aesDecrypt(AES_KEY.getBytes(), Base64.decode(string, 10), true), "UTF-8");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public long getImeiTmpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mPref.getLong("p_s_i_t_t", 0L) : invokeV.longValue;
    }

    public String getInstallData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            SharedPreferences sharedPreferences = this.mPref2;
            return sharedPreferences.getString("in_da" + str, "");
        }
        return (String) invokeL.objValue;
    }

    public int getJsSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mPref.getInt("appinv_js", 0) : invokeV.intValue;
    }

    public long getLastReportUCountTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mPref.getLong("slruct", 0L) : invokeV.longValue;
    }

    public String getLocalChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mPref2.getString("re_a_lc", "") : (String) invokeV.objValue;
    }

    public String getLocalLoadPluginVersion(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            SharedPreferences sharedPreferences = this.mPref;
            return sharedPreferences.getString("g_l_l_p_v_" + i, "");
        }
        return (String) invokeI.objValue;
    }

    public List<Integer> getLocalSetPluginKeys() {
        InterceptResult invokeV;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ArrayList arrayList = new ArrayList();
            String string = this.mPref.getString("glspk", "");
            if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
                for (String str : split) {
                    try {
                        arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                    } catch (NumberFormatException e2) {
                        BaiduLog.logE(e2.getMessage(), e2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public String getMyToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mPref1.getString("xytk_m", "") : (String) invokeV.objValue;
    }

    public String getNewUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mPref1.getString("rpnewuid", "") : (String) invokeV.objValue;
    }

    public String getNewUidNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            String string = this.mPref1.getString("rpnewuidn", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(EncryptUtil.aesDecrypt(AES_KEY.getBytes(), Base64.decode(string, 10), true), "UTF-8");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public long getNextPluginUpdateCheckTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mPref.getLong("npuct", 0L) : invokeV.longValue;
    }

    public int getOncePluginId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mPref.getInt("opi", 0) : invokeV.intValue;
    }

    public SharedPreferences getPlatformPrivateSharedPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mPref : (SharedPreferences) invokeV.objValue;
    }

    public SharedPreferences getPlatformSharedSharedPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mPref1 : (SharedPreferences) invokeV.objValue;
    }

    public int getPluginCheckTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mPref.getInt("appplg_te", 360) : invokeV.intValue;
    }

    public String getPrivacyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mPref.getString("p_s_p_c", "") : (String) invokeV.objValue;
    }

    public long getPullApkFailedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            long j = this.mPref.getLong("pu_ap_fd", 0L);
            if (j == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                setPullApkFailedTime();
                return currentTimeMillis;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public int getPullApkMobileFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mPref.getInt("mo_fa_pu_ap", 0) : invokeV.intValue;
    }

    public int getPullApkWifiFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mPref.getInt("wi_fa_pu_ap", 0) : invokeV.intValue;
    }

    public long getPullCloudFailedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            long j = this.mPref.getLong("pu_cl_fd", 0L);
            if (j == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                setPullCloudFailedTime();
                return currentTimeMillis;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public int getPullCloudMobileFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mPref.getInt("mo_fa_pu_cl", 0) : invokeV.intValue;
    }

    public int getPullCloudWifiFailed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mPref.getInt("wi_fa_pu_cl", 0) : invokeV.intValue;
    }

    public int getPullTokenCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mPref.getInt("tk_sa_pu_cl", 0) : invokeV.intValue;
    }

    public String getReportAliveTime(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, str)) == null) {
            SharedPreferences sharedPreferences = this.mPref2;
            return sharedPreferences.getString("re_net_ali2_" + str, "");
        }
        return (String) invokeL.objValue;
    }

    public int getReportDayLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mPref2.getInt("re_net_dy_lt", 50) : invokeV.intValue;
    }

    public int getReportDelayDataNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mPref2.getInt("g_r_d_d_n", 0) : invokeV.intValue;
    }

    public int getReportLastTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mPref2.getInt("re_net_wt", 3) : invokeV.intValue;
    }

    public int getReportNetworkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mPref2.getInt("re_net_ty", 2) : invokeV.intValue;
    }

    public long getReportOffLineTimestap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mPref2.getLong("re_last_ofline_time", 0L) : invokeV.longValue;
    }

    public int getReportOneceLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mPref2.getInt("re_net_one_lt", 5) : invokeV.intValue;
    }

    public int getReportOverTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mPref2.getInt("re_net_over", 7) : invokeV.intValue;
    }

    public int getReportPollBackHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mPref2.getInt("re_net_hr_bc", 8) : invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r0 < 24) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getReportPollHour() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            int i = 24;
            if ("com.baidu.BaiduMap.meizu".equals(this.mContext.getPackageName())) {
                return this.mPref2.getInt("re_net_hr", 24);
            }
            int i2 = this.mPref2.getInt("re_net_hr", 3);
            try {
                String[] selectAppKeyAndSecurityKey = CommonMethods.selectAppKeyAndSecurityKey(this.mContext);
                if (selectAppKeyAndSecurityKey != null && selectAppKeyAndSecurityKey.length == 2 && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[0]) && !TextUtils.isEmpty(selectAppKeyAndSecurityKey[1]) && "200080".equals(selectAppKeyAndSecurityKey[0])) {
                    if ("com.baidu.BaiduMap".equals(this.mContext.getPackageName())) {
                    }
                }
                i = i2;
                return i;
            } catch (Throwable unused) {
                return i2;
            }
        }
        return invokeV.intValue;
    }

    public int getRequestPluginTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mPref.getInt("rtqe", 0) : invokeV.intValue;
    }

    public boolean getResetDoubleListFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mPref.getBoolean("s_r_d_l_f", false) : invokeV.booleanValue;
    }

    public String getSecurityVerifyInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mPref.getString("svi_n", "") : (String) invokeV.objValue;
    }

    public String getSecurityVerifyInfoMark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mPref.getString("svi", "") : (String) invokeV.objValue;
    }

    public String getSelfVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mPref.getString("ssv", "") : (String) invokeV.objValue;
    }

    public long getSendAesFailTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            long j = this.mPref.getLong("se_ae_fd", 0L);
            if (j == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                setSendAesFailTime();
                return currentTimeMillis;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public String getSettingCuidTmp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            String string = this.mPref.getString("p_s_s_c_t", "");
            if (TextUtils.isEmpty(string)) {
                return "";
            }
            try {
                return new String(EncryptUtil.aesDecrypt(AES_KEY.getBytes(), Base64.decode(string, 10), true), "UTF-8");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public long getSettingCuidTmpTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mPref.getLong("p_s_s_c_t_t", 0L) : invokeV.longValue;
    }

    public int getThreadPoolCoreSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mPref.getInt("s_t_p_c_s", -1) : invokeV.intValue;
    }

    public long getTodayReportBeginTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.mPref2.getLong("re_day_b_t", 0L) : invokeV.longValue;
    }

    public long getTodayReportLen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.mPref2.getLong("re_day_len", 0L) : invokeV.longValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mPref1.getString("xytk", "") : (String) invokeV.objValue;
    }

    public int getUFinishTimesFor1Day() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mPref.getInt("sufzfd", 0) : invokeV.intValue;
    }

    public String getUID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.mPref1.getString("sgud", "") : (String) invokeV.objValue;
    }

    public int getUStartEndTimesForId(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048647, this, i, i2)) == null) {
            String str = i != 0 ? i != 1 ? "" : "suetfite" : "sustfits";
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            SharedPreferences sharedPreferences = this.mPref;
            return sharedPreferences.getInt(str + i2, 0);
        }
        return invokeII.intValue;
    }

    public int getUStartTimesFor1Day() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mPref.getInt("sustfd", 0) : invokeV.intValue;
    }

    public int getUploadNumberCondition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mPref2.getInt("up_nu_co", 50) : invokeV.intValue;
    }

    public int getUploadNumberLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mPref2.getInt("up_nu_li", 100) : invokeV.intValue;
    }

    public Bundle handleRemoteCall(Bundle bundle) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, bundle)) == null) {
            try {
                string = bundle.getString("operation");
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (OPERATION_QUERY.equals(string)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(PROVIDER_CALL_PREFERENCE_BUNDLE_HANDLE_PLATFORM, "sofire");
                return bundle2;
            }
            String string2 = bundle.getString(PROVIDER_CALL_PREFERENCE_BUNDLE_NAME);
            if (TextUtils.isEmpty(string2)) {
                return null;
            }
            String string3 = bundle.getString("key");
            if (TextUtils.isEmpty(string3)) {
                return null;
            }
            SharedPreferences chooseTargetPreferences = chooseTargetPreferences(string2);
            char c2 = 0;
            if (string.startsWith(OPERATION_GET_PERFIX)) {
                String string4 = bundle.getString(PROVIDER_CALL_PREFERENCE_BUNDLE_DEFULT_VALUE);
                if ((OPERATION_GET_STRING.equals(string) || !TextUtils.isEmpty(string4)) && chooseTargetPreferences != null) {
                    Bundle bundle3 = new Bundle();
                    switch (string.hashCode()) {
                        case -1249359687:
                            if (string.equals(OPERATION_GET_INT)) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -75354382:
                            if (string.equals(OPERATION_GET_LONG)) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 804029191:
                            if (string.equals(OPERATION_GET_STRING)) {
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1101572082:
                            if (string.equals(OPERATION_GET_BOOLEAN)) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1953351846:
                            if (string.equals(OPERATION_GET_FLOAT)) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 0) {
                        bundle3.putString("result", chooseTargetPreferences.getString(string3, string4));
                    } else if (c2 == 1) {
                        bundle3.putInt("result", chooseTargetPreferences.getInt(string3, Integer.parseInt(string4)));
                    } else if (c2 == 2) {
                        bundle3.putLong("result", chooseTargetPreferences.getLong(string3, Long.parseLong(string4)));
                    } else if (c2 == 3) {
                        bundle3.putFloat("result", chooseTargetPreferences.getFloat(string3, Float.parseFloat(string4)));
                    } else if (c2 == 4) {
                        bundle3.putBoolean("result", chooseTargetPreferences.getBoolean(string3, Boolean.parseBoolean(string4)));
                    }
                    return bundle3;
                }
                return null;
            }
            if (string.startsWith(OPERATION_PUT_PERFIX)) {
                SharedPreferences.Editor edit = chooseTargetPreferences.edit();
                switch (string.hashCode()) {
                    case -976920992:
                        if (string.equals(OPERATION_PUT_INT)) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -462997504:
                        if (string.equals(OPERATION_PUT_STRING)) {
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -219689429:
                        if (string.equals(OPERATION_PUT_LONG)) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 478450201:
                        if (string.equals(OPERATION_PUT_BOOLEAN)) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1773932685:
                        if (string.equals(OPERATION_PUT_FLOAT)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    edit.putString(string3, bundle.getString("value"));
                } else if (c2 == 1) {
                    edit.putInt(string3, bundle.getInt("value"));
                } else if (c2 == 2) {
                    edit.putLong(string3, bundle.getLong("value"));
                } else if (c2 == 3) {
                    edit.putFloat(string3, bundle.getFloat("value"));
                } else if (c2 == 4) {
                    edit.putBoolean(string3, bundle.getBoolean("value"));
                }
                edit.apply();
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public boolean isInitOnce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.mPref.getBoolean("iio", false) : invokeV.booleanValue;
    }

    public boolean isNeedBackupAPK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.mPref.getBoolean("bka", true) : invokeV.booleanValue;
    }

    public boolean isReportInstall(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, str)) == null) {
            SharedPreferences sharedPreferences = this.mPref2;
            return sharedPreferences.getBoolean("re_net_ins_" + str, false);
        }
        return invokeL.booleanValue;
    }

    public boolean isStartForegroundServiceOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.mPref.getBoolean("se_fg_s", false) : invokeV.booleanValue;
    }

    public void queryWhichCanHandleShared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("operation", OPERATION_QUERY);
            Bundle callSharedProvider = ProviderAccessUtil.callSharedProvider(this.mContext, PROVIDER_METHOD_CALL_PREFERENCE, bundle, false, MIN_HANDLE_VERSION, true);
            if (callSharedProvider != null) {
                this.mHandleSharedPlatformName = callSharedProvider.getString(PROVIDER_CALL_PREFERENCE_BUNDLE_HANDLE_PLATFORM);
            }
        }
    }

    public void setAesFailedCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i) == null) {
            this.mEditor.putInt("mo_ae_fa_ct", i);
            this.mEditor.commit();
        }
    }

    public void setAgreePolicy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.mEditor1.putBoolean("s_a_pl", z);
            if (Build.VERSION.SDK_INT >= 9) {
                this.mEditor1.apply();
            } else {
                this.mEditor1.commit();
            }
        }
    }

    public void setAlarmCheckTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i) == null) {
            this.mEditor.putInt("appal_te", i);
            this.mEditor.commit();
        }
    }

    public void setAliveData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048660, this, str, str2) == null) {
            SharedPreferences.Editor editor = this.mEditor2;
            editor.putString("al_da" + str, str2);
            this.mEditor2.commit();
        }
    }

    public void setAlivePkgs(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, str) == null) {
            this.mEditor2.putString("li_pk_s", str);
            this.mEditor2.commit();
        }
    }

    public void setAllowActiveCallback(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.mEditor.putBoolean("a_a_c_b", z);
            this.mEditor.commit();
        }
    }

    public void setAndroidId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, str) == null) {
            this.mEditor1.putString("rpandid", str);
            this.mEditor1.commit();
        }
    }

    public void setAndroidIdTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_a_i_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_a_i_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setAndroidIdTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048665, this, j) == null) {
            this.mEditor.putLong("p_s_a_i_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, str) == null) {
            this.mEditor2.putString("re_a_k", str);
            this.mEditor2.commit();
        }
    }

    public void setAppKeySwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i) == null) {
            this.mEditor.putInt("appinv_ky", i);
            this.mEditor.commit();
        }
    }

    public void setCUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, str) == null) {
            this.mEditor1.putString("xyus", str);
            this.mEditor1.commit();
        }
    }

    public void setCanConn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048669, this, z) == null) {
            this.mEditor.putBoolean("s_c_c", z);
            if (Build.VERSION.SDK_INT >= 9) {
                this.mEditor.apply();
            } else {
                this.mEditor.commit();
            }
        }
    }

    public void setClientVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, str) == null) {
            this.mEditor2.putString("re_a_cv", str);
            this.mEditor2.commit();
        }
    }

    public void setConfigInfos(ReportConfigInfo reportConfigInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, reportConfigInfo) == null) || reportConfigInfo == null) {
            return;
        }
        String string = this.mPref2.getString("re_con", "");
        SharedPreferences.Editor editor = this.mEditor2;
        editor.putString("re_con", string + "||" + ReportConfigInfo.configInfoToString(reportConfigInfo));
        this.mEditor2.commit();
    }

    public void setDayAlarmTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i) == null) {
            this.mEditor.putInt("appal_daa", i);
            this.mEditor.commit();
        }
    }

    public void setDid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, str) == null) {
            this.mEditor1.putString("s_h_d_id", str);
            if (Build.VERSION.SDK_INT >= 9) {
                this.mEditor1.apply();
            } else {
                this.mEditor1.commit();
            }
        }
    }

    public void setEncodeCUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
            this.mEditor1.putString("xyusec", str);
            this.mEditor1.commit();
        }
    }

    public void setExternalCuidTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_e_c_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_e_c_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setExternalCuidTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048676, this, j) == null) {
            this.mEditor.putLong("p_s_e_c_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setGalaxyCUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, str) == null) {
            this.mEditor1.putString("xygls", str);
            this.mEditor1.commit();
        }
    }

    public void setGalaxyCUIDNew(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor1.putString("xyglsn", "");
                this.mEditor1.commit();
                return;
            }
            try {
                this.mEditor1.putString("xyglsn", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor1.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setGetAppList(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048679, this, i) == null) {
            this.mEditor.putInt("appinv_t", i);
            this.mEditor.commit();
        }
    }

    public void setHostCarePluginKeys(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, iArr) == null) {
            if (iArr != null && iArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < iArr.length; i++) {
                    sb.append(iArr[i]);
                    if (i != iArr.length - 1) {
                        sb.append("-");
                    }
                }
                this.mEditor.putString("hcpk", sb.toString());
            } else {
                this.mEditor.putString("hcpk", "");
            }
            this.mEditor.commit();
        }
    }

    public void setIMEI(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, str) == null) {
            this.mEditor1.putString("rpiiem", str);
            this.mEditor1.commit();
        }
    }

    public void setIMEINew(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048682, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor1.putString("rpiiemn", "");
                this.mEditor1.commit();
                return;
            }
            try {
                this.mEditor1.putString("rpiiemn", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor1.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setImeiTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048683, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_i_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_i_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setImeiTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048684, this, j) == null) {
            this.mEditor.putLong("p_s_i_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setInitOnce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
            this.mEditor.putBoolean("iio", z);
            this.mEditor.commit();
        }
    }

    public void setInstallData(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048686, this, str, str2) == null) {
            SharedPreferences.Editor editor = this.mEditor2;
            editor.putString("in_da" + str, str2);
            this.mEditor2.commit();
        }
    }

    public void setJsSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i) == null) {
            this.mEditor.putInt("appinv_js", i);
            this.mEditor.commit();
        }
    }

    public void setLastReportUCountTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048688, this, j) == null) {
            this.mEditor.putLong("slruct", j);
            this.mEditor.commit();
        }
    }

    public void setLocalChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, str) == null) {
            this.mEditor2.putString("re_a_lc", str);
            this.mEditor2.commit();
        }
    }

    public void setLocalIp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048690, this, str) == null) {
            this.mEditor1.putString("gli", str);
            this.mEditor1.commit();
        }
    }

    public void setLocalLoadPluginVersion(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048691, this, i, str) == null) {
            SharedPreferences.Editor editor = this.mEditor;
            editor.putString("g_l_l_p_v_" + i, str);
            this.mEditor.commit();
        }
    }

    public void setLocalSetPluginKeys(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, list) == null) {
            if (list != null && list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if (i != list.size() - 1) {
                        sb.append("-");
                    }
                }
                this.mEditor.putString("glspk", sb.toString());
            } else {
                this.mEditor.putString("glspk", "");
            }
            this.mEditor.commit();
        }
    }

    public void setMyToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, str) == null) {
            this.mEditor1.putString("xytk_m", str);
            if (Build.VERSION.SDK_INT >= 9) {
                this.mEditor1.apply();
            } else {
                this.mEditor1.commit();
            }
        }
    }

    public void setNeedBackupAPK(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            this.mEditor.putBoolean("bka", z);
            this.mEditor.commit();
        }
    }

    public void setNetworkOperatorTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_n_o_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_n_o_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setNetworkOperatorTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048696, this, j) == null) {
            this.mEditor.putLong("p_s_n_o_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setNewUidNew(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048697, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor1.putString("rpnewuidn", "");
                this.mEditor1.commit();
                return;
            }
            try {
                this.mEditor1.putString("rpnewuidn", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor1.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setNextPluginUpdateCheckTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048698, this, j) == null) {
            this.mEditor.putLong("npuct", j);
            this.mEditor.commit();
        }
    }

    public void setOaidTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_o_d_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_o_d_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setOaidTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048700, this, j) == null) {
            this.mEditor.putLong("p_s_o_d_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setOncePluginId(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048701, this, i) == null) || i <= this.mPref.getInt("opi", 0)) {
            return;
        }
        this.mEditor.putInt("opi", i);
        this.mEditor.commit();
    }

    public void setPluginCheckTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048702, this, i) == null) {
            this.mEditor.putInt("appplg_te", i);
            this.mEditor.commit();
        }
    }

    public void setPrivacyConfig(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, str) == null) {
            this.mEditor.putString("p_s_p_c", str);
            this.mEditor.commit();
        }
    }

    public void setPullApkFailedTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.mEditor.putLong("pu_ap_fd", System.currentTimeMillis());
            this.mEditor.commit();
        }
    }

    public void setPullApkMobileFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i) == null) {
            this.mEditor.putInt("mo_fa_pu_ap", i);
            this.mEditor.commit();
        }
    }

    public void setPullApkWifiFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i) == null) {
            this.mEditor.putInt("wi_fa_pu_ap", i);
            this.mEditor.commit();
        }
    }

    public void setPullCloudFailedTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            this.mEditor.putLong("pu_cl_fd", System.currentTimeMillis());
            this.mEditor.commit();
        }
    }

    public void setPullCloudMobileFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i) == null) {
            this.mEditor.putInt("mo_fa_pu_cl", i);
            this.mEditor.commit();
        }
    }

    public void setPullCloudWifiFailed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i) == null) {
            this.mEditor.putInt("wi_fa_pu_cl", i);
            this.mEditor.commit();
        }
    }

    public void setPullTokenCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i) == null) {
            this.mEditor.putInt("tk_sa_pu_cl", i);
            this.mEditor.commit();
        }
    }

    public void setReportAliveTime(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048711, this, str, str2) == null) {
            SharedPreferences.Editor editor = this.mEditor2;
            editor.putString("re_net_ali2_" + str, str2);
            this.mEditor2.commit();
        }
    }

    public void setReportDayLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048712, this, i) == null) {
            this.mEditor2.putInt("re_net_dy_lt", i);
            this.mEditor2.commit();
        }
    }

    public void setReportDelayDataNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i) == null) {
            this.mEditor2.putInt("g_r_d_d_n", i);
            this.mEditor2.commit();
        }
    }

    public void setReportInstall(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048714, this, str, z) == null) {
            SharedPreferences.Editor editor = this.mEditor2;
            editor.putBoolean("re_net_ins_" + str, z);
            this.mEditor2.commit();
        }
    }

    public void setReportLastTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i) == null) {
            this.mEditor2.putInt("re_net_wt", i);
            this.mEditor2.commit();
        }
    }

    public void setReportNetworkType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i) == null) {
            this.mEditor2.putInt("re_net_ty", i);
            this.mEditor2.commit();
        }
    }

    public void setReportOffLineTimestap(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048717, this, j) == null) {
            this.mEditor2.putLong("re_last_ofline_time", j);
            this.mEditor2.commit();
        }
    }

    public void setReportOneceLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i) == null) {
            this.mEditor2.putInt("re_net_one_lt", i);
            this.mEditor2.commit();
        }
    }

    public void setReportOverTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048719, this, i) == null) {
            this.mEditor2.putInt("re_net_over", i);
            this.mEditor2.commit();
        }
    }

    public void setReportPollBackHour(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048720, this, i) == null) {
            this.mEditor2.putInt("re_net_hr_bc", i);
            this.mEditor2.commit();
        }
    }

    public void setReportPollHour(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i) == null) {
            this.mEditor2.putInt("re_net_hr", i);
            this.mEditor2.commit();
        }
    }

    public void setRequestPluginTimes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048722, this, i) == null) {
            this.mEditor.putInt("rtqe", i);
            this.mEditor.commit();
        }
    }

    public void setResetDoubleListFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.mEditor.putBoolean("s_r_d_l_f", true);
            this.mEditor.commit();
        }
    }

    public void setSecurityVerifyInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048724, this, str, str2) == null) {
            SharedPreferences.Editor editor = this.mEditor;
            editor.putString("svi_n", str + "-" + str2);
            this.mEditor.commit();
        }
    }

    public void setSecurityVerifyInfoMark(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048725, this, str, str2) == null) {
            SharedPreferences.Editor editor = this.mEditor;
            editor.putString("svi", str + "-" + str2);
            this.mEditor.commit();
        }
    }

    public void setSelfVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, str) == null) {
            this.mEditor.putString("ssv", str);
            this.mEditor.commit();
        }
    }

    public void setSendAesFailTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.mEditor.putLong("se_ae_fd", System.currentTimeMillis());
            this.mEditor.commit();
        }
    }

    public void setSettingCuidTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_s_c_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_s_c_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setSettingCuidTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048729, this, j) == null) {
            this.mEditor.putLong("p_s_s_c_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setSimOperatorTmp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.mEditor.putString("p_s_s_o_t", "");
                this.mEditor.commit();
                return;
            }
            try {
                this.mEditor.putString("p_s_s_o_t", new String(Base64.encode(EncryptUtil.aesEncrypt(AES_KEY.getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                this.mEditor.commit();
            } catch (Throwable th) {
                CommonMethods.handleNuLException(th);
            }
        }
    }

    public void setSimOperatorTmpTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048731, this, j) == null) {
            this.mEditor.putLong("p_s_s_o_t_t", j);
            this.mEditor.commit();
        }
    }

    public void setStartForegroundServiceSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z) == null) {
            this.mEditor.putBoolean("se_fg_s", z);
            this.mEditor.commit();
        }
    }

    public void setThreadPoolCoreSize(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048733, this, i) == null) || i > 20) {
            return;
        }
        this.mEditor.putInt("s_t_p_c_s", i);
        this.mEditor.commit();
    }

    public void setTodayReportBeginTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048734, this, j) == null) {
            this.mEditor2.putLong("re_day_b_t", j);
            this.mEditor2.commit();
        }
    }

    public void setTodayReportLen(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048735, this, j) == null) {
            this.mEditor2.putLong("re_day_len", j);
            this.mEditor2.commit();
        }
    }

    public void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, str) == null) {
            this.mEditor1.putString("xytk", str);
            this.mEditor1.commit();
        }
    }

    public void setUFinishTimesFor1Day(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048737, this, i) == null) {
            this.mEditor.putInt("sufzfd", i);
            this.mEditor.commit();
        }
    }

    public void setUID(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, str) == null) {
            this.mEditor1.putString("sgud", str);
            this.mEditor1.commit();
        }
    }

    public void setUStartEndTimesForId(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048739, this, i, i2, i3) == null) {
            String str = i != 0 ? i != 1 ? "" : "suetfite" : "sustfits";
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences.Editor editor = this.mEditor;
            editor.putInt(str + i2, i3);
            this.mEditor.commit();
        }
    }

    public void setUStartTimesFor1Day(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048740, this, i) == null) {
            this.mEditor.putInt("sustfd", i);
            this.mEditor.commit();
        }
    }

    public void setUploadNumberCondition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048741, this, i) == null) {
            this.mEditor2.putInt("up_nu_co", i);
            this.mEditor2.commit();
        }
    }

    public void setUploadNumberLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048742, this, i) == null) {
            this.mEditor2.putInt("up_nu_li", i);
            this.mEditor2.commit();
        }
    }

    public void setWakeupPushTag(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048743, this, j) == null) {
            this.mEditor.putLong(LocalConstant.KEY_AWAKEUP_PUSH_TAG, j);
            this.mEditor.commit();
        }
    }

    public void updateConfigInfos(List<ReportConfigInfo> list, ReportConfigInfo reportConfigInfo) {
        int indexOf;
        ReportConfigInfo reportConfigInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048744, this, list, reportConfigInfo) == null) || reportConfigInfo == null || list == null || (indexOf = list.indexOf(reportConfigInfo)) == -1 || (reportConfigInfo2 = list.get(indexOf)) == null) {
            return;
        }
        this.mEditor2.putString("re_con", this.mPref2.getString("re_con", "").replace(ReportConfigInfo.configInfoToString(reportConfigInfo2), ReportConfigInfo.configInfoToString(reportConfigInfo)));
        this.mEditor2.commit();
    }
}
