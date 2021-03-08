package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.switchs.WebpSwitch;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean mx() {
        return com.baidu.tbadk.core.k.bkV().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a Dp = com.baidu.tbadk.imageManager.c.bCS().Dp(str);
        if (z) {
            com.baidu.adp.lib.e.a.c(Dp != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return Dp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a a2 = a(aw.getNameMd5FromUrl(str2), bVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
        com.baidu.adp.lib.e.a.d(a2 != null, System.currentTimeMillis() - currentTimeMillis);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] aw;
        boolean z2;
        NSGif nSGif;
        com.baidu.adp.widget.ImageView.a aVar;
        int lastIndexOf;
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.tbadk.core.util.b.i iVar = new com.baidu.tbadk.core.util.b.i();
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                z = true;
                str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                aw = iVar.aw(str3, false);
                boolean btm = iVar.btm();
                if (iVar.btl() && iVar.errorCode == -11) {
                    BdLog.e("BIGIMAGE imageLoaderProc too big");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
                }
                if (aw != null || !iVar.btl()) {
                    com.baidu.adp.lib.e.a.a(false, str3, iVar.fdQ, 0L, 0L);
                    return null;
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(aw);
                if (z && Bytes2Bitmap == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
                    byte[] aw2 = iVar.aw(str, false);
                    boolean btm2 = iVar.btm();
                    if (aw2 == null || !iVar.btl()) {
                        z2 = btm2;
                        aw = aw2;
                    } else {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(aw2);
                        z2 = btm2;
                        aw = aw2;
                    }
                } else {
                    z2 = btm;
                }
                if (aw == null || Bytes2Bitmap == null) {
                    com.baidu.adp.lib.e.a.a(false, str3, iVar.fdQ, 0L, 0L);
                    return null;
                }
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    String nameMd5FromUrl = aw.getNameMd5FromUrl(str2);
                    com.baidu.tbadk.imageManager.c.bCS().freePicCache(TbConfig.getPbImageSize() + aw.length);
                    boolean isGif = com.baidu.adp.lib.util.l.isGif(aw);
                    if (!NSGif.Ll || !isGif) {
                        nSGif = null;
                    } else {
                        nSGif = NSGif.g(aw, 0, aw.length);
                    }
                    if (nSGif != null) {
                        aVar = new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) nSGif, Bytes2Bitmap, true);
                        aVar.setNeedCache(z2);
                    } else {
                        if (isGif) {
                            BdLog.e("BIGIMAGE gif parse fail ");
                            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                        }
                        aVar = new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                        aVar.setNeedCache(z2);
                    }
                    if (z2) {
                        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                        aVar2.setSubFolder(true);
                        aVar2.setData(aw);
                        aVar2.setSdCard(false);
                        aVar2.setSavedCache(true);
                        com.baidu.adp.lib.Disk.d.lg().c(aVar2);
                        if (bVar != null) {
                            d dVar = new d();
                            dVar.f(aVar2);
                            bVar.OL = dVar;
                        }
                    }
                    if (isGif) {
                        b.a(str, aw, false, bVar);
                    }
                    com.baidu.adp.lib.e.a.a(aw.length > 1, str3, iVar.fdQ, System.currentTimeMillis() - currentTimeMillis, aw.length);
                }
                return aVar;
            }
        }
        z = false;
        str3 = str;
        aw = iVar.aw(str3, false);
        boolean btm3 = iVar.btm();
        if (iVar.btl()) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (aw != null) {
        }
        com.baidu.adp.lib.e.a.a(false, str3, iVar.fdQ, 0L, 0L);
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if ((obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCS().b(str, aVar);
        }
    }

    public static com.baidu.adp.widget.ImageView.a a(String str, com.baidu.adp.lib.e.b bVar, String str2, String str3, int i, int i2) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        aVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSubFolder(true);
        aVar.setIsFormatData(false);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        aVar.setLock(bArr);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(aVar);
            bVar.OL = dVar;
        }
        if (!com.baidu.adp.lib.Disk.d.lg().c(aVar)) {
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
        if (aVar.isSuccess()) {
            boolean isGif = com.baidu.adp.lib.util.l.isGif(aVar.getData());
            if (isGif) {
                aVar.formatData(aVar.getData());
            }
            if (aVar.lm() != null) {
                return new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) aVar.lm(), BitmapHelper.Bytes2Bitmap(aVar.getData()), true);
            }
            if (isGif) {
                BdLog.e("BIGIMAGE gif parse fail ");
                com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aVar.getData()), i, i2), false, str2);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mz() {
        return 1;
    }
}
