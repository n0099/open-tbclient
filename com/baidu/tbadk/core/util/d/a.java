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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean Aa();

    public abstract boolean Ab();

    public abstract int Ac();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a he = com.baidu.tbadk.imageManager.c.IQ().he(str);
        if (he != null) {
            he.KJ.KL = "memory";
            he.KJ.KM = 0L;
            he.KJ.KN = true;
        }
        return he;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a ii = com.baidu.tbadk.core.util.t.ii();
        ii.ir();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fc = fc(as.eM(str2));
        if (fc == null) {
            return null;
        }
        fc.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fc.w(false);
        fc.u(true);
        fc.x(true);
        fc.v(false);
        fc.m(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fc);
            aVar.An = eVar;
        }
        boolean jF = com.baidu.adp.lib.util.j.jF();
        if (!com.baidu.adp.lib.Disk.d.ge().c(fc)) {
            com.baidu.tbadk.core.util.t.a(ii, str2, false, ii.is(), jF);
            return null;
        }
        int i = 2000;
        if (jF) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = fc.isSuccess() ? a(fc, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.t.a(ii, str2, true, ii.is(), jF);
        } else {
            com.baidu.tbadk.core.util.t.a(ii, str2, false, ii.is(), jF);
        }
        if (a != null) {
            a.KJ.KL = "disk";
            a.KJ.KM = ii.is();
            a.KJ.KN = true;
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
        com.baidu.adp.lib.stats.a ii = com.baidu.tbadk.core.util.t.ii();
        ii.ir();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String j = isFromCDN ? str : j(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hv().ax("webp_enable") == 1) || j.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = j.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = j;
        } else {
            str3 = j.substring(0, lastIndexOf) + ".webp" + j.substring(lastIndexOf + 4, j.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.An = iVar;
        }
        byte[] i3 = iVar.i(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.zU()) {
            if (iVar.responseCode == 302 && (17 == Ac() || 18 == Ac() || 13 == Ac() || 14 == Ac())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] e = com.baidu.adp.lib.network.a.b.e(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(e, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.k(e), iVar, e, rect);
                    if (a != null) {
                        a.KJ.KL = "net";
                        a.KJ.KM = ii.is();
                        a.KJ.KN = true;
                    }
                    com.baidu.adp.lib.g.a.f(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.hX().zT) {
                long j2 = 0;
                if (i3 != null) {
                    j2 = i3.length;
                }
                com.baidu.tbadk.core.util.t.a(ii, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.asC, "NetworkError", ii.is(), iVar.zX(), j2, Ac());
                return null;
            }
        }
        if (i3 == null && !iVar.hX().zT) {
            com.baidu.tbadk.core.util.t.a(ii, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.asC, "ByteIsNull", ii.is(), iVar.zX(), 0L, Ac());
            return null;
        }
        if (i3.length > 1) {
            j.Ae().e(i3.length, ii.is());
            com.baidu.tbadk.core.util.t.a(ii, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.asC, "InputToByteSucc", ii.is(), iVar.zX(), i3.length, Ac());
        } else {
            com.baidu.tbadk.core.util.t.a(ii, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.asC, "bytes<1", ii.is(), iVar.zX(), i3.length, Ac());
        }
        com.baidu.adp.lib.stats.a ii2 = com.baidu.tbadk.core.util.t.ii();
        ii2.ir();
        com.baidu.tbadk.imageManager.c.IQ().fe(TbConfig.getPbImageSize() + i3.length);
        Bitmap a2 = a(i3, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            i3 = iVar.i(j, !isFromCDN);
            ii2.ir();
            if (i3 == null || !iVar.zU()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(i3, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (i3 == null || bitmap == null) {
            if (i3 == null) {
                com.baidu.tbadk.core.util.t.a(ii2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", ii2.is(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.t.a(ii2, str, str3, false, isFromCDN, z2, i3.length, "ConvertError", ii2.is(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.k(i3);
        Bitmap b = b(bitmap, dip2px, height);
        if (b == null) {
            com.baidu.tbadk.core.util.t.a(ii2, str, str3, false, isFromCDN, z2, i3.length, "ResizeError", ii2.is(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.t.a(ii2, str, str3, true, isFromCDN, z2, i3.length, "", ii2.is(), sb.toString());
        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, b, z3, iVar, i3, rect);
        if (a3 != null) {
            a3.KJ.KL = "net";
            a3.KJ.KM = ii.is();
            a3.KJ.KN = true;
            return a3;
        }
        return a3;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (e(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.asH) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eM(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.u(true);
                cVar.setData(bArr);
                cVar.w(false);
                cVar.x(true);
                cVar.y(z);
                com.baidu.adp.lib.Disk.d.ge().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.An = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean ik() {
        return com.baidu.tbadk.core.i.te().tk();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.IQ().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    protected String j(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ap.bh(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.zw().zB());
            sb.append("&first_gif=1");
            if (Aa()) {
                sb.append("&ispv=1");
            }
            if (Ab()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c fc(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.i(cVar.getData());
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
    public boolean e(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IQ().fe(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel il() {
        return j.Ae().il();
    }

    @Override // com.baidu.adp.lib.f.e
    public int im() {
        return 1;
    }

    public static boolean v(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eM(com.baidu.adp.lib.f.c.ih().f(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.u(true);
        cVar.v(false);
        cVar.w(false);
        cVar.x(true);
        return cVar.gf();
    }

    public static com.baidu.adp.widget.ImageView.a w(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String f = com.baidu.adp.lib.f.c.ih().f(str, i);
        String eM = as.eM(f);
        if (i == 38) {
            return k.a(eM, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal");
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, eM, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.u(true);
            cVar.v(false);
            cVar.x(true);
            cVar.w(false);
            if (com.baidu.adp.lib.Disk.d.ge().b(cVar) && cVar.isSuccess()) {
                cVar.i(cVar.getData());
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
