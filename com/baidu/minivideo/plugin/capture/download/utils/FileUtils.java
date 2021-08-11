package com.baidu.minivideo.plugin.capture.download.utils;

import android.content.Context;
import android.os.Environment;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOWNLOAD_DIR = "UgcDownload";
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtils() {
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

    public static final File getDefaultDownloadDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (isSDMounted()) {
                return new File(context.getExternalCacheDir(), DOWNLOAD_DIR);
            }
            return new File(context.getCacheDir(), DOWNLOAD_DIR);
        }
        return (File) invokeL.objValue;
    }

    public static final String getFileFullName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? str.substring(str.lastIndexOf("/") + 1, str.length()) : (String) invokeL.objValue;
    }

    public static final String getPrefix(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str.substring(0, str.lastIndexOf(".")) : (String) invokeL.objValue;
    }

    public static final String getSuffix(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? str.substring(str.lastIndexOf(".") + 1) : (String) invokeL.objValue;
    }

    public static boolean isSDMounted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }
}
