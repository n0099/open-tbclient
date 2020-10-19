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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean bnn();

    public abstract boolean bno();

    public abstract int bnp();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.bwL().Du(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Vm.resourceFromType = "memory";
        checkIsValidPicMemoryCache.Vm.costTime = 0L;
        checkIsValidPicMemoryCache.Vm.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a mT = com.baidu.tbadk.core.util.u.mT();
        mT.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c Bz = Bz(av.getNameMd5FromUrl(str2));
        if (Bz == null) {
            return null;
        }
        Bz.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        Bz.setSdCard(false);
        Bz.setSubFolder(true);
        Bz.setSavedCache(true);
        Bz.setIsFormatData(false);
        Bz.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(Bz);
            aVar.MR = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.lL().c(Bz)) {
            com.baidu.tbadk.core.util.u.a(mT, str2, false, mT.getTimeCost(), isWifiNet);
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
        if (!Bz.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(Bz, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(mT, str2, true, mT.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.u.a(mT, str2, false, mT.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.Vm.resourceFromType = "disk";
            aVar2.Vm.costTime = mT.getTimeCost();
            aVar2.Vm.isScuess = true;
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
        byte[] au;
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
        com.baidu.adp.lib.stats.a mT = com.baidu.tbadk.core.util.u.mT();
        mT.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String n = isFromCDN ? str : n(str, dip2px, dip2px2);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = n.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = n.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = n.lastIndexOf(".jpg")) > 0) {
                str3 = n.substring(0, lastIndexOf) + ".webp" + n.substring(lastIndexOf + 4, n.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.MR = iVar;
                }
                au = iVar.au(str3, isFromCDN);
                boolean bnj = iVar.bnj();
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.bni()) {
                    if (iVar.responseCode == 302 && (17 == bnp() || 18 == bnp() || 13 == bnp() || 14 == bnp())) {
                        if (iVar.eAG != null) {
                            com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "redirect", mT.getTimeCost(), iVar.bnl(), 0L, bnp());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, bnj);
                            if (a2 != null) {
                                a2.Vm.resourceFromType = "net";
                                a2.Vm.costTime = mT.getTimeCost();
                                a2.Vm.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a2;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.my().Mn) {
                        long j2 = 0;
                        if (au != null) {
                            j2 = au.length;
                        }
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "NetworkError", mT.getTimeCost(), iVar.bnl(), j2, bnp());
                        return null;
                    }
                }
                if (au != null) {
                    if (!iVar.my().Mn) {
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "ByteIsNull", mT.getTimeCost(), iVar.bnl(), 0L, bnp());
                    }
                    return null;
                }
                if (au.length > 1) {
                    k.bnr().u(au.length, mT.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(mT, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "InputToByteSucc", mT.getTimeCost(), iVar.bnl(), au.length, bnp());
                } else {
                    com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eAG, "bytes<1", mT.getTimeCost(), iVar.bnl(), au.length, bnp());
                }
                com.baidu.adp.lib.stats.a mT2 = com.baidu.tbadk.core.util.u.mT();
                mT2.startTimer();
                com.baidu.tbadk.imageManager.c.bwL().freePicCache(TbConfig.getPbImageSize() + au.length);
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a3 = a(au, rect, sb2);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (z && a3 == null) {
                    TiebaStatic.imgError(-1012, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    byte[] au2 = iVar.au(n, !isFromCDN);
                    boolean bnj2 = iVar.bnj();
                    mT2.startTimer();
                    if (au2 == null || !iVar.bni()) {
                        j = currentTimeMillis2;
                        z3 = bnj2;
                        bArr = au2;
                        z2 = false;
                        sb = sb2;
                        bitmap = a3;
                    } else {
                        StringBuilder sb3 = new StringBuilder(100);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        Bitmap a4 = a(au2, rect, sb3);
                        j = System.currentTimeMillis() - currentTimeMillis3;
                        z3 = bnj2;
                        bArr = au2;
                        z2 = false;
                        sb = sb3;
                        bitmap = a4;
                    }
                } else {
                    j = currentTimeMillis2;
                    sb = sb2;
                    bArr = au;
                    z2 = z;
                    bitmap = a3;
                    z3 = bnj;
                }
                if (bArr == null || bitmap == null) {
                    if (bArr == null) {
                        com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", mT2.getTimeCost(), sb.toString(), iVar.eAG);
                    } else {
                        com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", mT2.getTimeCost(), sb.toString(), iVar.eAG);
                    }
                    return null;
                }
                boolean z4 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(bArr);
                Bitmap e = e(bitmap, dip2px, dip2px2);
                if (e == null) {
                    com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", mT2.getTimeCost(), sb.toString(), iVar.eAG);
                    return null;
                }
                com.baidu.tbadk.core.util.u.a(mT2, str, str3, true, isFromCDN, z2, bArr.length, "", mT2.getTimeCost(), sb.toString(), iVar.eAG);
                com.baidu.adp.widget.ImageView.a a5 = a(str, str2, aVar, null, e, z4, iVar, bArr, rect, z3);
                if (a5 != null) {
                    a5.Vm.resourceFromType = "net";
                    a5.Vm.costTime = mT.getTimeCost();
                    a5.Vm.isScuess = true;
                    a5.Vm.Vo = j;
                }
                return a5;
            }
        }
        z = false;
        str3 = n;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        au = iVar.au(str3, isFromCDN);
        boolean bnj3 = iVar.bnj();
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.bni()) {
        }
        if (au != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.bwL().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (v(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.eAL) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
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
                    aVar.MR = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mV() {
        return com.baidu.tbadk.core.k.bfo().isShowImages();
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aJ(i);
            aVar.aK(i2);
            com.baidu.tbadk.imageManager.c.bwL().c(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String n(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(at.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + au.bmV().getUrlQuality());
            sb.append("&first_gif=1");
            if (bnn()) {
                sb.append("&ispv=1");
            }
            if (bno()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c Bz(String str) {
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
        return k.bnr().mW();
    }

    @Override // com.baidu.adp.lib.e.e
    public int mX() {
        return 1;
    }

    public static boolean al(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, av.getNameMd5FromUrl(com.baidu.adp.lib.e.c.mS().genCacheKey(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a am(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.e.c.mS().genCacheKey(str, i);
        String nameMd5FromUrl = av.getNameMd5FromUrl(genCacheKey);
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
