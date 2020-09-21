package com.baidu.tbadk.core.util.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.e.e<com.baidu.adp.widget.ImageView.a> {
    private int procType;

    public int bkF() {
        return this.procType;
    }

    public c(int i) {
        this.procType = 0;
        this.procType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, Object... objArr) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        byte[] bArr;
        boolean booleanValue = Boolean.valueOf(String.valueOf(objArr[0])).booleanValue();
        byte[] bArr2 = (byte[]) objArr[1];
        Bitmap Bytes2Bitmap = bArr2 != null ? BitmapHelper.Bytes2Bitmap(bArr2) : null;
        if (Bytes2Bitmap == null) {
            if (booleanValue && str.startsWith("/")) {
                Bytes2Bitmap = com.baidu.adp.lib.util.d.oh().getImageAbsolutePath(str);
                if (Bytes2Bitmap != null && bArr2 == null) {
                    bArr = com.baidu.adp.lib.util.d.oh().Bitmap2Bytes(Bytes2Bitmap, 100);
                }
            } else {
                bArr = a(str, aVar);
                if (bArr != null) {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                }
            }
            if (Bytes2Bitmap == null) {
                return new com.baidu.adp.widget.ImageView.a(Bytes2Bitmap, com.baidu.adp.lib.util.l.isGif(bArr), str2, bArr);
            }
            return null;
        }
        bArr = bArr2;
        if (Bytes2Bitmap == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d4  */
    @Override // com.baidu.adp.lib.e.e
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.adp.widget.ImageView.a a(String str, String str2, int i, int i2, BdAsyncTask<?, ?, ?> bdAsyncTask, com.baidu.adp.lib.e.a aVar, Object... objArr) {
        boolean z;
        String str3;
        com.baidu.tbadk.core.util.a.i iVar;
        boolean bkz;
        byte[] bArr;
        Bitmap Bytes2Bitmap;
        Bitmap bitmap;
        byte[] bArr2;
        boolean z2;
        int lastIndexOf;
        if (str != null && str.startsWith("/")) {
            return null;
        }
        boolean booleanValue = (str == null || !str.startsWith("width=")) ? Boolean.valueOf(String.valueOf(objArr[2])).booleanValue() : false;
        String str4 = booleanValue ? str : TbConfig.IMAGE_ADDRESS + ((str + "&imgtype=0") + "&qulity=" + au.bkm().getUrlQuality());
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = str4.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = str4.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = str4.lastIndexOf(".jpg")) > 0) {
                z = true;
                str3 = str4.substring(0, lastIndexOf) + ".webp" + str4.substring(lastIndexOf + 4, str4.length());
                iVar = new com.baidu.tbadk.core.util.a.i();
                if (aVar != null) {
                    aVar.My = iVar;
                }
                byte[] aq = iVar.aq(str3, booleanValue);
                bkz = iVar.bkz();
                if (iVar.bky() && iVar.errorCode == -11) {
                    BdLog.e("BIGIMAGE imagesize too big");
                    com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "BigImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str3);
                }
                if (iVar.responseCode == 302 || !(17 == bkF() || 18 == bkF() || 13 == bkF() || 14 == bkF())) {
                    bArr = aq;
                } else {
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete_big2, new TypedValue());
                        bArr = com.baidu.adp.lib.network.a.b.f(openRawResource);
                        com.baidu.adp.lib.f.a.close(openRawResource);
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                }
                if (iVar.bky() && iVar.responseCode != 302) {
                    bArr2 = bArr;
                    bitmap = null;
                    z2 = bkz;
                } else {
                    Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
                    if (z || Bytes2Bitmap != null) {
                        bitmap = Bytes2Bitmap;
                        bArr2 = bArr;
                        z2 = bkz;
                    } else {
                        TiebaStatic.imgError(-1012, "Webp decoding failed.", str3);
                        TbadkCoreApplication.getInst().incWebpFailureCount();
                        byte[] aq2 = iVar.aq(str4, !booleanValue);
                        boolean bkz2 = iVar.bkz();
                        if (aq2 == null || !iVar.bky()) {
                            bitmap = Bytes2Bitmap;
                            bArr2 = aq2;
                            z2 = bkz2;
                        } else {
                            bitmap = BitmapHelper.Bytes2Bitmap(aq2);
                            bArr2 = aq2;
                            z2 = bkz2;
                        }
                    }
                }
                if (z2 && !iVar.eoz) {
                    a(str, bArr2, false, aVar);
                }
                com.baidu.adp.widget.ImageView.a aVar2 = new com.baidu.adp.widget.ImageView.a(bitmap, com.baidu.adp.lib.util.l.isGif(bArr2), str, bArr2);
                aVar2.setNeedCache(z2);
                return aVar2;
            }
        }
        z = false;
        str3 = str4;
        iVar = new com.baidu.tbadk.core.util.a.i();
        if (aVar != null) {
        }
        byte[] aq3 = iVar.aq(str3, booleanValue);
        bkz = iVar.bkz();
        if (iVar.bky()) {
            BdLog.e("BIGIMAGE imagesize too big");
            com.baidu.tbadk.core.d.a.a("gifplay", -1L, -1, "BigImageLoaderProc.getFromRemote", iVar.errorCode, "image size too large", "url", str3);
        }
        if (iVar.responseCode == 302) {
        }
        bArr = aq3;
        if (iVar.bky()) {
        }
        Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(bArr);
        if (z) {
        }
        bitmap = Bytes2Bitmap;
        bArr2 = bArr;
        z2 = bkz;
        if (z2) {
            a(str, bArr2, false, aVar);
        }
        com.baidu.adp.widget.ImageView.a aVar22 = new com.baidu.adp.widget.ImageView.a(bitmap, com.baidu.adp.lib.util.l.isGif(bArr2), str, bArr2);
        aVar22.setNeedCache(z2);
        return aVar22;
    }

    @Override // com.baidu.adp.lib.e.e
    public boolean mU() {
        return true;
    }

    @Override // com.baidu.adp.lib.e.e
    public void a(String str, Object obj, int i, int i2, Object... objArr) {
    }

    @Override // com.baidu.adp.lib.e.e
    public BdAsyncTaskParallel mV() {
        return null;
    }

    @Override // com.baidu.adp.lib.e.e
    public int mW() {
        return 1;
    }

    private static com.baidu.adp.lib.Disk.ops.c a(String str, DiskFileOperate.Action action) {
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, str, action);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        return cVar;
    }

    public static void a(String str, byte[] bArr, boolean z, com.baidu.adp.lib.e.a aVar) {
        String AP = AP(str);
        com.baidu.adp.lib.Disk.ops.c a = a(getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
        a.setGif(z);
        if (AP != null) {
            a.setHighQuality(AQ(str));
        } else {
            a.setHighQuality(true);
        }
        a.setData(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(a);
            aVar.My = eVar;
        }
        com.baidu.adp.lib.Disk.d.lK().c(a);
    }

    public static byte[] a(String str, com.baidu.adp.lib.e.a aVar) {
        String AP = AP(str);
        byte[] bArr = new byte[0];
        com.baidu.adp.lib.Disk.ops.c a = a(getNameMd5FromUrl(str), DiskFileOperate.Action.READ);
        a.setLock(bArr);
        if (aVar != null) {
            e eVar = new e();
            eVar.f(a);
            aVar.My = eVar;
        }
        if (com.baidu.adp.lib.Disk.d.lK().c(a)) {
            int i = 2000;
            if (com.baidu.adp.lib.util.j.isWifiNet()) {
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
                if (AP == null || a.isHighQuality() || !AQ(str)) {
                    return a.getFormatedData();
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String getNameMd5FromUrl(String str) {
        String AP = AP(str);
        if (AP != null) {
            str = AP;
        }
        return av.getNameMd5FromUrl(str);
    }

    public static boolean AO(String str) {
        String nameMd5FromUrl = getNameMd5FromUrl(str);
        if (TextUtils.isEmpty(nameMd5FromUrl)) {
            return false;
        }
        return a(nameMd5FromUrl, DiskFileOperate.Action.INFO).call();
    }

    private static String AP(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (com.baidu.tbadk.util.n.isCdn(str)) {
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

    private static boolean AQ(String str) {
        String[] split;
        if (str != null && com.baidu.tbadk.util.n.isCdn(str)) {
            String[] split2 = str.split("/");
            if (split2.length > 3) {
                try {
                    String[] split3 = URLDecoder.decode(split2[split2.length - 3], "utf-8").split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                    for (String str2 : split3) {
                        if (str2.startsWith(IXAdRequestInfo.COST_NAME)) {
                            if (Integer.valueOf(str2.split(ETAG.EQUAL)[split.length - 1]).intValue() <= 50) {
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
