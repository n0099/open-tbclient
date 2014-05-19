package com.baidu.tbadk.a;

import com.baidu.adp.lib.network.websocket.CoderException;
import com.baidu.adp.lib.network.websocket.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebSocketStateHelper;
import com.baidu.tbadk.coreExtra.d.m;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.framework.c.d {
    @Override // com.baidu.adp.framework.c.d
    public void a(g gVar) {
        m.a().a(true, "timeout cmd = " + gVar.i());
    }

    @Override // com.baidu.adp.framework.c.d
    public boolean a(byte[] bArr) {
        try {
            com.baidu.tbadk.message.websockt.b a = com.baidu.tbadk.message.websockt.b.a(bArr);
            TiebaStatic.imLog(a.a.c(), a.a.e(), "socket", "MessageQueue: onBinaryMesssage", "succ", 0, null, 0L, bArr.length, null);
            if (a.a.c() == 1003) {
                return true;
            }
            return false;
        } catch (CoderException e) {
            TiebaStatic.imLog(0, 0, "socket", "MessageQueue: onBinaryMesssage decodeHeader error", "fail", e.getErrorCode(), null, 0L, bArr.length, null);
            return false;
        }
    }

    @Override // com.baidu.adp.framework.c.d
    public boolean a() {
        return WebSocketStateHelper.a();
    }
}
