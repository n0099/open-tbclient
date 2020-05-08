package com.baidu.browser.core.permission;

import com.baidu.h.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a abX = new a();
    private Map<Integer, a.InterfaceC0121a> abW = new HashMap();

    private a() {
    }

    public static a rd() {
        return abX;
    }

    public void a(int i, a.InterfaceC0121a interfaceC0121a) {
        if (this.abW != null) {
            synchronized (a.class) {
                if (this.abW.containsKey(Integer.valueOf(i))) {
                    this.abW.remove(Integer.valueOf(i));
                }
                this.abW.put(Integer.valueOf(i), interfaceC0121a);
            }
        }
    }

    public void aU(int i) {
        synchronized (a.class) {
            if (this.abW != null && this.abW.containsKey(Integer.valueOf(i))) {
                this.abW.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0121a aV(int i) {
        if (this.abW == null || !this.abW.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.abW.get(Integer.valueOf(i));
    }
}
