package com.baidu.mobstat;

import com.baidu.mobstat.cq;
import java.net.InetSocketAddress;
/* loaded from: classes9.dex */
public abstract class bz implements cb {
    @Override // com.baidu.mobstat.cb
    public void a(by byVar, cs csVar, cz czVar) throws ch {
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, cs csVar) throws ch {
    }

    @Override // com.baidu.mobstat.cb
    public void a(by byVar, cq cqVar) {
    }

    @Override // com.baidu.mobstat.cb
    public void b(by byVar, cq cqVar) {
        cr crVar = new cr(cqVar);
        crVar.a(cq.a.PONG);
        byVar.a(crVar);
    }

    @Override // com.baidu.mobstat.cb
    public void c(by byVar, cq cqVar) {
    }

    @Override // com.baidu.mobstat.cb
    public String a(by byVar) throws ch {
        InetSocketAddress a = byVar.a();
        if (a == null) {
            throw new cj("socket not bound");
        }
        return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + a.getPort() + "\" /></cross-domain-policy>\u0000";
    }
}
