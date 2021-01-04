package com.baidu.browser.core.permission;

import com.baidu.n.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a {
    private static a agH = new a();
    private Map<Integer, a.InterfaceC0277a> agG = new HashMap();

    private a() {
    }

    public static a sW() {
        return agH;
    }

    public void a(int i, a.InterfaceC0277a interfaceC0277a) {
        if (this.agG != null) {
            synchronized (a.class) {
                if (this.agG.containsKey(Integer.valueOf(i))) {
                    this.agG.remove(Integer.valueOf(i));
                }
                this.agG.put(Integer.valueOf(i), interfaceC0277a);
            }
        }
    }

    public void bq(int i) {
        synchronized (a.class) {
            if (this.agG != null && this.agG.containsKey(Integer.valueOf(i))) {
                this.agG.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0277a br(int i) {
        if (this.agG == null || !this.agG.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.agG.get(Integer.valueOf(i));
    }
}
