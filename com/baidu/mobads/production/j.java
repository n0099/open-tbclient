package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3456a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f3456a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f3456a.b();
            this.f3456a.l();
            this.f3456a.k();
            this.f3456a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f3456a.s.e(e);
        }
    }
}
