package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VerticalTranslateLayout f615a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        x xVar5;
        xVar = this.f615a.v;
        if (xVar.g) {
            switch (message.what) {
                case -105:
                    xVar5 = this.f615a.v;
                    xVar5.d();
                    return;
                case -104:
                    xVar2 = this.f615a.v;
                    xVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    xVar3 = this.f615a.v;
                    xVar3.b();
                    return;
                case -100:
                    xVar4 = this.f615a.v;
                    xVar4.a();
                    return;
            }
        }
    }
}
