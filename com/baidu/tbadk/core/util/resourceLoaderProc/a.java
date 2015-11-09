package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean vm();

    public abstract boolean vn();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fq = com.baidu.tbadk.imageManager.c.BV().fq(str);
        if (fq != null) {
            fq.Gp.Gr = "memory";
            fq.Gp.Gs = 0L;
            fq.Gp.Gt = true;
        }
        return fq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hc = r.hc();
        hc.hz();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dx = dx(au.dn(str2));
        if (dx == null) {
            return null;
        }
        dx.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dx.o(true);
        dx.p(false);
        dx.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dx);
            aVar.vs = dVar;
        }
        boolean iO = com.baidu.adp.lib.util.i.iO();
        if (!com.baidu.adp.lib.Disk.d.fj().c(dx)) {
            r.a(hc, str2, false, hc.hA(), iO);
            return null;
        }
        int i = 2000;
        if (iO) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dx.isSuccess() ? a(dx, str2) : null;
        if (a != null) {
            r.a(hc, str2, true, hc.hA(), iO);
        } else {
            r.a(hc, str2, false, hc.hA(), iO);
        }
        if (a != null) {
            a.Gp.Gr = "disk";
            a.Gp.Gs = hc.hA();
            a.Gp.Gt = true;
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] bArr;
        boolean z2;
        Bitmap bitmap;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.d hc = r.hc();
        hc.hz();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, dip2px2);
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.gv().af("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = String.valueOf(d.substring(0, lastIndexOf)) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.j jVar = new com.baidu.tbadk.core.util.a.j();
        if (aVar != null) {
            aVar.vs = jVar;
        }
        byte[] l = jVar.l(str3, !isFromCDN);
        if (!jVar.vj()) {
            if (!jVar.gR().vd) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                r.a(hc, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.acC, "NetworkError", hc.hA(), jVar.vl(), j);
            }
            return null;
        } else if (l == null) {
            r.a(hc, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.acC, "ByteIsNull", hc.hA(), jVar.vl(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                h.vo().b(l.length, hc.hA());
                r.a(hc, str, true, str3, isFromCDN, Boolean.valueOf(z), jVar.acC, "", hc.hA(), jVar.vl(), l.length);
            } else {
                r.a(hc, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.acC, "bytes<1", hc.hA(), jVar.vl(), l.length);
            }
            com.baidu.adp.lib.stats.d hc2 = r.hc();
            hc2.hz();
            com.baidu.tbadk.imageManager.c.BV().el(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m411getInst().incWebpFailureCount();
                byte[] l2 = jVar.l(d, !isFromCDN);
                hc2.hz();
                if (l2 == null || !jVar.vj()) {
                    bArr = l2;
                    z2 = false;
                    bitmap = b;
                } else {
                    StringBuilder sb2 = new StringBuilder(100);
                    bArr = l2;
                    z2 = false;
                    bitmap = b(l2, rect, sb2);
                    sb = sb2;
                }
            } else {
                bArr = l;
                z2 = z;
                bitmap = b;
            }
            if (bArr == null || bitmap == null) {
                if (bArr == null) {
                    r.a(hc2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", hc2.hA(), sb.toString());
                } else {
                    r.a(hc2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", hc2.hA(), sb.toString());
                }
                return null;
            }
            boolean z3 = jVar.Gf || com.baidu.adp.lib.util.k.z(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                r.a(hc2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", hc2.hA(), sb.toString());
                return null;
            }
            r.a(hc2, str, str3, true, isFromCDN, z2, bArr.length, "", hc2.hA(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, jVar, bArr, rect);
            if (a != null) {
                a.Gp.Gr = "net";
                a.Gp.Gs = hc.hA();
                a.Gp.Gt = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.j jVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!jVar.acE) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.dn(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.fj().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.vs = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean he() {
        return com.baidu.tbadk.core.m.qV().qZ();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.BV().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(as.aP(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + at.uK().uP());
            sb.append("&first_gif=1");
            if (vm()) {
                sb.append("&ispv=1");
            }
            if (vn()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dx(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.x(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, cVar.fF(), str);
        }
        return null;
    }

    protected Bitmap b(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.c.a(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.BV().el(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel hf() {
        return h.vo().hf();
    }

    @Override // com.baidu.adp.lib.f.e
    public int hg() {
        return 1;
    }
}
