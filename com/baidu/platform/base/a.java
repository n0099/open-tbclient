package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    public AsyncHttpClient f9718b = new AsyncHttpClient();

    /* renamed from: c  reason: collision with root package name */
    public Handler f9719c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    public final Lock f9717a = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public boolean f9720d = true;

    /* renamed from: e  reason: collision with root package name */
    public DistrictResult f9721e = null;

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.a.c(((DistrictResult) searchResult).getCityName()).a(), protoResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        this.f9719c.post(new c(this, dVar, searchResult, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (b(str)) {
            return;
        }
        Log.e("BaseSearch", "Permission check unfinished, try again");
        int permissionCheck = PermissionCheck.permissionCheck();
        if (permissionCheck != 0) {
            Log.e("BaseSearch", "The authorized result is: " + permissionCheck);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, d dVar, Object obj, AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback) {
        SearchResult a2 = dVar.a(str);
        a2.status = c(str);
        if (a(dVar, a2)) {
            a(asyncHttpClient, protoResultCallback, a2);
        } else if (!(dVar instanceof com.baidu.platform.core.a.b)) {
            a(a2, obj, dVar);
        } else {
            DistrictResult districtResult = this.f9721e;
            if (districtResult != null) {
                DistrictResult districtResult2 = (DistrictResult) a2;
                districtResult2.setCityCode(districtResult.getCityCode());
                districtResult2.setCenterPt(this.f9721e.getCenterPt());
            }
            a(a2, obj, dVar);
            this.f9720d = true;
            this.f9721e = null;
            ((com.baidu.platform.core.a.b) dVar).a(false);
        }
    }

    private boolean a(d dVar, SearchResult searchResult) {
        if (dVar instanceof com.baidu.platform.core.a.b) {
            DistrictResult districtResult = (DistrictResult) searchResult;
            if (SearchResult.ERRORNO.RESULT_NOT_FOUND == districtResult.error && districtResult.getCityName() != null && this.f9720d) {
                this.f9720d = false;
                this.f9721e = districtResult;
                ((com.baidu.platform.core.a.b) dVar).a(true);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                Log.e("BaseSearch", "Permission check unfinished");
                return false;
            }
            return true;
        } catch (JSONException unused) {
            Log.e("BaseSearch", "Create JSONObject failed");
            return false;
        }
    }

    private int c(String str) {
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    return jSONObject.getInt("status");
                }
                if (jSONObject.has("status_sp")) {
                    return jSONObject.getInt("status_sp");
                }
                if (jSONObject.has("result")) {
                    return jSONObject.optJSONObject("result").optInt("error");
                }
                return 10204;
            } catch (JSONException unused) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return 10204;
    }

    public boolean a(e eVar, Object obj, d dVar) {
        if (dVar == null) {
            Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        String a2 = eVar.a();
        if (a2 != null) {
            this.f9718b.get(a2, new b(this, dVar, obj));
            return true;
        }
        Log.e("BaseSearch", "The sendurl is: " + a2);
        a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
        return false;
    }
}
