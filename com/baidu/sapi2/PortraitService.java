package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.android.util.media.MimeType;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
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
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class PortraitService extends AbstractService implements NoProguard {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetPortraitCallback f3213a;
        final /* synthetic */ SetPortraitResult b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult) {
            super(looper);
            this.f3213a = setPortraitCallback;
            this.b = setPortraitResult;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.f3213a.onFailure(this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f3213a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f3213a.onStart();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            this.b.setResultCode(PortraitService.this.getErrorCode(str));
            this.b.setResultMsg(PortraitService.this.getErrorMsg(str));
            int resultCode = this.b.getResultCode();
            if (resultCode != 0) {
                if (resultCode != 160103) {
                    this.f3213a.onFailure(this.b);
                    return;
                } else {
                    this.f3213a.onBdussExpired(this.b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.b.portraitSign = jSONObject.optString("portrait_tag");
                String optString = jSONObject.optString("portrait");
                if (!TextUtils.isEmpty(optString)) {
                    this.b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.b.portraitSign);
                }
            } catch (JSONException e) {
            }
            this.f3213a.onSuccess(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SetPopularPortraitResult f3214a;
        final /* synthetic */ SetPopularPortraitCallback b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Looper looper, SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback) {
            super(looper);
            this.f3214a = setPopularPortraitResult;
            this.b = setPopularPortraitCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f3214a.setResultCode(i);
            this.b.onFailure(this.f3214a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.b.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt(BaseJsonData.TAG_ERRNO);
                this.f3214a.setResultCode(i2);
                this.f3214a.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                if (i2 == 0) {
                    this.b.onSuccess(this.f3214a);
                } else {
                    this.b.onFailure(this.f3214a);
                }
            } catch (JSONException e) {
                this.f3214a.setResultCode(-202);
                this.b.onFailure(this.f3214a);
                Log.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetHistoryPortraitsResult f3215a;
        final /* synthetic */ GetHistoryPortraitsCallback b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback) {
            super(looper);
            this.f3215a = getHistoryPortraitsResult;
            this.b = getHistoryPortraitsCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f3215a.setResultCode(i);
            this.b.onFailure(this.f3215a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt(BaseJsonData.TAG_ERRNO);
                this.f3215a.setResultCode(i2);
                this.f3215a.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                if (i2 == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("history");
                    int length = optJSONArray.length();
                    this.f3215a.historyPortraits = new ArrayList(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        this.f3215a.historyPortraits.add(optJSONArray.optString(i3));
                    }
                    this.b.onSuccess(this.f3215a);
                    return;
                }
                this.b.onFailure(this.f3215a);
            } catch (JSONException e) {
                this.f3215a.setResultCode(-202);
                this.b.onFailure(this.f3215a);
                Log.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GetPopularPortraitsCallback f3216a;
        final /* synthetic */ GetPopularPortraitsInfoResult b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Looper looper, GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            super(looper);
            this.f3216a = getPopularPortraitsCallback;
            this.b = getPopularPortraitsInfoResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.b.setResultCode(i);
            this.f3216a.onFailure(this.b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f3216a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f3216a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.b.setResultCode(optInt);
                this.b.setResultMsg(jSONObject.optString(BaseJsonData.TAG_ERRMSG));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    this.b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.series = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString("url");
                            popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                            this.b.popularPortraitsInfoList.add(popularPortraitsInfo);
                        }
                    }
                    this.f3216a.onSuccess(this.b);
                    return;
                }
                this.f3216a.onFailure(this.b);
            } catch (JSONException e) {
                this.b.setResultCode(-202);
                this.f3216a.onFailure(this.b);
                Log.e(e);
            }
        }
    }

    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    String a() {
        return this.configuration.environment.getPortraitUrl() + "/sys/history";
    }

    String b() {
        return this.configuration.environment.getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    String c() {
        return this.configuration.environment.getPortraitUrl() + "/sys/sethotitem";
    }

    String d() {
        return "/v2/sapi/center/setportrait";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        SapiUtils.notNull(getHistoryPortraitsCallback, GetHistoryPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(getHistoryPortraitsDTO, "getHistoryPortrats dto can't be null");
        SapiUtils.notEmpty(getHistoryPortraitsDTO.bduss, "bduss can't be empty");
        int i = getHistoryPortraitsDTO.maxNum;
        if (i >= 0 && i <= 10) {
            GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("length", String.valueOf(getHistoryPortraitsDTO.maxNum));
            httpHashMapWrap.put("bduss", getHistoryPortraitsDTO.bduss);
            new HttpClientWrap().post(a(), httpHashMapWrap, null, getUaInfo(), new c(Looper.getMainLooper(), getHistoryPortraitsResult, getHistoryPortraitsCallback));
            return;
        }
        throw new IllegalArgumentException("abnormal request history number");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        SapiUtils.notNull(getPopularPortraitsCallback, GetPopularPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(b(), httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), getPopularPortraitsCallback, getPopularPortraitsInfoResult));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        SapiUtils.notNull(setPopularPortraitCallback, SetPopularPortraitCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(setPopularPortraitDTO, "SetPopularPortraitDto can't be null");
        SapiUtils.notEmpty(setPopularPortraitDTO.bduss, "bduss can't be empty");
        SapiUtils.notEmpty(setPopularPortraitDTO.series, "series can't be empty");
        SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", setPopularPortraitDTO.bduss);
        httpHashMapWrap.put("serie", setPopularPortraitDTO.series);
        httpHashMapWrap.put("num", String.valueOf(setPopularPortraitDTO.num));
        new HttpClientWrap().post(c(), httpHashMapWrap, null, getUaInfo(), new b(Looper.getMainLooper(), setPopularPortraitResult, setPopularPortraitCallback));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        SapiUtils.notNull(setPortraitDTO, "SetPortraitDTO can't be null");
        SapiUtils.notNull(setPortraitCallback, "SetPortraitCallback can't be null");
        SapiUtils.notEmpty(setPortraitDTO.bduss, "bduss can't be empty");
        byte[] bArr = setPortraitDTO.file;
        if (bArr != null && bArr.length != 0) {
            SetPortraitResult setPortraitResult = new SetPortraitResult();
            MultipartHashMapWrap multipartHashMapWrap = new MultipartHashMapWrap();
            multipartHashMapWrap.put("bduss", setPortraitDTO.bduss);
            multipartHashMapWrap.put("portrait_type", setPortraitDTO.portraitType + "");
            multipartHashMapWrap.put("file", new ByteArrayInputStream(setPortraitDTO.file), "portrait.jpg", TextUtils.isEmpty(setPortraitDTO.contentType) ? MimeType.Image.JPEG : setPortraitDTO.contentType);
            new HttpClientWrap().post(d(), multipartHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), setPortraitCallback, setPortraitResult));
            return;
        }
        throw new IllegalArgumentException("file can't be empty");
    }
}
