package com.baidu.tbadk.core.util.c;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ao;
import java.io.File;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.f.e<a> {
    private final n ajr = new n();

    @Override // com.baidu.adp.lib.f.e
    public boolean fM() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public a b(String str, String str2, Object... objArr) {
        return null;
    }

    private void wd() {
        b bVar = new b(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bVar.t(true);
        com.baidu.adp.lib.Disk.d.dH().b(bVar);
    }

    private DiskFileOperate a(com.baidu.adp.widget.a.a aVar, String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, ao.dX(str), DiskFileOperate.Action.WRITE_FORCE);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.t(true);
        diskFileOperate.setData(aVar.kP());
        return diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        wd();
        com.baidu.adp.widget.a.a a2 = this.ajr.a(str, str2, aVar, objArr);
        if (a2 != null && a2.kP() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.dH().b(a3) && a3.dV() != null) {
                return new a(a2, a3.dV().getAbsolutePath());
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        wd();
        com.baidu.adp.widget.a.a a2 = this.ajr.a(str, str2, i, i2, bdAsyncTask, aVar, objArr);
        if (a2 != null && a2.kP() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.dH().b(a3) && a3.dV() != null) {
                return new a(a2, a3.dV().getAbsolutePath());
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        this.ajr.a(str, obj, objArr);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        return this.ajr.fN();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fO() {
        return this.ajr.fO();
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        public b(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean c(File file) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public com.baidu.adp.widget.a.a ajs;
        public String path;

        public a(com.baidu.adp.widget.a.a aVar, String str) {
            this.ajs = aVar;
            this.path = str;
        }
    }
}
