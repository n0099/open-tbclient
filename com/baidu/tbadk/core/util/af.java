package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class af implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ad Um;
    long Un = 0;
    int Uo = 0;
    int Up = 0;
    int Uq = 0;
    private final /* synthetic */ Handler Ur;
    private final /* synthetic */ int Us;
    private final /* synthetic */ long Ut;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, Handler handler, int i, long j) {
        this.Um = adVar;
        this.Ur = handler;
        this.Us = i;
        this.Ut = j;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.Uo = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        com.baidu.tbadk.core.util.httpNet.a aVar;
        com.baidu.tbadk.core.util.httpNet.a aVar2;
        com.baidu.tbadk.core.util.httpNet.a aVar3;
        com.baidu.tbadk.core.util.httpNet.a aVar4;
        long j = 0;
        if (i > this.Un) {
            j = i - this.Un;
        }
        if (httpURLConnection != null) {
            aVar = this.Um.Ua;
            aVar.tq().mHeader = httpURLConnection.getHeaderFields();
            aVar2 = this.Um.Ua;
            if (aVar2.tr().wo != null) {
                aVar3 = this.Um.Ua;
                aVar3.tr().wo.vE = httpURLConnection.getHeaderFields().toString().getBytes().length;
                aVar4 = this.Um.Ua;
                aVar4.tr().wo.vF = (int) j;
            }
        }
        this.Up += i - this.Uq;
        this.Uq = i;
        if (this.Ur != null) {
            if (this.Up > this.Uo || i == i2) {
                this.Up = 0;
                this.Ur.sendMessage(this.Ur.obtainMessage(this.Us, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void ht() {
        if (this.Ut != 0) {
            this.Un = this.Ut;
        }
    }
}
