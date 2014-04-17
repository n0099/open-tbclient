package com.baidu.adp.lib.stats;

import com.baidu.tieba.switchs.features.VoiceSwitchStatic;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class n {
    private static n c;
    private HashMap<String, o> a = new HashMap<>();
    private HashMap<String, p> b = new HashMap<>();

    public static n a() {
        if (c == null) {
            synchronized (BdStatSwitchData.class) {
                if (c == null) {
                    c = new n();
                }
            }
        }
        return c;
    }

    public n() {
        p pVar = new p(this, (byte) 0);
        pVar.a(3000);
        pVar.b(120000);
        pVar.c(500);
        this.b.put(com.baidu.loginshare.e.e, pVar);
        this.b.put("op", pVar);
        this.b.put("stat", pVar);
        p pVar2 = new p(this, (byte) 0);
        pVar2.a(60000);
        pVar2.b(120000);
        pVar2.c(100);
        this.b.put("file", pVar2);
        this.b.put("db", pVar2);
        this.b.put("img", pVar2);
        this.b.put(VoiceSwitchStatic.VOICE, pVar2);
    }

    public final boolean a(String str) {
        p pVar = this.b.get(str);
        if (pVar == null) {
            return false;
        }
        o oVar = this.a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (oVar == null) {
            oVar = new o(this, (byte) 0);
            oVar.b(false);
            oVar.a(false);
            oVar.b(currentTimeMillis);
            this.a.put(str, oVar);
        }
        if (oVar.a()) {
            return true;
        }
        if (oVar.e()) {
            oVar.a(oVar.c() + 1);
            if (currentTimeMillis - oVar.b() < pVar.b()) {
                if (oVar.c() >= pVar.c()) {
                    oVar.a(true);
                    i.a().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            oVar.b(false);
            oVar.a(0);
        } else if (currentTimeMillis - oVar.d() < pVar.a()) {
            oVar.b(true);
            oVar.a(currentTimeMillis);
            return false;
        }
        oVar.b(currentTimeMillis);
        return false;
    }
}
