package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdContainer f8502a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HashMap f8503b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f8504c;

    public o(l lVar, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f8504c = lVar;
        this.f8502a = iXAdContainer;
        this.f8503b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar;
        aVar = this.f8504c.f8487b;
        aVar.d(this.f8502a, this.f8503b);
    }
}
