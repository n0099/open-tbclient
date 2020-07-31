package com.baidu.browser.core.permission;

import com.baidu.i.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static a acP = new a();
    private Map<Integer, a.InterfaceC0153a> acO = new HashMap();

    private a() {
    }

    public static a rD() {
        return acP;
    }

    public void a(int i, a.InterfaceC0153a interfaceC0153a) {
        if (this.acO != null) {
            synchronized (a.class) {
                if (this.acO.containsKey(Integer.valueOf(i))) {
                    this.acO.remove(Integer.valueOf(i));
                }
                this.acO.put(Integer.valueOf(i), interfaceC0153a);
            }
        }
    }

    public void bd(int i) {
        synchronized (a.class) {
            if (this.acO != null && this.acO.containsKey(Integer.valueOf(i))) {
                this.acO.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0153a be(int i) {
        if (this.acO == null || !this.acO.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.acO.get(Integer.valueOf(i));
    }
}
