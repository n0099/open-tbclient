package com.baidu.browser.core.permission;

import com.baidu.l.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class a {
    private static a afI = new a();
    private Map<Integer, a.InterfaceC0148a> afH = new HashMap();

    private a() {
    }

    public static a sI() {
        return afI;
    }

    public void a(int i, a.InterfaceC0148a interfaceC0148a) {
        if (this.afH != null) {
            synchronized (a.class) {
                if (this.afH.containsKey(Integer.valueOf(i))) {
                    this.afH.remove(Integer.valueOf(i));
                }
                this.afH.put(Integer.valueOf(i), interfaceC0148a);
            }
        }
    }

    public void bo(int i) {
        synchronized (a.class) {
            if (this.afH != null && this.afH.containsKey(Integer.valueOf(i))) {
                this.afH.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0148a bp(int i) {
        if (this.afH == null || !this.afH.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.afH.get(Integer.valueOf(i));
    }
}
