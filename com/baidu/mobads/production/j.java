package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f2417a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2417a.b();
            this.f2417a.l();
            this.f2417a.k();
            this.f2417a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Exception e) {
            this.f2417a.s.e(e);
        }
    }
}
