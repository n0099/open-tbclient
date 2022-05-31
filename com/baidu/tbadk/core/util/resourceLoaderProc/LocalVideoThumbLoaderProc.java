package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.media.ThumbnailUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dg;
import com.repackage.gg;
import com.repackage.u25;
import com.repackage.um;
import java.io.File;
/* loaded from: classes3.dex */
public class LocalVideoThumbLoaderProc implements gg<um> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public LocalVideoThumbLoaderProc() {
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

    public um createVideoThumbnail(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, str, i, i2)) == null) {
            try {
                if (new File(str).exists()) {
                    return new um(BitmapHelper.checkBitmapSize(ThumbnailUtils.createVideoThumbnail(str, 1), i, i2), false, str);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (um) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public um m48decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, objArr)) == null) {
            return null;
        }
        return (um) invokeLL.objValue;
    }

    @Override // com.repackage.gg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.gg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromRemote(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            return null;
        }
        return (um) invokeCommon.objValue;
    }

    @Override // com.repackage.gg
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
            return "videoThumb_" + str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.repackage.gg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof um)) {
            um umVar = (um) obj;
            if (umVar.u()) {
                umVar.A(i);
                umVar.z(i2);
                u25.k().d(toCacheKey(str), umVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromLocal(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return createVideoThumbnail(str, i, i2);
        }
        return (um) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public um getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            um checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str), u25.k().m(toCacheKey(str)), i, i2);
            if (checkIsValidPicMemoryCache == null || checkIsValidPicMemoryCache.p() == null || checkIsValidPicMemoryCache.p().isRecycled()) {
                return null;
            }
            return checkIsValidPicMemoryCache;
        }
        return (um) invokeCommon.objValue;
    }
}
