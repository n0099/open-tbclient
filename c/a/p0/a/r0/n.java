package c.a.p0.a.r0;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f8323a = "/aigames/sandbox/";

    /* renamed from: b  reason: collision with root package name */
    public static String f8324b;

    /* renamed from: c  reason: collision with root package name */
    public static String f8325c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8326a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1372168842, "Lc/a/p0/a/r0/n$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1372168842, "Lc/a/p0/a/r0/n$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            f8326a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8326a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(828242599, "Lc/a/p0/a/r0/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(828242599, "Lc/a/p0/a/r0/n;");
        }
    }

    public static JsFunction A(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            if (!TextUtils.isEmpty(str) && map != null) {
                Object obj = map.get(str);
                if (obj instanceof JsFunction) {
                    return (JsFunction) obj;
                }
            }
            return null;
        }
        return (JsFunction) invokeLL.objValue;
    }

    public static Map<String, JsFunction> B(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsObject)) == null) {
            if (jsObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                if (jsObject.getPropertyType(i2) == 8) {
                    hashMap.put(jsObject.getPropertyName(i2), jsObject.toJsFunction(i2));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String C(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, str3, str4)) == null) ? D(str, str2, str3, str4, false) : (String) invokeLLLL.objValue;
    }

    public static String D(String str, String str2, String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, str3, str4, Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return com.baidu.pass.biometrics.face.liveness.b.a.g0;
            }
            if (str.endsWith(" ")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str3 == null) {
                str3 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                return String.format("%s \"%s\"", str, str3);
            }
            if (str.endsWith(",")) {
                str = str.substring(0, str.length() - 1);
            }
            if (!z && TextUtils.isEmpty(str4)) {
                return String.format("%s, %s \"%s\"", str, str2, str3);
            }
            return String.format("%s, %s \"%s\" -> \"%s\"", str, str2, str3, str4);
        }
        return (String) invokeCommon.objValue;
    }

    @NonNull
    public static <T> T E(String str, Map<String, Object> map, @NonNull T t) {
        InterceptResult invokeLLL;
        T t2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, map, t)) == null) ? (TextUtils.isEmpty(str) || map == null || (t2 = (T) map.get(str)) == null) ? t : t2 : (T) invokeLLL.objValue;
    }

    public static String F(String str, Map<String, Object> map) {
        InterceptResult invokeLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, map)) == null) {
            if (TextUtils.isEmpty(str) || map == null || (obj = map.get(str)) == null || !(obj instanceof String)) {
                return null;
            }
            return (String) obj;
        }
        return (String) invokeLL.objValue;
    }

    public static Map<String, Object> G(f fVar, JsObject jsObject, c.a.p0.a.r0.o.b bVar, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, fVar, jsObject, bVar, str)) == null) {
            if (jsObject != null && fVar != null && bVar != null) {
                Map<String, JsFunction> B = B(jsObject);
                if (B == null) {
                    X(jsObject);
                    return null;
                }
                Map<String, Object> j2 = j(jsObject);
                if (j2 == null) {
                    X(jsObject);
                    bVar.errMsg = str;
                    k(B.get(com.baidu.pass.biometrics.face.liveness.b.a.g0), B.get(XAdRemoteEvent.COMPLETE), bVar, B.get("success"));
                    return null;
                }
                HashMap hashMap = new HashMap();
                for (String str2 : B.keySet()) {
                    hashMap.put(str2, B.get(str2));
                }
                for (String str3 : j2.keySet()) {
                    hashMap.put(str3, j2.get(str3));
                }
                X(jsObject);
                return hashMap;
            }
            X(jsObject);
            return null;
        }
        return (Map) invokeLLLL.objValue;
    }

    public static String H(String str, int i2) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "path";
            }
            switch (i2) {
                case 1:
                    str2 = "Boolean;";
                    break;
                case 2:
                case 3:
                case 5:
                    str2 = "Number;";
                    break;
                case 4:
                case 7:
                case 11:
                default:
                    str2 = "NoSupport;";
                    break;
                case 6:
                    str2 = "Array;";
                    break;
                case 8:
                    str2 = "Function;";
                    break;
                case 9:
                    str2 = "Object;";
                    break;
                case 10:
                    str2 = "ArrayBuffer;";
                    break;
                case 12:
                    str2 = "Undefined;";
                    break;
            }
            return "fail parameter error: parameter." + str + " should be String instead of " + str2;
        }
        return (String) invokeLI.objValue;
    }

    public static String I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.startsWith(WebGLImageLoader.BDFILE)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bdfile://code");
            if (!str.startsWith(File.separator)) {
                str = File.separator + str;
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String J(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            String w = w(AppRuntime.getAppContext());
            return w + File.separator + str + f8323a + str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("bdfile://tmp" + File.separator) || "bdfile://tmp".equals(str)) {
                    String n = n();
                    if (TextUtils.isEmpty(n)) {
                        return null;
                    }
                    String substring = str.substring(9);
                    if (substring.startsWith(File.separator)) {
                        return n + substring;
                    }
                    return n + File.separator + substring;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static int L(String str, JsObject jsObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, jsObject)) == null) {
            if (jsObject != null && !TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < jsObject.length(); i2++) {
                    if (str.equals(jsObject.getPropertyName(i2))) {
                        return jsObject.getPropertyType(i2);
                    }
                }
            }
            return 12;
        }
        return invokeLL.intValue;
    }

    public static String M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(c.a.p0.a.r0.a.USER_DATA_PATH + File.separator) || c.a.p0.a.r0.a.USER_DATA_PATH.equals(str)) {
                    String n = n();
                    if (TextUtils.isEmpty(n)) {
                        return null;
                    }
                    String substring = str.substring(9);
                    if (substring.startsWith(File.separator)) {
                        return n + substring;
                    }
                    return n + File.separator + substring;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str == null || str.length() < 1) {
                return null;
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = str.toCharArray();
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (Character.digit(charArray[i3 + 1], 16) | (Character.digit(charArray[i3], 16) << 4));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int indexOf = str.indexOf(Constants.PATH_PARENT);
            if (indexOf != 0) {
                return indexOf > 0;
            }
            String substring = str.substring(3);
            return !TextUtils.isEmpty(substring) && substring.contains(Constants.PATH_PARENT);
        }
        return invokeL.booleanValue;
    }

    public static boolean P(f fVar, c.a.p0.a.l0.a aVar, JsObject jsObject, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, fVar, aVar, jsObject, str)) == null) {
            if (fVar == null || aVar == null) {
                if (jsObject == null && !TextUtils.isEmpty(str)) {
                    d(aVar, str + "Object;");
                }
                X(jsObject);
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean Q(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, file, file2)) == null) {
            if (file == null || file2 == null) {
                return true;
            }
            if (file.isDirectory() && file2.isFile()) {
                return false;
            }
            return (file.isFile() && file2.isDirectory()) ? false : true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bdfile://tmp");
            sb.append(File.separator);
            boolean z = str.startsWith(sb.toString()) || "bdfile://tmp".equals(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c.a.p0.a.r0.a.USER_DATA_PATH);
            sb2.append(File.separator);
            boolean z2 = str.startsWith(sb2.toString()) || c.a.p0.a.r0.a.USER_DATA_PATH.equals(str);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("bdfile://code");
            sb3.append(File.separator);
            return (z || z2 || (str.startsWith(sb3.toString()) || "bdfile://code".equals(str))) && !O(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.p0.a.r0.a.USER_DATA_PATH);
            sb.append(File.separator);
            return (str.startsWith(sb.toString()) || c.a.p0.a.r0.a.USER_DATA_PATH.equals(str)) && !O(str);
        }
        return invokeL.booleanValue;
    }

    public static void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str + "/tmp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(str + "/usr");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(str + File.separator + "record.pro");
                if (!file3.exists()) {
                    try {
                        file3.createNewFile();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                File file4 = new File(str2);
                if (file4.exists()) {
                    return;
                }
                file4.mkdirs();
            }
        }
    }

    public static String U(String str) {
        InterceptResult invokeL;
        String y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, str)) == null) {
            int i2 = a.f8326a[c.a.p0.a.k2.b.s(str).ordinal()];
            if (i2 == 1) {
                y = y(str);
            } else if (i2 != 2) {
                y = str;
            } else {
                y = c.a.p0.a.g1.f.V().A() + str;
            }
            return TextUtils.isEmpty(y) ? str : y;
        }
        return (String) invokeL.objValue;
    }

    public static String V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String n = n();
            if (TextUtils.isEmpty(n)) {
                return null;
            }
            String str2 = n + File.separator;
            if (str.startsWith(str2) && str.length() > str2.length()) {
                return WebGLImageLoader.BDFILE + str.substring(str2.length());
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void W(JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, jsFunction) == null) || jsFunction == null) {
            return;
        }
        jsFunction.release();
    }

    public static void X(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    public static void Y(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65561, null, jsFunction, jsFunction2, obj, jsFunction3) == null) {
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            W(jsFunction3);
        }
    }

    public static void Z(c.a.p0.a.l0.a aVar, c cVar, JSExceptionType jSExceptionType, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65562, null, aVar, cVar, jSExceptionType, str, str2) == null) || aVar == null) {
            return;
        }
        if (cVar == null) {
            aVar.throwJSException(jSExceptionType, str2 + str);
            return;
        }
        int i2 = cVar.f8173a;
        if (i2 != 0) {
            JSExceptionType z = z(i2);
            aVar.throwJSException(z, str2 + cVar.f8174b);
        }
    }

    public static boolean a(b bVar, c.a.p0.a.r0.o.b bVar2, Map<Integer, String> map, c.a.p0.a.l0.a aVar) {
        InterceptResult invokeLLLL;
        String str;
        Map<String, Object> map2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65563, null, bVar, bVar2, map, aVar)) == null) {
            if (map != null) {
                for (Integer num : map.keySet()) {
                    if (num.intValue() != 7) {
                        str = H(map.get(num), num.intValue());
                        break;
                    }
                }
            }
            str = null;
            if (bVar2 == null || bVar == null || (map2 = bVar.f8172c) == null) {
                return false;
            }
            c cVar = bVar.f8170a;
            JsFunction A = A(com.baidu.pass.biometrics.face.liveness.b.a.g0, map2);
            JsFunction A2 = A(XAdRemoteEvent.COMPLETE, map2);
            JsFunction A3 = A("success", map2);
            if (!TextUtils.isEmpty(str)) {
                String str2 = bVar.f8171b + str;
                bVar2.errMsg = str2;
                d(aVar, str2);
                k(A, A2, bVar2, A3);
                return false;
            } else if (cVar == null) {
                bVar2.errMsg = bVar.f8171b + "unknown error";
                k(A, A2, bVar2, A3);
                return false;
            } else {
                bVar2.errMsg = bVar.f8171b + cVar.f8174b;
                if (cVar.f8173a != 0) {
                    k(A, A2, bVar2, A3);
                    return false;
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static void b(Object obj, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, obj, map) == null) {
            Y(A("success", map), A(XAdRemoteEvent.COMPLETE, map), obj, A(com.baidu.pass.biometrics.face.liveness.b.a.g0, map));
        }
    }

    public static void c() {
        Context appContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, null) == null) || (appContext = AppRuntime.getAppContext()) == null) {
            return;
        }
        String w = w(appContext);
        String str = w + File.separator + "swangame/anonymous/sandbox";
        if (!TextUtils.isEmpty(str)) {
            c.a.p0.t.d.L(str);
        }
        String str2 = w + File.separator + f8325c + f8323a;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c.a.p0.t.d.L(str2);
    }

    public static void d(c.a.p0.a.l0.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65566, null, aVar, str) == null) || aVar == null || aVar.z() == null || TextUtils.isEmpty(str)) {
            return;
        }
        aVar.z().b(str);
    }

    public static void e(String str, String str2) {
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, str, str2) == null) {
            try {
                new File(str2).mkdirs();
                String[] list = new File(str).list();
                for (int i2 = 0; i2 < list.length; i2++) {
                    if (str.endsWith(File.separator)) {
                        file = new File(str + list[i2]);
                    } else {
                        file = new File(str + File.separator + list[i2]);
                    }
                    if (file.isFile()) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + file.getName());
                        byte[] bArr = new byte[5120];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        fileOutputStream.flush();
                        c.a.p0.t.d.d(fileOutputStream);
                        c.a.p0.t.d.d(fileInputStream);
                    }
                    if (file.isDirectory()) {
                        e(str + "/" + list[i2], str2 + "/" + list[i2]);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65569, null, list) == null) || list == null || list.size() == 0) {
            return;
        }
        for (String str : list) {
            File file = new File(str);
            if (file.exists()) {
                c.a.p0.t.d.i(file);
            }
        }
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                boolean z = true;
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    if (listFiles[i2].isFile()) {
                        z = f(listFiles[i2].getAbsolutePath());
                        if (!z) {
                            break;
                        }
                    } else {
                        z = h(listFiles[i2].getAbsolutePath());
                        if (!z) {
                            break;
                        }
                    }
                }
                if (z) {
                    return file.delete();
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, str) == null) {
            String h2 = c.a.p0.a.c1.a.a0().h(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(h2)) {
                c.a.p0.t.d.L(J(h2, str));
                c.a.p0.t.d.L(J(c.a.p0.t.f.d(h2.getBytes(), false), str));
            }
            String i2 = c.a.p0.a.c1.a.a0().i(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(i2)) {
                c.a.p0.t.d.L(J(i2, str));
                c.a.p0.t.d.L(J(c.a.p0.t.f.d(i2.replace("|", "").getBytes(), false), str));
            }
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return;
            }
            String str2 = w(appContext) + File.separator + "swangame/anonymous/sandbox" + File.separator + str;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c.a.p0.t.d.L(str2);
        }
    }

    public static Map<String, Object> j(JsObject jsObject) {
        InterceptResult invokeL;
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, jsObject)) == null) {
            if (jsObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                int propertyType = jsObject.getPropertyType(i2);
                if (propertyType == 1) {
                    valueOf = Boolean.valueOf(jsObject.toBoolean(i2));
                } else if (propertyType == 2) {
                    valueOf = Integer.valueOf(jsObject.toInteger(i2));
                } else if (propertyType == 3) {
                    valueOf = Long.valueOf(jsObject.toLong(i2));
                } else if (propertyType != 5) {
                    valueOf = propertyType != 7 ? null : jsObject.toString(i2);
                } else {
                    valueOf = Double.valueOf(jsObject.toDouble(i2));
                }
                if (valueOf != null) {
                    hashMap.put(jsObject.getPropertyName(i2), valueOf);
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static void k(JsFunction jsFunction, JsFunction jsFunction2, Object obj, JsFunction jsFunction3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65573, null, jsFunction, jsFunction2, obj, jsFunction3) == null) {
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            W(jsFunction3);
            if (obj instanceof c.a.p0.a.r0.o.b) {
                c.a.p0.a.c1.b.j().b(((c.a.p0.a.r0.o.b) obj).errMsg);
            }
        }
    }

    public static String l(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            FileInputStream fileInputStream2 = null;
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    fileInputStream = new FileInputStream(new File(str));
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                int available = fileInputStream.available();
                byte[] bArr = new byte[available];
                fileInputStream.read(bArr);
                for (int i2 = 0; i2 < available; i2++) {
                    String hexString = Integer.toHexString(bArr[i2] & 255);
                    if (hexString.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(hexString);
                }
                c.a.p0.t.d.d(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                if (c.a.p0.a.k.f7085a) {
                    e.printStackTrace();
                }
                c.a.p0.t.d.d(fileInputStream2);
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                c.a.p0.t.d.d(fileInputStream2);
                throw th;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> m(String str, boolean z) {
        InterceptResult invokeLZ;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65575, null, str, z)) == null) {
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str)) {
                return arrayList;
            }
            File file = new File(str);
            if (file.exists()) {
                if (file.isFile()) {
                    arrayList.add(file.getAbsolutePath());
                    return arrayList;
                }
                LinkedList linkedList = new LinkedList();
                File[] listFiles2 = file.listFiles();
                for (int i2 = 0; i2 < listFiles2.length; i2++) {
                    if (listFiles2[i2] != null) {
                        if (listFiles2[i2].isDirectory()) {
                            linkedList.add(listFiles2[i2]);
                        }
                        if (z || listFiles2[i2].isFile()) {
                            arrayList.add(listFiles2[i2].getAbsolutePath());
                        }
                    }
                }
                while (!linkedList.isEmpty()) {
                    File file2 = (File) linkedList.removeFirst();
                    if (file2.isDirectory() && (listFiles = file2.listFiles()) != null) {
                        for (int i3 = 0; i3 < listFiles.length; i3++) {
                            if (listFiles[i3].isDirectory()) {
                                linkedList.add(listFiles[i3]);
                            }
                            if (z || listFiles[i3].isFile()) {
                                arrayList.add(listFiles[i3].getAbsolutePath());
                            }
                        }
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeLZ.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return "";
            }
            String w = w(appContext);
            if (c.a.p0.a.a2.e.i() == null) {
                return w;
            }
            String V = c.a.p0.a.a2.e.V();
            return w + File.separator + "swangame/anonymous/sandbox" + File.separator + V;
        }
        return (String) invokeV.objValue;
    }

    public static byte[] o(String str) {
        InterceptResult invokeL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65577, null, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        File file = new File(str);
        if (!file.exists()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
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
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 1024);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    c.a.p0.t.d.d(bufferedInputStream);
                    c.a.p0.t.d.d(byteArrayOutputStream);
                    return byteArray;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            e.printStackTrace();
            c.a.p0.t.d.d(bufferedInputStream2);
            c.a.p0.t.d.d(byteArrayOutputStream);
            return new byte[0];
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            c.a.p0.t.d.d(bufferedInputStream2);
            c.a.p0.t.d.d(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] p(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, jsObject)) == null) {
            if (jsObject == null) {
                return null;
            }
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                if (jsObject.getPropertyType(i2) == 10) {
                    JsArrayBuffer jsArrayBuffer = jsObject.toJsArrayBuffer(i2);
                    if (jsArrayBuffer != null) {
                        return jsArrayBuffer.buffer();
                    }
                    return null;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65579, null, context)) == null) ? context == null ? "" : context.getCacheDir().getAbsolutePath() : (String) invokeL.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext == null) {
                return "";
            }
            String q = q(appContext);
            c.a.p0.a.a2.e i2 = c.a.p0.a.a2.e.i();
            if (i2 == null) {
                return q;
            }
            String V = c.a.p0.a.a2.e.V();
            String Z = i2.Z();
            String d2 = i2.j() != null ? i2.j().d() : "";
            String i3 = c.a.p0.a.c1.a.a0().i(appContext);
            StringBuilder sb = new StringBuilder();
            sb.append(q(appContext));
            sb.append(File.separator);
            if (TextUtils.isEmpty(d2)) {
                d2 = i3;
            }
            sb.append(d2);
            sb.append("/aigames/swancache/");
            sb.append(V);
            sb.append(File.separator);
            sb.append(Z);
            sb.append(File.separator);
            sb.append("code");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static String[] s(String str, String str2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65581, null, str, str2)) == null) {
            String[] strArr = new String[2];
            if (TextUtils.isEmpty(str)) {
                strArr[0] = "";
                strArr[1] = str2;
                return strArr;
            }
            if (TextUtils.equals(str2, "hex")) {
                byte[] N = N(str);
                str = N == null ? "" : new String(N, "utf-8");
                str2 = "";
            }
            strArr[0] = str;
            strArr[1] = str2;
            return strArr;
        }
        return (String[]) invokeLL.objValue;
    }

    public static b t(c cVar, String str, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65582, null, cVar, str, map)) == null) {
            b bVar = new b();
            bVar.f8170a = cVar;
            bVar.f8171b = str;
            bVar.f8172c = map;
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    public static String u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65583, null, i2)) == null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 5) {
                    return "fail TypeError: data argument must not be a " + "Number;".toLowerCase();
                } else if (i2 == 6) {
                    return "fail TypeError: data argument must not be a " + "Array;".toLowerCase();
                } else if (i2 == 8) {
                    return "fail TypeError: data argument must not be a " + "Function;".toLowerCase();
                } else if (i2 != 9) {
                    if (i2 != 12) {
                        return "";
                    }
                    return "fail TypeError: data argument must not be a " + "Undefined;".toLowerCase();
                }
            }
            return "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object";
        }
        return (String) invokeI.objValue;
    }

    public static c v(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65584, null, str, str2, str3)) == null) {
            c cVar = new c();
            if (str == null) {
                cVar.f8174b = str3;
                cVar.f8173a = -2;
                return cVar;
            } else if ("".equals(str)) {
                cVar.f8174b = str2;
                cVar.f8173a = -1;
                return cVar;
            } else {
                return null;
            }
        }
        return (c) invokeLLL.objValue;
    }

    public static String w(Context context) {
        InterceptResult invokeL;
        File externalFilesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, context)) == null) {
            if (context == null) {
                return "";
            }
            if (TextUtils.isEmpty(f8324b) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                f8324b = externalFilesDir.getAbsolutePath();
            }
            return f8324b;
        }
        return (String) invokeL.objValue;
    }

    public static long x(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65586, null, str)) != null) {
            return invokeL.longValue;
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return 0L;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                long available = fileInputStream.available();
                c.a.p0.t.d.d(fileInputStream);
                return available;
            } catch (Exception unused) {
                fileInputStream2 = fileInputStream;
                c.a.p0.t.d.d(fileInputStream2);
                return 0L;
            } catch (Throwable th2) {
                th = th2;
                c.a.p0.t.d.d(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static String y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65587, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.startsWith(c.a.p0.a.r0.a.USER_DATA_PATH)) {
                return M(str);
            }
            return str.startsWith("bdfile://tmp") ? K(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public static JSExceptionType z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65588, null, i2)) == null) {
            if (i2 != -5) {
                if (i2 != -4) {
                    if (i2 != -3) {
                        if (i2 != -2) {
                            if (i2 != -1) {
                                return JSExceptionType.Error;
                            }
                            return JSExceptionType.Error;
                        }
                        return JSExceptionType.TypeError;
                    }
                    return JSExceptionType.SyntaxError;
                }
                return JSExceptionType.ReferenceError;
            }
            return JSExceptionType.RangeError;
        }
        return (JSExceptionType) invokeI.objValue;
    }
}
