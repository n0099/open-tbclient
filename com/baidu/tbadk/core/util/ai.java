package com.baidu.tbadk.core.util;

import android.os.Handler;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* loaded from: classes.dex */
class ai implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ag IC;
    int IE = 0;
    int IF = 0;
    int IG = 0;
    private final /* synthetic */ int IH;
    private final /* synthetic */ Handler val$handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, Handler handler, int i) {
        this.IC = agVar;
        this.val$handler = handler;
        this.IH = i;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        if (httpURLConnection != null && i > 0) {
            this.IE = i / 50;
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
        this.IF += i - this.IG;
        this.IG = i;
        if (this.val$handler != null) {
            if (this.IF > this.IE || i == i2) {
                this.IF = 0;
                this.val$handler.sendMessage(this.val$handler.obtainMessage(this.IH, i, i2));
            }
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void dW() {
    }
}
