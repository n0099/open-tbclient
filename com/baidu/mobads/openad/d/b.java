package com.baidu.mobads.openad.d;

import com.baidu.mobads.utils.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2384a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2384a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f2384a.f != null && this.f2384a.d.getAndSet(false)) {
                this.f2384a.f.disconnect();
                this.f2384a.f = null;
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }
}
