package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10329a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f10330b;

    public c(b bVar, String str) {
        this.f10330b = bVar;
        this.f10329a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10330b.f10328a.f(this.f10329a);
    }
}
