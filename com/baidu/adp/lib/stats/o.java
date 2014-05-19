package com.baidu.adp.lib.stats;

import com.baidu.kirin.KirinConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    private static o c;
    private HashMap<String, p> a = new HashMap<>();
    private HashMap<String, q> b = new HashMap<>();

    public static o a() {
        if (c == null) {
            synchronized (BdStatSwitchData.class) {
                if (c == null) {
                    c = new o();
                }
            }
        }
        return c;
    }

    public o() {
        q qVar = new q(this, null);
        qVar.a(KirinConfig.CONNECT_TIME_OUT);
        qVar.b(120000);
        qVar.c(500);
        this.b.put("net", qVar);
        this.b.put("op", qVar);
        this.b.put("stat", qVar);
        q qVar2 = new q(this, null);
        qVar2.a(60000);
        qVar2.b(120000);
        qVar2.c(100);
        this.b.put("file", qVar2);
        this.b.put("db", qVar2);
        this.b.put("img", qVar2);
        this.b.put("voice", qVar2);
    }

    public boolean a(String str) {
        q qVar = this.b.get(str);
        if (qVar == null) {
            return false;
        }
        p pVar = this.a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (pVar == null) {
            pVar = new p(this, null);
            pVar.b(false);
            pVar.a(false);
            pVar.b(currentTimeMillis);
            this.a.put(str, pVar);
        }
        if (pVar.a()) {
            return true;
        }
        if (pVar.e()) {
            pVar.a(pVar.c() + 1);
            if (currentTimeMillis - pVar.b() < qVar.b()) {
                if (pVar.c() >= qVar.c()) {
                    pVar.a(true);
                    h.a().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            pVar.b(false);
            pVar.a(0);
            pVar.b(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - pVar.d() < qVar.a()) {
            pVar.b(true);
            pVar.a(currentTimeMillis);
            return false;
        } else {
            pVar.b(currentTimeMillis);
            return false;
        }
    }
}
