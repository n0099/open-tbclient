package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.j7;
import com.baidu.tieba.n7;
import com.baidu.tieba.qb;
import com.baidu.tieba.rb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.sb
    public BdImage getFromLocal(String str, String str2, int i, int i2, rb rbVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), rbVar, objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            byte[] bArr = new byte[0];
            n7 createDiskPicOperate = createDiskPicOperate(TbMd5.getNameMd5FromUrl(str2));
            BdImage bdImage = null;
            if (createDiskPicOperate == null) {
                return null;
            }
            createDiskPicOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            createDiskPicOperate.setSubFolder(true);
            createDiskPicOperate.setIsFormatData(false);
            createDiskPicOperate.setLock(bArr);
            createDiskPicOperate.setSdCard(false);
            if (rbVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(createDiskPicOperate);
                rbVar.a = diskCancelWorker;
            }
            if (!j7.g().a(createDiskPicOperate)) {
                qb.f(false, 0L);
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
            if (createDiskPicOperate.isSuccess()) {
                bdImage = createImageFromDiskPicOperate(createDiskPicOperate, str2, i, i2);
            }
            if (bdImage != null) {
                z = true;
            }
            qb.f(z, System.currentTimeMillis() - currentTimeMillis);
            return bdImage;
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.procType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isFromCDN;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, bArr, objArr) != null) || TextUtils.isEmpty(str) || bArr == null || !((Boolean) objArr[0]).booleanValue()) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[2]).booleanValue();
        n7 n7Var = new n7("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        n7Var.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        n7Var.setSubFolder(true);
        n7Var.setData(bArr);
        n7Var.setSdCard(false);
        n7Var.setGif(booleanValue);
        j7.g().a(n7Var);
        rb rbVar = (rb) objArr[3];
        if (rbVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(n7Var);
            rbVar.a = diskCancelWorker;
        }
    }
}
