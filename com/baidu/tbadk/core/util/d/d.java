package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean iH() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.aty().qH(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, at.oj(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.L(false);
        cVar.M(true);
        cVar.K(false);
        cVar.q(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.Bk = eVar;
        }
        boolean kd = com.baidu.adp.lib.util.j.kd();
        if (com.baidu.adp.lib.Disk.d.gC().c(cVar)) {
            int i3 = 2000;
            if (kd) {
                i3 = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException e) {
                }
            }
            if (cVar.isSuccess()) {
                cVar.i(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), str2);
                    return aVar2;
                }
            }
            aVar2 = null;
            return aVar2;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
            if (aVar != null) {
                aVar.Bk = iVar;
            }
            byte[] O = iVar.O(str, false);
            if ((O != null || iVar.iv().AQ) && !iVar.bVB) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, at.oj(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setData(O);
                cVar.L(false);
                cVar.M(true);
                cVar.O(false);
                com.baidu.adp.lib.Disk.d.gC().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Bk = eVar;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.aty().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel iI() {
        return j.ajY().iI();
    }

    @Override // com.baidu.adp.lib.f.e
    public int iJ() {
        return 1;
    }

    public static boolean oF(String str) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, at.oj(com.baidu.adp.lib.f.c.iE().e(str, 41)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.K(false);
        cVar.L(false);
        cVar.M(true);
        return cVar.gD();
    }
}
