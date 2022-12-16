package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FSBitmapCache implements IBitmapCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mHitCountRequired;
    public Map<String, Integer> mMap;
    public int mMaxNumOfPixels;
    public IBitmapCache mMemCache;
    public String mStorageDir;

    public FSBitmapCache(String str, int i, int i2, IBitmapCache iBitmapCache) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2), iBitmapCache};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMap = new HashMap();
        this.mStorageDir = str;
        this.mHitCountRequired = i;
        this.mMaxNumOfPixels = i2;
        this.mMemCache = iBitmapCache;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public void clean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (String str : this.mMap.keySet()) {
                delete(str);
            }
            this.mMap.clear();
        }
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            new File(getFilePath(str)).delete();
        }
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public boolean exists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new File(getFilePath(str)).exists();
        }
        return invokeL.booleanValue;
    }

    public String getFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.mStorageDir + "/" + str + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public FSBitmapCache setHitCountRequired(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.mHitCountRequired = i;
            return this;
        }
        return (FSBitmapCache) invokeI.objValue;
    }

    public FSBitmapCache setMaxNumOfPixels(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.mMaxNumOfPixels = i;
            return this;
        }
        return (FSBitmapCache) invokeI.objValue;
    }

    public FSBitmapCache setStorageDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.mStorageDir = str;
            return this;
        }
        return (FSBitmapCache) invokeL.objValue;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public Bitmap get(String str) {
        InterceptResult invokeL;
        IBitmapCache iBitmapCache;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!exists(str)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(getFilePath(str), options);
            options.inSampleSize = AsyncImageLoader.computeSampleSize(options, -1, this.mMaxNumOfPixels);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(getFilePath(str), options);
            if (decodeFile == null) {
                return null;
            }
            Integer num = this.mMap.get(str);
            if (num == null) {
                num = 0;
            }
            if (num.intValue() + 1 >= this.mHitCountRequired && (iBitmapCache = this.mMemCache) != null) {
                iBitmapCache.put(str, decodeFile);
                this.mMap.remove(str);
                return decodeFile;
            }
            this.mMap.put(str, Integer.valueOf(num.intValue() + 1));
            return decodeFile;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.cloudsdk.common.imgloader.IBitmapCache
    public void put(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, bitmap) == null) {
            File file = new File(getFilePath(str));
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        file.createNewFile();
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    this.mMap.put(str, 1);
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    Log.e(FSBitmapCache.class.getSimpleName(), e.toString());
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
        }
    }
}
