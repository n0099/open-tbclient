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
    private static i crL;
    private String[] crN;
    private JSONArray crM = new JSONArray();
    private String mPort = "";
    private Map<String, String> crO = new HashMap();

    private i() {
    }

    public static i alA() {
        if (crL == null) {
            synchronized (i.class) {
                if (crL == null) {
                    crL = new i();
                }
            }
        }
        return crL;
    }

    public boolean isAvailable() {
        return (this.crN == null || this.crN.length <= 0 || TextUtils.isEmpty(this.mPort)) ? false : true;
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
            this.crN = string.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.mPort = string2;
            this.crO.put("projectId", string3);
        }
    }

    public void aM(JSONObject jSONObject) {
        if (this.crM != null && jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("path", com.baidu.swan.apps.w.f.ahV().aia());
                jSONObject2.putOpt("data", jSONObject.toString());
                this.crM.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        if (!isAvailable()) {
            com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.runtime.d.aoB().aoz(), a.h.aiapps_debug_report_invalid_params).showToast();
        } else if (this.crM == null || this.crM.length() <= 0) {
            new g.a(com.baidu.swan.apps.runtime.d.aoB().aoz()).eT(a.h.aiapps_debug_report_performance).eS(a.h.aiapps_debug_report_no_data).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_ok, (DialogInterface.OnClickListener) null).aon();
        } else {
            com.baidu.swan.c.a.f postRequest = com.baidu.swan.c.c.a.aFx().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), this.crM.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.crN.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(gd(i));
                postRequest.build().executeAsync(bVar);
            }
        }
    }

    private String gd(int i) {
        if (!isAvailable() || i >= this.crN.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(this.crN[i]).append(":").append(this.mPort).append("/uploadTraceData").append("?");
        for (Map.Entry<String, String> entry : this.crO.entrySet()) {
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        return sb.toString();
    }

    /* loaded from: classes11.dex */
    private class b extends ResponseCallback {
        private AtomicInteger crP = new AtomicInteger(0);
        private boolean crQ;
        private a crR;
        private int mCount;

        b(int i, a aVar) {
            this.mCount = i;
            this.crR = aVar;
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
            this.crQ = true;
            i.this.crM = new JSONArray();
            if (this.crR == null) {
                return;
            }
            this.crR.ge(a.h.aiapps_debug_report_success);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (this.crQ || this.crP.incrementAndGet() < this.mCount || this.crR == null) {
                return;
            }
            this.crR.ge(a.h.aiapps_debug_report_fail);
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class a {
        public abstract void jh(String str);

        /* JADX INFO: Access modifiers changed from: private */
        public void ge(int i) {
            Application aeR = com.baidu.swan.apps.u.a.aeR();
            if (aeR != null) {
                jh(aeR.getString(i));
            }
        }
    }
}
