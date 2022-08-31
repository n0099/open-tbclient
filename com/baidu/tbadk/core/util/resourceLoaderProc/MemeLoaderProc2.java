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
import com.baidu.tieba.ac;
import com.baidu.tieba.an;
import com.baidu.tieba.jg;
import com.baidu.tieba.m55;
import com.baidu.tieba.mg;
import com.baidu.tieba.pi;
import com.baidu.tieba.ri;
import com.baidu.tieba.se5;
import com.baidu.tieba.sn4;
import com.baidu.tieba.wb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class MemeLoaderProc2 implements mg<an> {
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

    public an createImageFromDiskPicOperate(ac acVar, String str, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acVar, str, i, i2)) == null) {
            if (acVar == null) {
                return null;
            }
            acVar.formatData(acVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(acVar.getBitmap(), i, i2);
            if (checkBitmapSize == null && acVar.c() == null) {
                return null;
            }
            return new an(checkBitmapSize, acVar.isGif(), str, acVar.c());
        }
        return (an) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public an m49decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (an) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.mg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? sn4.c().g() : invokeV.booleanValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public an storeBitmap(String str, String str2, jg jgVar, an anVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, jgVar, anVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                anVar = new an(bitmap, z, str2, bArr);
                anVar.y(z2);
                if (z2) {
                    ac acVar = new ac("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    acVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    acVar.setSubFolder(true);
                    acVar.setData(bArr);
                    acVar.setGif(z);
                    acVar.setSdCard(false);
                    acVar.setSavedCache(true);
                    wb.f().a(acVar);
                    if (jgVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(acVar);
                        jgVar.a = diskCancelWorker;
                    }
                }
            }
            return anVar;
        }
        return (an) invokeCommon.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.baidu.tieba.mg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof an)) {
            an anVar = (an) obj;
            if (anVar.u()) {
                anVar.A(i);
                anVar.z(i2);
                m55.k().d(str, anVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mg
    public an getFromLocal(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            ac acVar = new ac("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            acVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            acVar.setSubFolder(true);
            acVar.setIsFormatData(false);
            acVar.setSdCard(false);
            acVar.setSavedCache(true);
            acVar.setLock(bArr);
            if (jgVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(acVar);
                jgVar.a = diskCancelWorker;
            }
            if (wb.f().a(acVar)) {
                int i3 = pi.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (acVar.isSuccess()) {
                    return createImageFromDiskPicOperate(acVar, str, i, i2);
                }
                return null;
            }
            return null;
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mg
    public an getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            an checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, m55.k().m(str), i, i2);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (an) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.mg
    public an getFromRemote(String str, String str2, int i, int i2, jg jgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jgVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            int d = i == 0 ? ri.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i;
            int d2 = i2 == 0 ? ri.d(TbadkCoreApplication.getInst().getApp(), 105.0f) : i2;
            if (!this.isShare) {
                se5.e(this.isFromCDN, str, str);
                Pair<Boolean, String> d3 = se5.d(str);
                if (((Boolean) d3.first).booleanValue()) {
                    str3 = (String) d3.second;
                }
            } else {
                se5.g(MemeLoaderProc2.class.getSimpleName(), str);
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (jgVar != null) {
                jgVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes != null || webClient.getResponse().a) {
                boolean z = false;
                m55.k().i(TbConfig.getPbImageSize() + (downloadImageBytes != null ? downloadImageBytes.length : 0));
                return storeBitmap(str4, str2, jgVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), d, d2), (webClient.isGif || ri.B(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
            }
            return null;
        }
        return (an) invokeCommon.objValue;
    }
}
