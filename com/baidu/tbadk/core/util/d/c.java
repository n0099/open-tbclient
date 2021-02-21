package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean mx() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.bCP().Di(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setIsFormatData(false);
        cVar.setLock(bArr);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            bVar.Nl = dVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (com.baidu.adp.lib.Disk.d.lg().c(cVar)) {
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
                    aVar = new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), str2);
                    return aVar;
                }
            }
            aVar = null;
            return aVar;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.b.i iVar = new com.baidu.tbadk.core.util.b.i();
            if (bVar != null) {
                bVar.Nl = iVar;
            }
            byte[] aw = iVar.aw(str, false);
            boolean btj = iVar.btj();
            if ((aw != null || iVar.lV().MD) && btj && !iVar.fcw) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setData(aw);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(false);
                com.baidu.adp.lib.Disk.d.lg().c(cVar);
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.Nl = dVar;
                }
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.tbadk.imageManager.c.bCP().b(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        return g.btr().my();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mz() {
        return 1;
    }

    public static boolean Bu(String str) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(com.baidu.adp.lib.e.d.mw().genCacheKey(str, 41)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }
}
