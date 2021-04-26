package com.baidu.platform.comapi.walknavi.c;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9835a;

    public c(b bVar) {
        this.f9835a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        int i2;
        a aVar3;
        int i3;
        a aVar4;
        int i4 = message.what;
        if (i4 == 1) {
            aVar = this.f9835a.f9827e;
            if (aVar != null) {
                aVar2 = this.f9835a.f9827e;
                aVar2.b();
                this.f9835a.f9827e = null;
            }
        } else if (i4 == 16 || i4 == 32) {
            b bVar = this.f9835a;
            i2 = bVar.f9828f;
            bVar.f9828f = message.what | i2;
            aVar3 = this.f9835a.f9827e;
            if (aVar3 != null) {
                i3 = this.f9835a.f9828f;
                if (i3 == 48) {
                    aVar4 = this.f9835a.f9827e;
                    aVar4.a();
                }
            }
        }
    }
}
