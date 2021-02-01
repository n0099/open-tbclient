package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdInstanceInfo f3452a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3453b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a aVar, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        super(looper);
        this.f3453b = aVar;
        this.f3452a = iXAdInstanceInfo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    this.f3453b.a(message, this.f3452a);
                    return;
                } catch (Exception e) {
                    q.a().d(e);
                    return;
                }
            default:
                return;
        }
    }
}
