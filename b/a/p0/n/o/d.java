package b.a.p0.n.o;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, strArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (strArr != null) {
                try {
                    if (strArr.length > 0 && strArr.length % 2 == 0) {
                        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                            String str = strArr[i2];
                            String str2 = strArr[i2 + 1];
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                jSONObject.put(str, str2);
                            }
                        }
                    }
                } catch (Exception e2) {
                    if (b.a.p0.n.c.f11048a) {
                        e2.printStackTrace();
                    }
                }
            }
            return "errmsg:" + jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static File b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                b.a.p0.n.c.b().x("PMSFileUtil", "generateFilePath: empty parentDir : " + str + " file name: " + str2);
                return null;
            }
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                b.a.p0.n.c.b().x("PMSFileUtil", "cannot mkdir in : " + file);
                return null;
            }
            String d2 = d(str, str2);
            String str3 = d2;
            for (int i2 = 0; i2 < 1000; i2++) {
                File file2 = new File(str3);
                try {
                    if (!file2.exists() && file2.createNewFile()) {
                        return file2;
                    }
                } catch (IOException e2) {
                    b.a.p0.n.c.b().x("PMSFileUtil", "generateFilePath fail : " + e2.getMessage());
                    if (b.a.p0.n.c.f11048a) {
                        e2.printStackTrace();
                    }
                }
                str3 = d2 + "_" + i2;
            }
            b.a.p0.n.c.b().x("PMSFileUtil", "create temp path fail");
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static File c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            File dir = context.getDir("pms_dir", 0);
            if (!dir.exists()) {
                dir.mkdir();
            }
            return dir;
        }
        return (File) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? e(str, str2, File.separator) : (String) invokeLL.objValue;
    }

    public static String e(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(str3)) {
                if (str2.startsWith(str3)) {
                    return str.concat(str2.substring(str3.length()));
                }
                return str.concat(str2);
            } else if (str2.startsWith(str3)) {
                return str.concat(str2);
            } else {
                return str.concat(str3).concat(str2);
            }
        }
        return (String) invokeLLL.objValue;
    }
}
