package com.baidu.adp.lib.network.a;

import android.os.Handler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.webSocket.q;
import java.util.Map;
/* loaded from: classes.dex */
final class c extends q {
    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(byte[] bArr) {
        d dVar;
        d dVar2;
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(String str) {
        d dVar;
        d dVar2;
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        d dVar2;
        d dVar3;
        dVar2 = a.c;
        if (dVar2 != null) {
            dVar3 = a.c;
            dVar3.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(Map<String, String> map) {
        Handler handler;
        d dVar;
        d dVar2;
        j.a().b();
        handler = a.d;
        handler.removeMessages(1);
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(int i, String str) {
        Handler handler;
        d dVar;
        f fVar;
        d dVar2;
        handler = a.d;
        handler.removeMessages(1);
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(i, str);
        }
        if (BdUtilHelper.d()) {
            fVar = a.b;
            String str2 = "onClose:" + i + ":" + str;
            fVar.a();
        }
    }
}
