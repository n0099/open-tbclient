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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.w;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean we();

    public abstract boolean wf();

    public abstract int wg();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a ge = com.baidu.tbadk.imageManager.c.Eb().ge(str);
        if (ge != null) {
            ge.Hc.He = "memory";
            ge.Hc.Hf = 0L;
            ge.Hc.Hg = true;
        }
        return ge;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.c fM = w.fM();
        fM.fV();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c eg = eg(ay.dS(str2));
        if (eg == null) {
            return null;
        }
        eg.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        eg.s(true);
        eg.t(false);
        eg.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(eg);
            aVar.wg = dVar;
        }
        boolean hk = com.baidu.adp.lib.util.i.hk();
        if (!com.baidu.adp.lib.Disk.d.dI().c(eg)) {
            w.a(fM, str2, false, fM.fW(), hk);
            return null;
        }
        int i = 2000;
        if (hk) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = eg.isSuccess() ? a(eg, str2) : null;
        if (a != null) {
            w.a(fM, str2, true, fM.fW(), hk);
        } else {
            w.a(fM, str2, false, fM.fW(), hk);
        }
        if (a != null) {
            a.Hc.He = "disk";
            a.Hc.Hf = fM.fW();
            a.Hc.Hg = true;
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
        com.baidu.adp.lib.stats.c fM = w.fM();
        fM.fV();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.eY().ad("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.wg = kVar;
        }
        byte[] k = kVar.k(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!kVar.wa()) {
            if (kVar.responseCode == 302 && (17 == wg() || 18 == wg() || 13 == wg() || 14 == wg())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(w.g.img_default_delete, new TypedValue());
                    byte[] i3 = com.baidu.adp.lib.network.a.b.i(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(i3, rect, sb2), kVar.isGif || com.baidu.adp.lib.util.k.m(i3), kVar, i3, rect);
                    if (a != null) {
                        a.Hc.He = "net";
                        a.Hc.Hf = fM.fW();
                        a.Hc.Hg = true;
                    }
                    com.baidu.adp.lib.g.a.j(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!kVar.fB().vP) {
                long j = 0;
                if (k != null) {
                    j = k.length;
                }
                com.baidu.tbadk.core.util.w.a(fM, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahL, "NetworkError", fM.fW(), kVar.wd(), j, wg());
                return null;
            }
        }
        if (k == null && !kVar.fB().vP) {
            com.baidu.tbadk.core.util.w.a(fM, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahL, "ByteIsNull", fM.fW(), kVar.wd(), 0L, wg());
            return null;
        }
        if (k.length > 1) {
            h.wh().b(k.length, fM.fW());
            com.baidu.tbadk.core.util.w.a(fM, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.ahL, "InputToByteSucc", fM.fW(), kVar.wd(), k.length, wg());
        } else {
            com.baidu.tbadk.core.util.w.a(fM, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.ahL, "bytes<1", fM.fW(), kVar.wd(), k.length, wg());
        }
        com.baidu.adp.lib.stats.c fM2 = com.baidu.tbadk.core.util.w.fM();
        fM2.fV();
        com.baidu.tbadk.imageManager.c.Eb().eS(TbConfig.getPbImageSize() + k.length);
        Bitmap a2 = a(k, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m9getInst().incWebpFailureCount();
            k = kVar.k(c, !isFromCDN);
            fM2.fV();
            if (k == null || !kVar.wa()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(k, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (k == null || bitmap == null) {
            if (k == null) {
                com.baidu.tbadk.core.util.w.a(fM2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fM2.fW(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.w.a(fM2, str, str3, false, isFromCDN, z2, k.length, "ConvertError", fM2.fW(), sb.toString());
            }
            return null;
        }
        boolean z3 = kVar.isGif || com.baidu.adp.lib.util.k.m(k);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            com.baidu.tbadk.core.util.w.a(fM2, str, str3, false, isFromCDN, z2, k.length, "ResizeError", fM2.fW(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.w.a(fM2, str, str3, true, isFromCDN, z2, k.length, "", fM2.fW(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, kVar, k, rect);
        if (a4 != null) {
            a4.Hc.He = "net";
            a4.Hc.Hf = fM.fW();
            a4.Hc.Hg = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.ahQ) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ay.dS(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.s(true);
                cVar.setData(bArr);
                cVar.v(z);
                com.baidu.adp.lib.Disk.d.dI().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.wg = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fO() {
        return r.oK().oQ();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Eb().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(aw.aI(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ax.vA().vF());
            sb.append("&first_gif=1");
            if (we()) {
                sb.append("&ispv=1");
            }
            if (wf()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c eg(String str) {
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
            return new com.baidu.adp.widget.a.a(bitmap, cVar.isGif(), str);
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
            com.baidu.tbadk.imageManager.c.Eb().eS(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fP() {
        return h.wh().fP();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fQ() {
        return 1;
    }
}
