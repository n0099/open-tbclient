package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.switchs.WebpSwitch;
/* loaded from: classes.dex */
public class q implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    private boolean NJ = true;

    @Override // com.baidu.adp.lib.e.e
    public boolean gu() {
        return com.baidu.tbadk.core.i.azO().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.aPR().vy(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.rT = eVar;
        }
        if (com.baidu.adp.lib.Disk.d.fk().c(cVar)) {
            int i3 = 2000;
            if (com.baidu.adp.lib.util.j.isWifiNet()) {
                i3 = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException e) {
                }
            }
            return cVar.isSuccess() ? a(cVar, str, i, i2) : null;
        }
        return null;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, boolean z2) {
        if (bitmap != null || bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str2, bArr);
            aVar2.setNeedCache(z2);
            if (z2) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setGif(z);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                com.baidu.adp.lib.Disk.d.fk().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.rT = eVar;
                }
            }
        }
        return aVar2;
    }

    protected com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        cVar.formatData(cVar.getData());
        Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(cVar.getBitmap(), i, i2);
        if (checkBitmapSize == null && cVar.getFormatedData() == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(checkBitmapSize, cVar.isGif(), str, cVar.getFormatedData());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ae  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] T;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        if (i == 0) {
            i = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        if (i2 == 0) {
            i2 = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.rT = iVar;
                }
                T = iVar.T(str3, this.NJ);
                boolean aGP = iVar.aGP();
                if (T != null && !iVar.fY().rp) {
                    return null;
                }
                com.baidu.tbadk.imageManager.c.aPR().freePicCache(TbConfig.getPbImageSize() + T.length);
                return a(str3, str2, aVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(T), i, i2), !iVar.isGif || com.baidu.adp.lib.util.l.isGif(T), iVar, T, aGP);
            }
        }
        str3 = str;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        T = iVar.T(str3, this.NJ);
        boolean aGP2 = iVar.aGP();
        if (T != null) {
        }
        com.baidu.tbadk.imageManager.c.aPR().freePicCache(TbConfig.getPbImageSize() + T.length);
        return a(str3, str2, aVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(T), i, i2), !iVar.isGif || com.baidu.adp.lib.util.l.isGif(T), iVar, T, aGP2);
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ai(i);
            aVar.aj(i2);
            com.baidu.tbadk.imageManager.c.aPR().c(str, aVar);
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel gv() {
        return j.aGX().gv();
    }

    @Override // com.baidu.adp.lib.e.e
    public int gw() {
        return 1;
    }
}
