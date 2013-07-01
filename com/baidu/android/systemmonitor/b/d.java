package com.baidu.android.systemmonitor.b;

import com.baidu.android.systemmonitor.a.a.h;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f391a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f391a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(h.CHARGE_EVENT);
        arrayList.add(h.NETWORK_EVENT);
        arrayList.add(h.POWER_EVENT);
        arrayList.add(h.STORE_INFORMATION);
        arrayList.add(h.APKDOWNLOAD_EVENT);
        this.f391a.a(arrayList);
    }
}
