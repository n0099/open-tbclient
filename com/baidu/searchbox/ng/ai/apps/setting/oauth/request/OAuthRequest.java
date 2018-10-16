package com.baidu.searchbox.ng.ai.apps.setting.oauth.request;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.AntiReplayToken;
import com.baidu.searchbox.ng.ai.apps.res.widget.dialog.AiAppAlertDialog;
import com.baidu.searchbox.ng.ai.apps.res.widget.toast.UniversalToast;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.AiAppProvider;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthException;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.decorate.AiAppsDialogDecorate;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class OAuthRequest<ResultDataT> extends OAuthTask<ResultDataT> implements AiAppProvider {
    public final String mApi;
    private JSONObject mJoResponse;
    private final Map<String, String> mQuery = new HashMap();
    private String mStrResponse;

    public OAuthRequest(String str) {
        this.mApi = str;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
    protected void onExec() {
        Request buildRequest = buildRequest();
        if (buildRequest == null) {
            finish(new OAuthException("bad request", 10002));
        } else {
            OAuthUtils.getHttpClient().newCall(buildRequest).enqueue(new Callback() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest.1
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    OAuthRequest.this.finish(new OAuthException(iOException, 10002));
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        OAuthRequest.this.finish(new OAuthException("bad response", 10002));
                        return;
                    }
                    ResponseBody body = response.body();
                    if (body == null) {
                        OAuthRequest.this.finish(new OAuthException("empty response body", 10002));
                    } else {
                        OAuthRequest.this.handle(body.string());
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.AiAppProvider
    @NonNull
    public AiApp requireAiApp() {
        AiApp aiApp = AiApp.get();
        if (aiApp == null) {
            throw new IllegalStateException("null AiApp");
        }
        return aiApp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OAuthRequest<ResultDataT> addQuery(String str, String str2) {
        this.mQuery.put(str, str2);
        return this;
    }

    public Map<String, String> getQuery() {
        return this.mQuery;
    }

    public JSONObject getJoResponse() {
        return this.mJoResponse;
    }

    protected void handle(String str) {
        this.mStrResponse = str;
        try {
            this.mJoResponse = new JSONObject(this.mStrResponse);
            updateResultData(parse(this.mJoResponse));
            onRequestSuccess();
        } catch (OAuthException e) {
            finish(e);
        } catch (Exception e2) {
            finish(new OAuthException(e2, 11001));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBdussInvalid(final Activity activity, JSONObject jSONObject) {
        if (jSONObject != null && activity != null) {
            int optInt = jSONObject.optInt("errno", 11001);
            final String optString = jSONObject.optString("tipmsg");
            if (optInt == 402) {
                if (!TextUtils.isEmpty(optString)) {
                    AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest.2
                        @Override // java.lang.Runnable
                        public void run() {
                            UniversalToast.makeText(activity, optString).showToast();
                        }
                    });
                }
            } else if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = jSONObject.optJSONObject("tipoption");
                final String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest.3
                        @Override // java.lang.Runnable
                        public void run() {
                            OAuthRequest.this.showBdussInvalidDialog(activity, optString2, optString);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBdussInvalidDialog(final Activity activity, String str, String str2) {
        new AiAppAlertDialog.Builder(activity).setTitle(str).setMessage(str2).setDecorate(new AiAppsDialogDecorate()).setCancelable(true).setPositiveButton(activity.getString(R.string.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                AiAppsRuntime.getAiAppAccountRuntime().login(activity, "key_login_source", true, null);
            }
        }).setNegativeButton(activity.getString(R.string.aiapps_login_refuse), (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRequestSuccess() {
    }

    private Request buildRequest() {
        HttpUrl buildUri = buildUri();
        if (buildUri == null) {
            return null;
        }
        Request.Builder builder = new Request.Builder();
        builder.url(AiAppsRuntime.getAiAppAccountRuntime().processUrl(buildUri.toString()));
        builder.post(OAuthUtils.buildBody(getQuery()));
        return builder.build();
    }

    private HttpUrl buildUri() {
        HttpUrl parse = HttpUrl.parse(AiAppsRuntime.getConfigRuntime().getHostForHttps());
        if (parse == null) {
            return null;
        }
        HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(this.mApi);
        for (Map.Entry<String, String> entry : AntiReplayToken.create().queryMap.entrySet()) {
            addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
        }
        return addPathSegments.build();
    }

    public String toString() {
        return String.format("%s api(%s)\n  status(%s) errorcode(%s)  \n  strResponse :: %s \n  joResponse ::  %s \n  Result :: %s \n  Exception :: %s", super.toString(), this.mApi, getStatus(), Integer.valueOf(this.mResult.getErrorCode()), this.mStrResponse, this.mJoResponse, this.mResult.mData, this.mResult.getError());
    }
}
