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
/* loaded from: classes7.dex */
public class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static k cyO;
    private String[] cyQ;
    private Map<String, JSONArray> cyP = new ArrayMap();
    private String mPort = "";
    private Map<String, String> cyR = new HashMap();

    private k() {
    }

    public static k aoa() {
        if (cyO == null) {
            synchronized (k.class) {
                if (cyO == null) {
                    cyO = new k();
                }
            }
        }
        return cyO;
    }

    public boolean isAvailable() {
        return (this.cyQ == null || this.cyQ.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
    }

    public void L(Bundle bundle) {
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
            this.cyQ = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.cyR.put("projectId", string3);
        }
    }

    public void aV(JSONObject jSONObject) {
        if (this.cyP != null && jSONObject != null) {
            String akw = com.baidu.swan.apps.v.f.akr().akw();
            JSONArray jSONArray = this.cyP.get(akw);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.cyP.put(akw, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.runtime.d.arr().arp(), a.h.aiapps_debug_report_invalid_params).showToast();
        } else if (this.cyP == null || this.cyP.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.arr().arp()).fi(a.h.aiapps_debug_report_performance).fh(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).ard();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.cyP.entrySet()) {
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
            com.baidu.swan.b.a.f postRequest = com.baidu.swan.b.c.a.aKu().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.cyQ.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(gy(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String gy(int i) {
        if (!isAvailable() || i >= this.cyQ.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.cyQ[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.cyR.entrySet()) {
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes7.dex */
    private class b extends ResponseCallback {
        private AtomicInteger cyS = new AtomicInteger(0);
        private boolean cyT;
        private a cyU;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.cyU = aVar;
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
            this.cyT = true;
            k.this.cyP = new ArrayMap();
            if (this.cyU == null) {
                return;
            }
            this.cyU.gz(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.cyT || this.cyS.incrementAndGet() < this.mCount || this.cyU == null) {
                return;
            }
            this.cyU.gz(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class a {
        public abstract void jG(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void gz(int i) {
            Application ahj = com.baidu.swan.apps.t.a.ahj();
            if (ahj != null) {
                jG(ahj.getString(i));
            }
        }
    }
}
