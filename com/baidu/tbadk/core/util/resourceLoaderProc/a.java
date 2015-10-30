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

    public abstract boolean vi();

    public abstract boolean vj();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fo = com.baidu.tbadk.imageManager.c.Cc().fo(str);
        if (fo != null) {
            fo.Go.Gq = "memory";
            fo.Go.Gr = 0L;
            fo.Go.Gs = true;
        }
        return fo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hb = r.hb();
        hb.hy();
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
        boolean iN = com.baidu.adp.lib.util.i.iN();
        if (!com.baidu.adp.lib.Disk.d.fj().c(dx)) {
            r.a(hb, str2, false, hb.hz(), iN);
            return null;
        }
        int i = 2000;
        if (iN) {
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
            r.a(hb, str2, true, hb.hz(), iN);
        } else {
            r.a(hb, str2, false, hb.hz(), iN);
        }
        if (a != null) {
            a.Go.Gq = "disk";
            a.Go.Gr = hb.hz();
            a.Go.Gs = true;
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
        com.baidu.adp.lib.stats.d hb = r.hb();
        hb.hy();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, dip2px2);
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.gv().ah("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
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
        if (!jVar.vf()) {
            if (!jVar.gQ().vd) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                r.a(hb, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.acx, "NetworkError", hb.hz(), jVar.vh(), j);
            }
            return null;
        } else if (l == null) {
            r.a(hb, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.acx, "ByteIsNull", hb.hz(), jVar.vh(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                i.vk().b(l.length, hb.hz());
                r.a(hb, str, true, str3, isFromCDN, Boolean.valueOf(z), jVar.acx, "", hb.hz(), jVar.vh(), l.length);
            } else {
                r.a(hb, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.acx, "bytes<1", hb.hz(), jVar.vh(), l.length);
            }
            com.baidu.adp.lib.stats.d hb2 = r.hb();
            hb2.hy();
            com.baidu.tbadk.imageManager.c.Cc().en(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m411getInst().incWebpFailureCount();
                byte[] l2 = jVar.l(d, !isFromCDN);
                hb2.hy();
                if (l2 == null || !jVar.vf()) {
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
                    r.a(hb2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", hb2.hz(), sb.toString());
                } else {
                    r.a(hb2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", hb2.hz(), sb.toString());
                }
                return null;
            }
            boolean z3 = jVar.Ge || com.baidu.adp.lib.util.k.z(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                r.a(hb2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", hb2.hz(), sb.toString());
                return null;
            }
            r.a(hb2, str, str3, true, isFromCDN, z2, bArr.length, "", hb2.hz(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, jVar, bArr, rect);
            if (a != null) {
                a.Go.Gq = "net";
                a.Go.Gr = hb.hz();
                a.Go.Gs = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.j jVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!jVar.acz) {
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
    public boolean hd() {
        return com.baidu.tbadk.core.m.qU().qY();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Cc().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(as.aR(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + at.uG().uL());
            sb.append("&first_gif=1");
            if (vi()) {
                sb.append("&ispv=1");
            }
            if (vj()) {
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
            com.baidu.tbadk.imageManager.c.Cc().en(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel he() {
        return i.vk().he();
    }

    @Override // com.baidu.adp.lib.f.e
    public int hf() {
        return 1;
    }
}
