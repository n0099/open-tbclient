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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.e;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract boolean Bd();

    public abstract boolean Be();

    public abstract int Bf();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, com.baidu.tbadk.imageManager.c.Kg().hA(str), i, i2);
        if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.oh() == null || checkIsValidPicMemoryCache.oh().isRecycled()) {
            return null;
        }
        checkIsValidPicMemoryCache.Nj.Nl = "memory";
        checkIsValidPicMemoryCache.Nj.Nm = 0L;
        checkIsValidPicMemoryCache.Nj.Nn = true;
        return checkIsValidPicMemoryCache;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.widget.ImageView.a aVar2;
        com.baidu.adp.lib.stats.a jo = com.baidu.tbadk.core.util.s.jo();
        jo.jx();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c fu = fu(ar.fe(str2));
        if (fu == null) {
            return null;
        }
        fu.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        fu.F(false);
        fu.D(true);
        fu.G(true);
        fu.E(false);
        fu.n(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(fu);
            aVar.CI = eVar;
        }
        boolean kL = com.baidu.adp.lib.util.j.kL();
        if (!com.baidu.adp.lib.Disk.d.hl().c(fu)) {
            com.baidu.tbadk.core.util.s.a(jo, str2, false, jo.jy(), kL);
            return null;
        }
        int i3 = 2000;
        if (kL) {
            i3 = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i3);
            } catch (InterruptedException e) {
            }
        }
        if (!fu.isSuccess()) {
            aVar2 = null;
        } else {
            aVar2 = a(fu, str2, i, i2);
        }
        if (aVar2 != null) {
            com.baidu.tbadk.core.util.s.a(jo, str2, true, jo.jy(), kL);
        } else {
            com.baidu.tbadk.core.util.s.a(jo, str2, false, jo.jy(), kL);
        }
        if (aVar2 != null) {
            aVar2.Nj.Nl = "disk";
            aVar2.Nj.Nm = jo.jy();
            aVar2.Nj.Nn = true;
            return aVar2;
        }
        return aVar2;
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
        com.baidu.adp.lib.stats.a jo = com.baidu.tbadk.core.util.s.jo();
        jo.jx();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String l = isFromCDN ? str : l(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.iB().aO("webp_enable") == 1) || l.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = l.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = l;
        } else {
            str3 = l.substring(0, lastIndexOf) + ".webp" + l.substring(lastIndexOf + 4, l.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.CI = iVar;
        }
        byte[] j = iVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.AX()) {
            if (iVar.responseCode == 302 && (17 == Bf() || 18 == Bf() || 13 == Bf() || 14 == Bf())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(e.f.img_default_delete, new TypedValue());
                    byte[] g = com.baidu.adp.lib.network.a.b.g(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(g, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.s(g), iVar, g, rect);
                    if (a != null) {
                        a.Nj.Nl = "net";
                        a.Nj.Nm = jo.jy();
                        a.Nj.Nn = true;
                    }
                    com.baidu.adp.lib.g.a.h(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.jd().Cp) {
                long j2 = 0;
                if (j != null) {
                    j2 = j.length;
                }
                com.baidu.tbadk.core.util.s.a(jo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.avb, "NetworkError", jo.jy(), iVar.Ba(), j2, Bf());
                return null;
            }
        }
        if (j == null && !iVar.jd().Cp) {
            com.baidu.tbadk.core.util.s.a(jo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.avb, "ByteIsNull", jo.jy(), iVar.Ba(), 0L, Bf());
            return null;
        }
        if (j.length > 1) {
            j.Bh().e(j.length, jo.jy());
            com.baidu.tbadk.core.util.s.a(jo, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.avb, "InputToByteSucc", jo.jy(), iVar.Ba(), j.length, Bf());
        } else {
            com.baidu.tbadk.core.util.s.a(jo, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.avb, "bytes<1", jo.jy(), iVar.Ba(), j.length, Bf());
        }
        com.baidu.adp.lib.stats.a jo2 = com.baidu.tbadk.core.util.s.jo();
        jo2.jx();
        com.baidu.tbadk.imageManager.c.Kg().fp(TbConfig.getPbImageSize() + j.length);
        Bitmap a2 = a(j, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            j = iVar.j(l, !isFromCDN);
            jo2.jx();
            if (j == null || !iVar.AX()) {
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
                com.baidu.tbadk.core.util.s.a(jo2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", jo2.jy(), sb.toString());
            } else {
                com.baidu.tbadk.core.util.s.a(jo2, str, str3, false, isFromCDN, z2, j.length, "ConvertError", jo2.jy(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.s(j);
        Bitmap b = b(bitmap, dip2px, height);
        if (b == null) {
            com.baidu.tbadk.core.util.s.a(jo2, str, str3, false, isFromCDN, z2, j.length, "ResizeError", jo2.jy(), sb.toString());
            return null;
        }
        com.baidu.tbadk.core.util.s.a(jo2, str, str3, true, isFromCDN, z2, j.length, "", jo2.jy(), sb.toString());
        com.baidu.adp.widget.ImageView.a a3 = a(str, str2, aVar, null, b, z3, iVar, j, rect);
        if (a3 != null) {
            a3.Nj.Nl = "net";
            a3.Nj.Nm = jo.jy();
            a3.Nj.Nn = true;
            return a3;
        }
        return a3;
    }

    protected Bitmap b(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Kg().fp(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (f(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.avg) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fe(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.D(true);
                cVar.setData(bArr);
                cVar.F(false);
                cVar.G(true);
                cVar.I(z);
                com.baidu.adp.lib.Disk.d.hl().c(cVar);
                if (aVar != null) {
                    e eVar = new e();
                    eVar.f(cVar);
                    aVar.CI = eVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean jq() {
        return com.baidu.tbadk.core.i.uj().un();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.adp.widget.ImageView.a aVar = (com.baidu.adp.widget.ImageView.a) obj;
            aVar.aN(i);
            aVar.aO(i2);
            com.baidu.tbadk.imageManager.c.Kg().c(str, aVar);
        }
    }

    protected String l(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ao.by(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + aq.Az().AE());
            sb.append("&first_gif=1");
            if (Bd()) {
                sb.append("&ispv=1");
            }
            if (Be()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c fu(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str, int i, int i2) {
        if (cVar == null) {
            return null;
        }
        cVar.q(cVar.getData());
        Bitmap checkBitmapSize = checkBitmapSize(cVar.getBitmap(), i, i2);
        if (checkBitmapSize != null) {
            return new com.baidu.adp.widget.ImageView.a(checkBitmapSize, cVar.isGif(), str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.decodeByteArray(bArr, com.baidu.adp.lib.util.l.aO(TbadkCoreApplication.getInst()), com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        return BitmapHelper.checkBitmapSize(bitmap, i, i2);
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel jr() {
        return j.Bh().jr();
    }

    @Override // com.baidu.adp.lib.f.e
    public int js() {
        return 1;
    }

    public static boolean A(String str, int i) {
        com.baidu.adp.lib.Disk.ops.c cVar;
        if (TextUtils.isEmpty(str) || (cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ar.fe(com.baidu.adp.lib.f.c.jn().k(str, i)), DiskFileOperate.Action.INFO)) == null) {
            return false;
        }
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.D(true);
        cVar.E(false);
        cVar.F(false);
        cVar.G(true);
        return cVar.hm();
    }

    public static com.baidu.adp.widget.ImageView.a B(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String k = com.baidu.adp.lib.f.c.jn().k(str, i);
        String fe = ar.fe(k);
        if (i == 38) {
            return k.a(fe, (com.baidu.adp.lib.f.a) null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, fe, DiskFileOperate.Action.READ);
        if (cVar != null) {
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.D(true);
            cVar.E(false);
            cVar.G(true);
            cVar.F(false);
            if (com.baidu.adp.lib.Disk.d.hl().b(cVar) && cVar.isSuccess()) {
                cVar.q(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), k);
                }
                return null;
            }
            return null;
        }
        return null;
    }
}
