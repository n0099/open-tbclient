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
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.ec;
import com.baidu.tieba.gn;
import com.baidu.tieba.ic;
import com.baidu.tieba.n05;
import com.baidu.tieba.ng;
import com.baidu.tieba.qg;
import com.baidu.tieba.qw5;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MemeLoaderProc2 implements qg<gn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isShare;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public gn m128decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (gn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qg
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

    @Override // com.baidu.tieba.qg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return n05.c().g();
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

    public gn createImageFromDiskPicOperate(ic icVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, icVar, str, i, i2)) == null) {
            if (icVar == null) {
                return null;
            }
            icVar.formatData(icVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(icVar.getBitmap(), i, i2);
            if (checkBitmapSize == null && icVar.c() == null) {
                return null;
            }
            return new gn(checkBitmapSize, icVar.isGif(), str, icVar.c());
        }
        return (gn) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qg
    public gn getFromLocal(String str, String str2, int i, int i2, ng ngVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ngVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            ic icVar = new ic("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            icVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            icVar.setSubFolder(true);
            icVar.setIsFormatData(false);
            icVar.setSdCard(false);
            icVar.setSavedCache(true);
            icVar.setLock(bArr);
            if (ngVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(icVar);
                ngVar.a = diskCancelWorker;
            }
            if (!ec.f().a(icVar)) {
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
            if (!icVar.isSuccess()) {
                return null;
            }
            return createImageFromDiskPicOperate(icVar, str, i, i2);
        }
        return (gn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qg
    public gn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            gn checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, TbImageMemoryCache.u().z(str), i, i2);
            if (checkIsValidPicMemoryCache != null && checkIsValidPicMemoryCache.p() != null && !checkIsValidPicMemoryCache.p().isRecycled()) {
                return checkIsValidPicMemoryCache;
            }
            return null;
        }
        return (gn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.qg
    public gn getFromRemote(String str, String str2, int i, int i2, ng ngVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ngVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (i == 0) {
                i3 = vi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i3 = i;
            }
            if (i2 == 0) {
                i4 = vi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i4 = i2;
            }
            if (!this.isShare) {
                qw5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d = qw5.d(str);
                if (((Boolean) d.first).booleanValue()) {
                    str3 = (String) d.second;
                }
            } else {
                qw5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (ngVar != null) {
                ngVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes == null && !webClient.getResponse().a) {
                return null;
            }
            TbImageMemoryCache u = TbImageMemoryCache.u();
            int pbImageSize = TbConfig.getPbImageSize();
            boolean z = false;
            if (downloadImageBytes != null) {
                i5 = downloadImageBytes.length;
            } else {
                i5 = 0;
            }
            u.s(pbImageSize + i5);
            return storeBitmap(str4, str2, ngVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i3, i4), (webClient.isGif || vi.D(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
        }
        return (gn) invokeCommon.objValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public gn storeBitmap(String str, String str2, ng ngVar, gn gnVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, ngVar, gnVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                gnVar = new gn(bitmap, z, str2, bArr);
                gnVar.y(z2);
                if (z2) {
                    ic icVar = new ic("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    icVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    icVar.setSubFolder(true);
                    icVar.setData(bArr);
                    icVar.setGif(z);
                    icVar.setSdCard(false);
                    icVar.setSavedCache(true);
                    ec.f().a(icVar);
                    if (ngVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(icVar);
                        ngVar.a = diskCancelWorker;
                    }
                }
            }
            return gnVar;
        }
        return (gn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof gn)) {
            gn gnVar = (gn) obj;
            if (gnVar.u()) {
                gnVar.A(i);
                gnVar.z(i2);
                TbImageMemoryCache.u().l(str, gnVar);
            }
        }
    }
}
