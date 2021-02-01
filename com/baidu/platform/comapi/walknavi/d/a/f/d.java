package com.baidu.platform.comapi.walknavi.d.a.f;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.platform.comapi.walknavi.d.a.f.f;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends AsyncTask<String, Void, String> implements c {

    /* renamed from: a  reason: collision with root package name */
    f.a<JSONObject> f4240a;

    /* renamed from: b  reason: collision with root package name */
    private String f4241b;

    public d(String str, f.a<JSONObject> aVar) {
        this.f4240a = aVar;
        this.f4241b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f4241b).openConnection();
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Content-Type", HttpHelper.CONTENT_JSON);
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            com.baidu.platform.comapi.walknavi.d.a.g.a.a("post params = " + strArr[0]);
            dataOutputStream.write(strArr[0].getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return readLine;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.f4240a != null) {
                this.f4240a.b("http error! result is null");
                return;
            }
            return;
        }
        try {
            if (this.f4240a != null) {
                this.f4240a.a(new JSONObject(str));
            }
        } catch (JSONException e) {
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.f.c
    public void a() {
        cancel(true);
        this.f4240a = null;
    }
}
