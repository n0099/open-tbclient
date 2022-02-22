package c.a.s0.a.y.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f9824c;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, Object> a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, Integer> f9825b;

    /* renamed from: c.a.s0.a.y.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0637a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static Boolean a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, obj)) == null) {
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
                return null;
            }
            return (Boolean) invokeL.objValue;
        }

        public static Double b(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
                if (obj instanceof Double) {
                    return (Double) obj;
                }
                if (obj instanceof Number) {
                    return Double.valueOf(((Number) obj).doubleValue());
                }
                return null;
            }
            return (Double) invokeL.objValue;
        }

        public static Integer c(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
                if (obj instanceof Integer) {
                    return (Integer) obj;
                }
                if (obj instanceof Number) {
                    return Integer.valueOf(((Number) obj).intValue());
                }
                return null;
            }
            return (Integer) invokeL.objValue;
        }

        public static b d(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
                if (obj instanceof b) {
                    return (b) obj;
                }
                return null;
            }
            return (b) invokeL.objValue;
        }

        public static JsArrayBuffer e(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
                if (obj instanceof JsArrayBuffer) {
                    return (JsArrayBuffer) obj;
                }
                return null;
            }
            return (JsArrayBuffer) invokeL.objValue;
        }

        public static JsFunction f(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
                if (obj instanceof JsFunction) {
                    return (JsFunction) obj;
                }
                return null;
            }
            return (JsFunction) invokeL.objValue;
        }

        public static a g(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
                if (obj instanceof a) {
                    return (a) obj;
                }
                return null;
            }
            return (a) invokeL.objValue;
        }

        public static Long h(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) {
                if (obj instanceof Long) {
                    return (Long) obj;
                }
                if (obj instanceof Number) {
                    return Long.valueOf(((Number) obj).longValue());
                }
                return null;
            }
            return (Long) invokeL.objValue;
        }

        public static String i(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) {
                if (obj instanceof String) {
                    return (String) obj;
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public static JSTypeMismatchException j(a aVar, String str, int i2) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65545, null, aVar, str, i2)) == null) {
                int intValue = aVar.i().containsKey(str) ? ((Integer) aVar.i().get(str)).intValue() : 12;
                return new JSTypeMismatchException(str, intValue, i2, String.format("The \"%s\" argument must be %s. Received type %s", str, JsObject.typeToString(i2), JsObject.typeToString(intValue)));
            }
            return (JSTypeMismatchException) invokeLLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-989229417, "Lc/a/s0/a/y/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-989229417, "Lc/a/s0/a/y/b/a;");
                return;
            }
        }
        f9824c = k.a;
    }

    public a() {
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

    public static a F(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsObject)) == null) {
            if (jsObject == null) {
                boolean z = f9824c;
                return null;
            }
            a aVar = new a();
            boolean z2 = false;
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                int propertyType = jsObject.getPropertyType(i2);
                String propertyName = jsObject.getPropertyName(i2);
                aVar.i().put(propertyName, Integer.valueOf(propertyType));
                switch (propertyType) {
                    case 1:
                        aVar.f().put(propertyName, Boolean.valueOf(jsObject.toBoolean(i2)));
                        break;
                    case 2:
                        aVar.f().put(propertyName, Integer.valueOf(jsObject.toInteger(i2)));
                        break;
                    case 3:
                        aVar.f().put(propertyName, Long.valueOf(jsObject.toLong(i2)));
                        break;
                    case 5:
                        aVar.f().put(propertyName, Double.valueOf(jsObject.toDouble(i2)));
                        break;
                    case 6:
                        aVar.f().put(propertyName, new b(i2, jsObject));
                        z2 = true;
                        break;
                    case 7:
                        aVar.f().put(propertyName, jsObject.toString(i2));
                        break;
                    case 8:
                        aVar.f().put(propertyName, jsObject.toJsFunction(i2));
                        break;
                    case 9:
                        aVar.f().put(propertyName, F(jsObject.toJsObject(i2)));
                        break;
                    case 10:
                        aVar.f().put(propertyName, jsObject.toJsArrayBuffer(i2));
                        break;
                }
            }
            if (!z2) {
                jsObject.release();
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public JsObject[] A(String str, JsObject[] jsObjectArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, jsObjectArr)) == null) {
            b d2 = C0637a.d(f().get(str));
            return d2 != null ? d2.f9826b.toObjectArray(d2.a) : jsObjectArr;
        }
        return (JsObject[]) invokeLL.objValue;
    }

    public String B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? C(str, "") : (String) invokeL.objValue;
    }

    public String C(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String i2 = C0637a.i(f().get(str));
            return i2 != null ? i2 : str2;
        }
        return (String) invokeLL.objValue;
    }

    public String[] D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? E(str, null) : (String[]) invokeL.objValue;
    }

    public String[] E(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, strArr)) == null) {
            b d2 = C0637a.d(f().get(str));
            return d2 != null ? d2.f9826b.toStringArray(d2.a) : strArr;
        }
        return (String[]) invokeLL.objValue;
    }

    public void G(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, obj) == null) || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        f().put(str, obj);
    }

    public String H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? String.valueOf(f().get(str)) : (String) invokeL.objValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? i().containsKey(str) : invokeL.booleanValue;
    }

    public double c(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Double b2 = C0637a.b(f().get(str));
            if (b2 != null) {
                return b2.doubleValue();
            }
            throw C0637a.j(this, str, 5);
        }
        return invokeL.doubleValue;
    }

    public int d(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Integer c2 = C0637a.c(f().get(str));
            if (c2 != null) {
                return c2.intValue();
            }
            throw C0637a.j(this, str, 2);
        }
        return invokeL.intValue;
    }

    public JsObject[] e(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            b d2 = C0637a.d(f().get(str));
            if (d2 != null) {
                return d2.f9826b.toObjectArray(d2.a);
            }
            throw C0637a.j(this, str, 6);
        }
        return (JsObject[]) invokeL.objValue;
    }

    public final Map<String, Object> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a == null) {
                this.a = new TreeMap();
            }
            return this.a;
        }
        return (Map) invokeV.objValue;
    }

    public String g(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            String i2 = C0637a.i(f().get(str));
            if (i2 != null) {
                return i2;
            }
            throw C0637a.j(this, str, 7);
        }
        return (String) invokeL.objValue;
    }

    public int getType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Integer num = i().get(str);
            if (num == null) {
                num = 12;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public String[] h(String str) throws JSTypeMismatchException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            b d2 = C0637a.d(f().get(str));
            if (d2 != null) {
                return d2.f9826b.toStringArray(d2.a);
            }
            throw C0637a.j(this, str, 6);
        }
        return (String[]) invokeL.objValue;
    }

    public final Map<String, Integer> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.f9825b == null) {
                this.f9825b = new TreeMap();
            }
            return this.f9825b;
        }
        return (Map) invokeV.objValue;
    }

    public Set<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? f().keySet() : (Set) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? f().size() : invokeV.intValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? m(str, false) : invokeL.booleanValue;
    }

    public boolean m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048595, this, str, z)) == null) {
            Boolean a = C0637a.a(f().get(str));
            return a != null ? a.booleanValue() : z;
        }
        return invokeLZ.booleanValue;
    }

    public double n(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            Double b2 = C0637a.b(f().get(str));
            return b2 != null ? b2.doubleValue() : d2;
        }
        return invokeCommon.doubleValue;
    }

    public double[] o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? p(str, null) : (double[]) invokeL.objValue;
    }

    public double[] p(String str, double[] dArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, dArr)) == null) {
            b d2 = C0637a.d(f().get(str));
            return d2 != null ? d2.f9826b.toDoubleArray(d2.a) : dArr;
        }
        return (double[]) invokeLL.objValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) ? r(str, 0) : invokeL.intValue;
    }

    public int r(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, str, i2)) == null) {
            Integer c2 = C0637a.c(f().get(str));
            return c2 != null ? c2.intValue() : i2;
        }
        return invokeLI.intValue;
    }

    public JsArrayBuffer s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) ? t(str, null) : (JsArrayBuffer) invokeL.objValue;
    }

    public JsArrayBuffer t(String str, JsArrayBuffer jsArrayBuffer) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, jsArrayBuffer)) == null) {
            JsArrayBuffer e2 = C0637a.e(f().get(str));
            return e2 != null ? e2 : jsArrayBuffer;
        }
        return (JsArrayBuffer) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? f().toString() : (String) invokeV.objValue;
    }

    public JsFunction u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? v(str, null) : (JsFunction) invokeL.objValue;
    }

    public JsFunction v(String str, JsFunction jsFunction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, str, jsFunction)) == null) {
            JsFunction f2 = C0637a.f(f().get(str));
            return f2 != null ? f2 : jsFunction;
        }
        return (JsFunction) invokeLL.objValue;
    }

    public a w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) ? x(str, null) : (a) invokeL.objValue;
    }

    public a x(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, str, aVar)) == null) {
            a g2 = C0637a.g(f().get(str));
            return g2 != null ? g2 : aVar;
        }
        return (a) invokeLL.objValue;
    }

    public long y(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048608, this, str, j2)) == null) {
            Long h2 = C0637a.h(f().get(str));
            return h2 != null ? h2.longValue() : j2;
        }
        return invokeLJ.longValue;
    }

    public JsObject[] z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) ? A(str, null) : (JsObject[]) invokeL.objValue;
    }
}
