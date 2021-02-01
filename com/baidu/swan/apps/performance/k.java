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
/* loaded from: classes9.dex */
public class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static k dqV;
    private String[] dqX;
    private Map<String, JSONArray> dqW = new ArrayMap();
    private String mPort = "";
    private Map<String, String> dqY = new HashMap();

    private k() {
    }

    public static k aEe() {
        if (dqV == null) {
            synchronized (k.class) {
                if (dqV == null) {
                    dqV = new k();
                }
            }
        }
        return dqV;
    }

    public boolean isAvailable() {
        return (this.dqX == null || this.dqX.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
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
            this.dqX = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.dqY.put("projectId", string3);
        }
    }

    public void bw(JSONObject jSONObject) {
        if (this.dqW != null && jSONObject != null) {
            String aAq = com.baidu.swan.apps.v.f.aAl().aAq();
            JSONArray jSONArray = this.dqW.get(aAq);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.dqW.put(aAq, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.runtime.d.aIG().aIE(), a.h.aiapps_debug_report_invalid_params).aIs();
        } else if (this.dqW == null || this.dqW.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.aIG().aIE()).gR(a.h.aiapps_debug_report_performance).gQ(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aHX();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.dqW.entrySet()) {
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
            com.baidu.swan.a.a.f postRequest = com.baidu.swan.a.c.a.bbY().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.dqX.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(is(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String is(int i) {
        if (!isAvailable() || i >= this.dqX.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.dqX[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.dqY.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes9.dex */
    private class b extends ResponseCallback {
        private AtomicInteger dqZ = new AtomicInteger(0);
        private boolean dra;
        private a drb;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.drb = aVar;
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
            this.dra = true;
            k.this.dqW = new ArrayMap();
            if (this.drb == null) {
                return;
            }
            this.drb.it(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.dra || this.dqZ.incrementAndGet() < this.mCount || this.drb == null) {
                return;
            }
            this.drb.it(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public abstract void mu(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void it(int i) {
            Application awW = com.baidu.swan.apps.t.a.awW();
            if (awW != null) {
                mu(awW.getString(i));
            }
        }
    }
}
