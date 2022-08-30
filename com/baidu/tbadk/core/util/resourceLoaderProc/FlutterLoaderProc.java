package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tieba.R;
import com.baidu.tieba.ac;
import com.baidu.tieba.an;
import com.baidu.tieba.eg;
import com.baidu.tieba.jg;
import com.baidu.tieba.o55;
import com.baidu.tieba.og;
import com.baidu.tieba.pi;
import com.baidu.tieba.ri;
import com.baidu.tieba.ue5;
import com.baidu.tieba.wb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class FlutterLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isNeedFormat;
    public int procType;

    public FlutterLoaderProc(boolean z, int i, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isFromCDN = true;
        this.procType = 0;
        this.isNeedFormat = true;
        this.isFromCDN = z;
        this.procType = i;
        this.isNeedFormat = z2;
    }

    public an createImageByteFromDiskPicOperate(ac acVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, acVar, str, i, i2)) == null) {
            if (acVar == null) {
                return null;
            }
            an anVar = new an((Bitmap) null, false, str, acVar.getData());
            acVar.formatData(acVar.getData());
            Bitmap checkBitmapSize = checkBitmapSize(acVar.getBitmap(), i, i2);
            return checkBitmapSize != null ? new an(checkBitmapSize, acVar.isGif(), str) : anVar;
        }
        return (an) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.mg
    public an getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (an) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.procType : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ri.i(TbadkCoreApplication.getInst().getApp()) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? ri.k(TbadkCoreApplication.getInst().getApp()) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.isFromCDN : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) || TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        if (!booleanValue || booleanValue2) {
            return;
        }
        boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
        ac acVar = new ac("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        acVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        acVar.setSubFolder(true);
        acVar.setData(bArr);
        acVar.setSdCard(false);
        acVar.setSavedCache(true);
        acVar.setGif(booleanValue3);
        acVar.f(this.isNeedFormat);
        wb.f().a(acVar);
        jg jgVar = (jg) objArr[3];
        if (jgVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(acVar);
            jgVar.a = diskCancelWorker;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.mg
    public an getFromLocal(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            ac createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (jgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                jgVar.a = diskCancelWorker;
            }
            boolean H = pi.H();
            if (wb.f().a(createDiskPicOperate)) {
                int i3 = H ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (createDiskPicOperate.isSuccess()) {
                    return createImageByteFromDiskPicOperate(createDiskPicOperate, str2, i, i2);
                }
                return null;
            }
            return null;
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.mg
    public an getFromRemote(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        WebClient webClient;
        byte[] bArr;
        char c;
        boolean z3;
        WebClient webClient2;
        char c2;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int suggestWidth = i == 0 ? getSuggestWidth() : i;
            int suggestHeight = i2 == 0 ? getSuggestHeight() : i2;
            if (suggestWidth == 0) {
                suggestWidth = ri.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (suggestHeight == 0) {
                suggestHeight = ri.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            boolean isFromCDN = isFromCDN();
            String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, suggestWidth, suggestHeight);
            ue5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair<Boolean, String> d = ue5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                urlbyClientServerAddr = (String) d.second;
                z = true;
            } else {
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (jgVar != null) {
                jgVar.a = webClient3;
            }
            byte[] downloadImageBytes = webClient3.downloadImageBytes(urlbyClientServerAddr, !isFromCDN);
            boolean needCache = webClient3.needCache();
            if (webClient3.IsRequestSuccess()) {
                z2 = needCache;
                webClient = webClient3;
            } else if (webClient3.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                if (webClient3.mStat != null) {
                    z3 = needCache;
                    webClient2 = webClient3;
                    c2 = 1;
                    ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient3.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient3.isMobileProxy(), getProcType());
                } else {
                    z3 = needCache;
                    webClient2 = webClient3;
                    c2 = 1;
                }
                try {
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080bc4, new TypedValue());
                    byte[] d2 = eg.d(openRawResource);
                    try {
                        if (!webClient2.isGif && !ri.B(d2)) {
                            z4 = false;
                            an anVar = new an((Bitmap) null, z4, str, d2);
                            anVar.y(z3);
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(z3);
                            objArr2[c2] = Boolean.valueOf(webClient2.isCrackPic);
                            objArr2[2] = Boolean.valueOf(z4);
                            objArr2[3] = jgVar;
                            storeLocal(str2, d2, objArr2);
                            og.c(openRawResource);
                            return anVar;
                        }
                        storeLocal(str2, d2, objArr2);
                        og.c(openRawResource);
                        return anVar;
                    } catch (Throwable th) {
                        th = th;
                        BdLog.e(th);
                        return null;
                    }
                    z4 = true;
                    an anVar2 = new an((Bitmap) null, z4, str, d2);
                    anVar2.y(z3);
                    Object[] objArr22 = new Object[4];
                    objArr22[0] = Boolean.valueOf(z3);
                    objArr22[c2] = Boolean.valueOf(webClient2.isCrackPic);
                    objArr22[2] = Boolean.valueOf(z4);
                    objArr22[3] = jgVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                z2 = needCache;
                webClient = webClient3;
                if (!webClient.getResponse().a) {
                    ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient.mStat, "NetworkError", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
            }
            if (downloadImageBytes == null) {
                if (webClient.getResponse().a) {
                    return null;
                }
                ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (downloadImageBytes.length > 1) {
                ImageLoadSpeedRecorder.sharedInstance().addSpeedRecordItem(downloadImageBytes.length, currentTimeMillis2);
                bArr = downloadImageBytes;
                c = 1;
                ImageLogger.imagePerfNetLog(str, true, urlbyClientServerAddr, Boolean.valueOf(z), webClient.mStat, "InputToByteSucc", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            } else {
                bArr = downloadImageBytes;
                c = 1;
                ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient.mStat, "bytes<1", currentTimeMillis2, webClient.isMobileProxy(), getProcType());
            }
            byte[] bArr2 = bArr;
            o55.k().i(TbConfig.getPbImageSize() + bArr2.length);
            boolean z5 = webClient.isGif || ri.B(bArr2);
            an anVar3 = new an((Bitmap) null, z5, str, bArr2);
            anVar3.y(z2);
            Object[] objArr3 = new Object[4];
            objArr3[0] = Boolean.valueOf(z2);
            objArr3[c] = Boolean.valueOf(webClient.isCrackPic);
            objArr3[2] = Boolean.valueOf(z5);
            objArr3[3] = jgVar;
            storeLocal(str2, bArr2, objArr3);
            return anVar3;
        }
        return (an) invokeCommon.objValue;
    }
}
