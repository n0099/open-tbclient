package com.baidu.searchbox.unitedscheme.utils;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.InvokeSchemeInfo;
import com.baidu.searchbox.unitedscheme.NullableCallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.core.R;
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
    public static final String PARAMS_KEY = "params";
    public static final String TAG = "UnitedSchemeUtility";
    public static final boolean DEBUG = SchemeConfig.DEBUG;
    public static InvokeSchemeInfo currentLongestScheme = new InvokeSchemeInfo();

    public static JSONObject callCallback(CallbackHandler callbackHandler, String str, int i2) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i2);
        return TextUtils.isEmpty(str) ? wrapCallbackParams : callCallback(callbackHandler, new UnitedSchemeEntity(Uri.parse(str)), wrapCallbackParams);
    }

    public static String getAction(Uri uri) {
        List<String> pathSegments;
        if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        return pathSegments.get(pathSegments.size() - 1);
    }

    public static String getErrMessage(int i2) {
        if (i2 != 0) {
            if (i2 != 101) {
                if (i2 != 201) {
                    if (i2 != 202) {
                        if (i2 != 301) {
                            if (i2 != 302) {
                                switch (i2) {
                                    case 401:
                                        return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_action_sec_check_fail);
                                    case 402:
                                        return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_action_acl_check_fail);
                                    case 403:
                                        return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_action_allow_close);
                                    default:
                                        return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
                                }
                            }
                            return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_action_notfound);
                        }
                        return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_module_notfound);
                    }
                    return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_params_parse_fail);
                }
                return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_parse_fail);
            }
            return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_not_support);
        }
        return SchemeConfig.getAppContext().getString(R.string.united_scheme_err_message_ok);
    }

    public static String[] getModules(Uri uri) {
        List<String> pathSegments;
        if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        try {
            String[] strArr = (String[]) pathSegments.toArray(new String[0]);
            return (String[]) Arrays.copyOfRange(strArr, 0, strArr.length - 1);
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static HashMap<String, String> getParams(String str) {
        String substring;
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
            int i2 = indexOf + 1;
            if (indexOf2 > i2) {
                substring = str.substring(i2, indexOf2);
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
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    public static String[] getPaths(Uri uri) {
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

    public static final String getSameOriginUri(String str) {
        try {
            Uri parse = Uri.parse(str);
            return parse.getScheme() + parse.getAuthority();
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getVersion(Uri uri) {
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
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                if (UnitedSchemeConstants.DEBUG) {
                    throw e2;
                }
                return -1;
            }
        }
        return -1;
    }

    public static boolean hasVersion(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        return !TextUtils.isEmpty(host) && host.startsWith("v") && isContainNumber(host);
    }

    public static boolean isContainNumber(String str) {
        try {
            Pattern compile = Pattern.compile("[0-9]");
            return compile != null && compile.matcher(str).find();
        } catch (PatternSyntaxException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public static boolean isInvokedFromSwanGame(CallbackHandler callbackHandler) {
        return (callbackHandler instanceof TypedCallbackHandler) && ((TypedCallbackHandler) callbackHandler).getInvokeSourceType() == 1;
    }

    public static boolean isUnitedScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isUnitedScheme(Uri.parse(str));
    }

    @Nullable
    public static JSONObject optParamsAsJo(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            return new JSONObject(param);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static void safeCallback(final CallbackHandler callbackHandler, final UnitedSchemeEntity unitedSchemeEntity, final String str, final String str2) {
        if (DEBUG) {
            Log.i(TAG, "safeCallback handler:" + callbackHandler + "; params:" + str + ";callback:" + str2);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            safeCallbackOnUiThread(callbackHandler, unitedSchemeEntity, str, str2);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.1
                @Override // java.lang.Runnable
                public void run() {
                    UnitedSchemeUtility.safeCallbackOnUiThread(CallbackHandler.this, unitedSchemeEntity, str, str2);
                }
            });
        }
    }

    public static void safeCallbackOnUiThread(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
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

    public static void updateCurrentLongestScheme(String str) {
        InvokeSchemeInfo invokeSchemeInfo;
        if (str == null || (invokeSchemeInfo = currentLongestScheme) == null) {
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

    public static JSONObject wrapCallbackParams(int i2) {
        return wrapCallbackParams((JSONObject) null, i2);
    }

    public static JSONObject wrapCallbackParamsWithBase64(String str, int i2, String str2) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i2, str2);
        if (str != null) {
            try {
                wrapCallbackParams.put("data", Base64.encodeToString(str.getBytes("UTF-8"), 2));
            } catch (UnsupportedEncodingException | JSONException e2) {
                e2.printStackTrace();
            }
        }
        return wrapCallbackParams;
    }

    public static JSONObject wrapCallbackParamsWithEncode(JSONObject jSONObject, int i2, String str) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i2, str);
        if (jSONObject != null) {
            try {
                wrapCallbackParams.put("data", Uri.encode(jSONObject.toString(), "UTF-8"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return wrapCallbackParams;
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i2) {
        return wrapCallbackParams(jSONObject, i2, getErrMessage(i2));
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i2, String str) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i2, str);
        if (jSONObject != null) {
            try {
                wrapCallbackParams.put("data", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return wrapCallbackParams;
    }

    public static boolean isUnitedScheme(Uri uri) {
        if (uri == null) {
            return false;
        }
        return TextUtils.equals(UnitedSchemeConstants.UNITED_SCHEME, uri.getScheme()) && !TextUtils.isEmpty(uri.getHost());
    }

    public static JSONObject wrapCallbackParamsWithEncode(JSONObject jSONObject, int i2) {
        return wrapCallbackParamsWithEncode(jSONObject, i2, getErrMessage(i2));
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i2) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i2);
        return unitedSchemeEntity == null ? wrapCallbackParams : callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
    }

    public static JSONObject wrapCallbackParamsWithBase64(String str, int i2) {
        return wrapCallbackParamsWithBase64(str, i2, getErrMessage(i2));
    }

    public static JSONObject wrapCallbackParams(int i2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(i2));
            jSONObject.put("message", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        if (callbackHandler != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            return callCallback(callbackHandler, new UnitedSchemeEntity(Uri.parse(str)), jSONObject);
        }
        if (DEBUG) {
            throw new IllegalArgumentException("argument can not be null");
        }
        return jSONObject;
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
        String path;
        if (callbackHandler == null || unitedSchemeEntity == null || jSONObject == null || (jSONObject.optInt("status") > 0 && ((path = unitedSchemeEntity.getUri().getPath()) == null || path.toLowerCase(Locale.getDefault()).startsWith("/feed/iswebp")))) {
            return jSONObject;
        }
        String param = unitedSchemeEntity.getParam("callback");
        if (DEBUG) {
            Log.d(TAG, unitedSchemeEntity.getUri().toString() + " callCallback " + param + " " + jSONObject.toString());
        }
        if ((!TextUtils.isEmpty(param) || (callbackHandler instanceof NullableCallbackHandler)) && !unitedSchemeEntity.isCallbackInvoked()) {
            safeCallback(callbackHandler, unitedSchemeEntity, jSONObject.toString(), param);
            unitedSchemeEntity.markCallbackInvoked();
        }
        return jSONObject;
    }
}
