package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VerticalTranslateLayout f616a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5;
        zVar = this.f616a.v;
        if (zVar.g) {
            switch (message.what) {
                case -105:
                    zVar5 = this.f616a.v;
                    zVar5.d();
                    return;
                case -104:
                    zVar2 = this.f616a.v;
                    zVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    zVar3 = this.f616a.v;
                    zVar3.b();
                    return;
                case -100:
                    zVar4 = this.f616a.v;
                    zVar4.a();
                    return;
            }
        }
    }
}
