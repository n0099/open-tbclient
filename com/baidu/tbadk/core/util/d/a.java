package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean wv();

    public abstract boolean ww();

    public abstract int wx();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a gG = com.baidu.tbadk.imageManager.c.Fa().gG(str);
        if (gG != null) {
            gG.EF.EH = "memory";
            gG.EF.EI = 0L;
            gG.EF.EJ = true;
        }
        return gG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fq = com.baidu.tbadk.core.util.s.fq();
        fq.fA();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c eC = eC(aq.em(str2));
        if (eC == null) {
            return null;
        }
        eC.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        eC.w(false);
        eC.u(true);
        eC.x(true);
        eC.v(false);
        eC.j((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(eC);
            aVar.uq = dVar;
        }
        boolean gQ = com.baidu.adp.lib.util.j.gQ();
        if (!com.baidu.adp.lib.Disk.d.dp().c(eC)) {
            com.baidu.tbadk.core.util.s.a(fq, str2, false, fq.fB(), gQ);
            return null;
        }
        int i = 2000;
        if (gQ) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = eC.isSuccess() ? a(eC, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(fq, str2, true, fq.fB(), gQ);
        } else {
            com.baidu.tbadk.core.util.s.a(fq, str2, false, fq.fB(), gQ);
        }
        if (a != null) {
            a.EF.EH = "disk";
            a.EF.EI = fq.fB();
            a.EF.EJ = true;
            return a;
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        boolean z2;
        Bitmap bitmap;
        StringBuilder sb;
        int lastIndexOf;
        if (StringUtils.isNull(str)) {
            return null;
        }
        com.baidu.adp.lib.stats.a fq = com.baidu.tbadk.core.util.s.fq();
        fq.fA();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String j = isFromCDN ? str : j(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.eE().ak("webp_enable") == 1) || j.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = j.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = j;
        } else {
            str3 = j.substring(0, lastIndexOf) + ".webp" + j.substring(lastIndexOf + 4, j.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.uq = iVar;
        }
        byte[] j2 = iVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.wq()) {
            if (iVar.responseCode == 302 && (17 == wx() || 18 == wx() || 13 == wx() || 14 == wx())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] c = com.baidu.adp.lib.network.a.b.c(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(c, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.l(c), iVar, c, rect);
                    if (a != null) {
                        a.EF.EH = "net";
                        a.EF.EI = fq.fB();
                        a.EF.EJ = true;
                    }
                    com.baidu.adp.lib.g.a.d(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.ff().tW) {
                long j3 = 0;
                if (j2 != null) {
                    j3 = j2.length;
                }
                com.baidu.tbadk.core.util.s.a(fq, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ako, "NetworkError", fq.fB(), iVar.wt(), j3, wx());
                return null;
            }
        }
        if (j2 == null && !iVar.ff().tW) {
            com.baidu.tbadk.core.util.s.a(fq, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ako, "ByteIsNull", fq.fB(), iVar.wt(), 0L, wx());
            return null;
        }
        if (j2.length > 1) {
            i.wz().e(j2.length, fq.fB());
            com.baidu.tbadk.core.util.s.a(fq, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.ako, "InputToByteSucc", fq.fB(), iVar.wt(), j2.length, wx());
        } else {
            com.baidu.tbadk.core.util.s.a(fq, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ako, "bytes<1", fq.fB(), iVar.wt(), j2.length, wx());
        }
        com.baidu.adp.lib.stats.a fq2 = com.baidu.tbadk.core.util.s.fq();
        fq2.fA();
        com.baidu.tbadk.imageManager.c.Fa().eX(TbConfig.getPbImageSize() + j2.length);
        Bitmap a2 = a(j2, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            j2 = iVar.j(j, !isFromCDN);
            fq2.fA();
            if (j2 == null || !iVar.wq()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(j2, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (j2 == null || bitmap == null) {
            if (j2 == null) {
                com.baidu.tbadk.core.util.s.a(fq2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fq2.fB(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(fq2, str, str3, false, isFromCDN, z2, j2.length, "ConvertError", fq2.fB(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.l(j2);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            com.baidu.tbadk.core.util.s.a(fq2, str, str3, false, isFromCDN, z2, j2.length, "ResizeError", fq2.fB(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(fq2, str, str3, true, isFromCDN, z2, j2.length, "", fq2.fB(), sb.toString());
        com.baidu.adp.widget.ImageView.a a4 = a(str, str2, aVar, null, a3, z3, iVar, j2, rect);
        if (a4 != null) {
            a4.EF.EH = "net";
            a4.EF.EI = fq.fB();
            a4.EF.EJ = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.akt) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aq.em(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.u(true);
                cVar.setData(bArr);
                cVar.w(false);
                cVar.x(true);
                cVar.y(z);
                com.baidu.adp.lib.Disk.d.dp().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.uq = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean ft() {
        return com.baidu.tbadk.core.i.pY().qe();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.Fa().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    protected String j(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(an.aS(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ap.vQ().vV());
            sb.append("&first_gif=1");
            if (wv()) {
                sb.append("&ispv=1");
            }
            if (ww()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c eC(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.j(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.Bytes2Bitmap(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Fa().eX(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fu() {
        return i.wz().fu();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fv() {
        return 1;
    }

    public static boolean v(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aq.em(com.baidu.adp.lib.f.c.fp().f(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.u(true);
        cVar.v(false);
        cVar.w(false);
        cVar.x(true);
        return cVar.dq();
    }

    public static com.baidu.adp.widget.ImageView.a w(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String f = com.baidu.adp.lib.f.c.fp().f(str, i);
        String em = aq.em(f);
        if (i == 38) {
            return j.a(em, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal");
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, em, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.u(true);
            cVar.v(false);
            cVar.x(true);
            cVar.w(false);
            if (com.baidu.adp.lib.Disk.d.dp().b(cVar) && cVar.isSuccess()) {
                cVar.j(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), f);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
