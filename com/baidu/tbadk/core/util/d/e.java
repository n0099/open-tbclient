package com.baidu.tbadk.core.util.d;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aw;
import java.io.File;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.e.e<a> {
    private final n fcR = new n();

    public e() {
        this.fcR.jR(true);
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mx() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return null;
    }

    private void btq() {
        b bVar = new b(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
        bVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bVar.setSubFolder(true);
        bVar.setSavedCache(true);
        bVar.setSdCard(true);
        com.baidu.adp.lib.Disk.d.lg().b(bVar);
    }

    private DiskFileOperate a(com.baidu.adp.widget.ImageView.a aVar, String str) {
        DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, aw.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
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
        btq();
        com.baidu.adp.widget.ImageView.a a2 = this.fcR.a(str, str2, i, i2, bVar, objArr);
        if (a2 != null && a2.getByteData() != null) {
            DiskFileOperate a3 = a(a2, str2);
            if (com.baidu.adp.lib.Disk.d.lg().b(a3) && a3.getFileInfo() != null) {
                return new a(a2, a3.getFileInfo().getAbsolutePath());
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: f */
    public a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        btq();
        com.baidu.adp.widget.ImageView.a b2 = this.fcR.b(str, str2, i, i2, bVar, objArr);
        if (b2 != null && b2.getByteData() != null) {
            DiskFileOperate a2 = a(b2, str2);
            if (com.baidu.adp.lib.Disk.d.lg().b(a2) && a2.getFileInfo() != null) {
                return new a(b2, a2.getFileInfo().getAbsolutePath());
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        this.fcR.a(str, obj, i, i2, objArr);
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        return this.fcR.my();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mz() {
        return this.fcR.mz();
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
        public com.baidu.adp.widget.ImageView.a fcS;
        public String path;

        public a(com.baidu.adp.widget.ImageView.a aVar, String str) {
            this.fcS = aVar;
            this.path = str;
        }
    }
}
