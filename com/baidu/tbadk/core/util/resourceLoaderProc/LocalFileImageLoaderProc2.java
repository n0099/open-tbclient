package com.baidu.tbadk.core.util.resourceLoaderProc;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.eg;
import com.baidu.tieba.fg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class LocalFileImageLoaderProc2 implements fg<BdImage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public int width;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public BdImage m126decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (BdImage) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg
    public BdImage getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.fg
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

    public LocalFileImageLoaderProc2() {
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
            this.width = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            this.height = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
        }
    }

    public LocalFileImageLoaderProc2(int i, int i2) {
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

    public BdImage getBitmapFromFile(String str, int i, int i2) {
        Bitmap loadResizedBitmap;
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, str, i, i2)) == null) {
            try {
                if (str.toLowerCase().endsWith(".gif")) {
                    return new BdImage(BitmapHelper.loadBitmap(str), true, str);
                }
                if (i > 0 && i2 > 0 && i < this.width && i2 < this.height) {
                    loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, i, i2);
                } else {
                    loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, this.width, this.height);
                }
                return new BdImage(loadResizedBitmap, false, str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (BdImage) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg
    public BdImage getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), egVar, objArr})) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return getBitmapFromFile(str, i, i2);
        }
        return (BdImage) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.fg
    public BdImage getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            BdImage checkIsValidPicMemoryCache = BitmapHelper.checkIsValidPicMemoryCache(toCacheKey(str, i, i2), TbImageMemoryCache.A().D(toCacheKey(str, i, i2)), i, i2);
            if (checkIsValidPicMemoryCache != null && checkIsValidPicMemoryCache.getRawBitmap() != null && !checkIsValidPicMemoryCache.getRawBitmap().isRecycled()) {
                return checkIsValidPicMemoryCache;
            }
            return null;
        }
        return (BdImage) invokeCommon.objValue;
    }

    public String toCacheKey(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048589, this, str, i, i2)) == null) {
            return "localimage_" + str + ":w=" + i + "&h=" + i2;
        }
        return (String) invokeLII.objValue;
    }

    @Override // com.baidu.tieba.fg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && obj != null && (obj instanceof BdImage)) {
            BdImage bdImage = (BdImage) obj;
            if (bdImage.isNeedCache()) {
                bdImage.setRequestWidth(i);
                bdImage.setRequestHeight(i2);
                TbImageMemoryCache.A().l(toCacheKey(str, i, i2), bdImage);
            }
        }
    }
}
