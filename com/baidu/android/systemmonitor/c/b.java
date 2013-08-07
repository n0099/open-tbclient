package com.baidu.android.systemmonitor.c;

import com.baidu.android.systemmonitor.d.a.l;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f657a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f657a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(l.CHARGE_EVENT);
        arrayList.add(l.NETWORK_EVENT);
        arrayList.add(l.POWER_EVENT);
        arrayList.add(l.STORE_INFORMATION);
        arrayList.add(l.APKDOWNLOAD_EVENT);
        this.f657a.a(arrayList);
    }
}
