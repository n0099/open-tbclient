package com.baidu.adp.lib.stats;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.switchs.SwitchKey;
import java.util.HashMap;
/* loaded from: classes.dex */
public class o {
    private static o c;
    private HashMap<String, q> a = new HashMap<>();
    private HashMap<String, r> b = new HashMap<>();

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
        r rVar = new r(this);
        rVar.a(3000);
        rVar.b(120000);
        rVar.c(SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE);
        this.b.put(com.baidu.loginshare.e.e, rVar);
        this.b.put("op", rVar);
        this.b.put("stat", rVar);
        r rVar2 = new r(this);
        rVar2.a(60000);
        rVar2.b(120000);
        rVar2.c(10);
        this.b.put("file", rVar2);
        this.b.put("db", rVar2);
        this.b.put("img", rVar2);
        this.b.put(SwitchKey.VOICE, rVar2);
    }

    public boolean a(String str) {
        r rVar = this.b.get(str);
        if (rVar == null) {
            return false;
        }
        q qVar = this.a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (qVar == null) {
            qVar = new q(this);
            qVar.b(false);
            qVar.a(false);
            qVar.b(currentTimeMillis);
            this.a.put(str, qVar);
        }
        if (qVar.a()) {
            return true;
        }
        if (qVar.e()) {
            qVar.a(qVar.c() + 1);
            if (currentTimeMillis - qVar.b() < rVar.b()) {
                if (qVar.c() >= rVar.c()) {
                    qVar.a(true);
                    h.a().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            qVar.b(false);
            qVar.a(0);
            qVar.b(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - qVar.d() < rVar.a()) {
            qVar.b(true);
            qVar.a(currentTimeMillis);
            return false;
        } else {
            qVar.b(currentTimeMillis);
            return false;
        }
    }
}
