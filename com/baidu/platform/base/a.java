package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
/* loaded from: classes3.dex */
public abstract class a {
    private SearchType f;

    /* renamed from: b  reason: collision with root package name */
    private AsyncHttpClient f4172b = new AsyncHttpClient();
    private Handler c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    protected final Lock f4171a = new ReentrantLock();
    private boolean d = true;
    private DistrictResult e = null;

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        byte[] bArr = {102, 97, 105, 108, 100};
        try {
            bArr = AlgorithmUtil.getUrlNeedInfo(AppMD5.getUrlNeedInfo(), AppMD5.getUrlNeedInfo(), Base64.decode(str.getBytes(), 0));
        } catch (Exception e) {
            Log.e("BaseSearch", "transform result failed");
        }
        return new String(bArr).trim();
    }

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.a.c(((DistrictResult) searchResult).getCityName()).a(this.f), protoResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        this.c.post(new c(this, dVar, searchResult, obj));
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
            if (this.e != null) {
                ((DistrictResult) a2).setCityCode(this.e.getCityCode());
                ((DistrictResult) a2).setCenterPt(this.e.getCenterPt());
            }
            a(a2, obj, dVar);
            this.d = true;
            this.e = null;
            ((com.baidu.platform.core.a.b) dVar).a(false);
        }
    }

    private boolean a(d dVar, SearchResult searchResult) {
        if ((dVar instanceof com.baidu.platform.core.a.b) && SearchResult.ERRORNO.RESULT_NOT_FOUND == ((DistrictResult) searchResult).error && ((DistrictResult) searchResult).getCityName() != null && this.d) {
            this.d = false;
            this.e = (DistrictResult) searchResult;
            ((com.baidu.platform.core.a.b) dVar).a(true);
            return true;
        }
        return false;
    }

    private int b(String str) {
        JSONObject optJSONObject;
        int i = 10204;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    i = jSONObject.getInt("status");
                } else if (jSONObject.has("status_sp")) {
                    i = jSONObject.getInt("status_sp");
                } else if (jSONObject.has("result") && (optJSONObject = jSONObject.optJSONObject("result")) != null) {
                    i = optJSONObject.optInt(BdStatsConstant.StatsType.ERROR);
                }
            } catch (JSONException e) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") || jSONObject.has("status_sp")) {
                switch (jSONObject.has("status") ? jSONObject.getInt("status") : jSONObject.getInt("status_sp")) {
                    case 105:
                    case 106:
                        int permissionCheck = PermissionCheck.permissionCheck();
                        if (permissionCheck != 0) {
                            Log.e("BaseSearch", "permissionCheck result is: " + permissionCheck);
                            break;
                        }
                        break;
                }
            }
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(e eVar, Object obj, d dVar) {
        if (dVar == null) {
            Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        this.f = dVar.a();
        String a2 = eVar.a(this.f);
        if (a2 != null) {
            this.f4172b.get(a2, new b(this, dVar, obj));
            return true;
        }
        Log.e("BaseSearch", "The sendurl is: " + a2);
        a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
        return false;
    }
}
