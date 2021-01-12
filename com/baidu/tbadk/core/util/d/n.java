package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.switchs.WebpSwitch;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    private boolean akY = true;
    private boolean faM = false;

    public void jO(boolean z) {
        this.faM = z;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean my() {
        return com.baidu.tbadk.core.k.bkB().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.bCx().CT(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setLock(bArr);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            bVar.Nn = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.lh().c(cVar)) {
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

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.b bVar, com.baidu.adp.widget.ImageView.a aVar, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.b.i iVar, byte[] bArr, boolean z2) {
        if (bitmap != null || bArr != null) {
            aVar = new com.baidu.adp.widget.ImageView.a(bitmap, z, str2, bArr);
            aVar.setNeedCache(z2);
            if (z2) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setGif(z);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                com.baidu.adp.lib.Disk.d.lh().c(cVar);
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.Nn = dVar;
                }
            }
        }
        return aVar;
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        String str3;
        com.baidu.tbadk.core.util.b.i iVar;
        byte[] ax;
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
        if (!this.faM) {
            if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                int indexOf = str.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0) {
                    indexOf = str.indexOf("tiebapic.baidu.com");
                }
                if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                    str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                    iVar = new com.baidu.tbadk.core.util.b.i();
                    if (bVar != null) {
                        bVar.Nn = iVar;
                    }
                    ax = iVar.ax(str3, this.akY);
                    boolean bsP = iVar.bsP();
                    if (ax != null && !iVar.lW().MF) {
                        return null;
                    }
                    com.baidu.tbadk.imageManager.c.bCx().freePicCache(TbConfig.getPbImageSize() + ax.length);
                    return a(str3, str2, bVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(ax), i, i2), !iVar.isGif || com.baidu.adp.lib.util.l.isGif(ax), iVar, ax, bsP);
                }
            }
        }
        str3 = str;
        iVar = new com.baidu.tbadk.core.util.b.i();
        if (bVar != null) {
        }
        ax = iVar.ax(str3, this.akY);
        boolean bsP2 = iVar.bsP();
        if (ax != null) {
        }
        com.baidu.tbadk.imageManager.c.bCx().freePicCache(TbConfig.getPbImageSize() + ax.length);
        return a(str3, str2, bVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(ax), i, i2), !iVar.isGif || com.baidu.adp.lib.util.l.isGif(ax), iVar, ax, bsP2);
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCx().b(str, aVar);
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mz() {
        return g.bsX().mz();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mA() {
        return 1;
    }
}
