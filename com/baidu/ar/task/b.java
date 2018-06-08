package com.baidu.ar.task;

import android.content.Context;
import android.os.AsyncTask;
import com.baidu.ar.bean.ARConfig;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.UrlUtils;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends AsyncTask<String, Void, String> implements HttpHandle {
    private Context a;
    private String b;
    private HttpResponseListener<JSONObject> c;

    public b(Context context, String str, HttpResponseListener<JSONObject> httpResponseListener) {
        this.a = context.getApplicationContext();
        this.c = httpResponseListener;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            if (!UrlUtils.getStatisticUrl().equals(this.b) && ARConfig.isAipAuth()) {
                this.b += "?access_token=" + ARConfig.getToken();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
            httpURLConnection.setConnectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            ARLog.d("post params = " + strArr[0]);
            dataOutputStream.write(strArr[0].getBytes(StandardCharsets.UTF_8));
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return readLine;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (str == null) {
            ARLog.e("result = null");
            if (this.c != null) {
                this.c.onErrorResponse("http error! result is null");
                return;
            }
            return;
        }
        try {
            if (this.c != null) {
                this.c.onResponse(new JSONObject(str));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.ar.task.HttpHandle
    public void finish() {
        cancel(true);
        this.c = null;
    }
}
