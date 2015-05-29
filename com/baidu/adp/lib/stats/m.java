package com.baidu.adp.lib.stats;

import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private static m wJ;
    private HashMap<String, n> wH = new HashMap<>();
    private HashMap<String, o> wI = new HashMap<>();

    public static m hK() {
        if (wJ == null) {
            synchronized (BdStatSwitchData.class) {
                if (wJ == null) {
                    wJ = new m();
                }
            }
        }
        return wJ;
    }

    public m() {
        o oVar = new o(this, null);
        oVar.X(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        oVar.Y(120000);
        oVar.Z(500);
        this.wI.put("net", oVar);
        this.wI.put("op", oVar);
        this.wI.put("stat", oVar);
        o oVar2 = new o(this, null);
        oVar2.X(GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION);
        oVar2.Y(120000);
        oVar2.Z(100);
        this.wI.put("file", oVar2);
        this.wI.put("db", oVar2);
        this.wI.put("img", oVar2);
        this.wI.put("voice", oVar2);
    }

    public boolean aw(String str) {
        o oVar = this.wI.get(str);
        if (oVar == null) {
            return false;
        }
        n nVar = this.wH.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (nVar == null) {
            nVar = new n(this, null);
            nVar.C(false);
            nVar.B(false);
            nVar.g(currentTimeMillis);
            this.wH.put(str, nVar);
        }
        if (nVar.hL()) {
            return true;
        }
        if (nVar.hP()) {
            nVar.W(nVar.hN() + 1);
            if (currentTimeMillis - nVar.hM() < oVar.hR()) {
                if (nVar.hN() >= oVar.hS()) {
                    nVar.B(true);
                    f.hz().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            nVar.C(false);
            nVar.W(0);
            nVar.g(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - nVar.hO() < oVar.hQ()) {
            nVar.C(true);
            nVar.f(currentTimeMillis);
            return false;
        } else {
            nVar.g(currentTimeMillis);
            return false;
        }
    }
}
