package com.baidu.tbadk.core.util.d;

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean adS();

    public abstract boolean adT();

    public abstract int adU();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.anp().pi(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.oy() == null || checkIsValidPicMemoryCache.oy().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Of.Oh = "memory";
        checkIsValidPicMemoryCache.Of.Oi = 0L;
        checkIsValidPicMemoryCache.Of.Oj = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.core.util.s.jC();
        jC.jL();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c na = na(as.mK(str2));
        if (na == null) {
            return null;
        }
        na.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        na.T(false);
        na.R(true);
        na.U(true);
        na.S(false);
        na.q((Object) bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(na);
            aVar.Dv = eVar;
        }
        boolean kZ = com.baidu.adp.lib.util.j.kZ();
        if (!com.baidu.adp.lib.Disk.d.hz().c(na)) {
            com.baidu.tbadk.core.util.s.a(jC, str2, false, jC.jM(), kZ);
            return null;
        }
        int i3 = 2000;
        if (kZ) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!na.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(na, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jC, str2, true, jC.jM(), kZ);
        } else {
            com.baidu.tbadk.core.util.s.a(jC, str2, false, jC.jM(), kZ);
        }
        if (aVar2 != null) {
            aVar2.Of.Oh = "disk";
            aVar2.Of.Oi = jC.jM();
            aVar2.Of.Oj = true;
            return aVar2;
        }
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        boolean z2;
        Bitmap bitmap;
        StringBuilder sb;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a jC = com.baidu.tbadk.core.util.s.jC();
        jC.jL();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String m = isFromCDN ? str : m(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.iQ().aO("webp_enable") == 1) || m.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = m.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = m;
        } else {
            str3 = m.substring(0, lastIndexOf) + ".webp" + m.substring(lastIndexOf + 4, m.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.Dv = iVar;
        }
        byte[] K = iVar.K(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.adN()) {
            if (iVar.responseCode == 302 && (17 == adU() || 18 == adU() || 13 == adU() || 14 == adU())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] h = com.baidu.adp.lib.network.a.b.h(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(h, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.s(h), iVar, h, rect);
                    if (a != null) {
                        a.Of.Oh = "net";
                        a.Of.Oi = jC.jM();
                        a.Of.Oj = true;
                    }
                    com.baidu.adp.lib.g.a.i(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.js().Dc) {
                long j = 0;
                if (K != null) {
                    j = K.length;
                }
                com.baidu.tbadk.core.util.s.a(jC, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bMA, "NetworkError", jC.jM(), iVar.adP(), j, adU());
                return null;
            }
        }
        if (K == null && !iVar.js().Dc) {
            com.baidu.tbadk.core.util.s.a(jC, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bMA, "ByteIsNull", jC.jM(), iVar.adP(), 0L, adU());
            return null;
        }
        if (K.length > 1) {
            j.adW().h(K.length, jC.jM());
            com.baidu.tbadk.core.util.s.a(jC, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.bMA, "InputToByteSucc", jC.jM(), iVar.adP(), K.length, adU());
        } else {
            com.baidu.tbadk.core.util.s.a(jC, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bMA, "bytes<1", jC.jM(), iVar.adP(), K.length, adU());
        }
        com.baidu.adp.lib.stats.a jC2 = com.baidu.tbadk.core.util.s.jC();
        jC2.jL();
        com.baidu.tbadk.imageManager.c.anp().jM(TbConfig.getPbImageSize() + K.length);
        Bitmap a2 = a(K, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            K = iVar.K(m, !isFromCDN);
            jC2.jL();
            if (K == null || !iVar.adN()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(K, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (K == null || bitmap == null) {
            if (K == null) {
                com.baidu.tbadk.core.util.s.a(jC2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", jC2.jM(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(jC2, str, str3, false, isFromCDN, z2, K.length, "ConvertError", jC2.jM(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.s(K);
        Bitmap e = e(bitmap, dip2px, height);
        if (e == null) {
            com.baidu.tbadk.core.util.s.a(jC2, str, str3, false, isFromCDN, z2, K.length, "ResizeError", jC2.jM(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(jC2, str, str3, true, isFromCDN, z2, K.length, "", jC2.jM(), sb.toString());
        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, e, z3, iVar, K, rect);
        if (a3 != null) {
            a3.Of.Oh = "net";
            a3.Of.Oi = jC.jM();
            a3.Of.Oj = true;
            return a3;
        }
        return a3;
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.anp().jM(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.bMF) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.mK(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.R(true);
                cVar.setData(bArr);
                cVar.T(false);
                cVar.U(true);
                cVar.W(z);
                com.baidu.adp.lib.Disk.d.hz().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Dv = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean jE() {
        return com.baidu.tbadk.core.i.Wy().WC();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aO(i);
            aVar.aP(i2);
            com.baidu.tbadk.imageManager.c.anp().c(str, aVar);
        }
    }

    protected String m(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ap.bx(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.adp().adu());
            sb.append("&first_gif=1");
            if (adS()) {
                sb.append("&ispv=1");
            }
            if (adT()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c na(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        cVar.q(cVar.getData());
        Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i, i2);
        if (checkBitmapSize != null) {
            return new com.baidu.adp.widget.ImageView.a(checkBitmapSize, cVar.isGif(), str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jF() {
        return j.adW().jF();
    }

    @Override // com.baidu.adp.lib.f.e
    public int jG() {
        return 1;
    }

    public static boolean Y(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.mK(com.baidu.adp.lib.f.c.jB().k(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.R(true);
        cVar.S(false);
        cVar.T(false);
        cVar.U(true);
        return cVar.hA();
    }

    public static com.baidu.adp.widget.ImageView.a Z(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String k = com.baidu.adp.lib.f.c.jB().k(str, i);
        String mK = as.mK(k);
        if (i == 38) {
            return k.a(mK, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, mK, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.R(true);
            cVar.S(false);
            cVar.U(true);
            cVar.T(false);
            if (com.baidu.adp.lib.Disk.d.hz().b(cVar) && cVar.isSuccess()) {
                cVar.q(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), k);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
