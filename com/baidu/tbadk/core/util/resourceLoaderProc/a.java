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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean qq();

    public abstract boolean qr();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.we().en(str);
        if (en != null) {
            en.vA.vC = "memory";
            en.vA.vD = 0L;
            en.vA.vE = true;
        }
        return en;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q ed = w.ed();
        ed.eK();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cQ = cQ(bh.cH(str2));
        if (cQ == null) {
            return null;
        }
        cQ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cQ.o(true);
        cQ.p(false);
        cQ.g(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cQ);
            aVar.lf = dVar;
        }
        boolean fg = com.baidu.adp.lib.util.i.fg();
        if (!com.baidu.adp.lib.Disk.d.bM().c(cQ)) {
            w.a(ed, str2, false, ed.eL(), fg);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (fg) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = cQ.isSuccess() ? a(cQ, str2) : null;
        if (a != null) {
            w.a(ed, str2, true, ed.eL(), fg);
        } else {
            w.a(ed, str2, false, ed.eL(), fg);
        }
        if (a != null) {
            a.vA.vC = "disk";
            a.vA.vD = ed.eL();
            a.vA.vE = true;
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
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
        com.baidu.adp.lib.stats.q ed = w.ed();
        ed.eK();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, dip2px2);
        if (!(TbadkCoreApplication.m255getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.f.da().Z("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = String.valueOf(d.substring(0, lastIndexOf)) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.httpNet.i iVar = new com.baidu.tbadk.core.util.httpNet.i();
        if (aVar != null) {
            aVar.lf = iVar;
        }
        byte[] l = iVar.l(str3, !isFromCDN);
        if (!iVar.qn()) {
            if (!iVar.dO().kI) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                w.a(ed, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.Lc, "NetworkError", ed.eL(), iVar.qp(), j);
            }
            return null;
        } else if (l == null) {
            w.a(ed, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.Lc, "ByteIsNull", ed.eL(), iVar.qp(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                i.qs().c(l.length, ed.eL());
                w.a(ed, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.Lc, "", ed.eL(), iVar.qp(), l.length);
            } else {
                w.a(ed, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.Lc, "bytes<1", ed.eL(), iVar.qp(), l.length);
            }
            com.baidu.adp.lib.stats.q ed2 = w.ed();
            ed2.eK();
            com.baidu.tbadk.imageManager.e.we().dx(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(iVar.KY, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m255getInst().incWebpFailureCount();
                byte[] l2 = iVar.l(d, !isFromCDN);
                ed2.eK();
                if (l2 == null || !iVar.qn()) {
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
                    w.a(ed2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", ed2.eL(), sb.toString());
                } else {
                    w.a(ed2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", ed2.eL(), sb.toString());
                }
                return null;
            }
            boolean z3 = iVar.vq || com.baidu.adp.lib.util.l.l(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                w.a(ed2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", ed2.eL(), sb.toString());
                return null;
            }
            w.a(ed2, str, str3, true, isFromCDN, z2, bArr.length, "", ed2.eL(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, iVar, bArr, rect);
            if (a != null) {
                a.vA.vC = "net";
                a.vA.vD = ed.eL();
                a.vA.vE = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.Le) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bh.cH(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.bM().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(cVar);
                    aVar.lf = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.g
    public boolean ef() {
        return com.baidu.tbadk.core.l.mc().mg();
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.we().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(bf.aE(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + bg.pI().pN());
            sb.append("&first_gif=1");
            if (qq()) {
                sb.append("&ispv=1");
            }
            if (qr()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c cQ(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.j(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, cVar.ck(), str);
        }
        return null;
    }

    protected Bitmap b(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.d.a(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.e.we().dx(com.baidu.tbadk.core.util.d.d(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel eg() {
        return i.qs().eg();
    }

    @Override // com.baidu.adp.lib.f.g
    public int eh() {
        return 1;
    }
}
