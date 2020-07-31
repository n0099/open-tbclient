package com.baidu.prologue.service.network;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes8.dex */
public class i {
    public static void gV(String str) {
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.bEI.get();
            Request.a aVar2 = new Request.a(aVar.OO(), str);
            aVar2.aM("User-Agent", aVar.userAgent());
            aVar2.Qh().a(new l() { // from class: com.baidu.prologue.service.network.i.1
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                }

                @Override // com.baidu.prologue.service.network.l
                public void o(Throwable th) {
                    if (com.baidu.prologue.a.b.a.this.OY()) {
                        Log.e("ParallelCharge", "als on error response", th);
                    }
                }
            });
        }
    }
}
