package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean no() {
        return com.baidu.tbadk.core.i.wB().wH();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.Mb().gx(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return a(ao.ee(str2), aVar, str2, "ImageLoaderProc.getFromLocal");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] bArr;
        NSGif nSGif;
        com.baidu.adp.widget.a.a aVar2;
        int lastIndexOf;
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.mz().an("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = str;
        } else {
            str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
            z = true;
        }
        byte[] j = iVar.j(str3, false);
        if (iVar.Ds() && iVar.errorCode == -11) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (j == null || !iVar.Ds()) {
            return null;
        }
        Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(j);
        if (z && Bytes2Bitmap == null) {
            TbadkCoreApplication.getInst().incWebpFailureCount();
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
            byte[] j2 = iVar.j(str, false);
            if (j2 == null || !iVar.Ds()) {
                bArr = j2;
            } else {
                Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(j2);
                bArr = j2;
            }
        } else {
            bArr = j;
        }
        if (bArr == null || Bytes2Bitmap == null) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String ee = ao.ee(str2);
            com.baidu.tbadk.imageManager.c.Mb().ie(TbConfig.getPbImageSize() + bArr.length);
            boolean j3 = com.baidu.adp.lib.util.l.j(bArr);
            if (!NSGif.afl || !j3) {
                nSGif = null;
            } else {
                nSGif = NSGif.h(bArr, 0, bArr.length);
            }
            if (nSGif != null) {
                aVar2 = new com.baidu.adp.widget.a.a((com.baidu.adp.gif.b) nSGif, Bytes2Bitmap, true);
            } else {
                if (j3) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                }
                aVar2 = new com.baidu.adp.widget.a.a(Bytes2Bitmap, false, str);
            }
            com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, ee, DiskFileOperate.Action.WRITE);
            aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar3.Z(true);
            aVar3.setData(bArr);
            com.baidu.adp.lib.Disk.d.ll().c(aVar3);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(aVar3);
                aVar.ajQ = dVar;
            }
            if (j3) {
                c.a(str, bArr, false, aVar);
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Mb().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    public static com.baidu.adp.widget.a.a a(String str, com.baidu.adp.lib.f.a aVar, String str2, String str3) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.Z(true);
        aVar2.aa(false);
        aVar2.ao(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(aVar2);
            aVar.ajQ = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.ll().c(aVar2)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.oJ()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (aVar2.isSuccess()) {
                boolean j = com.baidu.adp.lib.util.l.j(aVar2.getData());
                if (j) {
                    aVar2.h(aVar2.getData());
                }
                if (aVar2.lF() != null) {
                    return new com.baidu.adp.widget.a.a((com.baidu.adp.gif.b) aVar2.lF(), BitmapHelper.Bytes2Bitmap(aVar2.getData()), true);
                }
                if (j) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                }
                return new com.baidu.adp.widget.a.a(BitmapHelper.Bytes2Bitmap(aVar2.getData()), false, str2);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel np() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int nq() {
        return 1;
    }
}
