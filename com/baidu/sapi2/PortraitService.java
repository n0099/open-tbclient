package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PortraitService extends AbstractService {
    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPortrait(final SetPortraitCallback setPortraitCallback, final String str, final byte[] bArr, final String str2) {
        if (setPortraitCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        }
        final SetPortraitResult setPortraitResult = new SetPortraitResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            setPortraitResult.setResultCode(-201);
            setPortraitCallback.onFailure(setPortraitResult);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("tpl", this.configuration.tpl);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("bduss", str);
        String calculateSig = SapiUtils.calculateSig(hashMap, this.configuration.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            multipartRequestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        multipartRequestParams.put("sig", calculateSig);
        multipartRequestParams.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", TextUtils.isEmpty(str2) ? "image/jpeg" : str2);
        this.asyncHttpClient.post(this.configuration.context, a(), multipartRequestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.1
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                setPortraitCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                setPortraitCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                PortraitService.this.domainRetry.reset();
                setPortraitResult.setResultCode(PortraitService.this.getErrorCode(str3));
                setPortraitResult.setResultMsg(PortraitService.this.getErrorMsg(str3));
                switch (setPortraitResult.getResultCode()) {
                    case 0:
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            setPortraitResult.portraitSign = jSONObject.optString("portrait_tag");
                            String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                            if (!TextUtils.isEmpty(optString)) {
                                setPortraitResult.portraitHttps = String.format("https://ss0.bdstatic.com/7Ls0a8Sm1A5BphGlnYG/sys/portrait/item/%s.jpg?%s", optString, setPortraitResult.portraitSign);
                            }
                        } catch (JSONException e) {
                        }
                        setPortraitCallback.onSuccess(setPortraitResult);
                        return;
                    case 160103:
                        setPortraitCallback.onBdussExpired(setPortraitResult);
                        return;
                    default:
                        setPortraitCallback.onFailure(setPortraitResult);
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!PortraitService.this.domainRetry.isShouldRetry()) {
                    PortraitService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        setPortraitResult.setResultCode(-203);
                        setPortraitCallback.onFailure(setPortraitResult);
                        return;
                    }
                    setPortraitResult.setResultCode(-202);
                    setPortraitCallback.onFailure(setPortraitResult);
                    return;
                }
                PortraitService.this.domainRetry.retry();
                PortraitService.this.setPortrait(setPortraitCallback, str, bArr, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPopularPortrait(final SetPopularPortraitCallback setPopularPortraitCallback, final SetPopularPortraitDTO setPopularPortraitDTO) {
        if (setPopularPortraitCallback == null) {
            throw new IllegalArgumentException("SetPopularPortraitCallback can't be null");
        }
        if (setPopularPortraitDTO == null) {
            throw new IllegalArgumentException("SetPopularPortraitDto can't be null");
        }
        if (TextUtils.isEmpty(setPopularPortraitDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(setPopularPortraitDTO.series)) {
            throw new IllegalArgumentException("series can't be empty");
        }
        final SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            setPopularPortraitResult.setResultCode(-201);
            setPopularPortraitCallback.onFailure(setPopularPortraitResult);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("tpl", this.configuration.tpl);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("bduss", setPopularPortraitDTO.bduss);
        hashMap.put("serie", setPopularPortraitDTO.series);
        hashMap.put("num", String.valueOf(setPopularPortraitDTO.num));
        String calculateSig = SapiUtils.calculateSig(hashMap, this.configuration.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            multipartRequestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        multipartRequestParams.put("sig", calculateSig);
        this.asyncHttpClient.post(this.configuration.context, d(), multipartRequestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.2
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!PortraitService.this.domainRetry.isShouldRetry()) {
                    PortraitService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        setPopularPortraitResult.setResultCode(-203);
                        setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                        return;
                    }
                    setPopularPortraitResult.setResultCode(-202);
                    setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                    return;
                }
                PortraitService.this.domainRetry.retry();
                PortraitService.this.setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                PortraitService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("errno");
                    setPopularPortraitResult.setResultCode(i2);
                    setPopularPortraitResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (i2 == 0) {
                        setPopularPortraitCallback.onSuccess(setPopularPortraitResult);
                    } else {
                        setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                    }
                } catch (JSONException e) {
                    setPopularPortraitResult.setResultCode(-202);
                    setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                    Log.e(e);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                setPopularPortraitCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                setPopularPortraitCallback.onFinish();
            }
        });
    }

    public void getPortrait(final SapiCallBack<GetPortraitResponse> sapiCallBack, final String str, final String str2, final String str3) {
        if (sapiCallBack == null) {
            throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            sapiCallBack.onNetworkFailed();
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("tpl", this.configuration.tpl);
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("bduss", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_STOKEN, str3);
        }
        String calculateSig = SapiUtils.calculateSig(hashMap, this.configuration.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        requestParams.put("sig", calculateSig);
        this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + "/v2/sapi/center/getportrait", requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.3
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str4) {
                if (!PortraitService.this.domainRetry.isShouldRetry()) {
                    PortraitService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    sapiCallBack.onSystemError(-100);
                    return;
                }
                PortraitService.this.domainRetry.retry();
                PortraitService.this.getPortrait(sapiCallBack, str, str2, str3);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str4) {
                PortraitService.this.domainRetry.reset();
                int errorCode = PortraitService.this.getErrorCode(str4);
                if (errorCode == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        GetPortraitResponse getPortraitResponse = new GetPortraitResponse();
                        getPortraitResponse.errorCode = errorCode;
                        getPortraitResponse.errorMsg = jSONObject.optString("errmsg");
                        String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                        if (!TextUtils.isEmpty(optString)) {
                            getPortraitResponse.portrait = String.format(SapiHost.getHost(SapiHost.DOMAIN_BDIMG) + "/sys/portrait/item/%s.jpg", optString);
                            getPortraitResponse.portraitHttps = String.format(SapiHost.getHost(SapiHost.DOMAIN_PORTRAIT_HTTPS_URL) + "/sys/portrait/item/%s.jpg", optString);
                        }
                        sapiCallBack.onSuccess(getPortraitResponse);
                        return;
                    } catch (JSONException e) {
                        sapiCallBack.onSystemError(errorCode);
                        Log.e(e);
                        return;
                    }
                }
                sapiCallBack.onSystemError(errorCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getHistoryPortraits(final GetHistoryPortraitsCallback getHistoryPortraitsCallback, final GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        if (getHistoryPortraitsCallback == null) {
            throw new IllegalArgumentException("getHistoryPortaits callback can't be null");
        }
        if (getHistoryPortraitsDTO == null) {
            throw new IllegalArgumentException("getHistoryPortrats dto can't be null");
        }
        if (TextUtils.isEmpty(getHistoryPortraitsDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (getHistoryPortraitsDTO.maxNum < 0 || getHistoryPortraitsDTO.maxNum > 10) {
            throw new IllegalArgumentException("abnormal request history number");
        }
        final GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getHistoryPortraitsResult.setResultCode(-201);
            getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.configuration.appId);
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("length", String.valueOf(getHistoryPortraitsDTO.maxNum));
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
        }
        if (!TextUtils.isEmpty(this.configuration.clientIp)) {
            hashMap.put("clientip", this.configuration.clientIp);
        }
        hashMap.put("bduss", getHistoryPortraitsDTO.bduss);
        String calculateSig = SapiUtils.calculateSig(hashMap, this.configuration.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        requestParams.put("sig", calculateSig);
        this.asyncHttpClient.post(this.configuration.context, b(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.4
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!PortraitService.this.domainRetry.isShouldRetry()) {
                    PortraitService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getHistoryPortraitsResult.setResultCode(-203);
                        getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                        return;
                    }
                    getHistoryPortraitsResult.setResultCode(-202);
                    getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                    return;
                }
                PortraitService.this.domainRetry.retry();
                PortraitService.this.getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                PortraitService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("errno");
                    getHistoryPortraitsResult.setResultCode(i2);
                    getHistoryPortraitsResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (i2 == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("history");
                        int length = optJSONArray.length();
                        getHistoryPortraitsResult.historyPortraits = new ArrayList(length);
                        for (int i3 = 0; i3 < length; i3++) {
                            getHistoryPortraitsResult.historyPortraits.add(optJSONArray.optString(i3));
                        }
                        getHistoryPortraitsCallback.onSuccess(getHistoryPortraitsResult);
                        return;
                    }
                    getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                } catch (JSONException e) {
                    getHistoryPortraitsResult.setResultCode(-202);
                    getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                    Log.e(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getPopularPortraitsInfo(final GetPopularPortraitsCallback getPopularPortraitsCallback, final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty nor null");
        }
        final GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getPopularPortraitsInfoResult.setResultCode(-201);
            getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        HashMap hashMap = new HashMap();
        hashMap.put("bduss", str);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.asyncHttpClient.post(this.configuration.context, c(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.5
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                getPopularPortraitsCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                getPopularPortraitsCallback.onFinish();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!PortraitService.this.domainRetry.isShouldRetry()) {
                    PortraitService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getPopularPortraitsInfoResult.setResultCode(-203);
                        getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                        return;
                    }
                    getPopularPortraitsInfoResult.setResultCode(-202);
                    getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                    return;
                }
                PortraitService.this.domainRetry.retry();
                PortraitService.this.getPopularPortraitsInfo(getPopularPortraitsCallback, str);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                PortraitService.this.domainRetry.reset();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno");
                    getPopularPortraitsInfoResult.setResultCode(optInt);
                    getPopularPortraitsInfoResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (optInt == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("list");
                        int length = optJSONArray.length();
                        getPopularPortraitsInfoResult.popularPortraitsInfoList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                                popularPortraitsInfo.num = optJSONObject.optInt("num");
                                popularPortraitsInfo.series = optJSONObject.optString("serie");
                                popularPortraitsInfo.url = optJSONObject.optString("url");
                                popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                                getPopularPortraitsInfoResult.popularPortraitsInfoList.add(popularPortraitsInfo);
                            }
                        }
                        getPopularPortraitsCallback.onSuccess(getPopularPortraitsInfoResult);
                        return;
                    }
                    getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                } catch (JSONException e) {
                    getPopularPortraitsInfoResult.setResultCode(-202);
                    getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                    Log.e(e);
                }
            }
        });
    }

    String a() {
        return this.domainRetry.getDomain() + "/v2/sapi/center/setportrait";
    }

    String b() {
        return this.configuration.environment.getPortraitUrl() + "/sys/history";
    }

    String c() {
        return this.configuration.environment.getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    String d() {
        return this.configuration.environment.getPortraitUrl() + "/sys/sethotitem";
    }
}
