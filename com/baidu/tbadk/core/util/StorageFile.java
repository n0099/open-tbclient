package com.baidu.tbadk.core.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
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
            deleteBubbleCache(new File(FileHelper.EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + FileHelper.getPrefixByType(3)));
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

    public String getDirectoryName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            long j = 0;
            for (byte b : str.getBytes()) {
                j += b;
            }
            return "image/" + (j % 20);
        }
        return (String) invokeL.objValue;
    }

    private void deleteImageCache(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, file) == null) && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteImageCache(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }
}
