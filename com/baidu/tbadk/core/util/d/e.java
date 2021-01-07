package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.av;
import java.io.File;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.e.e<a> {
    private final n ffk = new n();

    public e() {
        this.ffk.jS(true);
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean my() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return null;
    }

    private void bwQ() {
        b bVar = new b(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bVar.setSubFolder(true);
        bVar.setSavedCache(true);
        bVar.setSdCard(true);
        com.baidu.adp.lib.Disk.d.lh().b(bVar);
    }

    private DiskFileOperate a(com.baidu.adp.widget.ImageView.a aVar, String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, av.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
        diskFileOperate.a(DiskFileOperate.OperateType.MUST_SUCCESS);
        diskFileOperate.setSubFolder(true);
        diskFileOperate.setSavedCache(true);
        diskFileOperate.setSdCard(true);
        diskFileOperate.setData(aVar.getByteData());
        return diskFileOperate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: e */
    public a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        bwQ();
        com.baidu.adp.widget.ImageView.a a2 = this.ffk.a(str, str2, i, i2, bVar, objArr);
        if (a2 != null && a2.getByteData() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.lh().b(a3) && a3.getFileInfo() != null) {
                return new a(a2, a3.getFileInfo().getAbsolutePath());
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: f */
    public a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        bwQ();
        com.baidu.adp.widget.ImageView.a b2 = this.ffk.b(str, str2, i, i2, bVar, objArr);
        if (b2 != null && b2.getByteData() != null) {
            DiskFileOperate a2 = a(b2, str2);
            if (com.baidu.adp.lib.Disk.d.lh().b(a2) && a2.getFileInfo() != null) {
                return new a(b2, a2.getFileInfo().getAbsolutePath());
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        this.ffk.a(str, obj, i, i2, objArr);
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mz() {
        return this.ffk.mz();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mA() {
        return this.ffk.mA();
    }

    /* loaded from: classes.dex */
    public static class b extends DiskFileOperate implements com.baidu.adp.lib.Disk.a {
        public b(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
        }

        @Override // com.baidu.adp.lib.Disk.a
        public boolean compare(File file) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public com.baidu.adp.widget.ImageView.a ffl;
        public String path;

        public a(com.baidu.adp.widget.ImageView.a aVar, String str) {
            this.ffl = aVar;
            this.path = str;
        }
    }
}
