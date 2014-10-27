package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.g<com.baidu.adp.widget.a.a> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    public com.baidu.adp.widget.a.a a(String str, String str2, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    @Override // com.baidu.adp.lib.f.g
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.a.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        byte[] bArr;
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr2 = (byte[]) objArr[1];
        Bitmap w = bArr2 != null ? com.baidu.tbadk.core.util.d.w(bArr2) : null;
        if (w == null) {
            if (booleanValue && str.startsWith("/")) {
                w = com.baidu.adp.lib.util.c.eS().ao(str);
                if (w != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.c.eS().b(w, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    w = com.baidu.tbadk.core.util.d.w(bArr);
                }
            }
            if (w == null) {
                return new com.baidu.adp.widget.a.a(w, com.baidu.adp.lib.util.m.l(bArr), str2, bArr);
            }
            return null;
        }
        bArr = bArr2;
        if (w == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.g
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
        String str4 = booleanValue ? str : String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(str) + "&imgtype=0") + "&qulity=" + az.mD().mI());
        boolean z = false;
        if (!(TbadkApplication.m251getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.f.db().U("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = String.valueOf(str4.substring(0, lastIndexOf)) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.httpNet.k kVar = new com.baidu.tbadk.core.util.httpNet.k();
        if (aVar != null) {
            aVar.lb = kVar;
        }
        byte[] j = kVar.j(str3, !booleanValue);
        if (!kVar.ni()) {
            bArr = j;
            bitmap = null;
        } else {
            Bitmap w = com.baidu.tbadk.core.util.d.w(j);
            if (z && w == null) {
                TiebaStatic.imgError(kVar.Gt, TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkApplication.m251getInst().incWebpFailureCount();
                bArr = kVar.j(str4, !booleanValue);
                bitmap = (bArr == null || !kVar.ni()) ? w : com.baidu.tbadk.core.util.d.w(bArr);
            } else {
                bArr = j;
                bitmap = w;
            }
        }
        if (!kVar.Gz) {
            a(str, bArr, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.m.l(bArr), str, bArr);
    }

    @Override // com.baidu.adp.lib.f.g
    public boolean eh() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.g
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String ca = ca(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.bQ(ca == null ? str : ca), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.k(true);
        cVar.n(z);
        if (ca != null) {
            cVar.o(cb(str));
        } else {
            cVar.o(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cVar);
            aVar.lb = dVar;
        }
        com.baidu.adp.lib.Disk.d.bn().c(cVar);
    }

    private byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String ca = ca(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, ba.bQ(ca == null ? str : ca), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.k(true);
        cVar.l(true);
        cVar.b(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.g(cVar);
            aVar.lb = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.bn().c(cVar)) {
            int i = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
            if (com.baidu.adp.lib.util.j.fi()) {
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
                if (ca == null || cVar.bN() || !cb(str)) {
                    return cVar.bO();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public BdAsyncTaskParallel ei() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.g
    public int ej() {
        return 1;
    }

    private static String ca(String str) {
        int i;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf > 0 && indexOf < 20) {
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

    private static boolean cb(String str) {
        int indexOf;
        String[] split;
        if (str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20) {
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
