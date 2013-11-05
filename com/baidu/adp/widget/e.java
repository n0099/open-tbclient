package com.baidu.adp.widget;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HorizontalTranslateLayout f597a;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        f fVar;
        f fVar2;
        f fVar3;
        f fVar4;
        f fVar5;
        fVar = this.f597a.t;
        if (fVar.g) {
            switch (message.what) {
                case -105:
                    fVar5 = this.f597a.t;
                    fVar5.d();
                    return;
                case -104:
                    fVar2 = this.f597a.t;
                    fVar2.c();
                    return;
                case -103:
                case -102:
                default:
                    return;
                case -101:
                    fVar3 = this.f597a.t;
                    fVar3.b();
                    return;
                case -100:
                    fVar4 = this.f597a.t;
                    fVar4.a();
                    return;
            }
        }
    }
}
