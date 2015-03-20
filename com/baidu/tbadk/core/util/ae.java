package com.baidu.tbadk.core.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ ad Um;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.Um = adVar;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        com.baidu.tbadk.core.util.httpNet.a aVar;
        com.baidu.tbadk.core.util.httpNet.a aVar2;
        com.baidu.tbadk.core.util.httpNet.a aVar3;
        com.baidu.tbadk.core.util.httpNet.a aVar4;
        boolean z = true;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    String headerField = httpURLConnection.getHeaderField("imgsrc");
                    if (headerField == null || headerField.length() <= 0) {
                        z = false;
                    }
                    aVar = this.Um.Ua;
                    if (aVar.tp().ts().mIsBDImage || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    String headerField2 = httpURLConnection.getHeaderField("Src-Content-Type");
                    aVar2 = this.Um.Ua;
                    aVar2.tq().mHeader = httpURLConnection.getHeaderFields();
                    if ("image/gif".equalsIgnoreCase(headerField2)) {
                        aVar4 = this.Um.Ua;
                        aVar4.tq().rC = true;
                        return;
                    }
                    aVar3 = this.Um.Ua;
                    aVar3.tq().rC = false;
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
    public void ht() {
    }
}
