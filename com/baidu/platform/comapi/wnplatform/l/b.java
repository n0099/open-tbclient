package com.baidu.platform.comapi.wnplatform.l;

import android.os.Handler;
import android.os.Message;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3067a = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.baidu.platform.comapi.wnplatform.c.b bVar;
        com.baidu.platform.comapi.wnplatform.c.b bVar2;
        switch (message.what) {
            case 1:
                WLocData wLocData = (WLocData) message.obj;
                bVar = this.f3067a.h;
                if (bVar != null) {
                    bVar2 = this.f3067a.h;
                    bVar2.a(wLocData);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
