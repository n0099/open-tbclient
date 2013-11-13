package com.baidu.android.systemmonitor.d.a;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.baidu.android.common.net.ProxyHttpClient;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f795a;
    private String b;

    public g(d dVar, String str) {
        this.f795a = dVar;
        this.b = null;
        this.b = str;
        setName("SystemMonitor_ ServerCommandGrabberThread");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        UrlEncodedFormEntity b;
        ProxyHttpClient proxyHttpClient;
        Context context;
        ProxyHttpClient proxyHttpClient2;
        InputStream a2;
        Process.setThreadPriority(10);
        HttpUriRequest httpPost = new HttpPost(this.b);
        httpPost.setHeader("Accept-Encoding", "gzip");
        b = this.f795a.b();
        httpPost.setEntity(b);
        try {
            try {
                proxyHttpClient2 = this.f795a.f792a;
                HttpEntity entity = proxyHttpClient2.execute(httpPost).getEntity();
                a2 = this.f795a.a(entity);
                if (a2 == null) {
                    a2 = entity.getContent();
                }
                try {
                    this.f795a.a(a2);
                    this.f795a.c();
                } catch (IOException e) {
                } catch (XmlPullParserException e2) {
                }
            } catch (IOException e3) {
            }
        } catch (ClientProtocolException e4) {
        } catch (Exception e5) {
        } finally {
            proxyHttpClient = this.f795a.f792a;
            proxyHttpClient.close();
            k.f();
            m.b();
            c.c();
            context = this.f795a.c;
            context.sendBroadcast(new Intent("com.baidu.moplus.systemmonitor.pathrefresh"));
        }
    }
}
