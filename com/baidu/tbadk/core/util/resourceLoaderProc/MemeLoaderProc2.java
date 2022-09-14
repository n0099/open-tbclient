package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tieba.ah;
import com.baidu.tieba.ej;
import com.baidu.tieba.kc;
import com.baidu.tieba.oc;
import com.baidu.tieba.on;
import com.baidu.tieba.u75;
import com.baidu.tieba.up4;
import com.baidu.tieba.xg;
import com.baidu.tieba.zg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MemeLoaderProc2 implements ah<on> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isShare;

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

    public Bitmap checkBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i, i2)) == null) ? BitmapHelper.checkBitmapSize(bitmap, i, i2) : (Bitmap) invokeLII.objValue;
    }

    public on createImageFromDiskPicOperate(oc ocVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ocVar, str, i, i2)) == null) {
            if (ocVar == null) {
                return null;
            }
            ocVar.formatData(ocVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(ocVar.getBitmap(), i, i2);
            if (checkBitmapSize == null && ocVar.c() == null) {
                return null;
            }
            return new on(checkBitmapSize, ocVar.isGif(), str, ocVar.c());
        }
        return (on) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public on m49decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (on) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ah
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ah
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ah
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? up4.c().g() : invokeV.booleanValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public on storeBitmap(String str, String str2, xg xgVar, on onVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, xgVar, onVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                onVar = new on(bitmap, z, str2, bArr);
                onVar.y(z2);
                if (z2) {
                    oc ocVar = new oc("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    ocVar.setSubFolder(true);
                    ocVar.setData(bArr);
                    ocVar.setGif(z);
                    ocVar.setSdCard(false);
                    ocVar.setSavedCache(true);
                    kc.f().a(ocVar);
                    if (xgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(ocVar);
                        xgVar.a = diskCancelWorker;
                    }
                }
            }
            return onVar;
        }
        return (on) invokeCommon.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.baidu.tieba.ah
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof on)) {
            on onVar = (on) obj;
            if (onVar.u()) {
                onVar.A(i);
                onVar.z(i2);
                u75.k().d(str, onVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromLocal(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            oc ocVar = new oc("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            ocVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            ocVar.setSubFolder(true);
            ocVar.setIsFormatData(false);
            ocVar.setSdCard(false);
            ocVar.setSavedCache(true);
            ocVar.setLock(bArr);
            if (xgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(ocVar);
                xgVar.a = diskCancelWorker;
            }
            if (kc.f().a(ocVar)) {
                int i3 = BdNetTypeUtil.isWifiNet() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (ocVar.isSuccess()) {
                    return createImageFromDiskPicOperate(ocVar, str, i, i2);
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            on checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, u75.k().m(str), i, i2);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (on) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.ah
    public on getFromRemote(String str, String str2, int i, int i2, xg xgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), xgVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            int d = i == 0 ? ej.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i;
            int d2 = i2 == 0 ? ej.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i2;
            if (!this.isShare) {
                zg5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d3 = zg5.d(str);
                if (((Boolean) d3.first).booleanValue()) {
                    str3 = (String) d3.second;
                }
            } else {
                zg5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (xgVar != null) {
                xgVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes != null || webClient.getResponse().a) {
                boolean z = false;
                u75.k().i(TbConfig.getPbImageSize() + (downloadImageBytes != null ? downloadImageBytes.length : 0));
                return storeBitmap(str4, str2, xgVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), d, d2), (webClient.isGif || ej.B(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
            }
            return null;
        }
        return (on) invokeCommon.objValue;
    }
}
