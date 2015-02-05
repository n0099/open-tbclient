package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ag IJ;
    int IK = 0;
    int IL = 0;
    int IM = 0;
    private final /* synthetic */ Handler IN;
    private final /* synthetic */ int IO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, Handler handler, int i) {
        this.IJ = agVar;
        this.IN = handler;
        this.IO = i;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.IK = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.IL += i - this.IM;
        this.IM = i;
        if (this.IN != null) {
            if (this.IL > this.IK || i == i2) {
                this.IL = 0;
                this.IN.sendMessage(this.IN.obtainMessage(this.IO, i, i2));
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
