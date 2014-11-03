package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class ah implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ af Er;
    int Es = 0;
    int Et = 0;
    int Eu = 0;
    private final /* synthetic */ Handler Ev;
    private final /* synthetic */ int Ew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar, Handler handler, int i) {
        this.Er = afVar;
        this.Ev = handler;
        this.Ew = i;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.Es = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.Et += i - this.Eu;
        this.Eu = i;
        if (this.Ev != null) {
            if (this.Et > this.Es || i == i2) {
                this.Et = 0;
                this.Ev.sendMessage(this.Ev.obtainMessage(this.Ew, i, i2));
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
