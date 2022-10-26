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
import com.baidu.tieba.ah;
import com.baidu.tieba.bh;
import com.baidu.tieba.l85;
import com.baidu.tieba.lc;
import com.baidu.tieba.pc;
import com.baidu.tieba.pn;
import com.baidu.tieba.sh5;
import com.baidu.tieba.yg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BigdayImageLoaderProc implements bh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public pn m43decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (pn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bh
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bh
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

    @Override // com.baidu.tieba.bh
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
            pc pcVar = new pc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(ah.h().g(str, 41)), DiskFileOperate.Action.INFO);
            pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            pcVar.setIsFormatData(false);
            pcVar.setSdCard(false);
            pcVar.setSavedCache(true);
            return pcVar.call();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromLocal(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            pc pcVar = new pc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            pcVar.setSdCard(false);
            pcVar.setSavedCache(true);
            pcVar.setIsFormatData(false);
            pcVar.setLock(bArr);
            if (ygVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(pcVar);
                ygVar.a = diskCancelWorker;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (!lc.f().a(pcVar)) {
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
            if (!pcVar.isSuccess()) {
                return null;
            }
            pcVar.formatData(pcVar.getData());
            Bitmap bitmap = pcVar.getBitmap();
            if (bitmap == null) {
                return null;
            }
            return new pn(bitmap, pcVar.isGif(), str2);
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromRemote(String str, String str2, int i, int i2, yg ygVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ygVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            sh5.g(BigdayImageLoaderProc.class.getSimpleName(), str);
            WebClient webClient = new WebClient();
            if (ygVar != null) {
                ygVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str, false);
            boolean needCache = webClient.needCache();
            if ((downloadImageBytes != null || webClient.getResponse().a) && needCache && !webClient.isCrackPic) {
                pc pcVar = new pc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                pcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                pcVar.setData(downloadImageBytes);
                pcVar.setSdCard(false);
                pcVar.setSavedCache(true);
                pcVar.setGif(false);
                lc.f().a(pcVar);
                if (ygVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(pcVar);
                    ygVar.a = diskCancelWorker;
                }
            }
            return null;
        }
        return (pn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bh
    public pn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return l85.k().m(str);
        }
        return (pn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bh
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof pn)) {
            pn pnVar = (pn) obj;
            if (pnVar.u()) {
                l85.k().d(str, pnVar);
            }
        }
    }
}
