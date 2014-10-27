package com.baidu.adp.lib.stats;

import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private static m mo;
    private HashMap<String, n> mm = new HashMap<>();
    private HashMap<String, o> mn = new HashMap<>();

    public static m eB() {
        if (mo == null) {
            synchronized (BdStatSwitchData.class) {
                if (mo == null) {
                    mo = new m();
                }
            }
        }
        return mo;
    }

    public m() {
        o oVar = new o(this, null);
        oVar.L(3000);
        oVar.M(120000);
        oVar.N(500);
        this.mn.put("net", oVar);
        this.mn.put("op", oVar);
        this.mn.put("stat", oVar);
        o oVar2 = new o(this, null);
        oVar2.L(60000);
        oVar2.M(120000);
        oVar2.N(100);
        this.mn.put("file", oVar2);
        this.mn.put("db", oVar2);
        this.mn.put("img", oVar2);
        this.mn.put("voice", oVar2);
    }

    public boolean ak(String str) {
        o oVar = this.mn.get(str);
        if (oVar == null) {
            return false;
        }
        n nVar = this.mm.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (nVar == null) {
            nVar = new n(this, null);
            nVar.x(false);
            nVar.w(false);
            nVar.c(currentTimeMillis);
            this.mm.put(str, nVar);
        }
        if (nVar.eC()) {
            return true;
        }
        if (nVar.eG()) {
            nVar.K(nVar.eE() + 1);
            if (currentTimeMillis - nVar.eD() < oVar.eI()) {
                if (nVar.eE() >= oVar.eJ()) {
                    nVar.w(true);
                    f.er().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            nVar.x(false);
            nVar.K(0);
            nVar.c(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - nVar.eF() < oVar.eH()) {
            nVar.x(true);
            nVar.b(currentTimeMillis);
            return false;
        } else {
            nVar.c(currentTimeMillis);
            return false;
        }
    }
}
