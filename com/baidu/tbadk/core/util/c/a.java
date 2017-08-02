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

    public abstract boolean wk();

    public abstract boolean wl();

    public abstract int wm();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gk = com.baidu.tbadk.imageManager.c.Ep().gk(str);
        if (gk != null) {
            gk.Hc.He = "memory";
            gk.Hc.Hf = 0L;
            gk.Hc.Hg = true;
        }
        return gk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fK = r.fK();
        fK.fT();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ej = ej(an.dV(str2));
        if (ej == null) {
            return null;
        }
        ej.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ej.s(true);
        ej.t(false);
        ej.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ej);
            aVar.wh = dVar;
        }
        boolean hi = com.baidu.adp.lib.util.i.hi();
        if (!com.baidu.adp.lib.Disk.d.dH().c(ej)) {
            r.a(fK, str2, false, fK.fU(), hi);
            return null;
        }
        int i = 2000;
        if (hi) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = ej.isSuccess() ? a(ej, str2) : null;
        if (a != null) {
            r.a(fK, str2, true, fK.fU(), hi);
        } else {
            r.a(fK, str2, false, fK.fU(), hi);
        }
        if (a != null) {
            a.Hc.He = "disk";
            a.Hc.Hf = fK.fU();
            a.Hc.Hg = true;
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
        com.baidu.adp.lib.stats.a fK = r.fK();
        fK.fT();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.eW().af("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = c.substring(0, lastIndexOf) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.wh = iVar;
        }
        byte[] k = iVar.k(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.wg()) {
            if (iVar.responseCode == 302 && (17 == wm() || 18 == wm() || 13 == wm() || 14 == wm())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.g.img_default_delete, new TypedValue());
                    byte[] i3 = com.baidu.adp.lib.network.a.b.i(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(i3, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.k.m(i3), iVar, i3, rect);
                    if (a != null) {
                        a.Hc.He = "net";
                        a.Hc.Hf = fK.fU();
                        a.Hc.Hg = true;
                    }
                    com.baidu.adp.lib.g.a.j(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.fz().vQ) {
                long j = 0;
                if (k != null) {
                    j = k.length;
                }
                r.a(fK, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aih, "NetworkError", fK.fU(), iVar.wj(), j, wm());
                return null;
            }
        }
        if (k == null && !iVar.fz().vQ) {
            r.a(fK, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aih, "ByteIsNull", fK.fU(), iVar.wj(), 0L, wm());
            return null;
        }
        if (k.length > 1) {
            h.wn().b(k.length, fK.fU());
            r.a(fK, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.aih, "InputToByteSucc", fK.fU(), iVar.wj(), k.length, wm());
        } else {
            r.a(fK, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aih, "bytes<1", fK.fU(), iVar.wj(), k.length, wm());
        }
        com.baidu.adp.lib.stats.a fK2 = r.fK();
        fK2.fT();
        com.baidu.tbadk.imageManager.c.Ep().eV(TbConfig.getPbImageSize() + k.length);
        Bitmap a2 = a(k, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            k = iVar.k(c, !isFromCDN);
            fK2.fT();
            if (k == null || !iVar.wg()) {
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
                r.a(fK2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fK2.fU(), sb.toString());
            } else {
                r.a(fK2, str, str3, false, isFromCDN, z2, k.length, "ConvertError", fK2.fU(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.k.m(k);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            r.a(fK2, str, str3, false, isFromCDN, z2, k.length, "ResizeError", fK2.fU(), sb.toString());
            return null;
        }
        r.a(fK2, str, str3, true, isFromCDN, z2, k.length, "", fK2.fU(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, iVar, k, rect);
        if (a4 != null) {
            a4.Hc.He = "net";
            a4.Hc.Hf = fK.fU();
            a4.Hc.Hg = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.aim) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.dV(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(true);
                cVar.setData(bArr);
                cVar.v(z);
                com.baidu.adp.lib.Disk.d.dH().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.wh = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fM() {
        return com.baidu.tbadk.core.h.oN().oT();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ep().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(al.aK(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + am.vG().vL());
            sb.append("&first_gif=1");
            if (wk()) {
                sb.append("&ispv=1");
            }
            if (wl()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c ej(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.k(cVar.getData());
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
    public boolean g(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Ep().eV(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        return h.wn().fN();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fO() {
        return 1;
    }
}
