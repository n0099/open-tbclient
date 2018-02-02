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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract boolean Dp();

    public abstract boolean Dq();

    public abstract int Dr();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gG = com.baidu.tbadk.imageManager.c.LR().gG(str);
        if (gG != null) {
            gG.aup.aur = "memory";
            gG.aup.aus = 0L;
            gG.aup.aut = true;
        }
        return gG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.core.util.s.nn();
        nn.nw();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ez = ez(ao.ej(str2));
        if (ez == null) {
            return null;
        }
        ez.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ez.ab(false);
        ez.Z(true);
        ez.ac(true);
        ez.aa(false);
        ez.ao(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ez);
            aVar.ajT = dVar;
        }
        boolean oK = com.baidu.adp.lib.util.j.oK();
        if (!com.baidu.adp.lib.Disk.d.ll().c(ez)) {
            com.baidu.tbadk.core.util.s.a(nn, str2, false, nn.nx(), oK);
            return null;
        }
        int i = 2000;
        if (oK) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = ez.isSuccess() ? a(ez, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(nn, str2, true, nn.nx(), oK);
        } else {
            com.baidu.tbadk.core.util.s.a(nn, str2, false, nn.nx(), oK);
        }
        if (a != null) {
            a.aup.aur = "disk";
            a.aup.aus = nn.nx();
            a.aup.aut = true;
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
        com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.core.util.s.nn();
        nn.nw();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String i3 = isFromCDN ? str : i(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.mA().an("webp_enable") == 1) || i3.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = i3.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = i3;
        } else {
            str3 = i3.substring(0, lastIndexOf) + ".webp" + i3.substring(lastIndexOf + 4, i3.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.ajT = iVar;
        }
        byte[] j = iVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.Dk()) {
            if (iVar.responseCode == 302 && (17 == Dr() || 18 == Dr() || 13 == Dr() || 14 == Dr())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] c = com.baidu.adp.lib.network.a.b.c(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(c, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.j(c), iVar, c, rect);
                    if (a != null) {
                        a.aup.aur = "net";
                        a.aup.aus = nn.nx();
                        a.aup.aut = true;
                    }
                    com.baidu.adp.lib.g.a.d(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.nc().ajC) {
                long j2 = 0;
                if (j != null) {
                    j2 = j.length;
                }
                com.baidu.tbadk.core.util.s.a(nn, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aXm, "NetworkError", nn.nx(), iVar.Dn(), j2, Dr());
                return null;
            }
        }
        if (j == null && !iVar.nc().ajC) {
            com.baidu.tbadk.core.util.s.a(nn, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aXm, "ByteIsNull", nn.nx(), iVar.Dn(), 0L, Dr());
            return null;
        }
        if (j.length > 1) {
            i.Dt().c(j.length, nn.nx());
            com.baidu.tbadk.core.util.s.a(nn, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.aXm, "InputToByteSucc", nn.nx(), iVar.Dn(), j.length, Dr());
        } else {
            com.baidu.tbadk.core.util.s.a(nn, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aXm, "bytes<1", nn.nx(), iVar.Dn(), j.length, Dr());
        }
        com.baidu.adp.lib.stats.a nn2 = com.baidu.tbadk.core.util.s.nn();
        nn2.nw();
        com.baidu.tbadk.imageManager.c.LR().ia(TbConfig.getPbImageSize() + j.length);
        Bitmap a2 = a(j, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            j = iVar.j(i3, !isFromCDN);
            nn2.nw();
            if (j == null || !iVar.Dk()) {
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
                com.baidu.tbadk.core.util.s.a(nn2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", nn2.nx(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(nn2, str, str3, false, isFromCDN, z2, j.length, "ConvertError", nn2.nx(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.j(j);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            com.baidu.tbadk.core.util.s.a(nn2, str, str3, false, isFromCDN, z2, j.length, "ResizeError", nn2.nx(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(nn2, str, str3, true, isFromCDN, z2, j.length, "", nn2.nx(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, iVar, j, rect);
        if (a4 != null) {
            a4.aup.aur = "net";
            a4.aup.aus = nn.nx();
            a4.aup.aut = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (g(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.aXr) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.ej(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.Z(true);
                cVar.setData(bArr);
                cVar.ab(false);
                cVar.ac(true);
                cVar.ad(z);
                com.baidu.adp.lib.Disk.d.ll().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.ajT = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean np() {
        return com.baidu.tbadk.core.i.wB().wH();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.LR().c(str, (com.baidu.adp.widget.a.a) obj);
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
            sb.append("&qulity=" + an.CK().CP());
            sb.append("&first_gif=1");
            if (Dp()) {
                sb.append("&ispv=1");
            }
            if (Dq()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c ez(String str) {
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
            com.baidu.tbadk.imageManager.c.LR().ia(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel nq() {
        return i.Dt().nq();
    }

    @Override // com.baidu.adp.lib.f.e
    public int nr() {
        return 1;
    }

    public static boolean v(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.ej(com.baidu.adp.lib.f.c.nm().g(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.Z(true);
        cVar.aa(false);
        cVar.ab(false);
        cVar.ac(true);
        return cVar.lm();
    }

    public static com.baidu.adp.widget.a.a w(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String g = com.baidu.adp.lib.f.c.nm().g(str, i);
        String ej = ao.ej(g);
        if (i == 38) {
            return j.a(ej, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal");
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ej, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.Z(true);
            cVar.aa(false);
            cVar.ac(true);
            cVar.ab(false);
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
