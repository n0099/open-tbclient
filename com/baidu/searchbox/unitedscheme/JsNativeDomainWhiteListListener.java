package com.baidu.searchbox.unitedscheme;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
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
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = JsNativeDomainWhiteListListener.JSNATIVE_DOMAIN_WLIST_ACTION, module = "scheme")
/* loaded from: classes11.dex */
public class JsNativeDomainWhiteListListener extends JSONObjectCommandListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JSNATIVE_DOMAIN_WLIST_ACTION = "jsnative_domain_wlist";
    public static final String JSNATIVE_DOMAIN_WLIST_VERSION = "jsnative_domain_wlist_v";
    public static final String KEY_JSNATIVE_DOMAIN_WHITE_ENABLE = "jsnative_domain_white_list_enable";
    public static final String KEY_JSNATIVE_DOMAIN_WHITE_LIST = "jsnative_domain_white_list";
    public static final String TAG;
    public static final String WHITELIST = "whiteList";
    public static final String WHITELIST_ENABLE = "whiteListEnable";
    public static List<String> domainWhiteList;
    public static String[] localDomainList;
    public static boolean whiteListEnable;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-445544399, "Lcom/baidu/searchbox/unitedscheme/JsNativeDomainWhiteListListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-445544399, "Lcom/baidu/searchbox/unitedscheme/JsNativeDomainWhiteListListener;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
        TAG = JsNativeDomainWhiteListListener.class.getSimpleName();
        domainWhiteList = new ArrayList();
        localDomainList = new String[]{"baidu.com", "nuomi.com", "hao123.com", "baifubao.com", "dxmpay.com", "duxiaoman.com", "mipcdn.com", "wejianzhan.com"};
        whiteListEnable = PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getBoolean(KEY_JSNATIVE_DOMAIN_WHITE_ENABLE, true);
    }

    public JsNativeDomainWhiteListListener() {
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

    public static List<String> getDomainWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (domainWhiteList.size() == 0) {
                try {
                    setDomainWhiteList(new JSONArray(PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(KEY_JSNATIVE_DOMAIN_WHITE_LIST, "")));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            domainWhiteList.addAll(Arrays.asList(localDomainList));
            return domainWhiteList;
        }
        return (List) invokeV.objValue;
    }

    public static void setDomainWhiteList(JSONArray jSONArray) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONArray) == null) || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        domainWhiteList.clear();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                str = jSONArray.get(i2).toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
                str = "";
            }
            domainWhiteList.add(str);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048576, this, context, str, str2, commandPostData) == null) || commandPostData == null || commandPostData.getVersion() == null) {
            return;
        }
        commandPostData.getVersion().put(JSNATIVE_DOMAIN_WLIST_ACTION, getLocalVersion(context, str, str2));
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, actionData)) == null) {
            if (actionData == null || !TextUtils.equals(str2, JSNATIVE_DOMAIN_WLIST_ACTION) || TextUtils.isEmpty(actionData.version)) {
                return false;
            }
            if (!TextUtils.equals(actionData.version, getLocalVersion(context, str, str2)) && actionData.data != null) {
                if (DEBUG) {
                    String str3 = "value.data " + actionData.data;
                }
                setDomainWhiteList(actionData.data.optJSONArray(WHITELIST));
                whiteListEnable = actionData.data.optBoolean(WHITELIST_ENABLE, true);
                PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).edit().putString(JSNATIVE_DOMAIN_WLIST_VERSION, actionData.version).putBoolean(KEY_JSNATIVE_DOMAIN_WHITE_ENABLE, whiteListEnable).putString(KEY_JSNATIVE_DOMAIN_WHITE_LIST, actionData.data.toString()).apply();
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, str2)) == null) ? PreferenceManager.getDefaultSharedPreferences(SchemeConfig.getAppContext()).getString(JSNATIVE_DOMAIN_WLIST_VERSION, "0") : (String) invokeLLL.objValue;
    }
}
