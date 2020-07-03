package com.baidu.browser.core.permission;

import com.baidu.h.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a acU = new a();
    private Map<Integer, a.InterfaceC0127a> acT = new HashMap();

    private a() {
    }

    public static a rB() {
        return acU;
    }

    public void a(int i, a.InterfaceC0127a interfaceC0127a) {
        if (this.acT != null) {
            synchronized (a.class) {
                if (this.acT.containsKey(Integer.valueOf(i))) {
                    this.acT.remove(Integer.valueOf(i));
                }
                this.acT.put(Integer.valueOf(i), interfaceC0127a);
            }
        }
    }

    public void bb(int i) {
        synchronized (a.class) {
            if (this.acT != null && this.acT.containsKey(Integer.valueOf(i))) {
                this.acT.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0127a bc(int i) {
        if (this.acT == null || !this.acT.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.acT.get(Integer.valueOf(i));
    }
}
