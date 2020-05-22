package com.baidu.browser.core.permission;

import com.baidu.h.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a acp = new a();
    private Map<Integer, a.InterfaceC0125a> aco = new HashMap();

    private a() {
    }

    public static a rk() {
        return acp;
    }

    public void a(int i, a.InterfaceC0125a interfaceC0125a) {
        if (this.aco != null) {
            synchronized (a.class) {
                if (this.aco.containsKey(Integer.valueOf(i))) {
                    this.aco.remove(Integer.valueOf(i));
                }
                this.aco.put(Integer.valueOf(i), interfaceC0125a);
            }
        }
    }

    public void aV(int i) {
        synchronized (a.class) {
            if (this.aco != null && this.aco.containsKey(Integer.valueOf(i))) {
                this.aco.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0125a aW(int i) {
        if (this.aco == null || !this.aco.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aco.get(Integer.valueOf(i));
    }
}
