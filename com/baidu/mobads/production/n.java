package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdContainer f8499a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f8500b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f8501c;

    public n(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f8501c = lVar;
        this.f8499a = iXAdContainer;
        this.f8500b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.f8501c.f8487b;
        aVar.c(this.f8499a, this.f8500b);
    }
}
