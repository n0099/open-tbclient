package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.httpwrap.MultipartHashMapWrap;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PortraitService extends AbstractService {
    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPortrait(final SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        SapiUtils.notNull(setPortraitCallback, SetPortraitCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        }
        final SetPortraitResult setPortraitResult = new SetPortraitResult();
        MultipartHashMapWrap multipartHashMapWrap = new MultipartHashMapWrap();
        multipartHashMapWrap.put("bduss", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "image/jpeg";
        }
        multipartHashMapWrap.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", str2);
        new HttpClientWrap().post(a(), multipartHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                setPortraitCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                setPortraitCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
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
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                setPortraitResult.setResultCode(i);
                setPortraitCallback.onFailure(setPortraitResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPopularPortrait(final SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        SapiUtils.notNull(setPopularPortraitCallback, SetPopularPortraitCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(setPopularPortraitDTO, "SetPopularPortraitDto can't be null");
        SapiUtils.notEmpty(setPopularPortraitDTO.bduss, "bduss can't be empty");
        SapiUtils.notEmpty(setPopularPortraitDTO.series, "series can't be empty");
        final SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", setPopularPortraitDTO.bduss);
        httpHashMapWrap.put("serie", setPopularPortraitDTO.series);
        httpHashMapWrap.put("num", String.valueOf(setPopularPortraitDTO.num));
        new HttpClientWrap().post(d(), httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.2
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                setPopularPortraitResult.setResultCode(i);
                setPopularPortraitCallback.onFailure(setPopularPortraitResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
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

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                setPopularPortraitCallback.onStart();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                setPopularPortraitCallback.onFinish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getHistoryPortraits(final GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        SapiUtils.notNull(getHistoryPortraitsCallback, GetHistoryPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(getHistoryPortraitsDTO, "getHistoryPortrats dto can't be null");
        SapiUtils.notEmpty(getHistoryPortraitsDTO.bduss, "bduss can't be empty");
        if (getHistoryPortraitsDTO.maxNum < 0 || getHistoryPortraitsDTO.maxNum > 10) {
            throw new IllegalArgumentException("abnormal request history number");
        }
        final GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("length", String.valueOf(getHistoryPortraitsDTO.maxNum));
        httpHashMapWrap.put("bduss", getHistoryPortraitsDTO.bduss);
        new HttpClientWrap().post(b(), httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.3
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                getHistoryPortraitsResult.setResultCode(i);
                getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
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
    public void getPopularPortraitsInfo(final GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        SapiUtils.notNull(getPopularPortraitsCallback, GetPopularPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        final GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(c(), httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.PortraitService.4
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                getPopularPortraitsCallback.onStart();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                getPopularPortraitsCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                getPopularPortraitsInfoResult.setResultCode(i);
                getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno");
                    getPopularPortraitsInfoResult.setResultCode(optInt);
                    getPopularPortraitsInfoResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (optInt == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray(IntentConfig.LIST);
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
        return "/v2/sapi/center/setportrait";
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
