package com.baidu.prologue.service.network;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.prologue.service.network.Request;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class i {
    public static void iJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            final com.baidu.prologue.a.b.a aVar = com.baidu.prologue.a.b.a.bMm.get();
            Request.a aVar2 = new Request.a(aVar.Vt(), str);
            aVar2.aQ("User-Agent", aVar.userAgent());
            aVar2.WL().a(new l() { // from class: com.baidu.prologue.service.network.i.1
                @Override // com.baidu.prologue.service.network.l
                public void a(long j, InputStream inputStream) {
                }

                @Override // com.baidu.prologue.service.network.l
                public void n(Throwable th) {
                    if (com.baidu.prologue.a.b.a.this.VD()) {
                        Log.e("ParallelCharge", "als on error response", th);
                    }
                }
            });
        }
    }
}
