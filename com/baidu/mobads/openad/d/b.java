package com.baidu.mobads.openad.d;

import com.baidu.mobads.utils.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2388a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2388a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f2388a.f != null && this.f2388a.d.getAndSet(false)) {
                this.f2388a.f.disconnect();
                this.f2388a.f = null;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }
}
