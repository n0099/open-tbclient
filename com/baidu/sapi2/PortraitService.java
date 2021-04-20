package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
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
        public final /* synthetic */ SetPortraitCallback f10154a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SetPortraitResult f10155b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper, SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult) {
            super(looper);
            this.f10154a = setPortraitCallback;
            this.f10155b = setPortraitResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10155b.setResultCode(i);
            this.f10154a.onFailure(this.f10155b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10154a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10154a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            this.f10155b.setResultCode(PortraitService.this.getErrorCode(str));
            this.f10155b.setResultMsg(PortraitService.this.getErrorMsg(str));
            int resultCode = this.f10155b.getResultCode();
            if (resultCode != 0) {
                if (resultCode != 160103) {
                    this.f10154a.onFailure(this.f10155b);
                    return;
                } else {
                    this.f10154a.onBdussExpired(this.f10155b);
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f10155b.portraitSign = jSONObject.optString("portrait_tag");
                String optString = jSONObject.optString("portrait");
                if (!TextUtils.isEmpty(optString)) {
                    this.f10155b.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.f10155b.portraitSign);
                }
            } catch (JSONException unused) {
            }
            this.f10154a.onSuccess(this.f10155b);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SetPopularPortraitResult f10157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SetPopularPortraitCallback f10158b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper, SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback) {
            super(looper);
            this.f10157a = setPopularPortraitResult;
            this.f10158b = setPopularPortraitCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10157a.setResultCode(i);
            this.f10158b.onFailure(this.f10157a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10158b.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10158b.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("errno");
                this.f10157a.setResultCode(i2);
                this.f10157a.setResultMsg(jSONObject.optString("errmsg"));
                if (i2 == 0) {
                    this.f10158b.onSuccess(this.f10157a);
                } else {
                    this.f10158b.onFailure(this.f10157a);
                }
            } catch (JSONException e2) {
                this.f10157a.setResultCode(-202);
                this.f10158b.onFailure(this.f10157a);
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetHistoryPortraitsResult f10160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetHistoryPortraitsCallback f10161b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Looper looper, GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback) {
            super(looper);
            this.f10160a = getHistoryPortraitsResult;
            this.f10161b = getHistoryPortraitsCallback;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10160a.setResultCode(i);
            this.f10161b.onFailure(this.f10160a);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("errno");
                this.f10160a.setResultCode(i2);
                this.f10160a.setResultMsg(jSONObject.optString("errmsg"));
                if (i2 == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("history");
                    int length = optJSONArray.length();
                    this.f10160a.historyPortraits = new ArrayList(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        this.f10160a.historyPortraits.add(optJSONArray.optString(i3));
                    }
                    this.f10161b.onSuccess(this.f10160a);
                    return;
                }
                this.f10161b.onFailure(this.f10160a);
            } catch (JSONException e2) {
                this.f10160a.setResultCode(-202);
                this.f10161b.onFailure(this.f10160a);
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends HttpHandlerWrap {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GetPopularPortraitsCallback f10163a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetPopularPortraitsInfoResult f10164b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Looper looper, GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult) {
            super(looper);
            this.f10163a = getPopularPortraitsCallback;
            this.f10164b = getPopularPortraitsInfoResult;
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFailure(Throwable th, int i, String str) {
            this.f10164b.setResultCode(i);
            this.f10163a.onFailure(this.f10164b);
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onFinish() {
            this.f10163a.onFinish();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onStart() {
            this.f10163a.onStart();
        }

        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                this.f10164b.setResultCode(optInt);
                this.f10164b.setResultMsg(jSONObject.optString("errmsg"));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    int length = optJSONArray.length();
                    this.f10164b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.serie = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString("url");
                            popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                            popularPortraitsInfo.color = optJSONObject.optString("color");
                            popularPortraitsInfo.category = optJSONObject.optString("category");
                            this.f10164b.popularPortraitsInfoList.add(popularPortraitsInfo);
                        }
                    }
                    this.f10163a.onSuccess(this.f10164b);
                    return;
                }
                this.f10163a.onFailure(this.f10164b);
            } catch (JSONException e2) {
                this.f10164b.setResultCode(-202);
                this.f10163a.onFailure(this.f10164b);
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

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        SapiUtils.notNull(getPopularPortraitsCallback, GetPopularPortraitsCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        if (portraitCategory != null) {
            httpHashMapWrap.put("category", portraitCategory.getValue());
        }
        new HttpClientWrap().post(b(), httpHashMapWrap, null, getUaInfo(), new d(Looper.getMainLooper(), getPopularPortraitsCallback, getPopularPortraitsInfoResult));
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
        new HttpClientWrap().post(c(), httpHashMapWrap, null, getUaInfo(), new b(Looper.getMainLooper(), setPopularPortraitResult, setPopularPortraitCallback));
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
            new HttpClientWrap().post(d(), multipartHashMapWrap, null, getUaInfo(), new a(Looper.getMainLooper(), setPortraitCallback, setPortraitResult));
            return;
        }
        throw new IllegalArgumentException("file can't be empty");
    }
}
