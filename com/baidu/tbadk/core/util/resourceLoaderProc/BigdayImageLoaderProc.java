package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.ey5;
import com.baidu.tieba.fc;
import com.baidu.tieba.jc;
import com.baidu.tieba.jn;
import com.baidu.tieba.qg;
import com.baidu.tieba.sg;
import com.baidu.tieba.tg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class BigdayImageLoaderProc implements tg<jn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public jn m122decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (jn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tg
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

    @Override // com.baidu.tieba.tg
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
            jc jcVar = new jc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(sg.h().g(str, 41)), DiskFileOperate.Action.INFO);
            jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            jcVar.setIsFormatData(false);
            jcVar.setSdCard(false);
            jcVar.setSavedCache(true);
            return jcVar.call();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public jn getFromLocal(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            jc jcVar = new jc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            jcVar.setSdCard(false);
            jcVar.setSavedCache(true);
            jcVar.setIsFormatData(false);
            jcVar.setLock(bArr);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(jcVar);
                qgVar.a = diskCancelWorker;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (!fc.f().a(jcVar)) {
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
            if (!jcVar.isSuccess()) {
                return null;
            }
            jcVar.formatData(jcVar.getData());
            Bitmap bitmap = jcVar.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new jn(bitmap, jcVar.isGif(), str2);
        }
        return (jn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public jn getFromRemote(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            ey5.g(BigdayImageLoaderProc.class.getSimpleName(), str);
            WebClient webClient = new WebClient();
            if (qgVar != null) {
                qgVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str, false);
            boolean needCache = webClient.needCache();
            if ((downloadImageBytes != null || webClient.getResponse().a) && needCache && !webClient.isCrackPic) {
                jc jcVar = new jc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                jcVar.setData(downloadImageBytes);
                jcVar.setSdCard(false);
                jcVar.setSavedCache(true);
                jcVar.setGif(false);
                fc.f().a(jcVar);
                if (qgVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(jcVar);
                    qgVar.a = diskCancelWorker;
                }
            }
            return null;
        }
        return (jn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public jn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return TbImageMemoryCache.v().A(str);
        }
        return (jn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof jn)) {
            jn jnVar = (jn) obj;
            if (jnVar.u()) {
                TbImageMemoryCache.v().m(str, jnVar);
            }
        }
    }
}
