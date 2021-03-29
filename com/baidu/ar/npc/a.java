package com.baidu.ar.npc;

import android.os.Handler;
import android.os.Message;
import com.baidu.ar.npc.ArBridge;
/* loaded from: classes.dex */
public class a implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArBridge f4155a;

    public a(ArBridge arBridge) {
        this.f4155a = arBridge;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        this.f4155a.processIncomingMessage((ArBridge.b) message.obj);
        return false;
    }
}
