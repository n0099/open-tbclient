package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7980a;

    public s(r rVar) {
        this.f7980a = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r rVar;
        w wVar;
        super.handleMessage(message);
        rVar = r.f7976c;
        if (rVar != null) {
            wVar = this.f7980a.f7978d;
            wVar.a(message);
        }
    }
}
