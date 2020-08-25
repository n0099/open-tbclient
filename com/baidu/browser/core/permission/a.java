package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class a {
    private static a aeu = new a();
    private Map<Integer, a.InterfaceC0210a> aet = new HashMap();

    private a() {
    }

    public static a tq() {
        return aeu;
    }

    public void a(int i, a.InterfaceC0210a interfaceC0210a) {
        if (this.aet != null) {
            synchronized (a.class) {
                if (this.aet.containsKey(Integer.valueOf(i))) {
                    this.aet.remove(Integer.valueOf(i));
                }
                this.aet.put(Integer.valueOf(i), interfaceC0210a);
            }
        }
    }

    public void bi(int i) {
        synchronized (a.class) {
            if (this.aet != null && this.aet.containsKey(Integer.valueOf(i))) {
                this.aet.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0210a bj(int i) {
        if (this.aet == null || !this.aet.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aet.get(Integer.valueOf(i));
    }
}
