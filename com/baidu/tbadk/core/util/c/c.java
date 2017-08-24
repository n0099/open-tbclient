package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    private int procType;

    public int wx() {
        return this.procType;
    }

    public c(int i) {
        this.procType = 0;
        this.procType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: c */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        byte[] bArr;
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr2 = (byte[]) objArr[1];
        Bitmap Bytes2Bitmap = bArr2 != null ? BitmapHelper.Bytes2Bitmap(bArr2) : null;
        if (Bytes2Bitmap == null) {
            if (booleanValue && str.startsWith("/")) {
                Bytes2Bitmap = com.baidu.adp.lib.util.d.gZ().aD(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.gZ().Bitmap2Bytes(Bytes2Bitmap, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
            if (Bytes2Bitmap == null) {
                return new com.baidu.adp.widget.a.a(Bytes2Bitmap, com.baidu.adp.lib.util.k.p(bArr), str2, bArr);
            }
            return null;
        }
        bArr = bArr2;
        if (Bytes2Bitmap == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
        Bitmap bitmap;
        int lastIndexOf;
        if (str != null && str.startsWith("/")) {
            return null;
        }
        boolean booleanValue = (str == null || !str.startsWith("width=")) ? Boolean.valueOf(String.valueOf(objArr[2])).booleanValue() : false;
        String str4 = booleanValue ? str : TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + am.vR().vW());
        boolean z = false;
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.fh().am("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = str4.substring(0, lastIndexOf) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.xL = iVar;
        }
        byte[] k = iVar.k(str3, !booleanValue);
        if (iVar.responseCode == 302 && (17 == wx() || 18 == wx() || 13 == wx() || 14 == wx())) {
            try {
                InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.g.img_default_delete_big2, new TypedValue());
                k = com.baidu.adp.lib.network.a.b.o(openRawResource);
                com.baidu.adp.lib.g.a.p(openRawResource);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        if (!iVar.wr() && iVar.responseCode != 302) {
            bitmap = null;
        } else {
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(k);
            if (z && Bytes2Bitmap == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.getInst().incWebpFailureCount();
                k = iVar.k(str4, !booleanValue);
                if (k != null && iVar.wr()) {
                    bitmap = BitmapHelper.Bytes2Bitmap(k);
                }
            }
            bitmap = Bytes2Bitmap;
        }
        if (!iVar.ajH) {
            a(str, k, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.k.p(k), str, k);
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fX() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String ev = ev(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.ef(ev == null ? str : ev), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.v(z);
        if (ev != null) {
            cVar.w(ew(str));
        } else {
            cVar.w(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.xL = dVar;
        }
        com.baidu.adp.lib.Disk.d.dS().c(cVar);
    }

    public static boolean eu(String str) {
        String ev = ev(str);
        if (ev != null) {
            str = ev;
        }
        String ef = an.ef(str);
        if (!TextUtils.isEmpty(ef)) {
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ef, DiskFileOperate.Action.INFO);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            return cVar.dT();
        }
        return false;
    }

    private byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String ev = ev(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, an.ef(ev == null ? str : ev), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.t(true);
        cVar.k(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.xL = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.dS().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.hs()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (cVar.isSuccess()) {
                if (ev == null || cVar.eo() || !ew(str)) {
                    return cVar.ep();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fY() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fZ() {
        return 1;
    }

    private static String ev(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.i.gL(str)) {
            int lastIndexOf = str.lastIndexOf("/");
            int lastIndexOf2 = str.lastIndexOf(".");
            int lastIndexOf3 = str.lastIndexOf(".jpg");
            if (lastIndexOf3 <= 0) {
                int lastIndexOf4 = str.lastIndexOf(".webp");
                if (lastIndexOf4 <= 0) {
                    return null;
                }
                i = lastIndexOf4 + 5;
            } else {
                i = lastIndexOf3 + 4;
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (lastIndexOf > 0 && lastIndexOf2 > 0) {
                stringBuffer.append(str.substring(lastIndexOf + 1, lastIndexOf2));
                stringBuffer.append(str.substring(i));
                return stringBuffer.toString();
            }
        }
        return null;
    }

    private static boolean ew(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.i.gL(str)) {
            String[] split2 = str.split("/");
            if (split2.length > 3) {
                try {
                    String[] split3 = URLDecoder.decode(split2[split2.length - 3], "utf-8").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    for (String str2 : split3) {
                        if (str2.startsWith("q")) {
                            if (Integer.valueOf(str2.split("=")[split.length - 1]).intValue() <= 50) {
                                return false;
                            }
                        }
                    }
                    return true;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return true;
    }
}
