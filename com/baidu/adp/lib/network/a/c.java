package com.baidu.adp.lib.network.a;

import android.os.Handler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.webSocket.r;
import java.util.Map;
/* loaded from: classes.dex */
class c extends r {
    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(byte[] bArr) {
        d dVar;
        d dVar2;
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(String str) {
        d dVar;
        d dVar2;
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        d dVar2;
        d dVar3;
        dVar2 = a.c;
        if (dVar2 != null) {
            dVar3 = a.c;
            dVar3.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(Map<String, String> map) {
        Handler handler;
        d dVar;
        d dVar2;
        j.a().c();
        handler = a.d;
        handler.removeMessages(1);
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            dVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(int i, String str) {
        Handler handler;
        d dVar;
        f fVar;
        d dVar2;
        handler = a.d;
        handler.removeMessages(1);
        boolean z = false;
        dVar = a.c;
        if (dVar != null) {
            dVar2 = a.c;
            z = dVar2.a(i, str);
        }
        if (!z && BdUtilHelper.d()) {
            fVar = a.b;
            fVar.a("onClose:" + i + ":" + str);
        }
    }
}
