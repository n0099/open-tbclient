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
public final class k implements Runnable {
    private static final int f = 15000;
    private static final String g = "appid";
    private static final String h = "bduss";
    private static final String i = "tpl";
    private static final String j = "sName";
    private static final String k = "utf-8";
    private String a;
    private String b;
    private String c;
    private HttpClient d;
    private HttpParams e;
    private /* synthetic */ j l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str, String str2, String str3) {
        this.l = jVar;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.e = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(this.e, f);
        HttpConnectionParams.setSoTimeout(this.e, f);
        this.d = new DefaultHttpClient(this.e);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(g, this.l.b));
        arrayList.add(new BasicNameValuePair("bduss", this.b));
        arrayList.add(new BasicNameValuePair(i, this.l.a));
        arrayList.add(new BasicNameValuePair(j, this.c));
        try {
            HttpPost httpPost = new HttpPost(this.a);
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, k));
            this.d.execute(httpPost);
        } catch (Exception e) {
            Log.d("loginshare", "exception = " + e.toString());
        }
    }
}
