package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes.dex */
public class l implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    private boolean aiR = true;

    @Override // com.baidu.adp.lib.f.e
    public boolean fM() {
        return com.baidu.tbadk.core.h.oT().oZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.Es().gp(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.dV(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.t(true);
        cVar.u(false);
        cVar.j(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.vF = dVar;
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
                }
            }
            return cVar.isSuccess() ? a(cVar, str) : null;
        }
        return null;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr) {
        if (bitmap != null || bArr != null) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str2, bArr);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.dV(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.t(true);
            cVar.setData(bArr);
            cVar.w(z);
            com.baidu.adp.lib.Disk.d.dH().c(cVar);
            if (aVar != null) {
                d dVar = new d();
                dVar.f(cVar);
                aVar.vF = dVar;
            }
        }
        return aVar2;
    }

    protected com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.h(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap == null && cVar.ed() == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(bitmap, cVar.isGif(), str, cVar.ed());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
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
        String str3 = (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.eV().af("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) ? str : str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.vF = iVar;
        }
        byte[] j = iVar.j(str3, !this.aiR);
        if (j == null && !iVar.fz().vo) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.Es().fh(TbConfig.getPbImageSize() + j.length);
        return a(str3, str2, aVar, null, a(BitmapHelper.Bytes2Bitmap(j), i, i2), iVar.isGif || com.baidu.adp.lib.util.l.j(j), iVar, j);
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Es().fh(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Es().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        return i.wb().fN();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fO() {
        return 1;
    }
}
