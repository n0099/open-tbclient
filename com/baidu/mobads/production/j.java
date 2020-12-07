package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2419a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f2419a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2419a.b();
            this.f2419a.l();
            this.f2419a.k();
            this.f2419a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f2419a.s.e(e);
        }
    }
}
