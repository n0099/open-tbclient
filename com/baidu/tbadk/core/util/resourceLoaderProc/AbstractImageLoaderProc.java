package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.bh;
import com.baidu.tieba.dh;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.jq4;
import com.baidu.tieba.l85;
import com.baidu.tieba.lc;
import com.baidu.tieba.pc;
import com.baidu.tieba.pn;
import com.baidu.tieba.sh5;
import com.baidu.tieba.tg;
import com.baidu.tieba.xg;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes3.dex */
public abstract class AbstractImageLoaderProc implements bh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean checkBitmapValid(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) ? bitmap != null : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bh
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

    public abstract boolean isFromCDN();

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

    @Override // com.baidu.tieba.bh
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return jq4.c().g();
        }
        return invokeV.booleanValue;
    }

    public static boolean isImageFileExist(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            pc pcVar = new pc("images", TbMd5.getNameMd5FromUrl(ah.h().g(str, i)), DiskFileOperate.Action.INFO);
            pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            pcVar.setSubFolder(true);
            pcVar.setIsFormatData(false);
            pcVar.setSdCard(false);
            pcVar.setSavedCache(true);
            return pcVar.call();
        }
        return invokeLI.booleanValue;
    }

    public static pn loadBdImageFromLocal(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g = ah.h().g(str, i);
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g);
            if (i == 38) {
                return ImageLoaderProc.readGifFromDisk(nameMd5FromUrl, null, str, "AbstractImageLoaderProc.loadBdImageFromLocal", 0, 0);
            }
            pc pcVar = new pc("images", nameMd5FromUrl, DiskFileOperate.Action.READ);
            pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            pcVar.setSubFolder(true);
            pcVar.setIsFormatData(false);
            pcVar.setSavedCache(true);
            pcVar.setSdCard(false);
            if (!lc.f().call(pcVar) || !pcVar.isSuccess()) {
                return null;
            }
            pcVar.formatData(pcVar.getData());
            Bitmap bitmap = pcVar.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new pn(bitmap, pcVar.isGif(), g);
        }
        return (pn) invokeLI.objValue;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) {
            return BitmapHelper.checkBitmapSize(bitmap, i, i2);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public pn decodeToResourceWithWH(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, bArr, i, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeByteArray = BitmapHelper.decodeByteArray(bArr, i, i2);
            if (decodeByteArray != null) {
                z = true;
            } else {
                z = false;
            }
            xg.c(z, System.currentTimeMillis() - currentTimeMillis);
            return new pn(decodeByteArray);
        }
        return (pn) invokeLII.objValue;
    }

    public pc createDiskPicOperate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new pc("images", str, DiskFileOperate.Action.READ);
        }
        return (pc) invokeL.objValue;
    }

    public pn createImageFromDiskPicOperate(pc pcVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, pcVar, str, i, i2)) == null) {
            if (pcVar == null) {
                return null;
            }
            pcVar.b(pcVar.getData(), i, i2);
            Bitmap checkBitmapSize = checkBitmapSize(pcVar.getBitmap(), i, i2);
            if (checkBitmapSize == null) {
                return null;
            }
            return new pn(checkBitmapSize, pcVar.isGif(), str);
        }
        return (pn) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public pn m41decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bArr, objArr)) == null) {
            return decodeToResourceWithWH(bArr, fj.k(TbadkCoreApplication.getInst()), fj.i(TbadkCoreApplication.getInst()));
        }
        return (pn) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromLocal(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            byte[] bArr = new byte[0];
            pc createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            pn pnVar = null;
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (ygVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                ygVar.a = diskCancelWorker;
            }
            if (!lc.f().a(createDiskPicOperate)) {
                xg.f(false, 0L);
                return null;
            }
            int i3 = 2000;
            if (BdNetTypeUtil.isWifiNet()) {
                i3 = 300;
            }
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
                i = fj.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i2 == 0) {
                i2 = fj.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (createDiskPicOperate.isSuccess()) {
                pnVar = createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2);
            }
            if (pnVar != null) {
                z = true;
            }
            xg.f(z, System.currentTimeMillis() - currentTimeMillis);
            return pnVar;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            pn m = l85.k().m(str);
            if (z) {
                if (m != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                xg.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return m;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0138 A[Catch: all -> 0x0167, TryCatch #0 {all -> 0x0167, blocks: (B:47:0x0106, B:49:0x0128, B:54:0x0132, B:56:0x0138, B:58:0x0163), top: B:123:0x0106 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0162  */
    @Override // com.baidu.tieba.bh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public pn getFromRemote(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        String urlbyClientServerAddr;
        String str3;
        boolean z;
        WebClient webClient;
        int i5;
        boolean z2;
        boolean z3;
        byte[] bArr;
        boolean z4;
        String str4;
        boolean z5;
        int i6;
        String str5;
        int i7;
        int i8;
        Bitmap p;
        byte[] bArr2;
        boolean z6;
        boolean z7;
        boolean z8;
        WebClient webClient2;
        boolean z9;
        pn pnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 0) {
                i3 = getSuggestWidth();
            } else {
                i3 = i;
            }
            if (i2 == 0) {
                i4 = getSuggestHeight();
            } else {
                i4 = i2;
            }
            if (i3 == 0) {
                i3 = fj.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i9 = i3;
            if (i4 == 0) {
                i4 = fj.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            int i10 = i4;
            boolean isFromCDN = isFromCDN();
            if (isFromCDN) {
                urlbyClientServerAddr = str;
            } else {
                urlbyClientServerAddr = getUrlbyClientServerAddr(str, i9, i10);
            }
            sh5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair d = sh5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                str3 = (String) d.second;
                z = true;
            } else {
                str3 = urlbyClientServerAddr;
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (ygVar != null) {
                ygVar.a = webClient3;
            }
            byte[] downloadImageBytes = webClient3.downloadImageBytes(str3, !isFromCDN);
            boolean needCache = webClient3.needCache();
            Rect rect = new Rect();
            if (!webClient3.IsRequestSuccess()) {
                if (webClient3.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    xg.j(false, str3, webClient3.mStat, 0L, 0L);
                    if (webClient3.mStat != null) {
                        webClient2 = webClient3;
                        z8 = needCache;
                        ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient3.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient3.isMobileProxy(), getProcType());
                    } else {
                        z8 = needCache;
                        webClient2 = webClient3;
                    }
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080bf4, new TypedValue());
                        byte[] d2 = tg.d(openRawResource);
                        Bitmap Bytes2NineBitmap = BitmapHelper.Bytes2NineBitmap(d2, rect);
                        WebClient webClient4 = webClient2;
                        if (!webClient4.isGif && !fj.B(d2)) {
                            z9 = false;
                            if (!checkBitmapValid(Bytes2NineBitmap)) {
                                pnVar = new pn(Bytes2NineBitmap, z9, str, rect);
                                boolean z10 = z8;
                                pnVar.y(z10);
                                storeLocal(str2, d2, Boolean.valueOf(z10), Boolean.valueOf(webClient4.isCrackPic), Boolean.valueOf(z9), ygVar, Bytes2NineBitmap);
                            } else {
                                pnVar = null;
                            }
                            dh.c(openRawResource);
                            return pnVar;
                        }
                        z9 = true;
                        if (!checkBitmapValid(Bytes2NineBitmap)) {
                        }
                        dh.c(openRawResource);
                        return pnVar;
                    } catch (Throwable th) {
                        BdLog.e(th);
                        return null;
                    }
                }
                webClient = webClient3;
                i5 = 1;
                z2 = needCache;
                if (!webClient.getResponse().a) {
                    xg.j(false, str3, webClient.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
            } else {
                webClient = webClient3;
                i5 = 1;
                z2 = needCache;
            }
            if (downloadImageBytes == null) {
                if (!webClient.getResponse().a) {
                    xg.j(false, str3, webClient.mStat, 0L, 0L);
                    ImageLogger.imagePerfNetLog(str, false, str3, Boolean.valueOf(z), webClient.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (downloadImageBytes.length > i5) {
                z3 = true;
            } else {
                z3 = false;
            }
            String str6 = urlbyClientServerAddr;
            xg.j(z3, str3, webClient.mStat, currentTimeMillis2, downloadImageBytes.length);
            if (downloadImageBytes.length > 1) {
                ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                z4 = z2;
                str4 = str3;
                bArr = downloadImageBytes;
                str5 = str6;
                z5 = isFromCDN;
                i6 = i10;
                ImageLogger.imagePerfNetLog(str, true, str3, Boolean.valueOf(z), webClient.mStat, "InputToByteSucc", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            } else {
                bArr = downloadImageBytes;
                z4 = z2;
                str4 = str3;
                z5 = isFromCDN;
                i6 = i10;
                str5 = str6;
                ImageLogger.imagePerfNetLog(str, false, str4, Boolean.valueOf(z), webClient.mStat, "bytes<1", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            }
            byte[] bArr3 = bArr;
            l85.k().i(TbConfig.getPbImageSize() + bArr3.length);
            if (getProcType() == 19) {
                i8 = 1;
                p = m41decodeToResource(bArr3, rect).p();
                i7 = i9;
            } else {
                i7 = i9;
                i8 = 1;
                p = decodeToResourceWithWH(bArr3, i7, i6).p();
            }
            if (z && p == null) {
                sh5.b(str4);
                byte[] downloadImageBytes2 = webClient.downloadImageBytes(str5, !z5);
                boolean needCache2 = webClient.needCache();
                if (downloadImageBytes2 != null && webClient.IsRequestSuccess()) {
                    if (getProcType() == 19) {
                        Object[] objArr2 = new Object[i8];
                        objArr2[0] = rect;
                        p = m41decodeToResource(downloadImageBytes2, objArr2).p();
                    } else {
                        p = decodeToResourceWithWH(downloadImageBytes2, i7, i6).p();
                    }
                }
                bArr2 = downloadImageBytes2;
                z6 = needCache2;
            } else {
                bArr2 = bArr3;
                z6 = z4;
            }
            if (bArr2 != null && p != null) {
                if (!webClient.isGif && !fj.B(bArr2)) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                Bitmap resizeBitmapSize = resizeBitmapSize(p, i7, i6);
                if (resizeBitmapSize != null && checkBitmapValid(resizeBitmapSize)) {
                    pn pnVar2 = new pn(resizeBitmapSize, z7, str, rect);
                    pnVar2.y(z6);
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = Boolean.valueOf(z6);
                    objArr3[i8] = Boolean.valueOf(webClient.isCrackPic);
                    objArr3[2] = Boolean.valueOf(z7);
                    objArr3[3] = ygVar;
                    objArr3[4] = resizeBitmapSize;
                    storeLocal(str2, bArr2, objArr3);
                    return pnVar2;
                }
                return null;
            }
            return null;
        }
        return (pn) invokeCommon.objValue;
    }

    public String getUrlbyClientServerAddr(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, str, i, i2)) == null) {
            StringBuilder sb = new StringBuilder(100);
            if (str.startsWith(TbConfig.IMAGE_ADDRESS)) {
                return str;
            }
            if (str.startsWith(TbDomainConfig.DOMAIN_HTTPS_STATIC_SERVER)) {
                return str;
            }
            sb.append(TbConfig.IMAGE_ADDRESS);
            sb.append("src=");
            sb.append(ej.getUrlEncode(str));
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

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, str, bArr, objArr) == null) && !TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                pc pcVar = new pc("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                pcVar.setSubFolder(true);
                pcVar.setData(bArr);
                pcVar.setSdCard(false);
                pcVar.setSavedCache(true);
                pcVar.setGif(booleanValue3);
                lc.f().a(pcVar);
                yg ygVar = (yg) objArr[3];
                if (ygVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(pcVar);
                    ygVar.a = diskCancelWorker;
                }
            }
        }
    }

    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048597, this, bitmap, i, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
                l85.k().i(BitmapHelper.getBitmapSize(bitmap) * 2);
                return BitmapHelper.resizeBitmap(bitmap, i, i2, true);
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // com.baidu.tieba.bh
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof pn)) {
            pn pnVar = (pn) obj;
            if (pnVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                pnVar.A(i);
                pnVar.z(i2);
                l85.k().d(str, pnVar);
                xg.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }
}
