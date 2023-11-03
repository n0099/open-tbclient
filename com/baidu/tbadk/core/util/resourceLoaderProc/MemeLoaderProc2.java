package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.j7;
import com.baidu.tieba.jt5;
import com.baidu.tieba.lv4;
import com.baidu.tieba.n7;
import com.baidu.tieba.rb;
import com.baidu.tieba.sb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MemeLoaderProc2 implements sb<BdImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isShare;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public BdImage m130decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (BdImage) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sb
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bArr, objArr) == null) {
        }
    }

    public MemeLoaderProc2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isFromCDN = true;
        this.isShare = false;
    }

    @Override // com.baidu.tieba.sb
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sb
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return lv4.c().g();
        }
        return invokeV.booleanValue;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) {
            return BitmapHelper.checkBitmapSize(bitmap, i, i2);
        }
        return (Bitmap) invokeLII.objValue;
    }

    public BdImage createImageFromDiskPicOperate(n7 n7Var, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n7Var, str, i, i2)) == null) {
            if (n7Var == null) {
                return null;
            }
            n7Var.formatData(n7Var.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(n7Var.getBitmap(), i, i2);
            if (checkBitmapSize == null && n7Var.c() == null) {
                return null;
            }
            return new BdImage(checkBitmapSize, n7Var.isGif(), str, n7Var.c());
        }
        return (BdImage) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sb
    public BdImage getFromLocal(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            n7 n7Var = new n7("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            n7Var.setSubFolder(true);
            n7Var.setIsFormatData(false);
            n7Var.setSdCard(false);
            n7Var.setSavedCache(true);
            n7Var.setLock(bArr);
            if (rbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(n7Var);
                rbVar.a = diskCancelWorker;
            }
            if (!j7.g().a(n7Var)) {
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
            if (!n7Var.isSuccess()) {
                return null;
            }
            return createImageFromDiskPicOperate(n7Var, str, i, i2);
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sb
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            BdImage checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, TbImageMemoryCache.B().D(str), i, i2);
            if (checkIsValidPicMemoryCache != null && checkIsValidPicMemoryCache.getRawBitmap() != null && !checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
                return checkIsValidPicMemoryCache;
            }
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sb
    public BdImage getFromRemote(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (i == 0) {
                i3 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i3 = i;
            }
            if (i2 == 0) {
                i4 = BdUtilHelper.dip2px(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i4 = i2;
            }
            if (!this.isShare) {
                jt5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d = jt5.d(str);
                if (((Boolean) d.first).booleanValue()) {
                    str3 = (String) d.second;
                }
            } else {
                jt5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (rbVar != null) {
                rbVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes == null && !webClient.getResponse().a) {
                return null;
            }
            TbImageMemoryCache B = TbImageMemoryCache.B();
            int pbImageSize = TbConfig.getPbImageSize();
            boolean z = false;
            if (downloadImageBytes != null) {
                i5 = downloadImageBytes.length;
            } else {
                i5 = 0;
            }
            B.v(pbImageSize + i5);
            return storeBitmap(str4, str2, rbVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i3, i4), (webClient.isGif || BdUtilHelper.isGif(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
        }
        return (BdImage) invokeCommon.objValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public BdImage storeBitmap(String str, String str2, rb rbVar, BdImage bdImage, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, rbVar, bdImage, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                bdImage = new BdImage(bitmap, z, str2, bArr);
                bdImage.setNeedCache(z2);
                if (z2) {
                    n7 n7Var = new n7("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    n7Var.setSubFolder(true);
                    n7Var.setData(bArr);
                    n7Var.setGif(z);
                    n7Var.setSdCard(false);
                    n7Var.setSavedCache(true);
                    j7.g().a(n7Var);
                    if (rbVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(n7Var);
                        rbVar.a = diskCancelWorker;
                    }
                }
            }
            return bdImage;
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.sb
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof BdImage)) {
            BdImage bdImage = (BdImage) obj;
            if (bdImage.isNeedCache()) {
                bdImage.setRequestWidth(i);
                bdImage.setRequestHeight(i2);
                TbImageMemoryCache.B().l(str, bdImage);
            }
        }
    }
}
