package com.baidu.browser.core.permission;

import com.baidu.l.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    private static a afP = new a();
    private Map<Integer, a.InterfaceC0148a> afO = new HashMap();

    private a() {
    }

    public static a sL() {
        return afP;
    }

    public void a(int i, a.InterfaceC0148a interfaceC0148a) {
        if (this.afO != null) {
            synchronized (a.class) {
                if (this.afO.containsKey(Integer.valueOf(i))) {
                    this.afO.remove(Integer.valueOf(i));
                }
                this.afO.put(Integer.valueOf(i), interfaceC0148a);
            }
        }
    }

    public void bo(int i) {
        synchronized (a.class) {
            if (this.afO != null && this.afO.containsKey(Integer.valueOf(i))) {
                this.afO.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0148a bp(int i) {
        if (this.afO == null || !this.afO.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.afO.get(Integer.valueOf(i));
    }
}
