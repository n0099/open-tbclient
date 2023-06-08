package com.baidu.tbadk.abtest;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.n95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ABTestSwitchManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PREFERENCES_NAME = "pref_name_abtest";
    public static final String PREF_KEY_SWITCHS = "pref_key_abtest_switchs";
    public static ABTestSwitchManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, ABTestSwitchData> mSwitchs;

    public ABTestSwitchManager() {
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
        this.mSwitchs = new HashMap<>();
        HashMap<String, ABTestSwitchData> allDataFormSharedPref = getAllDataFormSharedPref();
        this.mSwitchs.clear();
        this.mSwitchs.putAll(allDataFormSharedPref);
    }

    private void clearAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            try {
                synchronized (this.mSwitchs) {
                    this.mSwitchs.clear();
                }
                SharedPreferences.Editor edit = getSharedPreferences().edit();
                edit.clear();
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getABTestBranch(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, str2)) == null) {
            ABTestSwitchData aBTestSwitchData = getABTestSwitchData(str);
            if (aBTestSwitchData != null && !TextUtils.isEmpty(aBTestSwitchData.branch)) {
                return aBTestSwitchData.branch;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    private HashMap<String, ABTestSwitchData> getAllDataFormSharedPref() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            HashMap<String, ABTestSwitchData> hashMap = new HashMap<>();
            try {
                JSONArray jSONArray = new JSONArray(getSharedPreferences().getString(PREF_KEY_SWITCHS, "[]"));
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("name");
                        hashMap.put(optString, new ABTestSwitchData(optString, jSONObject.optString("branch"), jSONObject.optString(LocalFilesFilterKt.FILTER_NAME_LOG)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static ABTestSwitchManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mInstance == null) {
                synchronized (ABTestSwitchManager.class) {
                    if (mInstance == null) {
                        mInstance = new ABTestSwitchManager();
                    }
                }
            }
            return mInstance;
        }
        return (ABTestSwitchManager) invokeV.objValue;
    }

    public static String getSharedNameForAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return "pref_name_abtest_" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static SharedPreferences getSharedPreferences() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return TbadkCoreApplication.getInst().getSharedPreferences(getSharedNameForAccount(), 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static boolean isATest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if ("a".equalsIgnoreCase(getInstance().getABTestBranch(str, ""))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isBTest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if ("b".equalsIgnoreCase(getInstance().getABTestBranch(str, ""))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isDefalutTest(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(getInstance().getABTestBranch(str, ""))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized ABTestSwitchData getABTestSwitchData(String str) {
        InterceptResult invokeL;
        ABTestSwitchData aBTestSwitchData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                aBTestSwitchData = this.mSwitchs.get(str);
            }
            return aBTestSwitchData;
        }
        return (ABTestSwitchData) invokeL.objValue;
    }

    public void parseJSONArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray == null) {
                    clearAll();
                    return;
                }
                HashMap hashMap = new HashMap();
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("name");
                        hashMap.put(optString, new ABTestSwitchData(optString, jSONObject.optString("branch"), jSONObject.optString(LocalFilesFilterKt.FILTER_NAME_LOG)));
                    }
                }
                synchronized (this.mSwitchs) {
                    this.mSwitchs.clear();
                    this.mSwitchs.putAll(hashMap);
                }
                EditorHelper.putString(getSharedPreferences(), PREF_KEY_SWITCHS, jSONArray.toString());
                n95 m = n95.m();
                if (isATest(ABTestConst.KEY_PERF_START_TEST)) {
                    i = 1;
                }
                m.z("perf_start_open", i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
