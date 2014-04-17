package com.baidu.tbadk.core.util.a;

import android.os.Build;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.n;
import com.baidu.tbadk.core.util.z;
/* loaded from: classes.dex */
public final class b {
    private final f i = new f();
    public boolean a = false;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public String f = q.a();
    public boolean g = false;
    public int h = 0;

    public final f a() {
        return this.i;
    }

    public final void a(z zVar) {
        String D = TbadkApplication.D();
        if (D != null && this.c) {
            zVar.a("BDUSS", D);
        }
    }

    public final void b(z zVar) {
        zVar.a("_client_type", "2");
        if (!TbadkApplication.j().G()) {
            zVar.a("apid", "sw");
        }
        zVar.a("_client_version", n.c());
        if (TbadkApplication.j().C() != null) {
            zVar.a("_phone_imei", TbadkApplication.j().C());
        }
        String B = TbadkApplication.B();
        if (B != null) {
            zVar.a("_client_id", B);
        }
        String I = TbadkApplication.I();
        if (I != null && I.length() > 0) {
            zVar.a("from", I);
        }
        String a = g.a();
        if (a != null) {
            String c = com.baidu.tbadk.coreExtra.a.a.a().c();
            if ("3".equalsIgnoreCase(a)) {
                if (TbadkApplication.j().P() == 1) {
                    c = String.valueOf(c) + "ka=open";
                }
            } else if (TbadkApplication.j().Q() == 1) {
                c = String.valueOf(c) + "ka=open";
            }
            com.baidu.adp.lib.network.willdelete.e.a();
            com.baidu.adp.lib.network.willdelete.b.b = c;
        }
        if (this.a) {
            TbadkApplication.j();
            zVar.a("tbs", TbadkApplication.A());
        }
        String z = TbadkApplication.j().z();
        if (z != null) {
            zVar.a("cuid", z);
        }
        zVar.a("timestamp", Long.toString(System.currentTimeMillis()));
        zVar.a("model", Build.MODEL);
    }

    public final String b() {
        if (this.i.a == null) {
            return null;
        }
        String str = n.a;
        if (this.i.a.startsWith(str)) {
            int indexOf = this.i.a.indexOf(63);
            if (indexOf < 0) {
                indexOf = this.i.a.length();
            }
            return this.i.a.substring(str.length(), indexOf);
        }
        return this.i.a;
    }
}
