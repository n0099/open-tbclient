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
/* loaded from: classes8.dex */
public class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static k doK;
    private String[] doM;
    private Map<String, JSONArray> doL = new ArrayMap();
    private String mPort = "";
    private Map<String, String> doN = new HashMap();

    private k() {
    }

    public static k aDJ() {
        if (doK == null) {
            synchronized (k.class) {
                if (doK == null) {
                    doK = new k();
                }
            }
        }
        return doK;
    }

    public boolean isAvailable() {
        return (this.doM == null || this.doM.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
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
            this.doM = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.doN.put("projectId", string3);
        }
    }

    public void bz(JSONObject jSONObject) {
        if (this.doL != null && jSONObject != null) {
            String azS = com.baidu.swan.apps.v.f.azN().azS();
            JSONArray jSONArray = this.doL.get(azS);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.doL.put(azS, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.runtime.d.aIn().aIl(), a.h.aiapps_debug_report_invalid_params).aHZ();
        } else if (this.doL == null || this.doL.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.aIn().aIl()).gO(a.h.aiapps_debug_report_performance).gN(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aHE();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.doL.entrySet()) {
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
            com.baidu.swan.a.a.f postRequest = com.baidu.swan.a.c.a.bbL().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.doM.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(ip(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String ip(int i) {
        if (!isAvailable() || i >= this.doM.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.doM[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.doN.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes8.dex */
    private class b extends ResponseCallback {
        private AtomicInteger doO = new AtomicInteger(0);
        private boolean doP;
        private a doQ;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.doQ = aVar;
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
            this.doP = true;
            k.this.doL = new ArrayMap();
            if (this.doQ == null) {
                return;
            }
            this.doQ.iq(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.doP || this.doO.incrementAndGet() < this.mCount || this.doQ == null) {
                return;
            }
            this.doQ.iq(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class a {
        public abstract void mc(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void iq(int i) {
            Application awy = com.baidu.swan.apps.t.a.awy();
            if (awy != null) {
                mc(awy.getString(i));
            }
        }
    }
}
