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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.t;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.g.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean uI();

    public abstract boolean uJ();

    public abstract int uK();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: d */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fM = com.baidu.tbadk.imageManager.c.CI().fM(str);
        if (fM != null) {
            fM.xH.xJ = "memory";
            fM.xH.xK = 0L;
            fM.xH.xL = true;
        }
        return fM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d dG = v.dG();
        dG.ed();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dL = dL(ba.dy(str2));
        if (dL == null) {
            return null;
        }
        dL.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dL.n(true);
        dL.o(false);
        dL.h((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dL);
            aVar.lU = dVar;
        }
        boolean fr = com.baidu.adp.lib.util.i.fr();
        if (!com.baidu.adp.lib.Disk.d.bG().c(dL)) {
            v.a(dG, str2, false, dG.ee(), fr);
            return null;
        }
        int i = 2000;
        if (fr) {
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
            v.a(dG, str2, true, dG.ee(), fr);
        } else {
            v.a(dG, str2, false, dG.ee(), fr);
        }
        if (a != null) {
            a.xH.xJ = "disk";
            a.xH.xK = dG.ee();
            a.xH.xL = true;
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
        com.baidu.adp.lib.stats.d dG = v.dG();
        dG.ed();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m11getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.m11getInst().getCapabilityOfWebp() && com.baidu.adp.lib.c.e.cS().Z("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.lU = kVar;
        }
        byte[] l = kVar.l(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!kVar.uE()) {
            if (kVar.responseCode == 302 && (17 == uK() || 18 == uK() || 13 == uK() || 14 == uK())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m11getInst().getResources().openRawResource(t.f.img_default_delete, new TypedValue());
                    byte[] b = com.baidu.adp.lib.network.a.b.b(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(b, rect, sb2), kVar.xv || com.baidu.adp.lib.util.k.j(b), kVar, b, rect);
                    if (a != null) {
                        a.xH.xJ = "net";
                        a.xH.xK = dG.ee();
                        a.xH.xL = true;
                    }
                    com.baidu.adp.lib.h.a.c(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!kVar.dv().lD) {
                long j = 0;
                if (l != null) {
                    j = l.length;
                }
                v.a(dG, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.Zm, "NetworkError", dG.ee(), kVar.uH(), j, uK());
                return null;
            }
        }
        if (l == null) {
            v.a(dG, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.Zm, "ByteIsNull", dG.ee(), kVar.uH(), 0L, uK());
            return null;
        }
        if (l.length > 1) {
            h.uL().b(l.length, dG.ee());
            v.a(dG, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.Zm, "InputToByteSucc", dG.ee(), kVar.uH(), l.length, uK());
        } else {
            v.a(dG, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.Zm, "bytes<1", dG.ee(), kVar.uH(), l.length, uK());
        }
        com.baidu.adp.lib.stats.d dG2 = v.dG();
        dG2.ed();
        com.baidu.tbadk.imageManager.c.CI().ey(TbConfig.getPbImageSize() + l.length);
        Bitmap a2 = a(l, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m11getInst().incWebpFailureCount();
            l = kVar.l(c, !isFromCDN);
            dG2.ed();
            if (l == null || !kVar.uE()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(l, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (l == null || bitmap == null) {
            if (l == null) {
                v.a(dG2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", dG2.ee(), sb.toString());
            } else {
                v.a(dG2, str, str3, false, isFromCDN, z2, l.length, "ConvertError", dG2.ee(), sb.toString());
            }
            return null;
        }
        boolean z3 = kVar.xv || com.baidu.adp.lib.util.k.j(l);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            v.a(dG2, str, str3, false, isFromCDN, z2, l.length, "ResizeError", dG2.ee(), sb.toString());
            return null;
        }
        v.a(dG2, str, str3, true, isFromCDN, z2, l.length, "", dG2.ee(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, kVar, l, rect);
        if (a4 != null) {
            a4.xH.xJ = "net";
            a4.xH.xK = dG.ee();
            a4.xH.xL = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.Zr) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.dy(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.n(true);
                cVar.setData(bArr);
                cVar.q(z);
                com.baidu.adp.lib.Disk.d.bG().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.lU = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.g.e
    public boolean dI() {
        return com.baidu.tbadk.core.l.ob().oh();
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.CI().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ay.aN(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + az.ug().ul());
            sb.append("&first_gif=1");
            if (uI()) {
                sb.append("&ispv=1");
            }
            if (uJ()) {
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
        cVar.h(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, cVar.cd(), str);
        }
        return null;
    }

    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.Bytes2Bitmap(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.CI().ey(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel dJ() {
        return h.uL().dJ();
    }

    @Override // com.baidu.adp.lib.g.e
    public int dK() {
        return 1;
    }
}
