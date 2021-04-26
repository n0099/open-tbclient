package com.baidu.apollon.statistics;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3943a = 10001;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3944b = 10002;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3945c = 10003;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f3946e;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3947d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static d f3949a = new d();
    }

    public static d a() {
        return a.f3949a;
    }

    public boolean b() {
        if (this.f3947d) {
            return false;
        }
        this.f3947d = true;
        f3946e.sendEmptyMessage(10003);
        LogSender.getInstance().a();
        return true;
    }

    public d() {
        this.f3947d = false;
        f3946e = new Handler(b.a().b().getLooper()) { // from class: com.baidu.apollon.statistics.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (10001 == i2) {
                    e eVar = (e) message.obj;
                    BasicStoreTools.getInstance().setLastEvtId(PayStatisticsUtil.c(), eVar.m);
                    c.a().a(eVar);
                } else if (10002 != i2) {
                    if (10003 == i2) {
                        c.a().b();
                    }
                } else {
                    String str = (String) message.obj;
                    c.a().a(message.arg1, str);
                    c.a().b(str);
                }
            }
        };
    }

    public void a(String str, String str2, String str3, String str4, long j) {
        ArrayList arrayList;
        if (str3 != null) {
            arrayList = new ArrayList(1);
            arrayList.add(str3);
        } else {
            arrayList = null;
        }
        a(str, str2, arrayList, str4, j);
    }

    public void a(String str, String str2, Collection<String> collection, String str3, long j) {
        if (g.a().b(str)) {
            return;
        }
        if (!b() && g.a().b()) {
            LogSender.getInstance().a();
        }
        f3946e.obtainMessage(10001, e.a(str, j, str2, f.a(), com.baidu.apollon.statistics.a.a(), collection, str3)).sendToTarget();
    }

    public void a(String str, int i2) {
        f3946e.obtainMessage(10002, i2, -1, str).sendToTarget();
    }
}
