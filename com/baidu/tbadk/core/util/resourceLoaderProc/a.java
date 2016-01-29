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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.t;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.g.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean wI();

    public abstract boolean wJ();

    public abstract int wK();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fH = com.baidu.tbadk.imageManager.c.Ed().fH(str);
        if (fH != null) {
            fH.Hj.Hl = "memory";
            fH.Hj.Hm = 0L;
            fH.Hj.Hn = true;
        }
        return fH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d hm = u.hm();
        hm.hJ();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dJ = dJ(ay.dy(str2));
        if (dJ == null) {
            return null;
        }
        dJ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dJ.o(true);
        dJ.p(false);
        dJ.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dJ);
            aVar.vK = dVar;
        }
        boolean ja = com.baidu.adp.lib.util.i.ja();
        if (!com.baidu.adp.lib.Disk.d.fr().c(dJ)) {
            u.a(hm, str2, false, hm.hK(), ja);
            return null;
        }
        int i = 2000;
        if (ja) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dJ.isSuccess() ? a(dJ, str2) : null;
        if (a != null) {
            u.a(hm, str2, true, hm.hK(), ja);
        } else {
            u.a(hm, str2, false, hm.hK(), ja);
        }
        if (a != null) {
            a.Hj.Hl = "disk";
            a.Hj.Hm = hm.hK();
            a.Hj.Hn = true;
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
        com.baidu.adp.lib.stats.d hm = u.hm();
        hm.hJ();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m411getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.c.e.gE().ai("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.vK = kVar;
        }
        byte[] m = kVar.m(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!kVar.wF()) {
            if (kVar.responseCode == 302 && (17 == wK() || 18 == wK() || 13 == wK() || 14 == wK())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m411getInst().getResources().openRawResource(t.f.img_default_delete, new TypedValue());
                    byte[] d = com.baidu.adp.lib.network.a.b.d(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(d, rect, sb2), kVar.GY || com.baidu.adp.lib.util.k.z(d), kVar, d, rect);
                    if (a != null) {
                        a.Hj.Hl = "net";
                        a.Hj.Hm = hm.hK();
                        a.Hj.Hn = true;
                    }
                    com.baidu.adp.lib.h.a.e(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!kVar.hb().vu) {
                long j = 0;
                if (m != null) {
                    j = m.length;
                }
                u.a(hm, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.aey, "NetworkError", hm.hK(), kVar.wH(), j, wK());
                return null;
            }
        }
        if (m == null) {
            u.a(hm, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.aey, "ByteIsNull", hm.hK(), kVar.wH(), 0L, wK());
            return null;
        }
        if (m.length > 1) {
            h.wL().b(m.length, hm.hK());
            u.a(hm, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.aey, "InputToByteSucc", hm.hK(), kVar.wH(), m.length, wK());
        } else {
            u.a(hm, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.aey, "bytes<1", hm.hK(), kVar.wH(), m.length, wK());
        }
        com.baidu.adp.lib.stats.d hm2 = u.hm();
        hm2.hJ();
        com.baidu.tbadk.imageManager.c.Ed().eN(TbConfig.getPbImageSize() + m.length);
        Bitmap a2 = a(m, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m411getInst().incWebpFailureCount();
            m = kVar.m(c, !isFromCDN);
            hm2.hJ();
            if (m == null || !kVar.wF()) {
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
                u.a(hm2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", hm2.hK(), sb.toString());
            } else {
                u.a(hm2, str, str3, false, isFromCDN, z2, m.length, "ConvertError", hm2.hK(), sb.toString());
            }
            return null;
        }
        boolean z3 = kVar.GY || com.baidu.adp.lib.util.k.z(m);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            u.a(hm2, str, str3, false, isFromCDN, z2, m.length, "ResizeError", hm2.hK(), sb.toString());
            return null;
        }
        u.a(hm2, str, str3, true, isFromCDN, z2, m.length, "", hm2.hK(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, kVar, m, rect);
        if (a4 != null) {
            a4.Hj.Hl = "net";
            a4.Hj.Hm = hm.hK();
            a4.Hj.Hn = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.aeA) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ay.dy(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.o(true);
                cVar.setData(bArr);
                cVar.r(z);
                com.baidu.adp.lib.Disk.d.fr().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.vK = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.g.e
    public boolean ho() {
        return com.baidu.tbadk.core.l.rn().rt();
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ed().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(aw.aS(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ax.wg().wl());
            sb.append("&first_gif=1");
            if (wI()) {
                sb.append("&ispv=1");
            }
            if (wJ()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dJ(String str) {
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
            return new com.baidu.adp.widget.a.a(bitmap, cVar.fN(), str);
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
            com.baidu.tbadk.imageManager.c.Ed().eN(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hp() {
        return h.wL().hp();
    }

    @Override // com.baidu.adp.lib.g.e
    public int hq() {
        return 1;
    }
}
