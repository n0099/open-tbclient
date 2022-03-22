package c.a.a0.x;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? TextUtils.isEmpty(str) ? str : i(str).replaceAll("\"\\{", "\\{").replaceAll("\\}\"", "\\}") : (String) invokeL.objValue;
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
                g(e2.getMessage());
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(JSONObject jSONObject, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, jSONObject, str, i) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, i);
                    return;
                } catch (Exception e2) {
                    h(e2);
                    return;
                }
            }
            g("json或key值不合法！");
        }
    }

    public static void d(JSONObject jSONObject, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{jSONObject, str, Long.valueOf(j)}) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, j);
                    return;
                } catch (Exception e2) {
                    h(e2);
                    return;
                }
            }
            g("json或key值不合法！");
        }
    }

    public static <T> void e(JSONObject jSONObject, String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str, t) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, t);
                    return;
                } catch (Exception e2) {
                    h(e2);
                    return;
                }
            }
            g("json或key值不合法！");
        }
    }

    public static void f(JSONObject jSONObject, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, jSONObject, str, z) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, z);
                    return;
                } catch (Exception e2) {
                    h(e2);
                    return;
                }
            }
            g("json或key值不合法！");
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
        }
    }

    public static void h(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, exc) == null) {
        }
    }

    public static String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                StringWriter stringWriter = new StringWriter(str.length());
                j(stringWriter, str);
                return stringWriter.toString();
            } catch (IOException e2) {
                g(e2.getMessage());
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void j(Writer writer, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, writer, str) == null) {
            if (writer == null) {
                throw new IllegalArgumentException("The Writer must not be null");
            }
            if (str != null) {
                int length = str.length();
                StringBuilder sb = new StringBuilder(4);
                boolean z = false;
                boolean z2 = false;
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (z2) {
                        sb.append(charAt);
                        if (sb.length() == 4) {
                            try {
                                writer.write((char) Integer.parseInt(sb.toString(), 16));
                                sb.setLength(0);
                                z = false;
                                z2 = false;
                            } catch (NumberFormatException e2) {
                                g(e2.getMessage());
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
