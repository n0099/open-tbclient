package com.baidu.browser.core.permission;

import com.baidu.m.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class a {
    private static a afg = new a();
    private Map<Integer, a.InterfaceC0238a> aff = new HashMap();

    private a() {
    }

    public static a tv() {
        return afg;
    }

    public void a(int i, a.InterfaceC0238a interfaceC0238a) {
        if (this.aff != null) {
            synchronized (a.class) {
                if (this.aff.containsKey(Integer.valueOf(i))) {
                    this.aff.remove(Integer.valueOf(i));
                }
                this.aff.put(Integer.valueOf(i), interfaceC0238a);
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

    public a.InterfaceC0238a bn(int i) {
        if (this.aff == null || !this.aff.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aff.get(Integer.valueOf(i));
    }
}
