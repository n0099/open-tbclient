package com.baidu.searchbox.unitedscheme.utils;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.InvokeSchemeInfo;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class UnitedSchemeUtility {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String PARAMS_KEY = "params";
    public static final String TAG = "UnitedSchemeUtility";
    public static InvokeSchemeInfo currentLongestScheme;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1696045694, "Lcom/baidu/searchbox/unitedscheme/utils/UnitedSchemeUtility;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1696045694, "Lcom/baidu/searchbox/unitedscheme/utils/UnitedSchemeUtility;");
                return;
            }
        }
        DEBUG = SchemeConfig.DEBUG;
        currentLongestScheme = new InvokeSchemeInfo();
    }

    public UnitedSchemeUtility() {
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

    public static JSONObject callCallback(CallbackHandler callbackHandler, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, callbackHandler, str, i)) == null) {
            JSONObject wrapCallbackParams = wrapCallbackParams(i);
            return TextUtils.isEmpty(str) ? wrapCallbackParams : callCallback(callbackHandler, new UnitedSchemeEntity(Uri.parse(str)), wrapCallbackParams);
        }
        return (JSONObject) invokeLLI.objValue;
    }

    public static String getAction(Uri uri) {
        InterceptResult invokeL;
        List<String> pathSegments;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, uri)) == null) {
            if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0) {
                return null;
            }
            return pathSegments.get(pathSegments.size() - 1);
        }
        return (String) invokeL.objValue;
    }

    public static String getErrMessage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            if (i != 0) {
                if (i != 101) {
                    if (i != 201) {
                        if (i != 202) {
                            if (i != 301) {
                                if (i != 302) {
                                    switch (i) {
                                        case 401:
                                            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14bf);
                                        case 402:
                                            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14bc);
                                        case 403:
                                            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14bd);
                                        default:
                                            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c4);
                                    }
                                }
                                return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14be);
                            }
                            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c0);
                        }
                        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c3);
                    }
                    return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c4);
                }
                return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c1);
            }
            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f14c2);
        }
        return (String) invokeI.objValue;
    }

    public static String[] getModules(Uri uri) {
        InterceptResult invokeL;
        List<String> pathSegments;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0) {
                return null;
            }
            try {
                String[] strArr = (String[]) pathSegments.toArray(new String[0]);
                return (String[]) Arrays.copyOfRange(strArr, 0, strArr.length - 1);
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static HashMap<String, String> getParams(String str) {
        InterceptResult invokeL;
        String substring;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            updateCurrentLongestScheme(str);
            HashMap<String, String> hashMap = new HashMap<>();
            if (TextUtils.isEmpty(str)) {
                return hashMap;
            }
            int indexOf = str.indexOf("?");
            int indexOf2 = str.indexOf("#");
            if (indexOf < 0) {
                return hashMap;
            }
            if (indexOf2 >= 0) {
                int i = indexOf + 1;
                if (indexOf2 > i) {
                    substring = str.substring(i, indexOf2);
                }
                return hashMap;
            }
            substring = str.substring(indexOf + 1);
            String[] split = substring.split("&");
            if (split == null) {
                return hashMap;
            }
            for (String str2 : split) {
                int indexOf3 = str2.indexOf("=");
                if (indexOf3 > 0) {
                    try {
                        hashMap.put(URLDecoder.decode(str2.substring(0, indexOf3)), URLDecoder.decode(str2.substring(indexOf3 + 1)));
                    } catch (Exception e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String[] getPaths(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, uri)) == null) {
            if (uri == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(uri.getPathSegments());
            if (!hasVersion(uri)) {
                arrayList.add(0, uri.getHost());
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) invokeL.objValue;
    }

    public static final String getSameOriginUri(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            try {
                Uri parse = Uri.parse(str);
                return parse.getScheme() + parse.getAuthority();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static int getVersion(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, uri)) == null) {
            if (uri == null) {
                return -1;
            }
            String host = uri.getHost();
            if (TextUtils.isEmpty(host)) {
                return -1;
            }
            String lowerCase = host.toLowerCase(Locale.getDefault());
            if (lowerCase.startsWith("v")) {
                try {
                    return Integer.parseInt(lowerCase.substring(1));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    if (UnitedSchemeConstants.DEBUG) {
                        throw e;
                    }
                    return -1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean hasVersion(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            String host = uri.getHost();
            return !TextUtils.isEmpty(host) && host.startsWith("v") && isContainNumber(host);
        }
        return invokeL.booleanValue;
    }

    public static boolean isContainNumber(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            try {
                Pattern compile = Pattern.compile("[0-9]");
                return compile != null && compile.matcher(str).find();
            } catch (PatternSyntaxException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isInvokedFromSwanGame(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, callbackHandler)) == null) ? (callbackHandler instanceof TypedCallbackHandler) && ((TypedCallbackHandler) callbackHandler).getInvokeSourceType() == 1 : invokeL.booleanValue;
    }

    public static boolean isUnitedScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return isUnitedScheme(Uri.parse(str));
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static JSONObject optParamsAsJo(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return null;
            }
            try {
                return new JSONObject(param);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void safeCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65556, null, callbackHandler, unitedSchemeEntity, str, str2) == null) {
            if (DEBUG) {
                Log.i(TAG, "safeCallback handler:" + callbackHandler + "; params:" + str + ";callback:" + str2);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                safeCallbackOnUiThread(callbackHandler, unitedSchemeEntity, str, str2);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(callbackHandler, unitedSchemeEntity, str, str2) { // from class: com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String val$callback;
                    public final /* synthetic */ UnitedSchemeEntity val$entity;
                    public final /* synthetic */ CallbackHandler val$handler;
                    public final /* synthetic */ String val$params;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {callbackHandler, unitedSchemeEntity, str, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$handler = callbackHandler;
                        this.val$entity = unitedSchemeEntity;
                        this.val$params = str;
                        this.val$callback = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            UnitedSchemeUtility.safeCallbackOnUiThread(this.val$handler, this.val$entity, this.val$params, this.val$callback);
                        }
                    }
                });
            }
        }
    }

    public static void safeCallbackOnUiThread(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65557, null, callbackHandler, unitedSchemeEntity, str, str2) == null) {
            if (DEBUG) {
                Log.i(TAG, "safeCallback callback:" + str2);
            }
            if ((callbackHandler instanceof NullableCallbackHandler) || !(callbackHandler == null || TextUtils.isEmpty(str2))) {
                if (unitedSchemeEntity != null) {
                    if (!TextUtils.equals(getSameOriginUri(unitedSchemeEntity.getReferUrl()), getSameOriginUri(callbackHandler.getCurrentPageUrl()))) {
                        return;
                    }
                }
                if (DEBUG) {
                    Log.i(TAG, "safeCallback check success");
                }
                callbackHandler.handleSchemeDispatchCallback(str2, str);
            }
        }
    }

    public static void updateCurrentLongestScheme(String str) {
        InvokeSchemeInfo invokeSchemeInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, null, str) == null) || str == null || (invokeSchemeInfo = currentLongestScheme) == null) {
            return;
        }
        if (invokeSchemeInfo.schemeUrl == null) {
            invokeSchemeInfo.schemeUrl = "";
        }
        if (str.length() > currentLongestScheme.schemeUrl.length()) {
            InvokeSchemeInfo invokeSchemeInfo2 = currentLongestScheme;
            invokeSchemeInfo2.schemeUrl = str;
            invokeSchemeInfo2.invokeTime = System.currentTimeMillis();
        }
    }

    public static JSONObject wrapCallbackParams(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65559, null, i)) == null) ? wrapCallbackParams((JSONObject) null, i) : (JSONObject) invokeI.objValue;
    }

    public static JSONObject wrapCallbackParamsWithBase64(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65564, null, str, i, str2)) == null) {
            JSONObject wrapCallbackParams = wrapCallbackParams(i, str2);
            if (str != null) {
                try {
                    wrapCallbackParams.put("data", Base64.encodeToString(str.getBytes("UTF-8"), 2));
                } catch (UnsupportedEncodingException | JSONException e) {
                    e.printStackTrace();
                }
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public static JSONObject wrapCallbackParamsWithEncode(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65566, null, jSONObject, i, str)) == null) {
            JSONObject wrapCallbackParams = wrapCallbackParams(i, str);
            if (jSONObject != null) {
                try {
                    wrapCallbackParams.put("data", Uri.encode(jSONObject.toString(), "UTF-8"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65561, null, jSONObject, i)) == null) ? wrapCallbackParams(jSONObject, i, getErrMessage(i)) : (JSONObject) invokeLI.objValue;
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65562, null, jSONObject, i, str)) == null) {
            JSONObject wrapCallbackParams = wrapCallbackParams(i, str);
            if (jSONObject != null) {
                try {
                    wrapCallbackParams.put("data", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return wrapCallbackParams;
        }
        return (JSONObject) invokeLIL.objValue;
    }

    public static boolean isUnitedScheme(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            return TextUtils.equals(UnitedSchemeConstants.UNITED_SCHEME, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost());
        }
        return invokeL.booleanValue;
    }

    public static JSONObject wrapCallbackParamsWithEncode(JSONObject jSONObject, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65565, null, jSONObject, i)) == null) ? wrapCallbackParamsWithEncode(jSONObject, i, getErrMessage(i)) : (JSONObject) invokeLI.objValue;
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, callbackHandler, unitedSchemeEntity, i)) == null) {
            JSONObject wrapCallbackParams = wrapCallbackParams(i);
            return unitedSchemeEntity == null ? wrapCallbackParams : callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
        }
        return (JSONObject) invokeLLI.objValue;
    }

    public static JSONObject wrapCallbackParamsWithBase64(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65563, null, str, i)) == null) ? wrapCallbackParamsWithBase64(str, i, getErrMessage(i)) : (JSONObject) invokeLI.objValue;
    }

    public static JSONObject wrapCallbackParams(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65560, null, i, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", String.valueOf(i));
                jSONObject.put("message", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeIL.objValue;
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, callbackHandler, str, jSONObject)) == null) {
            if (callbackHandler != null && !TextUtils.isEmpty(str) && jSONObject != null) {
                return callCallback(callbackHandler, new UnitedSchemeEntity(Uri.parse(str)), jSONObject);
            }
            if (DEBUG) {
                throw new IllegalArgumentException("argument can not be null");
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, unitedSchemeEntity, jSONObject)) == null) {
            if (callbackHandler == null || unitedSchemeEntity == null || jSONObject == null || (jSONObject.optInt("status") > 0 && ((path = unitedSchemeEntity.getUri().getPath()) == null || path.toLowerCase(Locale.getDefault()).startsWith("/feed/iswebp")))) {
                return jSONObject;
            }
            String param = unitedSchemeEntity.getParam(WebChromeClient.KEY_ARG_CALLBACK);
            if (DEBUG) {
                Log.d(TAG, unitedSchemeEntity.getUri().toString() + " callCallback " + param + " " + jSONObject.toString());
            }
            if ((!TextUtils.isEmpty(param) || (callbackHandler instanceof NullableCallbackHandler)) && !unitedSchemeEntity.isCallbackInvoked()) {
                safeCallback(callbackHandler, unitedSchemeEntity, jSONObject.toString(), param);
                unitedSchemeEntity.markCallbackInvoked();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}
