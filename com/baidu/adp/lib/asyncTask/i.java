package com.baidu.adp.lib.asyncTask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Looper looper) {
        super(looper);
        this.f415a = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            if (message.obj != null && (message.obj instanceof k)) {
                this.f415a.c((k) message.obj);
            }
        } else if (message.what == 2 && message.obj != null && (message.obj instanceof k)) {
            this.f415a.b((k) message.obj);
        }
    }
}
