package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.m.d.a;
import b.a.q0.c0.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.resourceLoader.IMImageSize;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class PicManager {
    public static /* synthetic */ Interceptable $ic;
    public static PicManager instance;
    public static final BdUniqueId taskId;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                } finally {
                    return null;
                }
                return null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void addPicMemoryCache(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) {
            c.k().d(str, aVar);
        }
    }

    public static synchronized PicManager getInstance() {
        InterceptResult invokeV;
        PicManager picManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
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

    public Bitmap getFixBitmap(Bitmap bitmap, boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bitmap, Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z2) {
                bitmap = getReSizeBitmap(bitmap);
            }
            if (z && bitmap != null) {
                float f2 = 10.0f;
                bitmap = BitmapHelper.getRoundedCornerBitmap(bitmap, (bitmap.getHeight() < 100 || bitmap.getWidth() < 100) ? 5.0f : 5.0f, true);
            }
            if (!TextUtils.isEmpty(str)) {
                StorageFile.getInstance().saveImage(str, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            return bitmap;
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public IMImageSize getImageSize(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        boolean z2;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int msgSPicMaxSizeInt = LocalViewSize.getInstance().getMsgSPicMaxSizeInt();
            if (z) {
                if (i2 / i3 >= 3) {
                    i5 = i2 / 2;
                    z2 = true;
                    i4 = i2;
                } else if (i3 / i2 >= 3) {
                    i4 = i3 / 2;
                    i5 = i3;
                    z2 = true;
                }
                if (i4 <= i5 && i4 > msgSPicMaxSizeInt) {
                    i6 = (int) (i5 / (i4 / msgSPicMaxSizeInt));
                } else if (i5 > i4 || i5 <= msgSPicMaxSizeInt) {
                    msgSPicMaxSizeInt = i4;
                    i6 = i5;
                } else {
                    msgSPicMaxSizeInt = (int) (i4 / (i5 / msgSPicMaxSizeInt));
                    i6 = msgSPicMaxSizeInt;
                }
                if (z2 && i2 <= msgSPicMaxSizeInt && i3 <= i6) {
                    i6 = (int) (i6 * 0.9d);
                    msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
                }
                if (msgSPicMaxSizeInt < 70 && i6 < 70) {
                    i6 = 70;
                    msgSPicMaxSizeInt = 70;
                }
                return new IMImageSize(msgSPicMaxSizeInt, i6, z2);
            }
            i4 = i2;
            i5 = i3;
            z2 = false;
            if (i4 <= i5) {
            }
            if (i5 > i4) {
            }
            msgSPicMaxSizeInt = i4;
            i6 = i5;
            if (z2) {
                i6 = (int) (i6 * 0.9d);
                msgSPicMaxSizeInt = (int) (msgSPicMaxSizeInt * 0.9d);
            }
            if (msgSPicMaxSizeInt < 70) {
                i6 = 70;
                msgSPicMaxSizeInt = 70;
            }
            return new IMImageSize(msgSPicMaxSizeInt, i6, z2);
        }
        return (IMImageSize) invokeCommon.objValue;
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? getReSizeBitmap(bitmap, true) : (Bitmap) invokeL.objValue;
    }

    public void saveImageToCacheDisk(String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || str2 == null || str == null) {
            return;
        }
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
        StorageFile.getInstance().copyFile(str2, nameMd5FromUrl);
        if (z || z2 || z3) {
            synchronized (BitmapHelper.lockForSyncImageDecoder) {
                int imageSize = StorageFile.getInstance().getImageSize(nameMd5FromUrl);
                if (imageSize <= 0) {
                    return;
                }
                if (z) {
                    Bitmap image = StorageFile.getInstance().getImage(nameMd5FromUrl);
                    c.k().i(imageSize);
                    if (image != null) {
                        addPicMemoryCache(str, image, z2, StorageFile.getInstance().isGif(nameMd5FromUrl), z3, nameMd5FromUrl);
                    }
                }
            }
        }
    }

    public void saveImageToCacheDiskAsync(String str, String str2, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            new SaveImgCacheAsyncTask(this, str2, str2, z3, z3, z3).execute(new String[0]);
        }
    }

    private void addPicMemoryCache(String str, Bitmap bitmap, boolean z, boolean z2, boolean z3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{str, bitmap, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), str2}) == null) {
            try {
                Bitmap fixBitmap = getFixBitmap(bitmap, z, z3, str2);
                if (fixBitmap == null) {
                    return;
                }
                addPicMemoryCache(str, new a(fixBitmap, z2));
            } catch (Exception e2) {
                TiebaStatic.imgError(-1006, "addPicMemoryCache error: " + e2.toString(), str);
            }
        }
    }

    public Bitmap getReSizeBitmap(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, bitmap, z)) == null) {
            try {
                IMImageSize imageSize = getImageSize(bitmap.getWidth(), bitmap.getHeight(), z);
                int i2 = imageSize.width;
                int i3 = imageSize.height;
                if (i2 == bitmap.getWidth() && i3 == bitmap.getHeight()) {
                    return bitmap;
                }
                Bitmap resizedBitmap = BitmapHelper.getResizedBitmap(bitmap, i2, i3);
                return resizedBitmap != null ? resizedBitmap : bitmap;
            } catch (Exception e2) {
                FieldBuilder fieldBuilder = new FieldBuilder();
                if (bitmap == null) {
                    fieldBuilder.append("bitmap", StringUtil.NULL_STRING);
                } else {
                    fieldBuilder.append("bitW", Integer.valueOf(bitmap.getWidth()));
                    fieldBuilder.append("bitH", Integer.valueOf(bitmap.getHeight()));
                }
                TiebaStatic.imgError(-1005, "getResizedBitmap error: " + e2.toString(), fieldBuilder.toString());
                return bitmap;
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }
}
