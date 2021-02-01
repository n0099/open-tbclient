package com.baidu.mapsdkplatform.comapi;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3018a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3018a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3018a.a(message);
    }
}
