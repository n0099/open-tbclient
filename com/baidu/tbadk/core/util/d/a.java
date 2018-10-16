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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.e;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean Dk();

    public abstract boolean Dl();

    public abstract int Dm();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.Me().hO(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.os() == null || checkIsValidPicMemoryCache.os().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.NF.NH = "memory";
        checkIsValidPicMemoryCache.NF.NI = 0L;
        checkIsValidPicMemoryCache.NF.NJ = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jD = com.baidu.tbadk.core.util.s.jD();
        jD.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fI = fI(ar.fs(str2));
        if (fI == null) {
            return null;
        }
        fI.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fI.F(false);
        fI.D(true);
        fI.G(true);
        fI.E(false);
        fI.q((Object) bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fI);
            aVar.Ds = eVar;
        }
        boolean kY = com.baidu.adp.lib.util.j.kY();
        if (!com.baidu.adp.lib.Disk.d.hC().c(fI)) {
            com.baidu.tbadk.core.util.s.a(jD, str2, false, jD.jM(), kY);
            return null;
        }
        int i3 = 2000;
        if (kY) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!fI.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(fI, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jD, str2, true, jD.jM(), kY);
        } else {
            com.baidu.tbadk.core.util.s.a(jD, str2, false, jD.jM(), kY);
        }
        if (aVar2 != null) {
            aVar2.NF.NH = "disk";
            aVar2.NF.NI = jD.jM();
            aVar2.NF.NJ = true;
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
        com.baidu.adp.lib.stats.a jD = com.baidu.tbadk.core.util.s.jD();
        jD.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String l = isFromCDN ? str : l(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.iR().aO("webp_enable") == 1) || l.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = l.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = l;
        } else {
            str3 = l.substring(0, lastIndexOf) + ".webp" + l.substring(lastIndexOf + 4, l.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.Ds = iVar;
        }
        byte[] q = iVar.q(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.De()) {
            if (iVar.responseCode == 302 && (17 == Dm() || 18 == Dm() || 13 == Dm() || 14 == Dm())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(e.f.img_default_delete, new TypedValue());
                    byte[] g = com.baidu.adp.lib.network.a.b.g(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(g, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.s(g), iVar, g, rect);
                    if (a != null) {
                        a.NF.NH = "net";
                        a.NF.NI = jD.jM();
                        a.NF.NJ = true;
                    }
                    com.baidu.adp.lib.g.a.h(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.js().CZ) {
                long j = 0;
                if (q != null) {
                    j = q.length;
                }
                com.baidu.tbadk.core.util.s.a(jD, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.azM, "NetworkError", jD.jM(), iVar.Dh(), j, Dm());
                return null;
            }
        }
        if (q == null && !iVar.js().CZ) {
            com.baidu.tbadk.core.util.s.a(jD, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.azM, "ByteIsNull", jD.jM(), iVar.Dh(), 0L, Dm());
            return null;
        }
        if (q.length > 1) {
            j.Do().e(q.length, jD.jM());
            com.baidu.tbadk.core.util.s.a(jD, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.azM, "InputToByteSucc", jD.jM(), iVar.Dh(), q.length, Dm());
        } else {
            com.baidu.tbadk.core.util.s.a(jD, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.azM, "bytes<1", jD.jM(), iVar.Dh(), q.length, Dm());
        }
        com.baidu.adp.lib.stats.a jD2 = com.baidu.tbadk.core.util.s.jD();
        jD2.startTimer();
        com.baidu.tbadk.imageManager.c.Me().fy(TbConfig.getPbImageSize() + q.length);
        Bitmap a2 = a(q, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            q = iVar.q(l, !isFromCDN);
            jD2.startTimer();
            if (q == null || !iVar.De()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(q, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (q == null || bitmap == null) {
            if (q == null) {
                com.baidu.tbadk.core.util.s.a(jD2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", jD2.jM(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(jD2, str, str3, false, isFromCDN, z2, q.length, "ConvertError", jD2.jM(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.s(q);
        Bitmap b = b(bitmap, dip2px, height);
        if (b == null) {
            com.baidu.tbadk.core.util.s.a(jD2, str, str3, false, isFromCDN, z2, q.length, "ResizeError", jD2.jM(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(jD2, str, str3, true, isFromCDN, z2, q.length, "", jD2.jM(), sb.toString());
        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, b, z3, iVar, q, rect);
        if (a3 != null) {
            a3.NF.NH = "net";
            a3.NF.NI = jD.jM();
            a3.NF.NJ = true;
            return a3;
        }
        return a3;
    }

    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Me().fy(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.azR) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fs(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.D(true);
                cVar.setData(bArr);
                cVar.F(false);
                cVar.G(true);
                cVar.I(z);
                com.baidu.adp.lib.Disk.d.hC().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Ds = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean jF() {
        return com.baidu.tbadk.core.i.ws().ww();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aN(i);
            aVar.aO(i2);
            com.baidu.tbadk.imageManager.c.Me().c(str, aVar);
        }
    }

    protected String l(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ao.bx(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + aq.CG().CL());
            sb.append("&first_gif=1");
            if (Dk()) {
                sb.append("&ispv=1");
            }
            if (Dl()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c fI(String str) {
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
    public boolean f(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jG() {
        return j.Do().jG();
    }

    @Override // com.baidu.adp.lib.f.e
    public int jH() {
        return 1;
    }

    public static boolean B(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fs(com.baidu.adp.lib.f.c.jC().k(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.D(true);
        cVar.E(false);
        cVar.F(false);
        cVar.G(true);
        return cVar.hD();
    }

    public static com.baidu.adp.widget.ImageView.a C(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String k = com.baidu.adp.lib.f.c.jC().k(str, i);
        String fs = ar.fs(k);
        if (i == 38) {
            return k.a(fs, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, fs, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.D(true);
            cVar.E(false);
            cVar.G(true);
            cVar.F(false);
            if (com.baidu.adp.lib.Disk.d.hC().b(cVar) && cVar.isSuccess()) {
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
