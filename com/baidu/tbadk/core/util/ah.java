package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class ah implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ af Eq;
    int Er = 0;
    int Es = 0;
    int Et = 0;
    private final /* synthetic */ Handler Eu;
    private final /* synthetic */ int Ev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, Handler handler, int i) {
        this.Eq = afVar;
        this.Eu = handler;
        this.Ev = i;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.Er = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.Es += i - this.Et;
        this.Et = i;
        if (this.Eu != null) {
            if (this.Es > this.Er || i == i2) {
                this.Es = 0;
                this.Eu.sendMessage(this.Eu.obtainMessage(this.Ev, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void dX() {
    }
}
