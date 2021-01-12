package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f3071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.f3071a = rVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r rVar;
        w wVar;
        super.handleMessage(message);
        rVar = r.c;
        if (rVar != null) {
            wVar = this.f3071a.d;
            wVar.a(message);
        }
    }
}
