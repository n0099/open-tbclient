package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMd5;
import d.a.c.e.a.d;
import d.a.c.e.a.f.c;
import d.a.c.e.l.b;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.d.a;
/* loaded from: classes3.dex */
public class SimpleForeverLoaderProc extends AbstractImageLoaderProc {
    public boolean isFromCDN;
    public int procType;

    public SimpleForeverLoaderProc(boolean z, int i2) {
        this.isFromCDN = true;
        this.procType = 0;
        this.isFromCDN = z;
        this.procType = i2;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        return this.procType;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        return l.i(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        return l.k(TbadkCoreApplication.getInst().getApp());
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        return this.isFromCDN;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        if (TextUtils.isEmpty(str) || bArr == null || !((Boolean) objArr[0]).booleanValue()) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
        c cVar = new c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(bArr);
        cVar.setSdCard(false);
        cVar.setGif(booleanValue);
        d.g().a(cVar);
        b bVar = (b) objArr[3];
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.f39031a = diskCancelWorker;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = new byte[0];
        c createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
        if (createDiskPicOperate == null) {
            return null;
        }
        createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        createDiskPicOperate.setSubFolder(true);
        createDiskPicOperate.setIsFormatData(false);
        createDiskPicOperate.setLock(bArr);
        createDiskPicOperate.setSdCard(false);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(createDiskPicOperate);
            bVar.f39031a = diskCancelWorker;
        }
        if (!d.g().a(createDiskPicOperate)) {
            d.a.c.e.l.a.f(false, 0L);
            return null;
        }
        int i4 = j.H() ? 300 : 2000;
        synchronized (bArr) {
            try {
                bArr.wait(i4);
            } catch (InterruptedException unused) {
            }
        }
        a createImageFromDiskPicOperate = createDiskPicOperate.isSuccess() ? createImageFromDiskPicOperate(createDiskPicOperate, str2, i2, i3) : null;
        d.a.c.e.l.a.f(createImageFromDiskPicOperate != null, System.currentTimeMillis() - currentTimeMillis);
        return createImageFromDiskPicOperate;
    }
}
