package com.baidu.mobads.production;
/* loaded from: classes2.dex */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8472a;

    public h(a aVar) {
        this.f8472a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.f8472a;
        aVar.f8440h.resize(aVar.getProdBase().getWidth(), this.f8472a.getProdBase().getHeight());
    }
}
