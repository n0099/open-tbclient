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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.switchs.WebpSwitch;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.e.e
    public boolean my() {
        return com.baidu.tbadk.core.k.bkB().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a CT = com.baidu.tbadk.imageManager.c.bCx().CT(str);
        if (z) {
            com.baidu.adp.lib.e.a.b(CT != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return CT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a a2 = a(av.getNameMd5FromUrl(str2), bVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
        com.baidu.adp.lib.e.a.c(a2 != null, System.currentTimeMillis() - currentTimeMillis);
        return a2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] ax;
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
                ax = iVar.ax(str3, false);
                boolean bsP = iVar.bsP();
                if (iVar.bsO() && iVar.errorCode == -11) {
                    BdLog.e("BIGIMAGE imageLoaderProc too big");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
                }
                if (ax != null || !iVar.bsO()) {
                    com.baidu.adp.lib.e.a.a(false, str3, iVar.fab, 0L, 0L);
                    return null;
                }
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(ax);
                if (z && Bytes2Bitmap == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
                    byte[] ax2 = iVar.ax(str, false);
                    boolean bsP2 = iVar.bsP();
                    if (ax2 == null || !iVar.bsO()) {
                        z2 = bsP2;
                        ax = ax2;
                    } else {
                        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(ax2);
                        z2 = bsP2;
                        ax = ax2;
                    }
                } else {
                    z2 = bsP;
                }
                if (ax == null || Bytes2Bitmap == null) {
                    com.baidu.adp.lib.e.a.a(false, str3, iVar.fab, 0L, 0L);
                    return null;
                }
                synchronized (BitmapHelper.lockForSyncImageDecoder) {
                    String nameMd5FromUrl = av.getNameMd5FromUrl(str2);
                    com.baidu.tbadk.imageManager.c.bCx().freePicCache(TbConfig.getPbImageSize() + ax.length);
                    boolean isGif = com.baidu.adp.lib.util.l.isGif(ax);
                    if (!NSGif.JT || !isGif) {
                        nSGif = null;
                    } else {
                        nSGif = NSGif.g(ax, 0, ax.length);
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
                        aVar2.setData(ax);
                        aVar2.setSdCard(false);
                        aVar2.setSavedCache(true);
                        com.baidu.adp.lib.Disk.d.lh().c(aVar2);
                        if (bVar != null) {
                            d dVar = new d();
                            dVar.f(aVar2);
                            bVar.Nn = dVar;
                        }
                    }
                    if (isGif) {
                        b.a(str, ax, false, bVar);
                    }
                    com.baidu.adp.lib.e.a.a(ax.length > 1, str3, iVar.fab, System.currentTimeMillis() - currentTimeMillis, ax.length);
                }
                return aVar;
            }
        }
        z = false;
        str3 = str;
        ax = iVar.ax(str3, false);
        boolean bsP3 = iVar.bsP();
        if (iVar.bsO()) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (ax != null) {
        }
        com.baidu.adp.lib.e.a.a(false, str3, iVar.fab, 0L, 0L);
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if ((obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCx().b(str, aVar);
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
            bVar.Nn = dVar;
        }
        if (!com.baidu.adp.lib.Disk.d.lh().c(aVar)) {
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
            if (aVar.ln() != null) {
                return new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) aVar.ln(), BitmapHelper.Bytes2Bitmap(aVar.getData()), true);
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
    public BdAsyncTaskParallel mz() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mA() {
        return 1;
    }
}
