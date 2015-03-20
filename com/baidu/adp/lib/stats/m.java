package com.baidu.adp.lib.stats;

import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class m {
    private static m xG;
    private HashMap<String, n> xE = new HashMap<>();
    private HashMap<String, o> xF = new HashMap<>();

    public static m ia() {
        if (xG == null) {
            synchronized (BdStatSwitchData.class) {
                if (xG == null) {
                    xG = new m();
                }
            }
        }
        return xG;
    }

    public m() {
        o oVar = new o(this, null);
        oVar.Z(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        oVar.aa(120000);
        oVar.ab(500);
        this.xF.put("net", oVar);
        this.xF.put("op", oVar);
        this.xF.put("stat", oVar);
        o oVar2 = new o(this, null);
        oVar2.Z(GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION);
        oVar2.aa(120000);
        oVar2.ab(100);
        this.xF.put("file", oVar2);
        this.xF.put("db", oVar2);
        this.xF.put("img", oVar2);
        this.xF.put("voice", oVar2);
    }

    public boolean av(String str) {
        o oVar = this.xF.get(str);
        if (oVar == null) {
            return false;
        }
        n nVar = this.xE.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (nVar == null) {
            nVar = new n(this, null);
            nVar.D(false);
            nVar.C(false);
            nVar.g(currentTimeMillis);
            this.xE.put(str, nVar);
        }
        if (nVar.ib()) {
            return true;
        }
        if (nVar.ig()) {
            nVar.Y(nVar.id() + 1);
            if (currentTimeMillis - nVar.ic() < oVar.ii()) {
                if (nVar.id() >= oVar.ij()) {
                    nVar.C(true);
                    f.hP().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            nVar.D(false);
            nVar.Y(0);
            nVar.g(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - nVar.ie() < oVar.ih()) {
            nVar.D(true);
            nVar.f(currentTimeMillis);
            return false;
        } else {
            nVar.g(currentTimeMillis);
            return false;
        }
    }
}
