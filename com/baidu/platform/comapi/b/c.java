package com.baidu.platform.comapi.b;

import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes20.dex */
public class c {
    private NALogStatistics a;
    private ArrayList<b> b;

    /* loaded from: classes20.dex */
    private static class a {
        private static final c a = new c();
    }

    private c() {
        this.a = null;
        this.b = new ArrayList<>();
        b();
    }

    public static c a() {
        return a.a;
    }

    private boolean b() {
        if (this.a == null) {
            this.a = new NALogStatistics();
            return true;
        }
        return true;
    }

    public boolean a(int i, int i2, String str, String str2) {
        if (this.a != null) {
            if (com.baidu.platform.comapi.b.f() || com.baidu.platform.comapi.b.h()) {
                a(new com.baidu.platform.comapi.b.a(i, i2, str, str2));
            }
            return this.a.a(i, i2, SysOSUtil.getInstance().getNetType(), str, str2);
        }
        return false;
    }

    public boolean a(com.baidu.platform.comapi.b.a aVar) {
        if (this.b == null || this.b.isEmpty()) {
            return false;
        }
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        return false;
    }
}
