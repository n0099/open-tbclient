package com.baidu.adp.lib.stats;

import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private static m mr;
    private HashMap<String, n> mp = new HashMap<>();
    private HashMap<String, o> mq = new HashMap<>();

    public static m eA() {
        if (mr == null) {
            synchronized (BdStatSwitchData.class) {
                if (mr == null) {
                    mr = new m();
                }
            }
        }
        return mr;
    }

    public m() {
        o oVar = new o(this, null);
        oVar.Y(3000);
        oVar.Z(120000);
        oVar.aa(500);
        this.mq.put("net", oVar);
        this.mq.put("op", oVar);
        this.mq.put("stat", oVar);
        o oVar2 = new o(this, null);
        oVar2.Y(GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION);
        oVar2.Z(120000);
        oVar2.aa(100);
        this.mq.put("file", oVar2);
        this.mq.put("db", oVar2);
        this.mq.put("img", oVar2);
        this.mq.put("voice", oVar2);
    }

    public boolean ao(String str) {
        o oVar = this.mq.get(str);
        if (oVar == null) {
            return false;
        }
        n nVar = this.mp.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (nVar == null) {
            nVar = new n(this, null);
            nVar.D(false);
            nVar.C(false);
            nVar.g(currentTimeMillis);
            this.mp.put(str, nVar);
        }
        if (nVar.eB()) {
            return true;
        }
        if (nVar.eF()) {
            nVar.X(nVar.eD() + 1);
            if (currentTimeMillis - nVar.eC() < oVar.eH()) {
                if (nVar.eD() >= oVar.eI()) {
                    nVar.C(true);
                    f.eq().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            nVar.D(false);
            nVar.X(0);
            nVar.g(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - nVar.eE() < oVar.eG()) {
            nVar.D(true);
            nVar.f(currentTimeMillis);
            return false;
        } else {
            nVar.g(currentTimeMillis);
            return false;
        }
    }
}
