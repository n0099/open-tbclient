package com.baidu.tbadk.core.util.d;

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
    private boolean Nf = true;

    @Override // com.baidu.adp.lib.e.e
    public boolean gv() {
        return com.baidu.tbadk.core.i.axf().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.aMZ().vb(str), i, i2);
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
            aVar.rS = eVar;
        }
        if (com.baidu.adp.lib.Disk.d.fj().c(cVar)) {
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

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr) {
        if (bitmap != null || bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str2, bArr);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setData(bArr);
            cVar.setGif(z);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            com.baidu.adp.lib.Disk.d.fj().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.rS = eVar;
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
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
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
                    aVar.rS = iVar;
                }
                T = iVar.T(str3, this.Nf);
                if (T != null && !iVar.fZ().ro) {
                    return null;
                }
                com.baidu.tbadk.imageManager.c.aMZ().freePicCache(TbConfig.getPbImageSize() + T.length);
                return a(str3, str2, aVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(T), i, i2), !iVar.isGif || com.baidu.adp.lib.util.l.isGif(T), iVar, T);
            }
        }
        str3 = str;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        T = iVar.T(str3, this.Nf);
        if (T != null) {
        }
        com.baidu.tbadk.imageManager.c.aMZ().freePicCache(TbConfig.getPbImageSize() + T.length);
        return a(str3, str2, aVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(T), i, i2), !iVar.isGif || com.baidu.adp.lib.util.l.isGif(T), iVar, T);
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.af(i);
            aVar.ag(i2);
            com.baidu.tbadk.imageManager.c.aMZ().c(str, aVar);
        }
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel gw() {
        return j.aEp().gw();
    }

    @Override // com.baidu.adp.lib.e.e
    public int gx() {
        return 1;
    }
}
