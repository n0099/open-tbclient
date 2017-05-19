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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.a.a> {
    private int procType;

    public int vS() {
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
                Bytes2Bitmap = com.baidu.adp.lib.util.d.gS().ap(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.gS().Bitmap2Bytes(Bytes2Bitmap, 100);
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
        String str4 = booleanValue ? str : String.valueOf(TbConfig.IMAGE_ADDRESS) + (String.valueOf(String.valueOf(str) + "&imgtype=0") + "&qulity=" + av.vo().vt());
        boolean z = false;
        if (!(TbadkCoreApplication.m9getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.e.eZ().Y("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            str3 = str4;
        } else {
            z = true;
            str3 = String.valueOf(str4.substring(0, lastIndexOf)) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.k kVar = new com.baidu.tbadk.core.util.a.k();
        if (aVar != null) {
            aVar.wh = kVar;
        }
        byte[] m = kVar.m(str3, !booleanValue);
        if (kVar.responseCode == 302 && (17 == vS() || 18 == vS() || 13 == vS() || 14 == vS())) {
            try {
                InputStream openRawResource = TbadkCoreApplication.m9getInst().getResources().openRawResource(w.g.img_default_delete_big2, new TypedValue());
                m = com.baidu.adp.lib.network.a.b.i(openRawResource);
                com.baidu.adp.lib.g.a.j(openRawResource);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        }
        if (!kVar.vM() && kVar.responseCode != 302) {
            bitmap = null;
        } else {
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(m);
            if (z && Bytes2Bitmap == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.m9getInst().incWebpFailureCount();
                m = kVar.m(str4, !booleanValue);
                if (m != null && kVar.vM()) {
                    bitmap = BitmapHelper.Bytes2Bitmap(m);
                }
            }
            bitmap = Bytes2Bitmap;
        }
        if (!kVar.ahr) {
            a(str, m, false, aVar);
        }
        return new com.baidu.adp.widget.a.a(bitmap, com.baidu.adp.lib.util.k.m(m), str, m);
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean fP() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
    }

    private void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String dQ = dQ(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dB(dQ == null ? str : dQ), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.v(z);
        if (dQ != null) {
            cVar.w(dR(str));
        } else {
            cVar.w(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.wh = dVar;
        }
        com.baidu.adp.lib.Disk.d.dI().c(cVar);
    }

    public static boolean dP(String str) {
        String dQ = dQ(str);
        if (dQ != null) {
            str = dQ;
        }
        String dB = aw.dB(str);
        if (!TextUtils.isEmpty(dB)) {
            com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, dB, DiskFileOperate.Action.INFO);
            cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.s(true);
            return cVar.dJ();
        }
        return false;
    }

    private byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String dQ = dQ(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, aw.dB(dQ == null ? str : dQ), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.s(true);
        cVar.t(true);
        cVar.k((Object) bArr);
        if (aVar != null) {
            d dVar = new d();
            dVar.f(cVar);
            aVar.wh = dVar;
        }
        if (com.baidu.adp.lib.Disk.d.dI().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.i.hl()) {
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
                if (dQ == null || cVar.eg() || !dR(str)) {
                    return cVar.eh();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel fQ() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int fR() {
        return 1;
    }

    private static String dQ(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.h.gd(str)) {
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

    private static boolean dR(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.h.gd(str)) {
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
