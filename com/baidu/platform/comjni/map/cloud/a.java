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
/* loaded from: classes5.dex */
public class a implements ICloudCenter {
    private int b;
    private CloudListener c;
    private String h;
    protected final Lock a = new ReentrantLock();
    private boolean d = true;
    private boolean e = true;
    private AsyncHttpClient f = new AsyncHttpClient();
    private Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        switch (this.b) {
            case 10001:
                CloudSearchResult cloudSearchResult = new CloudSearchResult();
                this.a.lock();
                try {
                    this.c.onGetSearchResult(cloudSearchResult, i);
                    return;
                } finally {
                }
            case 10002:
                DetailSearchResult detailSearchResult = new DetailSearchResult();
                this.a.lock();
                try {
                    this.c.onGetDetailSearchResult(detailSearchResult, i);
                    return;
                } finally {
                }
            case 10003:
                CloudRgcResult cloudRgcResult = new CloudRgcResult();
                this.a.lock();
                try {
                    this.c.onGetCloudRgcResult(cloudRgcResult, i);
                    return;
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
        this.f.get(str, new b(this));
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
        if (this.d) {
            str = str + "&token=" + AppMD5.encodeUrlParamsValue(authToken);
        }
        String str2 = str + HttpClient.getPhoneInfo();
        if (this.e) {
            return str2 + "&sign=" + AppMD5.getSignMD5String(Uri.parse(str2).buildUpon().build().getEncodedQuery());
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (this.b) {
                case 10001:
                    CloudSearchResult cloudSearchResult = new CloudSearchResult();
                    try {
                        cloudSearchResult.parseFromJSON(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.a.lock();
                    try {
                        this.c.onGetSearchResult(cloudSearchResult, cloudSearchResult.status);
                        return;
                    } finally {
                    }
                case 10002:
                    DetailSearchResult detailSearchResult = new DetailSearchResult();
                    try {
                        detailSearchResult.parseFromJSON(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    this.a.lock();
                    try {
                        this.c.onGetDetailSearchResult(detailSearchResult, detailSearchResult.status);
                        return;
                    } finally {
                    }
                case 10003:
                    CloudRgcResult cloudRgcResult = new CloudRgcResult();
                    try {
                        cloudRgcResult.parseFromJSON(jSONObject);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    this.a.lock();
                    try {
                        this.c.onGetCloudRgcResult(cloudRgcResult, cloudRgcResult.status);
                        return;
                    } finally {
                    }
                default:
                    return;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public void a(CloudListener cloudListener) {
        this.a.lock();
        this.c = cloudListener;
        this.a.unlock();
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public boolean a(String str) {
        this.b = 10001;
        this.d = false;
        return d(e(str));
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public boolean b(String str) {
        this.b = 10002;
        this.d = false;
        return d(e(str));
    }

    @Override // com.baidu.platform.comjni.map.cloud.ICloudCenter
    public boolean c(String str) {
        this.b = 10003;
        this.d = true;
        return d(e(str));
    }
}
