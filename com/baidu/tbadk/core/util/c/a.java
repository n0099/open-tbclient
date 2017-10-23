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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.d;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean vP();

    public abstract boolean vQ();

    public abstract int vR();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.ImageView.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.ImageView.a gh = com.baidu.tbadk.imageManager.c.DT().gh(str);
        if (gh != null) {
            gh.Gz.GB = "memory";
            gh.Gz.GC = 0L;
            gh.Gz.GD = true;
        }
        return gh;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.a fK = s.fK();
        fK.fT();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c ec = ec(ao.dP(str2));
        if (ec == null) {
            return null;
        }
        ec.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        ec.t(true);
        ec.u(false);
        ec.j(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(ec);
            aVar.vF = dVar;
        }
        boolean hi = com.baidu.adp.lib.util.j.hi();
        if (!com.baidu.adp.lib.Disk.d.dH().c(ec)) {
            s.a(fK, str2, false, fK.fU(), hi);
            return null;
        }
        int i = 2000;
        if (hi) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.ImageView.a a = ec.isSuccess() ? a(ec, str2) : null;
        if (a != null) {
            s.a(fK, str2, true, fK.fU(), hi);
        } else {
            s.a(fK, str2, false, fK.fU(), hi);
        }
        if (a != null) {
            a.Gz.GB = "disk";
            a.Gz.GC = fK.fU();
            a.Gz.GD = true;
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
        com.baidu.adp.lib.stats.a fK = s.fK();
        fK.fT();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.l.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String d = isFromCDN ? str : d(str, dip2px, height);
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.eV().af("webp_enable") == 1) || d.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = d.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = d;
        } else {
            str3 = d.substring(0, lastIndexOf) + ".webp" + d.substring(lastIndexOf + 4, d.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.vF = iVar;
        }
        byte[] j = iVar.j(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!iVar.vL()) {
            if (iVar.responseCode == 302 && (17 == vR() || 18 == vR() || 13 == vR() || 14 == vR())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.g.img_default_delete, new TypedValue());
                    byte[] c = com.baidu.adp.lib.network.a.b.c(openRawResource);
                    com.baidu.adp.widget.ImageView.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(c, rect, sb2), iVar.isGif || com.baidu.adp.lib.util.l.j(c), iVar, c, rect);
                    if (a != null) {
                        a.Gz.GB = "net";
                        a.Gz.GC = fK.fU();
                        a.Gz.GD = true;
                    }
                    com.baidu.adp.lib.g.a.d(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!iVar.fz().vo) {
                long j2 = 0;
                if (j != null) {
                    j2 = j.length;
                }
                s.a(fK, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ail, "NetworkError", fK.fU(), iVar.vO(), j2, vR());
                return null;
            }
        }
        if (j == null && !iVar.fz().vo) {
            s.a(fK, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ail, "ByteIsNull", fK.fU(), iVar.vO(), 0L, vR());
            return null;
        }
        if (j.length > 1) {
            h.vS().c(j.length, fK.fU());
            s.a(fK, str, true, str3, isFromCDN, Boolean.valueOf(z), iVar.ail, "InputToByteSucc", fK.fU(), iVar.vO(), j.length, vR());
        } else {
            s.a(fK, str, false, str3, isFromCDN, Boolean.valueOf(z), iVar.ail, "bytes<1", fK.fU(), iVar.vO(), j.length, vR());
        }
        com.baidu.adp.lib.stats.a fK2 = s.fK();
        fK2.fT();
        com.baidu.tbadk.imageManager.c.DT().fh(TbConfig.getPbImageSize() + j.length);
        Bitmap a2 = a(j, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            j = iVar.j(d, !isFromCDN);
            fK2.fT();
            if (j == null || !iVar.vL()) {
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
                s.a(fK2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", fK2.fU(), sb.toString());
            } else {
                s.a(fK2, str, str3, false, isFromCDN, z2, j.length, "ConvertError", fK2.fU(), sb.toString());
            }
            return null;
        }
        boolean z3 = iVar.isGif || com.baidu.adp.lib.util.l.j(j);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            s.a(fK2, str, str3, false, isFromCDN, z2, j.length, "ResizeError", fK2.fU(), sb.toString());
            return null;
        }
        s.a(fK2, str, str3, true, isFromCDN, z2, j.length, "", fK2.fU(), sb.toString());
        com.baidu.adp.widget.ImageView.a a4 = a(str, str2, aVar, null, a3, z3, iVar, j, rect);
        if (a4 != null) {
            a4.Gz.GB = "net";
            a4.Gz.GC = fK.fU();
            a4.Gz.GD = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.ImageView.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.i iVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, z, str, rect);
            if (!iVar.aiq) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ao.dP(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.t(true);
                cVar.setData(bArr);
                cVar.w(z);
                com.baidu.adp.lib.Disk.d.dH().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.vF = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fM() {
        return com.baidu.tbadk.core.h.oM().oS();
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.ImageView.a)) {
            com.baidu.tbadk.imageManager.c.DT().c(str, (com.baidu.adp.widget.ImageView.a) obj);
        }
    }

    protected String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(am.aN(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + an.vl().vq());
            sb.append("&first_gif=1");
            if (vP()) {
                sb.append("&ispv=1");
            }
            if (vQ()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c ec(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.ImageView.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.h(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.ImageView.a(bitmap, cVar.isGif(), str);
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
            com.baidu.tbadk.imageManager.c.DT().fh(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fN() {
        return h.vS().fN();
    }

    @Override // com.baidu.adp.lib.f.e
    public int fO() {
        return 1;
    }
}
