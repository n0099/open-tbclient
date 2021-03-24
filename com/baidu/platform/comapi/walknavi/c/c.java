package com.baidu.platform.comapi.walknavi.c;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes2.dex */
public class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9921a;

    public c(b bVar) {
        this.f9921a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2;
        int i;
        a aVar3;
        int i2;
        a aVar4;
        int i3 = message.what;
        if (i3 == 1) {
            aVar = this.f9921a.f9913e;
            if (aVar != null) {
                aVar2 = this.f9921a.f9913e;
                aVar2.b();
                this.f9921a.f9913e = null;
            }
        } else if (i3 == 16 || i3 == 32) {
            b bVar = this.f9921a;
            i = bVar.f9914f;
            bVar.f9914f = message.what | i;
            aVar3 = this.f9921a.f9913e;
            if (aVar3 != null) {
                i2 = this.f9921a.f9914f;
                if (i2 == 48) {
                    aVar4 = this.f9921a.f9913e;
                    aVar4.a();
                }
            }
        }
    }
}
