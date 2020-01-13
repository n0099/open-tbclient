package com.baidu.browser.core.permission;

import com.baidu.k.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static a Ir = new a();
    private Map<Integer, a.InterfaceC0072a> Iq = new HashMap();

    private a() {
    }

    public static a mm() {
        return Ir;
    }

    public void a(int i, a.InterfaceC0072a interfaceC0072a) {
        if (this.Iq != null) {
            synchronized (a.class) {
                if (this.Iq.containsKey(Integer.valueOf(i))) {
                    this.Iq.remove(Integer.valueOf(i));
                }
                this.Iq.put(Integer.valueOf(i), interfaceC0072a);
            }
        }
    }

    public void aF(int i) {
        synchronized (a.class) {
            if (this.Iq != null && this.Iq.containsKey(Integer.valueOf(i))) {
                this.Iq.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0072a aG(int i) {
        if (this.Iq == null || !this.Iq.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.Iq.get(Integer.valueOf(i));
    }
}
