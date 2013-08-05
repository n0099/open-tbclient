package com.baidu.android.systemmonitor.a.a;

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
public class k extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f649a;
    private String b;

    public k(e eVar, String str) {
        this.f649a = eVar;
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
        b = this.f649a.b();
        httpPost.setEntity(b);
        try {
            try {
                proxyHttpClient2 = this.f649a.f644a;
                HttpEntity entity = proxyHttpClient2.execute(httpPost).getEntity();
                a2 = this.f649a.a(entity);
                if (a2 == null) {
                    a2 = entity.getContent();
                }
                try {
                    this.f649a.a(a2);
                    this.f649a.c();
                } catch (IOException e) {
                } catch (XmlPullParserException e2) {
                }
            } catch (IOException e3) {
            }
        } catch (ClientProtocolException e4) {
        } catch (Exception e5) {
        } finally {
            proxyHttpClient = this.f649a.f644a;
            proxyHttpClient.close();
            o.f();
            m.b();
            i.c();
            context = this.f649a.c;
            context.sendBroadcast(new Intent("com.baidu.moplus.systemmonitor.pathrefresh"));
        }
    }
}
