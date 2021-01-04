package com.baidu.ar.statistic;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.h.s;
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
/* loaded from: classes6.dex */
class l extends AsyncTask<String, Void, List<String>> {
    private a wP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void onPerformanceRequestFinished(List<String> list);
    }

    public l(a aVar) {
        this.wP = aVar;
    }

    private List<String> aL(String str) {
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

    private String aM(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    private String gq() {
        return String.format("%s=%s&%s=%s&%s=%s&%s=%s&%s=%s", HttpConstants.HTTP_OS_TYPE, HttpConstants.OS_TYPE_VALUE, HttpConstants.HTTP_ENGINE_VERSION, String.valueOf(com.baidu.ar.h.c.getVersionCode()), "manufacture", aM(Build.MANUFACTURER), HttpConstants.HTTP_BOARD, aM(Build.BOARD), HttpConstants.HTTP_HARDWARE, aM(Build.HARDWARE));
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
        String gS = s.gS();
        newRequest.setUrl(gS).setMethod("POST").setBody(gq()).addHeader("Content-Type: application/x-www-form-urlencoded");
        try {
            IHttpResponse execute = newRequest.execute();
            if (execute.isSuccess()) {
                return aL(execute.getContent());
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
    /* renamed from: k */
    public void onPostExecute(List<String> list) {
        super.onPostExecute(list);
        if (this.wP != null) {
            this.wP.onPerformanceRequestFinished(list);
        }
        this.wP = null;
    }
}
