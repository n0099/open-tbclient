package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import d.a.c.e.a.f.c;
import d.a.c.e.l.b;
import d.a.c.e.l.d;
import d.a.c.e.l.e;
import d.a.c.e.p.j;
import d.a.c.k.d.a;
/* loaded from: classes3.dex */
public class BigdayImageLoaderProc implements e<a> {
    public static boolean isImageFileExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(d.h().g(str, 41)), DiskFileOperate.Action.INFO);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m17decodeToResource(byte[] bArr, Object... objArr) {
        return null;
    }

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        if (obj == null || !(obj instanceof a)) {
            return;
        }
        a aVar = (a) obj;
        if (aVar.u()) {
            d.a.n0.a0.c.k().d(str, aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        byte[] bArr = new byte[0];
        c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setIsFormatData(false);
        cVar.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.f42451a = diskCancelWorker;
        }
        boolean H = j.H();
        if (d.a.c.e.a.d.g().a(cVar)) {
            int i4 = H ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i4);
                } catch (InterruptedException unused) {
                }
            }
            if (cVar.isSuccess()) {
                cVar.formatData(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new a(bitmap, cVar.isGif(), str2);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        return d.a.n0.a0.c.k().m(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        WebClient webClient = new WebClient();
        if (bVar != null) {
            bVar.f42451a = webClient;
        }
        byte[] downloadImageBytes = webClient.downloadImageBytes(str, false);
        boolean needCache = webClient.needCache();
        if ((downloadImageBytes != null || webClient.getResponse().f42397a) && needCache && !webClient.isCrackPic) {
            c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setData(downloadImageBytes);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            cVar.setGif(false);
            d.a.c.e.a.d.g().a(cVar);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(cVar);
                bVar.f42451a = diskCancelWorker;
            }
        }
        return null;
    }
}
