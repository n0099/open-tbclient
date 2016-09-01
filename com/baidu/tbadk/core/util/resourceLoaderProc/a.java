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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.t;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.g.e<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean vM();

    public abstract boolean vN();

    public abstract int vO();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: d */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a fT = com.baidu.tbadk.imageManager.c.Ek().fT(str);
        if (fT != null) {
            fT.Ax.Az = "memory";
            fT.Ax.AA = 0L;
            fT.Ax.AB = true;
        }
        return fT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        com.baidu.adp.lib.stats.d eB = v.eB();
        eB.eY();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c dP = dP(bc.dC(str2));
        if (dP == null) {
            return null;
        }
        dP.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        dP.r(true);
        dP.s(false);
        dP.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(dP);
            aVar.oU = dVar;
        }
        boolean gn = com.baidu.adp.lib.util.i.gn();
        if (!com.baidu.adp.lib.Disk.d.cB().c(dP)) {
            v.a(eB, str2, false, eB.eZ(), gn);
            return null;
        }
        int i = 2000;
        if (gn) {
            i = 300;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = dP.isSuccess() ? a(dP, str2) : null;
        if (a != null) {
            v.a(eB, str2, true, eB.eZ(), gn);
        } else {
            v.a(eB, str2, false, eB.eZ(), gn);
        }
        if (a != null) {
            a.Ax.Az = "disk";
            a.Ax.AA = eB.eZ();
            a.Ax.AB = true;
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
        com.baidu.adp.lib.stats.d eB = v.eB();
        eB.eY();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f) : width;
        if (height == 0) {
            height = com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApp(), 105.0f);
        }
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, height);
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.c.e.dN().ac("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.oU = kVar;
        }
        byte[] m = kVar.m(str3, !isFromCDN);
        Rect rect = new Rect();
        StringBuilder sb2 = new StringBuilder(100);
        if (!kVar.vI()) {
            if (kVar.responseCode == 302 && (17 == vO() || 18 == vO() || 13 == vO() || 14 == vO())) {
                try {
                    InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(t.f.img_default_delete, new TypedValue());
                    byte[] i3 = com.baidu.adp.lib.network.a.b.i(openRawResource);
                    com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, BitmapHelper.Bytes2NineBitmap(i3, rect, sb2), kVar.Al || com.baidu.adp.lib.util.k.m(i3), kVar, i3, rect);
                    if (a != null) {
                        a.Ax.Az = "net";
                        a.Ax.AA = eB.eZ();
                        a.Ax.AB = true;
                    }
                    com.baidu.adp.lib.h.a.j(openRawResource);
                    return a;
                } catch (Throwable th) {
                    BdLog.e(th);
                    return null;
                }
            } else if (!kVar.eq().oD) {
                long j = 0;
                if (m != null) {
                    j = m.length;
                }
                v.a(eB, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.adb, "NetworkError", eB.eZ(), kVar.vL(), j, vO());
                return null;
            }
        }
        if (m == null && !kVar.eq().oD) {
            v.a(eB, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.adb, "ByteIsNull", eB.eZ(), kVar.vL(), 0L, vO());
            return null;
        }
        if (m.length > 1) {
            h.vP().b(m.length, eB.eZ());
            v.a(eB, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.adb, "InputToByteSucc", eB.eZ(), kVar.vL(), m.length, vO());
        } else {
            v.a(eB, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.adb, "bytes<1", eB.eZ(), kVar.vL(), m.length, vO());
        }
        com.baidu.adp.lib.stats.d eB2 = v.eB();
        eB2.eY();
        com.baidu.tbadk.imageManager.c.Ek().eR(TbConfig.getPbImageSize() + m.length);
        Bitmap a2 = a(m, rect, sb2);
        if (z && a2 == null) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
            TbadkCoreApplication.m9getInst().incWebpFailureCount();
            m = kVar.m(c, !isFromCDN);
            eB2.eY();
            if (m == null || !kVar.vI()) {
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
                v.a(eB2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", eB2.eZ(), sb.toString());
            } else {
                v.a(eB2, str, str3, false, isFromCDN, z2, m.length, "ConvertError", eB2.eZ(), sb.toString());
            }
            return null;
        }
        boolean z3 = kVar.Al || com.baidu.adp.lib.util.k.m(m);
        Bitmap a3 = a(bitmap, dip2px, height);
        if (a3 == null) {
            v.a(eB2, str, str3, false, isFromCDN, z2, m.length, "ResizeError", eB2.eZ(), sb.toString());
            return null;
        }
        v.a(eB2, str, str3, true, isFromCDN, z2, m.length, "", eB2.eZ(), sb.toString());
        com.baidu.adp.widget.a.a a4 = a(str, str2, aVar, null, a3, z3, kVar, m, rect);
        if (a4 != null) {
            a4.Ax.Az = "net";
            a4.Ax.AA = eB.eZ();
            a4.Ax.AB = true;
            return a4;
        }
        return a4;
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.a.k kVar, byte[] bArr, Rect rect) {
        if (h(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.adh) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.dC(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.r(true);
                cVar.setData(bArr);
                cVar.u(z);
                com.baidu.adp.lib.Disk.d.cB().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.f(cVar);
                    aVar.oU = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.g.e
    public boolean eD() {
        return com.baidu.tbadk.core.l.oG().oM();
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.c.Ek().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ba.aP(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + bb.vk().vp());
            sb.append("&first_gif=1");
            if (vM()) {
                sb.append("&ispv=1");
            }
            if (vN()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c dP(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.k(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, cVar.cY(), str);
        }
        return null;
    }

    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return BitmapHelper.Bytes2Bitmap(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.c.Ek().eR(BitmapHelper.getBitmapSize(bitmap) * 2);
            return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        return h.vP().eE();
    }

    @Override // com.baidu.adp.lib.g.e
    public int eF() {
        return 1;
    }
}
