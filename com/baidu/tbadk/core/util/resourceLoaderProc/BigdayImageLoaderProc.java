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
import com.baidu.tieba.h85;
import com.baidu.tieba.kc;
import com.baidu.tieba.mh5;
import com.baidu.tieba.oc;
import com.baidu.tieba.on;
import com.baidu.tieba.xg;
import com.baidu.tieba.zg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BigdayImageLoaderProc implements ah<on> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static boolean isImageFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            oc ocVar = new oc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(zg.h().g(str, 41)), DiskFileOperate.Action.INFO);
            ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ocVar.setIsFormatData(false);
            ocVar.setSdCard(false);
            ocVar.setSavedCache(true);
            return ocVar.call();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public on m43decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (on) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ah
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ah
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ah
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

    @Override // com.baidu.tieba.ah
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof on)) {
            on onVar = (on) obj;
            if (onVar.u()) {
                h85.k().d(str, onVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromLocal(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            oc ocVar = new oc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ocVar.setSdCard(false);
            ocVar.setSavedCache(true);
            ocVar.setIsFormatData(false);
            ocVar.setLock(bArr);
            if (xgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ocVar);
                xgVar.a = diskCancelWorker;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (kc.f().a(ocVar)) {
                int i3 = isWifiNet ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (ocVar.isSuccess()) {
                    ocVar.formatData(ocVar.getData());
                    Bitmap bitmap = ocVar.getBitmap();
                    if (bitmap != null) {
                        return new on(bitmap, ocVar.isGif(), str2);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? h85.k().m(str) : (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromRemote(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            mh5.g(BigdayImageLoaderProc.class.getSimpleName(), str);
            WebClient webClient = new WebClient();
            if (xgVar != null) {
                xgVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str, false);
            boolean needCache = webClient.needCache();
            if ((downloadImageBytes != null || webClient.getResponse().a) && needCache && !webClient.isCrackPic) {
                oc ocVar = new oc(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                ocVar.setData(downloadImageBytes);
                ocVar.setSdCard(false);
                ocVar.setSavedCache(true);
                ocVar.setGif(false);
                kc.f().a(ocVar);
                if (xgVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(ocVar);
                    xgVar.a = diskCancelWorker;
                }
            }
            return null;
        }
        return (on) invokeCommon.objValue;
    }
}
