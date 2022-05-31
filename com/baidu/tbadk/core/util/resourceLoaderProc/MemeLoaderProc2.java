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
import com.repackage.am4;
import com.repackage.dg;
import com.repackage.gg;
import com.repackage.ji;
import com.repackage.li;
import com.repackage.rb;
import com.repackage.u25;
import com.repackage.um;
import com.repackage.vb;
import com.repackage.xb5;
/* loaded from: classes3.dex */
public class MemeLoaderProc2 implements gg<um> {
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

    public um createImageFromDiskPicOperate(vb vbVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vbVar, str, i, i2)) == null) {
            if (vbVar == null) {
                return null;
            }
            vbVar.formatData(vbVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(vbVar.getBitmap(), i, i2);
            if (checkBitmapSize == null && vbVar.c() == null) {
                return null;
            }
            return new um(checkBitmapSize, vbVar.isGif(), str, vbVar.c());
        }
        return (um) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public um m49decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (um) invokeLL.objValue;
    }

    @Override // com.repackage.gg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.gg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.gg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? am4.c().g() : invokeV.booleanValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public um storeBitmap(String str, String str2, dg dgVar, um umVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, dgVar, umVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                umVar = new um(bitmap, z, str2, bArr);
                umVar.y(z2);
                if (z2) {
                    vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    vbVar.setSubFolder(true);
                    vbVar.setData(bArr);
                    vbVar.setGif(z);
                    vbVar.setSdCard(false);
                    vbVar.setSavedCache(true);
                    rb.f().a(vbVar);
                    if (dgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(vbVar);
                        dgVar.a = diskCancelWorker;
                    }
                }
            }
            return umVar;
        }
        return (um) invokeCommon.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.gg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof um)) {
            um umVar = (um) obj;
            if (umVar.u()) {
                umVar.A(i);
                umVar.z(i2);
                u25.k().d(str, umVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromLocal(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setSubFolder(true);
            vbVar.setIsFormatData(false);
            vbVar.setSdCard(false);
            vbVar.setSavedCache(true);
            vbVar.setLock(bArr);
            if (dgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(vbVar);
                dgVar.a = diskCancelWorker;
            }
            if (rb.f().a(vbVar)) {
                int i3 = ji.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (vbVar.isSuccess()) {
                    return createImageFromDiskPicOperate(vbVar, str, i, i2);
                }
                return null;
            }
            return null;
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            um checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, u25.k().m(str), i, i2);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromRemote(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            int d = i == 0 ? li.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i;
            int d2 = i2 == 0 ? li.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i2;
            if (!this.isShare) {
                xb5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d3 = xb5.d(str);
                if (((Boolean) d3.first).booleanValue()) {
                    str3 = (String) d3.second;
                }
            } else {
                xb5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (dgVar != null) {
                dgVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes != null || webClient.getResponse().a) {
                boolean z = false;
                u25.k().i(TbConfig.getPbImageSize() + (downloadImageBytes != null ? downloadImageBytes.length : 0));
                return storeBitmap(str4, str2, dgVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), d, d2), (webClient.isGif || li.B(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
            }
            return null;
        }
        return (um) invokeCommon.objValue;
    }
}
