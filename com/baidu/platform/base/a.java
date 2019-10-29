package com.baidu.platform.base;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mapapi.http.AsyncHttpClient;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a {
    private AsyncHttpClient b = new AsyncHttpClient();
    private Handler c = new Handler(Looper.getMainLooper());
    protected final Lock a = new ReentrantLock();
    private boolean d = true;
    private DistrictResult e = null;

    private void a(AsyncHttpClient asyncHttpClient, HttpClient.ProtoResultCallback protoResultCallback, SearchResult searchResult) {
        asyncHttpClient.get(new com.baidu.platform.core.a.c(((DistrictResult) searchResult).getCityName()).a(), protoResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpClient.HttpStateError httpStateError, d dVar, Object obj) {
        a(dVar.a("{SDK_InnerError:{httpStateError:" + httpStateError + "}}"), obj, dVar);
    }

    private void a(SearchResult searchResult, Object obj, d dVar) {
        this.c.post(new c(this, dVar, searchResult, obj));
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
        SearchResult a = dVar.a(str);
        a.status = c(str);
        if (a(dVar, a)) {
            a(asyncHttpClient, protoResultCallback, a);
        } else if (!(dVar instanceof com.baidu.platform.core.a.b)) {
            a(a, obj, dVar);
        } else {
            if (this.e != null) {
                ((DistrictResult) a).setCityCode(this.e.getCityCode());
                ((DistrictResult) a).setCenterPt(this.e.getCenterPt());
            }
            a(a, obj, dVar);
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

    private boolean b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("SDK_InnerError") && jSONObject.optJSONObject("SDK_InnerError").has("PermissionCheckError")) {
                Log.e("BaseSearch", "Permission check unfinished");
                return false;
            }
            return true;
        } catch (JSONException e) {
            Log.e("BaseSearch", "Create JSONObject failed");
            return false;
        }
    }

    private int c(String str) {
        int i = 10204;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    i = jSONObject.getInt("status");
                } else if (jSONObject.has("status_sp")) {
                    i = jSONObject.getInt("status_sp");
                } else if (jSONObject.has("result")) {
                    i = jSONObject.optJSONObject("result").optInt(BdStatsConstant.StatsType.ERROR);
                }
            } catch (JSONException e) {
                Log.e("BaseSearch", "Create JSONObject failed when get response result status");
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(e eVar, Object obj, d dVar) {
        if (dVar == null) {
            Log.e(a.class.getSimpleName(), "The SearchParser is null, must be applied.");
            return false;
        }
        String a = eVar.a();
        if (a != null) {
            this.b.get(a, new b(this, dVar, obj));
            return true;
        }
        Log.e("BaseSearch", "The sendurl is: " + a);
        a(dVar.a("{SDK_InnerError:{PermissionCheckError:Error}}"), obj, dVar);
        return false;
    }
}
