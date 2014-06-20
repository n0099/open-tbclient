package com.baidu.android.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class s {
    private static s o = null;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = true;
    private boolean i = false;
    private boolean j = true;
    private int k = 3;
    private int l = 24;
    private String m = "";
    private HashMap n = new HashMap();
    boolean a = false;

    private s(Context context) {
        b(context);
    }

    public static synchronized s a(Context context) {
        s sVar;
        synchronized (s.class) {
            if (o == null) {
                o = new s(context);
            }
            sVar = o;
        }
        return sVar;
    }

    private void b(Context context) {
        ArrayList a = h.a(context.getApplicationContext()).a(1);
        if (a == null || a.size() == 0) {
            return;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            this.n.put(eVar.a(), eVar.b());
        }
        com.baidu.android.moplus.util.a.b(context, e());
        com.baidu.android.moplus.util.a.d(context, g());
    }

    public static void n() {
        if (o != null) {
            o.o();
            o = null;
        }
    }

    private void o() {
        this.n = null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean a() {
        if (com.baidu.android.systemmonitor.util.a.f() != -1) {
            return com.baidu.android.systemmonitor.util.a.f() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("tjenable"))) {
            return Boolean.parseBoolean((String) this.n.get("tjenable"));
        }
        return this.b;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean b() {
        if (com.baidu.android.systemmonitor.util.a.g() != -1) {
            return com.baidu.android.systemmonitor.util.a.g() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("devicetjenable"))) {
            return Boolean.parseBoolean((String) this.n.get("devicetjenable"));
        }
        return this.c;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean c() {
        if (com.baidu.android.systemmonitor.util.a.h() != -1) {
            return com.baidu.android.systemmonitor.util.a.h() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("networktjenable"))) {
            return Boolean.parseBoolean((String) this.n.get("networktjenable"));
        }
        return this.d;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean d() {
        if (com.baidu.android.systemmonitor.util.a.i() != -1) {
            return com.baidu.android.systemmonitor.util.a.i() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("downloadtjenable"))) {
            return Boolean.parseBoolean((String) this.n.get("downloadtjenable"));
        }
        return this.e;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean e() {
        if (com.baidu.android.systemmonitor.util.a.b() != -1) {
            return com.baidu.android.systemmonitor.util.a.b() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("localserverenable"))) {
            return Boolean.parseBoolean((String) this.n.get("localserverenable"));
        }
        return this.h;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean f() {
        if (com.baidu.android.systemmonitor.util.a.n() != -1) {
            return com.baidu.android.systemmonitor.util.a.n() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("applist_tjenable"))) {
            return Boolean.parseBoolean((String) this.n.get("applist_tjenable"));
        }
        return this.i;
    }

    public boolean g() {
        try {
            if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("moplus_enable"))) {
                return Boolean.parseBoolean((String) this.n.get("moplus_enable"));
            }
        } catch (Exception e) {
        }
        return this.j;
    }

    public String h() {
        try {
            if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("moplus_from_control"))) {
                return (String) this.n.get("moplus_from_control");
            }
        } catch (Exception e) {
        }
        return this.m;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:7:0x000e). Please submit an issue!!! */
    public boolean i() {
        if (com.baidu.android.systemmonitor.util.a.a() != -1) {
            return com.baidu.android.systemmonitor.util.a.a() == 1;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("secretenable"))) {
            return Boolean.parseBoolean((String) this.n.get("secretenable"));
        }
        return this.g;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0038 -> B:6:0x0010). Please submit an issue!!! */
    public long j() {
        if (com.baidu.android.systemmonitor.util.a.c() != -1) {
            return com.baidu.android.systemmonitor.util.a.c() * 86400000;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("tj_data_remain_time"))) {
            return Long.parseLong((String) this.n.get("tj_data_remain_time")) * 86400000;
        }
        return this.k * 86400000;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003b -> B:6:0x0013). Please submit an issue!!! */
    public long k() {
        long j = 3600000;
        if (com.baidu.android.systemmonitor.util.a.d() != -1) {
            j = TbConfig.USE_TIME_INTERVAL;
            return com.baidu.android.systemmonitor.util.a.d() * TbConfig.USE_TIME_INTERVAL;
        }
        if (this.n != null && !TextUtils.isEmpty((CharSequence) this.n.get("tj_data_upload_interval"))) {
            return Long.parseLong((String) this.n.get("tj_data_upload_interval")) * 3600000;
        }
        return this.l * j;
    }

    public void l() {
        this.a = true;
    }

    public void m() {
        this.a = false;
    }
}
