package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10402a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f10403b;

    public c(b bVar, String str) {
        this.f10403b = bVar;
        this.f10402a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10403b.f10401a.f(this.f10402a);
    }
}
