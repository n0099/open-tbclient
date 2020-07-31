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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean bbj();

    public abstract boolean bbk();

    public abstract int bbl();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.bkk().zV(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.TY.resourceFromType = "memory";
        checkIsValidPicMemoryCache.TY.costTime = 0L;
        checkIsValidPicMemoryCache.TY.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.u.lo();
        lo.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c yc = yc(au.getNameMd5FromUrl(str2));
        if (yc == null) {
            return null;
        }
        yc.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        yc.setSdCard(false);
        yc.setSubFolder(true);
        yc.setSavedCache(true);
        yc.setIsFormatData(false);
        yc.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(yc);
            aVar.LH = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.kh().c(yc)) {
            com.baidu.tbadk.core.util.u.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
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
        if (!yc.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(yc, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(lo, str2, true, lo.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.u.a(lo, str2, false, lo.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.TY.resourceFromType = "disk";
            aVar2.TY.costTime = lo.getTimeCost();
            aVar2.TY.isScuess = true;
            return aVar2;
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0206  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] am;
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
        com.baidu.adp.lib.stats.a lo = com.baidu.tbadk.core.util.u.lo();
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
                    aVar.LH = iVar;
                }
                am = iVar.am(str3, isFromCDN);
                boolean bbf = iVar.bbf();
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.bbe()) {
                    if (iVar.responseCode == 302 && (17 == bbl() || 18 == bbl() || 13 == bbl() || 14 == bbl())) {
                        if (iVar.eco != null) {
                            com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "redirect", lo.getTimeCost(), iVar.bbh(), 0L, bbl());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, bbf);
                            if (a != null) {
                                a.TY.resourceFromType = "net";
                                a.TY.costTime = lo.getTimeCost();
                                a.TY.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.kU().Le) {
                        long j2 = 0;
                        if (am != null) {
                            j2 = am.length;
                        }
                        com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "NetworkError", lo.getTimeCost(), iVar.bbh(), j2, bbl());
                        return null;
                    }
                }
                if (am != null) {
                    if (!iVar.kU().Le) {
                        com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "ByteIsNull", lo.getTimeCost(), iVar.bbh(), 0L, bbl());
                    }
                    return null;
                }
                if (am.length > 1) {
                    k.bbn().t(am.length, lo.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(lo, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "InputToByteSucc", lo.getTimeCost(), iVar.bbh(), am.length, bbl());
                } else {
                    com.baidu.tbadk.core.util.u.a(lo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eco, "bytes<1", lo.getTimeCost(), iVar.bbh(), am.length, bbl());
                }
                com.baidu.adp.lib.stats.a lo2 = com.baidu.tbadk.core.util.u.lo();
                lo2.startTimer();
                com.baidu.tbadk.imageManager.c.bkk().freePicCache(TbConfig.getPbImageSize() + am.length);
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a2 = a(am, rect, sb2);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (z && a2 == null) {
                    TiebaStatic.imgError(-1012, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    byte[] am2 = iVar.am(o, !isFromCDN);
                    boolean bbf2 = iVar.bbf();
                    lo2.startTimer();
                    if (am2 == null || !iVar.bbe()) {
                        j = currentTimeMillis2;
                        z3 = bbf2;
                        bArr = am2;
                        z2 = false;
                        sb = sb2;
                        bitmap = a2;
                    } else {
                        StringBuilder sb3 = new StringBuilder(100);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        Bitmap a3 = a(am2, rect, sb3);
                        j = System.currentTimeMillis() - currentTimeMillis3;
                        z3 = bbf2;
                        bArr = am2;
                        z2 = false;
                        sb = sb3;
                        bitmap = a3;
                    }
                } else {
                    j = currentTimeMillis2;
                    sb = sb2;
                    bArr = am;
                    z2 = z;
                    bitmap = a2;
                    z3 = bbf;
                }
                if (bArr == null || bitmap == null) {
                    if (bArr == null) {
                        com.baidu.tbadk.core.util.u.a(lo2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", lo2.getTimeCost(), sb.toString(), iVar.eco);
                    } else {
                        com.baidu.tbadk.core.util.u.a(lo2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", lo2.getTimeCost(), sb.toString(), iVar.eco);
                    }
                    return null;
                }
                boolean z4 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(bArr);
                Bitmap e = e(bitmap, dip2px, dip2px2);
                if (e == null) {
                    com.baidu.tbadk.core.util.u.a(lo2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", lo2.getTimeCost(), sb.toString(), iVar.eco);
                    return null;
                }
                com.baidu.tbadk.core.util.u.a(lo2, str, str3, true, isFromCDN, z2, bArr.length, "", lo2.getTimeCost(), sb.toString(), iVar.eco);
                com.baidu.adp.widget.ImageView.a a4 = a(str, str2, aVar, null, e, z4, iVar, bArr, rect, z3);
                if (a4 != null) {
                    a4.TY.resourceFromType = "net";
                    a4.TY.costTime = lo.getTimeCost();
                    a4.TY.isScuess = true;
                    a4.TY.Ua = j;
                }
                return a4;
            }
        }
        z = false;
        str3 = o;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        am = iVar.am(str3, isFromCDN);
        boolean bbf3 = iVar.bbf();
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.bbe()) {
        }
        if (am != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.bkk().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (v(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.ect) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
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
                    aVar.LH = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean lq() {
        return com.baidu.tbadk.core.k.aTv().isShowImages();
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aD(i);
            aVar.aE(i2);
            com.baidu.tbadk.imageManager.c.bkk().c(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(as.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + at.baS().getUrlQuality());
            sb.append("&first_gif=1");
            if (bbj()) {
                sb.append("&ispv=1");
            }
            if (bbk()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c yc(String str) {
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
    public boolean v(Bitmap bitmap) {
        return bitmap != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel lr() {
        return k.bbn().lr();
    }

    @Override // com.baidu.adp.lib.e.e
    public int ls() {
        return 1;
    }

    public static boolean aj(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.getNameMd5FromUrl(com.baidu.adp.lib.e.c.ln().genCacheKey(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a ak(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.e.c.ln().genCacheKey(str, i);
        String nameMd5FromUrl = au.getNameMd5FromUrl(genCacheKey);
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
