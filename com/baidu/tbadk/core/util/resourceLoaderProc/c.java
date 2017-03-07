package com.baidu.tbadk.core.util.resourceLoaderProc;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    private int procType;

    public int wh() {
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
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
                Bytes2Bitmap = com.baidu.adp.lib.util.d.gM().at(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.gM().Bitmap2Bytes(Bytes2Bitmap, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
            if (Bytes2Bitmap == null) {
                return new com.baidu.adp.widget.a.a(Bytes2Bitmap, com.baidu.adp.lib.util.k.m(bArr), str2, bArr);
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
        String str4 = booleanValue ? str : String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(str) + "&imgtype=0") + "&qulity=" + av.vD().vI());
        boolean z = false;
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.eT().ab("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = String.valueOf(str4.substring(0, lastIndexOf)) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.wz = kVar;
        }
        byte[] m = kVar.m(str3, !booleanValue);
        if (kVar.responseCode == 302 && (17 == wh() || 18 == wh() || 13 == wh() || 14 == wh())) {
            try {
                InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(w.g.img_default_delete_big2, new TypedValue());
                m = com.baidu.adp.lib.network.a.b.i(openRawResource);
                com.baidu.adp.lib.g.a.j(openRawResource);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        if (!kVar.wb() && kVar.responseCode != 302) {
            bitmap = null;
        } else {
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(m);
            if (z && Bytes2Bitmap == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.m9getInst().incWebpFailureCount();
                m = kVar.m(str4, !booleanValue);
                if (m != null && kVar.wb()) {
                    bitmap = BitmapHelper.Bytes2Bitmap(m);
                }
            }
            bitmap = Bytes2Bitmap;
        }
        if (!kVar.ahK) {
            a(str, m, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.k.m(m), str, m);
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fJ() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String dM = dM(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dx(dM == null ? str : dM), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.v(z);
        if (dM != null) {
            cVar.w(dN(str));
        } else {
            cVar.w(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.wz = dVar;
        }
        com.baidu.adp.lib.Disk.d.dI().c(cVar);
    }

    public static boolean dL(String str) {
        String dM = dM(str);
        if (dM != null) {
            str = dM;
        }
        String dx = aw.dx(str);
        if (!TextUtils.isEmpty(dx)) {
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, dx, DiskFileOperate.Action.INFO);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            return cVar.dJ();
        }
        return false;
    }

    private byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String dM = dM(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dx(dM == null ? str : dM), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.t(true);
        cVar.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.wz = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.dI().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.hf()) {
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
                if (dM == null || cVar.eg() || !dN(str)) {
                    return cVar.eh();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fK() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fL() {
        return 1;
    }

    private static String dM(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.g.fZ(str)) {
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

    private static boolean dN(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.g.fZ(str)) {
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
