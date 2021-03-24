package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* loaded from: classes2.dex */
public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f8445a;

    public c(a aVar) {
        this.f8445a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f8445a.f();
            this.f8445a.l();
            this.f8445a.k();
            this.f8445a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e2) {
            this.f8445a.v.e(e2);
        }
    }
}
