package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
import java.io.File;
/* loaded from: classes.dex */
public class f implements com.baidu.adp.lib.f.e<a> {
    private final p asW = new p();

    @Override // com.baidu.adp.lib.f.e
    public boolean ik() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: h */
    public a f(String str, String str2, Object... objArr) {
        return null;
    }

    private void Ab() {
        b bVar = new b(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bVar.u(true);
        bVar.x(true);
        bVar.w(false);
        com.baidu.adp.lib.Disk.d.ge().b(bVar);
    }

    private DiskFileOperate a(com.baidu.adp.widget.ImageView.a aVar, String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, as.eM(str), DiskFileOperate.Action.WRITE_FORCE);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.u(true);
        diskFileOperate.x(true);
        diskFileOperate.w(false);
        diskFileOperate.setData(aVar.ng());
        return diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        Ab();
        com.baidu.adp.widget.ImageView.a a2 = this.asW.a(str, str2, aVar, objArr);
        if (a2 != null && a2.ng() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.ge().b(a3) && a3.gs() != null) {
                return new a(a2, a3.gs().getAbsolutePath());
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        Ab();
        com.baidu.adp.widget.ImageView.a a2 = this.asW.a(str, str2, i, i2, bdAsyncTask, aVar, objArr);
        if (a2 != null && a2.ng() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.ge().b(a3) && a3.gs() != null) {
                return new a(a2, a3.gs().getAbsolutePath());
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        this.asW.a(str, obj, objArr);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel il() {
        return this.asW.il();
    }

    @Override // com.baidu.adp.lib.f.e
    public int im() {
        return this.asW.im();
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        public b(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean d(File file) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public com.baidu.adp.widget.ImageView.a asX;
        public String path;

        public a(com.baidu.adp.widget.ImageView.a aVar, String str) {
            this.asX = aVar;
            this.path = str;
        }
    }
}
