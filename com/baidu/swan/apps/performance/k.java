package com.baidu.swan.apps.performance;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.webkit.internal.ETAG;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static k cUN;
    private String[] cUP;
    private Map<String, JSONArray> cUO = new ArrayMap();
    private String mPort = "";
    private Map<String, String> cUQ = new HashMap();

    private k() {
    }

    public static k azp() {
        if (cUN == null) {
            synchronized (k.class) {
                if (cUN == null) {
                    cUN = new k();
                }
            }
        }
        return cUN;
    }

    public boolean isAvailable() {
        return (this.cUP == null || this.cUP.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
    }

    public void J(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("tool_ip");
            String string2 = bundle.getString("tool_port");
            String string3 = bundle.getString("projectId");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                if (DEBUG) {
                    Log.d("TraceDataManager", "Trace Data Params is invalid");
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d("TraceDataManager", "IP : " + string);
                Log.d("TraceDataManager", "Port : " + string2);
                Log.d("TraceDataManager", "Project ID : " + string3);
            }
            this.cUP = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.cUQ.put("projectId", string3);
        }
    }

    public void bm(JSONObject jSONObject) {
        if (this.cUO != null && jSONObject != null) {
            String avz = com.baidu.swan.apps.v.f.avu().avz();
            JSONArray jSONArray = this.cUO.get(avz);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.cUO.put(avz, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.runtime.d.aCW().aCU(), a.h.aiapps_debug_report_invalid_params).showToast();
        } else if (this.cUO == null || this.cUO.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.aCW().aCU()).hK(a.h.aiapps_debug_report_performance).hJ(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aCH();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.cUO.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("path", entry.getKey());
                    jSONObject.putOpt("data", entry.getValue().toString());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.e("TraceDataManager", "Maybe the format of the Trace data is incorrect", e);
                }
            }
            com.baidu.swan.a.a.f postRequest = com.baidu.swan.a.c.a.aWr().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.cUP.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(jl(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String jl(int i) {
        if (!isAvailable() || i >= this.cUP.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.cUP[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.cUQ.entrySet()) {
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes10.dex */
    private class b extends ResponseCallback {
        private AtomicInteger cUR = new AtomicInteger(0);
        private boolean cUS;
        private a cUT;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.cUT = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            if (response == null || response.body() == null || !response.isSuccessful()) {
                return null;
            }
            try {
                return response.body().string();
            } catch (IOException e) {
                if (k.DEBUG) {
                    Log.d("TraceDataManager", "Trace Data publish fail for IOException", e);
                    return null;
                }
                return null;
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            this.cUS = true;
            k.this.cUO = new ArrayMap();
            if (this.cUT == null) {
                return;
            }
            this.cUT.jm(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.cUS || this.cUR.incrementAndGet() < this.mCount || this.cUT == null) {
                return;
            }
            this.cUT.jm(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class a {
        public abstract void ml(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void jm(int i) {
            Application asf = com.baidu.swan.apps.t.a.asf();
            if (asf != null) {
                ml(asf.getString(i));
            }
        }
    }
}
