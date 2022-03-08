package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = SchemeUsageStatisticsListener.STATISTIC_SWITCH_ACTION, module = "scheme")
/* loaded from: classes4.dex */
public class SchemeUsageStatisticsListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JSINTERFACE_SWITCH_LIST = "jsinterface_switch_list";
    public static final String SCHEME_SWITCH_LIST = "scheme_switch_list";
    public static final String STATISTIC_SWITCH_ACTION = "statistic_switch";
    public static final String STATISTIC_SWITCH_VERSION = "statistic_switch_v";
    public static final String TAG;
    public static ArrayList<String> jsinterfaceList;
    public static ArrayList<String> schemeList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1653799637, "Lcom/baidu/searchbox/unitedscheme/SchemeUsageStatisticsListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1653799637, "Lcom/baidu/searchbox/unitedscheme/SchemeUsageStatisticsListener;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        TAG = SchemeUsageStatisticsListener.class.getSimpleName();
        schemeList = new ArrayList<>();
        jsinterfaceList = new ArrayList<>();
    }

    public SchemeUsageStatisticsListener() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ArrayList<String> getStatisticJsinterfaceList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (jsinterfaceList.size() == 0) {
                String string = PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(JSINTERFACE_SWITCH_LIST, "");
                try {
                    if (!TextUtils.isEmpty(string)) {
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() > 0) {
                            setDataList(jSONArray, jsinterfaceList);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jsinterfaceList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static ArrayList<String> getStatisticSchemeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (schemeList.size() == 0) {
                String string = PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(SCHEME_SWITCH_LIST, "");
                try {
                    if (!TextUtils.isEmpty(string)) {
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() > 0) {
                            setDataList(jSONArray, schemeList);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return schemeList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static String getUrlWithoutQuery(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                Uri parse = Uri.parse(str);
                return parse.getScheme() + "://" + parse.getAuthority() + parse.getPath();
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    return "";
                }
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void setDataList(JSONArray jSONArray, List<String> list) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, jSONArray, list) == null) || jSONArray == null) {
            return;
        }
        list.clear();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                str = jSONArray.get(i2).toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                str = "";
            }
            list.add(str);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) || commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(STATISTIC_SWITCH_ACTION, getLocalVersion(context, str, str2));
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (actionData == null || !TextUtils.equals(str2, STATISTIC_SWITCH_ACTION) || TextUtils.isEmpty(actionData.version)) {
                return false;
            }
            if (!TextUtils.equals(actionData.version, getLocalVersion(context, str, str2)) && actionData.data != null) {
                if (DEBUG) {
                    String str3 = "value.data " + actionData.data;
                }
                JSONArray optJSONArray = actionData.data.optJSONArray(SCHEME_SWITCH_LIST);
                setDataList(optJSONArray, schemeList);
                JSONArray optJSONArray2 = actionData.data.optJSONArray(JSINTERFACE_SWITCH_LIST);
                setDataList(optJSONArray2, jsinterfaceList);
                PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(STATISTIC_SWITCH_VERSION, actionData.version).putString(SCHEME_SWITCH_LIST, optJSONArray == null ? "" : optJSONArray.toString()).putString(JSINTERFACE_SWITCH_LIST, optJSONArray2 != null ? optJSONArray2.toString() : "").apply();
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(STATISTIC_SWITCH_VERSION, "0") : (String) invokeLLL.objValue;
    }
}
