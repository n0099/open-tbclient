package com.baidu.location.c;

import android.location.OnNmeaMessageListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class g implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f2695a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f2695a = fVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f2695a.J != null) {
            this.f2695a.J.sendMessage(this.f2695a.J.obtainMessage(5, str));
        }
    }
}
