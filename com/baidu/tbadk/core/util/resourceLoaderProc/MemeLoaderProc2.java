package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import d.a.c.e.a.d;
import d.a.c.e.a.f.c;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.d.a;
import d.a.m0.r.k;
/* loaded from: classes3.dex */
public class MemeLoaderProc2 implements e<a> {
    public boolean isFromCDN = true;
    public boolean isShare = false;

    public Bitmap checkBitmapSize(Bitmap bitmap, int i2, int i3) {
        return BitmapHelper.checkBitmapSize(bitmap, i2, i3);
    }

    public a createImageFromDiskPicOperate(c cVar, String str, int i2, int i3) {
        if (cVar == null) {
            return null;
        }
        cVar.formatData(cVar.getData());
        Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(cVar.getBitmap(), i2, i3);
        if (checkBitmapSize == null && cVar.c() == null) {
            return null;
        }
        return new a(checkBitmapSize, cVar.isGif(), str, cVar.c());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m23decodeToResource(byte[] bArr, Object... objArr) {
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
        return k.c().g();
    }

    public void setIsShare(boolean z) {
        this.isShare = z;
    }

    public a storeBitmap(String str, String str2, b bVar, a aVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        if (bitmap != null || bArr != null) {
            aVar = new a(bitmap, z, str2, bArr);
            aVar.y(z2);
            if (z2) {
                c cVar = new c("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setGif(z);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                d.g().a(cVar);
                if (bVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(cVar);
                    bVar.f38695a = diskCancelWorker;
                }
            }
        }
        return aVar;
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
            aVar.A(i2);
            aVar.z(i3);
            d.a.m0.a0.c.k().d(str, aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        byte[] bArr = new byte[0];
        c cVar = new c("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.f38695a = diskCancelWorker;
        }
        if (d.g().a(cVar)) {
            int i4 = j.H() ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i4);
                } catch (InterruptedException unused) {
                }
            }
            if (cVar.isSuccess()) {
                return createImageFromDiskPicOperate(cVar, str, i2, i3);
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, d.a.m0.a0.c.k().m(str), i2, i3);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
            return null;
        }
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        int lastIndexOf;
        String str3 = str;
        if (StringUtils.isNull(str)) {
            return null;
        }
        int e2 = i2 == 0 ? l.e(TbadkCoreApplication.getInst().getApp(), 105.0f) : i2;
        int e3 = i3 == 0 ? l.e(TbadkCoreApplication.getInst().getApp(), 105.0f) : i3;
        boolean z = false;
        if (!this.isShare) {
            if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                int indexOf = str.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0) {
                    indexOf = str.indexOf("tiebapic.baidu.com");
                }
                if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                    str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                }
            }
        }
        String str4 = str3;
        WebClient webClient = new WebClient();
        if (bVar != null) {
            bVar.f38695a = webClient;
        }
        byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
        boolean needCache = webClient.needCache();
        if (downloadImageBytes != null || webClient.getResponse().f38641a) {
            d.a.m0.a0.c.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
            return storeBitmap(str4, str2, bVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), e2, e3), (webClient.isGif || l.B(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
        }
        return null;
    }
}
