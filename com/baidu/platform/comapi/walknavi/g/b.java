package com.baidu.platform.comapi.walknavi.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f4503a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1 && message.what != 2 && message.what == 3) {
            this.f4503a.m();
        }
    }
}
