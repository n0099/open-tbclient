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
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.n;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.g.e<com.baidu.adp.widget.a.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        byte[] bArr;
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr2 = (byte[]) objArr[1];
        Bitmap N = bArr2 != null ? com.baidu.tbadk.core.util.c.N(bArr2) : null;
        if (N == null) {
            if (booleanValue && str.startsWith("/")) {
                N = com.baidu.adp.lib.util.d.ix().aD(str);
                if (N != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.ix().e(N, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    N = com.baidu.tbadk.core.util.c.N(bArr);
                }
            }
            if (N == null) {
                return new com.baidu.adp.widget.a.a(N, com.baidu.adp.lib.util.k.z(bArr), str2, bArr);
            }
            return null;
        }
        bArr = bArr2;
        if (N == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.g.a aVar, Object... objArr) {
        String str3;
        Bitmap bitmap;
        int lastIndexOf;
        if (str != null && str.startsWith("/")) {
            return null;
        }
        boolean booleanValue = (str == null || !str.startsWith("width=")) ? Boolean.valueOf(String.valueOf(objArr[2])).booleanValue() : false;
        String str4 = booleanValue ? str : String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(str) + "&imgtype=0") + "&qulity=" + ay.va().vf());
        boolean z = false;
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.c.e.gw().aj("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = String.valueOf(str4.substring(0, lastIndexOf)) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.j jVar = new com.baidu.tbadk.core.util.a.j();
        if (aVar != null) {
            aVar.vA = jVar;
        }
        byte[] m = jVar.m(str3, !booleanValue);
        if (jVar.responseCode == 302 && !com.baidu.tbadk.util.e.gf(str4)) {
            try {
                InputStream openRawResource = TbadkCoreApplication.m411getInst().getResources().openRawResource(n.f.img_default_delete_big2, new TypedValue());
                m = com.baidu.adp.lib.network.a.b.d(openRawResource);
                com.baidu.adp.lib.h.a.e(openRawResource);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        if (!jVar.vz() && jVar.responseCode != 302) {
            bitmap = null;
        } else {
            Bitmap N = com.baidu.tbadk.core.util.c.N(m);
            if (z && N == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.m411getInst().incWebpFailureCount();
                m = jVar.m(str4, !booleanValue);
                if (m != null && jVar.vz()) {
                    bitmap = com.baidu.tbadk.core.util.c.N(m);
                }
            }
            bitmap = N;
        }
        if (!jVar.aea) {
            a(str, m, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.k.z(m), str, m);
    }

    @Override // com.baidu.adp.lib.g.e
    public boolean hg() {
        return true;
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.g.a aVar) {
        String dL = dL(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, az.dB(dL == null ? str : dL), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.o(true);
        cVar.r(z);
        if (dL != null) {
            cVar.s(dM(str));
        } else {
            cVar.s(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.vA = dVar;
        }
        com.baidu.adp.lib.Disk.d.fj().c(cVar);
    }

    public static boolean checkFileExist(String str) {
        String dL = dL(str);
        if (dL != null) {
            str = dL;
        }
        String dB = az.dB(str);
        if (!TextUtils.isEmpty(dB)) {
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, dB, DiskFileOperate.Action.INFO);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            return cVar.fk();
        }
        return false;
    }

    private byte[] a(String str, com.baidu.adp.lib.g.a aVar) {
        String dL = dL(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, az.dB(dL == null ? str : dL), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.o(true);
        cVar.p(true);
        cVar.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.vA = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.fj().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.iR()) {
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
                if (dL == null || cVar.fG() || !dM(str)) {
                    return cVar.fH();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel hh() {
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public int hi() {
        return 1;
    }

    private static String dL(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.e.ge(str)) {
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

    private static boolean dM(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.e.ge(str)) {
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
