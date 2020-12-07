package com.baidu.prologue.service.network;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes14.dex */
public class i {
    public static void ks(String str) {
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.clZ.get();
            Request.a aVar2 = new Request.a(aVar.aei(), str);
            aVar2.bi("User-Agent", aVar.userAgent());
            aVar2.afz().a(new l() { // from class: com.baidu.prologue.service.network.i.1
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                }

                @Override // com.baidu.prologue.service.network.l
                public void n(Throwable th) {
                    if (com.baidu.prologue.a.b.a.this.aes()) {
                        Log.e("ParallelCharge", "als on error response", th);
                    }
                }
            });
        }
    }
}
