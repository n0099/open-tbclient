package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ag IM;
    int IN = 0;
    int IO = 0;
    int IP = 0;
    private final /* synthetic */ Handler IQ;
    private final /* synthetic */ int IR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, Handler handler, int i) {
        this.IM = agVar;
        this.IQ = handler;
        this.IR = i;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.IN = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.IO += i - this.IP;
        this.IP = i;
        if (this.IQ != null) {
            if (this.IO > this.IN || i == i2) {
                this.IO = 0;
                this.IQ.sendMessage(this.IQ.obtainMessage(this.IR, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void dU() {
    }
}
