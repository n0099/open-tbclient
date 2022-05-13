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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.co;
import com.repackage.dd5;
import com.repackage.eg;
import com.repackage.jg;
import com.repackage.ki;
import com.repackage.mi;
import com.repackage.rb;
import com.repackage.vb;
import com.repackage.y35;
import com.repackage.zf;
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

    public co createImageByteFromDiskPicOperate(vb vbVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, vbVar, str, i, i2)) == null) {
            if (vbVar == null) {
                return null;
            }
            co coVar = new co((Bitmap) null, false, str, vbVar.getData());
            vbVar.formatData(vbVar.getData());
            Bitmap checkBitmapSize = checkBitmapSize(vbVar.getBitmap(), i, i2);
            return checkBitmapSize != null ? new co(checkBitmapSize, vbVar.isGif(), str) : coVar;
        }
        return (co) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.repackage.hg
    public co getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (co) invokeCommon.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? mi.i(TbadkCoreApplication.getInst().getApp()) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? mi.k(TbadkCoreApplication.getInst().getApp()) : invokeV.intValue;
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
        vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        vbVar.setSubFolder(true);
        vbVar.setData(bArr);
        vbVar.setSdCard(false);
        vbVar.setSavedCache(true);
        vbVar.setGif(booleanValue3);
        vbVar.f(this.isNeedFormat);
        rb.f().a(vbVar);
        eg egVar = (eg) objArr[3];
        if (egVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(vbVar);
            egVar.a = diskCancelWorker;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.repackage.hg
    public co getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
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
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                egVar.a = diskCancelWorker;
            }
            boolean H = ki.H();
            if (rb.f().a(createDiskPicOperate)) {
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
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.repackage.hg
    public co getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int suggestWidth = i == 0 ? getSuggestWidth() : i;
            int suggestHeight = i2 == 0 ? getSuggestHeight() : i2;
            if (suggestWidth == 0) {
                suggestWidth = mi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (suggestHeight == 0) {
                suggestHeight = mi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            boolean isFromCDN = isFromCDN();
            String urlbyClientServerAddr = isFromCDN ? str : getUrlbyClientServerAddr(str, suggestWidth, suggestHeight);
            dd5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair<Boolean, String> d = dd5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                urlbyClientServerAddr = (String) d.second;
                z = true;
            } else {
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (egVar != null) {
                egVar.a = webClient3;
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
                    InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.obfuscated_res_0x7f080b96, new TypedValue());
                    byte[] d2 = zf.d(openRawResource);
                    try {
                        if (!webClient2.isGif && !mi.A(d2)) {
                            z4 = false;
                            co coVar = new co((Bitmap) null, z4, str, d2);
                            coVar.y(z3);
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(z3);
                            objArr2[c2] = Boolean.valueOf(webClient2.isCrackPic);
                            objArr2[2] = Boolean.valueOf(z4);
                            objArr2[3] = egVar;
                            storeLocal(str2, d2, objArr2);
                            jg.c(openRawResource);
                            return coVar;
                        }
                        storeLocal(str2, d2, objArr2);
                        jg.c(openRawResource);
                        return coVar;
                    } catch (Throwable th) {
                        th = th;
                        BdLog.e(th);
                        return null;
                    }
                    z4 = true;
                    co coVar2 = new co((Bitmap) null, z4, str, d2);
                    coVar2.y(z3);
                    Object[] objArr22 = new Object[4];
                    objArr22[0] = Boolean.valueOf(z3);
                    objArr22[c2] = Boolean.valueOf(webClient2.isCrackPic);
                    objArr22[2] = Boolean.valueOf(z4);
                    objArr22[3] = egVar;
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
            y35.k().i(TbConfig.getPbImageSize() + bArr2.length);
            boolean z5 = webClient.isGif || mi.A(bArr2);
            co coVar3 = new co((Bitmap) null, z5, str, bArr2);
            coVar3.y(z2);
            Object[] objArr3 = new Object[4];
            objArr3[0] = Boolean.valueOf(z2);
            objArr3[c] = Boolean.valueOf(webClient.isCrackPic);
            objArr3[2] = Boolean.valueOf(z5);
            objArr3[3] = egVar;
            storeLocal(str2, bArr2, objArr3);
            return coVar3;
        }
        return (co) invokeCommon.objValue;
    }
}
