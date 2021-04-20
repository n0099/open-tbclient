package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f7704a;

    public s(r rVar) {
        this.f7704a = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r rVar;
        w wVar;
        super.handleMessage(message);
        rVar = r.f7700c;
        if (rVar != null) {
            wVar = this.f7704a.f7702d;
            wVar.a(message);
        }
    }
}
