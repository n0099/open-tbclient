package c.a.v.a.h;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;

    /* renamed from: b  reason: collision with root package name */
    public static d f26542b;

    /* renamed from: c  reason: collision with root package name */
    public static File f26543c;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(a.getExternalFilesDir("Log").getPath() + "/");
                String str = "file path ..." + file.getPath();
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file.getPath() + "/logs.txt");
                if (file2.exists()) {
                    file2.delete();
                }
                try {
                    file2.createNewFile();
                } catch (Exception e2) {
                    r0 = "Create log file failure !!! " + e2.toString();
                }
                return file2;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                Class<?> cls = Class.forName("com.baidu.android.imsdk.internal.IMConfigInternal");
                String valueOf = String.valueOf(cls.getMethod("getSDKVersionValue", Context.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(new Object(), new Object[0]), a));
                return String.format("%s.%s.%s", valueOf.substring(0, 1), valueOf.substring(1, 2), valueOf.substring(2, 3));
            } catch (Exception e2) {
                e2.getMessage();
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static d c(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == null || f26542b == null || (file = f26543c) == null || !file.exists()) {
                a = context;
                f26542b = new d();
                f26543c = a();
                e("imsdkversion:" + b());
                e("lcpsdkversion:" + d());
                String str = "LogFilePath is: " + f26543c.getPath();
            }
            return f26542b;
        }
        return (d) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? "2280016" : (String) invokeV.objValue;
    }

    public static void e(Object obj) {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, obj) == null) || a == null || f26542b == null || (file = f26543c) == null || !file.exists()) {
            return;
        }
        String str = System.currentTimeMillis() + ":" + obj.toString();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f26543c, true));
            bufferedWriter.write(str);
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } catch (Exception e2) {
            String str2 = "Write failure !!! " + e2.toString();
        }
    }
}
