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
/* loaded from: classes8.dex */
public class k {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static k cGK;
    private String[] cGM;
    private Map<String, JSONArray> cGL = new ArrayMap();
    private String mPort = "";
    private Map<String, String> cGN = new HashMap();

    private k() {
    }

    public static k avV() {
        if (cGK == null) {
            synchronized (k.class) {
                if (cGK == null) {
                    cGK = new k();
                }
            }
        }
        return cGK;
    }

    public boolean isAvailable() {
        return (this.cGM == null || this.cGM.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
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
            this.cGM = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.cGN.put("projectId", string3);
        }
    }

    public void bc(JSONObject jSONObject) {
        if (this.cGL != null && jSONObject != null) {
            String asd = com.baidu.swan.apps.v.f.arY().asd();
            JSONArray jSONArray = this.cGL.get(asd);
            if (jSONArray == null) {
                jSONArray = new JSONArray();
                this.cGL.put(asd, jSONArray);
            }
            jSONArray.put(jSONObject);
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.runtime.d.azE().azC(), a.h.aiapps_debug_report_invalid_params).showToast();
        } else if (this.cGL == null || this.cGL.size() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.azE().azC()).he(a.h.aiapps_debug_report_performance).hd(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).azp();
        } else {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.cGL.entrySet()) {
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
            com.baidu.swan.a.a.f postRequest = com.baidu.swan.a.c.a.aSW().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.cGM.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(iE(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String iE(int i) {
        if (!isAvailable() || i >= this.cGM.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.cGM[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.cGN.entrySet()) {
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes8.dex */
    private class b extends ResponseCallback {
        private AtomicInteger cGO = new AtomicInteger(0);
        private boolean cGP;
        private a cGQ;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.cGQ = aVar;
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
            this.cGP = true;
            k.this.cGL = new ArrayMap();
            if (this.cGQ == null) {
                return;
            }
            this.cGQ.iF(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.cGP || this.cGO.incrementAndGet() < this.mCount || this.cGQ == null) {
                return;
            }
            this.cGQ.iF(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class a {
        public abstract void lg(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void iF(int i) {
            Application aoJ = com.baidu.swan.apps.t.a.aoJ();
            if (aoJ != null) {
                lg(aoJ.getString(i));
            }
        }
    }
}
