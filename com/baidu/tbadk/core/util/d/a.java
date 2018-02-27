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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    public abstract boolean DI();

    public abstract boolean DJ();

    public abstract int DK();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.a.a f(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a gP = com.baidu.tbadk.imageManager.c.Mw().gP(str);
        if (gP != null) {
            gP.aub.aud = "memory";
            gP.aub.aue = 0L;
            gP.aub.auf = true;
        }
        return gP;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a nn = com.baidu.tbadk.core.util.s.nn();
        nn.nw();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c eK = eK(ap.eu(str2));
        if (eK == null) {
            return null;
        }
        eK.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        eK.ad(false);
        eK.ab(true);
        eK.ae(true);
        eK.ac(false);
        eK.ao(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(eK);
            aVar.ajM = dVar;
        }
        boolean oK = com.baidu.adp.lib.util.j.oK();
        if (!com.baidu.adp.lib.Disk.d.ll().c(eK)) {
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
        com.baidu.adp.widget.a.a a = eK.isSuccess() ? a(eK, str2) : null;
        if (a != null) {
            com.baidu.tbadk.core.util.s.a(nn, str2, true, nn.nx(), oK);
        } else {
            com.baidu.tbadk.core.util.s.a(nn, str2, false, nn.nx(), oK);
        }
        if (a != null) {
            a.aub.aud = "disk";
            a.aub.aue = nn.nx();
            a.aub.auf = true;
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
            aVar.ajM = iVar;
        }
        byte[] i4 = iVar.i(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.DD()) {
            if (iVar.responseCode == 302 && (17 == DK() || 18 == DK() || 13 == DK() || 14 == DK())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete, new TypedValue());
                    byte[] c = com.baidu.adp.lib.network.a.b.c(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(c, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.j(c), iVar, c, rect);
                    if (a != null) {
                        a.aub.aud = "net";
                        a.aub.aue = nn.nx();
                        a.aub.auf = true;
                    }
                    com.baidu.adp.lib.g.a.d(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.nc().ajv) {
                long j = 0;
                if (i4 != null) {
                    j = i4.length;
                }
                com.baidu.tbadk.core.util.s.a(nn, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aYJ, "NetworkError", nn.nx(), iVar.DG(), j, DK());
                return null;
            }
        }
        if (i4 == null && !iVar.nc().ajv) {
            com.baidu.tbadk.core.util.s.a(nn, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aYJ, "ByteIsNull", nn.nx(), iVar.DG(), 0L, DK());
            return null;
        }
        if (i4.length > 1) {
            i.DM().b(i4.length, nn.nx());
            com.baidu.tbadk.core.util.s.a(nn, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.aYJ, "InputToByteSucc", nn.nx(), iVar.DG(), i4.length, DK());
        } else {
            com.baidu.tbadk.core.util.s.a(nn, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.aYJ, "bytes<1", nn.nx(), iVar.DG(), i4.length, DK());
        }
        com.baidu.adp.lib.stats.a nn2 = com.baidu.tbadk.core.util.s.nn();
        nn2.nw();
        com.baidu.tbadk.imageManager.c.Mw().hY(TbConfig.getPbImageSize() + i4.length);
        Bitmap a2 = a(i4, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            i4 = iVar.i(i3, !isFromCDN);
            nn2.nw();
            if (i4 == null || !iVar.DD()) {
                bitmap = a2;
                sb = sb2;
                z2 = false;
            } else {
                StringBuilder sb3 = new StringBuilder(100);
                bitmap = a(i4, rect, sb3);
                sb = sb3;
                z2 = false;
            }
        } else {
            z2 = z;
            bitmap = a2;
            sb = sb2;
        }
        if (i4 == null || bitmap == null) {
            if (i4 == null) {
                com.baidu.tbadk.core.util.s.a(nn2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", nn2.nx(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(nn2, str, str3, false, isFromCDN, z2, i4.length, "ConvertError", nn2.nx(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.j(i4);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            com.baidu.tbadk.core.util.s.a(nn2, str, str3, false, isFromCDN, z2, i4.length, "ResizeError", nn2.nx(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(nn2, str, str3, true, isFromCDN, z2, i4.length, "", nn2.nx(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, iVar, i4, rect);
        if (a4 != null) {
            a4.aub.aud = "net";
            a4.aub.aue = nn.nx();
            a4.aub.auf = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (i(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!iVar.aYO) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ap.eu(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.ab(true);
                cVar.setData(bArr);
                cVar.ad(false);
                cVar.ae(true);
                cVar.af(z);
                com.baidu.adp.lib.Disk.d.ll().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.ajM = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean np() {
        return com.baidu.tbadk.core.i.xo().xu();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Mw().c(str, (com.baidu.adp.widget.a.a) obj);
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
            sb.append("&qulity=" + ao.Dd().Di());
            sb.append("&first_gif=1");
            if (DI()) {
                sb.append("&ispv=1");
            }
            if (DJ()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c eK(String str) {
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
    public boolean i(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Mw().hY(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel nq() {
        return i.DM().nq();
    }

    @Override // com.baidu.adp.lib.f.e
    public int nr() {
        return 1;
    }

    public static boolean v(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ap.eu(com.baidu.adp.lib.f.c.nm().g(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.ab(true);
        cVar.ac(false);
        cVar.ad(false);
        cVar.ae(true);
        return cVar.lm();
    }

    public static com.baidu.adp.widget.a.a w(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String g = com.baidu.adp.lib.f.c.nm().g(str, i);
        String eu = ap.eu(g);
        if (i == 38) {
            return j.a(eu, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal");
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, eu, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.ab(true);
            cVar.ac(false);
            cVar.ae(true);
            cVar.ad(false);
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
