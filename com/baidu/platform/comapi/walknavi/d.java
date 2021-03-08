package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2909a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f2909a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2909a.F().runEntryState();
    }
}
