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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean qf();

    public abstract boolean qg();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a en = com.baidu.tbadk.imageManager.e.vL().en(str);
        if (en != null) {
            en.vu.vw = "memory";
            en.vu.vx = 0L;
            en.vu.vy = true;
        }
        return en;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q ef = w.ef();
        ef.startTimer();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cR = cR(bc.cI(str2));
        if (cR == null) {
            return null;
        }
        cR.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cR.o(true);
        cR.p(false);
        cR.g(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cR);
            aVar.lc = dVar;
        }
        boolean fh = com.baidu.adp.lib.util.i.fh();
        if (!com.baidu.adp.lib.Disk.d.bO().c(cR)) {
            w.a(ef, str2, false, ef.eM(), fh);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (fh) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = cR.isSuccess() ? a(cR, str2) : null;
        if (a != null) {
            w.a(ef, str2, true, ef.eM(), fh);
        } else {
            w.a(ef, str2, false, ef.eM(), fh);
        }
        if (a != null) {
            a.vu.vw = "disk";
            a.vu.vx = ef.eM();
            a.vu.vy = true;
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
        com.baidu.adp.lib.stats.q ef = w.ef();
        ef.startTimer();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.m255getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, dip2px2);
        if (!(TbadkCoreApplication.m255getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.f.dc().Z("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = String.valueOf(d.substring(0, lastIndexOf)) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.httpNet.i iVar = new com.baidu.tbadk.core.util.httpNet.i();
        if (aVar != null) {
            aVar.lc = iVar;
        }
        byte[] l = iVar.l(str3, !isFromCDN);
        if (!iVar.qc()) {
            if (!iVar.dQ().kF) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                w.a(ef, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.KI, "NetworkError", ef.eM(), iVar.qe(), j);
            }
            return null;
        } else if (l == null) {
            w.a(ef, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.KI, "ByteIsNull", ef.eM(), iVar.qe(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                i.qh().c(l.length, ef.eM());
                w.a(ef, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.KI, "", ef.eM(), iVar.qe(), l.length);
            } else {
                w.a(ef, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.KI, "bytes<1", ef.eM(), iVar.qe(), l.length);
            }
            com.baidu.adp.lib.stats.q ef2 = w.ef();
            ef2.startTimer();
            com.baidu.tbadk.imageManager.e.vL().dq(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(iVar.KE, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m255getInst().incWebpFailureCount();
                byte[] l2 = iVar.l(d, !isFromCDN);
                ef2.startTimer();
                if (l2 == null || !iVar.qc()) {
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
                    w.a(ef2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", ef2.eM(), sb.toString());
                } else {
                    w.a(ef2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", ef2.eM(), sb.toString());
                }
                return null;
            }
            boolean z3 = iVar.vk || com.baidu.adp.lib.util.l.l(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                w.a(ef2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", ef2.eM(), sb.toString());
                return null;
            }
            w.a(ef2, str, str3, true, isFromCDN, z2, bArr.length, "", ef2.eM(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, iVar, bArr, rect);
            if (a != null) {
                a.vu.vw = "net";
                a.vu.vx = ef.eM();
                a.vu.vy = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.KK) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.cI(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.bO().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(cVar);
                    aVar.lc = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.g
    public boolean eh() {
        return com.baidu.tbadk.core.l.mc().mg();
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.vL().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ba.aE(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + bb.px().pC());
            sb.append("&first_gif=1");
            if (qf()) {
                sb.append("&ispv=1");
            }
            if (qg()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c cR(String str) {
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
            return new com.baidu.adp.widget.a.a(bitmap, cVar.cm(), str);
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
            com.baidu.tbadk.imageManager.e.vL().dq(com.baidu.tbadk.core.util.d.d(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        return i.qh().ei();
    }

    @Override // com.baidu.adp.lib.f.g
    public int ej() {
        return 1;
    }
}
