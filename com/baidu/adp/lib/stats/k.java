package com.baidu.adp.lib.stats;

import com.baidu.kirin.KirinConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class k {
    private static k c;
    private HashMap<String, l> a = new HashMap<>();
    private HashMap<String, m> b = new HashMap<>();

    public static k a() {
        if (c == null) {
            synchronized (BdStatSwitchData.class) {
                if (c == null) {
                    c = new k();
                }
            }
        }
        return c;
    }

    public k() {
        m mVar = new m(this, null);
        mVar.a(KirinConfig.CONNECT_TIME_OUT);
        mVar.b(120000);
        mVar.c(500);
        this.b.put("net", mVar);
        this.b.put("op", mVar);
        this.b.put("stat", mVar);
        m mVar2 = new m(this, null);
        mVar2.a(60000);
        mVar2.b(120000);
        mVar2.c(100);
        this.b.put("file", mVar2);
        this.b.put("db", mVar2);
        this.b.put("img", mVar2);
        this.b.put("voice", mVar2);
    }

    public boolean a(String str) {
        m mVar = this.b.get(str);
        if (mVar == null) {
            return false;
        }
        l lVar = this.a.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (lVar == null) {
            lVar = new l(this, null);
            lVar.b(false);
            lVar.a(false);
            lVar.b(currentTimeMillis);
            this.a.put(str, lVar);
        }
        if (lVar.a()) {
            return true;
        }
        if (lVar.e()) {
            lVar.a(lVar.c() + 1);
            if (currentTimeMillis - lVar.b() < mVar.b()) {
                if (lVar.c() >= mVar.c()) {
                    lVar.a(true);
                    d.b().a(false, "d", "logfast", null, null, 0L, 99999, str, new Object[0]);
                    return true;
                }
                return false;
            }
            lVar.b(false);
            lVar.a(0);
            lVar.b(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - lVar.d() < mVar.a()) {
            lVar.b(true);
            lVar.a(currentTimeMillis);
            return false;
        } else {
            lVar.b(currentTimeMillis);
            return false;
        }
    }
}
