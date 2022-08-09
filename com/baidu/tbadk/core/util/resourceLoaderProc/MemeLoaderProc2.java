package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i55;
import com.repackage.ig;
import com.repackage.lg;
import com.repackage.ne5;
import com.repackage.oi;
import com.repackage.qi;
import com.repackage.rn4;
import com.repackage.vb;
import com.repackage.zb;
import com.repackage.zm;
/* loaded from: classes3.dex */
public class MemeLoaderProc2 implements lg<zm> {
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

    public zm createImageFromDiskPicOperate(zb zbVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zbVar, str, i, i2)) == null) {
            if (zbVar == null) {
                return null;
            }
            zbVar.formatData(zbVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(zbVar.getBitmap(), i, i2);
            if (checkBitmapSize == null && zbVar.c() == null) {
                return null;
            }
            return new zm(checkBitmapSize, zbVar.isGif(), str, zbVar.c());
        }
        return (zm) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public zm m49decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (zm) invokeLL.objValue;
    }

    @Override // com.repackage.lg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.lg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.lg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? rn4.c().g() : invokeV.booleanValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public zm storeBitmap(String str, String str2, ig igVar, zm zmVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, igVar, zmVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                zmVar = new zm(bitmap, z, str2, bArr);
                zmVar.y(z2);
                if (z2) {
                    zb zbVar = new zb("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    zbVar.setSubFolder(true);
                    zbVar.setData(bArr);
                    zbVar.setGif(z);
                    zbVar.setSdCard(false);
                    zbVar.setSavedCache(true);
                    vb.f().a(zbVar);
                    if (igVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(zbVar);
                        igVar.a = diskCancelWorker;
                    }
                }
            }
            return zmVar;
        }
        return (zm) invokeCommon.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.lg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof zm)) {
            zm zmVar = (zm) obj;
            if (zmVar.u()) {
                zmVar.A(i);
                zmVar.z(i2);
                i55.k().d(str, zmVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromLocal(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            zb zbVar = new zb("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            zbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            zbVar.setSubFolder(true);
            zbVar.setIsFormatData(false);
            zbVar.setSdCard(false);
            zbVar.setSavedCache(true);
            zbVar.setLock(bArr);
            if (igVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(zbVar);
                igVar.a = diskCancelWorker;
            }
            if (vb.f().a(zbVar)) {
                int i3 = oi.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (zbVar.isSuccess()) {
                    return createImageFromDiskPicOperate(zbVar, str, i, i2);
                }
                return null;
            }
            return null;
        }
        return (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            zm checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, i55.k().m(str), i, i2);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (zm) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.lg
    public zm getFromRemote(String str, String str2, int i, int i2, ig igVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), igVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            int d = i == 0 ? qi.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i;
            int d2 = i2 == 0 ? qi.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i2;
            if (!this.isShare) {
                ne5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d3 = ne5.d(str);
                if (((Boolean) d3.first).booleanValue()) {
                    str3 = (String) d3.second;
                }
            } else {
                ne5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (igVar != null) {
                igVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes != null || webClient.getResponse().a) {
                boolean z = false;
                i55.k().i(TbConfig.getPbImageSize() + (downloadImageBytes != null ? downloadImageBytes.length : 0));
                return storeBitmap(str4, str2, igVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), d, d2), (webClient.isGif || qi.B(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
            }
            return null;
        }
        return (zm) invokeCommon.objValue;
    }
}
