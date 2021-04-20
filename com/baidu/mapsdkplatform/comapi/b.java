package com.baidu.mapsdkplatform.comapi;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f7561a;

    public b(a aVar) {
        this.f7561a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f7561a.a(message);
    }
}
