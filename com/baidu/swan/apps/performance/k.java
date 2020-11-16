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
    private static k dhz;
    private String[] dhB;
    private Map<String, JSONArray> dhA = new ArrayMap();
    private String mPort = "";
    private Map<String, String> dhC = new HashMap();

    private k() {
    }

    public static k aDb() {
        if (dhz == null) {
            synchronized (k.class) {
                if (dhz == null) {
                    dhz = new k();
                }
            }
        }
        return dhz;
    }

    public boolean isAvailable() {
        return (this.dhB == null || this.dhB.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
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
            this.dhB = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.dhC.put("projectId", string3);
        }
    }

    public void bp(JSONObject jSONObject) {
        if (this.dhA != null && jSONObject != null) {
            String azl = com.baidu.swan.apps.v.f.azg().azl();
            JSONArray jSONArray = this.dhA.get(azl);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.dhA.put(azl, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.runtime.d.aGI().aGG(), a.h.aiapps_debug_report_invalid_params).showToast();
        } else if (this.dhA == null || this.dhA.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.aGI().aGG()).ib(a.h.aiapps_debug_report_performance).ia(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aGt();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.dhA.entrySet()) {
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
            com.baidu.swan.a.a.f postRequest = com.baidu.swan.a.c.a.bad().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.dhB.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(jC(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String jC(int i) {
        if (!isAvailable() || i >= this.dhB.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.dhB[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.dhC.entrySet()) {
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes7.dex */
    private class b extends ResponseCallback {
        private AtomicInteger dhD = new AtomicInteger(0);
        private boolean dhE;
        private a dhF;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.dhF = aVar;
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
            this.dhE = true;
            k.this.dhA = new ArrayMap();
            if (this.dhF == null) {
                return;
            }
            this.dhF.jD(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.dhE || this.dhD.incrementAndGet() < this.mCount || this.dhF == null) {
                return;
            }
            this.dhF.jD(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class a {
        public abstract void mN(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void jD(int i) {
            Application avS = com.baidu.swan.apps.t.a.avS();
            if (avS != null) {
                mN(avS.getString(i));
            }
        }
    }
}
