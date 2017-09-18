package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean ws();

    public abstract boolean wt();

    public abstract int wu();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a go = com.baidu.tbadk.imageManager.c.Ev().go(str);
        if (go != null) {
            go.Gx.Gz = "memory";
            go.Gx.GA = 0L;
            go.Gx.GB = true;
        }
        return go;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fL = s.fL();
        fL.fU();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c el = el(ao.dX(str2));
        if (el == null) {
            return null;
        }
        el.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        el.t(true);
        el.u(false);
        el.j(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(el);
            aVar.vC = dVar;
        }
        boolean hj = com.baidu.adp.lib.util.i.hj();
        if (!com.baidu.adp.lib.Disk.d.dI().c(el)) {
            s.a(fL, str2, false, fL.fV(), hj);
            return null;
        }
        int i = 2000;
        if (hj) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = el.isSuccess() ? a(el, str2) : null;
        if (a != null) {
            s.a(fL, str2, true, fL.fV(), hj);
        } else {
            s.a(fL, str2, false, fL.fV(), hj);
        }
        if (a != null) {
            a.Gx.Gz = "disk";
            a.Gx.GA = fL.fV();
            a.Gx.GB = true;
            return a;
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        boolean z2;
        Bitmap bitmap;
        StringBuilder sb;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a fL = s.fL();
        fL.fU();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.eW().af("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = d.substring(0, lastIndexOf) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.vC = iVar;
        }
        byte[] k = iVar.k(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.wo()) {
            if (iVar.responseCode == 302 && (17 == wu() || 18 == wu() || 13 == wu() || 14 == wu())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.g.img_default_delete, new TypedValue());
                    byte[] c = com.baidu.adp.lib.network.a.b.c(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(c, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.k.j(c), iVar, c, rect);
                    if (a != null) {
                        a.Gx.Gz = "net";
                        a.Gx.GA = fL.fV();
                        a.Gx.GB = true;
                    }
                    com.baidu.adp.lib.g.a.d(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.fA().vl) {
                long j = 0;
                if (k != null) {
                    j = k.length;
                }
                s.a(fL, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aiV, "NetworkError", fL.fV(), iVar.wr(), j, wu());
                return null;
            }
        }
        if (k == null && !iVar.fA().vl) {
            s.a(fL, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aiV, "ByteIsNull", fL.fV(), iVar.wr(), 0L, wu());
            return null;
        }
        if (k.length > 1) {
            h.wv().c(k.length, fL.fV());
            s.a(fL, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.aiV, "InputToByteSucc", fL.fV(), iVar.wr(), k.length, wu());
        } else {
            s.a(fL, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aiV, "bytes<1", fL.fV(), iVar.wr(), k.length, wu());
        }
        com.baidu.adp.lib.stats.a fL2 = s.fL();
        fL2.fU();
        com.baidu.tbadk.imageManager.c.Ev().eX(TbConfig.getPbImageSize() + k.length);
        Bitmap a2 = a(k, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            k = iVar.k(d, !isFromCDN);
            fL2.fU();
            if (k == null || !iVar.wo()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(k, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (k == null || bitmap == null) {
            if (k == null) {
                s.a(fL2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fL2.fV(), sb.toString());
            } else {
                s.a(fL2, str, str3, false, isFromCDN, z2, k.length, "ConvertError", fL2.fV(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.k.j(k);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            s.a(fL2, str, str3, false, isFromCDN, z2, k.length, "ResizeError", fL2.fV(), sb.toString());
            return null;
        }
        s.a(fL2, str, str3, true, isFromCDN, z2, k.length, "", fL2.fV(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, iVar, k, rect);
        if (a4 != null) {
            a4.Gx.Gz = "net";
            a4.Gx.GA = fL.fV();
            a4.Gx.GB = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.aja) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.dX(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.t(true);
                cVar.setData(bArr);
                cVar.w(z);
                com.baidu.adp.lib.Disk.d.dI().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.vC = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fN() {
        return com.baidu.tbadk.core.h.oS().oY();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ev().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(am.aN(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + an.vO().vT());
            sb.append("&first_gif=1");
            if (ws()) {
                sb.append("&ispv=1");
            }
            if (wt()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c el(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.h(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, cVar.isGif(), str);
        }
        return null;
    }

    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.Bytes2Bitmap(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Ev().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fO() {
        return h.wv().fO();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fP() {
        return 1;
    }
}
