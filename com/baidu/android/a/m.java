package com.baidu.android.a;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.baidu.android.common.net.ProxyHttpClient;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends Thread {
    final /* synthetic */ e a;
    private String b;

    public m(e eVar, String str) {
        this.a = eVar;
        this.b = null;
        this.b = str;
        setName("SystemMonitor_ ServerCommandGrabberThread");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        UrlEncodedFormEntity b;
        ProxyHttpClient proxyHttpClient;
        Context context;
        Context context2;
        ProxyHttpClient proxyHttpClient2;
        InputStream a;
        Process.setThreadPriority(10);
        HttpUriRequest httpPost = new HttpPost(this.b);
        httpPost.setHeader("Accept-Encoding", "gzip");
        b = this.a.b();
        httpPost.setEntity(b);
        try {
            try {
                proxyHttpClient2 = this.a.a;
                HttpResponse execute = proxyHttpClient2.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = execute.getEntity();
                    a = this.a.a(entity);
                    if (a == null) {
                        a = entity.getContent();
                    }
                    try {
                        this.a.a(a);
                        this.a.c();
                    } catch (IOException e) {
                    } catch (XmlPullParserException e2) {
                    }
                }
            } catch (IOException e3) {
            }
        } catch (ClientProtocolException e4) {
        } catch (Exception e5) {
        } finally {
            proxyHttpClient = this.a.a;
            proxyHttpClient.close();
            j.k();
            l.b();
            i.c();
            context = this.a.c;
            context.sendBroadcast(new Intent("com.baidu.moplus.systemmonitor.pathrefresh"));
            context2 = this.a.c;
            j.a(context2);
        }
    }
}
