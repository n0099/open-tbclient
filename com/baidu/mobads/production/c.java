package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2449a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f2449a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2449a.f();
            this.f2449a.l();
            this.f2449a.k();
            this.f2449a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f2449a.v.e(e);
        }
    }
}
