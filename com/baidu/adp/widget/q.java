package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VerticalTranslateLayout f512a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        rVar = this.f512a.v;
        if (rVar.g) {
            switch (message.what) {
                case -105:
                    rVar5 = this.f512a.v;
                    rVar5.d();
                    return;
                case -104:
                    rVar2 = this.f512a.v;
                    rVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    rVar3 = this.f512a.v;
                    rVar3.b();
                    return;
                case -100:
                    rVar4 = this.f512a.v;
                    rVar4.a();
                    return;
            }
        }
    }
}
