package com.baidu.swan.apps.performance;

import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
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
/* loaded from: classes11.dex */
public class i {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static i cwz;
    private String[] cwB;
    private JSONArray cwA = new JSONArray();
    private String mPort = "";
    private Map<String, String> cwC = new HashMap();

    private i() {
    }

    public static i amG() {
        if (cwz == null) {
            synchronized (i.class) {
                if (cwz == null) {
                    cwz = new i();
                }
            }
        }
        return cwz;
    }

    public boolean isAvailable() {
        return (this.cwB == null || this.cwB.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
    }

    public void K(Bundle bundle) {
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
            this.cwB = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.cwC.put("projectId", string3);
        }
    }

    public void aT(JSONObject jSONObject) {
        if (this.cwA != null && jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("path", com.baidu.swan.apps.w.f.ajb().ajg());
                jSONObject2.putOpt("data", jSONObject.toString());
                this.cwA.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.runtime.d.apI().apG(), a.h.aiapps_debug_report_invalid_params).showToast();
        } else if (this.cwA == null || this.cwA.length() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.apI().apG()).fe(a.h.aiapps_debug_report_performance).fd(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).apu();
        } else {
            com.baidu.swan.c.a.f postRequest = com.baidu.swan.c.c.a.aGD().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), this.cwA.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.cwB.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(gp(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String gp(int i) {
        if (!isAvailable() || i >= this.cwB.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.cwB[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.cwC.entrySet()) {
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes11.dex */
    private class b extends ResponseCallback {
        private AtomicInteger cwD = new AtomicInteger(0);
        private boolean cwE;
        private a cwF;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.cwF = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            if (response == null || response.body() == null || !response.isSuccessful()) {
                return null;
            }
            try {
                return response.body().string();
            } catch (IOException e) {
                if (i.DEBUG) {
                    Log.d("TraceDataManager", "Trace Data publish fail for IOException", e);
                    return null;
                }
                return null;
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            this.cwE = true;
            i.this.cwA = new JSONArray();
            if (this.cwF == null) {
                return;
            }
            this.cwF.gq(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.cwE || this.cwD.incrementAndGet() < this.mCount || this.cwF == null) {
                return;
            }
            this.cwF.gq(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class a {
        public abstract void jp(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void gq(int i) {
            Application afX = com.baidu.swan.apps.u.a.afX();
            if (afX != null) {
                jp(afX.getString(i));
            }
        }
    }
}
