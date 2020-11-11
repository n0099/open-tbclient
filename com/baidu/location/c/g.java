package com.baidu.location.c;

import android.location.OnNmeaMessageListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class g implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f1936a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f1936a = fVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f1936a.J != null) {
            this.f1936a.J.sendMessage(this.f1936a.J.obtainMessage(5, str));
        }
    }
}
