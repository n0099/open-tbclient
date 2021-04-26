package com.baidu.platform.comapi.walknavi.g;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f10060a;

    public o(a aVar) {
        this.f10060a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10060a.s();
        com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_AR_ADJUST_HAS_SHOW", true);
    }
}
