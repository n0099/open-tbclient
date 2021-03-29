package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
import java.util.List;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f8390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NativeCPUManager.a f8391b;

    public b(NativeCPUManager.a aVar, List list) {
        this.f8391b = aVar;
        this.f8390a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.f8375b.onAdLoaded(this.f8390a);
    }
}
