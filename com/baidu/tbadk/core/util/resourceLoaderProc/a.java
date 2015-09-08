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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean vn();

    public abstract boolean vo();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fj = com.baidu.tbadk.imageManager.c.Cs().fj(str);
        if (fj != null) {
            fj.Gn.Gp = "memory";
            fj.Gn.Gq = 0L;
            fj.Gn.Gr = true;
        }
        return fj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d ha = r.ha();
        ha.hx();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dt = dt(as.di(str2));
        if (dt == null) {
            return null;
        }
        dt.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dt.o(true);
        dt.p(false);
        dt.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dt);
            aVar.vr = dVar;
        }
        boolean iM = com.baidu.adp.lib.util.i.iM();
        if (!com.baidu.adp.lib.Disk.d.fj().c(dt)) {
            r.a(ha, str2, false, ha.hy(), iM);
            return null;
        }
        int i = 2000;
        if (iM) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dt.isSuccess() ? a(dt, str2) : null;
        if (a != null) {
            r.a(ha, str2, true, ha.hy(), iM);
        } else {
            r.a(ha, str2, false, ha.hy(), iM);
        }
        if (a != null) {
            a.Gn.Gp = "disk";
            a.Gn.Gq = ha.hy();
            a.Gn.Gr = true;
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
        com.baidu.adp.lib.stats.d ha = r.ha();
        ha.hx();
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
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.vr = iVar;
        }
        byte[] l = iVar.l(str3, !isFromCDN);
        if (!iVar.vk()) {
            if (!iVar.gQ().vc) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                r.a(ha, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.acx, "NetworkError", ha.hy(), iVar.vm(), j);
            }
            return null;
        } else if (l == null) {
            r.a(ha, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.acx, "ByteIsNull", ha.hy(), iVar.vm(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                i.vp().b(l.length, ha.hy());
                r.a(ha, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.acx, "", ha.hy(), iVar.vm(), l.length);
            } else {
                r.a(ha, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.acx, "bytes<1", ha.hy(), iVar.vm(), l.length);
            }
            com.baidu.adp.lib.stats.d ha2 = r.ha();
            ha2.hx();
            com.baidu.tbadk.imageManager.c.Cs().em(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m411getInst().incWebpFailureCount();
                byte[] l2 = iVar.l(d, !isFromCDN);
                ha2.hx();
                if (l2 == null || !iVar.vk()) {
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
                    r.a(ha2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", ha2.hy(), sb.toString());
                } else {
                    r.a(ha2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", ha2.hy(), sb.toString());
                }
                return null;
            }
            boolean z3 = iVar.Gd || com.baidu.adp.lib.util.k.z(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                r.a(ha2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", ha2.hy(), sb.toString());
                return null;
            }
            r.a(ha2, str, str3, true, isFromCDN, z2, bArr.length, "", ha2.hy(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, iVar, bArr, rect);
            if (a != null) {
                a.Gn.Gp = "net";
                a.Gn.Gq = ha.hy();
                a.Gn.Gr = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.acz) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.di(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.fj().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.vr = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean hc() {
        return com.baidu.tbadk.core.m.rb().rf();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Cs().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(aq.aR(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.uK().uP());
            sb.append("&first_gif=1");
            if (vn()) {
                sb.append("&ispv=1");
            }
            if (vo()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dt(String str) {
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
            com.baidu.tbadk.imageManager.c.Cs().em(com.baidu.tbadk.core.util.c.f(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel hd() {
        return i.vp().hd();
    }

    @Override // com.baidu.adp.lib.f.e
    public int he() {
        return 1;
    }
}
