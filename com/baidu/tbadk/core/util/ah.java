package com.baidu.tbadk.core.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ag IC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.IC = agVar;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        com.baidu.tbadk.core.util.httpNet.c cVar;
        com.baidu.tbadk.core.util.httpNet.c cVar2;
        com.baidu.tbadk.core.util.httpNet.c cVar3;
        boolean z = true;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    String headerField = httpURLConnection.getHeaderField("imgsrc");
                    if (headerField == null || headerField.length() <= 0) {
                        z = false;
                    }
                    cVar = this.IC.Iq;
                    if (cVar.pV().pY().mIsBDImage || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                        cVar3 = this.IC.Iq;
                        cVar3.pW().gg = true;
                        return;
                    }
                    cVar2 = this.IC.Iq;
                    cVar2.pW().gg = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void dW() {
    }
}
