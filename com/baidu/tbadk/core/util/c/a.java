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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean bur();

    public abstract boolean bus();

    public abstract int but();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.adp.widget.ImageView.a Ei = com.baidu.tbadk.imageManager.c.bDV().Ei(str);
        if (Ei != null && Ei.getRawBitmap() != null && !Ei.getRawBitmap().isRecycled()) {
            Ei.Wj.resourceFromType = "memory";
            Ei.Wj.isScuess = true;
            Ei.Wj.Wl = System.currentTimeMillis() - currentTimeMillis;
        }
        return Ei;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Cn = Cn(aw.getNameMd5FromUrl(str2));
        if (Cn == null) {
            return null;
        }
        Cn.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Cn.setSdCard(false);
        Cn.setSubFolder(true);
        Cn.setSavedCache(true);
        Cn.setIsFormatData(false);
        Cn.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(Cn);
            aVar.NM = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (com.baidu.adp.lib.Disk.d.lL().c(Cn)) {
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
            com.baidu.adp.widget.ImageView.a a2 = Cn.isSuccess() ? a(Cn, str2, i, i2) : null;
            if (a2 != null) {
                a2.Wj.resourceFromType = "disk";
                a2.Wj.isScuess = true;
                a2.Wj.Wm = System.currentTimeMillis() - currentTimeMillis;
                return a2;
            }
            return a2;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0212  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] ax;
        long j;
        boolean z2;
        byte[] bArr;
        boolean z3;
        Bitmap bitmap;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a mT = com.baidu.tbadk.core.util.u.mT();
        mT.startTimer();
        long currentTimeMillis = System.currentTimeMillis();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String p = isFromCDN ? str : p(str, dip2px, dip2px2);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = p.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = p.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = p.lastIndexOf(".jpg")) > 0) {
                str3 = p.substring(0, lastIndexOf) + ".webp" + p.substring(lastIndexOf + 4, p.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.NM = iVar;
                }
                ax = iVar.ax(str3, isFromCDN);
                boolean bun = iVar.bun();
                Rect rect = new Rect();
                StringBuilder sb = new StringBuilder(100);
                if (!iVar.bum()) {
                    if (iVar.responseCode == 302 && (17 == but() || 18 == but() || 13 == but() || 14 == but())) {
                        if (iVar.eVk != null) {
                            com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eVk, "", mT.getTimeCost(), iVar.bup(), 0L, but());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, bun);
                            if (a2 != null) {
                                a2.Wj.resourceFromType = "net";
                                a2.Wj.isScuess = false;
                                a2.Wj.Wn = System.currentTimeMillis() - currentTimeMillis;
                                a2.Wj.reason = "redirect";
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a2;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.my().Nj) {
                        long j2 = 0;
                        if (ax != null) {
                            j2 = ax.length;
                        }
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eVk, "NetworkError", mT.getTimeCost(), iVar.bup(), j2, but());
                        return null;
                    }
                }
                if (ax != null) {
                    if (!iVar.my().Nj) {
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eVk, "ByteIsNull", mT.getTimeCost(), iVar.bup(), 0L, but());
                    }
                    return null;
                }
                if (ax.length > 1) {
                    k.buv().t(ax.length, mT.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(mT, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eVk, "InputToByteSucc", mT.getTimeCost(), iVar.bup(), ax.length, but());
                } else {
                    com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eVk, "bytes<1", mT.getTimeCost(), iVar.bup(), ax.length, but());
                }
                com.baidu.adp.lib.stats.a mT2 = com.baidu.tbadk.core.util.u.mT();
                mT2.startTimer();
                com.baidu.tbadk.imageManager.c.bDV().freePicCache(TbConfig.getPbImageSize() + ax.length);
                long currentTimeMillis2 = System.currentTimeMillis();
                Bitmap a3 = a(ax, rect, sb);
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                if (z && a3 == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    byte[] ax2 = iVar.ax(p, !isFromCDN);
                    boolean bun2 = iVar.bun();
                    mT2.startTimer();
                    if (ax2 == null || !iVar.bum()) {
                        j = currentTimeMillis3;
                        z2 = bun2;
                        bArr = ax2;
                        z3 = false;
                        bitmap = a3;
                    } else {
                        long currentTimeMillis4 = System.currentTimeMillis();
                        Bitmap a4 = a(ax2, rect, sb);
                        j = System.currentTimeMillis() - currentTimeMillis4;
                        z2 = bun2;
                        bArr = ax2;
                        z3 = false;
                        bitmap = a4;
                    }
                } else {
                    j = currentTimeMillis3;
                    z2 = bun;
                    bArr = ax;
                    z3 = z;
                    bitmap = a3;
                }
                if (bArr == null || bitmap == null) {
                    if (bArr == null) {
                        com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z3, 0, "TmpIsNull", mT2.getTimeCost(), sb.toString(), iVar.eVk);
                    } else {
                        com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z3, bArr.length, "ConvertError", mT2.getTimeCost(), sb.toString(), iVar.eVk);
                    }
                    return null;
                }
                boolean z4 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(bArr);
                Bitmap e = e(bitmap, dip2px, dip2px2);
                if (e == null) {
                    com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z3, bArr.length, "ResizeError", mT2.getTimeCost(), sb.toString(), iVar.eVk);
                    return null;
                }
                com.baidu.tbadk.core.util.u.a(mT2, str, str3, true, isFromCDN, z3, bArr.length, "", mT2.getTimeCost(), sb.toString(), iVar.eVk);
                com.baidu.adp.widget.ImageView.a a5 = a(str, str2, aVar, null, e, z4, iVar, bArr, rect, z2);
                if (a5 != null) {
                    a5.Wj.resourceFromType = "net";
                    a5.Wj.costTime = mT.getTimeCost();
                    a5.Wj.isScuess = true;
                    a5.Wj.Wo = j;
                }
                return a5;
            }
        }
        z = false;
        str3 = p;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        ax = iVar.ax(str3, isFromCDN);
        boolean bun3 = iVar.bun();
        Rect rect2 = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.bum()) {
        }
        if (ax != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.bDV().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (v(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.eVp) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                com.baidu.adp.lib.Disk.d.lL().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.NM = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mV() {
        return com.baidu.tbadk.core.k.blV().isShowImages();
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aO(i);
            aVar.aP(i2);
            com.baidu.tbadk.imageManager.c.bDV().c(str, aVar);
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
            sb.append("&qulity=" + av.btX().getUrlQuality());
            sb.append("&first_gif=1");
            if (bur()) {
                sb.append("&ispv=1");
            }
            if (bus()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c Cn(String str) {
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
    public BdAsyncTaskParallel mW() {
        return k.buv().mW();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mX() {
        return 1;
    }

    public static boolean an(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.getNameMd5FromUrl(com.baidu.adp.lib.e.c.mS().genCacheKey(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a ao(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.e.c.mS().genCacheKey(str, i);
        String nameMd5FromUrl = aw.getNameMd5FromUrl(genCacheKey);
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
            if (com.baidu.adp.lib.Disk.d.lL().b(cVar) && cVar.isSuccess()) {
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
