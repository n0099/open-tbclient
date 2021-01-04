package com.baidu.mobads.openad.d;

import com.baidu.mobads.utils.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3455a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f3455a.f != null && this.f3455a.d.getAndSet(false)) {
                this.f3455a.f.disconnect();
                this.f3455a.f = null;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }
}
