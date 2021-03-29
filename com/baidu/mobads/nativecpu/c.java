package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8392a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f8393b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NativeCPUManager.a f8394c;

    public c(NativeCPUManager.a aVar, String str, int i) {
        this.f8394c = aVar;
        this.f8392a = str;
        this.f8393b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.f8375b.onAdError(this.f8392a, this.f8393b);
    }
}
