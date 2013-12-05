package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VerticalTranslateLayout f622a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        aa aaVar4;
        aa aaVar5;
        aaVar = this.f622a.v;
        if (aaVar.g) {
            switch (message.what) {
                case -105:
                    aaVar5 = this.f622a.v;
                    aaVar5.d();
                    return;
                case -104:
                    aaVar2 = this.f622a.v;
                    aaVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    aaVar3 = this.f622a.v;
                    aaVar3.b();
                    return;
                case -100:
                    aaVar4 = this.f622a.v;
                    aaVar4.a();
                    return;
            }
        }
    }
}
