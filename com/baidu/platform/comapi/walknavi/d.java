package com.baidu.platform.comapi.walknavi;
/* loaded from: classes2.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9922a;

    public d(b bVar) {
        this.f9922a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9922a.F().runEntryState();
    }
}
