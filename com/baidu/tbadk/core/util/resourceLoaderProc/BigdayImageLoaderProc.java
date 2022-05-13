package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.co;
import com.repackage.dd5;
import com.repackage.eg;
import com.repackage.gg;
import com.repackage.hg;
import com.repackage.ki;
import com.repackage.rb;
import com.repackage.vb;
import com.repackage.y35;
/* loaded from: classes3.dex */
public class BigdayImageLoaderProc implements hg<co> {
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
            vb vbVar = new vb(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(gg.h().g(str, 41)), DiskFileOperate.Action.INFO);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setIsFormatData(false);
            vbVar.setSdCard(false);
            vbVar.setSavedCache(true);
            return vbVar.call();
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public co m45decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (co) invokeLL.objValue;
    }

    @Override // com.repackage.hg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ImageLoadSpeedRecorder.sharedInstance().getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.hg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.hg
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

    @Override // com.repackage.hg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof co)) {
            co coVar = (co) obj;
            if (coVar.u()) {
                y35.k().d(str, coVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            byte[] bArr = new byte[0];
            vb vbVar = new vb(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.READ);
            vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            vbVar.setSdCard(false);
            vbVar.setSavedCache(true);
            vbVar.setIsFormatData(false);
            vbVar.setLock(bArr);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(vbVar);
                egVar.a = diskCancelWorker;
            }
            boolean H = ki.H();
            if (rb.f().a(vbVar)) {
                int i3 = H ? 300 : 2000;
                synchronized (bArr) {
                    try {
                        bArr.wait(i3);
                    } catch (InterruptedException unused) {
                    }
                }
                if (vbVar.isSuccess()) {
                    vbVar.formatData(vbVar.getData());
                    Bitmap bitmap = vbVar.getBitmap();
                    if (bitmap != null) {
                        return new co(bitmap, vbVar.isGif(), str2);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) ? y35.k().m(str) : (co) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.hg
    public co getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            dd5.g(BigdayImageLoaderProc.class.getSimpleName(), str);
            WebClient webClient = new WebClient();
            if (egVar != null) {
                egVar.a = webClient;
            }
            byte[] downloadImageBytes = webClient.downloadImageBytes(str, false);
            boolean needCache = webClient.needCache();
            if ((downloadImageBytes != null || webClient.getResponse().a) && needCache && !webClient.isCrackPic) {
                vb vbVar = new vb(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, TbMd5.getNameMd5FromUrl(str2), DiskFileOperate.Action.WRITE);
                vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                vbVar.setData(downloadImageBytes);
                vbVar.setSdCard(false);
                vbVar.setSavedCache(true);
                vbVar.setGif(false);
                rb.f().a(vbVar);
                if (egVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(vbVar);
                    egVar.a = diskCancelWorker;
                }
            }
            return null;
        }
        return (co) invokeCommon.objValue;
    }
}
