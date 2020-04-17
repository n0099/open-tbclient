package com.baidu.prologue.service.network;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class i {
    public static void gd(String str) {
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.brQ.get();
            Request.a aVar2 = new Request.a(aVar.Lh(), str);
            aVar2.av("User-Agent", aVar.userAgent());
            aVar2.MA().a(new l() { // from class: com.baidu.prologue.service.network.i.1
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                }

                @Override // com.baidu.prologue.service.network.l
                public void n(Throwable th) {
                    if (com.baidu.prologue.a.b.a.this.Lr()) {
                        Log.e("ParallelCharge", "als on error response", th);
                    }
                }
            });
        }
    }
}
