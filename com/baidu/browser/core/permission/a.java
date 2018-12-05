package com.baidu.browser.core.permission;

import com.baidu.e.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static a Vh = new a();
    private Map<Integer, a.InterfaceC0073a> Vg = new HashMap();

    private a() {
    }

    public static a ql() {
        return Vh;
    }

    public void a(int i, a.InterfaceC0073a interfaceC0073a) {
        if (this.Vg != null) {
            synchronized (a.class) {
                if (this.Vg.containsKey(Integer.valueOf(i))) {
                    this.Vg.remove(Integer.valueOf(i));
                }
                this.Vg.put(Integer.valueOf(i), interfaceC0073a);
            }
        }
    }

    public void bB(int i) {
        synchronized (a.class) {
            if (this.Vg != null && this.Vg.containsKey(Integer.valueOf(i))) {
                this.Vg.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0073a bC(int i) {
        if (this.Vg == null || !this.Vg.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.Vg.get(Integer.valueOf(i));
    }
}
