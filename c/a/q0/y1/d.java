package c.a.q0.y1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(f.f29106e + f.f29102a + str));
    }

    public static void c(String str, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, str, jSONArray) == null) || StringUtils.isNull(str) || jSONArray == null) {
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                jSONArray.put(jSONArray2.optJSONObject(i2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static JSONArray d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (StringUtils.isNull(str)) {
                return jSONArray;
            }
            File file = new File(str);
            if (file.exists()) {
                String e2 = e(file);
                String[] split = e2.split(org.apache.commons.lang3.StringUtils.LF);
                if (split.length > 0) {
                    for (String str2 : split) {
                        c(str2, jSONArray);
                    }
                } else {
                    c(e2, jSONArray);
                }
                FileHelper.deleteFile(file);
                return jSONArray;
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public static String e(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            StringBuilder sb = new StringBuilder();
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                c.a.e.e.m.a.c(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                c.a.e.e.m.a.c(fileInputStream2);
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                c.a.e.e.m.a.c(fileInputStream2);
                throw th;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, file, str)) == null) ? g(file, str, true) : invokeLL.booleanValue;
    }

    public static boolean g(File file, String str, boolean z) {
        InterceptResult invokeLLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.BAIDU_LOGO_ID, null, file, str, z)) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                c.a.e.e.m.a.d(fileOutputStream);
                return true;
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                c.a.e.e.m.a.d(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                c.a.e.e.m.a.d(fileOutputStream2);
                throw th;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
