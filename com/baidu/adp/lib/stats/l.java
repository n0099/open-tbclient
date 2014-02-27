package com.baidu.adp.lib.stats;

import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.switchs.SwitchKey;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class l {
    private static l c;
    private HashMap<String, m> a = new HashMap<>();
    private HashMap<String, n> b = new HashMap<>();

    public static l a() {
        if (c == null) {
            synchronized (BdStatSwitchData.class) {
                if (c == null) {
                    c = new l();
                }
            }
        }
        return c;
    }

    public l() {
        n nVar = new n(this, (byte) 0);
        nVar.a(3000);
        nVar.b(120000);
        nVar.c(SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE);
        this.b.put(com.baidu.loginshare.e.e, nVar);
        this.b.put("op", nVar);
        this.b.put("stat", nVar);
        n nVar2 = new n(this, (byte) 0);
        nVar2.a(60000);
        nVar2.b(120000);
        nVar2.c(10);
        this.b.put("file", nVar2);
        this.b.put("db", nVar2);
        this.b.put("img", nVar2);
        this.b.put(SwitchKey.VOICE, nVar2);
    }

    public final boolean a(String str) {
        n nVar = this.b.get(str);
        if (nVar == null) {
            return false;
        }
        m mVar = this.a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (mVar == null) {
            mVar = new m(this, (byte) 0);
            mVar.b(false);
            mVar.a(false);
            mVar.b(currentTimeMillis);
            this.a.put(str, mVar);
        }
        if (mVar.a()) {
            return true;
        }
        if (mVar.e()) {
            mVar.a(mVar.c() + 1);
            if (currentTimeMillis - mVar.b() < nVar.b()) {
                if (mVar.c() >= nVar.c()) {
                    mVar.a(true);
                    g.a().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            mVar.b(false);
            mVar.a(0);
        } else if (currentTimeMillis - mVar.d() < nVar.a()) {
            mVar.b(true);
            mVar.a(currentTimeMillis);
            return false;
        }
        mVar.b(currentTimeMillis);
        return false;
    }
}
