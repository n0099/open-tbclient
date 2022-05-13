package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.co;
import com.repackage.dg;
import com.repackage.eg;
import com.repackage.ki;
import com.repackage.mi;
import com.repackage.rb;
import com.repackage.vb;
/* loaded from: classes3.dex */
public class SimpleForeverLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isFromCDN;
    public int procType;

    public SimpleForeverLoaderProc(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i)};
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
        this.procType = 0;
        this.isFromCDN = z;
        this.procType = i;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.procType : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? mi.i(TbadkCoreApplication.getInst().getApp()) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? mi.k(TbadkCoreApplication.getInst().getApp()) : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isFromCDN : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, bArr, objArr) == null) || TextUtils.isEmpty(str) || bArr == null || !((Boolean) objArr[0]).booleanValue()) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
        vb vbVar = new vb("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        vbVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        vbVar.setSubFolder(true);
        vbVar.setData(bArr);
        vbVar.setSdCard(false);
        vbVar.setGif(booleanValue);
        rb.f().a(vbVar);
        eg egVar = (eg) objArr[3];
        if (egVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(vbVar);
            egVar.a = diskCancelWorker;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.repackage.hg
    public co getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[0];
            vb createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            createDiskPicOperate.setSdCard(false);
            if (egVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                egVar.a = diskCancelWorker;
            }
            if (!rb.f().a(createDiskPicOperate)) {
                dg.f(false, 0L);
                return null;
            }
            int i3 = ki.H() ? 300 : 2000;
            synchronized (bArr) {
                try {
                    bArr.wait(i3);
                } catch (InterruptedException unused) {
                }
            }
            co createImageFromDiskPicOperate = createDiskPicOperate.isSuccess() ? createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2) : null;
            dg.f(createImageFromDiskPicOperate != null, System.currentTimeMillis() - currentTimeMillis);
            return createImageFromDiskPicOperate;
        }
        return (co) invokeCommon.objValue;
    }
}
