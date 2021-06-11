package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7720a;

    public s(r rVar) {
        this.f7720a = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r rVar;
        w wVar;
        super.handleMessage(message);
        rVar = r.f7716c;
        if (rVar != null) {
            wVar = this.f7720a.f7718d;
            wVar.a(message);
        }
    }
}
