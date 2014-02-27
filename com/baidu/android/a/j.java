package com.baidu.android.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class j {
    private static j l = null;
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = true;
    private boolean g = false;
    private boolean h = true;
    private int i = 3;
    private int j = 24;
    private HashMap k = new HashMap();

    private j(Context context) {
        b(context);
    }

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (l == null) {
                l = new j(context);
            }
            jVar = l;
        }
        return jVar;
    }

    private void b(Context context) {
        ArrayList a = o.a(context.getApplicationContext()).a(1);
        if (a == null || a.size() == 0) {
            return;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            this.k.put(kVar.a(), kVar.b());
        }
        com.baidu.android.moplus.util.b.b(context, e());
        com.baidu.android.moplus.util.b.d(context, g());
    }

    public static void k() {
        if (l != null) {
            l.k = null;
            l = null;
        }
    }

    private void l() {
        this.k = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean a() {
        if (com.baidu.android.systemmonitor.c.a.f() != -1) {
            return com.baidu.android.systemmonitor.c.a.f() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("tjenable"))) {
            return Boolean.parseBoolean((String) this.k.get("tjenable"));
        }
        return this.a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean b() {
        if (com.baidu.android.systemmonitor.c.a.g() != -1) {
            return com.baidu.android.systemmonitor.c.a.g() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("devicetjenable"))) {
            return Boolean.parseBoolean((String) this.k.get("devicetjenable"));
        }
        return this.b;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean c() {
        if (com.baidu.android.systemmonitor.c.a.h() != -1) {
            return com.baidu.android.systemmonitor.c.a.h() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("networktjenable"))) {
            return Boolean.parseBoolean((String) this.k.get("networktjenable"));
        }
        return this.c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean d() {
        if (com.baidu.android.systemmonitor.c.a.i() != -1) {
            return com.baidu.android.systemmonitor.c.a.i() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("downloadtjenable"))) {
            return Boolean.parseBoolean((String) this.k.get("downloadtjenable"));
        }
        return this.d;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean e() {
        if (com.baidu.android.systemmonitor.c.a.b() != -1) {
            return com.baidu.android.systemmonitor.c.a.b() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("localserverenable"))) {
            return Boolean.parseBoolean((String) this.k.get("localserverenable"));
        }
        return this.f;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean f() {
        if (com.baidu.android.systemmonitor.c.a.n() != -1) {
            return com.baidu.android.systemmonitor.c.a.n() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("applist_tjenable"))) {
            return Boolean.parseBoolean((String) this.k.get("applist_tjenable"));
        }
        return this.g;
    }

    public final boolean g() {
        try {
            if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("moplus_enable"))) {
                return Boolean.parseBoolean((String) this.k.get("moplus_enable"));
            }
        } catch (Exception e) {
        }
        return this.h;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0035 -> B:7:0x000e). Please submit an issue!!! */
    public final boolean h() {
        if (com.baidu.android.systemmonitor.c.a.a() != -1) {
            return com.baidu.android.systemmonitor.c.a.a() == 1;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("pushenable"))) {
            return Boolean.parseBoolean((String) this.k.get("pushenable"));
        }
        return this.e;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0036 -> B:6:0x0010). Please submit an issue!!! */
    public final long i() {
        if (com.baidu.android.systemmonitor.c.a.c() != -1) {
            return com.baidu.android.systemmonitor.c.a.c() * 86400000;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("tj_data_remain_time"))) {
            return Long.parseLong((String) this.k.get("tj_data_remain_time")) * 86400000;
        }
        return this.i * 86400000;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0039 -> B:6:0x0013). Please submit an issue!!! */
    public final long j() {
        long j = 3600000;
        if (com.baidu.android.systemmonitor.c.a.d() != -1) {
            j = 60000;
            return com.baidu.android.systemmonitor.c.a.d() * 60000;
        }
        if (this.k != null && !TextUtils.isEmpty((CharSequence) this.k.get("tj_data_upload_interval"))) {
            return Long.parseLong((String) this.k.get("tj_data_upload_interval")) * 3600000;
        }
        return this.j * j;
    }
}
