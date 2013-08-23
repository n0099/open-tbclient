package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HorizontalTranslateLayout f505a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        eVar = this.f505a.t;
        if (eVar.g) {
            switch (message.what) {
                case -105:
                    eVar5 = this.f505a.t;
                    eVar5.d();
                    return;
                case -104:
                    eVar2 = this.f505a.t;
                    eVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    eVar3 = this.f505a.t;
                    eVar3.b();
                    return;
                case -100:
                    eVar4 = this.f505a.t;
                    eVar4.a();
                    return;
            }
        }
    }
}
