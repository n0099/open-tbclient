package com.baidu.browser.core.permission;

import com.baidu.h.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a abU = new a();
    private Map<Integer, a.InterfaceC0100a> abT = new HashMap();

    private a() {
    }

    public static a rd() {
        return abU;
    }

    public void a(int i, a.InterfaceC0100a interfaceC0100a) {
        if (this.abT != null) {
            synchronized (a.class) {
                if (this.abT.containsKey(Integer.valueOf(i))) {
                    this.abT.remove(Integer.valueOf(i));
                }
                this.abT.put(Integer.valueOf(i), interfaceC0100a);
            }
        }
    }

    public void aU(int i) {
        synchronized (a.class) {
            if (this.abT != null && this.abT.containsKey(Integer.valueOf(i))) {
                this.abT.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0100a aV(int i) {
        if (this.abT == null || !this.abT.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.abT.get(Integer.valueOf(i));
    }
}
