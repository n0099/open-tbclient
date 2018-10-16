package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.network.CountingFileRequestBody;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.network.interceptor.HeaderInterceptor;
import com.baidu.searchbox.ng.ai.apps.network.interfaces.IUploadProgressListener;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class UploadFileAction extends BaseRequestAction implements NetworkDef {
    private static final String ACTION_TYPE = "/swan/uploadFile";
    public static final String PARAMS_FILEPATH = "filePath";
    public static final String PARAMS_FORMDATA = "formData";
    public static final String PARAMS_NAME = "name";
    public static final String PARAMS_UPLOADFILE_CONTENT_TYPE = "multipart/form-data";
    public static final int UPLOAD_TIME_PERIOD = 500;

    public UploadFileAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction, com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp is null");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String optString = paramAsJo.optString(BaseRequestAction.PARAMS_CALLBACK_PROGRESS);
        final String optString2 = paramAsJo.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, BaseRequestAction.MESSAGE_ILLEGAL_RESULTCALLBACK);
            return false;
        }
        String aiAppId = AiApp.getAiAppId();
        if (TextUtils.isEmpty(aiAppId)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String buildRequestCancelTag = buildRequestCancelTag(aiAppId);
        final String valueOf = String.valueOf(System.currentTimeMillis());
        Request buildRequest = buildRequest(paramAsJo, optString, buildRequestCancelTag, valueOf, aiAppId, callbackHandler);
        if (buildRequest == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, BaseRequestAction.MESSAGE_ILLEGAL_REQUEST);
            releaseMap(valueOf);
            return false;
        }
        JSONObject optJSONObject = paramAsJo.optJSONObject("header");
        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        headerInterceptor.setHeaders(formHeaders(optJSONObject, true));
        aiApp.getNetwork().call(buildRequest, headerInterceptor, new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.UploadFileAction.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                UploadFileAction.this.releaseMap(valueOf);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseRequestAction.PARAMS_STATUSCODE, response.code());
                    UploadFileAction.this.parseResponseBody(jSONObject, response.body());
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                } catch (Exception e) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    UploadFileAction.this.releaseMap(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(getCancelTag(buildRequestCancelTag), 0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseResponseBody(@NonNull JSONObject jSONObject, @Nullable ResponseBody responseBody) throws IOException, JSONException {
        if (responseBody != null) {
            String string = responseBody.string();
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(string);
                    if (jSONObject2 != null) {
                        jSONObject.put("data", jSONObject2);
                    }
                } catch (JSONException e) {
                    jSONObject.put("data", string);
                } catch (Throwable th) {
                    if (0 != 0) {
                        jSONObject.put("data", (Object) null);
                        return;
                    }
                    throw th;
                }
            }
        }
    }

    @Nullable
    private Request buildRequest(@Nullable JSONObject jSONObject, @Nullable final String str, @Nullable String str2, @Nullable final String str3, @Nullable String str4, @Nullable final CallbackHandler callbackHandler) {
        HttpUrl parseUrl;
        if (jSONObject == null || (parseUrl = parseUrl(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = parseUrl.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        String optString = jSONObject.optString("filePath", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        String scheme2Path = StorageUtil.scheme2Path(optString, str4);
        if (TextUtils.isEmpty(scheme2Path)) {
            return null;
        }
        File file = new File(scheme2Path);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        final long length = file.length();
        if (length > BaseRequestAction.SIZE_25MB) {
            return null;
        }
        String optString2 = jSONObject.optString("name", "");
        if (TextUtils.isEmpty(optString2)) {
            return null;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(PARAMS_FORMDATA);
        this.mHashMap.put(str3, 0L);
        CountingFileRequestBody countingFileRequestBody = new CountingFileRequestBody(file, PARAMS_UPLOADFILE_CONTENT_TYPE, new IUploadProgressListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.UploadFileAction.2
            @Override // com.baidu.searchbox.ng.ai.apps.network.interfaces.IUploadProgressListener
            public void transferred(long j) {
                UploadFileAction.this.handleProgressResult(length, j, str, str3, callbackHandler);
            }
        });
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        setupFormDataParams(type, optJSONObject);
        setupNameParams(type, optString2, file.getName(), countingFileRequestBody);
        return new Request.Builder().url(httpUrl).tag(str2).post(type.build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleProgressResult(long j, long j2, String str, String str2, CallbackHandler callbackHandler) {
        if (j > 0 && j2 <= j && j2 != 0 && !TextUtils.isEmpty(str) && callbackHandler != null) {
            int floor = (int) Math.floor((100 * j2) / j);
            if (System.currentTimeMillis() - getCurrentTimeFromMap(str2) > 500) {
                if (floor != 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", String.valueOf(floor));
                        jSONObject.put(BaseRequestAction.PARAMS_TOTALBYTESSENT, String.valueOf(j2));
                        jSONObject.put(BaseRequestAction.PARAMS_TOTALBYTESEXPECTEDTOSEND, String.valueOf(j));
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e) {
                    }
                }
                this.mHashMap.put(str2, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    private void setupNameParams(MultipartBody.Builder builder, String str, String str2, CountingFileRequestBody countingFileRequestBody) {
        if (builder != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && countingFileRequestBody != null) {
            builder.addFormDataPart(str, str2, countingFileRequestBody);
        }
    }

    public static void setupFormDataParams(MultipartBody.Builder builder, JSONObject jSONObject) {
        if (builder != null && jSONObject != null && jSONObject.length() >= 1) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(optString)) {
                        builder.addFormDataPart(next, optString);
                    }
                }
            }
        }
    }
}
