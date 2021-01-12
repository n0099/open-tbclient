package com.baidu.location.b;

import android.location.OnNmeaMessageListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f2610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f2610a = eVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f2610a.b(str)) {
            this.f2610a.a(str);
        }
    }
}
