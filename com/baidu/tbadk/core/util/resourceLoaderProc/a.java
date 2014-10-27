package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean isFromCDN();

    public abstract boolean nk();

    public abstract boolean nl();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, Object... objArr) {
        com.baidu.adp.widget.a.a dt = com.baidu.tbadk.imageManager.e.sg().dt(str);
        if (dt != null) {
            dt.tj.tl = "memory";
            dt.tj.tm = 0L;
            dt.tj.tn = true;
        }
        return dt;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        q logItem = v.getLogItem();
        logItem.eL();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c bZ = bZ(ba.bQ(str2));
        if (bZ == null) {
            return null;
        }
        bZ.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        bZ.k(true);
        bZ.l(false);
        bZ.b(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(bZ);
            aVar.lb = dVar;
        }
        boolean fi = com.baidu.adp.lib.util.j.fi();
        if (!com.baidu.adp.lib.Disk.d.bn().c(bZ)) {
            v.a(logItem, str2, false, logItem.eM(), fi);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (fi) {
            i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a = bZ.isSuccess() ? a(bZ, str2) : null;
        if (a != null) {
            v.a(logItem, str2, true, logItem.eM(), fi);
        } else {
            v.a(logItem, str2, false, logItem.eM(), fi);
        }
        if (a != null) {
            a.tj.tl = "disk";
            a.tj.tm = logItem.eM();
            a.tj.tn = true;
        }
        return a;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] bArr;
        boolean z2;
        Bitmap bitmap;
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        q logItem = v.getLogItem();
        logItem.eL();
        int width = i == 0 ? getWidth() : i;
        int height = i2 == 0 ? getHeight() : i2;
        int dip2px = width == 0 ? com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 105.0f) : width;
        int dip2px2 = height == 0 ? com.baidu.adp.lib.util.m.dip2px(TbadkApplication.m251getInst().getApp(), 105.0f) : height;
        boolean isFromCDN = isFromCDN();
        String c = isFromCDN ? str : c(str, dip2px, dip2px2);
        if (!(TbadkApplication.m251getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.f.db().U("webp_enable") == 1) || c.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = c.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = c;
        } else {
            str3 = String.valueOf(c.substring(0, lastIndexOf)) + ".webp" + c.substring(lastIndexOf + 4, c.length());
            z = true;
        }
        com.baidu.tbadk.core.util.httpNet.k kVar = new com.baidu.tbadk.core.util.httpNet.k();
        if (aVar != null) {
            aVar.lb = kVar;
        }
        byte[] j = kVar.j(str3, !isFromCDN);
        if (!kVar.ni()) {
            if (!kVar.dR().kE) {
                v.a(logItem, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.Gx, "NetworkError", logItem.eM(), kVar.dZ());
            }
            return null;
        } else if (j == null) {
            v.a(logItem, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.Gx, "ByteIsNull", logItem.eM(), kVar.dZ());
            return null;
        } else {
            if (j.length > 1) {
                h.nm().a(j.length, logItem.eM());
                v.a(logItem, str, true, str3, isFromCDN, Boolean.valueOf(z), kVar.Gx, "", logItem.eM(), kVar.dZ());
            } else {
                v.a(logItem, str, false, str3, isFromCDN, Boolean.valueOf(z), kVar.Gx, "bytes<1", logItem.eM(), kVar.dZ());
            }
            q logItem2 = v.getLogItem();
            logItem2.eL();
            com.baidu.tbadk.imageManager.e.sg().cR(TbConfig.getPbImageSize() + j.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap b = b(j, rect, sb);
            if (z && b == null) {
                TiebaStatic.imgError(kVar.Gt, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkApplication.m251getInst().incWebpFailureCount();
                byte[] j2 = kVar.j(c, !isFromCDN);
                if (j2 == null || !kVar.ni()) {
                    bArr = j2;
                    z2 = false;
                    bitmap = b;
                } else {
                    StringBuilder sb2 = new StringBuilder(100);
                    bArr = j2;
                    z2 = false;
                    bitmap = b(j2, rect, sb2);
                    sb = sb2;
                }
            } else {
                bArr = j;
                z2 = z;
                bitmap = b;
            }
            if (bArr == null || bitmap == null) {
                if (bArr == null) {
                    v.a(logItem2, str, str3, false, isFromCDN, z2, 0, "TmpIsNull", logItem2.eM(), sb.toString());
                } else {
                    v.a(logItem2, str, str3, false, isFromCDN, z2, bArr.length, "ConvertError", logItem2.eM(), sb.toString());
                }
                return null;
            }
            boolean z3 = kVar.sX || com.baidu.adp.lib.util.m.l(bArr);
            Bitmap c2 = c(bitmap, dip2px, dip2px2);
            if (c2 == null) {
                v.a(logItem2, str, str3, false, isFromCDN, z2, bArr.length, "ResizeError", logItem2.eM(), sb.toString());
                return null;
            }
            v.a(logItem2, str, str3, true, isFromCDN, z2, bArr.length, "", logItem2.eM(), sb.toString());
            com.baidu.adp.widget.a.a a = a(str, str2, aVar, null, c2, z3, kVar, bArr, rect);
            if (a != null) {
                a.tj.tl = "net";
                a.tj.tm = logItem.eM();
                a.tj.tn = true;
            }
            return a;
        }
    }

    protected com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, com.baidu.adp.widget.a.a aVar2, Bitmap bitmap, boolean z, com.baidu.tbadk.core.util.httpNet.k kVar, byte[] bArr, Rect rect) {
        if (d(bitmap)) {
            aVar2 = new com.baidu.adp.widget.a.a(bitmap, z, str, rect);
            if (!kVar.Gz) {
                com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.bQ(str2), DiskFileOperate.Action.WRITE);
                cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
                cVar.k(true);
                cVar.setData(bArr);
                cVar.n(z);
                com.baidu.adp.lib.Disk.d.bn().c(cVar);
                if (aVar != null) {
                    d dVar = new d();
                    dVar.g(cVar);
                    aVar.lb = dVar;
                }
            }
        }
        return aVar2;
    }

    @Override // com.baidu.adp.lib.f.g
    public boolean eh() {
        return com.baidu.tbadk.core.k.js().jw();
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.sg().c(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String c(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ay.aC(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + az.mD().mI());
            sb.append("&first_gif=1");
            if (nk()) {
                sb.append("&ispv=1");
            }
            if (nl()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.lib.Disk.ops.c bZ(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.i(cVar.getData());
        Bitmap bitmap = cVar.getBitmap();
        if (bitmap != null) {
            return new com.baidu.adp.widget.a.a(bitmap, cVar.bM(), str);
        }
        return null;
    }

    protected Bitmap b(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.d.a(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap c(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.e.sg().cR(com.baidu.tbadk.core.util.d.a(bitmap) * 2);
            return com.baidu.tbadk.core.util.d.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        return h.nm().ei();
    }

    @Override // com.baidu.adp.lib.f.g
    public int ej() {
        return 1;
    }
}
