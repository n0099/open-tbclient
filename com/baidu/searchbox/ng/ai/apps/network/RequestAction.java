package com.baidu.searchbox.ng.ai.apps.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.facebook.common.internal.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RequestAction extends BaseRequestAction implements NetworkDef {
    private static final String ACTION_TYPE = "/swan/request";
    private static final Set<String> AVAILABLE_DATA_TYPE = h.J(NetworkDef.DataType.JSON, "string");
    private static final Set<String> AVAILABLE_METHOD = h.J("OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", NetworkDef.Http.Method.CONNECT);

    public RequestAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction, com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp is null");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal pamas");
            return false;
        }
        final String optString = paramAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal cb");
            return false;
        }
        final String buildRequestCancelTag = buildRequestCancelTag(aiApp.id);
        Request buildRequest = buildRequest(paramAsJo, buildRequestCancelTag);
        if (buildRequest == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, BaseRequestAction.MESSAGE_ILLEGAL_REQUEST);
            return false;
        }
        final String dataType = getDataType(paramAsJo);
        aiApp.getNetwork().call(buildRequest, new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.network.RequestAction.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                AiAppNetworkUtils.cancelCallWithTag(aiApp.getNetwork().getHttpClient(), buildRequestCancelTag);
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseRequestAction.PARAMS_STATUSCODE, response.code());
                    jSONObject.put("header", BaseRequestAction.toJo(response.headers()));
                    RequestAction.this.parseResponseBody(jSONObject, response.body(), dataType);
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (IOException | JSONException e) {
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(getCancelTag(buildRequestCancelTag), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseResponseBody(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody, @NonNull String str) throws IOException, JSONException {
        if (responseBody != null) {
            String string = responseBody.string();
            if (!TextUtils.isEmpty(string)) {
                char c = 65535;
                switch (str.hashCode()) {
                    case -891985903:
                        if (str.equals("string")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3271912:
                        if (str.equals(NetworkDef.DataType.JSON)) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (isArray(string)) {
                            jSONObject.put("data", new JSONArray(string));
                            return;
                        } else {
                            jSONObject.put("data", new JSONObject(string));
                            return;
                        }
                    default:
                        jSONObject.put("data", string);
                        return;
                }
            }
        }
    }

    private boolean isArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.trim().startsWith("[");
    }

    @NonNull
    private static String getDataType(@NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString(WebSocketAction.PARAM_KEY_DATA_TYPE);
        if (TextUtils.isEmpty(optString)) {
            return NetworkDef.DataType.JSON;
        }
        if (!AVAILABLE_DATA_TYPE.contains(optString)) {
            return "string";
        }
        return optString;
    }

    @Nullable
    private Request buildRequest(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl parseUrl;
        RequestBody createBody;
        if (jSONObject == null || TextUtils.isEmpty(str) || (parseUrl = parseUrl(jSONObject.optString("url"))) == null) {
            return null;
        }
        String optString = jSONObject.optString("method");
        optString = (TextUtils.isEmpty(optString) || !AVAILABLE_METHOD.contains(optString)) ? "GET" : "GET";
        HashMap hashMap = new HashMap();
        Request.Builder builder = new Request.Builder();
        setupHeaders(builder, jSONObject.optJSONObject("header"), hashMap, true);
        Object opt = jSONObject.opt("data");
        boolean z = opt != null;
        if (z && !HttpMethod.permitsRequestBody(optString)) {
            parseUrl = appendQueryTo(parseUrl, opt);
            createBody = null;
        } else {
            createBody = (z || HttpMethod.requiresRequestBody(optString)) ? createBody(opt, hashMap) : null;
        }
        if (HttpMethod.requiresRequestBody(optString) && createBody == null) {
            return null;
        }
        return builder.url(parseUrl).method(optString, createBody).tag(str).build();
    }

    private static void setupHeaders(@NonNull Request.Builder builder, @Nullable JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && !ILLEGAL_HEADERS.contains(next.toUpperCase())) {
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        if (map != null) {
                            map.put(next.toLowerCase(), optString);
                        }
                        builder.header(next, optString);
                    }
                }
            }
        }
    }

    private static void setupHeaders(@NonNull Request.Builder builder, @Nullable JSONObject jSONObject, Map<String, String> map, boolean z) {
        setupHeaders(builder, jSONObject, map);
        if (z) {
            builder.header(BaseRequestAction.HEADER_REFERER, getFixedHttpReferer());
        }
    }

    @Nullable
    private static RequestBody createBody(@Nullable Object obj, Map<String, String> map) {
        String str = map.get("content-type");
        if (TextUtils.isEmpty(str)) {
            return RequestBody.create(NetworkDef.ContentType.JSON, obj == null ? "" : obj.toString());
        }
        if (NetworkDef.ContentType.JSON.equals(MediaType.parse(str))) {
            return RequestBody.create(NetworkDef.ContentType.JSON, obj == null ? "" : obj.toString());
        }
        return createFormBody(obj);
    }

    private static RequestBody createFormBody(@Nullable Object obj) {
        FormBody.Builder builder = new FormBody.Builder();
        if (obj == null || !(obj instanceof JSONObject)) {
            return builder.build();
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    builder.add(next, optString);
                }
            }
        }
        return builder.build();
    }

    @NonNull
    private static HttpUrl appendQueryTo(@NonNull HttpUrl httpUrl, @NonNull Object obj) {
        HttpUrl.Builder newBuilder = httpUrl.newBuilder();
        if (obj instanceof JSONObject) {
            Iterator<String> keys = ((JSONObject) obj).keys();
            boolean z = false;
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = ((JSONObject) obj).optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        newBuilder.addQueryParameter(next, optString);
                        z = true;
                    }
                }
            }
            return z ? newBuilder.build() : httpUrl;
        }
        return httpUrl;
    }
}
