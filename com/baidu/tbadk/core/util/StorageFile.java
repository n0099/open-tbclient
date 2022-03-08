package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
/* loaded from: classes5.dex */
public class StorageFile {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DIRECTORY_COUNT = 20;
    public static final long MAX_BUBBULE_CACHE_TIME = -1702967296;
    public static StorageFile mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public StorageFile() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void deleteBubbleCache(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, file) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteImageCache(file2);
                        file2.delete();
                    } else if (currentTimeMillis - file2.lastModified() >= MAX_BUBBULE_CACHE_TIME) {
                        file2.delete();
                    }
                }
            }
        }
    }

    private void deleteImageCache(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, file) == null) || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                deleteImageCache(file2);
                file2.delete();
            } else {
                file2.delete();
            }
        }
    }

    public static synchronized StorageFile getInstance() {
        InterceptResult invokeV;
        StorageFile storageFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (StorageFile.class) {
                if (mInstance == null) {
                    mInstance = new StorageFile();
                }
                storageFile = mInstance;
            }
            return storageFile;
        }
        return (StorageFile) invokeV.objValue;
    }

    public void clearBubbleCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            deleteBubbleCache(new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + FileHelper.getPrefixByType(3)));
        }
    }

    public void clearImageCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            deleteImageCache(new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/image"));
            deleteImageCache(new File(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/images"));
        }
    }

    public boolean copyFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String str3 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            if (!FileHelper.CheckTempDir(str3)) {
                FileHelper.makeRootDirectory(str3);
            }
            String str4 = str3 + getDirectoryName(str2);
            if (!FileHelper.CheckTempDir(str4)) {
                FileHelper.makeRootDirectory(str4);
            }
            String str5 = str4 + "/" + str2;
            if (str.equals(str5)) {
                return false;
            }
            return FileHelper.copyFileByRelativelyPath(str, str5, true);
        }
        return invokeLL.booleanValue;
    }

    public String getDirectoryName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return null;
            }
            long j2 = 0;
            for (byte b2 : str.getBytes()) {
                j2 += b2;
            }
            return FileUtils.IMAGE_FILE_START + (j2 % 20);
        }
        return (String) invokeL.objValue;
    }

    public Bitmap getImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return FileHelper.getImage(getDirectoryName(str), str);
        }
        return (Bitmap) invokeL.objValue;
    }

    public int getImageSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return (int) FileHelper.checkImageFileSize(getDirectoryName(str), str);
        }
        return invokeL.intValue;
    }

    public boolean isGif(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return FileHelper.isGif(getDirectoryName(str), str);
        }
        return invokeL.booleanValue;
    }

    public void saveImage(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, bArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.saveFileByBytes(getDirectoryName(str), str, bArr);
    }

    public void saveNineImage(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.saveFileByBytes(FileHelper.getPrefixByType(3), str, bArr);
    }
}
