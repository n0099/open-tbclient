package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.q;
/* loaded from: classes2.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IXAdInstanceInfo f8467a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f8468b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(a aVar, Looper looper, IXAdInstanceInfo iXAdInstanceInfo) {
        super(looper);
        this.f8468b = aVar;
        this.f8467a = iXAdInstanceInfo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 0) {
            return;
        }
        try {
            this.f8468b.a(message, this.f8467a);
        } catch (Exception e2) {
            q.a().d(e2);
        }
    }
}
