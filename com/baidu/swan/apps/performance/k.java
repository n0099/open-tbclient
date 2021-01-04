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
    private static k dtA;
    private String[] dtC;
    private Map<String, JSONArray> dtB = new ArrayMap();
    private String mPort = "";
    private Map<String, String> dtD = new HashMap();

    private k() {
    }

    public static k aHC() {
        if (dtA == null) {
            synchronized (k.class) {
                if (dtA == null) {
                    dtA = new k();
                }
            }
        }
        return dtA;
    }

    public boolean isAvailable() {
        return (this.dtC == null || this.dtC.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
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
            this.dtC = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.dtD.put("projectId", string3);
        }
    }

    public void bz(JSONObject jSONObject) {
        if (this.dtB != null && jSONObject != null) {
            String aDL = com.baidu.swan.apps.v.f.aDG().aDL();
            JSONArray jSONArray = this.dtB.get(aDL);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.dtB.put(aDL, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.u(com.baidu.swan.apps.runtime.d.aMg().aMe(), a.h.aiapps_debug_report_invalid_params).aLS();
        } else if (this.dtB == null || this.dtB.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.aMg().aMe()).iu(a.h.aiapps_debug_report_performance).it(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aLx();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.dtB.entrySet()) {
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
            com.baidu.swan.a.a.f postRequest = com.baidu.swan.a.c.a.bfE().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.dtC.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(jV(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String jV(int i) {
        if (!isAvailable() || i >= this.dtC.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.dtC[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.dtD.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes9.dex */
    private class b extends ResponseCallback {
        private AtomicInteger dtE = new AtomicInteger(0);
        private boolean dtF;
        private a dtG;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.dtG = aVar;
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
            this.dtF = true;
            k.this.dtB = new ArrayMap();
            if (this.dtG == null) {
                return;
            }
            this.dtG.jW(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.dtF || this.dtE.incrementAndGet() < this.mCount || this.dtG == null) {
                return;
            }
            this.dtG.jW(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class a {
        public abstract void nn(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void jW(int i) {
            Application aAr = com.baidu.swan.apps.t.a.aAr();
            if (aAr != null) {
                nn(aAr.getString(i));
            }
        }
    }
}
