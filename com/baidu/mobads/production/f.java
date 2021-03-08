package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IXAdInstanceInfo f2459a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a aVar, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        super(looper);
        this.b = aVar;
        this.f2459a = iXAdInstanceInfo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    this.b.a(message, this.f2459a);
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
