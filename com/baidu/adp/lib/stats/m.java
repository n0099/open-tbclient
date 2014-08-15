package com.baidu.adp.lib.stats;

import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private static m c;
    private HashMap<String, n> a = new HashMap<>();
    private HashMap<String, o> b = new HashMap<>();

    public static m a() {
        if (c == null) {
            synchronized (BdStatSwitchData.class) {
                if (c == null) {
                    c = new m();
                }
            }
        }
        return c;
    }

    public m() {
        o oVar = new o(this, null);
        oVar.a(3000);
        oVar.b(120000);
        oVar.c(500);
        this.b.put("net", oVar);
        this.b.put("op", oVar);
        this.b.put("stat", oVar);
        o oVar2 = new o(this, null);
        oVar2.a(60000);
        oVar2.b(120000);
        oVar2.c(100);
        this.b.put("file", oVar2);
        this.b.put("db", oVar2);
        this.b.put("img", oVar2);
        this.b.put("voice", oVar2);
    }

    public boolean a(String str) {
        o oVar = this.b.get(str);
        if (oVar == null) {
            return false;
        }
        n nVar = this.a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (nVar == null) {
            nVar = new n(this, null);
            nVar.b(false);
            nVar.a(false);
            nVar.b(currentTimeMillis);
            this.a.put(str, nVar);
        }
        if (nVar.a()) {
            return true;
        }
        if (nVar.e()) {
            nVar.a(nVar.c() + 1);
            if (currentTimeMillis - nVar.b() < oVar.b()) {
                if (nVar.c() >= oVar.c()) {
                    nVar.a(true);
                    f.c().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            nVar.b(false);
            nVar.a(0);
            nVar.b(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - nVar.d() < oVar.a()) {
            nVar.b(true);
            nVar.a(currentTimeMillis);
            return false;
        } else {
            nVar.b(currentTimeMillis);
            return false;
        }
    }
}
