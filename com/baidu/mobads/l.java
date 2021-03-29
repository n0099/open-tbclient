package com.baidu.mobads;
/* loaded from: classes2.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8363a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f8364b;

    public l(k kVar, String str) {
        this.f8364b = kVar;
        this.f8363a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8364b.f8362d.onUrl(this.f8363a);
    }
}
