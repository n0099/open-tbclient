package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.R;
import com.baidu.tieba.in;
import com.baidu.tieba.xi;
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

    /* loaded from: classes4.dex */
    public class SaveImgCacheAsyncTask extends BdAsyncTask<String, String, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String imageUrl;
        public final boolean isNeedReSize;
        public final boolean isNeedRound;
        public final String localFileFullPath;
        public final boolean put2MemoryCache;
        public final /* synthetic */ PicManager this$0;

        public SaveImgCacheAsyncTask(PicManager picManager, String str, String str2, boolean z, boolean z2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {picManager, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = picManager;
            this.imageUrl = str;
            this.localFileFullPath = str2;
            this.put2MemoryCache = z;
            this.isNeedRound = z2;
            this.isNeedReSize = z3;
            setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, PicManager.taskId));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                try {
                    this.this$0.saveImageToCacheDisk(this.imageUrl, this.localFileFullPath, this.put2MemoryCache, this.isNeedRound, this.isNeedReSize);
                    return null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }
    }

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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
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

    private void addPicMemoryCache(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{str, bitmap, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) {
            try {
                Bitmap fixBitmap = getFixBitmap(bitmap, z, z3, str2);
                if (fixBitmap == null) {
                    return;
                }
                addPicMemoryCache(str, new in(fixBitmap, z2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void addPicMemoryCache(String str, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, inVar) == null) {
            TbImageMemoryCache.u().l(str, inVar);
        }
    }

    public IMImageSize getChatImageSize(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            int g = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds408);
            int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds174);
            float f = (i * 1.0f) / i2;
            int i3 = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i3 == 0) {
                i = g;
                i2 = i;
            } else if (i3 > 0 && f < 2.4f) {
                i2 = (int) ((g * 1.0f) / f);
                i = g;
            } else if (f >= 2.4f) {
                i = g;
                i2 = g2;
            } else if (f < 1.0f && f > 0.41666666f) {
                i = (int) (g * f);
                i2 = g;
            } else if (f <= 0.41666666f) {
                i2 = g;
                i = g2;
            }
            return new IMImageSize(i, i2, false);
        }
        return (IMImageSize) invokeII.objValue;
    }

    public Bitmap getFixBitmap(Bitmap bitmap, boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z2) {
                bitmap = getReSizeBitmap(bitmap);
            }
            if (z && bitmap != null) {
                float f = 10.0f;
                bitmap = BitmapHelper.getRoundedCornerBitmap(bitmap, (bitmap.getHeight() < 100 || bitmap.getWidth() < 100) ? 5.0f : 5.0f, true);
            }
            if (!TextUtils.isEmpty(str)) {
                StorageFile.getInstance().saveImage(str, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public IMImageSize getImageSize(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        int i3;
        int i4;
        boolean z2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmap)) == null) {
            return getReSizeBitmap(bitmap, true);
        }
        return (Bitmap) invokeL.objValue;
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, bitmap, z)) == null) {
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

    public void saveImageToCacheDisk(String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && str2 != null && str != null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
            StorageFile.getInstance().copyFile(str2, nameMd5FromUrl);
            if (!z && !z2 && !z3) {
                return;
            }
            synchronized (BitmapHelper.lockForSyncImageDecoder) {
                int imageSize = StorageFile.getInstance().getImageSize(nameMd5FromUrl);
                if (imageSize <= 0) {
                    return;
                }
                if (z) {
                    Bitmap image = StorageFile.getInstance().getImage(nameMd5FromUrl);
                    TbImageMemoryCache.u().s(imageSize);
                    if (image != null) {
                        addPicMemoryCache(str, image, z2, StorageFile.getInstance().isGif(nameMd5FromUrl), z3, nameMd5FromUrl);
                    }
                }
            }
        }
    }

    public void saveImageToCacheDiskAsync(String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            new SaveImgCacheAsyncTask(this, str2, str2, z3, z3, z3).execute(new String[0]);
        }
    }
}
