package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    public abstract int btq();

    public abstract int btr();

    public abstract int bts();

    public abstract boolean isFromCDN();

    @Override // com.baidu.adp.lib.e.e
    public boolean mx() {
        return com.baidu.tbadk.core.k.bkV().isShowImages();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a Dp = com.baidu.tbadk.imageManager.c.bCS().Dp(str);
        if (z) {
            com.baidu.adp.lib.e.a.c(Dp != null, System.currentTimeMillis() - currentTimeMillis);
        }
        return Dp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a aVar = null;
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Bx = Bx(aw.getNameMd5FromUrl(str2));
        if (Bx == null) {
            return null;
        }
        Bx.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Bx.setSdCard(false);
        Bx.setSubFolder(true);
        Bx.setSavedCache(true);
        Bx.setIsFormatData(false);
        Bx.setLock(bArr);
        if (bVar != null) {
            d dVar = new d();
            dVar.f(Bx);
            bVar.OL = dVar;
        }
        if (!com.baidu.adp.lib.Disk.d.lg().c(Bx)) {
            com.baidu.adp.lib.e.a.d(false, 0L);
            return null;
        }
        int i3 = 2000;
        if (com.baidu.adp.lib.util.j.isWifiNet()) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (Bx.isSuccess()) {
            aVar = a(Bx, str2, i, i2);
        }
        com.baidu.adp.lib.e.a.d(aVar != null, System.currentTimeMillis() - currentTimeMillis);
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0225  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, int i, int i2, com.baidu.adp.lib.e.b bVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.b.i iVar;
        byte[] aw;
        boolean z2;
        byte[] bArr;
        com.baidu.adp.widget.ImageView.a aVar;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int btq = i == 0 ? btq() : i;
        int btr = i2 == 0 ? btr() : i2;
        int dip2px = btq == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : btq;
        if (btr == 0) {
            btr = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String p = isFromCDN ? str : p(str, dip2px, btr);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = p.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = p.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = p.lastIndexOf(".jpg")) > 0) {
                str3 = p.substring(0, lastIndexOf) + ".webp" + p.substring(lastIndexOf + 4, p.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.b.i();
                if (bVar != null) {
                    bVar.OL = iVar;
                }
                aw = iVar.aw(str3, isFromCDN);
                boolean btm = iVar.btm();
                Rect rect = new Rect();
                if (!iVar.btl()) {
                    if (iVar.responseCode == 302 && (17 == bts() || 18 == bts() || 13 == bts() || 14 == bts())) {
                        com.baidu.adp.lib.e.a.a(false, str3, iVar.fdQ, 0L, 0L);
                        if (iVar.fdQ != null) {
                            u.a(str, false, str3, Boolean.valueOf(z), iVar.fdQ, "redirect", System.currentTimeMillis() - currentTimeMillis, iVar.bto(), bts());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(f, rect);
                            boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(f);
                            if (!v(Bytes2NineBitmap)) {
                                aVar = null;
                            } else {
                                aVar = new com.baidu.adp.widget.ImageView.a(Bytes2NineBitmap, z3, str, rect);
                                aVar.setNeedCache(btm);
                                a(str2, f, Boolean.valueOf(btm), Boolean.valueOf(iVar.fdV), Boolean.valueOf(z3), bVar, Bytes2NineBitmap);
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return aVar;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.lV().Od) {
                        com.baidu.adp.lib.e.a.a(false, str3, iVar.fdQ, 0L, 0L);
                        u.a(str, false, str3, Boolean.valueOf(z), iVar.fdQ, "NetworkError", System.currentTimeMillis() - currentTimeMillis, iVar.bto(), bts());
                        return null;
                    }
                }
                if (aw != null) {
                    if (!iVar.lV().Od) {
                        com.baidu.adp.lib.e.a.a(false, str3, iVar.fdQ, 0L, 0L);
                        u.a(str, false, str3, Boolean.valueOf(z), iVar.fdQ, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, iVar.bto(), bts());
                    }
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.e.a.a(aw.length > 1, str3, iVar.fdQ, currentTimeMillis2, aw.length);
                if (aw.length > 1) {
                    g.btu().u(aw.length, currentTimeMillis2);
                    u.a(str, true, str3, Boolean.valueOf(z), iVar.fdQ, "InputToByteSucc", currentTimeMillis2, iVar.bto(), bts());
                } else {
                    u.a(str, false, str3, Boolean.valueOf(z), iVar.fdQ, "bytes<1", currentTimeMillis2, iVar.bto(), bts());
                }
                com.baidu.tbadk.imageManager.c.bCS().freePicCache(TbConfig.getPbImageSize() + aw.length);
                Bitmap rawBitmap = a(aw, rect).getRawBitmap();
                if (z && rawBitmap == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    bArr = iVar.aw(p, !isFromCDN);
                    boolean btm2 = iVar.btm();
                    if (bArr == null || !iVar.btl()) {
                        z2 = btm2;
                    } else {
                        rawBitmap = a(bArr, rect).getRawBitmap();
                        z2 = btm2;
                    }
                } else {
                    z2 = btm;
                    bArr = aw;
                }
                if (bArr == null || rawBitmap == null) {
                    return null;
                }
                boolean z4 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(bArr);
                Bitmap e = e(rawBitmap, dip2px, btr);
                if (e != null && v(e)) {
                    com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a(e, z4, str, rect);
                    aVar2.setNeedCache(z2);
                    a(str2, bArr, Boolean.valueOf(z2), Boolean.valueOf(iVar.fdV), Boolean.valueOf(z4), bVar, e);
                    return aVar2;
                }
                return null;
            }
        }
        z = false;
        str3 = p;
        iVar = new com.baidu.tbadk.core.util.b.i();
        if (bVar != null) {
        }
        aw = iVar.aw(str3, isFromCDN);
        boolean btm3 = iVar.btm();
        Rect rect2 = new Rect();
        if (!iVar.btl()) {
        }
        if (aw != null) {
        }
    }

    public com.baidu.adp.widget.ImageView.a a(byte[] bArr, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        com.baidu.adp.lib.e.a.f(decodeByteArray != null, System.currentTimeMillis() - currentTimeMillis);
        return new com.baidu.adp.widget.ImageView.a(decodeByteArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.bCS().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if ((obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aP(i);
            aVar.aQ(i2);
            com.baidu.tbadk.imageManager.c.bCS().b(str, aVar);
            com.baidu.adp.lib.e.a.h(true, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public void a(String str, byte[] bArr, Object... objArr) {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(booleanValue3);
                com.baidu.adp.lib.Disk.d.lg().c(cVar);
                com.baidu.adp.lib.e.b bVar = (com.baidu.adp.lib.e.b) objArr[3];
                if (bVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    bVar.OL = dVar;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String p(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(au.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + av.bsV().getUrlQuality());
            sb.append("&first_gif=1");
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c Bx(String str) {
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

    protected boolean v(Bitmap bitmap) {
        return bitmap != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel my() {
        return g.btu().my();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mz() {
        return 1;
    }

    public static boolean as(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(com.baidu.adp.lib.e.d.mw().genCacheKey(str, i)), DiskFileOperate.Action.INFO);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a at(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.e.d.mw().genCacheKey(str, i);
        String nameMd5FromUrl = aw.getNameMd5FromUrl(genCacheKey);
        if (i == 38) {
            return h.a(nameMd5FromUrl, (com.baidu.adp.lib.e.b) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSavedCache(true);
        cVar.setSdCard(false);
        if (com.baidu.adp.lib.Disk.d.lg().b(cVar) && cVar.isSuccess()) {
            cVar.formatData(cVar.getData());
            Bitmap bitmap = cVar.getBitmap();
            if (bitmap != null) {
                return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), genCacheKey);
            }
            return null;
        }
        return null;
    }
}
