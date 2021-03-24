package com.baidu.platform.comapi.walknavi.d.a.f;

import android.os.AsyncTask;
import android.text.TextUtils;
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
/* loaded from: classes2.dex */
public class d extends AsyncTask<String, Void, String> implements c {

    /* renamed from: a  reason: collision with root package name */
    public f.a<JSONObject> f10000a;

    /* renamed from: b  reason: collision with root package name */
    public String f10001b;

    public d(String str, f.a<JSONObject> aVar) {
        this.f10000a = aVar;
        this.f10001b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f10001b).openConnection();
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
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
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (TextUtils.isEmpty(str)) {
            f.a<JSONObject> aVar = this.f10000a;
            if (aVar != null) {
                aVar.b("http error! result is null");
                return;
            }
            return;
        }
        try {
            if (this.f10000a != null) {
                this.f10000a.a(new JSONObject(str));
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.d.a.f.c
    public void a() {
        cancel(true);
        this.f10000a = null;
    }
}
