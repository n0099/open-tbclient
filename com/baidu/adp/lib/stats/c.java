package com.baidu.adp.lib.stats;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public abstract class c extends f {
    protected String a;
    protected String b;
    protected boolean c;
    protected boolean d;
    private long t;

    public c(Context context, String str) {
        super(context, str);
        this.c = true;
        this.d = true;
        this.t = 0L;
    }

    @Override // com.baidu.adp.lib.stats.f
    public boolean a(boolean z) {
        return z || l();
    }

    public String a() {
        if (this.n == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.a);
            sb.append("Writing");
            sb.append(this.b);
            this.n = sb.toString();
        }
        return this.n;
    }

    public String b() {
        StringBuilder sb = new StringBuilder(40);
        sb.append(this.a);
        sb.append("Uploading");
        sb.append(System.currentTimeMillis());
        sb.append(this.b);
        return sb.toString();
    }

    @Override // com.baidu.adp.lib.stats.f
    public boolean b(boolean z) {
        boolean z2 = false;
        if (g()) {
            z2 = true;
        } else if (z && System.currentTimeMillis() - i() >= h.a().e()) {
            z2 = true;
        }
        if (z2) {
            d dVar = new d(this, this.o, this.n, this.o, b(), DiskFileOperate.Action.RENAME, this);
            dVar.e(this.c);
            if (this.d) {
                dVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                dVar.a(3);
            }
            dVar.p();
        }
        return true;
    }

    @Override // com.baidu.adp.lib.stats.f
    public void b(String str) {
        this.p = str;
        this.n = null;
    }

    @Override // com.baidu.adp.lib.stats.f
    public String c() {
        return "omp";
    }

    @Override // com.baidu.adp.lib.stats.f
    public boolean d() {
        return this.i > 5;
    }

    public void e() {
    }

    @Override // com.baidu.adp.lib.stats.f
    public void c(boolean z) {
        if (!d() && this.m > 0) {
            e eVar = new e(this, this.o, a(), DiskFileOperate.Action.APPEND, this, z);
            eVar.e(this.c);
            eVar.a(this.l.toString());
            n();
            if (this.d) {
                eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                eVar.a(3);
            }
            if (!com.baidu.adp.lib.Disk.d.a().b(eVar)) {
                this.i++;
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.f
    public ArrayList<String> f() {
        String name;
        ArrayList<String> arrayList = null;
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.o, null, DiskFileOperate.Action.INFO);
        diskFileOperate.e(this.c);
        if (this.d) {
            diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskFileOperate.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().a(diskFileOperate);
        File[] listFiles = diskFileOperate.n().listFiles();
        if (listFiles != null) {
            arrayList = new ArrayList<>();
            for (File file : listFiles) {
                if (file.isFile() && (name = file.getName()) != null && !name.equals(this.n) && name.endsWith(this.b) && name.startsWith(this.a)) {
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    protected boolean g() {
        if (this.m > this.h) {
            return true;
        }
        return !TextUtils.isEmpty(this.n) && this.t > 40960;
    }

    @Override // com.baidu.adp.lib.stats.f
    public void a(String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(this.o, str, DiskFileOperate.Action.DELETE);
        diskFileOperate.e(this.c);
        if (this.d) {
            diskFileOperate.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            diskFileOperate.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().a(diskFileOperate);
        this.r = System.currentTimeMillis();
    }

    @Override // com.baidu.adp.lib.stats.f
    public ArrayList<String> c(String str) {
        com.baidu.adp.lib.Disk.ops.e eVar = new com.baidu.adp.lib.Disk.ops.e(this.o, str, DiskFileOperate.Action.READ);
        eVar.e(this.c);
        if (this.d) {
            eVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            eVar.a(3);
        }
        com.baidu.adp.lib.Disk.d.a().a(eVar);
        if (eVar.g()) {
            String[] split = eVar.s().split(IOUtils.LINE_SEPARATOR_WINDOWS);
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str2 : split) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return null;
    }
}
