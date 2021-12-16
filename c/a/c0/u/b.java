package c.a.c0.u;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? TextUtils.isEmpty(str) ? str : g(str).replaceAll("\"\\{", "\\{").replaceAll("\\}\"", "\\}") : (String) invokeL.objValue;
    }

    @NonNull
    public static JSONObject b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (Exception e2) {
                e(e2.getMessage());
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(JSONObject jSONObject, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{jSONObject, str, Long.valueOf(j2)}) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, j2);
                    return;
                } catch (Exception e2) {
                    f(e2);
                    return;
                }
            }
            e("json或key值不合法！");
        }
    }

    public static <T> void d(JSONObject jSONObject, String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, str, t) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, t);
                    return;
                } catch (Exception e2) {
                    f(e2);
                    return;
                }
            }
            e("json或key值不合法！");
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
        }
    }

    public static void f(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, exc) == null) {
        }
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                StringWriter stringWriter = new StringWriter(str.length());
                h(stringWriter, str);
                return stringWriter.toString();
            } catch (IOException e2) {
                e(e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void h(Writer writer, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, writer, str) == null) {
            if (writer == null) {
                throw new IllegalArgumentException("The Writer must not be null");
            }
            if (str != null) {
                int length = str.length();
                StringBuilder sb = new StringBuilder(4);
                boolean z = false;
                boolean z2 = false;
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if (z2) {
                        sb.append(charAt);
                        if (sb.length() == 4) {
                            try {
                                writer.write((char) Integer.parseInt(sb.toString(), 16));
                                sb.setLength(0);
                                z = false;
                                z2 = false;
                            } catch (NumberFormatException e2) {
                                e(e2.getMessage());
                            }
                        }
                    } else if (z) {
                        if (charAt == '\"') {
                            writer.write(34);
                        } else if (charAt == '\'') {
                            writer.write(39);
                        } else if (charAt == '\\') {
                            writer.write(92);
                        } else if (charAt == 'b') {
                            writer.write(8);
                        } else if (charAt == 'f') {
                            writer.write(12);
                        } else if (charAt == 'n') {
                            writer.write(10);
                        } else if (charAt == 'r') {
                            writer.write(13);
                        } else if (charAt == 't') {
                            writer.write(9);
                        } else if (charAt != 'u') {
                            writer.write(charAt);
                        } else {
                            z = false;
                            z2 = true;
                        }
                        z = false;
                    } else if (charAt == '\\') {
                        z = true;
                    } else {
                        writer.write(charAt);
                    }
                }
                if (z) {
                    writer.write(92);
                }
            }
        }
    }
}
