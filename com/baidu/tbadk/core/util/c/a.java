package com.baidu.tbadk.core.util.c;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract boolean Dn();

    public abstract boolean Do();

    public abstract int Dp();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gy = com.baidu.tbadk.imageManager.c.LP().gy(str);
        if (gy != null) {
            gy.aum.auo = "memory";
            gy.aum.aup = 0L;
            gy.aum.auq = true;
        }
        return gy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a nm = com.baidu.tbadk.core.util.s.nm();
        nm.nv();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c er = er(ao.ee(str2));
        if (er == null) {
            return null;
        }
        er.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        er.Z(true);
        er.aa(false);
        er.ao(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(er);
            aVar.ajQ = dVar;
        }
        boolean oJ = com.baidu.adp.lib.util.j.oJ();
        if (!com.baidu.adp.lib.Disk.d.ll().c(er)) {
            com.baidu.tbadk.core.util.s.a(nm, str2, false, nm.nw(), oJ);
            return null;
        }
        int i = 2000;
        if (oJ) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = er.isSuccess() ? a(er, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(nm, str2, true, nm.nw(), oJ);
        } else {
            com.baidu.tbadk.core.util.s.a(nm, str2, false, nm.nw(), oJ);
        }
        if (a != null) {
            a.aum.auo = "disk";
            a.aum.aup = nm.nw();
            a.aum.auq = true;
            return a;
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
        com.baidu.adp.lib.stats.a nm = com.baidu.tbadk.core.util.s.nm();
        nm.nv();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String i3 = isFromCDN ? str : i(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.mz().an("webp_enable") == 1) || i3.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = i3.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = i3;
        } else {
            str3 = i3.substring(0, lastIndexOf) + ".webp" + i3.substring(lastIndexOf + 4, i3.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.ajQ = iVar;
        }
        byte[] j = iVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.Dj()) {
            if (iVar.responseCode == 302 && (17 == Dp() || 18 == Dp() || 13 == Dp() || 14 == Dp())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] c = com.baidu.adp.lib.network.a.b.c(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(c, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.j(c), iVar, c, rect);
                    if (a != null) {
                        a.aum.auo = "net";
                        a.aum.aup = nm.nw();
                        a.aum.auq = true;
                    }
                    com.baidu.adp.lib.g.a.d(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.nb().ajz) {
                long j2 = 0;
                if (j != null) {
                    j2 = j.length;
                }
                com.baidu.tbadk.core.util.s.a(nm, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aXj, "NetworkError", nm.nw(), iVar.Dm(), j2, Dp());
                return null;
            }
        }
        if (j == null && !iVar.nb().ajz) {
            com.baidu.tbadk.core.util.s.a(nm, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aXj, "ByteIsNull", nm.nw(), iVar.Dm(), 0L, Dp());
            return null;
        }
        if (j.length > 1) {
            i.Dr().c(j.length, nm.nw());
            com.baidu.tbadk.core.util.s.a(nm, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.aXj, "InputToByteSucc", nm.nw(), iVar.Dm(), j.length, Dp());
        } else {
            com.baidu.tbadk.core.util.s.a(nm, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aXj, "bytes<1", nm.nw(), iVar.Dm(), j.length, Dp());
        }
        com.baidu.adp.lib.stats.a nm2 = com.baidu.tbadk.core.util.s.nm();
        nm2.nv();
        com.baidu.tbadk.imageManager.c.LP().ia(TbConfig.getPbImageSize() + j.length);
        Bitmap a2 = a(j, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            j = iVar.j(i3, !isFromCDN);
            nm2.nv();
            if (j == null || !iVar.Dj()) {
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
                com.baidu.tbadk.core.util.s.a(nm2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", nm2.nw(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(nm2, str, str3, false, isFromCDN, z2, j.length, "ConvertError", nm2.nw(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.j(j);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            com.baidu.tbadk.core.util.s.a(nm2, str, str3, false, isFromCDN, z2, j.length, "ResizeError", nm2.nw(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(nm2, str, str3, true, isFromCDN, z2, j.length, "", nm2.nw(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, iVar, j, rect);
        if (a4 != null) {
            a4.aum.auo = "net";
            a4.aum.aup = nm.nw();
            a4.aum.auq = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.aXo) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.ee(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.Z(true);
                cVar.setData(bArr);
                cVar.ac(z);
                com.baidu.adp.lib.Disk.d.ll().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.ajQ = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean no() {
        return com.baidu.tbadk.core.i.wA().wG();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.LP().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String i(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(am.aV(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + an.CJ().CO());
            sb.append("&first_gif=1");
            if (Dn()) {
                sb.append("&ispv=1");
            }
            if (Do()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c er(String str) {
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
            com.baidu.tbadk.imageManager.c.LP().ia(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel np() {
        return i.Dr().np();
    }

    @Override // com.baidu.adp.lib.f.e
    public int nq() {
        return 1;
    }

    public static boolean v(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.ee(com.baidu.adp.lib.f.c.nl().g(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.Z(true);
        cVar.aa(false);
        return cVar.lm();
    }

    public static com.baidu.adp.widget.a.a w(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String g = com.baidu.adp.lib.f.c.nl().g(str, i);
        String ee = ao.ee(g);
        if (i == 38) {
            return j.a(ee, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal");
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ee, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.Z(true);
            cVar.aa(false);
            if (com.baidu.adp.lib.Disk.d.ll().b(cVar) && cVar.isSuccess()) {
                cVar.h(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new com.baidu.adp.widget.a.a(bitmap, cVar.isGif(), g);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
