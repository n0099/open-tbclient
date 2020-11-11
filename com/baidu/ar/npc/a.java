package com.baidu.ar.npc;

import android.os.Handler;
import android.os.Message;
import com.baidu.ar.npc.ArBridge;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArBridge f1209a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(ArBridge arBridge) {
        this.f1209a = arBridge;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f1209a.a((ArBridge.b) message.obj);
                return false;
            default:
                return false;
        }
    }
}
