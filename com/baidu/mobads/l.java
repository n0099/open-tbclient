package com.baidu.mobads;
/* loaded from: classes2.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8362a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f8363b;

    public l(k kVar, String str) {
        this.f8363b = kVar;
        this.f8362a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8363b.f8361d.onUrl(this.f8362a);
    }
}
