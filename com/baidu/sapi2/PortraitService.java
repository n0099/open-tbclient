package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.enums.PortraitCategory;
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
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PortraitService extends AbstractService implements NoProguard {

    /* loaded from: classes2.dex */
    public class a extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPortraitCallback f9537a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SetPortraitResult f9538b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult) {
            super(looper);
            this.f9537a = setPortraitCallback;
            this.f9538b = setPortraitResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9538b.setResultCode(i2);
            this.f9537a.onFailure(this.f9538b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9537a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f9537a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            this.f9538b.setResultCode(PortraitService.this.getErrorCode(str));
            this.f9538b.setResultMsg(PortraitService.this.getErrorMsg(str));
            int resultCode = this.f9538b.getResultCode();
            if (resultCode != 0) {
                if (resultCode != 160103) {
                    this.f9537a.onFailure(this.f9538b);
                    return;
                } else {
                    this.f9537a.onBdussExpired(this.f9538b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f9538b.portraitSign = jSONObject.optString("portrait_tag");
                String optString = jSONObject.optString("portrait");
                if (!TextUtils.isEmpty(optString)) {
                    this.f9538b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.f9538b.portraitSign);
                }
            } catch (JSONException unused) {
            }
            this.f9537a.onSuccess(this.f9538b);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPopularPortraitResult f9540a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SetPopularPortraitCallback f9541b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback) {
            super(looper);
            this.f9540a = setPopularPortraitResult;
            this.f9541b = setPopularPortraitCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9540a.setResultCode(i2);
            this.f9541b.onFailure(this.f9540a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9541b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f9541b.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = jSONObject.getInt("errno");
                this.f9540a.setResultCode(i3);
                this.f9540a.setResultMsg(jSONObject.optString("errmsg"));
                if (i3 == 0) {
                    this.f9541b.onSuccess(this.f9540a);
                } else {
                    this.f9541b.onFailure(this.f9540a);
                }
            } catch (JSONException e2) {
                this.f9540a.setResultCode(-202);
                this.f9541b.onFailure(this.f9540a);
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetHistoryPortraitsResult f9543a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetHistoryPortraitsCallback f9544b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback) {
            super(looper);
            this.f9543a = getHistoryPortraitsResult;
            this.f9544b = getHistoryPortraitsCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9543a.setResultCode(i2);
            this.f9544b.onFailure(this.f9543a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i3 = jSONObject.getInt("errno");
                this.f9543a.setResultCode(i3);
                this.f9543a.setResultMsg(jSONObject.optString("errmsg"));
                if (i3 == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("history");
                    int length = optJSONArray.length();
                    this.f9543a.historyPortraits = new ArrayList(length);
                    for (int i4 = 0; i4 < length; i4++) {
                        this.f9543a.historyPortraits.add(optJSONArray.optString(i4));
                    }
                    this.f9544b.onSuccess(this.f9543a);
                    return;
                }
                this.f9544b.onFailure(this.f9543a);
            } catch (JSONException e2) {
                this.f9543a.setResultCode(-202);
                this.f9544b.onFailure(this.f9543a);
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetPopularPortraitsCallback f9546a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetPopularPortraitsInfoResult f9547b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            super(looper);
            this.f9546a = getPopularPortraitsCallback;
            this.f9547b = getPopularPortraitsInfoResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i2, String str) {
            this.f9547b.setResultCode(i2);
            this.f9546a.onFailure(this.f9547b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f9546a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f9546a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i2, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                this.f9547b.setResultCode(optInt);
                this.f9547b.setResultMsg(jSONObject.optString("errmsg"));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    this.f9547b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.serie = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString("url");
                            popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                            popularPortraitsInfo.color = optJSONObject.optString("color");
                            popularPortraitsInfo.category = optJSONObject.optString("category");
                            this.f9547b.popularPortraitsInfoList.add(popularPortraitsInfo);
                        }
                    }
                    this.f9546a.onSuccess(this.f9547b);
                    return;
                }
                this.f9546a.onFailure(this.f9547b);
            } catch (JSONException e2) {
                this.f9547b.setResultCode(-202);
                this.f9546a.onFailure(this.f9547b);
                Log.e(e2);
            }
        }
    }

    public PortraitService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    public String a() {
        return this.configuration.environment.getPortraitUrl() + "/sys/history";
    }

    public String b() {
        return this.configuration.environment.getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    public String c() {
        return this.configuration.environment.getPortraitUrl() + "/sys/sethotitem";
    }

    public String d() {
        return "/v2/sapi/center/setportrait";
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        SapiUtils.notNull(getHistoryPortraitsCallback, GetHistoryPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notNull(getHistoryPortraitsDTO, "getHistoryPortrats dto can't be null");
        SapiUtils.notEmpty(getHistoryPortraitsDTO.bduss, "bduss can't be empty");
        int i2 = getHistoryPortraitsDTO.maxNum;
        if (i2 >= 0 && i2 <= 10) {
            GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(getHistoryPortraitsDTO.maxNum));
            httpHashMapWrap.put("bduss", getHistoryPortraitsDTO.bduss);
            new HttpClientWrap().post(a(), ReqPriority.HIGH, httpHashMapWrap, null, getUaInfo(), new c(Looper.getMainLooper(), getHistoryPortraitsResult, getHistoryPortraitsCallback));
            return;
        }
        throw new IllegalArgumentException("abnormal request history number");
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        SapiUtils.notNull(getPopularPortraitsCallback, GetPopularPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        if (portraitCategory != null) {
            httpHashMapWrap.put("category", portraitCategory.getValue());
        }
        new HttpClientWrap().post(b(), ReqPriority.HIGH, httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), getPopularPortraitsCallback, getPopularPortraitsInfoResult));
    }

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
        new HttpClientWrap().post(c(), ReqPriority.HIGH, httpHashMapWrap, null, getUaInfo(), new b(Looper.getMainLooper(), setPopularPortraitResult, setPopularPortraitCallback));
    }

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
            multipartHashMapWrap.put("file", new ByteArrayInputStream(setPortraitDTO.file), "portrait.jpg", TextUtils.isEmpty(setPortraitDTO.contentType) ? "image/jpeg" : setPortraitDTO.contentType);
            new HttpClientWrap().post(d(), ReqPriority.HIGH, multipartHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), setPortraitCallback, setPortraitResult));
            return;
        }
        throw new IllegalArgumentException("file can't be empty");
    }
}
