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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.r;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean wu();

    public abstract boolean wv();

    public abstract int ww();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gp = com.baidu.tbadk.imageManager.c.Ex().gp(str);
        if (gp != null) {
            gp.IB.IE = "memory";
            gp.IB.IF = 0L;
            gp.IB.IG = true;
        }
        return gp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fV = r.fV();
        fV.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ep = ep(an.eb(str2));
        if (ep == null) {
            return null;
        }
        ep.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ep.s(true);
        ep.t(false);
        ep.k(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ep);
            aVar.xJ = dVar;
        }
        boolean hs = com.baidu.adp.lib.util.i.hs();
        if (!com.baidu.adp.lib.Disk.d.dS().c(ep)) {
            r.a(fV, str2, false, fV.gf(), hs);
            return null;
        }
        int i = 2000;
        if (hs) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = ep.isSuccess() ? a(ep, str2) : null;
        if (a != null) {
            r.a(fV, str2, true, fV.gf(), hs);
        } else {
            r.a(fV, str2, false, fV.gf(), hs);
        }
        if (a != null) {
            a.IB.IE = "disk";
            a.IB.IF = fV.gf();
            a.IB.IG = true;
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
        com.baidu.adp.lib.stats.a fV = r.fV();
        fV.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.fh().al("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = c.substring(0, lastIndexOf) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.xJ = iVar;
        }
        byte[] k = iVar.k(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.wq()) {
            if (iVar.responseCode == 302 && (17 == ww() || 18 == ww() || 13 == ww() || 14 == ww())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.g.img_default_delete, new TypedValue());
                    byte[] o = com.baidu.adp.lib.network.a.b.o(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(o, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.k.p(o), iVar, o, rect);
                    if (a != null) {
                        a.IB.IE = "net";
                        a.IB.IF = fV.gf();
                        a.IB.IG = true;
                    }
                    com.baidu.adp.lib.g.a.p(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.fK().xs) {
                long j = 0;
                if (k != null) {
                    j = k.length;
                }
                r.a(fV, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ajA, "NetworkError", fV.gf(), iVar.wt(), j, ww());
                return null;
            }
        }
        if (k == null && !iVar.fK().xs) {
            r.a(fV, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ajA, "ByteIsNull", fV.gf(), iVar.wt(), 0L, ww());
            return null;
        }
        if (k.length > 1) {
            h.wx().b(k.length, fV.gf());
            r.a(fV, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.ajA, "InputToByteSucc", fV.gf(), iVar.wt(), k.length, ww());
        } else {
            r.a(fV, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ajA, "bytes<1", fV.gf(), iVar.wt(), k.length, ww());
        }
        com.baidu.adp.lib.stats.a fV2 = r.fV();
        fV2.startTimer();
        com.baidu.tbadk.imageManager.c.Ex().eX(TbConfig.getPbImageSize() + k.length);
        Bitmap a2 = a(k, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            k = iVar.k(c, !isFromCDN);
            fV2.startTimer();
            if (k == null || !iVar.wq()) {
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
                r.a(fV2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fV2.gf(), sb.toString());
            } else {
                r.a(fV2, str, str3, false, isFromCDN, z2, k.length, "ConvertError", fV2.gf(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.k.p(k);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            r.a(fV2, str, str3, false, isFromCDN, z2, k.length, "ResizeError", fV2.gf(), sb.toString());
            return null;
        }
        r.a(fV2, str, str3, true, isFromCDN, z2, k.length, "", fV2.gf(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, iVar, k, rect);
        if (a4 != null) {
            a4.IB.IE = "net";
            a4.IB.IF = fV.gf();
            a4.IB.IG = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.ajF) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.eb(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(true);
                cVar.setData(bArr);
                cVar.v(z);
                com.baidu.adp.lib.Disk.d.dS().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.xJ = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fX() {
        return com.baidu.tbadk.core.h.oX().pd();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ex().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(al.aQ(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + am.vQ().vV());
            sb.append("&first_gif=1");
            if (wu()) {
                sb.append("&ispv=1");
            }
            if (wv()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c ep(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.n(cVar.getData());
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
    public boolean h(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Ex().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fY() {
        return h.wx().fY();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fZ() {
        return 1;
    }
}
