package com.baidu.adp.lib.g;

import com.baidu.adp.lib.network.e;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0043 -> B:21:0x0035). Please submit an issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        byte[] g;
        try {
            g = this.a.g();
            if (g != null && g.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                com.baidu.adp.lib.h.d.a(g, byteArrayOutputStream);
                try {
                    e a = com.baidu.adp.lib.network.d.a().a("http://or.baidu.com/or/api/get", (ArrayList<BasicNameValuePair>) null, "monitor", byteArrayOutputStream.toByteArray(), 2, (com.baidu.adp.lib.network.c) null, (com.baidu.adp.lib.network.a) null, (LinkedList<BasicNameValuePair>) null);
                    if (a == null || a.a != 200) {
                        this.a.d();
                    } else {
                        this.a.e();
                    }
                } catch (Exception e) {
                    this.a.d();
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            this.a.d();
            e2.printStackTrace();
        }
        this.a.n = false;
    }
}
