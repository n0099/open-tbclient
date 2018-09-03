package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class p implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    private boolean asS = true;

    @Override // com.baidu.adp.lib.f.e
    public boolean ik() {
        return com.baidu.tbadk.core.i.td().tj();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.c.IQ().he(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eM(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.u(true);
        cVar.v(false);
        cVar.w(false);
        cVar.x(true);
        cVar.m(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.Ao = eVar;
        }
        if (com.baidu.adp.lib.Disk.d.ge().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.jF()) {
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

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr) {
        if (bitmap != null || bArr != null) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str2, bArr);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eM(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.u(true);
            cVar.setData(bArr);
            cVar.y(z);
            cVar.w(false);
            cVar.x(true);
            com.baidu.adp.lib.Disk.d.ge().c(cVar);
            if (aVar != null) {
                e eVar = new e();
                eVar.f(cVar);
                aVar.Ao = eVar;
            }
        }
        return aVar2;
    }

    protected com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.i(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap == null && cVar.gC() == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), str, cVar.gC());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
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
        String str3 = (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hv().ax("webp_enable") == 1) || str.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str.lastIndexOf(".jpg")) <= 0) ? str : str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.Ao = iVar;
        }
        byte[] i3 = iVar.i(str3, !this.asS);
        if (i3 == null && !iVar.hX().zU) {
            return null;
        }
        com.baidu.tbadk.imageManager.c.IQ().fd(TbConfig.getPbImageSize() + i3.length);
        return a(str3, str2, aVar, null, b(BitmapHelper.Bytes2Bitmap(i3), i, i2), iVar.isGif || com.baidu.adp.lib.util.l.k(i3), iVar, i3);
    }

    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IQ().fd(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.IQ().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel il() {
        return j.Ac().il();
    }

    @Override // com.baidu.adp.lib.f.e
    public int im() {
        return 1;
    }
}
