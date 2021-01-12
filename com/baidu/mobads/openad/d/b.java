package com.baidu.mobads.openad.d;

import com.baidu.mobads.utils.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3418a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3418a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f3418a.f != null && this.f3418a.d.getAndSet(false)) {
                this.f3418a.f.disconnect();
                this.f3418a.f = null;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }
}
