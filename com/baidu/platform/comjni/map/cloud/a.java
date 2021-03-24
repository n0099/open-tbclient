package com.baidu.platform.comjni.map.cloud;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mapapi.cloud.CloudListener;
import com.baidu.mapapi.cloud.CloudRgcResult;
import com.baidu.mapapi.cloud.CloudSearchResult;
import com.baidu.mapapi.cloud.DetailSearchResult;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements ICloudCenter {

    /* renamed from: b  reason: collision with root package name */
    public int f10394b;

    /* renamed from: c  reason: collision with root package name */
    public CloudListener f10395c;

    /* renamed from: h  reason: collision with root package name */
    public String f10400h;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f10393a = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public boolean f10396d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10397e = true;

    /* renamed from: f  reason: collision with root package name */
    public AsyncHttpClient f10398f = new AsyncHttpClient();

    /* renamed from: g  reason: collision with root package name */
    public Handler f10399g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        switch (this.f10394b) {
            case 10001:
                CloudSearchResult cloudSearchResult = new CloudSearchResult();
                this.f10393a.lock();
                try {
                    this.f10395c.onGetSearchResult(cloudSearchResult, i);
                    break;
                } finally {
                }
            case 10002:
                DetailSearchResult detailSearchResult = new DetailSearchResult();
                this.f10393a.lock();
                try {
                    this.f10395c.onGetDetailSearchResult(detailSearchResult, i);
                    break;
                } finally {
                }
            case 10003:
                CloudRgcResult cloudRgcResult = new CloudRgcResult();
                this.f10393a.lock();
                try {
                    this.f10395c.onGetCloudRgcResult(cloudRgcResult, i);
                    break;
                } finally {
                }
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private boolean d(String str) {
        if (str == null) {
            return false;
        }
        this.f10398f.get(str, new b(this));
        return true;
    }

    private String e(String str) {
        String authToken;
        if (str == null || str.equals("")) {
            return null;
        }
        if (HttpClient.getAuthToken() == null) {
            a(-4);
            return null;
        }
        if (this.f10396d) {
            str = str + "&token=" + AppMD5.encodeUrlParamsValue(authToken);
        }
        String str2 = str + HttpClient.getPhoneInfo();
        if (this.f10397e) {
            Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
            return str2 + "&sign=" + AppMD5.getSignMD5String(buildUpon.build().getEncodedQuery());
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (this.f10394b) {
                case 10001:
                    CloudSearchResult cloudSearchResult = new CloudSearchResult();
                    try {
                        cloudSearchResult.parseFromJSON(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.f10393a.lock();
                    try {
                        this.f10395c.onGetSearchResult(cloudSearchResult, cloudSearchResult.status);
                        break;
                    } finally {
                    }
                case 10002:
                    DetailSearchResult detailSearchResult = new DetailSearchResult();
                    try {
                        detailSearchResult.parseFromJSON(jSONObject);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    this.f10393a.lock();
                    try {
                        this.f10395c.onGetDetailSearchResult(detailSearchResult, detailSearchResult.status);
                        break;
                    } finally {
                    }
                case 10003:
                    CloudRgcResult cloudRgcResult = new CloudRgcResult();
                    try {
                        cloudRgcResult.parseFromJSON(jSONObject);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                    this.f10393a.lock();
                    try {
                        this.f10395c.onGetCloudRgcResult(cloudRgcResult, cloudRgcResult.status);
                        break;
                    } finally {
                    }
                default:
                    return;
            }
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public void a(CloudListener cloudListener) {
        this.f10393a.lock();
        this.f10395c = cloudListener;
        this.f10393a.unlock();
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public boolean a(String str) {
        this.f10394b = 10001;
        this.f10396d = false;
        return d(e(str));
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public boolean b(String str) {
        this.f10394b = 10002;
        this.f10396d = false;
        return d(e(str));
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public boolean c(String str) {
        this.f10394b = 10003;
        this.f10396d = true;
        return d(e(str));
    }
}
