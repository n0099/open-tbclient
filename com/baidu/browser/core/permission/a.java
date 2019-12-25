package com.baidu.browser.core.permission;

import com.baidu.k.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    private static a Im = new a();
    private Map<Integer, a.InterfaceC0072a> Il = new HashMap();

    private a() {
    }

    public static a mm() {
        return Im;
    }

    public void a(int i, a.InterfaceC0072a interfaceC0072a) {
        if (this.Il != null) {
            synchronized (a.class) {
                if (this.Il.containsKey(Integer.valueOf(i))) {
                    this.Il.remove(Integer.valueOf(i));
                }
                this.Il.put(Integer.valueOf(i), interfaceC0072a);
            }
        }
    }

    public void aF(int i) {
        synchronized (a.class) {
            if (this.Il != null && this.Il.containsKey(Integer.valueOf(i))) {
                this.Il.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0072a aG(int i) {
        if (this.Il == null || !this.Il.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.Il.get(Integer.valueOf(i));
    }
}
