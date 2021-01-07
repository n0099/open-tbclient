package com.baidu.location.c;

import com.baidu.location.c.b;
/* loaded from: classes3.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.a f2679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b.a aVar) {
        this.f2679a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.this.k();
        } catch (Exception e) {
        }
    }
}
