package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.R;
import com.baidu.tieba.fc;
import com.baidu.tieba.jc;
import com.baidu.tieba.qg;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SimpleLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsForceLoad;
    public boolean mIsFromCDN;
    public boolean mIsNeedFormat;
    public int mProcType;
    public int mSuggestHeight;
    public int mSuggestWidth;

    public SimpleLoaderProc(boolean z, boolean z2, boolean z3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsFromCDN = z;
        this.mIsNeedFormat = z2;
        this.mIsForceLoad = z3;
        this.mProcType = i;
        int l = yi.l(TbadkCoreApplication.getInst());
        int j = yi.j(TbadkCoreApplication.getInst());
        if (i == 13) {
            l = l <= 0 ? 200 : l;
            this.mSuggestWidth = l;
            if (l > 480) {
                this.mSuggestWidth = 480;
            }
            if (this.mSuggestWidth > yi.d(TbadkCoreApplication.getInst(), 320.0f)) {
                this.mSuggestWidth = yi.d(TbadkCoreApplication.getInst(), 320.0f);
            }
            this.mSuggestHeight = this.mSuggestWidth;
        } else if (i == 17) {
            int min = Math.min(yi.d(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
            this.mSuggestWidth = min;
            this.mSuggestHeight = (int) (min * 1.6f);
        } else if (i == 15) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070387);
            this.mSuggestHeight = dimensionPixelSize;
            this.mSuggestWidth = dimensionPixelSize;
        } else if (i == 16) {
            int dimensionPixelSize2 = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070383);
            this.mSuggestHeight = dimensionPixelSize2;
            this.mSuggestWidth = dimensionPixelSize2;
        } else if (i == 21) {
            this.mSuggestHeight = 0;
            this.mSuggestWidth = 0;
        } else if (i == 30) {
            if (l <= 0 || l > 644) {
                this.mSuggestWidth = 644;
            }
            if (this.mSuggestWidth > yi.d(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
                this.mSuggestWidth = yi.d(TbadkCoreApplication.getInst().getApp(), 430.0f);
            }
            this.mSuggestHeight = (int) (this.mSuggestWidth * 0.43f);
        } else if (i == 46) {
            int i4 = (l * 2) / 3;
            this.mSuggestWidth = i4;
            this.mSuggestHeight = (i4 * 4) / 3;
        } else {
            this.mSuggestWidth = l;
            this.mSuggestHeight = j;
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mProcType;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mSuggestHeight;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSuggestWidth;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mIsFromCDN;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.tg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mIsForceLoad) {
                return true;
            }
            return super.isNeedLoad();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public Bitmap resizeBitmapSize(Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bitmap, i, i2)) == null) {
            int i3 = this.mProcType;
            if (i3 != 13 && i3 != 17) {
                return super.resizeBitmapSize(bitmap, i, i2);
            }
            return bitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, str, bArr, objArr) == null) && !TextUtils.isEmpty(str) && bArr != null) {
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            if (booleanValue && !booleanValue2) {
                boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
                jc jcVar = new jc("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
                jcVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
                jcVar.setSubFolder(true);
                jcVar.setData(bArr);
                jcVar.setSdCard(false);
                jcVar.setSavedCache(true);
                jcVar.setGif(booleanValue3);
                jcVar.f(this.mIsNeedFormat);
                fc.f().a(jcVar);
                qg qgVar = (qg) objArr[3];
                if (qgVar != null) {
                    DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                    diskCancelWorker.setOperate(jcVar);
                    qgVar.a = diskCancelWorker;
                }
            }
        }
    }
}
