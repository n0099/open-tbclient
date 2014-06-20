package com.baidu.android.systemmonitor.a;

import android.content.Context;
import com.baidu.android.a.g;
import com.baidu.android.a.s;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        Context context3;
        ArrayList arrayList = new ArrayList();
        context = this.a.b;
        if (s.a(context).b()) {
            arrayList.add(g.CHARGE_EVENT);
            arrayList.add(g.POWER_EVENT);
            arrayList.add(g.STORE_INFORMATION);
        }
        context2 = this.a.b;
        if (s.a(context2).c()) {
            arrayList.add(g.NETWORK_EVENT);
        }
        context3 = this.a.b;
        if (s.a(context3).d()) {
            arrayList.add(g.APKDOWNLOAD_EVENT);
        }
        if (arrayList.size() > 0) {
            this.a.a(arrayList);
        }
    }
}
