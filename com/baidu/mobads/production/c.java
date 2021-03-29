package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8446a;

    public c(a aVar) {
        this.f8446a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f8446a.f();
            this.f8446a.l();
            this.f8446a.k();
            this.f8446a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e2) {
            this.f8446a.v.e(e2);
        }
    }
}
