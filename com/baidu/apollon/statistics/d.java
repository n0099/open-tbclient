package com.baidu.apollon.statistics;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3856a = 10001;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3857b = 10002;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3858c = 10003;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f3859e;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3860d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static d f3862a = new d();
    }

    public static d a() {
        return a.f3862a;
    }

    public boolean b() {
        if (this.f3860d) {
            return false;
        }
        this.f3860d = true;
        f3859e.sendEmptyMessage(10003);
        LogSender.getInstance().a();
        return true;
    }

    public d() {
        this.f3860d = false;
        f3859e = new Handler(b.a().b().getLooper()) { // from class: com.baidu.apollon.statistics.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (10001 == i) {
                    e eVar = (e) message.obj;
                    BasicStoreTools.getInstance().setLastEvtId(PayStatisticsUtil.c(), eVar.m);
                    c.a().a(eVar);
                } else if (10002 != i) {
                    if (10003 == i) {
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
        f3859e.obtainMessage(10001, e.a(str, j, str2, f.a(), com.baidu.apollon.statistics.a.a(), collection, str3)).sendToTarget();
    }

    public void a(String str, int i) {
        f3859e.obtainMessage(10002, i, -1, str).sendToTarget();
    }
}
