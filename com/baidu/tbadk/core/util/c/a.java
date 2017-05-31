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
import com.baidu.tbadk.core.r;
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

    public abstract boolean vN();

    public abstract boolean vO();

    public abstract int vP();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fK = com.baidu.tbadk.imageManager.c.DH().fK(str);
        if (fK != null) {
            fK.Hd.Hf = "memory";
            fK.Hd.Hg = 0L;
            fK.Hd.Hh = true;
        }
        return fK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.c fN = u.fN();
        fN.fW();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dL = dL(aw.dy(str2));
        if (dL == null) {
            return null;
        }
        dL.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dL.s(true);
        dL.t(false);
        dL.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dL);
            aVar.wh = dVar;
        }
        boolean hl = com.baidu.adp.lib.util.i.hl();
        if (!com.baidu.adp.lib.Disk.d.dI().c(dL)) {
            u.a(fN, str2, false, fN.fX(), hl);
            return null;
        }
        int i = 2000;
        if (hl) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dL.isSuccess() ? a(dL, str2) : null;
        if (a != null) {
            u.a(fN, str2, true, fN.fX(), hl);
        } else {
            u.a(fN, str2, false, fN.fX(), hl);
        }
        if (a != null) {
            a.Hd.Hf = "disk";
            a.Hd.Hg = fN.fX();
            a.Hd.Hh = true;
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
        com.baidu.adp.lib.stats.c fN = u.fN();
        fN.fW();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.eZ().Y("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.wh = kVar;
        }
        byte[] j = kVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!kVar.vJ()) {
            if (kVar.responseCode == 302 && (17 == vP() || 18 == vP() || 13 == vP() || 14 == vP())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(w.g.img_default_delete, new TypedValue());
                    byte[] i3 = com.baidu.adp.lib.network.a.b.i(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(i3, rect, sb2), kVar.GS || com.baidu.adp.lib.util.k.m(i3), kVar, i3, rect);
                    if (a != null) {
                        a.Hd.Hf = "net";
                        a.Hd.Hg = fN.fX();
                        a.Hd.Hh = true;
                    }
                    com.baidu.adp.lib.g.a.j(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!kVar.fC().vQ) {
                long j2 = 0;
                if (j != null) {
                    j2 = j.length;
                }
                u.a(fN, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahd, "NetworkError", fN.fX(), kVar.vM(), j2, vP());
                return null;
            }
        }
        if (j == null && !kVar.fC().vQ) {
            u.a(fN, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahd, "ByteIsNull", fN.fX(), kVar.vM(), 0L, vP());
            return null;
        }
        if (j.length > 1) {
            h.vQ().b(j.length, fN.fX());
            u.a(fN, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.ahd, "InputToByteSucc", fN.fX(), kVar.vM(), j.length, vP());
        } else {
            u.a(fN, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahd, "bytes<1", fN.fX(), kVar.vM(), j.length, vP());
        }
        com.baidu.adp.lib.stats.c fN2 = u.fN();
        fN2.fW();
        com.baidu.tbadk.imageManager.c.DH().eQ(TbConfig.getPbImageSize() + j.length);
        Bitmap a2 = a(j, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m9getInst().incWebpFailureCount();
            j = kVar.j(c, !isFromCDN);
            fN2.fW();
            if (j == null || !kVar.vJ()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(j, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (j == null || bitmap == null) {
            if (j == null) {
                u.a(fN2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fN2.fX(), sb.toString());
            } else {
                u.a(fN2, str, str3, false, isFromCDN, z2, j.length, "ConvertError", fN2.fX(), sb.toString());
            }
            return null;
        }
        boolean z3 = kVar.GS || com.baidu.adp.lib.util.k.m(j);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            u.a(fN2, str, str3, false, isFromCDN, z2, j.length, "ResizeError", fN2.fX(), sb.toString());
            return null;
        }
        u.a(fN2, str, str3, true, isFromCDN, z2, j.length, "", fN2.fX(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, kVar, j, rect);
        if (a4 != null) {
            a4.Hd.Hf = "net";
            a4.Hd.Hg = fN.fX();
            a4.Hd.Hh = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.ahi) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dy(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(true);
                cVar.setData(bArr);
                cVar.v(z);
                com.baidu.adp.lib.Disk.d.dI().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.wh = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fP() {
        return r.oN().oT();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.DH().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(au.aD(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + av.vl().vq());
            sb.append("&first_gif=1");
            if (vN()) {
                sb.append("&ispv=1");
            }
            if (vO()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dL(String str) {
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
    public boolean g(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.DH().eQ(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fQ() {
        return h.vQ().fQ();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fR() {
        return 1;
    }
}
