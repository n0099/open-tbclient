package com.baidu.location;

import android.os.Handler;
import android.os.Message;
import com.baidu.zeus.bouncycastle.DERTags;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f473a;

    private h(e eVar) {
        this.f473a = eVar;
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
                this.f473a.g();
                return;
            case 2:
                this.f473a.h();
                return;
            case 3:
                this.f473a.d(message);
                return;
            case 4:
                this.f473a.l();
                return;
            case 5:
                this.f473a.e(message);
                return;
            case 6:
                this.f473a.f(message);
                return;
            case 7:
                this.f473a.m();
                return;
            case 8:
                this.f473a.c(message);
                return;
            case 9:
                this.f473a.a(message);
                return;
            case 10:
                this.f473a.b(message);
                return;
            case 11:
                this.f473a.k();
                return;
            case 12:
                this.f473a.f();
                return;
            case 21:
                this.f473a.a(message, 21);
                return;
            case DERTags.VISIBLE_STRING /* 26 */:
                this.f473a.a(message, 26);
                return;
            case DERTags.GENERAL_STRING /* 27 */:
                this.f473a.g(message);
                return;
            case 54:
                jVar2 = this.f473a.e;
                if (jVar2.h) {
                    this.f473a.q = true;
                    return;
                }
                return;
            case 55:
                jVar = this.f473a.e;
                if (jVar.h) {
                    this.f473a.q = false;
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
