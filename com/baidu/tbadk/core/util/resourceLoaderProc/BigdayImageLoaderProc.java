package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.bb;
import com.baidu.tieba.cb;
import com.baidu.tieba.pr5;
import com.baidu.tieba.t6;
import com.baidu.tieba.x6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BigdayImageLoaderProc implements cb<BdImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public BdImage m123decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (BdImage) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.cb
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.cb
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    public BigdayImageLoaderProc() {
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

    @Override // com.baidu.tieba.cb
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    public static boolean isImageFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            x6 x6Var = new x6(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(BdResourceLoader.getInstance().genCacheKey(str, 41)), DiskFileOperate.Action.INFO);
            x6Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            x6Var.setIsFormatData(false);
            x6Var.setSdCard(false);
            x6Var.setSavedCache(true);
            return x6Var.call();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.cb
    public BdImage getFromLocal(String str, String str2, int i, int i2, bb bbVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), bbVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            x6 x6Var = new x6(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            x6Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            x6Var.setSdCard(false);
            x6Var.setSavedCache(true);
            x6Var.setIsFormatData(false);
            x6Var.setLock(bArr);
            if (bbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(x6Var);
                bbVar.a = diskCancelWorker;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (!t6.g().a(x6Var)) {
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
            if (!x6Var.isSuccess()) {
                return null;
            }
            x6Var.formatData(x6Var.getData());
            Bitmap bitmap = x6Var.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new BdImage(bitmap, x6Var.isGif(), str2);
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.cb
    public BdImage getFromRemote(String str, String str2, int i, int i2, bb bbVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), bbVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            pr5.g(BigdayImageLoaderProc.class.getSimpleName(), str);
            WebClient webClient = new WebClient();
            if (bbVar != null) {
                bbVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str, false);
            boolean needCache = webClient.needCache();
            if ((downloadImageBytes != null || webClient.getResponse().a) && needCache && !webClient.isCrackPic) {
                x6 x6Var = new x6(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                x6Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                x6Var.setData(downloadImageBytes);
                x6Var.setSdCard(false);
                x6Var.setSavedCache(true);
                x6Var.setGif(false);
                t6.g().a(x6Var);
                if (bbVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(x6Var);
                    bbVar.a = diskCancelWorker;
                }
            }
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.cb
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.B().D(str);
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.cb
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof BdImage)) {
            BdImage bdImage = (BdImage) obj;
            if (bdImage.isNeedCache()) {
                TbImageMemoryCache.B().l(str, bdImage);
            }
        }
    }
}
