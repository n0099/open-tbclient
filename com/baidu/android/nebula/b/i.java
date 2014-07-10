package com.baidu.android.nebula.b;

import android.content.Context;
import android.os.Process;
import com.baidu.android.common.net.ProxyHttpClient;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ a a;
    private final CharSequence b;
    private String c;

    public i(a aVar, CharSequence charSequence, String str) {
        this.a = aVar;
        this.c = null;
        this.b = charSequence;
        this.c = str;
    }

    private UrlEncodedFormEntity a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("needsdata", this.c));
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "utf-8");
            try {
                urlEncodedFormEntity.setContentType("application/x-www-form-urlencoded");
                return urlEncodedFormEntity;
            } catch (UnsupportedEncodingException e) {
                return urlEncodedFormEntity;
            }
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        InputStream a;
        Process.setThreadPriority(10);
        context = this.a.a;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(context);
        HttpPost httpPost = new HttpPost(this.b.toString());
        try {
            try {
                httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
                httpPost.addHeader("Accept-Encoding", "gzip");
                httpPost.setEntity(a());
                HttpResponse execute = proxyHttpClient.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = execute.getEntity();
                    a = this.a.a(entity);
                    if (a == null) {
                        a = entity.getContent();
                    }
                    try {
                        this.a.a(a);
                        this.a.b();
                    } catch (IOException e) {
                    } catch (JSONException e2) {
                    }
                }
            } catch (IOException e3) {
            }
        } catch (ClientProtocolException e4) {
        } finally {
            proxyHttpClient.close();
        }
    }
}
