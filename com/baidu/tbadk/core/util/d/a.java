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
    public abstract boolean EI();

    public abstract boolean EJ();

    public abstract int EK();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.NM().iw(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.ot() == null || checkIsValidPicMemoryCache.ot().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.NT.NV = "memory";
        checkIsValidPicMemoryCache.NT.NW = 0L;
        checkIsValidPicMemoryCache.NT.NX = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jB = com.baidu.tbadk.core.util.s.jB();
        jB.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c go = go(ar.fY(str2));
        if (go == null) {
            return null;
        }
        go.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        go.T(false);
        go.R(true);
        go.U(true);
        go.S(false);
        go.q(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(go);
            aVar.Dw = eVar;
        }
        boolean kW = com.baidu.adp.lib.util.j.kW();
        if (!com.baidu.adp.lib.Disk.d.hB().c(go)) {
            com.baidu.tbadk.core.util.s.a(jB, str2, false, jB.jK(), kW);
            return null;
        }
        int i3 = 2000;
        if (kW) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!go.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(go, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jB, str2, true, jB.jK(), kW);
        } else {
            com.baidu.tbadk.core.util.s.a(jB, str2, false, jB.jK(), kW);
        }
        if (aVar2 != null) {
            aVar2.NT.NV = "disk";
            aVar2.NT.NW = jB.jK();
            aVar2.NT.NX = true;
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
        com.baidu.adp.lib.stats.a jB = com.baidu.tbadk.core.util.s.jB();
        jB.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String n = isFromCDN ? str : n(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.iQ().aO("webp_enable") == 1) || n.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = n.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = n;
        } else {
            str3 = n.substring(0, lastIndexOf) + ".webp" + n.substring(lastIndexOf + 4, n.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.Dw = iVar;
        }
        byte[] r = iVar.r(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.EC()) {
            if (iVar.responseCode == 302 && (17 == EK() || 18 == EK() || 13 == EK() || 14 == EK())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(e.f.img_default_delete, new TypedValue());
                    byte[] g = com.baidu.adp.lib.network.a.b.g(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(g, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.r(g), iVar, g, rect);
                    if (a != null) {
                        a.NT.NV = "net";
                        a.NT.NW = jB.jK();
                        a.NT.NX = true;
                    }
                    com.baidu.adp.lib.g.a.h(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.jq().Dd) {
                long j = 0;
                if (r != null) {
                    j = r.length;
                }
                com.baidu.tbadk.core.util.s.a(jB, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aEF, "NetworkError", jB.jK(), iVar.EF(), j, EK());
                return null;
            }
        }
        if (r == null && !iVar.jq().Dd) {
            com.baidu.tbadk.core.util.s.a(jB, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aEF, "ByteIsNull", jB.jK(), iVar.EF(), 0L, EK());
            return null;
        }
        if (r.length > 1) {
            j.EM().h(r.length, jB.jK());
            com.baidu.tbadk.core.util.s.a(jB, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.aEF, "InputToByteSucc", jB.jK(), iVar.EF(), r.length, EK());
        } else {
            com.baidu.tbadk.core.util.s.a(jB, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aEF, "bytes<1", jB.jK(), iVar.EF(), r.length, EK());
        }
        com.baidu.adp.lib.stats.a jB2 = com.baidu.tbadk.core.util.s.jB();
        jB2.startTimer();
        com.baidu.tbadk.imageManager.c.NM().gb(TbConfig.getPbImageSize() + r.length);
        Bitmap a2 = a(r, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            r = iVar.r(n, !isFromCDN);
            jB2.startTimer();
            if (r == null || !iVar.EC()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(r, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (r == null || bitmap == null) {
            if (r == null) {
                com.baidu.tbadk.core.util.s.a(jB2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", jB2.jK(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(jB2, str, str3, false, isFromCDN, z2, r.length, "ConvertError", jB2.jK(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.r(r);
        Bitmap c = c(bitmap, dip2px, height);
        if (c == null) {
            com.baidu.tbadk.core.util.s.a(jB2, str, str3, false, isFromCDN, z2, r.length, "ResizeError", jB2.jK(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(jB2, str, str3, true, isFromCDN, z2, r.length, "", jB2.jK(), sb.toString());
        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, c, z3, iVar, r, rect);
        if (a3 != null) {
            a3.NT.NV = "net";
            a3.NT.NW = jB.jK();
            a3.NT.NX = true;
            return a3;
        }
        return a3;
    }

    protected Bitmap c(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.NM().gb(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.aEK) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fY(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.R(true);
                cVar.setData(bArr);
                cVar.T(false);
                cVar.U(true);
                cVar.W(z);
                com.baidu.adp.lib.Disk.d.hB().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Dw = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean jD() {
        return com.baidu.tbadk.core.i.xR().xV();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.be(i);
            aVar.bf(i2);
            com.baidu.tbadk.imageManager.c.NM().c(str, aVar);
        }
    }

    protected String n(String str, int i, int i2) {
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
            sb.append("&qulity=" + aq.Ee().Ej());
            sb.append("&first_gif=1");
            if (EI()) {
                sb.append("&ispv=1");
            }
            if (EJ()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c go(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        cVar.p(cVar.getData());
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
    public BdAsyncTaskParallel jE() {
        return j.EM().jE();
    }

    @Override // com.baidu.adp.lib.f.e
    public int jF() {
        return 1;
    }

    public static boolean D(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fY(com.baidu.adp.lib.f.c.jA().k(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.R(true);
        cVar.S(false);
        cVar.T(false);
        cVar.U(true);
        return cVar.hC();
    }

    public static com.baidu.adp.widget.ImageView.a E(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String k = com.baidu.adp.lib.f.c.jA().k(str, i);
        String fY = ar.fY(k);
        if (i == 38) {
            return k.a(fY, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, fY, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.R(true);
            cVar.S(false);
            cVar.U(true);
            cVar.T(false);
            if (com.baidu.adp.lib.Disk.d.hB().b(cVar) && cVar.isSuccess()) {
                cVar.p(cVar.getData());
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
