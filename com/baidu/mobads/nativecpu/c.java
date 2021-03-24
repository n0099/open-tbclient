package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8391a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f8392b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeCPUManager.a f8393c;

    public c(NativeCPUManager.a aVar, String str, int i) {
        this.f8393c = aVar;
        this.f8391a = str;
        this.f8392b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.f8374b.onAdError(this.f8391a, this.f8392b);
    }
}
