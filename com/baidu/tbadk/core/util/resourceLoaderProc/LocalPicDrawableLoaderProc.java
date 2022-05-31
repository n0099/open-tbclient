package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jg;
import com.repackage.u25;
import com.repackage.um;
/* loaded from: classes3.dex */
public class LocalPicDrawableLoaderProc extends AbstractImageLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int procType;

    public LocalPicDrawableLoaderProc(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public int getSuggestWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc
    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.repackage.gg
    public um getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            String str3 = str + (TbadkCoreApplication.getInst().getSkinType() == 1 ? SkinManager.nightSufix : "");
            um m = u25.k().m(str3);
            if (m == null) {
                Bitmap bitmap = SkinManager.getBitmap(jg.e(str2, 0));
                if (bitmap == null) {
                    return null;
                }
                um umVar = new um(bitmap, false, str2);
                u25.k().d(str3, umVar);
                return umVar;
            }
            return m;
        }
        return (um) invokeCommon.objValue;
    }
}
