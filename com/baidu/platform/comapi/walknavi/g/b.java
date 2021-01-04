package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4502a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1 && message.what != 2 && message.what == 3) {
            this.f4502a.m();
        }
    }
}
