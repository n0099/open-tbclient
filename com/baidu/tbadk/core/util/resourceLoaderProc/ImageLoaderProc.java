package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.gif.NSGif;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import d.b.c.e.a.d;
import d.b.c.e.l.b;
import d.b.c.e.l.e;
import d.b.c.e.p.j;
import d.b.c.e.p.l;
import d.b.c.j.d.a;
import d.b.i0.a0.c;
import d.b.i0.r.k;
/* loaded from: classes3.dex */
public class ImageLoaderProc implements e<a> {
    public static final String GIF_PLAY_LOG_TYPE = "gifplay";

    public static a readGifFromDisk(String str, b bVar, String str2, String str3, int i, int i2) {
        byte[] bArr = new byte[0];
        d.b.c.e.a.f.a aVar = new d.b.c.e.a.f.a("images", str, DiskFileOperate.Action.READ);
        aVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        aVar.setSubFolder(true);
        aVar.setIsFormatData(false);
        aVar.setSdCard(false);
        aVar.setSavedCache(true);
        aVar.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(aVar);
            bVar.f42585a = diskCancelWorker;
        }
        if (d.g().a(aVar)) {
            int i3 = j.H() ? 500 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException e2) {
                    BdLog.detailException(e2);
                }
            }
            if (aVar.isSuccess()) {
                boolean A = l.A(aVar.getData());
                if (A) {
                    aVar.formatData(aVar.getData());
                }
                if (aVar.a() != null) {
                    return new a((d.b.c.d.b) aVar.a(), BitmapHelper.Bytes2Bitmap(aVar.getData()), true);
                }
                if (A) {
                    BdLog.e("BIGIMAGE gif parse fail ");
                    d.b.i0.r.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "readGifFromDisk", -1, "gif parse fail", "url", str2, "callpath", str3);
                }
                return new a(BitmapHelper.checkBitmapSize(BitmapHelper.Bytes2Bitmap(aVar.getData()), i, i2), false, str2);
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m20decodeToResource(byte[] bArr, Object... objArr) {
        return null;
    }

    @Override // d.b.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.b.c.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    @Override // d.b.c.e.l.e
    public boolean isNeedLoad() {
        return k.c().g();
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    @Override // d.b.c.e.l.e
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (aVar.u()) {
                aVar.A(i);
                aVar.z(i2);
                c.k().d(str, aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.c.e.l.e
    public a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        a readGifFromDisk = readGifFromDisk(TbMd5.getNameMd5FromUrl(str2), bVar, str2, "ImageLoaderProc.getFromLocal", i, i2);
        d.b.c.e.l.a.f(readGifFromDisk != null, System.currentTimeMillis() - currentTimeMillis);
        return readGifFromDisk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.c.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        a m = c.k().m(str);
        if (z) {
            d.b.c.e.l.a.i(m != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return m;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.b.c.e.l.e
    public a getFromRemote(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        String str3;
        boolean z;
        byte[] downloadImageBytes;
        a aVar;
        boolean z2;
        int lastIndexOf;
        long currentTimeMillis = System.currentTimeMillis();
        WebClient webClient = new WebClient();
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = str.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                z = true;
                downloadImageBytes = webClient.downloadImageBytes(str3, false);
                boolean needCache = webClient.needCache();
                if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                    BdLog.e("BIGIMAGE imageLoaderProc too big");
                    d.b.i0.r.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
                }
                if (downloadImageBytes == null && webClient.IsRequestSuccess()) {
                    Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                    if (z && Bytes2Bitmap == null) {
                        TbadkCoreApplication.getInst().incWebpFailureCount();
                        d.b.i0.r.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "webp decode fail ", "url", str);
                        downloadImageBytes = webClient.downloadImageBytes(str, false);
                        needCache = webClient.needCache();
                        if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                            Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                        }
                    }
                    if (downloadImageBytes != null && Bytes2Bitmap != null) {
                        synchronized (BitmapHelper.lockForSyncImageDecoder) {
                            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                            c.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                            boolean A = l.A(downloadImageBytes);
                            NSGif f2 = (NSGif.f2170f && A) ? NSGif.f(downloadImageBytes, 0, downloadImageBytes.length) : null;
                            if (f2 != null) {
                                aVar = new a((d.b.c.d.b) f2, Bytes2Bitmap, true);
                                aVar.y(needCache);
                            } else {
                                if (A) {
                                    BdLog.e("BIGIMAGE gif parse fail ");
                                    d.b.i0.r.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "getFromRemote", -1, "gif parse fail", "url", str);
                                }
                                a aVar2 = new a(BitmapHelper.checkBitmapSize(Bytes2Bitmap, i, i2), false, str);
                                aVar2.y(needCache);
                                aVar = aVar2;
                            }
                            if (needCache) {
                                d.b.c.e.a.f.a aVar3 = new d.b.c.e.a.f.a("images", nameMd5FromUrl, DiskFileOperate.Action.WRITE);
                                aVar3.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                                aVar3.setSubFolder(true);
                                aVar3.setData(downloadImageBytes);
                                aVar3.setSdCard(false);
                                aVar3.setSavedCache(true);
                                d.g().a(aVar3);
                                if (bVar != null) {
                                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                                    diskCancelWorker.setOperate(aVar3);
                                    bVar.f42585a = diskCancelWorker;
                                }
                            }
                            if (A) {
                                z2 = false;
                                BigImageLoaderProc.updateLocal(str, downloadImageBytes, false, bVar);
                            } else {
                                z2 = false;
                            }
                            if (downloadImageBytes.length > 1) {
                                z2 = true;
                            }
                            d.b.c.e.l.a.j(z2, str3, webClient.mStat, System.currentTimeMillis() - currentTimeMillis, downloadImageBytes.length);
                        }
                        return aVar;
                    }
                    d.b.c.e.l.a.j(false, str3, webClient.mStat, 0L, 0L);
                    return null;
                }
                d.b.c.e.l.a.j(false, str3, webClient.mStat, 0L, 0L);
                return null;
            }
        }
        str3 = str;
        z = false;
        downloadImageBytes = webClient.downloadImageBytes(str3, false);
        boolean needCache2 = webClient.needCache();
        if (webClient.IsRequestSuccess()) {
            BdLog.e("BIGIMAGE imageLoaderProc too big");
            d.b.i0.r.z.a.a(GIF_PLAY_LOG_TYPE, -1L, -1, "ImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str);
        }
        if (downloadImageBytes == null) {
        }
        d.b.c.e.l.a.j(false, str3, webClient.mStat, 0L, 0L);
        return null;
    }
}
