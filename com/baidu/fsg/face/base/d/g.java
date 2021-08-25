package com.baidu.fsg.face.base.d;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f39739a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f39740b = "SapiBioFileUtils";

    /* renamed from: c  reason: collision with root package name */
    public static final String f39741c = "liveness_video.mp4";

    /* renamed from: d  reason: collision with root package name */
    public static final String f39742d = "liveness_action_video.mp4";

    /* renamed from: e  reason: collision with root package name */
    public static final String f39743e = "BI0_VIDEO";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365275506, "Lcom/baidu/fsg/face/base/d/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-365275506, "Lcom/baidu/fsg/face/base/d/g;");
                return;
            }
        }
        f39739a = ApollonConstants.VIDEO_DEBUG;
    }

    public g() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getDir(f39743e, 0).getAbsolutePath() : (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String a2 = f39739a ? a() : a(context);
            return a2 + File.separator + f39741c;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            String a2 = f39739a ? a() : a(context);
            return a2 + File.separator + f39742d;
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? context.getDir(f39743e, 0).getAbsolutePath() : (String) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Environment.getExternalStorageDirectory().getAbsolutePath() : (String) invokeV.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (c(str)) {
                return false;
            }
            if (a(str)) {
                return a(new File(str));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? str == null || "".equals(str) : invokeL.booleanValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (!str2.startsWith(".")) {
                str2 = "." + str2;
            }
            return str + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            if (file.exists()) {
                return true;
            }
            file.getParentFile().mkdirs();
            return file.createNewFile();
        }
        return invokeL.booleanValue;
    }

    public static boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            try {
                return file.delete();
            } catch (Exception e2) {
                d.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(File file, byte[] bArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, file, bArr)) == null) ? a(file, bArr, true) : invokeLL.booleanValue;
    }

    public static boolean a(File file, byte[] bArr, boolean z) throws IOException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65543, null, file, bArr, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.close();
                    return true;
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
        }
    }
}
