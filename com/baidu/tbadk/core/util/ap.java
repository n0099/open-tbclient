package com.baidu.tbadk.core.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.adp.lib.network.willdelete.d {
    final /* synthetic */ NetWorkCoreByBdHttp a;
    private final /* synthetic */ String b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NetWorkCoreByBdHttp netWorkCoreByBdHttp, String str, long j) {
        this.a = netWorkCoreByBdHttp;
        this.b = str;
        this.c = j;
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, HttpURLConnection httpURLConnection, OutputStream outputStream) {
        com.baidu.tbadk.core.util.a.a aVar;
        com.baidu.tbadk.core.util.a.a aVar2;
        com.baidu.tbadk.core.util.a.a aVar3;
        com.baidu.tbadk.core.util.a.a aVar4;
        com.baidu.tbadk.core.util.a.a aVar5;
        boolean z = false;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getInputStream() != null) {
                    String headerField = httpURLConnection.getHeaderField("imgsrc");
                    if (headerField != null && headerField.length() > 0) {
                        z = true;
                    }
                    aVar = this.a.d;
                    if (aVar.a().a().e || z) {
                        byte[] bArr = new byte[23];
                        int read = httpURLConnection.getInputStream().read(bArr, 0, 23);
                        if (!new String(bArr, 0, bArr.length).equalsIgnoreCase("app:tiebaclient;type:0;")) {
                            outputStream.write(bArr, 0, read);
                        }
                    }
                    if ("image/gif".equalsIgnoreCase(httpURLConnection.getHeaderField("Src-Content-Type"))) {
                        aVar3 = this.a.d;
                        aVar3.b().e = true;
                        aVar4 = this.a.d;
                        if (aVar4.a().h == 1) {
                            aVar5 = this.a.d;
                            aVar5.a().h = 2;
                            return;
                        }
                        return;
                    }
                    aVar2 = this.a.d;
                    aVar2.b().e = false;
                    return;
                }
            } catch (IOException e) {
                com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.k.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), "0", e.getMessage(), "connection failed."));
                try {
                    com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.k.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), String.valueOf(httpURLConnection.getContentLength()), String.valueOf(httpURLConnection.getResponseCode()) + ":" + httpURLConnection.getHeaderFields(), "|download error|" + e.getMessage()));
                } catch (IOException e2) {
                    com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.k.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), String.valueOf(httpURLConnection.getContentLength()), "cann't get responseCode:" + httpURLConnection.getHeaderFields(), "|download error|" + e.getMessage()));
                }
                e.printStackTrace();
                return;
            }
        }
        com.baidu.tbadk.core.log.a.a(com.baidu.tbadk.core.log.k.a(this.b, String.valueOf(System.currentTimeMillis() - this.c), "0", "failed to open connection.", "connection failed."));
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(int i, int i2, HttpURLConnection httpURLConnection) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a(com.baidu.adp.lib.network.willdelete.f fVar) {
    }

    @Override // com.baidu.adp.lib.network.willdelete.d
    public void a() {
    }
}
