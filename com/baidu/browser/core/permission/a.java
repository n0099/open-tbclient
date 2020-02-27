package com.baidu.browser.core.permission;

import com.baidu.k.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a IQ = new a();
    private Map<Integer, a.InterfaceC0078a> IP = new HashMap();

    private a() {
    }

    public static a mB() {
        return IQ;
    }

    public void a(int i, a.InterfaceC0078a interfaceC0078a) {
        if (this.IP != null) {
            synchronized (a.class) {
                if (this.IP.containsKey(Integer.valueOf(i))) {
                    this.IP.remove(Integer.valueOf(i));
                }
                this.IP.put(Integer.valueOf(i), interfaceC0078a);
            }
        }
    }

    public void aI(int i) {
        synchronized (a.class) {
            if (this.IP != null && this.IP.containsKey(Integer.valueOf(i))) {
                this.IP.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0078a aJ(int i) {
        if (this.IP == null || !this.IP.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.IP.get(Integer.valueOf(i));
    }
}
