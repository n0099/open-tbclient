package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VerticalTranslateLayout f606a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        u uVar;
        u uVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        uVar = this.f606a.v;
        if (uVar.g) {
            switch (message.what) {
                case -105:
                    uVar5 = this.f606a.v;
                    uVar5.d();
                    return;
                case -104:
                    uVar2 = this.f606a.v;
                    uVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    uVar3 = this.f606a.v;
                    uVar3.b();
                    return;
                case -100:
                    uVar4 = this.f606a.v;
                    uVar4.a();
                    return;
            }
        }
    }
}
