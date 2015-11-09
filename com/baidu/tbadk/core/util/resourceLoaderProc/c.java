package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: f */
    public com.baidu.adp.widget.a.a c(String str, String str2, Object... objArr) {
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
        Bitmap N = bArr2 != null ? com.baidu.tbadk.core.util.c.N(bArr2) : null;
        if (N == null) {
            if (booleanValue && str.startsWith("/")) {
                N = com.baidu.adp.lib.util.d.iv().az(str);
                if (N != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.iv().e(N, 100);
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
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        String str3;
        byte[] bArr;
        Bitmap bitmap;
        int lastIndexOf;
        if (str != null && str.startsWith("/")) {
            return null;
        }
        boolean booleanValue = (str == null || !str.startsWith("width=")) ? Boolean.valueOf(String.valueOf(objArr[2])).booleanValue() : false;
        String str4 = booleanValue ? str : String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(str) + "&imgtype=0") + "&qulity=" + at.uK().uP());
        boolean z = false;
        if (!(TbadkCoreApplication.m411getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.gv().af("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = String.valueOf(str4.substring(0, lastIndexOf)) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.j jVar = new com.baidu.tbadk.core.util.a.j();
        if (aVar != null) {
            aVar.vs = jVar;
        }
        byte[] l = jVar.l(str3, !booleanValue);
        if (!jVar.vj()) {
            bArr = l;
            bitmap = null;
        } else {
            Bitmap N = com.baidu.tbadk.core.util.c.N(l);
            if (z && N == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.m411getInst().incWebpFailureCount();
                bArr = jVar.l(str4, !booleanValue);
                bitmap = (bArr == null || !jVar.vj()) ? N : com.baidu.tbadk.core.util.c.N(bArr);
            } else {
                bArr = l;
                bitmap = N;
            }
        }
        if (!jVar.acE) {
            a(str, bArr, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.k.z(bArr), str, bArr);
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean he() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String dy = dy(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.dn(dy == null ? str : dy), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.o(true);
        cVar.r(z);
        if (dy != null) {
            cVar.s(dz(str));
        } else {
            cVar.s(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.vs = dVar;
        }
        com.baidu.adp.lib.Disk.d.fj().c(cVar);
    }

    public static boolean checkFileExist(String str) {
        String dy = dy(str);
        if (dy != null) {
            str = dy;
        }
        String dn = au.dn(str);
        if (!TextUtils.isEmpty(dn)) {
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, dn, DiskFileOperate.Action.INFO);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.o(true);
            return cVar.fk();
        }
        return false;
    }

    private byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String dy = dy(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, au.dn(dy == null ? str : dy), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.o(true);
        cVar.p(true);
        cVar.h(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.vs = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.fj().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.iO()) {
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
                if (dy == null || cVar.fG() || !dz(str)) {
                    return cVar.fH();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel hf() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int hg() {
        return 1;
    }

    private static String dy(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.e.fM(str)) {
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

    private static boolean dz(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.e.fM(str)) {
            String[] split2 = str.split("/");
            if (split2.length > 3) {
                try {
                    String[] split3 = URLDecoder.decode(split2[split2.length - 3], "utf-8").split(";");
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
