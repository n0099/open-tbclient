package com.baidu.mapsdkplatform.comapi;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3139a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3139a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3139a.a(message);
    }
}
