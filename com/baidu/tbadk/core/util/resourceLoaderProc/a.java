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

    public abstract boolean qj();

    public abstract boolean qk();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a ek = com.baidu.tbadk.imageManager.e.vY().ek(str);
        if (ek != null) {
            ek.vx.vz = "memory";
            ek.vx.vA = 0L;
            ek.vx.vB = true;
        }
        return ek;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q ed = w.ed();
        ed.eK();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cN = cN(bh.cE(str2));
        if (cN == null) {
            return null;
        }
        cN.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cN.o(true);
        cN.p(false);
        cN.g(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cN);
            aVar.lf = dVar;
        }
        boolean fg = com.baidu.adp.lib.util.i.fg();
        if (!com.baidu.adp.lib.Disk.d.bM().c(cN)) {
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
        com.baidu.adp.widget.a.a a = cN.isSuccess() ? a(cN, str2) : null;
        if (a != null) {
            w.a(ed, str2, true, ed.eL(), fg);
        } else {
            w.a(ed, str2, false, ed.eL(), fg);
        }
        if (a != null) {
            a.vx.vz = "disk";
            a.vx.vA = ed.eL();
            a.vx.vB = true;
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
        if (!iVar.qg()) {
            if (!iVar.dO().kI) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                w.a(ed, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.KZ, "NetworkError", ed.eL(), iVar.qi(), j);
            }
            return null;
        } else if (l == null) {
            w.a(ed, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.KZ, "ByteIsNull", ed.eL(), iVar.qi(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                i.ql().c(l.length, ed.eL());
                w.a(ed, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.KZ, "", ed.eL(), iVar.qi(), l.length);
            } else {
                w.a(ed, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.KZ, "bytes<1", ed.eL(), iVar.qi(), l.length);
            }
            com.baidu.adp.lib.stats.q ed2 = w.ed();
            ed2.eK();
            com.baidu.tbadk.imageManager.e.vY().dx(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(iVar.KV, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m255getInst().incWebpFailureCount();
                byte[] l2 = iVar.l(d, !isFromCDN);
                ed2.eK();
                if (l2 == null || !iVar.qg()) {
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
            boolean z3 = iVar.vn || com.baidu.adp.lib.util.l.l(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                w.a(ed2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", ed2.eL(), sb.toString());
                return null;
            }
            w.a(ed2, str, str3, true, isFromCDN, z2, bArr.length, "", ed2.eL(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, iVar, bArr, rect);
            if (a != null) {
                a.vx.vz = "net";
                a.vx.vA = ed.eL();
                a.vx.vB = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.Lb) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bh.cE(str2), DiskFileOperate.Action.WRITE);
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
        return com.baidu.tbadk.core.l.lV().lZ();
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.vY().c(str, (com.baidu.adp.widget.a.a) obj);
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
            sb.append("&qulity=" + bg.pB().pG());
            sb.append("&first_gif=1");
            if (qj()) {
                sb.append("&ispv=1");
            }
            if (qk()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c cN(String str) {
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
            com.baidu.tbadk.imageManager.e.vY().dx(com.baidu.tbadk.core.util.d.d(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel eg() {
        return i.ql().eg();
    }

    @Override // com.baidu.adp.lib.f.g
    public int eh() {
        return 1;
    }
}
