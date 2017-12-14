package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean fM() {
        return com.baidu.tbadk.core.h.oY().pe();
    }

    private String k(String str, boolean z) {
        return str + (z ? "_gif" : "");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.EA().gr(k(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.a.a aVar2;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null) {
            return null;
        }
        String dX = ao.dX(str2);
        if (valueOf3.booleanValue()) {
            aVar2 = a(dX, aVar, valueOf4, "ImageLoaderProc.getFromLocal");
        } else {
            Bitmap b = b(dX, aVar);
            aVar2 = b != null ? new com.baidu.adp.widget.a.a(b, false, valueOf4) : null;
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.a.a aVar2;
        NSGif nSGif;
        if (objArr == null || objArr.length != 4) {
            return null;
        }
        String valueOf = objArr[0] == null ? "" : String.valueOf(objArr[0]);
        String valueOf2 = objArr[1] == null ? "" : String.valueOf(objArr[1]);
        Boolean valueOf3 = Boolean.valueOf(String.valueOf(objArr[2]));
        String valueOf4 = objArr[3] == null ? "" : String.valueOf(objArr[3]);
        if (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) {
            return null;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        byte[] j = iVar.j(valueOf4, false);
        if (iVar.vT() && iVar.errorCode == -11) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "ImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", valueOf4);
        }
        if (j == null || !iVar.vT()) {
            return null;
        }
        synchronized (BitmapHelper.lockForSyncImageDecoder) {
            String dX = ao.dX(str2);
            com.baidu.tbadk.imageManager.c.EA().fg(TbConfig.getPbImageSize() + j.length);
            if (valueOf3.booleanValue()) {
                if (!NSGif.qK) {
                    nSGif = null;
                } else {
                    nSGif = NSGif.h(j, 0, j.length);
                }
                if (nSGif != null) {
                    aVar2 = new com.baidu.adp.widget.a.a((com.baidu.adp.gif.b) nSGif, BitmapHelper.Bytes2Bitmap(j), true);
                } else {
                    if (com.baidu.adp.lib.util.l.j(j)) {
                        BdLog.e("BIGIMAGE gif parse fail ");
                        com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "getFromRemote", -1, "gif parse fail", "url", valueOf4);
                    }
                    aVar2 = new com.baidu.adp.widget.a.a(BitmapHelper.Bytes2Bitmap(j), false, valueOf4);
                }
                com.baidu.adp.lib.Disk.ops.a aVar3 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, dX, DiskFileOperate.Action.WRITE);
                aVar3.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                aVar3.t(true);
                aVar3.setData(j);
                com.baidu.adp.lib.Disk.d.dH().c(aVar3);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(aVar3);
                    aVar.vC = dVar;
                }
                if (aVar2 == null) {
                    return null;
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(j);
                if (Bytes2Bitmap == null) {
                    return null;
                }
                aVar2 = new com.baidu.adp.widget.a.a(Bytes2Bitmap, valueOf3.booleanValue(), valueOf4);
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, dX, DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.t(true);
                cVar.setData(j);
                cVar.w(valueOf3.booleanValue());
                com.baidu.adp.lib.Disk.d.dH().c(cVar);
                if (aVar != null) {
                    d dVar2 = new d();
                    dVar2.f(cVar);
                    aVar.vC = dVar2;
                }
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.EA().c(k(str, Boolean.valueOf(String.valueOf(objArr[2])).booleanValue()), (com.baidu.adp.widget.a.a) obj);
        }
    }

    public static com.baidu.adp.widget.a.a a(String str, com.baidu.adp.lib.f.a aVar, String str2, String str3) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.a aVar2 = new com.baidu.adp.lib.Disk.ops.a(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        aVar2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar2.t(true);
        aVar2.u(false);
        aVar2.j(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(aVar2);
            aVar.vC = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.dH().c(aVar2)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.hi()) {
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
                aVar2.h(aVar2.getData());
                if (aVar2.eb() != null) {
                    return new com.baidu.adp.widget.a.a((com.baidu.adp.gif.b) aVar2.eb(), BitmapHelper.Bytes2Bitmap(aVar2.getData()), true);
                }
                if (com.baidu.adp.lib.util.l.j(aVar2.getData())) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                }
                return new com.baidu.adp.widget.a.a(BitmapHelper.Bytes2Bitmap(aVar2.getData()), false, str2);
            }
            return null;
        }
        return null;
    }

    public static Bitmap b(String str, com.baidu.adp.lib.f.a aVar) {
        Bitmap bitmap;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.t(false);
        cVar.u(false);
        cVar.j(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.vC = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.dH().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.hi()) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    BdLog.detailException(e);
                }
            }
            if (cVar.isSuccess()) {
                cVar.h(cVar.getData());
                bitmap = cVar.getBitmap();
            } else {
                bitmap = null;
            }
            return bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fO() {
        return 1;
    }
}
