package com.baidu.ar.b;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.load.ARAsyncTask;
import com.baidu.ar.load.util.ResponseUtil;
import com.baidu.ar.task.HttpResponseListener;
import com.baidu.ar.util.ARLog;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class b extends ARAsyncTask<Object, Double, String> {
    private String a;
    private String b;
    private int c;
    private HttpResponseListener<String> d;
    private boolean e = false;
    private boolean f = false;

    public b(String str, String str2, int i, HttpResponseListener<String> httpResponseListener) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = httpResponseListener;
    }

    private String c() {
        if (TextUtils.isEmpty(this.a)) {
            ARLog.e("mUrl is null!");
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            httpURLConnection.setConnectTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            if (this.c == 0) {
                httpURLConnection.setRequestMethod("GET");
            } else if (this.c == 1) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                ARLog.d("post params = " + this.b);
                dataOutputStream.write(this.b.getBytes());
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            d();
            return readLine;
        } catch (IOException e) {
            e.printStackTrace();
            ARLog.e("IOException: " + e.getMessage());
            return null;
        }
    }

    private void d() {
        while (this.e) {
            ARLog.d("mIsPause = " + this.e);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    /* renamed from: a */
    public String doInBackground(Object[] objArr) {
        if (TextUtils.isEmpty(this.a)) {
            return null;
        }
        return c();
    }

    public void a() {
        this.f = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.d != null) {
                this.d.onResponse(ResponseUtil.getActionResponseInfo(1, "query result is null!", null));
                return;
            }
            return;
        }
        onProgressUpdate(Double.valueOf(100.0d));
        if (this.d != null) {
            this.d.onResponse(ResponseUtil.getActionResponseInfo(0, "query success!", str));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.load.ARAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Double... dArr) {
        super.onProgressUpdate(dArr);
    }

    public void b() {
        if (this.f) {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } else {
            execute(new Object[0]);
        }
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onCancelled() {
        if (this.d != null) {
            this.d.onResponse(ResponseUtil.getActionResponseInfo(3, "query cancel!", null));
        }
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onError(String str) {
        if (this.d != null) {
            this.d.onResponse(ResponseUtil.getActionResponseInfo(1, "query task execute error:" + str, null));
        }
    }

    @Override // com.baidu.ar.load.ARAsyncTask
    protected void onTimeout() {
        if (this.d != null) {
            this.d.onResponse(ResponseUtil.getActionResponseInfo(2, "query time out!", null));
        }
    }
}
