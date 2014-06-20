package com.baidu.android.systemmonitor.a;

import android.content.Context;
import android.os.Process;
import com.baidu.android.a.g;
import com.baidu.android.a.t;
import com.baidu.android.nebula.cmd.k;
import com.baidu.android.systemmonitor.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.EntityUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends Thread {
    ArrayList a;
    final /* synthetic */ a b;
    private long c;

    public b(a aVar, ArrayList arrayList, long j) {
        this.b = aVar;
        this.a = new ArrayList();
        this.c = 0L;
        this.a = arrayList;
        this.c = j;
        setName("SystemMonitor_SendStaticDataWorker");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        byte[] a;
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
        com.baidu.android.nebula.a.d a2 = com.baidu.android.nebula.a.d.a(context);
        context2 = this.b.b;
        String a3 = a2.a(t.a(context2).a(), false);
        context3 = this.b.b;
        com.baidu.android.nebula.a.a aVar = new com.baidu.android.nebula.a.a(context3);
        HttpPost httpPost = new HttpPost(a3);
        try {
            a = this.b.a(this.a, this.c);
            if (a == null) {
                return;
            }
            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(a);
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
            httpPost.setEntity(byteArrayEntity);
            HttpResponse execute = aVar.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() != 200) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    switch ((g) it.next()) {
                        case FREQ_STATISTIC:
                            context4 = this.b.b;
                            com.baidu.android.systemmonitor.freqstatistic.c.a(context4).a(false);
                            break;
                    }
                }
            } else if (!EntityUtils.toString(execute.getEntity()).equals("ok")) {
                Iterator it2 = this.a.iterator();
                while (it2.hasNext()) {
                    switch ((g) it2.next()) {
                        case FREQ_STATISTIC:
                            context5 = this.b.b;
                            com.baidu.android.systemmonitor.freqstatistic.c.a(context5).a(false);
                            break;
                    }
                }
            } else {
                Iterator it3 = this.a.iterator();
                while (it3.hasNext()) {
                    switch ((g) it3.next()) {
                        case FREQ_STATISTIC:
                            context14 = this.b.b;
                            com.baidu.android.systemmonitor.freqstatistic.c.a(context14).a(true);
                            break;
                        case APPCHANGE_STATISTIC:
                            context13 = this.b.b;
                            com.baidu.android.systemmonitor.freqstatistic.c.a(context13).g();
                            break;
                        case ACTIVE_EVENT:
                            context11 = this.b.b;
                            e.b(context11, true);
                            context12 = this.b.b;
                            e.a(context12, "");
                            break;
                        case POWER_EVENT:
                            context10 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.g.a(context10).b(1, this.c);
                            break;
                        case CHARGE_EVENT:
                            context9 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.g.a(context9).b(2, this.c);
                            break;
                        case STORE_INFORMATION:
                            context7 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.g.a(context7).b(4, this.c);
                            break;
                        case NETWORK_EVENT:
                            context8 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.g.a(context8).b(3, this.c);
                            break;
                        case APKDOWNLOAD_EVENT:
                            context6 = this.b.b;
                            com.baidu.android.systemmonitor.devicestatistic.g.a(context6).b(5, this.c);
                            break;
                        case PV_EVENT:
                            k.a().c();
                            k.d();
                            break;
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            aVar.a();
        }
    }
}
