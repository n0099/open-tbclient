package com.baidu.browser.core.permission;

import com.baidu.n.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a {
    private static a agh = new a();
    private Map<Integer, a.InterfaceC0276a> agg = new HashMap();

    private a() {
    }

    public static a ty() {
        return agh;
    }

    public void a(int i, a.InterfaceC0276a interfaceC0276a) {
        if (this.agg != null) {
            synchronized (a.class) {
                if (this.agg.containsKey(Integer.valueOf(i))) {
                    this.agg.remove(Integer.valueOf(i));
                }
                this.agg.put(Integer.valueOf(i), interfaceC0276a);
            }
        }
    }

    public void bq(int i) {
        synchronized (a.class) {
            if (this.agg != null && this.agg.containsKey(Integer.valueOf(i))) {
                this.agg.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0276a br(int i) {
        if (this.agg == null || !this.agg.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.agg.get(Integer.valueOf(i));
    }
}
