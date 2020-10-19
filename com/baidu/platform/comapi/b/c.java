package com.baidu.platform.comapi.b;

import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private NALogStatistics f2820a;
    private ArrayList<b> b;

    /* loaded from: classes7.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f2821a = new c();
    }

    private c() {
        this.f2820a = null;
        this.b = new ArrayList<>();
        b();
    }

    public static c a() {
        return a.f2821a;
    }

    private boolean b() {
        if (this.f2820a == null) {
            this.f2820a = new NALogStatistics();
            return true;
        }
        return true;
    }

    public boolean a(int i, int i2, String str, String str2) {
        if (this.f2820a != null) {
            if (com.baidu.platform.comapi.b.f() || com.baidu.platform.comapi.b.h()) {
                a(new com.baidu.platform.comapi.b.a(i, i2, str, str2));
            }
            return this.f2820a.a(i, i2, SysOSUtil.getInstance().getNetType(), str, str2);
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
