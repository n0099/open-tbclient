package com.baidu.android.systemmonitor.a;

import android.content.Context;
import com.baidu.android.a.j;
import com.baidu.android.a.n;
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
        if (j.a(context).b()) {
            arrayList.add(n.CHARGE_EVENT);
            arrayList.add(n.POWER_EVENT);
            arrayList.add(n.STORE_INFORMATION);
        }
        context2 = this.a.b;
        if (j.a(context2).c()) {
            arrayList.add(n.NETWORK_EVENT);
        }
        context3 = this.a.b;
        if (j.a(context3).d()) {
            arrayList.add(n.APKDOWNLOAD_EVENT);
        }
        if (arrayList.size() > 0) {
            this.a.a(arrayList);
        }
    }
}
