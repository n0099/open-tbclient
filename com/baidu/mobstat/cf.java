package com.baidu.mobstat;

import com.baidu.mobstat.cw;
import java.net.InetSocketAddress;
/* loaded from: classes2.dex */
public abstract class cf implements ch {
    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, cw cwVar) {
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, cy cyVar) throws cn {
    }

    @Override // com.baidu.mobstat.ch
    public void a(ce ceVar, cy cyVar, df dfVar) throws cn {
    }

    @Override // com.baidu.mobstat.ch
    public void c(ce ceVar, cw cwVar) {
    }

    @Override // com.baidu.mobstat.ch
    public String a(ce ceVar) throws cn {
        InetSocketAddress a = ceVar.a();
        if (a != null) {
            return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + a.getPort() + "\" /></cross-domain-policy>\u0000";
        }
        throw new cp("socket not bound");
    }

    @Override // com.baidu.mobstat.ch
    public void b(ce ceVar, cw cwVar) {
        cx cxVar = new cx(cwVar);
        cxVar.a(cw.a.PONG);
        ceVar.a(cxVar);
    }
}
