package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f2415a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2415a.b();
            this.f2415a.l();
            this.f2415a.k();
            this.f2415a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f2415a.s.e(e);
        }
    }
}
