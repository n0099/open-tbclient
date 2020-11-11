package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.switchs.WebpSwitch;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean mV() {
        return com.baidu.tbadk.core.k.bjH().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.bBd().Eb(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Vn.resourceFromType = "memory";
        checkIsValidPicMemoryCache.Vn.costTime = 0L;
        checkIsValidPicMemoryCache.Vn.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        return a(av.getNameMd5FromUrl(str2), aVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] aw;
        byte[] bArr;
        boolean z2;
        NSGif nSGif;
        com.baidu.adp.widget.ImageView.a aVar2;
        int lastIndexOf;
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                z = true;
                aw = iVar.aw(str3, false);
                boolean brC = iVar.brC();
                if (iVar.brB() && iVar.errorCode == -11) {
                    BdLog.e("BIGIMAGE imageLoaderProc too big");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
                }
                if (aw != null || !iVar.brB()) {
                    return null;
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(aw);
                if (z && Bytes2Bitmap == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
                    byte[] aw2 = iVar.aw(str, false);
                    boolean brC2 = iVar.brC();
                    if (aw2 == null || !iVar.brB()) {
                        z2 = brC2;
                        bArr = aw2;
                    } else {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(aw2);
                        z2 = brC2;
                        bArr = aw2;
                    }
                } else {
                    bArr = aw;
                    z2 = brC;
                }
                if (bArr == null || Bytes2Bitmap == null) {
                    return null;
                }
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    String nameMd5FromUrl = av.getNameMd5FromUrl(str2);
                    com.baidu.tbadk.imageManager.c.bBd().freePicCache(TbConfig.getPbImageSize() + bArr.length);
                    boolean isGif = com.baidu.adp.lib.util.l.isGif(bArr);
                    if (!NSGif.JD || !isGif) {
                        nSGif = null;
                    } else {
                        nSGif = NSGif.g(bArr, 0, bArr.length);
                    }
                    if (nSGif != null) {
                        aVar2 = new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) nSGif, Bytes2Bitmap, true);
                        aVar2.setNeedCache(z2);
                    } else {
                        if (isGif) {
                            BdLog.e("BIGIMAGE gif parse fail ");
                            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                        }
                        aVar2 = new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                        aVar2.setNeedCache(z2);
                    }
                    if (z2) {
                        com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                        aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                        aVar3.setSubFolder(true);
                        aVar3.setData(bArr);
                        aVar3.setSdCard(false);
                        aVar3.setSavedCache(true);
                        com.baidu.adp.lib.Disk.d.lL().c(aVar3);
                        if (aVar != null) {
                            e eVar = new e();
                            eVar.f(aVar3);
                            aVar.MS = eVar;
                        }
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
        aw = iVar.aw(str3, false);
        boolean brC3 = iVar.brC();
        if (iVar.brB()) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (aw != null) {
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aJ(i);
            aVar.aK(i2);
            com.baidu.tbadk.imageManager.c.bBd().c(str, aVar);
        }
    }

    public static com.baidu.adp.widget.ImageView.a a(String str, com.baidu.adp.lib.e.a aVar, String str2, String str3, int i, int i2) {
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
            aVar.MS = eVar;
        }
        if (!com.baidu.adp.lib.Disk.d.lL().c(aVar2)) {
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
            if (aVar2.lP() != null) {
                return new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) aVar2.lP(), BitmapHelper.Bytes2Bitmap(aVar2.getData()), true);
            }
            if (isGif) {
                BdLog.e("BIGIMAGE gif parse fail ");
                com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aVar2.getData()), i, i2), false, str2);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mW() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mX() {
        return 1;
    }
}
