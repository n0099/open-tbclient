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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.w;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean wf();

    public abstract boolean wg();

    public abstract int wh();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fI = com.baidu.tbadk.imageManager.c.El().fI(str);
        if (fI != null) {
            fI.HA.HC = "memory";
            fI.HA.HD = 0L;
            fI.HA.HE = true;
        }
        return fI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.c fH = u.fH();
        fH.fQ();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dK = dK(aw.dx(str2));
        if (dK == null) {
            return null;
        }
        dK.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dK.s(true);
        dK.t(false);
        dK.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dK);
            aVar.wz = dVar;
        }
        boolean hf = com.baidu.adp.lib.util.i.hf();
        if (!com.baidu.adp.lib.Disk.d.dI().c(dK)) {
            u.a(fH, str2, false, fH.fR(), hf);
            return null;
        }
        int i = 2000;
        if (hf) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dK.isSuccess() ? a(dK, str2) : null;
        if (a != null) {
            u.a(fH, str2, true, fH.fR(), hf);
        } else {
            u.a(fH, str2, false, fH.fR(), hf);
        }
        if (a != null) {
            a.HA.HC = "disk";
            a.HA.HD = fH.fR();
            a.HA.HE = true;
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
        com.baidu.adp.lib.stats.c fH = u.fH();
        fH.fQ();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.eT().ab("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.wz = kVar;
        }
        byte[] m = kVar.m(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!kVar.wb()) {
            if (kVar.responseCode == 302 && (17 == wh() || 18 == wh() || 13 == wh() || 14 == wh())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(w.g.img_default_delete, new TypedValue());
                    byte[] i3 = com.baidu.adp.lib.network.a.b.i(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(i3, rect, sb2), kVar.Ho || com.baidu.adp.lib.util.k.m(i3), kVar, i3, rect);
                    if (a != null) {
                        a.HA.HC = "net";
                        a.HA.HD = fH.fR();
                        a.HA.HE = true;
                    }
                    com.baidu.adp.lib.g.a.j(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!kVar.fw().wi) {
                long j = 0;
                if (m != null) {
                    j = m.length;
                }
                u.a(fH, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahF, "NetworkError", fH.fR(), kVar.we(), j, wh());
                return null;
            }
        }
        if (m == null && !kVar.fw().wi) {
            u.a(fH, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahF, "ByteIsNull", fH.fR(), kVar.we(), 0L, wh());
            return null;
        }
        if (m.length > 1) {
            h.wi().b(m.length, fH.fR());
            u.a(fH, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.ahF, "InputToByteSucc", fH.fR(), kVar.we(), m.length, wh());
        } else {
            u.a(fH, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahF, "bytes<1", fH.fR(), kVar.we(), m.length, wh());
        }
        com.baidu.adp.lib.stats.c fH2 = u.fH();
        fH2.fQ();
        com.baidu.tbadk.imageManager.c.El().eQ(TbConfig.getPbImageSize() + m.length);
        Bitmap a2 = a(m, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m9getInst().incWebpFailureCount();
            m = kVar.m(c, !isFromCDN);
            fH2.fQ();
            if (m == null || !kVar.wb()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(m, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (m == null || bitmap == null) {
            if (m == null) {
                u.a(fH2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fH2.fR(), sb.toString());
            } else {
                u.a(fH2, str, str3, false, isFromCDN, z2, m.length, "ConvertError", fH2.fR(), sb.toString());
            }
            return null;
        }
        boolean z3 = kVar.Ho || com.baidu.adp.lib.util.k.m(m);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            u.a(fH2, str, str3, false, isFromCDN, z2, m.length, "ResizeError", fH2.fR(), sb.toString());
            return null;
        }
        u.a(fH2, str, str3, true, isFromCDN, z2, m.length, "", fH2.fR(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, kVar, m, rect);
        if (a4 != null) {
            a4.HA.HC = "net";
            a4.HA.HD = fH.fR();
            a4.HA.HE = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.ahK) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dx(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(true);
                cVar.setData(bArr);
                cVar.v(z);
                com.baidu.adp.lib.Disk.d.dI().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.wz = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fJ() {
        return com.baidu.tbadk.core.l.oQ().oW();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.El().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(au.aI(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + av.vD().vI());
            sb.append("&first_gif=1");
            if (wf()) {
                sb.append("&ispv=1");
            }
            if (wg()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dK(String str) {
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
            return new com.baidu.adp.widget.a.a(bitmap, cVar.ef(), str);
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
            com.baidu.tbadk.imageManager.c.El().eQ(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fK() {
        return h.wi().fK();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fL() {
        return 1;
    }
}
