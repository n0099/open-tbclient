package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
/* loaded from: classes2.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8473a;

    public i(a aVar) {
        this.f8473a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        IXAdContainer iXAdContainer = this.f8473a.f8440h;
        if (iXAdContainer != null) {
            iXAdContainer.pause();
        }
    }
}
