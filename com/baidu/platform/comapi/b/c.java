package com.baidu.platform.comapi.b;

import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private NALogStatistics f4188a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<b> f4189b;

    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f4190a = new c();
    }

    private c() {
        this.f4188a = null;
        this.f4189b = new ArrayList<>();
        b();
    }

    public static c a() {
        return a.f4190a;
    }

    private boolean b() {
        if (this.f4188a == null) {
            this.f4188a = new NALogStatistics();
            return true;
        }
        return true;
    }

    public boolean a(int i, int i2, String str, String str2) {
        if (this.f4188a != null) {
            if (com.baidu.platform.comapi.b.f() || com.baidu.platform.comapi.b.h()) {
                a(new com.baidu.platform.comapi.b.a(i, i2, str, str2));
            }
            return this.f4188a.a(i, i2, SysOSUtil.getInstance().getNetType(), str, str2);
        }
        return false;
    }

    public boolean a(com.baidu.platform.comapi.b.a aVar) {
        if (this.f4189b == null || this.f4189b.isEmpty()) {
            return false;
        }
        Iterator<b> it = this.f4189b.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        return false;
    }
}
