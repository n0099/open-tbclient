package com.baidu.tbadk.core.util.schemeaction;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SchemeActionHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> NEED_MAIN_TAB_SCHEMA_LIST;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(282017854, "Lcom/baidu/tbadk/core/util/schemeaction/SchemeActionHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(282017854, "Lcom/baidu/tbadk/core/util/schemeaction/SchemeActionHelper;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        NEED_MAIN_TAB_SCHEMA_LIST = arrayList;
        arrayList.add(UrlSchemaHelper.SCHEMA_GAME_RECOMMENT_PAGE);
    }

    public SchemeActionHelper() {
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

    public static JSONObject getParams(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uri)) == null) {
            return getParams(uri, "params");
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String getSchemeAction(UriBuilder uriBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uriBuilder)) == null) {
            if (uriBuilder != null && uriBuilder.isValidated()) {
                return parserSchemeAction(uriBuilder.getUriString());
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isPushPbUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (yi.isEmpty(str) || !Pattern.compile("http[s]?://tieba.baidu.com/p").matcher(str).find()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isTieBaAppSchemeHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (!yi.isEmpty(str) && str.startsWith("tiebaapp")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean needMainTabActivity(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            for (String str2 : NEED_MAIN_TAB_SCHEMA_LIST) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void printLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65550, null, str) == null) && TbadkCoreApplication.getInst().isDebugMode()) {
            Log.d("TiebaSchemeAction", str);
        }
    }

    public static JSONObject getParams(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, uri, str)) == null) {
            if (uri == null) {
                return new JSONObject();
            }
            String queryParameter = uri.getQueryParameter(str);
            if (yi.isEmpty(queryParameter)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(queryParameter);
            } catch (Exception unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String getSafeQueryParameter(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, str)) == null) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getValueFromParams(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, uri, str)) == null) {
            JSONObject params = getParams(uri);
            if (params == null) {
                return "";
            }
            return params.optString(str, "");
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isSchemeAction(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            if (yi.isEmpty(str)) {
                return false;
            }
            String parserSchemeAction = parserSchemeAction(str);
            if (yi.isEmpty(parserSchemeAction)) {
                return false;
            }
            return str2.equalsIgnoreCase(parserSchemeAction);
        }
        return invokeLL.booleanValue;
    }

    public static String getSchemeHeaderFromLink(String str) {
        InterceptResult invokeL;
        String[] split;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (yi.isEmpty(str) || (split = str.split("\\:\\/\\/")) == null || split.length == 0 || (str2 = split[0]) == null || str2.length() <= 0) {
                return null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String parserSchemeAction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (yi.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("\\?");
            if (split != null && split.length != 0) {
                String str2 = split[0];
                String[] split2 = str2.split("\\/\\/");
                if (split2 == null || split2.length < 2) {
                    return null;
                }
                return str2;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isToMaintab(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, intent)) == null) {
            if (intent != null) {
                String action = intent.getAction();
                Set<String> categories = intent.getCategories();
                String stringExtra = intent.getStringExtra(MainTabActivityConfig.TARGET_SCHEME_BAK);
                if (yi.isEmpty(stringExtra)) {
                    stringExtra = intent.getStringExtra("target_scheme");
                }
                if ((!TextUtils.equals(action, "android.intent.action.MAIN") || categories == null || !categories.contains("android.intent.category.LAUNCHER")) && !yi.isEmpty(stringExtra)) {
                    if (isPushPbUrl(stringExtra) || needMainTabActivity(stringExtra)) {
                        return false;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Uri replaceUriParameter(Uri uri, String str, String str2) {
        InterceptResult invokeLLL;
        String queryParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, uri, str, str2)) == null) {
            if (uri != null && !TextUtils.isEmpty(str)) {
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                Uri.Builder clearQuery = uri.buildUpon().clearQuery();
                for (String str3 : queryParameterNames) {
                    if (str3.equals(str)) {
                        queryParameter = str2;
                    } else {
                        queryParameter = uri.getQueryParameter(str3);
                    }
                    clearQuery.appendQueryParameter(str3, queryParameter);
                }
                return clearQuery.build();
            }
            return null;
        }
        return (Uri) invokeLLL.objValue;
    }

    public static String replaceUrlParameter(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Uri replaceUriParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, str, str2, str3)) == null) {
            if (str == null || TextUtils.isEmpty(str2) || (replaceUriParameter = replaceUriParameter(Uri.parse(str), str2, str3)) == null) {
                return null;
            }
            return replaceUriParameter.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
