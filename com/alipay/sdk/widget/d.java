package com.alipay.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f2025a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, Looper looper) {
        super(looper);
        this.f2025a = aVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        this.f2025a.c();
    }
}
