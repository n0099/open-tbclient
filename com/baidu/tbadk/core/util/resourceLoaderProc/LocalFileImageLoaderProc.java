package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hg;
import com.repackage.kg;
import com.repackage.l45;
import com.repackage.pi;
import com.repackage.x45;
import com.repackage.ym;
/* loaded from: classes3.dex */
public class LocalFileImageLoaderProc implements kg<ym> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public int width;

    public LocalFileImageLoaderProc() {
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
        this.width = 0;
        this.height = 0;
        initDefalutMaxSize();
    }

    private void initDefalutMaxSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.width = pi.k(TbadkCoreApplication.getInst());
            this.height = pi.i(TbadkCoreApplication.getInst());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public ym m46decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (ym) invokeLL.objValue;
    }

    @Override // com.repackage.kg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.kg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public ym getBitmapFromFile(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, str, i, i2)) == null) {
            try {
                if (str.toLowerCase().endsWith(".gif")) {
                    return new ym(BitmapHelper.loadBitmap(str), true, str);
                }
                return new ym(BitmapHelper.checkBitmapSize(BitmapHelper.loadResizedBitmap(str, this.width, this.height), i, i2), false, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (ym) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromRemote(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            return null;
        }
        return (ym) invokeCommon.objValue;
    }

    @Override // com.repackage.kg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, str, bArr, objArr) == null) {
        }
    }

    public String toCacheKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            ImageOperation g = x45.g(this.width, this.height);
            return "image_" + str + ':' + g.actionName + '=' + g.actionParam;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.kg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof ym)) {
            ym ymVar = (ym) obj;
            if (ymVar.u()) {
                ymVar.A(i);
                ymVar.z(i2);
                l45.k().d(toCacheKey(str), ymVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromLocal(String str, String str2, int i, int i2, hg hgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), hgVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return getBitmapFromFile(str, i, i2);
        }
        return (ym) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.kg
    public ym getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            ym checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str), l45.k().m(toCacheKey(str)), i, i2);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (ym) invokeCommon.objValue;
    }

    public LocalFileImageLoaderProc(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.width = 0;
        this.height = 0;
        if (i > 0 && i2 > 0) {
            this.width = i;
            this.height = i2;
            return;
        }
        initDefalutMaxSize();
    }
}
