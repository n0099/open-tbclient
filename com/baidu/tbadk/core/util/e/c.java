package com.baidu.tbadk.core.util.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    private int procType;

    public int aki() {
        return this.procType;
    }

    public c(int i) {
        this.procType = 0;
        this.procType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
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
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        byte[] bArr;
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr2 = (byte[]) objArr[1];
        Bitmap Bytes2Bitmap = bArr2 != null ? BitmapHelper.Bytes2Bitmap(bArr2) : null;
        if (Bytes2Bitmap == null) {
            if (booleanValue && str.startsWith("/")) {
                Bytes2Bitmap = com.baidu.adp.lib.util.d.jJ().aT(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.jJ().Bitmap2Bytes(Bytes2Bitmap, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
            if (Bytes2Bitmap == null) {
                return new com.baidu.adp.widget.ImageView.a(Bytes2Bitmap, com.baidu.adp.lib.util.l.k(bArr), str2, bArr);
            }
            return null;
        }
        bArr = bArr2;
        if (Bytes2Bitmap == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cf  */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        byte[] bArr;
        Bitmap bitmap;
        int lastIndexOf;
        if (str != null && str.startsWith("/")) {
            return null;
        }
        boolean booleanValue = (str == null || !str.startsWith("width=")) ? Boolean.valueOf(String.valueOf(objArr[2])).booleanValue() : false;
        String str4 = booleanValue ? str : TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + ar.ajw().ajB());
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hS().az("webp_enable") == 1) {
            int indexOf = str4.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str4.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str4.lastIndexOf(".jpg")) > 0) {
                z = true;
                str3 = str4.substring(0, lastIndexOf) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.Bk = iVar;
                }
                byte[] O = iVar.O(str3, booleanValue);
                if (iVar.ajV() && iVar.errorCode == -11) {
                    BdLog.e("BIGIMAGE imagesize too big");
                    com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "BigImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str3);
                }
                if (iVar.responseCode == 302 || !(17 == aki() || 18 == aki() || 13 == aki() || 14 == aki())) {
                    bArr = O;
                } else {
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete_big2, new TypedValue());
                        bArr = com.baidu.adp.lib.network.a.b.f(openRawResource);
                        com.baidu.adp.lib.g.a.g(openRawResource);
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                }
                if (iVar.ajV() && iVar.responseCode != 302) {
                    bitmap = null;
                } else {
                    Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                    if (z && Bytes2Bitmap == null) {
                        TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                        TbadkCoreApplication.getInst().incWebpFailureCount();
                        bArr = iVar.O(str4, booleanValue);
                        if (bArr != null && iVar.ajV()) {
                            bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                        }
                    }
                    bitmap = Bytes2Bitmap;
                }
                if (!iVar.bWg) {
                    a(str, bArr, false, aVar);
                }
                return new com.baidu.adp.widget.ImageView.a(bitmap, com.baidu.adp.lib.util.l.k(bArr), str, bArr);
            }
        }
        z = false;
        str3 = str4;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        byte[] O2 = iVar.O(str3, booleanValue);
        if (iVar.ajV()) {
            BdLog.e("BIGIMAGE imagesize too big");
            com.baidu.tbadk.core.e.a.a("gifplay", -1L, -1, "BigImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str3);
        }
        if (iVar.responseCode == 302) {
        }
        bArr = O2;
        if (iVar.ajV()) {
        }
        Bitmap Bytes2Bitmap2 = BitmapHelper.Bytes2Bitmap(bArr);
        if (z) {
            TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
            TbadkCoreApplication.getInst().incWebpFailureCount();
            bArr = iVar.O(str4, booleanValue);
            if (bArr != null) {
                bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                if (!iVar.bWg) {
                }
                return new com.baidu.adp.widget.ImageView.a(bitmap, com.baidu.adp.lib.util.l.k(bArr), str, bArr);
            }
        }
        bitmap = Bytes2Bitmap2;
        if (!iVar.bWg) {
        }
        return new com.baidu.adp.widget.ImageView.a(bitmap, com.baidu.adp.lib.util.l.k(bArr), str, bArr);
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean iH() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel iI() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int iJ() {
        return 1;
    }

    private static com.baidu.adp.lib.Disk.ops.c a(String str, DiskFileOperate.Action action) {
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, action);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.J(true);
        cVar.L(false);
        cVar.M(true);
        return cVar;
    }

    public static void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String oL = oL(str);
        com.baidu.adp.lib.Disk.ops.c a = a(ol(str), DiskFileOperate.Action.WRITE_FORCE);
        a.O(z);
        if (oL != null) {
            a.P(oM(str));
        } else {
            a.P(true);
        }
        a.setData(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(a);
            aVar.Bk = eVar;
        }
        com.baidu.adp.lib.Disk.d.gC().c(a);
    }

    public static byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String oL = oL(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c a = a(ol(str), DiskFileOperate.Action.READ);
        a.q(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(a);
            aVar.Bk = eVar;
        }
        if (com.baidu.adp.lib.Disk.d.gC().c(a)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.kd()) {
                i = 500;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (a.isSuccess()) {
                if (oL == null || a.gY() || !oM(str)) {
                    return a.gZ();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String ol(String str) {
        String oL = oL(str);
        if (oL != null) {
            str = oL;
        }
        return as.ol(str);
    }

    public static boolean oK(String str) {
        String ol = ol(str);
        if (TextUtils.isEmpty(ol)) {
            return false;
        }
        return a(ol, DiskFileOperate.Action.INFO).gD();
    }

    private static String oL(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.k.rp(str)) {
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

    private static boolean oM(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.k.rp(str)) {
            String[] split2 = str.split("/");
            if (split2.length > 3) {
                try {
                    String[] split3 = URLDecoder.decode(split2[split2.length - 3], "utf-8").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    for (String str2 : split3) {
                        if (str2.startsWith(IXAdRequestInfo.COST_NAME)) {
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
