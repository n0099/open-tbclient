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
import com.baidu.tieba.ax5;
import com.baidu.tieba.fc;
import com.baidu.tieba.in;
import com.baidu.tieba.jc;
import com.baidu.tieba.pg;
import com.baidu.tieba.r05;
import com.baidu.tieba.sg;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MemeLoaderProc2 implements sg<in> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isShare;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public in m128decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (in) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.sg
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

    @Override // com.baidu.tieba.sg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return r05.c().g();
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

    public in createImageFromDiskPicOperate(jc jcVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jcVar, str, i, i2)) == null) {
            if (jcVar == null) {
                return null;
            }
            jcVar.formatData(jcVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(jcVar.getBitmap(), i, i2);
            if (checkBitmapSize == null && jcVar.c() == null) {
                return null;
            }
            return new in(checkBitmapSize, jcVar.isGif(), str, jcVar.c());
        }
        return (in) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sg
    public in getFromLocal(String str, String str2, int i, int i2, pg pgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), pgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            jc jcVar = new jc("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            jcVar.setSubFolder(true);
            jcVar.setIsFormatData(false);
            jcVar.setSdCard(false);
            jcVar.setSavedCache(true);
            jcVar.setLock(bArr);
            if (pgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(jcVar);
                pgVar.a = diskCancelWorker;
            }
            if (!fc.f().a(jcVar)) {
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
            if (!jcVar.isSuccess()) {
                return null;
            }
            return createImageFromDiskPicOperate(jcVar, str, i, i2);
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sg
    public in getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            in checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, TbImageMemoryCache.u().w(str), i, i2);
            if (checkIsValidPicMemoryCache != null && checkIsValidPicMemoryCache.p() != null && !checkIsValidPicMemoryCache.p().isRecycled()) {
                return checkIsValidPicMemoryCache;
            }
            return null;
        }
        return (in) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.sg
    public in getFromRemote(String str, String str2, int i, int i2, pg pgVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), pgVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (i == 0) {
                i3 = xi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i3 = i;
            }
            if (i2 == 0) {
                i4 = xi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i4 = i2;
            }
            if (!this.isShare) {
                ax5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d = ax5.d(str);
                if (((Boolean) d.first).booleanValue()) {
                    str3 = (String) d.second;
                }
            } else {
                ax5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (pgVar != null) {
                pgVar.a = webClient;
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
            return storeBitmap(str4, str2, pgVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i3, i4), (webClient.isGif || xi.D(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
        }
        return (in) invokeCommon.objValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public in storeBitmap(String str, String str2, pg pgVar, in inVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, pgVar, inVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                inVar = new in(bitmap, z, str2, bArr);
                inVar.y(z2);
                if (z2) {
                    jc jcVar = new jc("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    jcVar.setSubFolder(true);
                    jcVar.setData(bArr);
                    jcVar.setGif(z);
                    jcVar.setSdCard(false);
                    jcVar.setSavedCache(true);
                    fc.f().a(jcVar);
                    if (pgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(jcVar);
                        pgVar.a = diskCancelWorker;
                    }
                }
            }
            return inVar;
        }
        return (in) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.sg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof in)) {
            in inVar = (in) obj;
            if (inVar.u()) {
                inVar.A(i);
                inVar.z(i2);
                TbImageMemoryCache.u().l(str, inVar);
            }
        }
    }
}
