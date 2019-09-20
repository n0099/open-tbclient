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
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean akg();

    public abstract boolean akh();

    public abstract int aki();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.atK().qS(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.nK() == null || checkIsValidPicMemoryCache.nK().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Mb.Md = "memory";
        checkIsValidPicMemoryCache.Mb.Me = 0L;
        checkIsValidPicMemoryCache.Mb.Mf = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a iF = com.baidu.tbadk.core.util.s.iF();
        iF.iO();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c oJ = oJ(as.ol(str2));
        if (oJ == null) {
            return null;
        }
        oJ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        oJ.L(false);
        oJ.J(true);
        oJ.M(true);
        oJ.K(false);
        oJ.q(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(oJ);
            aVar.Bk = eVar;
        }
        boolean kd = com.baidu.adp.lib.util.j.kd();
        if (!com.baidu.adp.lib.Disk.d.gC().c(oJ)) {
            com.baidu.tbadk.core.util.s.a(iF, str2, false, iF.iP(), kd);
            return null;
        }
        int i3 = 2000;
        if (kd) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!oJ.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(oJ, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(iF, str2, true, iF.iP(), kd);
        } else {
            com.baidu.tbadk.core.util.s.a(iF, str2, false, iF.iP(), kd);
        }
        if (aVar2 != null) {
            aVar2.Mb.Md = "disk";
            aVar2.Mb.Me = iF.iP();
            aVar2.Mb.Mf = true;
            return aVar2;
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01bc  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] O;
        boolean z2;
        Bitmap bitmap;
        StringBuilder sb;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a iF = com.baidu.tbadk.core.util.s.iF();
        iF.iO();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String m = isFromCDN ? str : m(str, dip2px, height);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hS().az("webp_enable") == 1) {
            int indexOf = m.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = m.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = m.lastIndexOf(".jpg")) > 0) {
                str3 = m.substring(0, lastIndexOf) + ".webp" + m.substring(lastIndexOf + 4, m.length());
                z = true;
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.Bk = iVar;
                }
                O = iVar.O(str3, isFromCDN);
                Rect rect = new Rect();
                StringBuilder sb2 = new StringBuilder(100);
                if (!iVar.ajV()) {
                    if (iVar.responseCode == 302 && (17 == aki() || 18 == aki() || 13 == aki() || 14 == aki())) {
                        try {
                            InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                            byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                            com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.k(f), iVar, f, rect);
                            if (a != null) {
                                a.Mb.Md = "net";
                                a.Mb.Me = iF.iP();
                                a.Mb.Mf = true;
                            }
                            com.baidu.adp.lib.g.a.g(openRawResource);
                            return a;
                        } catch (Throwable th) {
                            BdLog.e(th);
                            return null;
                        }
                    } else if (!iVar.iv().AQ) {
                        long j = 0;
                        if (O != null) {
                            j = O.length;
                        }
                        com.baidu.tbadk.core.util.s.a(iF, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bWb, "NetworkError", iF.iP(), iVar.ajX(), j, aki());
                        return null;
                    }
                }
                if (O != null) {
                    if (!iVar.iv().AQ) {
                        com.baidu.tbadk.core.util.s.a(iF, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bWb, "ByteIsNull", iF.iP(), iVar.ajX(), 0L, aki());
                    }
                    return null;
                }
                if (O.length > 1) {
                    j.akk().o(O.length, iF.iP());
                    com.baidu.tbadk.core.util.s.a(iF, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.bWb, "InputToByteSucc", iF.iP(), iVar.ajX(), O.length, aki());
                } else {
                    com.baidu.tbadk.core.util.s.a(iF, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bWb, "bytes<1", iF.iP(), iVar.ajX(), O.length, aki());
                }
                com.baidu.adp.lib.stats.a iF2 = com.baidu.tbadk.core.util.s.iF();
                iF2.iO();
                com.baidu.tbadk.imageManager.c.atK().kJ(TbConfig.getPbImageSize() + O.length);
                Bitmap a2 = a(O, rect, sb2);
                if (z && a2 == null) {
                    TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    O = iVar.O(m, !isFromCDN);
                    iF2.iO();
                    if (O == null || !iVar.ajV()) {
                        bitmap = a2;
                        sb = sb2;
                        z2 = false;
                    } else {
                        StringBuilder sb3 = new StringBuilder(100);
                        bitmap = a(O, rect, sb3);
                        sb = sb3;
                        z2 = false;
                    }
                } else {
                    z2 = z;
                    bitmap = a2;
                    sb = sb2;
                }
                if (O == null || bitmap == null) {
                    if (O == null) {
                        com.baidu.tbadk.core.util.s.a(iF2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", iF2.iP(), sb.toString());
                    } else {
                        com.baidu.tbadk.core.util.s.a(iF2, str, str3, false, isFromCDN, z2, O.length, "ConvertError", iF2.iP(), sb.toString());
                    }
                    return null;
                }
                boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.k(O);
                Bitmap e = e(bitmap, dip2px, height);
                if (e == null) {
                    com.baidu.tbadk.core.util.s.a(iF2, str, str3, false, isFromCDN, z2, O.length, "ResizeError", iF2.iP(), sb.toString());
                    return null;
                }
                com.baidu.tbadk.core.util.s.a(iF2, str, str3, true, isFromCDN, z2, O.length, "", iF2.iP(), sb.toString());
                com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, e, z3, iVar, O, rect);
                if (a3 != null) {
                    a3.Mb.Md = "net";
                    a3.Mb.Me = iF.iP();
                    a3.Mb.Mf = true;
                    return a3;
                }
                return a3;
            }
        }
        z = false;
        str3 = m;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        O = iVar.O(str3, isFromCDN);
        Rect rect2 = new Rect();
        StringBuilder sb22 = new StringBuilder(100);
        if (!iVar.ajV()) {
        }
        if (O != null) {
        }
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.atK().kJ(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.bWg) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.ol(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.J(true);
                cVar.setData(bArr);
                cVar.L(false);
                cVar.M(true);
                cVar.O(z);
                com.baidu.adp.lib.Disk.d.gC().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Bk = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean iH() {
        return com.baidu.tbadk.core.i.ace().aci();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aG(i);
            aVar.aH(i2);
            com.baidu.tbadk.imageManager.c.atK().c(str, aVar);
        }
    }

    protected String m(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(aq.bi(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.ajw().ajB());
            sb.append("&first_gif=1");
            if (akg()) {
                sb.append("&ispv=1");
            }
            if (akh()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c oJ(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        cVar.i(cVar.getData());
        Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i, i2);
        if (checkBitmapSize != null) {
            return new com.baidu.adp.widget.ImageView.a(checkBitmapSize, cVar.isGif(), str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.af(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel iI() {
        return j.akk().iI();
    }

    @Override // com.baidu.adp.lib.f.e
    public int iJ() {
        return 1;
    }

    public static boolean U(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.ol(com.baidu.adp.lib.f.c.iE().e(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.J(true);
        cVar.K(false);
        cVar.L(false);
        cVar.M(true);
        return cVar.gD();
    }

    public static com.baidu.adp.widget.ImageView.a V(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String e = com.baidu.adp.lib.f.c.iE().e(str, i);
        String ol = as.ol(e);
        if (i == 38) {
            return k.a(ol, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ol, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.J(true);
            cVar.K(false);
            cVar.M(true);
            cVar.L(false);
            if (com.baidu.adp.lib.Disk.d.gC().b(cVar) && cVar.isSuccess()) {
                cVar.i(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), e);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
