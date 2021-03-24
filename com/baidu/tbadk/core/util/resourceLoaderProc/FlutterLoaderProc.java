package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import d.b.b.e.a.d;
import d.b.b.e.a.f.c;
import d.b.b.e.l.b;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.b.j.d.a;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class FlutterLoaderProc extends AbstractImageLoaderProc {
    public boolean isFromCDN;
    public boolean isNeedFormat;
    public int procType;

    public FlutterLoaderProc(boolean z, int i, boolean z2) {
        this.isFromCDN = true;
        this.procType = 0;
        this.isNeedFormat = true;
        this.isFromCDN = z;
        this.procType = i;
        this.isNeedFormat = z2;
    }

    public a createImageByteFromDiskPicOperate(c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        a aVar = new a((Bitmap) null, false, str, cVar.getData());
        cVar.formatData(cVar.getData());
        Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i, i2);
        return checkBitmapSize != null ? new a(checkBitmapSize, cVar.isGif(), str) : aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.b.e.l.e
    public a getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        return null;
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
        if (TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        if (!booleanValue || booleanValue2) {
            return;
        }
        boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
        c cVar = new c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(bArr);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setGif(booleanValue3);
        cVar.d(this.isNeedFormat);
        d.g().a(cVar);
        b bVar = (b) objArr[3];
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.f41847a = diskCancelWorker;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.b.e.l.e
    public a getFromLocal(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        byte[] bArr = new byte[0];
        c createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
        if (createDiskPicOperate == null) {
            return null;
        }
        createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        createDiskPicOperate.setSdCard(false);
        createDiskPicOperate.setSubFolder(true);
        createDiskPicOperate.setSavedCache(true);
        createDiskPicOperate.setIsFormatData(false);
        createDiskPicOperate.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(createDiskPicOperate);
            bVar.f41847a = diskCancelWorker;
        }
        boolean H = j.H();
        if (d.g().a(createDiskPicOperate)) {
            int i3 = H ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException unused) {
                }
            }
            if (createDiskPicOperate.isSuccess()) {
                return createImageByteFromDiskPicOperate(createDiskPicOperate, str2, i, i2);
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ca  */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, d.b.b.e.l.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a getFromRemote(String str, String str2, int i, int i2, b bVar, Object... objArr) {
        boolean z;
        WebClient webClient;
        byte[] downloadImageBytes;
        boolean z2;
        WebClient webClient2;
        int i3;
        byte[] bArr;
        boolean z3;
        char c2;
        boolean z4;
        WebClient webClient3;
        boolean z5;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int suggestWidth = i == 0 ? getSuggestWidth() : i;
        int suggestHeight = i2 == 0 ? getSuggestHeight() : i2;
        if (suggestWidth == 0) {
            suggestWidth = l.e(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        if (suggestHeight == 0) {
            suggestHeight = l.e(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, suggestWidth, suggestHeight);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = urlbyClientServerAddr.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = urlbyClientServerAddr.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = urlbyClientServerAddr.lastIndexOf(".jpg")) > 0) {
                urlbyClientServerAddr = urlbyClientServerAddr.substring(0, lastIndexOf) + ".webp" + urlbyClientServerAddr.substring(lastIndexOf + 4, urlbyClientServerAddr.length());
                z = true;
                webClient = new WebClient();
                if (bVar != null) {
                    bVar.f41847a = webClient;
                }
                downloadImageBytes = webClient.downloadImageBytes(urlbyClientServerAddr, !isFromCDN);
                boolean needCache = webClient.needCache();
                if (!webClient.IsRequestSuccess()) {
                    z2 = needCache;
                    webClient2 = webClient;
                    i3 = 1;
                } else if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    if (webClient.mStat != null) {
                        webClient3 = webClient;
                        z4 = needCache;
                        ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    } else {
                        z4 = needCache;
                        webClient3 = webClient;
                    }
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                        byte[] d2 = d.b.b.e.j.b.b.d(openRawResource);
                        if (!webClient3.isGif && !l.A(d2)) {
                            z5 = false;
                            a aVar = new a((Bitmap) null, z5, str, d2);
                            boolean z6 = z4;
                            aVar.y(z6);
                            storeLocal(str2, d2, Boolean.valueOf(z6), Boolean.valueOf(webClient3.isCrackPic), Boolean.valueOf(z5), bVar);
                            d.b.b.e.m.a.c(openRawResource);
                            return aVar;
                        }
                        z5 = true;
                        a aVar2 = new a((Bitmap) null, z5, str, d2);
                        boolean z62 = z4;
                        aVar2.y(z62);
                        storeLocal(str2, d2, Boolean.valueOf(z62), Boolean.valueOf(webClient3.isCrackPic), Boolean.valueOf(z5), bVar);
                        d.b.b.e.m.a.c(openRawResource);
                        return aVar2;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                } else {
                    z2 = needCache;
                    webClient2 = webClient;
                    i3 = 1;
                    if (!webClient2.getResponse().f41796a) {
                        ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient2.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient2.isMobileProxy(), getProcType());
                        return null;
                    }
                }
                if (downloadImageBytes != null) {
                    if (!webClient2.getResponse().f41796a) {
                        ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient2.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient2.isMobileProxy(), getProcType());
                    }
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (downloadImageBytes.length > i3) {
                    ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                    c2 = 1;
                    z3 = z2;
                    bArr = downloadImageBytes;
                    ImageLogger.imagePerfNetLog(str, true, urlbyClientServerAddr, Boolean.valueOf(z), webClient2.mStat, "InputToByteSucc", currentTimeMillis2, webClient2.isMobileProxy(), getProcType());
                } else {
                    bArr = downloadImageBytes;
                    z3 = z2;
                    c2 = 1;
                    ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient2.mStat, "bytes<1", currentTimeMillis2, webClient2.isMobileProxy(), getProcType());
                }
                d.b.h0.a0.c.j().h(TbConfig.getPbImageSize() + bArr.length);
                boolean z7 = webClient2.isGif || l.A(bArr);
                a aVar3 = new a((Bitmap) null, z7, str, bArr);
                boolean z8 = z3;
                aVar3.y(z8);
                Object[] objArr2 = new Object[4];
                objArr2[0] = Boolean.valueOf(z8);
                objArr2[c2] = Boolean.valueOf(webClient2.isCrackPic);
                objArr2[2] = Boolean.valueOf(z7);
                objArr2[3] = bVar;
                storeLocal(str2, bArr, objArr2);
                return aVar3;
            }
        }
        z = false;
        webClient = new WebClient();
        if (bVar != null) {
        }
        downloadImageBytes = webClient.downloadImageBytes(urlbyClientServerAddr, !isFromCDN);
        boolean needCache2 = webClient.needCache();
        if (!webClient.IsRequestSuccess()) {
        }
        if (downloadImageBytes != null) {
        }
    }
}
