package com.baidu.location.b;

import android.location.OnNmeaMessageListener;
/* loaded from: classes2.dex */
public class f implements OnNmeaMessageListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f6677a;

    public f(e eVar) {
        this.f6677a = eVar;
    }

    @Override // android.location.OnNmeaMessageListener
    public void onNmeaMessage(String str, long j) {
        if (this.f6677a.b(str)) {
            this.f6677a.a(str);
        }
    }
}
