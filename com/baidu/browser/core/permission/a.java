package com.baidu.browser.core.permission;

import com.baidu.e.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static a Vq = new a();
    private Map<Integer, a.InterfaceC0073a> Vp = new HashMap();

    private a() {
    }

    public static a qp() {
        return Vq;
    }

    public void a(int i, a.InterfaceC0073a interfaceC0073a) {
        if (this.Vp != null) {
            synchronized (a.class) {
                if (this.Vp.containsKey(Integer.valueOf(i))) {
                    this.Vp.remove(Integer.valueOf(i));
                }
                this.Vp.put(Integer.valueOf(i), interfaceC0073a);
            }
        }
    }

    public void bB(int i) {
        synchronized (a.class) {
            if (this.Vp != null && this.Vp.containsKey(Integer.valueOf(i))) {
                this.Vp.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0073a bC(int i) {
        if (this.Vp == null || !this.Vp.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.Vp.get(Integer.valueOf(i));
    }
}
