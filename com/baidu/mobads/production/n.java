package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdContainer f8498a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f8499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f8500c;

    public n(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f8500c = lVar;
        this.f8498a = iXAdContainer;
        this.f8499b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.f8500c.f8486b;
        aVar.c(this.f8498a, this.f8499b);
    }
}
