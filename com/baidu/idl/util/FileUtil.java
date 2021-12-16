package com.baidu.idl.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes10.dex */
public class FileUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FileUtil";
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean createFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists() && file.length() > 3145728) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            try {
                file.createNewFile();
                return true;
            } catch (IOException e2) {
                StuLogEx.e("FileUtil", "创建文件失败", e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean loadPropertiesFile(File file, Properties properties) {
        InterceptResult invokeLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, properties)) == null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                properties.load(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream2 = bufferedInputStream;
                StuLogEx.e("FileUtil", e.getMessage(), e);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean savePropertiesFile(File file, Properties properties) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, file, properties)) == null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream2 = bufferedOutputStream;
                StuLogEx.e("FileUtil", e.getMessage(), e);
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
