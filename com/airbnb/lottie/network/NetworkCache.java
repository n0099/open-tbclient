package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.Logger;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class NetworkCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context appContext;

    public NetworkCache(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.appContext = context.getApplicationContext();
    }

    public static String filenameForUrl(String str, FileExtension fileExtension, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, str, fileExtension, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("lottie_cache_");
            sb.append(str.replaceAll("\\W+", ""));
            sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    @Nullable
    private File getCachedFile(String str) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            File file = new File(parentDir(), filenameForUrl(str, FileExtension.JSON, false));
            if (file.exists()) {
                return file;
            }
            File file2 = new File(parentDir(), filenameForUrl(str, FileExtension.ZIP, false));
            if (file2.exists()) {
                return file2;
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    private File parentDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            File file = new File(this.appContext.getCacheDir(), "lottie_network_cache");
            if (file.isFile()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            File parentDir = parentDir();
            if (parentDir.exists()) {
                File[] listFiles = parentDir.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file : parentDir.listFiles()) {
                        file.delete();
                    }
                }
                parentDir.delete();
            }
        }
    }

    @Nullable
    @WorkerThread
    public Pair<FileExtension, InputStream> fetch(String str) {
        InterceptResult invokeL;
        FileExtension fileExtension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                File cachedFile = getCachedFile(str);
                if (cachedFile == null) {
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(cachedFile);
                if (cachedFile.getAbsolutePath().endsWith(".zip")) {
                    fileExtension = FileExtension.ZIP;
                } else {
                    fileExtension = FileExtension.JSON;
                }
                Logger.debug("Cache hit for " + str + " at " + cachedFile.getAbsolutePath());
                return new Pair<>(fileExtension, fileInputStream);
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        return (Pair) invokeL.objValue;
    }

    public void renameTempFile(String str, FileExtension fileExtension) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, fileExtension) == null) {
            File file = new File(parentDir(), filenameForUrl(str, fileExtension, true));
            File file2 = new File(file.getAbsolutePath().replace(XAdSimpleImageLoader.TEMP_SUFFIX, ""));
            boolean renameTo = file.renameTo(file2);
            Logger.debug("Copying temp file to real file (" + file2 + SmallTailInfo.EMOTION_SUFFIX);
            if (renameTo) {
                return;
            }
            Logger.warning("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    public File writeTempCacheFile(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(1048579, this, str, inputStream, fileExtension)) != null) {
            return (File) invokeLLL.objValue;
        }
        File file = new File(parentDir(), filenameForUrl(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
