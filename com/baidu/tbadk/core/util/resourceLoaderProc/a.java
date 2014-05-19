package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.resourceLoader.BdResourceLoaderNetHelperStatic;
import com.baidu.adp.lib.stats.s;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public abstract class a implements com.baidu.adp.lib.resourceLoader.g<com.baidu.adp.widget.a.a> {
    public abstract int b();

    public abstract int c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, Object... objArr) {
        return com.baidu.tbadk.imageManager.e.a().c(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, com.baidu.adp.lib.resourceLoader.a aVar, Object... objArr) {
        com.baidu.adp.widget.a.a aVar2;
        s a = ac.a();
        a.a();
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c a2 = a(be.f(str));
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
        if (!com.baidu.adp.lib.Disk.d.a().b(a2)) {
            ac.a(a, str, false, a.b());
            return null;
        }
        int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
        if (BdResourceLoaderNetHelperStatic.a()) {
            i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        }
        synchronized (bArr) {
            try {
                bArr.wait(i);
            } catch (InterruptedException e) {
                BdLog.d("wait exception. class is " + e.getClass().getName() + e.getMessage());
            }
        }
        if (a2.g()) {
            aVar2 = a(a2, str);
        } else {
            BdLog.d("local failed");
            aVar2 = null;
        }
        if (aVar2 != null) {
            ac.a(a, str, true, a.b());
            return aVar2;
        }
        ac.a(a, str, false, a.b());
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.resourceLoader.g
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
        BdLog.d("begin from remote");
        s a = ac.a();
        a.a();
        int b = i == 0 ? b() : i;
        int c = i2 == 0 ? c() : i2;
        int a2 = b == 0 ? com.baidu.adp.lib.util.h.a((Context) TbadkApplication.m252getInst().getApp(), 105.0f) : b;
        int a3 = c == 0 ? com.baidu.adp.lib.util.h.a((Context) TbadkApplication.m252getInst().getApp(), 105.0f) : c;
        boolean d = d();
        String a4 = d ? str : a(str, a2, a3);
        if (!(TbadkApplication.m252getInst().getCapabilityOfWebp() && com.baidu.adp.lib.a.f.a().b("webp_enable") == 1) || a4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = a4.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = a4;
        } else {
            str3 = String.valueOf(a4.substring(0, lastIndexOf)) + ".webp" + a4.substring(lastIndexOf + 4, a4.length());
            z = true;
        }
        com.baidu.tbadk.core.util.a.e eVar = new com.baidu.tbadk.core.util.a.e();
        if (aVar != null) {
            aVar.a = eVar;
        }
        byte[] a5 = eVar.a(str3, !d);
        if (!eVar.b()) {
            if (!eVar.c().a) {
                ac.a(a, str, false, str3, d, Boolean.valueOf(z), eVar.f, "NetworkError", a.b());
            }
            return null;
        } else if (a5 == null) {
            ac.a(a, str, false, str3, d, Boolean.valueOf(z), eVar.f, "ByteIsNull", a.b());
            return null;
        } else {
            if (a5.length > 1) {
                ac.a(a, str, true, str3, d, Boolean.valueOf(z), eVar.f, "", a.b());
            } else {
                ac.a(a, str, false, str3, d, Boolean.valueOf(z), eVar.f, "bytes<1", a.b());
            }
            s a6 = ac.a();
            a6.a();
            com.baidu.tbadk.imageManager.e.a().c(TbConfig.getPbImageSize() + a5.length);
            Rect rect = new Rect();
            Bitmap a7 = a(a5, rect);
            if (z && a7 == null) {
                BdLog.e("Webp decoding failed: " + str);
                TiebaStatic.imgError(eVar.a, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str);
                TbadkApplication.m252getInst().incWebpFailureCount();
                byte[] a8 = eVar.a(a4, !d);
                if (a8 == null || !eVar.b()) {
                    bArr = a8;
                    z2 = false;
                } else {
                    a7 = a(a8, rect);
                    bArr = a8;
                    z2 = false;
                }
            } else {
                bArr = a5;
                z2 = z;
            }
            if (bArr == null || a7 == null) {
                if (bArr == null) {
                    ac.a(a6, str, str3, false, d, z2, 0, "TmpIsNull", a6.b());
                } else {
                    ac.a(a6, str, str3, false, d, z2, bArr.length, "ConvertError", a6.b());
                }
                return null;
            }
            boolean z3 = eVar.d || com.baidu.adp.lib.util.h.a(bArr);
            Bitmap a9 = a(a7, a2, a3);
            if (a9 == null) {
                ac.a(a6, str, str3, false, d, z2, bArr.length, "ResizeError", a6.b());
                return null;
            }
            ac.a(a6, str, str3, true, d, z2, bArr.length, "", a6.b());
            if (!a(a9)) {
                return null;
            }
            com.baidu.adp.widget.a.a aVar2 = new com.baidu.adp.widget.a.a(a9, z3, str, rect);
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, be.f(str2), DiskFileOperate.Action.WRITE);
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

    @Override // com.baidu.adp.lib.resourceLoader.g
    public boolean a() {
        return com.baidu.tbadk.core.h.a().f();
    }

    @Override // com.baidu.adp.lib.resourceLoader.g
    public void a(String str, Object obj, Object... objArr) {
        if (obj != null && (obj instanceof com.baidu.adp.widget.a.a)) {
            com.baidu.tbadk.imageManager.e.a().b(str, (com.baidu.adp.widget.a.a) obj);
        }
    }

    protected String a(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(100);
        sb.append(TbConfig.IMAGE_ADDRESS);
        sb.append("src=");
        sb.append(be.d(str));
        sb.append("&width=");
        sb.append(String.valueOf(i));
        sb.append("&height=");
        sb.append(String.valueOf(i2));
        sb.append("&imgtype=0");
        sb.append("&qulity=" + bf.a().d());
        sb.append("&first_gif=1");
        if (e()) {
            sb.append("&ispv=1");
        }
        if (f()) {
            sb.append("&no_prefix=1");
        }
        return sb.toString();
    }

    protected com.baidu.adp.lib.Disk.ops.c a(String str) {
        return new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, DiskFileOperate.Action.READ);
    }

    protected com.baidu.adp.widget.a.a a(com.baidu.adp.lib.Disk.ops.c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        cVar.b(cVar.b());
        Bitmap u = cVar.u();
        if (u != null) {
            com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(u, cVar.t(), str);
            BdLog.d("from local. data returned.");
            return aVar;
        }
        return null;
    }

    protected Bitmap a(byte[] bArr, Rect rect) {
        return com.baidu.tbadk.core.util.g.a(bArr);
    }

    protected boolean a(Bitmap bitmap) {
        return bitmap != null;
    }

    protected Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            BdLog.e(getClass().getName(), "doInBackground", "image_too_big:" + String.valueOf(String.valueOf(bitmap.getWidth()) + "*" + String.valueOf(bitmap.getHeight())));
            com.baidu.tbadk.imageManager.e.a().c(com.baidu.tbadk.core.util.g.a(bitmap) * 2);
            return com.baidu.tbadk.core.util.g.a(bitmap, i, i2, true);
        }
        return bitmap;
    }
}
