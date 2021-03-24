package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
/* loaded from: classes2.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8474a;

    public j(a aVar) {
        this.f8474a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        IXAdContainer iXAdContainer = this.f8474a.f8440h;
        if (iXAdContainer != null) {
            iXAdContainer.resume();
        }
    }
}
