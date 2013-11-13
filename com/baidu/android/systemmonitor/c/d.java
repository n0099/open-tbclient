package com.baidu.android.systemmonitor.c;

import android.content.Context;
import android.os.Process;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.nebula.util.e;
import com.baidu.android.systemmonitor.d.a.l;
import com.baidu.android.systemmonitor.d.a.m;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Thread {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f787a;
    final /* synthetic */ a b;
    private long c;

    public d(a aVar, ArrayList arrayList, long j) {
        this.b = aVar;
        this.f787a = new ArrayList();
        this.c = 0L;
        this.f787a = arrayList;
        this.c = j;
        setName("SystemMonitor_SendStaticDataWorker");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        byte[] a2;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        Context context8;
        Context context9;
        Context context10;
        Context context11;
        Context context12;
        Context context13;
        Context context14;
        Process.setThreadPriority(10);
        context = this.b.b;
        e a3 = e.a(context);
        context2 = this.b.b;
        String a4 = a3.a(m.a(context2).a(), false);
        context3 = this.b.b;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(context3);
        HttpPost httpPost = new HttpPost(a4);
        try {
            a2 = this.b.a(this.f787a, this.c);
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(a2);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setEntity(byteArrayEntity);
            HttpResponse execute = proxyHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() != 200) {
                Iterator it = this.f787a.iterator();
                while (it.hasNext()) {
                    switch ((l) it.next()) {
                        case FREQ_STATISTIC:
                            context4 = this.b.b;
                            com.baidu.android.systemmonitor.b.d.a(context4).a(false);
                            break;
                    }
                }
            } else if (!EntityUtils.toString(execute.getEntity()).equals("ok")) {
                Iterator it2 = this.f787a.iterator();
                while (it2.hasNext()) {
                    switch ((l) it2.next()) {
                        case FREQ_STATISTIC:
                            context5 = this.b.b;
                            com.baidu.android.systemmonitor.b.d.a(context5).a(false);
                            break;
                    }
                }
            } else {
                Iterator it3 = this.f787a.iterator();
                while (it3.hasNext()) {
                    switch ((l) it3.next()) {
                        case FREQ_STATISTIC:
                            context14 = this.b.b;
                            com.baidu.android.systemmonitor.b.d.a(context14).a(true);
                            break;
                        case APPCHANGE_STATISTIC:
                            context13 = this.b.b;
                            com.baidu.android.systemmonitor.b.d.a(context13).g();
                            break;
                        case ACTIVE_EVENT:
                            context11 = this.b.b;
                            com.baidu.android.systemmonitor.d.b.b(context11, true);
                            context12 = this.b.b;
                            com.baidu.android.systemmonitor.d.b.a(context12, "");
                            break;
                        case POWER_EVENT:
                            context10 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.d.a(context10).b(1, this.c);
                            break;
                        case CHARGE_EVENT:
                            context9 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.d.a(context9).b(2, this.c);
                            break;
                        case STORE_INFORMATION:
                            context7 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.d.a(context7).b(4, this.c);
                            break;
                        case NETWORK_EVENT:
                            context8 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.d.a(context8).b(3, this.c);
                            break;
                        case APKDOWNLOAD_EVENT:
                            context6 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.d.a(context6).b(5, this.c);
                            break;
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            proxyHttpClient.close();
        }
    }
}
