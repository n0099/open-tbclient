package com.baidu.searchbox.aideviceperformance.utils;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes10.dex */
public class FileUtil {
    public static /* synthetic */ Interceptable $ic;
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
            }
        }
    }

    public void copyDirFromAssets(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, str2) == null) {
            try {
                String[] list = context.getAssets().list(str);
                if (list != null && list.length != 0) {
                    new File(str2).mkdirs();
                    for (String str3 : list) {
                        copyDirFromAssets(context, str + File.separator + str3, str2 + File.separator + str3);
                    }
                    return;
                }
                copyFileFromAssets(context, str, str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void copyFileFromAssets(Context context, String str, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2) != null) {
            return;
        }
        InputStream open = context.getAssets().open(str);
        File file = new File(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = open.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                file.setReadable(true);
                return;
            }
        }
    }

    public boolean deleteFile(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            if (file.exists()) {
                if (file.isFile()) {
                    return file.delete();
                }
                for (File file2 : file.listFiles()) {
                    deleteFile(file2);
                    file2.delete();
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
