package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import java.io.File;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.f.e<a> {
    private final p bUG = new p();

    @Override // com.baidu.adp.lib.f.e
    public boolean iy() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, Object... objArr) {
        return null;
    }

    private void aiR() {
        b bVar = new b(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bVar.J(true);
        bVar.M(true);
        bVar.L(true);
        com.baidu.adp.lib.Disk.d.gt().b(bVar);
    }

    private DiskFileOperate a(com.baidu.adp.widget.ImageView.a aVar, String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, as.nT(str), DiskFileOperate.Action.WRITE_FORCE);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.J(true);
        diskFileOperate.M(true);
        diskFileOperate.L(true);
        diskFileOperate.setData(aVar.nx());
        return diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        aiR();
        com.baidu.adp.widget.ImageView.a a2 = this.bUG.a(str, str2, i, i2, aVar, objArr);
        if (a2 != null && a2.nx() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.gt().b(a3) && a3.gH() != null) {
                return new a(a2, a3.gH().getAbsolutePath());
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        aiR();
        com.baidu.adp.widget.ImageView.a a2 = this.bUG.a(str, str2, i, i2, bdAsyncTask, aVar, objArr);
        if (a2 != null && a2.nx() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.gt().b(a3) && a3.gH() != null) {
                return new a(a2, a3.gH().getAbsolutePath());
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        this.bUG.a(str, obj, i, i2, objArr);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel iz() {
        return this.bUG.iz();
    }

    @Override // com.baidu.adp.lib.f.e
    public int iA() {
        return this.bUG.iA();
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        public b(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean e(File file) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public com.baidu.adp.widget.ImageView.a bUH;
        public String path;

        public a(com.baidu.adp.widget.ImageView.a aVar, String str) {
            this.bUH = aVar;
            this.path = str;
        }
    }
}
