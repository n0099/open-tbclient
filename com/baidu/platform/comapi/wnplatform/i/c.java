package com.baidu.platform.comapi.wnplatform.i;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f10215a;

    public c(b bVar) {
        this.f10215a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        int i2;
        Bundle a2;
        int i3;
        a aVar3;
        a aVar4;
        com.baidu.platform.comapi.wnplatform.d.a.b("WRoutePlaner", "msg.arg1" + message.arg1 + "; msg.what" + message.what);
        if (message.what != 4099) {
            return;
        }
        int i4 = message.arg1;
        int i5 = message.arg2;
        if (i5 == 1 || i5 == 0) {
            if (i4 != 0) {
                aVar = this.f10215a.f10212a;
                if (aVar != null) {
                    aVar2 = this.f10215a.f10212a;
                    aVar2.a(i4);
                    return;
                }
                return;
            }
            com.baidu.platform.comapi.wnplatform.model.b R = com.baidu.platform.comapi.walknavi.b.a().R();
            b bVar = this.f10215a;
            i2 = bVar.f10213b;
            a2 = bVar.a(i2);
            i3 = this.f10215a.f10213b;
            R.a(a2, i3);
            aVar3 = this.f10215a.f10212a;
            if (aVar3 != null) {
                aVar4 = this.f10215a.f10212a;
                aVar4.b();
            }
        }
    }
}
