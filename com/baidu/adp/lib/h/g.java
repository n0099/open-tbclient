package com.baidu.adp.lib.h;

import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class g {
    private static g xG;
    private HashMap<String, h> wH = new HashMap<>();
    private HashMap<String, i> wI = new HashMap<>();

    public static g iI() {
        if (xG == null) {
            synchronized (g.class) {
                if (xG == null) {
                    xG = new g();
                }
            }
        }
        return xG;
    }

    public g() {
        i iVar = new i(this, null);
        iVar.X(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        iVar.Y(120000);
        iVar.Z(500);
        this.wI.put("net", iVar);
        this.wI.put("op", iVar);
        this.wI.put("stat", iVar);
        this.wI.put("crash", iVar);
        this.wI.put("pfmonitor", iVar);
        i iVar2 = new i(this, null);
        iVar2.X(GroupInfoActivityConfig.JOIN_BUTTON_DISABLE_MAX_DURATION);
        iVar2.Y(120000);
        iVar2.Z(100);
        this.wI.put("file", iVar2);
        this.wI.put("db", iVar2);
        this.wI.put("img", iVar2);
        this.wI.put("voice", iVar2);
        this.wI.put("error", iVar2);
        i iVar3 = new i(this, null);
        iVar3.X(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        iVar3.Y(120000);
        iVar3.Z(1500);
        this.wI.put("dbg", iVar3);
    }

    public boolean aw(String str) {
        i iVar = this.wI.get(str);
        if (iVar == null) {
            return false;
        }
        h hVar = this.wH.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (hVar == null) {
            hVar = new h(this, null);
            hVar.C(false);
            hVar.B(false);
            hVar.g(currentTimeMillis);
            this.wH.put(str, hVar);
        }
        if (hVar.hL()) {
            return true;
        }
        if (hVar.hP()) {
            hVar.W(hVar.hN() + 1);
            if (currentTimeMillis - hVar.hM() < iVar.hR()) {
                if (hVar.hN() >= iVar.hS()) {
                    hVar.B(true);
                    a.iB().a(false, "d", "logfast", -1L, null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            hVar.C(false);
            hVar.W(0);
            hVar.g(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - hVar.hO() < iVar.hQ()) {
            hVar.C(true);
            hVar.f(currentTimeMillis);
            return false;
        } else {
            hVar.g(currentTimeMillis);
            return false;
        }
    }
}
