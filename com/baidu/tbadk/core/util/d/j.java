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
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean ft() {
        return com.baidu.tbadk.core.i.pY().qe();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.Fa().gG(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        return a(aq.em(str2), aVar, str2, "ImageLoaderProc.getFromLocal");
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
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.eE().ak("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = str;
        } else {
            str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
            z = true;
        }
        byte[] j = iVar.j(str3, false);
        if (iVar.wq() && iVar.errorCode == -11) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str);
        }
        if (j == null || !iVar.wq()) {
            return null;
        }
        Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(j);
        if (z && Bytes2Bitmap == null) {
            TbadkCoreApplication.getInst().incWebpFailureCount();
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "webp decode fail ", "url", str);
            byte[] j2 = iVar.j(str, false);
            if (j2 == null || !iVar.wq()) {
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
            String em = aq.em(str2);
            com.baidu.tbadk.imageManager.c.Fa().eX(TbConfig.getPbImageSize() + bArr.length);
            boolean l = com.baidu.adp.lib.util.l.l(bArr);
            if (!NSGif.pD || !l) {
                nSGif = null;
            } else {
                nSGif = NSGif.h(bArr, 0, bArr.length);
            }
            if (nSGif != null) {
                aVar2 = new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) nSGif, Bytes2Bitmap, true);
            } else {
                if (l) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                }
                aVar2 = new com.baidu.adp.widget.ImageView.a(Bytes2Bitmap, false, str);
            }
            com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, em, DiskFileOperate.Action.WRITE);
            aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            aVar3.u(true);
            aVar3.setData(bArr);
            aVar3.w(false);
            aVar3.x(true);
            com.baidu.adp.lib.Disk.d.dp().c(aVar3);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(aVar3);
                aVar.uq = dVar;
            }
            if (l) {
                c.a(str, bArr, false, aVar);
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.Fa().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    public static com.baidu.adp.widget.ImageView.a a(String str, com.baidu.adp.lib.f.a aVar, String str2, String str3) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.u(true);
        aVar2.v(false);
        aVar2.w(false);
        aVar2.x(true);
        aVar2.j((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(aVar2);
            aVar.uq = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.dp().c(aVar2)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.gQ()) {
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
                boolean l = com.baidu.adp.lib.util.l.l(aVar2.getData());
                if (l) {
                    aVar2.j(aVar2.getData());
                }
                if (aVar2.dK() != null) {
                    return new com.baidu.adp.widget.ImageView.a((com.baidu.adp.gif.b) aVar2.dK(), BitmapHelper.Bytes2Bitmap(aVar2.getData()), true);
                }
                if (l) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                }
                return new com.baidu.adp.widget.ImageView.a(BitmapHelper.Bytes2Bitmap(aVar2.getData()), false, str2);
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fu() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fv() {
        return 1;
    }
}
