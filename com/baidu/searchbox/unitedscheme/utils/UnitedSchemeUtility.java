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
import com.baidu.tieba.R;
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
/* loaded from: classes4.dex */
public final class UnitedSchemeUtility {
    public static final String PARAMS_KEY = "params";
    public static final String TAG = "UnitedSchemeUtility";
    public static final boolean DEBUG = SchemeConfig.DEBUG;
    public static InvokeSchemeInfo currentLongestScheme = new InvokeSchemeInfo();

    public static JSONObject callCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, int i) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i);
        if (unitedSchemeEntity == null) {
            return wrapCallbackParams;
        }
        return callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i, String str) {
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

    public static JSONObject wrapCallbackParamsWithBase64(String str, int i, String str2) {
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

    public static JSONObject wrapCallbackParamsWithEncode(JSONObject jSONObject, int i, String str) {
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

    public static JSONObject callCallback(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
        String path;
        if (callbackHandler != null && unitedSchemeEntity != null && jSONObject != null) {
            if (jSONObject.optInt("status") > 0 && ((path = unitedSchemeEntity.getUri().getPath()) == null || path.toLowerCase(Locale.getDefault()).startsWith("/feed/iswebp"))) {
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
        }
        return jSONObject;
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, String str, int i) {
        JSONObject wrapCallbackParams = wrapCallbackParams(i);
        if (TextUtils.isEmpty(str)) {
            return wrapCallbackParams;
        }
        return callCallback(callbackHandler, new UnitedSchemeEntity(Uri.parse(str)), wrapCallbackParams);
    }

    public static JSONObject callCallback(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        if (callbackHandler != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            return callCallback(callbackHandler, new UnitedSchemeEntity(Uri.parse(str)), jSONObject);
        }
        if (!DEBUG) {
            return jSONObject;
        }
        throw new IllegalArgumentException("argument can not be null");
    }

    public static String getAction(Uri uri) {
        List<String> pathSegments;
        if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        return pathSegments.get(pathSegments.size() - 1);
    }

    public static String[] getModules(Uri uri) {
        List<String> pathSegments;
        if (uri == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.size() <= 0) {
            return null;
        }
        try {
            String[] strArr = (String[]) pathSegments.toArray(new String[0]);
            return (String[]) Arrays.copyOfRange(strArr, 0, strArr.length - 1);
        } catch (Exception e) {
            if (!DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
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

    public static boolean hasVersion(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host) || !host.startsWith("v") || !isContainNumber(host)) {
            return false;
        }
        return true;
    }

    public static boolean isContainNumber(String str) {
        try {
            Pattern compile = Pattern.compile("[0-9]");
            if (compile == null || !compile.matcher(str).find()) {
                return false;
            }
            return true;
        } catch (PatternSyntaxException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public static boolean isInvokedFromSwanGame(CallbackHandler callbackHandler) {
        if (!(callbackHandler instanceof TypedCallbackHandler) || ((TypedCallbackHandler) callbackHandler).getInvokeSourceType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isUnitedScheme(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (!TextUtils.equals(UnitedSchemeConstants.UNITED_SCHEME, scheme) || TextUtils.isEmpty(host)) {
            return false;
        }
        return true;
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
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void updateCurrentLongestScheme(String str) {
        InvokeSchemeInfo invokeSchemeInfo;
        if (str != null && (invokeSchemeInfo = currentLongestScheme) != null) {
            if (invokeSchemeInfo.schemeUrl == null) {
                invokeSchemeInfo.schemeUrl = "";
            }
            if (str.length() > currentLongestScheme.schemeUrl.length()) {
                InvokeSchemeInfo invokeSchemeInfo2 = currentLongestScheme;
                invokeSchemeInfo2.schemeUrl = str;
                invokeSchemeInfo2.invokeTime = System.currentTimeMillis();
            }
        }
    }

    public static JSONObject wrapCallbackParams(int i) {
        return wrapCallbackParams((JSONObject) null, i);
    }

    public static String getErrMessage(int i) {
        if (i != 0) {
            if (i != 101) {
                if (i != 201) {
                    if (i != 202) {
                        if (i != 301) {
                            if (i != 302) {
                                switch (i) {
                                    case 401:
                                        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17ab);
                                    case 402:
                                        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17a8);
                                    case 403:
                                        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17a9);
                                    default:
                                        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17b0);
                                }
                            }
                            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17aa);
                        }
                        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17ac);
                    }
                    return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17af);
                }
                return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17b0);
            }
            return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17ad);
        }
        return SchemeConfig.getAppContext().getString(R.string.obfuscated_res_0x7f0f17ae);
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
        if (indexOf2 < 0) {
            substring = str.substring(indexOf + 1);
        } else {
            int i = indexOf + 1;
            if (indexOf2 > i) {
                substring = str.substring(i, indexOf2);
            }
            return hashMap;
        }
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

    public static int getVersion(Uri uri) {
        if (uri == null) {
            return -1;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return -1;
        }
        String lowerCase = host.toLowerCase(Locale.getDefault());
        if (!lowerCase.startsWith("v")) {
            return -1;
        }
        try {
            return Integer.parseInt(lowerCase.substring(1));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (!UnitedSchemeConstants.DEBUG) {
                return -1;
            }
            throw e;
        }
    }

    public static boolean isUnitedScheme(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isUnitedScheme(Uri.parse(str));
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
        if (!(callbackHandler instanceof NullableCallbackHandler) && (callbackHandler == null || TextUtils.isEmpty(str2))) {
            return;
        }
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

    public static JSONObject wrapCallbackParams(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", String.valueOf(i));
            jSONObject.put("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject wrapCallbackParamsWithBase64(String str, int i) {
        return wrapCallbackParamsWithBase64(str, i, getErrMessage(i));
    }

    public static JSONObject wrapCallbackParamsWithEncode(JSONObject jSONObject, int i) {
        return wrapCallbackParamsWithEncode(jSONObject, i, getErrMessage(i));
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject, int i) {
        return wrapCallbackParams(jSONObject, i, getErrMessage(i));
    }
}
