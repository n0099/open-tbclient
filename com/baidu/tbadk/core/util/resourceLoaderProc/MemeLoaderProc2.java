package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.switchs.WebpSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.a.d;
import d.a.c.e.a.f.c;
import d.a.c.e.l.b;
import d.a.c.e.l.e;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.c.k.d.a;
import d.a.r0.r.k;
/* loaded from: classes4.dex */
public class MemeLoaderProc2 implements e<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public boolean isShare;

    public MemeLoaderProc2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isFromCDN = true;
        this.isShare = false;
    }

    public Bitmap checkBitmapSize(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bitmap, i2, i3)) == null) ? BitmapHelper.checkBitmapSize(bitmap, i2, i3) : (Bitmap) invokeLII.objValue;
    }

    public a createImageFromDiskPicOperate(c cVar, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str, i2, i3)) == null) {
            if (cVar == null) {
                return null;
            }
            cVar.formatData(cVar.getData());
            Bitmap checkBitmapSize = BitmapHelper.checkBitmapSize(cVar.getBitmap(), i2, i3);
            if (checkBitmapSize == null && cVar.c() == null) {
                return null;
            }
            return new a(checkBitmapSize, cVar.isGif(), str, cVar.c());
        }
        return (a) invokeLLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public a m31decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bArr, objArr)) == null) {
            return null;
        }
        return (a) invokeLL.objValue;
    }

    @Override // d.a.c.e.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // d.a.c.e.l.e
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.c.e.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? k.c().g() : invokeV.booleanValue;
    }

    public void setIsShare(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.isShare = z;
        }
    }

    public a storeBitmap(String str, String str2, b bVar, a aVar, Bitmap bitmap, boolean z, WebClient webClient, byte[] bArr, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, str2, bVar, aVar, bitmap, Boolean.valueOf(z), webClient, bArr, Boolean.valueOf(z2)})) == null) {
            if (bitmap != null || bArr != null) {
                aVar = new a(bitmap, z, str2, bArr);
                aVar.y(z2);
                if (z2) {
                    c cVar = new c("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                    cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                    cVar.setSubFolder(true);
                    cVar.setData(bArr);
                    cVar.setGif(z);
                    cVar.setSdCard(false);
                    cVar.setSavedCache(true);
                    d.g().a(cVar);
                    if (bVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(cVar);
                        bVar.f44260a = diskCancelWorker;
                    }
                }
            }
            return aVar;
        }
        return (a) invokeCommon.objValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, str, bArr, objArr) == null) {
        }
    }

    @Override // d.a.c.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (aVar.u()) {
                aVar.A(i2);
                aVar.z(i3);
                d.a.r0.a0.c.k().d(str, aVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromLocal(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            c cVar = new c("images", TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSubFolder(true);
            cVar.setIsFormatData(false);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            cVar.setLock(bArr);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(cVar);
                bVar.f44260a = diskCancelWorker;
            }
            if (d.g().a(cVar)) {
                int i4 = j.H() ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i4);
                    } catch (InterruptedException unused) {
                    }
                }
                if (cVar.isSuccess()) {
                    return createImageFromDiskPicOperate(cVar, str, i2, i3);
                }
                return null;
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) {
            a checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(str, d.a.r0.a0.c.k().m(str), i2, i3);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.a.c.e.l.e
    public a getFromRemote(String str, String str2, int i2, int i3, b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            String str3 = str;
            if (StringUtils.isNull(str)) {
                return null;
            }
            int e2 = i2 == 0 ? l.e(TbadkCoreApplication.getInst().getApp(), 105.0f) : i2;
            int e3 = i3 == 0 ? l.e(TbadkCoreApplication.getInst().getApp(), 105.0f) : i3;
            boolean z = false;
            if (!this.isShare) {
                if (TbadkCoreApplication.getInst().getCapabilityOfWebp() && SwitchManager.getInstance().findType(WebpSwitch.WEBP_ENABLE) == 1) {
                    int indexOf = str.indexOf("hiphotos.baidu.com");
                    if (indexOf <= 0) {
                        indexOf = str.indexOf("tiebapic.baidu.com");
                    }
                    if (indexOf > 0 && (lastIndexOf = str.lastIndexOf(".jpg")) > 0) {
                        str3 = str.substring(0, lastIndexOf) + ".webp" + str.substring(lastIndexOf + 4, str.length());
                    }
                }
            }
            String str4 = str3;
            WebClient webClient = new WebClient();
            if (bVar != null) {
                bVar.f44260a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str4, !this.isFromCDN);
            boolean needCache = webClient.needCache();
            if (downloadImageBytes != null || webClient.getResponse().f44206a) {
                d.a.r0.a0.c.k().i(TbConfig.getPbImageSize() + downloadImageBytes.length);
                return storeBitmap(str4, str2, bVar, null, checkBitmapSize(BitmapHelper.Bytes2Bitmap(downloadImageBytes), e2, e3), (webClient.isGif || l.B(downloadImageBytes)) ? true : true, webClient, downloadImageBytes, needCache);
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }
}
