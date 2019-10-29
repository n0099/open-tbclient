package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean ani();

    public abstract boolean anj();

    public abstract int ank();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.avu().pY(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.xD.resourceFromType = "memory";
        checkIsValidPicMemoryCache.xD.costTime = 0L;
        checkIsValidPicMemoryCache.xD.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a fU = com.baidu.tbadk.core.util.s.fU();
        fU.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c oi = oi(as.getNameMd5FromUrl(str2));
        if (oi == null) {
            return null;
        }
        oi.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oi.setSdCard(false);
        oi.setSubFolder(true);
        oi.setSavedCache(true);
        oi.setIsFormatData(false);
        oi.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(oi);
            aVar.pM = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.eP().c(oi)) {
            com.baidu.tbadk.core.util.s.a(fU, str2, false, fU.getTimeCost(), isWifiNet);
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
        if (!oi.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(oi, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(fU, str2, true, fU.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.s.a(fU, str2, false, fU.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.xD.resourceFromType = "disk";
            aVar2.xD.costTime = fU.getTimeCost();
            aVar2.xD.isScuess = true;
            return aVar2;
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0294  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] P;
        StringBuilder sb;
        boolean z2;
        Bitmap bitmap;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a fU = com.baidu.tbadk.core.util.s.fU();
        fU.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String l = isFromCDN ? str : l(str, dip2px, height);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.ft().af("webp_enable") == 1) {
            int indexOf = l.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = l.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = l.lastIndexOf(".jpg")) > 0) {
                str3 = l.substring(0, lastIndexOf) + ".webp" + l.substring(lastIndexOf + 4, l.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.pM = iVar;
                }
                P = iVar.P(str3, isFromCDN);
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.amZ()) {
                    if (iVar.responseCode == 302 && (17 == ank() || 18 == ank() || 13 == ank() || 14 == ank())) {
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect);
                            if (a != null) {
                                a.xD.resourceFromType = "net";
                                a.xD.costTime = fU.getTimeCost();
                                a.xD.isScuess = true;
                            }
                            com.baidu.adp.lib.g.a.close(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.fK().pz) {
                        long j = 0;
                        if (P != null) {
                            j = P.length;
                        }
                        com.baidu.tbadk.core.util.s.a(fU, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.clh, "NetworkError", fU.getTimeCost(), iVar.anb(), j, ank());
                        return null;
                    }
                }
                if (P != null) {
                    if (!iVar.fK().pz) {
                        com.baidu.tbadk.core.util.s.a(fU, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.clh, "ByteIsNull", fU.getTimeCost(), iVar.anb(), 0L, ank());
                    }
                    return null;
                }
                if (P.length > 1) {
                    j.anm().o(P.length, fU.getTimeCost());
                    com.baidu.tbadk.core.util.s.a(fU, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.clh, "InputToByteSucc", fU.getTimeCost(), iVar.anb(), P.length, ank());
                } else {
                    com.baidu.tbadk.core.util.s.a(fU, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.clh, "bytes<1", fU.getTimeCost(), iVar.anb(), P.length, ank());
                }
                com.baidu.adp.lib.stats.a fU2 = com.baidu.tbadk.core.util.s.fU();
                fU2.startTimer();
                com.baidu.tbadk.imageManager.c.avu().freePicCache(TbConfig.getPbImageSize() + P.length);
                Bitmap a2 = a(P, rect, sb2);
                if (z && a2 == null) {
                    z = false;
                    TiebaStatic.imgError(-1012, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    P = iVar.P(l, !isFromCDN);
                    fU2.startTimer();
                    if (P != null && iVar.amZ()) {
                        sb = new StringBuilder(100);
                        bitmap = a(P, rect, sb);
                        z2 = false;
                        if (P != null || bitmap == null) {
                            if (P != null) {
                                com.baidu.tbadk.core.util.s.a(fU2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fU2.getTimeCost(), sb.toString(), iVar.clh);
                            } else {
                                com.baidu.tbadk.core.util.s.a(fU2, str, str3, false, isFromCDN, z2, P.length, "ConvertError", fU2.getTimeCost(), sb.toString(), iVar.clh);
                            }
                            return null;
                        }
                        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(P);
                        Bitmap e = e(bitmap, dip2px, height);
                        if (e == null) {
                            com.baidu.tbadk.core.util.s.a(fU2, str, str3, false, isFromCDN, z2, P.length, "ResizeError", fU2.getTimeCost(), sb.toString(), iVar.clh);
                            return null;
                        }
                        com.baidu.tbadk.core.util.s.a(fU2, str, str3, true, isFromCDN, z2, P.length, "", fU2.getTimeCost(), sb.toString(), iVar.clh);
                        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, e, z3, iVar, P, rect);
                        if (a3 != null) {
                            a3.xD.resourceFromType = "net";
                            a3.xD.costTime = fU.getTimeCost();
                            a3.xD.isScuess = true;
                            return a3;
                        }
                        return a3;
                    }
                }
                sb = sb2;
                z2 = z;
                bitmap = a2;
                if (P != null) {
                }
                if (P != null) {
                }
                return null;
            }
        }
        z = false;
        str3 = l;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        P = iVar.P(str3, isFromCDN);
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.amZ()) {
        }
        if (P != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.avu().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (o(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.clm) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                com.baidu.adp.lib.Disk.d.eP().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.pM = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fW() {
        return com.baidu.tbadk.core.i.agq().isShowImages();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.ac(i);
            aVar.ad(i2);
            com.baidu.tbadk.imageManager.c.avu().c(str, aVar);
        }
    }

    protected String l(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(aq.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.amO().getUrlQuality());
            sb.append("&first_gif=1");
            if (ani()) {
                sb.append("&ispv=1");
            }
            if (anj()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c oi(String str) {
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
    public boolean o(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fX() {
        return j.anm().fX();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fY() {
        return 1;
    }

    public static boolean P(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(com.baidu.adp.lib.f.c.fT().genCacheKey(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a Q(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.f.c.fT().genCacheKey(str, i);
        String nameMd5FromUrl = as.getNameMd5FromUrl(genCacheKey);
        if (i == 38) {
            return k.a(nameMd5FromUrl, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setIsFormatData(false);
            cVar.setSavedCache(true);
            cVar.setSdCard(false);
            if (com.baidu.adp.lib.Disk.d.eP().b(cVar) && cVar.isSuccess()) {
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
