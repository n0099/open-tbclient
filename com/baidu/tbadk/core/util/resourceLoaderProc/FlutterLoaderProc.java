package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ImageLogger;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.R;
import com.baidu.tieba.dg;
import com.baidu.tieba.tv5;
import com.baidu.tieba.ub;
import com.baidu.tieba.yb;
import com.baidu.tieba.yf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class FlutterLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isNeedFormat;
    public int procType;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.eg
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

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

    public BdImage createImageByteFromDiskPicOperate(yb ybVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, ybVar, str, i, i2)) == null) {
            if (ybVar == null) {
                return null;
            }
            BdImage bdImage = new BdImage((Bitmap) null, false, str, ybVar.getData());
            ybVar.formatData(ybVar.getData());
            Bitmap checkBitmapSize = checkBitmapSize(ybVar.getBitmap(), i, i2);
            if (checkBitmapSize != null) {
                return new BdImage(checkBitmapSize, ybVar.isGif(), str);
            }
            return bdImage;
        }
        return (BdImage) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.eg
    public BdImage getFromLocal(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            yb createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSdCard(false);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setSavedCache(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            if (dgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                dgVar.a = diskCancelWorker;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (!ub.f().a(createDiskPicOperate)) {
                return null;
            }
            int i3 = 2000;
            if (isWifiNet) {
                i3 = 300;
            }
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException unused) {
                }
            }
            if (!createDiskPicOperate.isSuccess()) {
                return null;
            }
            return createImageByteFromDiskPicOperate(createDiskPicOperate, str2, i, i2);
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.eg
    public BdImage getFromRemote(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        String urlbyClientServerAddr;
        boolean z;
        boolean z2;
        WebClient webClient;
        byte[] bArr;
        char c;
        boolean z3;
        boolean z4;
        WebClient webClient2;
        char c2;
        boolean z5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
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
                i3 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            if (i4 == 0) {
                i4 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            }
            boolean isFromCDN = isFromCDN();
            if (isFromCDN) {
                urlbyClientServerAddr = str;
            } else {
                urlbyClientServerAddr = getUrlbyClientServerAddr(str, i3, i4);
            }
            tv5.e(isFromCDN, urlbyClientServerAddr, str);
            Pair<Boolean, String> d = tv5.d(urlbyClientServerAddr);
            if (((Boolean) d.first).booleanValue()) {
                urlbyClientServerAddr = (String) d.second;
                z = true;
            } else {
                z = false;
            }
            WebClient webClient3 = new WebClient();
            if (dgVar != null) {
                dgVar.a = webClient3;
            }
            byte[] downloadImageBytes = webClient3.downloadImageBytes(urlbyClientServerAddr, !isFromCDN);
            boolean needCache = webClient3.needCache();
            if (!webClient3.IsRequestSuccess()) {
                if (webClient3.responseCode == 302 && (17 == getProcType() || 18 == getProcType() || 13 == getProcType() || 14 == getProcType())) {
                    if (webClient3.mStat != null) {
                        z4 = needCache;
                        webClient2 = webClient3;
                        c2 = 1;
                        ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient3.mStat, "redirect", System.currentTimeMillis() - currentTimeMillis, webClient3.isMobileProxy(), getProcType());
                    } else {
                        z4 = needCache;
                        webClient2 = webClient3;
                        c2 = 1;
                    }
                    try {
                        InputStream openRawResource = TbadkCoreApplication.getInst().getResources().openRawResource(R.drawable.img_default_delete, new TypedValue());
                        byte[] d2 = yf.d(openRawResource);
                        try {
                            if (!webClient2.isGif && !BdUtilHelper.isGif(d2)) {
                                z5 = false;
                                BdImage bdImage = new BdImage((Bitmap) null, z5, str, d2);
                                bdImage.setNeedCache(z4);
                                Object[] objArr2 = new Object[4];
                                objArr2[0] = Boolean.valueOf(z4);
                                objArr2[c2] = Boolean.valueOf(webClient2.isCrackPic);
                                objArr2[2] = Boolean.valueOf(z5);
                                objArr2[3] = dgVar;
                                storeLocal(str2, d2, objArr2);
                                BdCloseHelper.close(openRawResource);
                                return bdImage;
                            }
                            storeLocal(str2, d2, objArr2);
                            BdCloseHelper.close(openRawResource);
                            return bdImage;
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            return null;
                        }
                        z5 = true;
                        BdImage bdImage2 = new BdImage((Bitmap) null, z5, str, d2);
                        bdImage2.setNeedCache(z4);
                        Object[] objArr22 = new Object[4];
                        objArr22[0] = Boolean.valueOf(z4);
                        objArr22[c2] = Boolean.valueOf(webClient2.isCrackPic);
                        objArr22[2] = Boolean.valueOf(z5);
                        objArr22[3] = dgVar;
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
            } else {
                z2 = needCache;
                webClient = webClient3;
            }
            if (downloadImageBytes == null) {
                if (!webClient.getResponse().a) {
                    ImageLogger.imagePerfNetLog(str, false, urlbyClientServerAddr, Boolean.valueOf(z), webClient.mStat, "ByteIsNull", System.currentTimeMillis() - currentTimeMillis, webClient.isMobileProxy(), getProcType());
                    return null;
                }
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
            TbImageMemoryCache.B().v(TbConfig.getPbImageSize() + bArr2.length);
            if (!webClient.isGif && !BdUtilHelper.isGif(bArr2)) {
                z3 = false;
            } else {
                z3 = true;
            }
            BdImage bdImage3 = new BdImage((Bitmap) null, z3, str, bArr2);
            bdImage3.setNeedCache(z2);
            Object[] objArr3 = new Object[4];
            objArr3[0] = Boolean.valueOf(z2);
            objArr3[c] = Boolean.valueOf(webClient.isCrackPic);
            objArr3[2] = Boolean.valueOf(z3);
            objArr3[3] = dgVar;
            storeLocal(str2, bArr2, objArr3);
            return bdImage3;
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.procType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.isFromCDN;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) && !TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                yb ybVar = new yb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                ybVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                ybVar.setSubFolder(true);
                ybVar.setData(bArr);
                ybVar.setSdCard(false);
                ybVar.setSavedCache(true);
                ybVar.setGif(booleanValue3);
                ybVar.f(this.isNeedFormat);
                ub.f().a(ybVar);
                dg dgVar = (dg) objArr[3];
                if (dgVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(ybVar);
                    dgVar.a = diskCancelWorker;
                }
            }
        }
    }
}
