package com.baidu.ar.statistic;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class l extends AsyncTask<String, Void, List<String>> {
    private a vy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void onPerformanceRequestFinished(List<String> list);
    }

    public l(a aVar) {
        this.vy = aVar;
    }

    private List<String> aE(String str) {
        int length;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
            JSONObject jSONObject = optJSONObject != null ? optJSONObject.getJSONObject("statistic_swtich") : null;
            if (jSONObject != null && (length = jSONObject.length()) > 0) {
                ArrayList arrayList = new ArrayList(length);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if ("1".equals(jSONObject.opt(next))) {
                        arrayList.add(next);
                    }
                }
                return arrayList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String aF(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private String fc() {
        return String.format("%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", HttpConstants.HTTP_OS_TYPE, "android", HttpConstants.HTTP_ENGINE_VERSION, String.valueOf(com.baidu.ar.f.c.getVersionCode()), "manufacture", aF(Build.MANUFACTURER), HttpConstants.HTTP_BOARD, aF(Build.BOARD), HttpConstants.HTTP_HARDWARE, aF(Build.HARDWARE));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public List<String> doInBackground(String... strArr) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return null;
        }
        String fD = com.baidu.ar.f.q.fD();
        newRequest.setUrl(fD).setMethod("POST").setBody(fc()).addHeader("Content-Type: application/x-www-form-urlencoded");
        try {
            IHttpResponse execute = newRequest.execute();
            if (execute.isSuccess()) {
                return aE(execute.getContent());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: j */
    public void onPostExecute(List<String> list) {
        super.onPostExecute(list);
        if (this.vy != null) {
            this.vy.onPerformanceRequestFinished(list);
        }
        this.vy = null;
    }
}
