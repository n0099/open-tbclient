package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static a aff = new a();
    private Map<Integer, a.InterfaceC0224a> afe = new HashMap();

    private a() {
    }

    public static a tv() {
        return aff;
    }

    public void a(int i, a.InterfaceC0224a interfaceC0224a) {
        if (this.afe != null) {
            synchronized (a.class) {
                if (this.afe.containsKey(Integer.valueOf(i))) {
                    this.afe.remove(Integer.valueOf(i));
                }
                this.afe.put(Integer.valueOf(i), interfaceC0224a);
            }
        }
    }

    public void bm(int i) {
        synchronized (a.class) {
            if (this.afe != null && this.afe.containsKey(Integer.valueOf(i))) {
                this.afe.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0224a bn(int i) {
        if (this.afe == null || !this.afe.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.afe.get(Integer.valueOf(i));
    }
}
