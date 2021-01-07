package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3494a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f3494a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3494a.b();
            this.f3494a.l();
            this.f3494a.k();
            this.f3494a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f3494a.s.e(e);
        }
    }
}
