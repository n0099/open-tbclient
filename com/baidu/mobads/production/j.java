package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f3493a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3493a.b();
            this.f3493a.l();
            this.f3493a.k();
            this.f3493a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f3493a.s.e(e);
        }
    }
}
