package com.baidu.loginshare;

import android.util.Log;
import java.util.ArrayList;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    private static final int g = 15000;
    private static final String h = "appid";
    private static final String i = "bduss";
    private static final String j = "tpl";
    private static final String k = "sName";
    private static final String l = "utf-8";
    final /* synthetic */ c a;
    private String b;
    private String c;
    private String d;
    private HttpClient e;
    private HttpParams f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str, String str2, String str3) {
        this.a = cVar;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(this.f, g);
        HttpConnectionParams.setSoTimeout(this.f, g);
        this.e = new DefaultHttpClient(this.f);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        str = this.a.d;
        arrayList.add(new BasicNameValuePair(h, str));
        arrayList.add(new BasicNameValuePair(i, this.c));
        str2 = this.a.c;
        arrayList.add(new BasicNameValuePair(j, str2));
        arrayList.add(new BasicNameValuePair(k, this.d));
        try {
            HttpPost httpPost = new HttpPost(this.b);
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "utf-8"));
            this.e.execute(httpPost);
        } catch (Exception e) {
            Log.d("loginshare", "exception = " + e.toString());
        }
    }
}
