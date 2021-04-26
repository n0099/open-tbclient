package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import d.a.c.e.a.d;
import d.a.c.e.a.f.c;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.j.d.a;
import d.a.i0.z0.o;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class BigImageLoaderProc implements e<a> {
    public static final String NCDN_PER = "width=";
    public int procType;

    public BigImageLoaderProc(int i2) {
        this.procType = 0;
        this.procType = i2;
    }

    public static boolean checkBigImageFileExist(String str) {
        String nameMd5FromUrl = getNameMd5FromUrl(str);
        if (TextUtils.isEmpty(nameMd5FromUrl)) {
            return false;
        }
        return newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO).call();
    }

    public static File getFileInfo(String str) {
        String nameMd5FromUrl = getNameMd5FromUrl(str);
        if (!TextUtils.isEmpty(nameMd5FromUrl)) {
            c newDiskPicOperate = newDiskPicOperate(nameMd5FromUrl, DiskFileOperate.Action.INFO);
            if (d.g().d(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
                return newDiskPicOperate.getFileInfo();
            }
        }
        return null;
    }

    public static byte[] getFromLocalData(String str, b bVar) {
        String pidFromCDNURL = getPidFromCDNURL(str);
        byte[] bArr = new byte[0];
        c newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
        newDiskPicOperate.setLock(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(newDiskPicOperate);
            bVar.f39786a = diskCancelWorker;
        }
        if (d.g().a(newDiskPicOperate)) {
            int i2 = j.H() ? 500 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i2);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            if (newDiskPicOperate.isSuccess()) {
                if (pidFromCDNURL == null || newDiskPicOperate.b() || !getIsHighQualityFromCDNURL(str)) {
                    return newDiskPicOperate.a();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static boolean getIsHighQualityFromCDNURL(String str) {
        String[] split;
        if (str != null && o.b(str)) {
            String[] split2 = str.split("/");
            if (split2.length > 3) {
                try {
                    for (String str2 : URLDecoder.decode(split2[split2.length - 3], "utf-8").split(";")) {
                        if (str2.startsWith(IAdRequestParam.COST_NAME)) {
                            String[] split3 = str2.split("=");
                            if (Integer.valueOf(split3[split3.length - 1]).intValue() <= 50) {
                                return false;
                            }
                        }
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return true;
    }

    public static String getNameMd5FromUrl(String str) {
        String pidFromCDNURL = getPidFromCDNURL(str);
        if (pidFromCDNURL != null) {
            str = pidFromCDNURL;
        }
        return TbMd5.getNameMd5FromUrl(str);
    }

    public static String getPidFromCDNURL(String str) {
        int i2;
        if (str != null && o.b(str)) {
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".");
            int lastIndexOf3 = str.lastIndexOf(".jpg");
            if (lastIndexOf3 <= 0) {
                int lastIndexOf4 = str.lastIndexOf(".webp");
                if (lastIndexOf4 <= 0) {
                    return null;
                }
                i2 = lastIndexOf4 + 5;
            } else {
                i2 = lastIndexOf3 + 4;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (lastIndexOf > 0 && lastIndexOf2 > 0) {
                stringBuffer.append(str.substring(lastIndexOf + 1, lastIndexOf2));
                stringBuffer.append(str.substring(i2));
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public static a loadBdImage(String str) {
        c newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
        if (d.g().d(newDiskPicOperate) && newDiskPicOperate.isSuccess()) {
            newDiskPicOperate.formatData(newDiskPicOperate.getData());
            Bitmap bitmap = newDiskPicOperate.getBitmap();
            if (bitmap != null) {
                return new a(bitmap, newDiskPicOperate.isGif(), str);
            }
            return null;
        }
        return null;
    }

    public static c newDiskPicOperate(String str, DiskFileOperate.Action action) {
        c cVar = new c("images", str, action);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar;
    }

    public static void updateLocal(String str, byte[] bArr, boolean z, b bVar) {
        String pidFromCDNURL = getPidFromCDNURL(str);
        c newDiskPicOperate = newDiskPicOperate(getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
        newDiskPicOperate.setGif(z);
        if (pidFromCDNURL != null) {
            newDiskPicOperate.c(getIsHighQualityFromCDNURL(str));
        } else {
            newDiskPicOperate.c(true);
        }
        newDiskPicOperate.setData(bArr);
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(newDiskPicOperate);
            bVar.f39786a = diskCancelWorker;
        }
        d.g().a(newDiskPicOperate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m17decodeToResource(byte[] bArr, Object... objArr) {
        return null;
    }

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        return null;
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        return 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        return null;
    }

    public int getProcType() {
        return this.procType;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        return true;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr = (byte[]) objArr[1];
        Bitmap Bytes2Bitmap = bArr != null ? BitmapHelper.Bytes2Bitmap(bArr) : null;
        if (Bytes2Bitmap == null) {
            if (booleanValue && str.startsWith("/")) {
                Bytes2Bitmap = d.a.c.e.p.d.d().c(str);
                if (Bytes2Bitmap != null && bArr == null) {
                    bArr = d.a.c.e.p.d.d().a(Bytes2Bitmap, 100);
                }
            } else {
                bArr = getFromLocalData(str, bVar);
                if (bArr != null) {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
        }
        if (Bytes2Bitmap != null) {
            return new a(Bytes2Bitmap, l.B(bArr), str2, bArr);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    @Override // d.a.c.e.l.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        String str3;
        String str4;
        boolean z;
        WebClient webClient;
        byte[] downloadImageBytes;
        boolean needCache;
        int lastIndexOf;
        Bitmap bitmap = null;
        if (str == null || !str.startsWith("/")) {
            boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[2])).booleanValue();
            if (str != null && str.startsWith(NCDN_PER)) {
                booleanValue = false;
            }
            if (booleanValue) {
                str3 = str;
            } else {
                str3 = TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + TbImageHelper.getInstance().getUrlQuality());
            }
            if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                int indexOf = str3.indexOf("hiphotos.baidu.com");
                if (indexOf <= 0) {
                    indexOf = str3.indexOf("tiebapic.baidu.com");
                }
                if (indexOf > 0 && (lastIndexOf = str3.lastIndexOf(".jpg")) > 0) {
                    str4 = str3.substring(0, lastIndexOf) + ".webp" + str3.substring(lastIndexOf + 4, str3.length());
                    z = true;
                    webClient = new WebClient();
                    if (bVar != null) {
                        bVar.f39786a = webClient;
                    }
                    downloadImageBytes = webClient.downloadImageBytes(str4, !booleanValue);
                    needCache = webClient.needCache();
                    if (webClient.IsRequestSuccess() && webClient.errorCode == -11) {
                        BdLog.e("BIGIMAGE imagesize too big");
                        d.a.i0.r.z.a.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "BigImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str4);
                    }
                    if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete_big2, new TypedValue());
                            downloadImageBytes = d.a.c.e.j.b.b.d(openRawResource);
                            d.a.c.e.m.a.c(openRawResource);
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    }
                    if (!webClient.IsRequestSuccess() || webClient.responseCode == 302) {
                        bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                        if (z && bitmap == null) {
                            TiebaStatic.imgError(-1012, "Webp decoding failed.", str4);
                            TbadkCoreApplication.getInst().incWebpFailureCount();
                            downloadImageBytes = webClient.downloadImageBytes(str3, !booleanValue);
                            needCache = webClient.needCache();
                            if (downloadImageBytes != null && webClient.IsRequestSuccess()) {
                                bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                            }
                        }
                    }
                    if (needCache && !webClient.isCrackPic) {
                        updateLocal(str, downloadImageBytes, false, bVar);
                    }
                    a aVar = new a(bitmap, l.B(downloadImageBytes), str, downloadImageBytes);
                    aVar.y(needCache);
                    return aVar;
                }
            }
            str4 = str3;
            z = false;
            webClient = new WebClient();
            if (bVar != null) {
            }
            downloadImageBytes = webClient.downloadImageBytes(str4, !booleanValue);
            needCache = webClient.needCache();
            if (webClient.IsRequestSuccess()) {
                BdLog.e("BIGIMAGE imagesize too big");
                d.a.i0.r.z.a.a(ImageLoaderProc.GIF_PLAY_LOG_TYPE, -1L, -1, "BigImageLoaderProc.getFromRemote", webClient.errorCode, "image size too large", "url", str4);
            }
            if (webClient.responseCode == 302) {
                InputStream openRawResource2 = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete_big2, new TypedValue());
                downloadImageBytes = d.a.c.e.j.b.b.d(openRawResource2);
                d.a.c.e.m.a.c(openRawResource2);
            }
            if (!webClient.IsRequestSuccess()) {
            }
            bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
            if (z) {
                TiebaStatic.imgError(-1012, "Webp decoding failed.", str4);
                TbadkCoreApplication.getInst().incWebpFailureCount();
                downloadImageBytes = webClient.downloadImageBytes(str3, !booleanValue);
                needCache = webClient.needCache();
                if (downloadImageBytes != null) {
                    bitmap = BitmapHelper.Bytes2Bitmap(downloadImageBytes);
                }
            }
            if (needCache) {
                updateLocal(str, downloadImageBytes, false, bVar);
            }
            a aVar2 = new a(bitmap, l.B(downloadImageBytes), str, downloadImageBytes);
            aVar2.y(needCache);
            return aVar2;
        }
        return null;
    }
}
