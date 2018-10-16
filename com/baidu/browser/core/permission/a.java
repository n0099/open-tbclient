package com.baidu.browser.core.permission;

import com.baidu.f.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    private static a Vf = new a();
    private Map<Integer, a.InterfaceC0073a> Ve = new HashMap();

    private a() {
    }

    public static a qo() {
        return Vf;
    }

    public void a(int i, a.InterfaceC0073a interfaceC0073a) {
        if (this.Ve != null) {
            synchronized (a.class) {
                if (this.Ve.containsKey(Integer.valueOf(i))) {
                    this.Ve.remove(Integer.valueOf(i));
                }
                this.Ve.put(Integer.valueOf(i), interfaceC0073a);
            }
        }
    }

    public void bm(int i) {
        synchronized (a.class) {
            if (this.Ve != null && this.Ve.containsKey(Integer.valueOf(i))) {
                this.Ve.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0073a bn(int i) {
        if (this.Ve == null || !this.Ve.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.Ve.get(Integer.valueOf(i));
    }
}
