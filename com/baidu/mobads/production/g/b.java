package com.baidu.mobads.production.g;

import com.baidu.mobads.interfaces.event.IXAdEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2410a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2410a.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STOPPED));
    }
}
