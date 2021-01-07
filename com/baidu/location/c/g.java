package com.baidu.location.c;

import android.location.OnNmeaMessageListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class g implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2696a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f2696a = fVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f2696a.J != null) {
            this.f2696a.J.sendMessage(this.f2696a.J.obtainMessage(5, str));
        }
    }
}
