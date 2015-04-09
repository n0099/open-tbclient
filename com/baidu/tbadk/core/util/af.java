package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class af implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ad Uo;
    long Up = 0;
    int Uq = 0;
    int Ur = 0;
    int Us = 0;
    private final /* synthetic */ Handler Ut;
    private final /* synthetic */ int Uu;
    private final /* synthetic */ long Uv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, Handler handler, int i, long j) {
        this.Uo = adVar;
        this.Ut = handler;
        this.Uu = i;
        this.Uv = j;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.Uq = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        com.baidu.tbadk.core.util.httpNet.a aVar;
        com.baidu.tbadk.core.util.httpNet.a aVar2;
        com.baidu.tbadk.core.util.httpNet.a aVar3;
        com.baidu.tbadk.core.util.httpNet.a aVar4;
        long j = 0;
        if (i > this.Up) {
            j = i - this.Up;
        }
        if (httpURLConnection != null) {
            aVar = this.Uo.Uc;
            aVar.tq().mHeader = httpURLConnection.getHeaderFields();
            aVar2 = this.Uo.Uc;
            if (aVar2.tr().wo != null) {
                aVar3 = this.Uo.Uc;
                aVar3.tr().wo.vE = httpURLConnection.getHeaderFields().toString().getBytes().length;
                aVar4 = this.Uo.Uc;
                aVar4.tr().wo.vF = (int) j;
            }
        }
        this.Ur += i - this.Us;
        this.Us = i;
        if (this.Ut != null) {
            if (this.Ur > this.Uq || i == i2) {
                this.Ur = 0;
                this.Ut.sendMessage(this.Ut.obtainMessage(this.Uu, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void ht() {
        if (this.Uv != 0) {
            this.Up = this.Uv;
        }
    }
}
