package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    @Override // com.baidu.adp.lib.f.e
    public boolean ik() {
        return true;
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
        com.baidu.adp.widget.ImageView.a aVar2;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, as.eM(str2), DiskFileOperate.Action.READ);
        if (cVar == null) {
            return null;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.w(false);
        cVar.x(true);
        cVar.v(false);
        cVar.m(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.Ao = eVar;
        }
        boolean jF = com.baidu.adp.lib.util.j.jF();
        if (com.baidu.adp.lib.Disk.d.ge().c(cVar)) {
            int i = 2000;
            if (jF) {
                i = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                }
            }
            if (cVar.isSuccess()) {
                cVar.i(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), str2);
                    return aVar2;
                }
            }
            aVar2 = null;
            return aVar2;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        if (!StringUtils.isNull(str)) {
            com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
            if (aVar != null) {
                aVar.Ao = iVar;
            }
            byte[] i3 = iVar.i(str, false);
            if ((i3 != null || iVar.hX().zU) && !iVar.asI) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, as.eM(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setData(i3);
                cVar.w(false);
                cVar.x(true);
                cVar.y(false);
                com.baidu.adp.lib.Disk.d.ge().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Ao = eVar;
                }
            }
        }
        return null;
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

    public static boolean fg(String str) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, as.eM(com.baidu.adp.lib.f.c.ih().f(str, 41)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.v(false);
        cVar.w(false);
        cVar.x(true);
        return cVar.gf();
    }
}
