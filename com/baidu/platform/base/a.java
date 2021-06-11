package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.AlgorithmUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: f  reason: collision with root package name */
    public SearchType f9300f;

    /* renamed from: b  reason: collision with root package name */
    public AsyncHttpClient f9296b = new AsyncHttpClient();

    /* renamed from: c  reason: collision with root package name */
    public Handler f9297c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Lock f9295a = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public boolean f9298d = true;

    /* renamed from: e  reason: collision with root package name */
    public DistrictResult f9299e = null;

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        byte[] bArr = {102, 97, 105, 108, 100};
        try {
            bArr = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
        } catch (Exception e2) {
            Log.e("BaseSearch", "transform result failed", e2);
        }
        return new String(bArr).trim();
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.a.c(((DistrictResult) searchResult).getCityName()).a(this.f9300f), protoResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        this.f9297c.post(new c(this, dVar, searchResult, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        SearchResult a2 = dVar.a(str);
        a2.status = b(str);
        if (a(dVar, a2)) {
            a(asyncHttpClient, protoResultCallback, a2);
        } else if (!(dVar instanceof com.baidu.platform.core.a.b)) {
            a(a2, obj, dVar);
        } else {
            DistrictResult districtResult = this.f9299e;
            if (districtResult != null) {
                DistrictResult districtResult2 = (DistrictResult) a2;
                districtResult2.setCityCode(districtResult.getCityCode());
                districtResult2.setCenterPt(this.f9299e.getCenterPt());
            }
            a(a2, obj, dVar);
            this.f9298d = true;
            this.f9299e = null;
            ((com.baidu.platform.core.a.b) dVar).a(false);
        }
    }

    private boolean a(d dVar, SearchResult searchResult) {
        if (dVar instanceof com.baidu.platform.core.a.b) {
            DistrictResult districtResult = (DistrictResult) searchResult;
            if (SearchResult.ERRORNO.RESULT_NOT_FOUND == districtResult.error && districtResult.getCityName() != null && this.f9298d) {
                this.f9298d = false;
                this.f9299e = districtResult;
                ((com.baidu.platform.core.a.b) dVar).a(true);
                return true;
            }
            return false;
        }
        return false;
    }

    private int b(String str) {
        JSONObject optJSONObject;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    return jSONObject.getInt("status");
                }
                if (jSONObject.has("status_sp")) {
                    return jSONObject.getInt("status_sp");
                }
                if (!jSONObject.has("result") || (optJSONObject = jSONObject.optJSONObject("result")) == null) {
                    return 10204;
                }
                return optJSONObject.optInt("error");
            } catch (JSONException unused) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return 10204;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        int permissionCheck;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                int i2 = jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp");
                if ((i2 == 105 || i2 == 106) && (permissionCheck = PermissionCheck.permissionCheck()) != 0) {
                    Log.e("BaseSearch", "permissionCheck result is: " + permissionCheck);
                }
            }
        } catch (JSONException e2) {
            Log.e("BaseSearch", "Parse json happened exception", e2);
        }
    }

    public boolean a(e eVar, Object obj, d dVar) {
        if (dVar == null) {
            Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        SearchType a2 = dVar.a();
        this.f9300f = a2;
        String a3 = eVar.a(a2);
        if (a3 != null) {
            this.f9296b.get(a3, new b(this, dVar, obj));
            return true;
        }
        Log.e("BaseSearch", "The sendurl is: " + a3);
        a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
        return false;
    }
}
