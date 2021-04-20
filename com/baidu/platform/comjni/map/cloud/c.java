package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9961a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f9962b;

    public c(b bVar, String str) {
        this.f9962b = bVar;
        this.f9961a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9962b.f9960a.f(this.f9961a);
    }
}
