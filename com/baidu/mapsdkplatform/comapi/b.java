package com.baidu.mapsdkplatform.comapi;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2202a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f2202a.a(message);
    }
}
