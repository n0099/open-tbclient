package com.baidu.tbadk.core.util.d;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean aEE();

    public abstract boolean aEF();

    public abstract int aEG();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.aNs().vg(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.getRawBitmap() == null || checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.zF.resourceFromType = "memory";
        checkIsValidPicMemoryCache.zF.costTime = 0L;
        checkIsValidPicMemoryCache.zF.isScuess = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a gs = com.baidu.tbadk.core.util.s.gs();
        gs.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c tq = tq(as.getNameMd5FromUrl(str2));
        if (tq == null) {
            return null;
        }
        tq.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        tq.setSdCard(false);
        tq.setSubFolder(true);
        tq.setSavedCache(true);
        tq.setIsFormatData(false);
        tq.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(tq);
            aVar.rS = eVar;
        }
        boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
        if (!com.baidu.adp.lib.Disk.d.fj().c(tq)) {
            com.baidu.tbadk.core.util.s.a(gs, str2, false, gs.getTimeCost(), isWifiNet);
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
        if (!tq.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(tq, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(gs, str2, true, gs.getTimeCost(), isWifiNet);
        } else {
            com.baidu.tbadk.core.util.s.a(gs, str2, false, gs.getTimeCost(), isWifiNet);
        }
        if (aVar2 != null) {
            aVar2.zF.resourceFromType = "disk";
            aVar2.zF.costTime = gs.getTimeCost();
            aVar2.zF.isScuess = true;
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
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] T;
        StringBuilder sb;
        boolean z2;
        Bitmap bitmap;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a gs = com.baidu.tbadk.core.util.s.gs();
        gs.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String m = isFromCDN ? str : m(str, dip2px, height);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = m.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = m.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = m.lastIndexOf(".jpg")) > 0) {
                str3 = m.substring(0, lastIndexOf) + ".webp" + m.substring(lastIndexOf + 4, m.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.rS = iVar;
                }
                T = iVar.T(str3, isFromCDN);
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.aEB()) {
                    if (iVar.responseCode == 302 && (17 == aEG() || 18 == aEG() || 13 == aEG() || 14 == aEG())) {
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.isGif(f), iVar, f, rect);
                            if (a != null) {
                                a.zF.resourceFromType = "net";
                                a.zF.costTime = gs.getTimeCost();
                                a.zF.isScuess = true;
                            }
                            com.baidu.adp.lib.f.a.close(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.fY().ro) {
                        long j = 0;
                        if (T != null) {
                            j = T.length;
                        }
                        com.baidu.tbadk.core.util.s.a(gs, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.cXk, "NetworkError", gs.getTimeCost(), iVar.aED(), j, aEG());
                        return null;
                    }
                }
                if (T != null) {
                    if (!iVar.fY().ro) {
                        com.baidu.tbadk.core.util.s.a(gs, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.cXk, "ByteIsNull", gs.getTimeCost(), iVar.aED(), 0L, aEG());
                    }
                    return null;
                }
                if (T.length > 1) {
                    j.aEI().s(T.length, gs.getTimeCost());
                    com.baidu.tbadk.core.util.s.a(gs, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.cXk, "InputToByteSucc", gs.getTimeCost(), iVar.aED(), T.length, aEG());
                } else {
                    com.baidu.tbadk.core.util.s.a(gs, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.cXk, "bytes<1", gs.getTimeCost(), iVar.aED(), T.length, aEG());
                }
                com.baidu.adp.lib.stats.a gs2 = com.baidu.tbadk.core.util.s.gs();
                gs2.startTimer();
                com.baidu.tbadk.imageManager.c.aNs().freePicCache(TbConfig.getPbImageSize() + T.length);
                Bitmap a2 = a(T, rect, sb2);
                if (z && a2 == null) {
                    z = false;
                    TiebaStatic.imgError(-1012, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    T = iVar.T(m, !isFromCDN);
                    gs2.startTimer();
                    if (T != null && iVar.aEB()) {
                        sb = new StringBuilder(100);
                        bitmap = a(T, rect, sb);
                        z2 = false;
                        if (T != null || bitmap == null) {
                            if (T != null) {
                                com.baidu.tbadk.core.util.s.a(gs2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", gs2.getTimeCost(), sb.toString(), iVar.cXk);
                            } else {
                                com.baidu.tbadk.core.util.s.a(gs2, str, str3, false, isFromCDN, z2, T.length, "ConvertError", gs2.getTimeCost(), sb.toString(), iVar.cXk);
                            }
                            return null;
                        }
                        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.isGif(T);
                        Bitmap e = e(bitmap, dip2px, height);
                        if (e == null) {
                            com.baidu.tbadk.core.util.s.a(gs2, str, str3, false, isFromCDN, z2, T.length, "ResizeError", gs2.getTimeCost(), sb.toString(), iVar.cXk);
                            return null;
                        }
                        com.baidu.tbadk.core.util.s.a(gs2, str, str3, true, isFromCDN, z2, T.length, "", gs2.getTimeCost(), sb.toString(), iVar.cXk);
                        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, e, z3, iVar, T, rect);
                        if (a3 != null) {
                            a3.zF.resourceFromType = "net";
                            a3.zF.costTime = gs.getTimeCost();
                            a3.zF.isScuess = true;
                            return a3;
                        }
                        return a3;
                    }
                }
                sb = sb2;
                z2 = z;
                bitmap = a2;
                if (T != null) {
                }
                if (T != null) {
                }
                return null;
            }
        }
        z = false;
        str3 = m;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        T = iVar.T(str3, isFromCDN);
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.aEB()) {
        }
        if (T != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.aNs().freePicCache(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.e.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (o(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.cXp) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.setSubFolder(true);
                cVar.setData(bArr);
                cVar.setSdCard(false);
                cVar.setSavedCache(true);
                cVar.setGif(z);
                com.baidu.adp.lib.Disk.d.fj().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.rS = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean gu() {
        return com.baidu.tbadk.core.i.axy().isShowImages();
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.af(i);
            aVar.ag(i2);
            com.baidu.tbadk.imageManager.c.aNs().c(str, aVar);
        }
    }

    protected String m(String str, int i, int i2) {
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
            sb.append("&qulity=" + ar.aEq().getUrlQuality());
            sb.append("&first_gif=1");
            if (aEE()) {
                sb.append("&ispv=1");
            }
            if (aEF()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c tq(String str) {
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

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel gv() {
        return j.aEI().gv();
    }

    @Override // com.baidu.adp.lib.e.e
    public int gw() {
        return 1;
    }

    public static boolean ab(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.getNameMd5FromUrl(com.baidu.adp.lib.e.c.gr().genCacheKey(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setIsFormatData(false);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar.call();
    }

    public static com.baidu.adp.widget.ImageView.a ac(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String genCacheKey = com.baidu.adp.lib.e.c.gr().genCacheKey(str, i);
        String nameMd5FromUrl = as.getNameMd5FromUrl(genCacheKey);
        if (i == 38) {
            return k.a(nameMd5FromUrl, (com.baidu.adp.lib.e.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, nameMd5FromUrl, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setIsFormatData(false);
            cVar.setSavedCache(true);
            cVar.setSdCard(false);
            if (com.baidu.adp.lib.Disk.d.fj().b(cVar) && cVar.isSuccess()) {
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
