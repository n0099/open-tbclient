package com.baidu.tbadk.core.util.resourceLoaderProc;

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
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.n;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.g.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean vS();

    public abstract boolean vT();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fF = com.baidu.tbadk.imageManager.c.CX().fF(str);
        if (fF != null) {
            fF.GG.GI = "memory";
            fF.GG.GJ = 0L;
            fF.GG.GK = true;
        }
        return fF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d he = v.he();
        he.hB();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dH = dH(az.dy(str2));
        if (dH == null) {
            return null;
        }
        dH.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dH.o(true);
        dH.p(false);
        dH.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dH);
            aVar.vy = dVar;
        }
        boolean iQ = com.baidu.adp.lib.util.i.iQ();
        if (!com.baidu.adp.lib.Disk.d.fj().c(dH)) {
            v.a(he, str2, false, he.hC(), iQ);
            return null;
        }
        int i = 2000;
        if (iQ) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dH.isSuccess() ? a(dH, str2) : null;
        if (a != null) {
            v.a(he, str2, true, he.hC(), iQ);
        } else {
            v.a(he, str2, false, he.hC(), iQ);
        }
        if (a != null) {
            a.GG.GI = "disk";
            a.GG.GJ = he.hC();
            a.GG.GK = true;
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        boolean z;
        String str3;
        boolean z2;
        Bitmap bitmap;
        StringBuilder sb;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.d he = v.he();
        he.hB();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, height);
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.c.e.gw().aj("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = String.valueOf(d.substring(0, lastIndexOf)) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.j jVar = new com.baidu.tbadk.core.util.a.j();
        if (aVar != null) {
            aVar.vy = jVar;
        }
        byte[] m = jVar.m(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!jVar.vP()) {
            if (jVar.responseCode == 302 && !com.baidu.tbadk.util.e.gb(d)) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m411getInst().getResources().openRawResource(n.e.img_default_delete, new TypedValue());
                    byte[] d2 = com.baidu.adp.lib.network.a.b.d(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, com.baidu.tbadk.core.util.c.a(d2, rect, sb2), jVar.Gu || com.baidu.adp.lib.util.k.z(d2), jVar, d2, rect);
                    if (a != null) {
                        a.GG.GI = "net";
                        a.GG.GJ = he.hC();
                        a.GG.GK = true;
                    }
                    com.baidu.adp.lib.h.a.e(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!jVar.gT().vj) {
                long j = 0;
                if (m != null) {
                    j = m.length;
                }
                v.a(he, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.adu, "NetworkError", he.hC(), jVar.vR(), j);
                return null;
            }
        }
        if (m == null) {
            v.a(he, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.adu, "ByteIsNull", he.hC(), jVar.vR(), 0L);
            return null;
        }
        if (m.length > 1) {
            h.vU().b(m.length, he.hC());
            v.a(he, str, true, str3, isFromCDN, Boolean.valueOf(z), jVar.adu, "", he.hC(), jVar.vR(), m.length);
        } else {
            v.a(he, str, false, str3, isFromCDN, Boolean.valueOf(z), jVar.adu, "bytes<1", he.hC(), jVar.vR(), m.length);
        }
        com.baidu.adp.lib.stats.d he2 = v.he();
        he2.hB();
        com.baidu.tbadk.imageManager.c.CX().ez(TbConfig.getPbImageSize() + m.length);
        Bitmap b = b(m, rect, sb2);
        if (z && b == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m411getInst().incWebpFailureCount();
            m = jVar.m(d, !isFromCDN);
            he2.hB();
            if (m == null || !jVar.vP()) {
                bitmap = b;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = b(m, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = b;
            sb = sb2;
        }
        if (m == null || bitmap == null) {
            if (m == null) {
                v.a(he2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", he2.hC(), sb.toString());
            } else {
                v.a(he2, str, str3, false, isFromCDN, z2, m.length, "ConvertError", he2.hC(), sb.toString());
            }
            return null;
        }
        boolean z3 = jVar.Gu || com.baidu.adp.lib.util.k.z(m);
        Bitmap b2 = b(bitmap, dip2px, height);
        if (b2 == null) {
            v.a(he2, str, str3, false, isFromCDN, z2, m.length, "ResizeError", he2.hC(), sb.toString());
            return null;
        }
        v.a(he2, str, str3, true, isFromCDN, z2, m.length, "", he2.hC(), sb.toString());
        com.baidu.adp.widget.a.a a2 = a(str, str2, aVar, null, b2, z3, jVar, m, rect);
        if (a2 != null) {
            a2.GG.GI = "net";
            a2.GG.GJ = he.hC();
            a2.GG.GK = true;
            return a2;
        }
        return a2;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.j jVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!jVar.adw) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, az.dy(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.fj().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.vy = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.g.e
    public boolean hg() {
        return com.baidu.tbadk.core.m.rh().rn();
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.CX().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ax.aT(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ay.vq().vv());
            sb.append("&first_gif=1");
            if (vS()) {
                sb.append("&ispv=1");
            }
            if (vT()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dH(String str) {
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
            com.baidu.tbadk.imageManager.c.CX().ez(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hh() {
        return h.vU().hh();
    }

    @Override // com.baidu.adp.lib.g.e
    public int hi() {
        return 1;
    }
}
