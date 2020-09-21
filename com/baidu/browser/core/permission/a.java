package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static a aeO = new a();
    private Map<Integer, a.InterfaceC0209a> aeN = new HashMap();

    private a() {
    }

    public static a tv() {
        return aeO;
    }

    public void a(int i, a.InterfaceC0209a interfaceC0209a) {
        if (this.aeN != null) {
            synchronized (a.class) {
                if (this.aeN.containsKey(Integer.valueOf(i))) {
                    this.aeN.remove(Integer.valueOf(i));
                }
                this.aeN.put(Integer.valueOf(i), interfaceC0209a);
            }
        }
    }

    public void bm(int i) {
        synchronized (a.class) {
            if (this.aeN != null && this.aeN.containsKey(Integer.valueOf(i))) {
                this.aeN.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0209a bn(int i) {
        if (this.aeN == null || !this.aeN.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aeN.get(Integer.valueOf(i));
    }
}
