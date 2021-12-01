package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes8.dex */
public class PassBioFileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PassBioFileUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public PassBioFileUtils() {
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

    public static boolean checkAndCreadFile(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file.exists()) {
                return true;
            }
            file.getParentFile().mkdirs();
            return file.createNewFile();
        }
        return invokeL.booleanValue;
    }

    public static boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (isFileExist(str)) {
                return deleteFile(new File(str));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean isFileExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, file, bArr)) == null) ? write(file, bArr, true) : invokeLL.booleanValue;
    }

    public static boolean write(File file, byte[] bArr, boolean z) throws IOException {
        InterceptResult invokeLLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65542, null, file, bArr, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (file.canWrite()) {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    return true;
                } catch (Throwable unused) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            try {
                return file.delete();
            } catch (Exception e2) {
                Log.e(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
