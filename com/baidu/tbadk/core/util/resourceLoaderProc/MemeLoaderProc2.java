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
import com.baidu.tieba.a15;
import com.baidu.tieba.ey5;
import com.baidu.tieba.fc;
import com.baidu.tieba.jc;
import com.baidu.tieba.jn;
import com.baidu.tieba.qg;
import com.baidu.tieba.tg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MemeLoaderProc2 implements tg<jn> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isShare;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public jn m128decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (jn) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tg
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

    @Override // com.baidu.tieba.tg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return a15.c().g();
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

    public jn createImageFromDiskPicOperate(jc jcVar, String str, int i, int i2) {
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
            return new jn(checkBitmapSize, jcVar.isGif(), str, jcVar.c());
        }
        return (jn) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public jn getFromLocal(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            jc jcVar = new jc("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            jcVar.setSubFolder(true);
            jcVar.setIsFormatData(false);
            jcVar.setSdCard(false);
            jcVar.setSavedCache(true);
            jcVar.setLock(bArr);
            if (qgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(jcVar);
                qgVar.a = diskCancelWorker;
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
        return (jn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public jn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            jn checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, TbImageMemoryCache.v().A(str), i, i2);
            if (checkIsValidPicMemoryCache != null && checkIsValidPicMemoryCache.p() != null && !checkIsValidPicMemoryCache.p().isRecycled()) {
                return checkIsValidPicMemoryCache;
            }
            return null;
        }
        return (jn) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.tg
    public jn getFromRemote(String str, String str2, int i, int i2, qg qgVar, Object... objArr) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), qgVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (i == 0) {
                i3 = yi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i3 = i;
            }
            if (i2 == 0) {
                i4 = yi.d(TbadkCoreApplication.getInst().getApp(), 105.0f);
            } else {
                i4 = i2;
            }
            if (!this.isShare) {
                ey5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d = ey5.d(str);
                if (((Boolean) d.first).booleanValue()) {
                    str3 = (String) d.second;
                }
            } else {
                ey5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (qgVar != null) {
                qgVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes == null && !webClient.getResponse().a) {
                return null;
            }
            TbImageMemoryCache v = TbImageMemoryCache.v();
            int pbImageSize = TbConfig.getPbImageSize();
            boolean z = false;
            if (downloadImageBytes != null) {
                i5 = downloadImageBytes.length;
            } else {
                i5 = 0;
            }
            v.t(pbImageSize + i5);
            return storeBitmap(str4, str2, qgVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), i3, i4), (webClient.isGif || yi.E(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
        }
        return (jn) invokeCommon.objValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public jn storeBitmap(String str, String str2, qg qgVar, jn jnVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, qgVar, jnVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                jnVar = new jn(bitmap, z, str2, bArr);
                jnVar.y(z2);
                if (z2) {
                    jc jcVar = new jc("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    jcVar.setSubFolder(true);
                    jcVar.setData(bArr);
                    jcVar.setGif(z);
                    jcVar.setSdCard(false);
                    jcVar.setSavedCache(true);
                    fc.f().a(jcVar);
                    if (qgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(jcVar);
                        qgVar.a = diskCancelWorker;
                    }
                }
            }
            return jnVar;
        }
        return (jn) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof jn)) {
            jn jnVar = (jn) obj;
            if (jnVar.u()) {
                jnVar.A(i);
                jnVar.z(i2);
                TbImageMemoryCache.v().m(str, jnVar);
            }
        }
    }
}
