package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.zeus.bouncycastle.DERTags;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ e a;

    private h(e eVar) {
        this.a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(e eVar, g gVar) {
        this(eVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        j jVar;
        j jVar2;
        switch (message.what) {
            case 1:
                this.a.g();
                return;
            case 2:
                this.a.h();
                return;
            case 3:
                this.a.d(message);
                return;
            case 4:
                this.a.l();
                return;
            case 5:
                this.a.e(message);
                return;
            case 6:
                this.a.f(message);
                return;
            case 7:
                this.a.m();
                return;
            case 8:
                this.a.c(message);
                return;
            case 9:
                this.a.a(message);
                return;
            case 10:
                this.a.b(message);
                return;
            case 11:
                this.a.k();
                return;
            case 12:
                this.a.f();
                return;
            case 21:
                this.a.a(message, 21);
                return;
            case DERTags.VISIBLE_STRING /* 26 */:
                this.a.a(message, 26);
                return;
            case DERTags.GENERAL_STRING /* 27 */:
                this.a.g(message);
                return;
            case 54:
                jVar2 = this.a.e;
                if (jVar2.h) {
                    this.a.q = true;
                    return;
                }
                return;
            case 55:
                jVar = this.a.e;
                if (jVar.h) {
                    this.a.q = false;
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
