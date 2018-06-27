package com.baidu.tbadk.core.util.d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.d;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.f.e<com.baidu.adp.widget.ImageView.a> {
    private int procType;

    public int Am() {
        return this.procType;
    }

    public c(int i) {
        this.procType = 0;
        this.procType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.e
    /* renamed from: g */
    public com.baidu.adp.widget.ImageView.a f(String str, String str2, Object... objArr) {
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
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        byte[] bArr;
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr2 = (byte[]) objArr[1];
        Bitmap Bytes2Bitmap = bArr2 != null ? BitmapHelper.Bytes2Bitmap(bArr2) : null;
        if (Bytes2Bitmap == null) {
            if (booleanValue && str.startsWith("/")) {
                Bytes2Bitmap = com.baidu.adp.lib.util.d.jl().aQ(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.jl().Bitmap2Bytes(Bytes2Bitmap, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
            if (Bytes2Bitmap == null) {
                return new com.baidu.adp.widget.ImageView.a(Bytes2Bitmap, com.baidu.adp.lib.util.l.m(bArr), str2, bArr);
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
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.f.a aVar, Object... objArr) {
        boolean z;
        String str3;
        byte[] bArr;
        Bitmap bitmap;
        int lastIndexOf;
        if (str != null && str.startsWith("/")) {
            return null;
        }
        boolean booleanValue = (str == null || !str.startsWith("width=")) ? Boolean.valueOf(String.valueOf(objArr[2])).booleanValue() : false;
        String str4 = booleanValue ? str : TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + ar.zF().zK());
        if (!(TbadkCoreApplication.getInst().getCapabilityOfWebp() && com.baidu.adp.lib.b.d.hv().aw("webp_enable") == 1) || str4.indexOf("hiphotos.baidu.com") <= 0 || (lastIndexOf = str4.lastIndexOf(".jpg")) <= 0) {
            z = false;
            str3 = str4;
        } else {
            z = true;
            str3 = str4.substring(0, lastIndexOf) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
        }
        com.baidu.tbadk.core.util.a.i iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
            aVar.As = iVar;
        }
        byte[] j = iVar.j(str3, !booleanValue);
        if (iVar.Af() && iVar.errorCode == -11) {
            BdLog.e("BIGIMAGE imagesize too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "BigImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str3);
        }
        if (iVar.responseCode == 302 && (17 == Am() || 18 == Am() || 13 == Am() || 14 == Am())) {
            try {
                InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(d.f.img_default_delete_big2, new TypedValue());
                bArr = com.baidu.adp.lib.network.a.b.e(openRawResource);
                com.baidu.adp.lib.g.a.f(openRawResource);
            } catch (Throwable th) {
                BdLog.e(th);
                return null;
            }
        } else {
            bArr = j;
        }
        if (!iVar.Af() && iVar.responseCode != 302) {
            bitmap = null;
        } else {
            Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
            if (z && Bytes2Bitmap == null) {
                TiebaStatic.imgError(TbErrInfo.ERR_IMG_DECODE_WEBP, "Webp decoding failed.", str3);
                TbadkCoreApplication.getInst().incWebpFailureCount();
                bArr = iVar.j(str4, !booleanValue);
                if (bArr != null && iVar.Af()) {
                    bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
            bitmap = Bytes2Bitmap;
        }
        if (!iVar.ate) {
            a(str, bArr, false, aVar);
        }
        return new com.baidu.adp.widget.ImageView.a(bitmap, com.baidu.adp.lib.util.l.m(bArr), str, bArr);
    }

    @Override // com.baidu.adp.lib.f.e
    public boolean ij() {
        return true;
    }

    @Override // com.baidu.adp.lib.f.e
    public void a(String str, Object obj, Object... objArr) {
    }

    public static void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.f.a aVar) {
        String fg = fg(str);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eO(fg == null ? str : fg), DiskFileOperate.Action.WRITE_FORCE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.w(true);
        cVar.A(z);
        cVar.y(false);
        cVar.z(true);
        if (fg != null) {
            cVar.B(fh(str));
        } else {
            cVar.B(true);
        }
        cVar.setData(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.As = eVar;
        }
        com.baidu.adp.lib.Disk.d.gf().c(cVar);
    }

    public static byte[] a(String str, com.baidu.adp.lib.f.a aVar) {
        String fg = fg(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, as.eO(fg == null ? str : fg), DiskFileOperate.Action.READ);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.w(true);
        cVar.x(true);
        cVar.y(false);
        cVar.z(true);
        cVar.m(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(cVar);
            aVar.As = eVar;
        }
        if (com.baidu.adp.lib.Disk.d.gf().c(cVar)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.jE()) {
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
                if (fg == null || cVar.gC() || !fh(str)) {
                    return cVar.gD();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static boolean ff(String str) {
        String fg = fg(str);
        if (fg != null) {
            str = fg;
        }
        String eO = as.eO(str);
        if (TextUtils.isEmpty(eO)) {
            return false;
        }
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, eO, DiskFileOperate.Action.INFO);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.w(true);
        cVar.y(false);
        cVar.z(true);
        return cVar.gg();
    }

    @Override // com.baidu.adp.lib.f.e
    public BdAsyncTaskParallel ik() {
        return null;
    }

    @Override // com.baidu.adp.lib.f.e
    public int il() {
        return 1;
    }

    private static String fg(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.i.hz(str)) {
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

    private static boolean fh(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.i.hz(str)) {
            String[] split2 = str.split("/");
            if (split2.length > 3) {
                try {
                    String[] split3 = URLDecoder.decode(split2[split2.length - 3], IoUtils.UTF_8).split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
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
