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

    public abstract boolean wv();

    public abstract boolean ww();

    public abstract int wx();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gt = com.baidu.tbadk.imageManager.c.Ex().gt(str);
        if (gt != null) {
            gt.IE.IG = "memory";
            gt.IE.IH = 0L;
            gt.IE.II = true;
        }
        return gt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fV = r.fV();
        fV.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c et = et(an.ef(str2));
        if (et == null) {
            return null;
        }
        et.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        et.s(true);
        et.t(false);
        et.k(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(et);
            aVar.xL = dVar;
        }
        boolean hs = com.baidu.adp.lib.util.i.hs();
        if (!com.baidu.adp.lib.Disk.d.dS().c(et)) {
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
        com.baidu.adp.widget.a.a a = et.isSuccess() ? a(et, str2) : null;
        if (a != null) {
            r.a(fV, str2, true, fV.gf(), hs);
        } else {
            r.a(fV, str2, false, fV.gf(), hs);
        }
        if (a != null) {
            a.IE.IG = "disk";
            a.IE.IH = fV.gf();
            a.IE.II = true;
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
        String d = isFromCDN ? str : d(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.fh().am("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = d.substring(0, lastIndexOf) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.xL = iVar;
        }
        byte[] k = iVar.k(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.wr()) {
            if (iVar.responseCode == 302 && (17 == wx() || 18 == wx() || 13 == wx() || 14 == wx())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.g.img_default_delete, new TypedValue());
                    byte[] o = com.baidu.adp.lib.network.a.b.o(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(o, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.k.p(o), iVar, o, rect);
                    if (a != null) {
                        a.IE.IG = "net";
                        a.IE.IH = fV.gf();
                        a.IE.II = true;
                    }
                    com.baidu.adp.lib.g.a.p(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.fK().xu) {
                long j = 0;
                if (k != null) {
                    j = k.length;
                }
                r.a(fV, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ajC, "NetworkError", fV.gf(), iVar.wu(), j, wx());
                return null;
            }
        }
        if (k == null && !iVar.fK().xu) {
            r.a(fV, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ajC, "ByteIsNull", fV.gf(), iVar.wu(), 0L, wx());
            return null;
        }
        if (k.length > 1) {
            h.wy().b(k.length, fV.gf());
            r.a(fV, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.ajC, "InputToByteSucc", fV.gf(), iVar.wu(), k.length, wx());
        } else {
            r.a(fV, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ajC, "bytes<1", fV.gf(), iVar.wu(), k.length, wx());
        }
        com.baidu.adp.lib.stats.a fV2 = r.fV();
        fV2.startTimer();
        com.baidu.tbadk.imageManager.c.Ex().eX(TbConfig.getPbImageSize() + k.length);
        Bitmap a2 = a(k, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            k = iVar.k(d, !isFromCDN);
            fV2.startTimer();
            if (k == null || !iVar.wr()) {
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
            a4.IE.IG = "net";
            a4.IE.IH = fV.gf();
            a4.IE.II = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.ajH) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.ef(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(true);
                cVar.setData(bArr);
                cVar.v(z);
                com.baidu.adp.lib.Disk.d.dS().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.xL = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fX() {
        return com.baidu.tbadk.core.h.oY().pe();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ex().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(al.aR(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + am.vR().vW());
            sb.append("&first_gif=1");
            if (wv()) {
                sb.append("&ispv=1");
            }
            if (ww()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c et(String str) {
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
        return h.wy().fY();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fZ() {
        return 1;
    }
}
