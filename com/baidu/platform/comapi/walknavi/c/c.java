package com.baidu.platform.comapi.walknavi.c;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4198a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4198a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i;
        a aVar;
        int i2;
        a aVar2;
        a aVar3;
        a aVar4;
        switch (message.what) {
            case 1:
                aVar3 = this.f4198a.e;
                if (aVar3 != null) {
                    aVar4 = this.f4198a.e;
                    aVar4.b();
                    this.f4198a.e = null;
                    return;
                }
                return;
            case 16:
            case 32:
                b bVar = this.f4198a;
                i = this.f4198a.f;
                bVar.f = i | message.what;
                aVar = this.f4198a.e;
                if (aVar != null) {
                    i2 = this.f4198a.f;
                    if (i2 == 48) {
                        aVar2 = this.f4198a.e;
                        aVar2.a();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
