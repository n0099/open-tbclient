package com.baidu.android.pushservice.b;

import android.content.Context;
import android.util.Log;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.util.PushDatabase;
import com.baidu.browser.core.util.BdUtil;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f703a;
    private final CharSequence b;
    private String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(o oVar, CharSequence charSequence, String str) {
        super("Push_UpdateWorker");
        this.f703a = oVar;
        this.c = null;
        this.b = charSequence;
        this.c = str;
    }

    private InputStream a(HttpResponse httpResponse) {
        Context context;
        InputStream a2;
        PushSettings.a(System.currentTimeMillis());
        context = this.f703a.b;
        PushDatabase.clearBehaviorInfo(PushDatabase.getDb(context));
        HttpEntity entity = httpResponse.getEntity();
        a2 = this.f703a.a(entity);
        return a2 == null ? entity.getContent() : a2;
    }

    private UrlEncodedFormEntity a() {
        UrlEncodedFormEntity urlEncodedFormEntity;
        UnsupportedEncodingException e;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("stats", this.c));
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, BdUtil.UTF8);
            try {
                urlEncodedFormEntity.setContentType("application/json");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
                return urlEncodedFormEntity;
            }
        } catch (UnsupportedEncodingException e3) {
            urlEncodedFormEntity = null;
            e = e3;
        }
        return urlEncodedFormEntity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String obj = this.b.toString();
        context = this.f703a.b;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(context);
        HttpPost httpPost = new HttpPost(obj);
        try {
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setEntity(a());
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            InputStream a2 = a(execute);
            if (execute.getStatusLine().getStatusCode() == 200) {
                this.f703a.a(a2);
            } else if (execute.getStatusLine().getStatusCode() == 201) {
                this.f703a.b(a2);
            } else if (execute.getStatusLine().getStatusCode() == 403) {
                this.f703a.c(a2);
            }
        } catch (ClientProtocolException e) {
        } catch (IOException e2) {
        } catch (Exception e3) {
            context2 = this.f703a.b;
            if (com.baidu.android.pushservice.b.a(context2)) {
                Log.w("StatisticPoster", e3);
            }
        } finally {
            proxyHttpClient.close();
        }
    }
}
