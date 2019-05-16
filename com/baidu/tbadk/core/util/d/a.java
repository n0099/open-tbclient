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
import com.baidu.tieba.R;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean aiO();

    public abstract boolean aiP();

    public abstract int aiQ();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.asp().qr(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.ns() == null || checkIsValidPicMemoryCache.ns().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.LO.LQ = "memory";
        checkIsValidPicMemoryCache.LO.LR = 0L;
        checkIsValidPicMemoryCache.LO.LS = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a iw = com.baidu.tbadk.core.util.s.iw();
        iw.iF();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ok = ok(as.nT(str2));
        if (ok == null) {
            return null;
        }
        ok.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ok.L(false);
        ok.J(true);
        ok.M(true);
        ok.K(false);
        ok.q(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(ok);
            aVar.Bf = eVar;
        }
        boolean jT = com.baidu.adp.lib.util.j.jT();
        if (!com.baidu.adp.lib.Disk.d.gt().c(ok)) {
            com.baidu.tbadk.core.util.s.a(iw, str2, false, iw.iG(), jT);
            return null;
        }
        int i3 = 2000;
        if (jT) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!ok.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(ok, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(iw, str2, true, iw.iG(), jT);
        } else {
            com.baidu.tbadk.core.util.s.a(iw, str2, false, iw.iG(), jT);
        }
        if (aVar2 != null) {
            aVar2.LO.LQ = "disk";
            aVar2.LO.LR = iw.iG();
            aVar2.LO.LS = true;
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
        com.baidu.adp.lib.stats.a iw = com.baidu.tbadk.core.util.s.iw();
        iw.iF();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String m = isFromCDN ? str : m(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hI().ay("webp_enable") == 1) || m.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = m.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = m;
        } else {
            str3 = m.substring(0, lastIndexOf) + ".webp" + m.substring(lastIndexOf + 4, m.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.Bf = iVar;
        }
        byte[] N = iVar.N(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.aiJ()) {
            if (iVar.responseCode == 302 && (17 == aiQ() || 18 == aiQ() || 13 == aiQ() || 14 == aiQ())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                    byte[] f = com.baidu.adp.lib.network.a.b.f(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(f, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.k(f), iVar, f, rect);
                    if (a != null) {
                        a.LO.LQ = "net";
                        a.LO.LR = iw.iG();
                        a.LO.LS = true;
                    }
                    com.baidu.adp.lib.g.a.g(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.il().AK) {
                long j = 0;
                if (N != null) {
                    j = N.length;
                }
                com.baidu.tbadk.core.util.s.a(iw, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bUo, "NetworkError", iw.iG(), iVar.aiL(), j, aiQ());
                return null;
            }
        }
        if (N == null && !iVar.il().AK) {
            com.baidu.tbadk.core.util.s.a(iw, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bUo, "ByteIsNull", iw.iG(), iVar.aiL(), 0L, aiQ());
            return null;
        }
        if (N.length > 1) {
            j.aiS().o(N.length, iw.iG());
            com.baidu.tbadk.core.util.s.a(iw, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.bUo, "InputToByteSucc", iw.iG(), iVar.aiL(), N.length, aiQ());
        } else {
            com.baidu.tbadk.core.util.s.a(iw, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.bUo, "bytes<1", iw.iG(), iVar.aiL(), N.length, aiQ());
        }
        com.baidu.adp.lib.stats.a iw2 = com.baidu.tbadk.core.util.s.iw();
        iw2.iF();
        com.baidu.tbadk.imageManager.c.asp().kz(TbConfig.getPbImageSize() + N.length);
        Bitmap a2 = a(N, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            N = iVar.N(m, !isFromCDN);
            iw2.iF();
            if (N == null || !iVar.aiJ()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(N, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (N == null || bitmap == null) {
            if (N == null) {
                com.baidu.tbadk.core.util.s.a(iw2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", iw2.iG(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(iw2, str, str3, false, isFromCDN, z2, N.length, "ConvertError", iw2.iG(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.k(N);
        Bitmap e = e(bitmap, dip2px, height);
        if (e == null) {
            com.baidu.tbadk.core.util.s.a(iw2, str, str3, false, isFromCDN, z2, N.length, "ResizeError", iw2.iG(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(iw2, str, str3, true, isFromCDN, z2, N.length, "", iw2.iG(), sb.toString());
        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, e, z3, iVar, N, rect);
        if (a3 != null) {
            a3.LO.LQ = "net";
            a3.LO.LR = iw.iG();
            a3.LO.LS = true;
            return a3;
        }
        return a3;
    }

    protected Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.asp().kz(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (m(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.bUt) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.nT(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.J(true);
                cVar.setData(bArr);
                cVar.L(false);
                cVar.M(true);
                cVar.O(z);
                com.baidu.adp.lib.Disk.d.gt().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.Bf = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean iy() {
        return com.baidu.tbadk.core.i.abb().abf();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aG(i);
            aVar.aH(i2);
            com.baidu.tbadk.imageManager.c.asp().c(str, aVar);
        }
    }

    protected String m(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ap.bh(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.ail().aiq());
            sb.append("&first_gif=1");
            if (aiO()) {
                sb.append("&ispv=1");
            }
            if (aiP()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c ok(String str) {
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
    public BdAsyncTaskParallel iz() {
        return j.aiS().iz();
    }

    @Override // com.baidu.adp.lib.f.e
    public int iA() {
        return 1;
    }

    public static boolean U(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.nT(com.baidu.adp.lib.f.c.iv().e(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.J(true);
        cVar.K(false);
        cVar.L(false);
        cVar.M(true);
        return cVar.gu();
    }

    public static com.baidu.adp.widget.ImageView.a V(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String e = com.baidu.adp.lib.f.c.iv().e(str, i);
        String nT = as.nT(e);
        if (i == 38) {
            return k.a(nT, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, nT, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.J(true);
            cVar.K(false);
            cVar.M(true);
            cVar.L(false);
            if (com.baidu.adp.lib.Disk.d.gt().b(cVar) && cVar.isSuccess()) {
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
