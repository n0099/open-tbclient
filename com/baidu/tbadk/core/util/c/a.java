package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean aXi();

    public abstract boolean aXj();

    public abstract int aXk();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.bgz().yO(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Ue.resourceFromType = "memory";
        checkIsValidPicMemoryCache.Ue.costTime = 0L;
        checkIsValidPicMemoryCache.Ue.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.t.lo();
        lo.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c wU = wU(at.getNameMd5FromUrl(str2));
        if (wU == null) {
            return null;
        }
        wU.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        wU.setSdCard(false);
        wU.setSubFolder(true);
        wU.setSavedCache(true);
        wU.setIsFormatData(false);
        wU.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(wU);
            aVar.LI = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.kh().c(wU)) {
            com.baidu.tbadk.core.util.t.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
            return null;
        }
        int i3 = 2000;
        if (isWifiNet) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!wU.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(wU, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.t.a(lo, str2, true, lo.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.t.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.Ue.resourceFromType = "disk";
            aVar2.Ue.costTime = lo.getTimeCost();
            aVar2.Ue.isScuess = true;
            return aVar2;
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0207  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] an;
        long j;
        StringBuilder sb;
        byte[] bArr;
        boolean z2;
        Bitmap bitmap;
        boolean z3;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.t.lo();
        lo.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String o = isFromCDN ? str : o(str, dip2px, dip2px2);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = o.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = o.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = o.lastIndexOf(".jpg")) > 0) {
                str3 = o.substring(0, lastIndexOf) + ".webp" + o.substring(lastIndexOf + 4, o.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.LI = iVar;
                }
                an = iVar.an(str3, isFromCDN);
                boolean aXe = iVar.aXe();
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.aXd()) {
                    if (iVar.responseCode == 302 && (17 == aXk() || 18 == aXk() || 13 == aXk() || 14 == aXk())) {
                        if (iVar.dVT != null) {
                            com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "redirect", lo.getTimeCost(), iVar.aXg(), 0L, aXk());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, aXe);
                            if (a != null) {
                                a.Ue.resourceFromType = "net";
                                a.Ue.costTime = lo.getTimeCost();
                                a.Ue.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.kU().Le) {
                        long j2 = 0;
                        if (an != null) {
                            j2 = an.length;
                        }
                        com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "NetworkError", lo.getTimeCost(), iVar.aXg(), j2, aXk());
                        return null;
                    }
                }
                if (an != null) {
                    if (!iVar.kU().Le) {
                        com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "ByteIsNull", lo.getTimeCost(), iVar.aXg(), 0L, aXk());
                    }
                    return null;
                }
                if (an.length > 1) {
                    k.aXm().t(an.length, lo.getTimeCost());
                    com.baidu.tbadk.core.util.t.a(lo, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "InputToByteSucc", lo.getTimeCost(), iVar.aXg(), an.length, aXk());
                } else {
                    com.baidu.tbadk.core.util.t.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.dVT, "bytes<1", lo.getTimeCost(), iVar.aXg(), an.length, aXk());
                }
                com.baidu.adp.lib.stats.a lo2 = com.baidu.tbadk.core.util.t.lo();
                lo2.startTimer();
                com.baidu.tbadk.imageManager.c.bgz().freePicCache(TbConfig.getPbImageSize() + an.length);
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = a(an, rect, sb2);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (z && a2 == null) {
                    TiebaStatic.imgError(-1012, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    byte[] an2 = iVar.an(o, !isFromCDN);
                    boolean aXe2 = iVar.aXe();
                    lo2.startTimer();
                    if (an2 == null || !iVar.aXd()) {
                        j = currentTimeMillis2;
                        z3 = aXe2;
                        bArr = an2;
                        z2 = false;
                        sb = sb2;
                        bitmap = a2;
                    } else {
                        StringBuilder sb3 = new StringBuilder(100);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        Bitmap a3 = a(an2, rect, sb3);
                        j = System.currentTimeMillis() - currentTimeMillis3;
                        z3 = aXe2;
                        bArr = an2;
                        z2 = false;
                        sb = sb3;
                        bitmap = a3;
                    }
                } else {
                    j = currentTimeMillis2;
                    sb = sb2;
                    bArr = an;
                    z2 = z;
                    bitmap = a2;
                    z3 = aXe;
                }
                if (bArr == null || bitmap == null) {
                    if (bArr == null) {
                        com.baidu.tbadk.core.util.t.a(lo2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", lo2.getTimeCost(), sb.toString(), iVar.dVT);
                    } else {
                        com.baidu.tbadk.core.util.t.a(lo2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", lo2.getTimeCost(), sb.toString(), iVar.dVT);
                    }
                    return null;
                }
                boolean z4 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(bArr);
                Bitmap e = e(bitmap, dip2px, dip2px2);
                if (e == null) {
                    com.baidu.tbadk.core.util.t.a(lo2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", lo2.getTimeCost(), sb.toString(), iVar.dVT);
                    return null;
                }
                com.baidu.tbadk.core.util.t.a(lo2, str, str3, true, isFromCDN, z2, bArr.length, "", lo2.getTimeCost(), sb.toString(), iVar.dVT);
                com.baidu.adp.widget.ImageView.a a4 = a(str, str2, aVar, null, e, z4, iVar, bArr, rect, z3);
                if (a4 != null) {
                    a4.Ue.resourceFromType = "net";
                    a4.Ue.costTime = lo.getTimeCost();
                    a4.Ue.isScuess = true;
                    a4.Ue.Ug = j;
                }
                return a4;
            }
        }
        z = false;
        str3 = o;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        an = iVar.an(str3, isFromCDN);
        boolean aXe3 = iVar.aXe();
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.aXd()) {
        }
        if (an != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.bgz().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (s(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.dVY) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, at.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                com.baidu.adp.lib.Disk.d.kh().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.LI = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean lq() {
        return com.baidu.tbadk.core.k.aPA().isShowImages();
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aB(i);
            aVar.aC(i2);
            com.baidu.tbadk.imageManager.c.bgz().c(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ar.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + as.aWR().getUrlQuality());
            sb.append("&first_gif=1");
            if (aXi()) {
                sb.append("&ispv=1");
            }
            if (aXj()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c wU(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        cVar.formatData(cVar.getData());
        Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i, i2);
        if (checkBitmapSize != null) {
            return new com.baidu.adp.widget.ImageView.a(checkBitmapSize, cVar.isGif(), str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s(Bitmap bitmap) {
        return bitmap != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel lr() {
        return k.aXm().lr();
    }

    @Override // com.baidu.adp.lib.e.e
    public int ls() {
        return 1;
    }

    public static boolean ai(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, at.getNameMd5FromUrl(com.baidu.adp.lib.e.c.ln().genCacheKey(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a aj(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.e.c.ln().genCacheKey(str, i);
        String nameMd5FromUrl = at.getNameMd5FromUrl(genCacheKey);
        if (i == 38) {
            return l.a(nameMd5FromUrl, (com.baidu.adp.lib.e.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setIsFormatData(false);
            cVar.setSavedCache(true);
            cVar.setSdCard(false);
            if (com.baidu.adp.lib.Disk.d.kh().b(cVar) && cVar.isSuccess()) {
                cVar.formatData(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), genCacheKey);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
