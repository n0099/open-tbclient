package com.baidu.browser.core.permission;

import com.baidu.l.a.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes14.dex */
public class a {
    private static a ahb = new a();
    private Map<Integer, a.InterfaceC0154a> aha = new HashMap();

    private a() {
    }

    public static a sI() {
        return ahb;
    }

    public void a(int i, a.InterfaceC0154a interfaceC0154a) {
        if (this.aha != null) {
            synchronized (a.class) {
                if (this.aha.containsKey(Integer.valueOf(i))) {
                    this.aha.remove(Integer.valueOf(i));
                }
                this.aha.put(Integer.valueOf(i), interfaceC0154a);
            }
        }
    }

    public void bp(int i) {
        synchronized (a.class) {
            if (this.aha != null && this.aha.containsKey(Integer.valueOf(i))) {
                this.aha.remove(Integer.valueOf(i));
            }
        }
    }

    public a.InterfaceC0154a bq(int i) {
        if (this.aha == null || !this.aha.containsKey(Integer.valueOf(i))) {
            return null;
        }
        return this.aha.get(Integer.valueOf(i));
    }
}
