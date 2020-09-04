package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class a {
    private static a aew = new a();
    private Map<Integer, a.InterfaceC0210a> aev = new HashMap();

    private a() {
    }

    public static a tq() {
        return aew;
    }

    public void a(int i, a.InterfaceC0210a interfaceC0210a) {
        if (this.aev != null) {
            synchronized (a.class) {
                if (this.aev.containsKey(Integer.valueOf(i))) {
                    this.aev.remove(Integer.valueOf(i));
                }
                this.aev.put(Integer.valueOf(i), interfaceC0210a);
            }
        }
    }

    public void bi(int i) {
        synchronized (a.class) {
            if (this.aev != null && this.aev.containsKey(Integer.valueOf(i))) {
                this.aev.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0210a bj(int i) {
        if (this.aev == null || !this.aev.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aev.get(Integer.valueOf(i));
    }
}
