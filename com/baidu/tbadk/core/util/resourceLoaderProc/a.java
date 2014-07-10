package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.stats.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.bn;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.resourceLoader.h<com.baidu.adp.widget.a.a> {
    public abstract int d();

    public abstract int e();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.a().c(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        o a = ae.a();
        a.a();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c a2 = a(bm.f(str2));
        if (a2 == null) {
            return null;
        }
        a2.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        a2.b(true);
        a2.d(false);
        a2.a((Object) bArr);
        if (aVar != null) {
            b bVar = new b();
            bVar.a(a2);
            aVar.a = bVar;
        }
        boolean a3 = BdResourceLoaderNetHelperStatic.a();
        if (!com.baidu.adp.lib.Disk.d.a().b(a2)) {
            ae.a(a, str2, false, a.b(), a3);
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (a3) {
            i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
            }
        }
        com.baidu.adp.widget.a.a a4 = a2.g() ? a(a2, str2) : null;
        if (a4 != null) {
            ae.a(a, str2, true, a.b(), a3);
        } else {
            ae.a(a, str2, false, a.b(), a3);
        }
        return a4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.h
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] bArr;
        boolean z2;
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        o a = ae.a();
        a.a();
        int d = i == 0 ? d() : i;
        int e = i2 == 0 ? e() : i2;
        int a2 = d == 0 ? com.baidu.adp.lib.util.j.a((Context) TbadkApplication.m252getInst().getApp(), 105.0f) : d;
        int a3 = e == 0 ? com.baidu.adp.lib.util.j.a((Context) TbadkApplication.m252getInst().getApp(), 105.0f) : e;
        boolean f = f();
        String a4 = f ? str : a(str, a2, a3);
        if (!(TbadkApplication.m252getInst().getCapabilityOfWebp() && com.baidu.adp.lib.a.f.a().b("webp_enable") == 1) || a4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = a4.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = a4;
        } else {
            str3 = String.valueOf(a4.substring(0, lastIndexOf)) + ".webp" + a4.substring(lastIndexOf + 4, a4.length());
            z = true;
        }
        com.baidu.tbadk.core.util.httpNet.i iVar = new com.baidu.tbadk.core.util.httpNet.i();
        if (aVar != null) {
            aVar.a = iVar;
        }
        byte[] a5 = iVar.a(str3, !f);
        if (!iVar.b()) {
            if (!iVar.c().a) {
                ae.a(a, str, false, str3, f, Boolean.valueOf(z), iVar.f, "NetworkError", a.b());
            }
            return null;
        } else if (a5 == null) {
            ae.a(a, str, false, str3, f, Boolean.valueOf(z), iVar.f, "ByteIsNull", a.b());
            return null;
        } else {
            if (a5.length > 1) {
                ae.a(a, str, true, str3, f, Boolean.valueOf(z), iVar.f, "", a.b());
            } else {
                ae.a(a, str, false, str3, f, Boolean.valueOf(z), iVar.f, "bytes<1", a.b());
            }
            o a6 = ae.a();
            a6.a();
            com.baidu.tbadk.imageManager.e.a().c(TbConfig.getPbImageSize() + a5.length);
            Rect rect = new Rect();
            StringBuilder sb = new StringBuilder(100);
            Bitmap a7 = a(a5, rect, sb);
            if (z && a7 == null) {
                TiebaStatic.imgError(iVar.a, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkApplication.m252getInst().incWebpFailureCount();
                bArr = iVar.a(a4, !f);
                if (bArr == null || !iVar.b()) {
                    z2 = false;
                } else {
                    StringBuilder sb2 = new StringBuilder(100);
                    z2 = false;
                    a7 = a(bArr, rect, sb2);
                    sb = sb2;
                }
            } else {
                bArr = a5;
                z2 = z;
            }
            if (bArr == null || a7 == null) {
                if (bArr == null) {
                    ae.a(a6, str, str3, false, f, z2, 0, "TmpIsNull", a6.b(), sb.toString());
                } else {
                    ae.a(a6, str, str3, false, f, z2, bArr.length, "ConvertError", a6.b(), sb.toString());
                }
                return null;
            }
            boolean z3 = iVar.d || com.baidu.adp.lib.util.j.a(bArr);
            Bitmap a8 = a(a7, a2, a3);
            if (a8 == null) {
                ae.a(a6, str, str3, false, f, z2, bArr.length, "ResizeError", a6.b(), sb.toString());
                return null;
            }
            ae.a(a6, str, str3, true, f, z2, bArr.length, "", a6.b(), sb.toString());
            if (!a(a8)) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(a8, z3, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bm.f(str2), DiskFileOperate.Action.WRITE);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.b(true);
            cVar.a(bArr);
            cVar.f(z3);
            com.baidu.adp.lib.Disk.d.a().b(cVar);
            if (aVar != null) {
                b bVar = new b();
                bVar.a(cVar);
                aVar.a = bVar;
            }
            return aVar2;
        }
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public boolean a() {
        return com.baidu.tbadk.core.h.a().f();
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.a().b(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String a(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        if (!str.startsWith(TbConfig.IMAGE_ADDRESS)) {
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(bm.d(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + bn.a().d());
            sb.append("&first_gif=1");
            if (g()) {
                sb.append("&ispv=1");
            }
            if (h()) {
                sb.append("&no_prefix=1");
            }
            return sb.toString();
        }
        return str;
    }

    protected com.baidu.adp.lib.Disk.ops.c a(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    protected com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.b(cVar.b());
        Bitmap w = cVar.w();
        if (w != null) {
            return new com.baidu.adp.widget.a.a(w, cVar.v(), str);
        }
        return null;
    }

    protected Bitmap a(byte[] bArr, Rect rect, StringBuilder sb) {
        return com.baidu.tbadk.core.util.h.a(bArr, sb);
    }

    protected boolean a(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            com.baidu.tbadk.imageManager.e.a().c(com.baidu.tbadk.core.util.h.a(bitmap) * 2);
            return com.baidu.tbadk.core.util.h.a(bitmap, i, i2, true);
        }
        return bitmap;
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public BdAsyncTaskParallel b() {
        return null;
    }

    @Override // com.baidu.adp.lib.resourceLoader.h
    public int c() {
        return 1;
    }
}
