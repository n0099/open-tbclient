package com.baidu.adp.lib.g;

import com.baidu.adp.lib.network.d;
import com.baidu.adp.lib.network.e;
import java.io.ByteArrayOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f485a = aVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:21:0x0034). Please submit an issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        byte[] g;
        try {
            g = this.f485a.g();
            if (g != null && g.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                com.baidu.adp.lib.h.c.a(g, byteArrayOutputStream);
                try {
                    e a2 = d.a().a("http://or.baidu.com/or/api/get", null, "monitor", byteArrayOutputStream.toByteArray(), 2, null, null);
                    if (a2 == null || a2.f513a != 200) {
                        this.f485a.d();
                    } else {
                        this.f485a.e();
                    }
                } catch (Exception e) {
                    this.f485a.d();
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            this.f485a.d();
            e2.printStackTrace();
        }
        this.f485a.n = false;
    }
}
