package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import android.text.TextUtils;
import c.a.d.f.a.d;
import c.a.d.f.a.f.c;
import c.a.d.f.l.b;
import c.a.d.f.p.n;
import c.a.u0.a4.e;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SimpleLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsForceLoad;
    public boolean mIsFromCDN;
    public boolean mIsNeedFormat;
    public int mProcType;
    public int mSuggestHeight;
    public int mSuggestWidth;

    public SimpleLoaderProc(boolean z, boolean z2, boolean z3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsFromCDN = z;
        this.mIsNeedFormat = z2;
        this.mIsForceLoad = z3;
        this.mProcType = i2;
        int k = n.k(TbadkCoreApplication.getInst());
        int i5 = n.i(TbadkCoreApplication.getInst());
        if (i2 == 13) {
            k = k <= 0 ? 200 : k;
            this.mSuggestWidth = k;
            if (k > 480) {
                this.mSuggestWidth = 480;
            }
            if (this.mSuggestWidth > n.d(TbadkCoreApplication.getInst(), 320.0f)) {
                this.mSuggestWidth = n.d(TbadkCoreApplication.getInst(), 320.0f);
            }
            this.mSuggestHeight = this.mSuggestWidth;
        } else if (i2 == 17) {
            int min = Math.min(n.d(TbadkCoreApplication.getInst().getApp(), 427.0f), 640);
            this.mSuggestWidth = min;
            this.mSuggestHeight = (int) (min * 1.6f);
        } else if (i2 == 15) {
            int dimensionPixelSize = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.ds184);
            this.mSuggestHeight = dimensionPixelSize;
            this.mSuggestWidth = dimensionPixelSize;
        } else if (i2 == 16) {
            int dimensionPixelSize2 = TbadkCoreApplication.getInst().getApp().getResources().getDimensionPixelSize(e.ds176);
            this.mSuggestHeight = dimensionPixelSize2;
            this.mSuggestWidth = dimensionPixelSize2;
        } else if (i2 == 21) {
            this.mSuggestHeight = 0;
            this.mSuggestWidth = 0;
        } else if (i2 == 30) {
            if (k <= 0 || k > 644) {
                this.mSuggestWidth = 644;
            }
            if (this.mSuggestWidth > n.d(TbadkCoreApplication.getInst().getApp(), 430.0f)) {
                this.mSuggestWidth = n.d(TbadkCoreApplication.getInst().getApp(), 430.0f);
            }
            this.mSuggestHeight = (int) (this.mSuggestWidth * 0.43f);
        } else if (i2 == 46) {
            int i6 = (k * 2) / 3;
            this.mSuggestWidth = i6;
            this.mSuggestHeight = (i6 * 4) / 3;
        } else {
            this.mSuggestWidth = k;
            this.mSuggestHeight = i5;
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getProcType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mProcType : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSuggestHeight : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSuggestWidth : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsFromCDN : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, c.a.d.f.l.e
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
    public Bitmap resizeBitmapSize(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bitmap, i2, i3)) == null) {
            int i4 = this.mProcType;
            return (i4 == 13 || i4 == 17) ? bitmap : super.resizeBitmapSize(bitmap, i2, i3);
        }
        return (Bitmap) invokeLII.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, str, bArr, objArr) == null) || TextUtils.isEmpty(str) || bArr == null) {
            return;
        }
        boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
        boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
        if (!booleanValue || booleanValue2) {
            return;
        }
        boolean booleanValue3 = ((Boolean) objArr[2]).booleanValue();
        c cVar = new c("images", TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE);
        cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.setSubFolder(true);
        cVar.setData(bArr);
        cVar.setSdCard(false);
        cVar.setSavedCache(true);
        cVar.setGif(booleanValue3);
        cVar.f(this.mIsNeedFormat);
        d.f().a(cVar);
        b bVar = (b) objArr[3];
        if (bVar != null) {
            DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
            diskCancelWorker.setOperate(cVar);
            bVar.a = diskCancelWorker;
        }
    }
}
