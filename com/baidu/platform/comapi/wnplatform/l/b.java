package com.baidu.platform.comapi.wnplatform.l;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* loaded from: classes2.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9871a;

    public b(a aVar) {
        this.f9871a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.platform.comapi.wnplatform.c.b bVar;
        com.baidu.platform.comapi.wnplatform.c.b bVar2;
        if (message.what != 1) {
            return;
        }
        WLocData wLocData = (WLocData) message.obj;
        bVar = this.f9871a.f9868h;
        if (bVar != null) {
            bVar2 = this.f9871a.f9868h;
            bVar2.a(wLocData);
        }
    }
}
