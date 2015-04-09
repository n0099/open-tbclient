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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean tA();

    public abstract boolean tz();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a eu = com.baidu.tbadk.imageManager.e.zy().eu(str);
        if (eu != null) {
            eu.Gw.Gy = "memory";
            eu.Gw.Gz = 0L;
            eu.Gw.GA = true;
        }
        return eu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.q hC = t.hC();
        hC.il();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cW = cW(bf.cN(str2));
        if (cW == null) {
            return null;
        }
        cW.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cW.o(true);
        cW.p(false);
        cW.g(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cW);
            aVar.wt = dVar;
        }
        boolean iI = com.baidu.adp.lib.util.k.iI();
        if (!com.baidu.adp.lib.Disk.d.fk().c(cW)) {
            t.a(hC, str2, false, hC.im(), iI);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (iI) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = cW.isSuccess() ? a(cW, str2) : null;
        if (a != null) {
            t.a(hC, str2, true, hC.im(), iI);
        } else {
            t.a(hC, str2, false, hC.im(), iI);
        }
        if (a != null) {
            a.Gw.Gy = "disk";
            a.Gw.Gz = hC.im();
            a.Gw.GA = true;
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
        com.baidu.adp.lib.stats.q hC = t.hC();
        hC.il();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.n.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, dip2px2);
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.f.gz().ag("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = String.valueOf(d.substring(0, lastIndexOf)) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.httpNet.h hVar = new com.baidu.tbadk.core.util.httpNet.h();
        if (aVar != null) {
            aVar.wt = hVar;
        }
        byte[] l = hVar.l(str3, !isFromCDN);
        if (!hVar.tw()) {
            if (!hVar.hn().vW) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                t.a(hC, str, false, str3, isFromCDN, Boolean.valueOf(z), hVar.WD, "NetworkError", hC.im(), hVar.ty(), j);
            }
            return null;
        } else if (l == null) {
            t.a(hC, str, false, str3, isFromCDN, Boolean.valueOf(z), hVar.WD, "ByteIsNull", hC.im(), hVar.ty(), 0L);
            return null;
        } else {
            if (l.length > 1) {
                i.tB().c(l.length, hC.im());
                t.a(hC, str, true, str3, isFromCDN, Boolean.valueOf(z), hVar.WD, "", hC.im(), hVar.ty(), l.length);
            } else {
                t.a(hC, str, false, str3, isFromCDN, Boolean.valueOf(z), hVar.WD, "bytes<1", hC.im(), hVar.ty(), l.length);
            }
            com.baidu.adp.lib.stats.q hC2 = t.hC();
            hC2.il();
            com.baidu.tbadk.imageManager.e.zy().dE(TbConfig.getPbImageSize() + l.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(l, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(hVar.Wz, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkCoreApplication.m411getInst().incWebpFailureCount();
                byte[] l2 = hVar.l(d, !isFromCDN);
                hC2.il();
                if (l2 == null || !hVar.tw()) {
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
                    t.a(hC2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", hC2.im(), sb.toString());
                } else {
                    t.a(hC2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", hC2.im(), sb.toString());
                }
                return null;
            }
            boolean z3 = hVar.Gm || com.baidu.adp.lib.util.n.n(bArr);
            Bitmap b2 = b(bitmap, dip2px, dip2px2);
            if (b2 == null) {
                t.a(hC2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", hC2.im(), sb.toString());
                return null;
            }
            t.a(hC2, str, str3, true, isFromCDN, z2, bArr.length, "", hC2.im(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, b2, z3, hVar, bArr, rect);
            if (a != null) {
                a.Gw.Gy = "net";
                a.Gw.Gz = hC.im();
                a.Gw.GA = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.h hVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!hVar.WF) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bf.cN(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.fk().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(cVar);
                    aVar.wt = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.g
    public boolean hE() {
        return com.baidu.tbadk.core.n.px().pB();
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.zy().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(bd.aM(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + be.sY().td());
            sb.append("&first_gif=1");
            if (tz()) {
                sb.append("&ispv=1");
            }
            if (tA()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c cW(String str) {
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
            return new com.baidu.adp.widget.a.a(bitmap, cVar.fI(), str);
        }
        return null;
    }

    protected Bitmap b(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.c.a(bArr, sb);
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
            com.baidu.tbadk.imageManager.e.zy().dE(com.baidu.tbadk.core.util.c.d(bitmap) * 2);
            return com.baidu.tbadk.core.util.c.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel hF() {
        return i.tB().hF();
    }

    @Override // com.baidu.adp.lib.f.g
    public int hG() {
        return 1;
    }
}
