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
    public abstract boolean bpg();

    public abstract boolean bph();

    public abstract int bpi();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.byE().DN(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Vn.resourceFromType = "memory";
        checkIsValidPicMemoryCache.Vn.costTime = 0L;
        checkIsValidPicMemoryCache.Vn.isScuess = true;
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
        com.baidu.adp.lib.Disk.ops.c BS = BS(av.getNameMd5FromUrl(str2));
        if (BS == null) {
            return null;
        }
        BS.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        BS.setSdCard(false);
        BS.setSubFolder(true);
        BS.setSavedCache(true);
        BS.setIsFormatData(false);
        BS.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(BS);
            aVar.MS = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.lL().c(BS)) {
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
        if (!BS.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(BS, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.u.a(mT, str2, true, mT.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.u.a(mT, str2, false, mT.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.Vn.resourceFromType = "disk";
            aVar2.Vn.costTime = mT.getTimeCost();
            aVar2.Vn.isScuess = true;
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
        byte[] aw;
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
                    aVar.MS = iVar;
                }
                aw = iVar.aw(str3, isFromCDN);
                boolean bpc = iVar.bpc();
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.bpb()) {
                    if (iVar.responseCode == 302 && (17 == bpi() || 18 == bpi() || 13 == bpi() || 14 == bpi())) {
                        if (iVar.eJc != null) {
                            com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eJc, "redirect", mT.getTimeCost(), iVar.bpe(), 0L, bpi());
                        }
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a2 = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect, bpc);
                            if (a2 != null) {
                                a2.Vn.resourceFromType = "net";
                                a2.Vn.costTime = mT.getTimeCost();
                                a2.Vn.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a2;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.my().Mo) {
                        long j2 = 0;
                        if (aw != null) {
                            j2 = aw.length;
                        }
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eJc, "NetworkError", mT.getTimeCost(), iVar.bpe(), j2, bpi());
                        return null;
                    }
                }
                if (aw != null) {
                    if (!iVar.my().Mo) {
                        com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eJc, "ByteIsNull", mT.getTimeCost(), iVar.bpe(), 0L, bpi());
                    }
                    return null;
                }
                if (aw.length > 1) {
                    k.bpk().u(aw.length, mT.getTimeCost());
                    com.baidu.tbadk.core.util.u.a(mT, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.eJc, "InputToByteSucc", mT.getTimeCost(), iVar.bpe(), aw.length, bpi());
                } else {
                    com.baidu.tbadk.core.util.u.a(mT, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.eJc, "bytes<1", mT.getTimeCost(), iVar.bpe(), aw.length, bpi());
                }
                com.baidu.adp.lib.stats.a mT2 = com.baidu.tbadk.core.util.u.mT();
                mT2.startTimer();
                com.baidu.tbadk.imageManager.c.byE().freePicCache(TbConfig.getPbImageSize() + aw.length);
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a3 = a(aw, rect, sb2);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (z && a3 == null) {
                    TiebaStatic.imgError(-1012, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    byte[] aw2 = iVar.aw(o, !isFromCDN);
                    boolean bpc2 = iVar.bpc();
                    mT2.startTimer();
                    if (aw2 == null || !iVar.bpb()) {
                        j = currentTimeMillis2;
                        z3 = bpc2;
                        bArr = aw2;
                        z2 = false;
                        sb = sb2;
                        bitmap = a3;
                    } else {
                        StringBuilder sb3 = new StringBuilder(100);
                        long currentTimeMillis3 = System.currentTimeMillis();
                        Bitmap a4 = a(aw2, rect, sb3);
                        j = System.currentTimeMillis() - currentTimeMillis3;
                        z3 = bpc2;
                        bArr = aw2;
                        z2 = false;
                        sb = sb3;
                        bitmap = a4;
                    }
                } else {
                    j = currentTimeMillis2;
                    sb = sb2;
                    bArr = aw;
                    z2 = z;
                    bitmap = a3;
                    z3 = bpc;
                }
                if (bArr == null || bitmap == null) {
                    if (bArr == null) {
                        com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", mT2.getTimeCost(), sb.toString(), iVar.eJc);
                    } else {
                        com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", mT2.getTimeCost(), sb.toString(), iVar.eJc);
                    }
                    return null;
                }
                boolean z4 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(bArr);
                Bitmap e = e(bitmap, dip2px, dip2px2);
                if (e == null) {
                    com.baidu.tbadk.core.util.u.a(mT2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", mT2.getTimeCost(), sb.toString(), iVar.eJc);
                    return null;
                }
                com.baidu.tbadk.core.util.u.a(mT2, str, str3, true, isFromCDN, z2, bArr.length, "", mT2.getTimeCost(), sb.toString(), iVar.eJc);
                com.baidu.adp.widget.ImageView.a a5 = a(str, str2, aVar, null, e, z4, iVar, bArr, rect, z3);
                if (a5 != null) {
                    a5.Vn.resourceFromType = "net";
                    a5.Vn.costTime = mT.getTimeCost();
                    a5.Vn.isScuess = true;
                    a5.Vn.Vp = j;
                }
                return a5;
            }
        }
        z = false;
        str3 = o;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        aw = iVar.aw(str3, isFromCDN);
        boolean bpc3 = iVar.bpc();
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.bpb()) {
        }
        if (aw != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.byE().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect, boolean z2) {
        if (v(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            aVar2.setNeedCache(z2);
            if (z2 && !iVar.eJh) {
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
                    aVar.MS = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mV() {
        return com.baidu.tbadk.core.k.bhh().isShowImages();
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a) && ((com.baidu.adp.widget.ImageView.a) obj).isNeedCache()) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aJ(i);
            aVar.aK(i2);
            com.baidu.tbadk.imageManager.c.byE().c(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String o(String str, int i, int i2) {
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
            sb.append("&qulity=" + au.boO().getUrlQuality());
            sb.append("&first_gif=1");
            if (bpg()) {
                sb.append("&ispv=1");
            }
            if (bph()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c BS(String str) {
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
        return k.bpk().mW();
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
