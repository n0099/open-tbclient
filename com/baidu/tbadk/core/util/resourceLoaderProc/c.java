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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.t;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.g.e<com.baidu.adp.widget.a.a> {
    private int aaR;

    public int vO() {
        return this.aaR;
    }

    public c(int i) {
        this.aaR = 0;
        this.aaR = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.g.e
    /* renamed from: d */
    public com.baidu.adp.widget.a.a b(String str, String str2, Object... objArr) {
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
        Bitmap Bytes2Bitmap = bArr2 != null ? BitmapHelper.Bytes2Bitmap(bArr2) : null;
        if (Bytes2Bitmap == null) {
            if (booleanValue && str.startsWith("/")) {
                Bytes2Bitmap = com.baidu.adp.lib.util.d.fT().aA(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.fT().Bitmap2Bytes(Bytes2Bitmap, 100);
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
        String str4 = booleanValue ? str : String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(str) + "&imgtype=0") + "&qulity=" + bb.vk().vp());
        boolean z = false;
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.c.e.dN().ac("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = String.valueOf(str4.substring(0, lastIndexOf)) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.oU = kVar;
        }
        byte[] m = kVar.m(str3, !booleanValue);
        if (kVar.responseCode == 302 && (17 == vO() || 18 == vO() || 13 == vO() || 14 == vO())) {
            try {
                InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(t.f.img_default_delete_big2, new TypedValue());
                m = com.baidu.adp.lib.network.a.b.i(openRawResource);
                com.baidu.adp.lib.h.a.j(openRawResource);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        if (!kVar.vI() && kVar.responseCode != 302) {
            bitmap = null;
        } else {
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(m);
            if (z && Bytes2Bitmap == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.m9getInst().incWebpFailureCount();
                m = kVar.m(str4, !booleanValue);
                if (m != null && kVar.vI()) {
                    bitmap = BitmapHelper.Bytes2Bitmap(m);
                }
            }
            bitmap = Bytes2Bitmap;
        }
        if (!kVar.adh) {
            a(str, m, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.k.m(m), str, m);
    }

    @Override // com.baidu.adp.lib.g.e
    public boolean eD() {
        return true;
    }

    @Override // com.baidu.adp.lib.g.e
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.g.a aVar) {
        String dR = dR(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.dC(dR == null ? str : dR), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.r(true);
        cVar.u(z);
        if (dR != null) {
            cVar.v(dS(str));
        } else {
            cVar.v(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.oU = dVar;
        }
        com.baidu.adp.lib.Disk.d.cB().c(cVar);
    }

    public static boolean dQ(String str) {
        String dR = dR(str);
        if (dR != null) {
            str = dR;
        }
        String dC = bc.dC(str);
        if (!TextUtils.isEmpty(dC)) {
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, dC, DiskFileOperate.Action.INFO);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.r(true);
            return cVar.cC();
        }
        return false;
    }

    private byte[] a(String str, com.baidu.adp.lib.g.a aVar) {
        String dR = dR(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, bc.dC(dR == null ? str : dR), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.r(true);
        cVar.s(true);
        cVar.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.oU = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.cB().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.gn()) {
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
                if (dR == null || cVar.cZ() || !dS(str)) {
                    return cVar.da();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public BdAsyncTaskParallel eE() {
        return null;
    }

    @Override // com.baidu.adp.lib.g.e
    public int eF() {
        return 1;
    }

    private static String dR(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.h.go(str)) {
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

    private static boolean dS(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.h.go(str)) {
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
