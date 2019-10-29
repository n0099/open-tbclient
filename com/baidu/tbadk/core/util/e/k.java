package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean fW() {
        return com.baidu.tbadk.core.i.agq().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.avu().pY(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.xD.resourceFromType = "memory";
        checkIsValidPicMemoryCache.xD.costTime = 0L;
        checkIsValidPicMemoryCache.xD.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return a(as.getNameMd5FromUrl(str2), aVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] P;
        byte[] bArr;
        NSGif nSGif;
        com.baidu.adp.widget.ImageView.a aVar2;
        int lastIndexOf;
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.ft().af("webp_enable") == 1) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                z = true;
                P = iVar.P(str3, false);
                if (iVar.amZ() && iVar.errorCode == -11) {
                    BdLog.e("BIGIMAGE imageLoaderProc too big");
                    com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
                }
                if (P != null || !iVar.amZ()) {
                    return null;
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(P);
                if (z && Bytes2Bitmap == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
                    byte[] P2 = iVar.P(str, false);
                    if (P2 == null || !iVar.amZ()) {
                        bArr = P2;
                    } else {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(P2);
                        bArr = P2;
                    }
                } else {
                    bArr = P;
                }
                if (bArr == null || Bytes2Bitmap == null) {
                    return null;
                }
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    String nameMd5FromUrl = as.getNameMd5FromUrl(str2);
                    com.baidu.tbadk.imageManager.c.avu().freePicCache(TbConfig.getPbImageSize() + bArr.length);
                    boolean isGif = com.baidu.adp.lib.util.l.isGif(bArr);
                    if (!NSGif.mH || !isGif) {
                        nSGif = null;
                    } else {
                        nSGif = NSGif.f(bArr, 0, bArr.length);
                    }
                    if (nSGif != null) {
                        aVar2 = new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) nSGif, Bytes2Bitmap, true);
                    } else {
                        if (isGif) {
                            BdLog.e("BIGIMAGE gif parse fail ");
                            com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                        }
                        aVar2 = new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                    }
                    com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                    aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                    aVar3.setSubFolder(true);
                    aVar3.setData(bArr);
                    aVar3.setSdCard(false);
                    aVar3.setSavedCache(true);
                    com.baidu.adp.lib.Disk.d.eP().c(aVar3);
                    if (aVar != null) {
                        e eVar = new e();
                        eVar.f(aVar3);
                        aVar.pM = eVar;
                    }
                    if (isGif) {
                        c.a(str, bArr, false, aVar);
                    }
                }
                return aVar2;
            }
        }
        z = false;
        str3 = str;
        P = iVar.P(str3, false);
        if (iVar.amZ()) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (P != null) {
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ac(i);
            aVar.ad(i2);
            com.baidu.tbadk.imageManager.c.avu().c(str, aVar);
        }
    }

    public static com.baidu.adp.widget.ImageView.a a(String str, com.baidu.adp.lib.f.a aVar, String str2, String str3, int i, int i2) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.setSubFolder(true);
        aVar2.setIsFormatData(false);
        aVar2.setSdCard(false);
        aVar2.setSavedCache(true);
        aVar2.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(aVar2);
            aVar.pM = eVar;
        }
        if (!com.baidu.adp.lib.Disk.d.eP().c(aVar2)) {
            return null;
        }
        int i3 = 2000;
        if (com.baidu.adp.lib.util.j.isWifiNet()) {
            i3 = 500;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
                BdLog.detailException(e);
            }
        }
        if (aVar2.isSuccess()) {
            boolean isGif = com.baidu.adp.lib.util.l.isGif(aVar2.getData());
            if (isGif) {
                aVar2.formatData(aVar2.getData());
            }
            if (aVar2.eT() != null) {
                return new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) aVar2.eT(), BitmapHelper.Bytes2Bitmap(aVar2.getData()), true);
            }
            if (isGif) {
                BdLog.e("BIGIMAGE gif parse fail ");
                com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aVar2.getData()), i, i2), false, str2);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fX() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fY() {
        return 1;
    }
}
