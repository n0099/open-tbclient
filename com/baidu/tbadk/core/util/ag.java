package com.baidu.tbadk.core.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ af Er;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.Er = afVar;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        com.baidu.tbadk.core.util.httpNet.e eVar;
        com.baidu.tbadk.core.util.httpNet.e eVar2;
        com.baidu.tbadk.core.util.httpNet.e eVar3;
        boolean z = true;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    String headerField = httpURLConnection.getHeaderField("imgsrc");
                    if (headerField == null || headerField.length() <= 0) {
                        z = false;
                    }
                    eVar = this.Er.Ee;
                    if (eVar.na().nd().mIsBDImage || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                        eVar3 = this.Er.Ee;
                        eVar3.nb().ee = true;
                        return;
                    }
                    eVar2 = this.Er.Ee;
                    eVar2.nb().ee = false;
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
    public void dX() {
    }
}
