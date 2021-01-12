package com.baidu.mobads.production.g;

import com.baidu.mobads.interfaces.event.IXAdEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3448a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3448a.dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_STOPPED));
    }
}
