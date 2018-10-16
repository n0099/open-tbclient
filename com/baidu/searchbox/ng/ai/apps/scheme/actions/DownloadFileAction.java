package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.network.NetworkDef;
import com.baidu.searchbox.ng.ai.apps.network.interceptor.DownloadProgressInterceptor;
import com.baidu.searchbox.ng.ai.apps.network.interceptor.HeaderInterceptor;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppFileClassifyHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppStreamUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DownloadFileAction extends BaseRequestAction implements NetworkDef {
    private static final String ACTION_TYPE = "/swan/downloadFile";
    public static final int DOWNLOAD_TIME_PERIOD = 500;
    public static final String MESSAGE_DOWNLOAD_SIZE = "download file size > 10MB";
    public static final String MESSAGE_PROGRESS_FAIL = "progress callback fail()";
    public static final String MESSAGE_REALFILEPATH_PARSE_FAIL = "realFilePath create fail";
    public static final String MESSAGE_STREAMTOFILE_FAIL = "streamToFile fail";
    public static final String MESSAGE_TMPFILEPATH_SAVE_FAIL = "parse tmpFilePath from realFilePath fail";

    public DownloadFileAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
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
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        final String optString = paramAsJo.optString(BaseRequestAction.PARAMS_CALLBACK_PROGRESS);
        final String optString2 = paramAsJo.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, BaseRequestAction.MESSAGE_ILLEGAL_RESULTCALLBACK);
            return false;
        }
        final String aiAppId = AiApp.getAiAppId();
        if (TextUtils.isEmpty(aiAppId)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        final String buildRequestCancelTag = buildRequestCancelTag(aiAppId);
        Request buildRequest = buildRequest(paramAsJo, buildRequestCancelTag);
        if (buildRequest == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, BaseRequestAction.MESSAGE_ILLEGAL_REQUEST);
            return false;
        }
        JSONObject optJSONObject = paramAsJo.optJSONObject("header");
        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        headerInterceptor.setHeaders(formHeaders(optJSONObject, true));
        final String valueOf = String.valueOf(System.currentTimeMillis());
        this.mHashMap.put(valueOf, 0L);
        DownloadProgressInterceptor downloadProgressInterceptor = new DownloadProgressInterceptor();
        downloadProgressInterceptor.setProgressListener(new DownloadProgressInterceptor.IProgressCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.DownloadFileAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.network.interceptor.DownloadProgressInterceptor.IProgressCallback
            public void onSizeFail(long j) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, DownloadFileAction.MESSAGE_DOWNLOAD_SIZE).toString());
                AiAppNetworkUtils.cancelCallWithTag(aiApp.getNetwork().getHttpClient(), buildRequestCancelTag);
                DownloadFileAction.this.releaseMap(valueOf);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.network.interceptor.DownloadProgressInterceptor.IProgressCallback
            public void onFail(long j, long j2) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, DownloadFileAction.MESSAGE_PROGRESS_FAIL).toString());
                AiAppNetworkUtils.cancelCallWithTag(aiApp.getNetwork().getHttpClient(), buildRequestCancelTag);
                DownloadFileAction.this.releaseMap(valueOf);
            }

            @Override // com.baidu.searchbox.ng.ai.apps.network.interceptor.DownloadProgressInterceptor.IProgressCallback
            public void onSuccess(int i, long j, long j2) {
                if (System.currentTimeMillis() - DownloadFileAction.this.getCurrentTimeFromMap(valueOf) > 500) {
                    if (i != 100) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("progress", String.valueOf(i));
                            jSONObject.put(BaseRequestAction.PARAMS_TOTALBYTESWRITTEN, String.valueOf(j));
                            jSONObject.put(BaseRequestAction.PARAMS_TOTALBYTESEXPECTEDTOWRITE, String.valueOf(j2));
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                        } catch (Exception e) {
                        }
                    }
                    DownloadFileAction.this.mHashMap.put(valueOf, Long.valueOf(System.currentTimeMillis()));
                }
            }
        });
        aiApp.getNetwork().getHttpClient().newBuilder().addInterceptor(headerInterceptor).addNetworkInterceptor(downloadProgressInterceptor).build().newCall(buildRequest).enqueue(new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.DownloadFileAction.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
                DownloadFileAction.this.releaseMap(valueOf);
            }

            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [231=4] */
            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseRequestAction.PARAMS_STATUSCODE, response.code());
                    String header = response.header("Content-Type", "");
                    String str = TextUtils.isEmpty(header) ? "" : AiAppFileClassifyHelper.sMimeTypeToExtensionMap.get(header);
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    String createTmpFile = StorageUtil.createTmpFile(aiAppId, String.valueOf(System.currentTimeMillis()), str);
                    if (TextUtils.isEmpty(createTmpFile)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, DownloadFileAction.MESSAGE_REALFILEPATH_PARSE_FAIL).toString());
                        return;
                    }
                    String path2Scheme = StorageUtil.path2Scheme(createTmpFile, aiAppId);
                    if (TextUtils.isEmpty(path2Scheme)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, DownloadFileAction.MESSAGE_TMPFILEPATH_SAVE_FAIL).toString());
                        return;
                    }
                    jSONObject.put("tempFilePath", path2Scheme);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(createTmpFile);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (AiAppStreamUtils.streamToFile(byteStream, file)) {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, DownloadFileAction.MESSAGE_STREAMTOFILE_FAIL).toString());
                    }
                } catch (Exception e) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(201, e.getMessage()).toString());
                } finally {
                    DownloadFileAction.this.releaseMap(valueOf);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(getCancelTag(buildRequestCancelTag), 0));
        return true;
    }

    @Nullable
    private Request buildRequest(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl parseUrl;
        if (jSONObject == null || TextUtils.isEmpty(str) || (parseUrl = parseUrl(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = parseUrl.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        return new Request.Builder().url(httpUrl).tag(str).build();
    }
}
