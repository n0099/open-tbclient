package com.baidu.searchbox.aperf.bosuploader;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.Closeables;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* loaded from: classes2.dex */
public class FileUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FileUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1983395485, "Lcom/baidu/searchbox/aperf/bosuploader/FileUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1983395485, "Lcom/baidu/searchbox/aperf/bosuploader/FileUtil;");
        }
    }

    public FileUtil() {
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

    public static String readFromFileInputStream(FileInputStream fileInputStream) {
        InterceptResult invokeL;
        IOException e2;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fileInputStream)) == null) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader2 = null;
            if (fileInputStream != null) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    try {
                        try {
                            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                sb.append(readLine);
                            }
                            bufferedReader2 = bufferedReader;
                        } catch (IOException e3) {
                            e2 = e3;
                            Log.e(TAG, e2.getMessage(), e2);
                            Closeables.closeSafely(bufferedReader);
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        Closeables.closeSafely(bufferedReader2);
                        throw th;
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(bufferedReader2);
                    throw th;
                }
            }
            Closeables.closeSafely(bufferedReader2);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void writeDataToFile(File file, String str) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, file, str) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
            try {
                writeDataToFile(fileOutputStream, str);
                Closeables.closeSafely(fileOutputStream);
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                Log.e(TAG, e.getMessage(), e);
                Closeables.closeSafely(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(fileOutputStream2);
                throw th;
            }
        }
    }

    public static void writeDataToFile(FileOutputStream fileOutputStream, String str) {
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fileOutputStream, str) == null) {
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(str);
                bufferedWriter.flush();
                Closeables.closeSafely(bufferedWriter);
            } catch (IOException e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                Log.e(TAG, e.getMessage(), e);
                Closeables.closeSafely(bufferedWriter2);
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                Closeables.closeSafely(bufferedWriter2);
                throw th;
            }
        }
    }
}
