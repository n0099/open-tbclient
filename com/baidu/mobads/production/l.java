package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class l extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdInstanceInfo f3496a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3497b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(b bVar, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        super(looper);
        this.f3497b = bVar;
        this.f3496a = iXAdInstanceInfo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    this.f3497b.a(message, this.f3496a);
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
