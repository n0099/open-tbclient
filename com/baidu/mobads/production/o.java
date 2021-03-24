package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdContainer f8501a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f8502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f8503c;

    public o(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f8503c = lVar;
        this.f8501a = iXAdContainer;
        this.f8502b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.f8503c.f8486b;
        aVar.d(this.f8501a, this.f8502b);
    }
}
