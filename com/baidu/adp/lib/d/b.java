package com.baidu.adp.lib.d;

import com.baidu.adp.lib.network.d;
import com.baidu.adp.lib.network.e;
import java.io.ByteArrayOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f389a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f389a = aVar;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0042 -> B:21:0x0034). Please submit an issue!!! */
    @Override // java.lang.Runnable
    public void run() {
        byte[] f;
        try {
            f = this.f389a.f();
            if (f != null && f.length > 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                com.baidu.adp.lib.e.c.a(f, byteArrayOutputStream);
                try {
                    e a2 = d.a().a("http://or.baidu.com/or/api/get", null, "monitor", byteArrayOutputStream.toByteArray(), 2, null, null);
                    if (a2 == null || a2.f446a != 200) {
                        this.f389a.c();
                    } else {
                        this.f389a.d();
                    }
                } catch (Exception e) {
                    this.f389a.c();
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            this.f389a.c();
            e2.printStackTrace();
        }
        this.f389a.n = false;
    }
}
