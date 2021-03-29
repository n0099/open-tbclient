package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10403a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f10404b;

    public c(b bVar, String str) {
        this.f10404b = bVar;
        this.f10403a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10404b.f10402a.f(this.f10403a);
    }
}
