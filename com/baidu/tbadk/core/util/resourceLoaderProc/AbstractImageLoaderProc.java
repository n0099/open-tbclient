package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bg;
import com.repackage.cn4;
import com.repackage.fg;
import com.repackage.fo;
import com.repackage.gg;
import com.repackage.h35;
import com.repackage.ig;
import com.repackage.jg;
import com.repackage.lg;
import com.repackage.mi;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.rb;
import com.repackage.vb;
import java.io.InputStream;
/* loaded from: classes3.dex */
public abstract class AbstractImageLoaderProc implements jg<fo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractImageLoaderProc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isImageFileExist(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(ig.h().g(str, i)), DiskFileOperate.Action.INFO);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setSubFolder(true);
            vbVar.setIsFormatData(false);
            vbVar.setSdCard(false);
            vbVar.setSavedCache(true);
            return vbVar.call();
        }
        return invokeLI.booleanValue;
    }

    public static fo loadBdImageFromLocal(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g = ig.h().g(str, i);
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g);
            if (i == 38) {
                return ImageLoaderProc.readGifFromDisk(nameMd5FromUrl, null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
            }
            vb vbVar = new vb("images", nameMd5FromUrl, DiskFileOperate.Action.READ);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setSubFolder(true);
            vbVar.setIsFormatData(false);
            vbVar.setSavedCache(true);
            vbVar.setSdCard(false);
            if (rb.f().call(vbVar) && vbVar.isSuccess()) {
                vbVar.formatData(vbVar.getData());
                Bitmap bitmap = vbVar.getBitmap();
                if (bitmap != null) {
                    return new fo(bitmap, vbVar.isGif(), g);
                }
                return null;
            }
            return null;
        }
        return (fo) invokeLI.objValue;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) ? BitmapHelper.checkBitmapSize(bitmap, i, i2) : (Bitmap) invokeLII.objValue;
    }

    public boolean checkBitmapValid(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? bitmap != null : invokeL.booleanValue;
    }

    public vb createDiskPicOperate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new vb("images", str, DiskFileOperate.Action.READ) : (vb) invokeL.objValue;
    }

    public fo createImageFromDiskPicOperate(vb vbVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, vbVar, str, i, i2)) == null) {
            if (vbVar == null) {
                return null;
            }
            vbVar.b(vbVar.getData(), i, i2);
            Bitmap checkBitmapSize = checkBitmapSize(vbVar.getBitmap(), i, i2);
            if (checkBitmapSize != null) {
                return new fo(checkBitmapSize, vbVar.isGif(), str);
            }
            return null;
        }
        return (fo) invokeLLII.objValue;
    }

    public fo decodeToResourceWithWH(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, i, i2);
            fg.c(decodeByteArray != null, System.currentTimeMillis() - currentTimeMillis);
            return new fo(decodeByteArray);
        }
        return (fo) invokeLII.objValue;
    }

    @Override // com.repackage.jg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.jg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public abstract int getProcType();

    public abstract int getSuggestHeight();

    public abstract int getSuggestWidth();

    public String getUrlbyClientServerAddr(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, str, i, i2)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (str.startsWith(TbConfig.IMAGE_ADDRESS)) {
                return str;
            }
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ni.getUrlEncode(str));
            sb.append("&width=");
            sb.append(String.valueOf(i));
            sb.append("&height=");
            sb.append(String.valueOf(i2));
            sb.append("&imgtype=0");
            sb.append("&qulity=" + TbImageHelper.getInstance().getUrlQuality());
            sb.append("&first_gif=1");
            return sb.toString();
        }
        return (String) invokeLII.objValue;
    }

    public abstract boolean isFromCDN();

    @Override // com.repackage.jg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? cn4.c().g() : invokeV.booleanValue;
    }

    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, bitmap, i, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                h35.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
                return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048598, this, str, bArr, objArr) == null) || TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        if (!booleanValue || booleanValue2) {
            return;
        }
        boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
        vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        vbVar.setSubFolder(true);
        vbVar.setData(bArr);
        vbVar.setSdCard(false);
        vbVar.setSavedCache(true);
        vbVar.setGif(booleanValue3);
        rb.f().a(vbVar);
        gg ggVar = (gg) objArr[3];
        if (ggVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(vbVar);
            ggVar.a = diskCancelWorker;
        }
    }

    @Override // com.repackage.jg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof fo)) {
            fo foVar = (fo) obj;
            if (foVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                foVar.A(i);
                foVar.z(i2);
                h35.k().d(str, foVar);
                fg.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public fo m43decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bArr, objArr)) == null) ? decodeToResourceWithWH(bArr, oi.k(TbadkCoreApplication.getInst()), oi.i(TbadkCoreApplication.getInst())) : (fo) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.jg
    public fo getFromLocal(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[0];
            vb createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (ggVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                ggVar.a = diskCancelWorker;
            }
            if (!rb.f().a(createDiskPicOperate)) {
                fg.f(false, 0L);
                return null;
            }
            int i3 = mi.H() ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException unused) {
                }
            }
            if (i == 0) {
                i = getSuggestWidth();
            }
            if (i2 == 0) {
                i2 = getSuggestHeight();
            }
            if (i == 0) {
                i = oi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i2 == 0) {
                i2 = oi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            fo createImageFromDiskPicOperate = createDiskPicOperate.isSuccess() ? createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2) : null;
            fg.f(createImageFromDiskPicOperate != null, System.currentTimeMillis() - currentTimeMillis);
            return createImageFromDiskPicOperate;
        }
        return (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.jg
    public fo getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            fo m = h35.k().m(str);
            if (z) {
                fg.i(m != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (fo) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0176 A[Catch: all -> 0x01a5, TryCatch #0 {all -> 0x01a5, blocks: (B:59:0x0146, B:61:0x0166, B:66:0x0170, B:68:0x0176, B:70:0x01a1), top: B:136:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0226  */
    @Override // com.repackage.jg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public fo getFromRemote(String str, String str2, int i, int i2, gg ggVar, Object... objArr) {
        InterceptResult invokeCommon;
        String str3;
        boolean z;
        WebClient webClient;
        byte[] downloadImageBytes;
        boolean z2;
        WebClient webClient2;
        int i3;
        char c;
        byte[] bArr;
        boolean z3;
        String str4;
        int i4;
        int i5;
        int i6;
        Bitmap p;
        Bitmap bitmap;
        boolean z4;
        boolean z5;
        WebClient webClient3;
        char c2;
        boolean z6;
        fo foVar;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ggVar, objArr})) != null) {
            return (fo) invokeCommon.objValue;
        }
        if (StringUtils.isNull(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int suggestWidth = i == 0 ? getSuggestWidth() : i;
        int suggestHeight = i2 == 0 ? getSuggestHeight() : i2;
        if (suggestWidth == 0) {
            suggestWidth = oi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        int i7 = suggestWidth;
        if (suggestHeight == 0) {
            suggestHeight = oi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
        }
        int i8 = suggestHeight;
        boolean isFromCDN = isFromCDN();
        String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, i7, i8);
        if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
            int indexOf = urlbyClientServerAddr.indexOf("hiphotos.baidu.com");
            if (indexOf <= 0) {
                indexOf = urlbyClientServerAddr.indexOf("tiebapic.baidu.com");
            }
            if (indexOf > 0 && (lastIndexOf = urlbyClientServerAddr.lastIndexOf(".jpg")) > 0) {
                str3 = urlbyClientServerAddr.substring(0, lastIndexOf) + ".webp" + urlbyClientServerAddr.substring(lastIndexOf + 4, urlbyClientServerAddr.length());
                z = true;
                webClient = new WebClient();
                if (ggVar != null) {
                    ggVar.a = webClient;
                }
                downloadImageBytes = webClient.downloadImageBytes(str3, !isFromCDN);
                boolean needCache = webClient.needCache();
                Rect rect = new Rect();
                if (!webClient.IsRequestSuccess()) {
                    z2 = needCache;
                    webClient2 = webClient;
                    i3 = 1;
                    c = 0;
                } else if (webClient.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    fg.j(false, str3, webClient.mStat, 0L, 0L);
                    if (webClient.mStat != null) {
                        z5 = needCache;
                        webClient3 = webClient;
                        c2 = 0;
                        ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    } else {
                        z5 = needCache;
                        webClient3 = webClient;
                        c2 = 0;
                    }
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080b77, new TypedValue());
                        byte[] d = bg.d(openRawResource);
                        Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(d, rect);
                        if (!webClient3.isGif && !oi.A(d)) {
                            z6 = false;
                            if (checkBitmapValid(Bytes2NineBitmap)) {
                                foVar = null;
                            } else {
                                foVar = new fo(Bytes2NineBitmap, z6, str, rect);
                                boolean z7 = z5;
                                foVar.y(z7);
                                Object[] objArr2 = new Object[5];
                                objArr2[c2] = Boolean.valueOf(z7);
                                objArr2[1] = Boolean.valueOf(webClient3.isCrackPic);
                                objArr2[2] = Boolean.valueOf(z6);
                                objArr2[3] = ggVar;
                                objArr2[4] = Bytes2NineBitmap;
                                storeLocal(str2, d, objArr2);
                            }
                            lg.c(openRawResource);
                            return foVar;
                        }
                        z6 = true;
                        if (checkBitmapValid(Bytes2NineBitmap)) {
                        }
                        lg.c(openRawResource);
                        return foVar;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                } else {
                    z2 = needCache;
                    webClient2 = webClient;
                    i3 = 1;
                    c = 0;
                    if (!webClient2.getResponse().a) {
                        fg.j(false, str3, webClient2.mStat, 0L, 0L);
                        ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient2.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient2.isMobileProxy(), getProcType());
                        return null;
                    }
                }
                if (downloadImageBytes != null) {
                    if (webClient2.getResponse().a) {
                        return null;
                    }
                    fg.j(false, str3, webClient2.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient2.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient2.isMobileProxy(), getProcType());
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                fg.j(downloadImageBytes.length > i3, str3, webClient2.mStat, currentTimeMillis2, downloadImageBytes.length);
                if (downloadImageBytes.length > 1) {
                    ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                    bArr = downloadImageBytes;
                    z3 = z2;
                    str4 = urlbyClientServerAddr;
                    i4 = i8;
                    ImageLogger.imagePerfNetLog(str, true, str3, Boolean.valueOf(z), webClient2.mStat, "InputToByteSucc", currentTimeMillis2, webClient2.isMobileProxy(), getProcType());
                } else {
                    bArr = downloadImageBytes;
                    z3 = z2;
                    str4 = urlbyClientServerAddr;
                    i4 = i8;
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient2.mStat, "bytes<1", currentTimeMillis2, webClient2.isMobileProxy(), getProcType());
                }
                byte[] bArr2 = bArr;
                h35.k().i(TbConfig.getPbImageSize() + bArr2.length);
                if (getProcType() == 19) {
                    i6 = 1;
                    Object[] objArr3 = new Object[1];
                    objArr3[c] = rect;
                    p = m43decodeToResource(bArr2, objArr3).p();
                    i5 = i7;
                } else {
                    i5 = i7;
                    i6 = 1;
                    p = decodeToResourceWithWH(bArr2, i5, i4).p();
                }
                if (z && p == null) {
                    TbadkCoreApplication.getInst().incWebpFailureCount();
                    bArr2 = webClient2.downloadImageBytes(str4, !isFromCDN);
                    z4 = webClient2.needCache();
                    if (bArr2 != null && webClient2.IsRequestSuccess()) {
                        if (getProcType() == 19) {
                            Object[] objArr4 = new Object[i6];
                            objArr4[c] = rect;
                            p = m43decodeToResource(bArr2, objArr4).p();
                        } else {
                            p = decodeToResourceWithWH(bArr2, i5, i4).p();
                        }
                    }
                    bitmap = p;
                } else {
                    bitmap = p;
                    z4 = z3;
                }
                byte[] bArr3 = bArr2;
                if (bArr3 == null || bitmap == null) {
                    return null;
                }
                boolean z8 = webClient2.isGif || oi.A(bArr3);
                Bitmap resizeBitmapSize = resizeBitmapSize(bitmap, i5, i4);
                if (resizeBitmapSize != null && checkBitmapValid(resizeBitmapSize)) {
                    fo foVar2 = new fo(resizeBitmapSize, z8, str, rect);
                    foVar2.y(z4);
                    Object[] objArr5 = new Object[5];
                    objArr5[c] = Boolean.valueOf(z4);
                    objArr5[i6] = Boolean.valueOf(webClient2.isCrackPic);
                    objArr5[2] = Boolean.valueOf(z8);
                    objArr5[3] = ggVar;
                    objArr5[4] = resizeBitmapSize;
                    storeLocal(str2, bArr3, objArr5);
                    return foVar2;
                }
                return null;
            }
        }
        str3 = urlbyClientServerAddr;
        z = false;
        webClient = new WebClient();
        if (ggVar != null) {
        }
        downloadImageBytes = webClient.downloadImageBytes(str3, !isFromCDN);
        boolean needCache2 = webClient.needCache();
        Rect rect2 = new Rect();
        if (!webClient.IsRequestSuccess()) {
        }
        if (downloadImageBytes != null) {
        }
    }
}
