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
    public abstract boolean Ak();

    public abstract boolean Al();

    public abstract int Am();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a hi = com.baidu.tbadk.imageManager.c.IV().hi(str);
        if (hi != null) {
            hi.KN.KP = "memory";
            hi.KN.KQ = 0L;
            hi.KN.KR = true;
        }
        return hi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a ih = com.baidu.tbadk.core.util.t.ih();
        ih.iq();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fe = fe(as.eO(str2));
        if (fe == null) {
            return null;
        }
        fe.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fe.y(false);
        fe.w(true);
        fe.z(true);
        fe.x(false);
        fe.m(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fe);
            aVar.As = eVar;
        }
        boolean jE = com.baidu.adp.lib.util.j.jE();
        if (!com.baidu.adp.lib.Disk.d.gf().c(fe)) {
            com.baidu.tbadk.core.util.t.a(ih, str2, false, ih.ir(), jE);
            return null;
        }
        int i = 2000;
        if (jE) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = fe.isSuccess() ? a(fe, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.t.a(ih, str2, true, ih.ir(), jE);
        } else {
            com.baidu.tbadk.core.util.t.a(ih, str2, false, ih.ir(), jE);
        }
        if (a != null) {
            a.KN.KP = "disk";
            a.KN.KQ = ih.ir();
            a.KN.KR = true;
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
        com.baidu.adp.lib.stats.a ih = com.baidu.tbadk.core.util.t.ih();
        ih.iq();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String j = isFromCDN ? str : j(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hv().aw("webp_enable") == 1) || j.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = j.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = j;
        } else {
            str3 = j.substring(0, lastIndexOf) + ".webp" + j.substring(lastIndexOf + 4, j.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.As = iVar;
        }
        byte[] j2 = iVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.Af()) {
            if (iVar.responseCode == 302 && (17 == Am() || 18 == Am() || 13 == Am() || 14 == Am())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] e = com.baidu.adp.lib.network.a.b.e(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(e, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.m(e), iVar, e, rect);
                    if (a != null) {
                        a.KN.KP = "net";
                        a.KN.KQ = ih.ir();
                        a.KN.KR = true;
                    }
                    com.baidu.adp.lib.g.a.f(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.hW().zY) {
                long j3 = 0;
                if (j2 != null) {
                    j3 = j2.length;
                }
                com.baidu.tbadk.core.util.t.a(ih, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.asZ, "NetworkError", ih.ir(), iVar.Ai(), j3, Am());
                return null;
            }
        }
        if (j2 == null && !iVar.hW().zY) {
            com.baidu.tbadk.core.util.t.a(ih, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.asZ, "ByteIsNull", ih.ir(), iVar.Ai(), 0L, Am());
            return null;
        }
        if (j2.length > 1) {
            j.Ao().e(j2.length, ih.ir());
            com.baidu.tbadk.core.util.t.a(ih, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.asZ, "InputToByteSucc", ih.ir(), iVar.Ai(), j2.length, Am());
        } else {
            com.baidu.tbadk.core.util.t.a(ih, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.asZ, "bytes<1", ih.ir(), iVar.Ai(), j2.length, Am());
        }
        com.baidu.adp.lib.stats.a ih2 = com.baidu.tbadk.core.util.t.ih();
        ih2.iq();
        com.baidu.tbadk.imageManager.c.IV().fd(TbConfig.getPbImageSize() + j2.length);
        Bitmap a2 = a(j2, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            j2 = iVar.j(j, !isFromCDN);
            ih2.iq();
            if (j2 == null || !iVar.Af()) {
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
                com.baidu.tbadk.core.util.t.a(ih2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", ih2.ir(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.t.a(ih2, str, str3, false, isFromCDN, z2, j2.length, "ConvertError", ih2.ir(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.m(j2);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            com.baidu.tbadk.core.util.t.a(ih2, str, str3, false, isFromCDN, z2, j2.length, "ResizeError", ih2.ir(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.t.a(ih2, str, str3, true, isFromCDN, z2, j2.length, "", ih2.ir(), sb.toString());
        com.baidu.adp.widget.ImageView.a a4 = a(str, str2, aVar, null, a3, z3, iVar, j2, rect);
        if (a4 != null) {
            a4.KN.KP = "net";
            a4.KN.KQ = ih.ir();
            a4.KN.KR = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (e(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.ate) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eO(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.w(true);
                cVar.setData(bArr);
                cVar.y(false);
                cVar.z(true);
                cVar.A(z);
                com.baidu.adp.lib.Disk.d.gf().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.As = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean ij() {
        return com.baidu.tbadk.core.i.tt().tz();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.IV().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    protected String j(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ap.bg(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + ar.zF().zK());
            sb.append("&first_gif=1");
            if (Ak()) {
                sb.append("&ispv=1");
            }
            if (Al()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c fe(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.k(cVar.getData());
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

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.IV().fd(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel ik() {
        return j.Ao().ik();
    }

    @Override // com.baidu.adp.lib.f.e
    public int il() {
        return 1;
    }

    public static boolean v(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eO(com.baidu.adp.lib.f.c.ig().f(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.w(true);
        cVar.x(false);
        cVar.y(false);
        cVar.z(true);
        return cVar.gg();
    }

    public static com.baidu.adp.widget.ImageView.a w(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String f = com.baidu.adp.lib.f.c.ig().f(str, i);
        String eO = as.eO(f);
        if (i == 38) {
            return k.a(eO, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal");
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, eO, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.w(true);
            cVar.x(false);
            cVar.z(true);
            cVar.y(false);
            if (com.baidu.adp.lib.Disk.d.gf().b(cVar) && cVar.isSuccess()) {
                cVar.k(cVar.getData());
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
