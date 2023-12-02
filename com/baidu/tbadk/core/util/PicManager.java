package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PicManager {
    public static /* synthetic */ Interceptable $ic;
    public static PicManager instance;
    public static final BdUniqueId taskId;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1625780984, "Lcom/baidu/tbadk/core/util/PicManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1625780984, "Lcom/baidu/tbadk/core/util/PicManager;");
                return;
            }
        }
        taskId = BdUniqueId.gen();
    }

    public PicManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized PicManager getInstance() {
        InterceptResult invokeV;
        PicManager picManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (PicManager.class) {
                if (instance == null) {
                    instance = new PicManager();
                }
                picManager = instance;
            }
            return picManager;
        }
        return (PicManager) invokeV.objValue;
    }

    public IMImageSize getChatImageSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds408);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds174);
            float f = (i * 1.0f) / i2;
            int i3 = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i3 == 0) {
                i = dimens;
                i2 = i;
            } else if (i3 > 0 && f < 2.4f) {
                i2 = (int) ((dimens * 1.0f) / f);
                i = dimens;
            } else if (f >= 2.4f) {
                i = dimens;
                i2 = dimens2;
            } else if (f < 1.0f && f > 0.41666666f) {
                i = (int) (dimens * f);
                i2 = dimens;
            } else if (f <= 0.41666666f) {
                i2 = dimens;
                i = dimens2;
            }
            return new IMImageSize(i, i2, false);
        }
        return (IMImageSize) invokeII.objValue;
    }

    public IMImageSize getImageSize(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        boolean z2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int msgSPicMaxSizeInt = LocalViewSize.getInstance().getMsgSPicMaxSizeInt();
            if (z) {
                if (i / i2 >= 3) {
                    i4 = i / 2;
                    z2 = true;
                    i3 = i;
                } else if (i2 / i >= 3) {
                    i3 = i2 / 2;
                    i4 = i2;
                    z2 = true;
                }
                if (i3 <= i4 && i3 > msgSPicMaxSizeInt) {
                    i5 = (int) (i4 / (i3 / msgSPicMaxSizeInt));
                } else if (i4 <= i3 && i4 > msgSPicMaxSizeInt) {
                    msgSPicMaxSizeInt = (int) (i3 / (i4 / msgSPicMaxSizeInt));
                    i5 = msgSPicMaxSizeInt;
                } else {
                    msgSPicMaxSizeInt = i3;
                    i5 = i4;
                }
                if (z2 && i <= msgSPicMaxSizeInt && i2 <= i5) {
                    i5 = (int) (i5 * 0.9d);
                    msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
                }
                if (msgSPicMaxSizeInt < 70 && i5 < 70) {
                    i5 = 70;
                    msgSPicMaxSizeInt = 70;
                }
                return new IMImageSize(msgSPicMaxSizeInt, i5, z2);
            }
            i3 = i;
            i4 = i2;
            z2 = false;
            if (i3 <= i4) {
            }
            if (i4 <= i3) {
            }
            msgSPicMaxSizeInt = i3;
            i5 = i4;
            if (z2) {
                i5 = (int) (i5 * 0.9d);
                msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
            }
            if (msgSPicMaxSizeInt < 70) {
                i5 = 70;
                msgSPicMaxSizeInt = 70;
            }
            return new IMImageSize(msgSPicMaxSizeInt, i5, z2);
        }
        return (IMImageSize) invokeCommon.objValue;
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) {
            return getReSizeBitmap(bitmap, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, bitmap, z)) == null) {
            try {
                IMImageSize imageSize = getImageSize(bitmap.getWidth(), bitmap.getHeight(), z);
                int i = imageSize.width;
                int i2 = imageSize.height;
                if (i == bitmap.getWidth() && i2 == bitmap.getHeight()) {
                    return bitmap;
                }
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i, i2);
                if (resizedBitmap != null) {
                    return resizedBitmap;
                }
                return bitmap;
            } catch (Exception unused) {
                FieldBuilder fieldBuilder = new FieldBuilder();
                if (bitmap == null) {
                    fieldBuilder.append("bitmap", StringUtil.NULL_STRING);
                } else {
                    fieldBuilder.append("bitW", Integer.valueOf(bitmap.getWidth()));
                    fieldBuilder.append("bitH", Integer.valueOf(bitmap.getHeight()));
                }
                return bitmap;
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }
}
