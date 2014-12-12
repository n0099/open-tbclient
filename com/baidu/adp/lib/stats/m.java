package com.baidu.adp.lib.stats;

import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private static m mo;
    private HashMap<String, n> mm = new HashMap<>();
    private HashMap<String, o> mn = new HashMap<>();

    public static m eC() {
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
        oVar.T(3000);
        oVar.U(120000);
        oVar.V(500);
        this.mn.put("net", oVar);
        this.mn.put("op", oVar);
        this.mn.put("stat", oVar);
        o oVar2 = new o(this, null);
        oVar2.T(GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION);
        oVar2.U(120000);
        oVar2.V(100);
        this.mn.put("file", oVar2);
        this.mn.put("db", oVar2);
        this.mn.put("img", oVar2);
        this.mn.put("voice", oVar2);
    }

    public boolean ao(String str) {
        o oVar = this.mn.get(str);
        if (oVar == null) {
            return false;
        }
        n nVar = this.mm.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (nVar == null) {
            nVar = new n(this, null);
            nVar.D(false);
            nVar.C(false);
            nVar.g(currentTimeMillis);
            this.mm.put(str, nVar);
        }
        if (nVar.eD()) {
            return true;
        }
        if (nVar.eH()) {
            nVar.S(nVar.eF() + 1);
            if (currentTimeMillis - nVar.eE() < oVar.eJ()) {
                if (nVar.eF() >= oVar.eK()) {
                    nVar.C(true);
                    f.es().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            nVar.D(false);
            nVar.S(0);
            nVar.g(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - nVar.eG() < oVar.eI()) {
            nVar.D(true);
            nVar.f(currentTimeMillis);
            return false;
        } else {
            nVar.g(currentTimeMillis);
            return false;
        }
    }
}
