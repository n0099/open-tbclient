package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9836a;

    public d(b bVar) {
        this.f9836a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9836a.F().runEntryState();
    }
}
