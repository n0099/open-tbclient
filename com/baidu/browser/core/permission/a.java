package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static a afg = new a();
    private Map<Integer, a.InterfaceC0250a> aff = new HashMap();

    private a() {
    }

    public static a tv() {
        return afg;
    }

    public void a(int i, a.InterfaceC0250a interfaceC0250a) {
        if (this.aff != null) {
            synchronized (a.class) {
                if (this.aff.containsKey(Integer.valueOf(i))) {
                    this.aff.remove(Integer.valueOf(i));
                }
                this.aff.put(Integer.valueOf(i), interfaceC0250a);
            }
        }
    }

    public void bm(int i) {
        synchronized (a.class) {
            if (this.aff != null && this.aff.containsKey(Integer.valueOf(i))) {
                this.aff.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0250a bn(int i) {
        if (this.aff == null || !this.aff.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aff.get(Integer.valueOf(i));
    }
}
