package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3440a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3440a.f();
            this.f3440a.l();
            this.f3440a.k();
            this.f3440a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f3440a.v.e(e);
        }
    }
}
