package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class l extends Handler {
    final /* synthetic */ IXAdInstanceInfo a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(b bVar, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        super(looper);
        this.b = bVar;
        this.a = iXAdInstanceInfo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    this.b.a(message, this.a);
                    return;
                } catch (Exception e) {
                    com.baidu.mobads.utils.m.a().e(e);
                    return;
                }
            default:
                return;
        }
    }
}
