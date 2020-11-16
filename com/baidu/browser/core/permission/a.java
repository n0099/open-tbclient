package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a afl = new a();
    private Map<Integer, a.InterfaceC0248a> afk = new HashMap();

    private a() {
    }

    public static a tv() {
        return afl;
    }

    public void a(int i, a.InterfaceC0248a interfaceC0248a) {
        if (this.afk != null) {
            synchronized (a.class) {
                if (this.afk.containsKey(Integer.valueOf(i))) {
                    this.afk.remove(Integer.valueOf(i));
                }
                this.afk.put(Integer.valueOf(i), interfaceC0248a);
            }
        }
    }

    public void bm(int i) {
        synchronized (a.class) {
            if (this.afk != null && this.afk.containsKey(Integer.valueOf(i))) {
                this.afk.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0248a bn(int i) {
        if (this.afk == null || !this.afk.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.afk.get(Integer.valueOf(i));
    }
}
