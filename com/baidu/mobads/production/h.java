package com.baidu.mobads.production;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8473a;

    public h(a aVar) {
        this.f8473a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f8473a;
        aVar.f8441h.resize(aVar.getProdBase().getWidth(), this.f8473a.getProdBase().getHeight());
    }
}
