package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean la() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.bet().yv(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setIsFormatData(false);
        cVar.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.Lg = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (com.baidu.adp.lib.Disk.d.jR().c(cVar)) {
            int i3 = 2000;
            if (isWifiNet) {
                i3 = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException e) {
                }
            }
            if (cVar.isSuccess()) {
                cVar.formatData(cVar.getData());
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
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
            if (aVar != null) {
                aVar.Lg = iVar;
            }
            byte[] al = iVar.al(str, false);
            boolean aVj = iVar.aVj();
            if ((al != null || iVar.kE().KE) && aVj && !iVar.dPg) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setData(al);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(false);
                com.baidu.adp.lib.Disk.d.jR().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Lg = eVar;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.tbadk.imageManager.c.bet().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel lb() {
        return j.aVr().lb();
    }

    @Override // com.baidu.adp.lib.e.e
    public int lc() {
        return 1;
    }

    public static boolean wH(String str) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(com.baidu.adp.lib.e.c.kX().genCacheKey(str, 41)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }
}
