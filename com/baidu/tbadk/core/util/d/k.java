package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean jF() {
        return com.baidu.tbadk.core.i.ws().ww();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.Me().hO(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.os() == null || checkIsValidPicMemoryCache.os().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.NF.NH = "memory";
        checkIsValidPicMemoryCache.NF.NI = 0L;
        checkIsValidPicMemoryCache.NF.NJ = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return a(ar.fs(str2), aVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] bArr;
        NSGif nSGif;
        com.baidu.adp.widget.ImageView.a aVar2;
        int lastIndexOf;
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.iR().aO("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = str;
        } else {
            str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
            z = true;
        }
        byte[] q = iVar.q(str3, false);
        if (iVar.De() && iVar.errorCode == -11) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (q == null || !iVar.De()) {
            return null;
        }
        Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(q);
        if (z && Bytes2Bitmap == null) {
            TbadkCoreApplication.getInst().incWebpFailureCount();
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
            byte[] q2 = iVar.q(str, false);
            if (q2 == null || !iVar.De()) {
                bArr = q2;
            } else {
                Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(q2);
                bArr = q2;
            }
        } else {
            bArr = q;
        }
        if (bArr == null || Bytes2Bitmap == null) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String fs = ar.fs(str2);
            com.baidu.tbadk.imageManager.c.Me().fy(TbConfig.getPbImageSize() + bArr.length);
            boolean s = com.baidu.adp.lib.util.l.s(bArr);
            if (!NSGif.yN || !s) {
                nSGif = null;
            } else {
                nSGif = NSGif.h(bArr, 0, bArr.length);
            }
            if (nSGif != null) {
                aVar2 = new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) nSGif, Bytes2Bitmap, true);
            } else {
                if (s) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
            }
            com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, fs, DiskFileOperate.Action.WRITE);
            aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar3.D(true);
            aVar3.setData(bArr);
            aVar3.F(false);
            aVar3.G(true);
            com.baidu.adp.lib.Disk.d.hC().c(aVar3);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(aVar3);
                aVar.Ds = eVar;
            }
            if (s) {
                c.a(str, bArr, false, aVar);
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aN(i);
            aVar.aO(i2);
            com.baidu.tbadk.imageManager.c.Me().c(str, aVar);
        }
    }

    public static com.baidu.adp.widget.ImageView.a a(String str, com.baidu.adp.lib.f.a aVar, String str2, String str3, int i, int i2) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.D(true);
        aVar2.E(false);
        aVar2.F(false);
        aVar2.G(true);
        aVar2.q((Object) bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(aVar2);
            aVar.Ds = eVar;
        }
        if (!com.baidu.adp.lib.Disk.d.hC().c(aVar2)) {
            return null;
        }
        int i3 = 2000;
        if (com.baidu.adp.lib.util.j.kY()) {
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
            boolean s = com.baidu.adp.lib.util.l.s(aVar2.getData());
            if (s) {
                aVar2.q(aVar2.getData());
            }
            if (aVar2.hW() != null) {
                return new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) aVar2.hW(), BitmapHelper.Bytes2Bitmap(aVar2.getData()), true);
            }
            if (s) {
                BdLog.e("BIGIMAGE gif parse fail ");
                com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
            }
            return new com.baidu.adp.widget.ImageView.a(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aVar2.getData()), i, i2), false, str2);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jG() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int jH() {
        return 1;
    }
}
