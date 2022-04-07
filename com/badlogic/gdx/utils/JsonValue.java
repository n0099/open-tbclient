package com.badlogic.gdx.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.h8;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class JsonValue implements Iterable<JsonValue> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueType a;
    public String b;
    public double c;
    public long d;
    public String e;
    public JsonValue f;
    public JsonValue g;
    public JsonValue h;
    public JsonValue i;
    public int j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class ValueType {
        public static final /* synthetic */ ValueType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ValueType array;
        public static final ValueType booleanValue;
        public static final ValueType doubleValue;
        public static final ValueType longValue;
        public static final ValueType nullValue;
        public static final ValueType object;
        public static final ValueType stringValue;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1367339623, "Lcom/badlogic/gdx/utils/JsonValue$ValueType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1367339623, "Lcom/badlogic/gdx/utils/JsonValue$ValueType;");
                    return;
                }
            }
            object = new ValueType("object", 0);
            array = new ValueType("array", 1);
            stringValue = new ValueType("stringValue", 2);
            doubleValue = new ValueType("doubleValue", 3);
            longValue = new ValueType("longValue", 4);
            booleanValue = new ValueType("booleanValue", 5);
            ValueType valueType = new ValueType("nullValue", 6);
            nullValue = valueType;
            $VALUES = new ValueType[]{object, array, stringValue, doubleValue, longValue, booleanValue, valueType};
        }

        public ValueType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ValueType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ValueType) Enum.valueOf(ValueType.class, str) : (ValueType) invokeL.objValue;
        }

        public static ValueType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ValueType[]) $VALUES.clone() : (ValueType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(564879651, "Lcom/badlogic/gdx/utils/JsonValue$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(564879651, "Lcom/badlogic/gdx/utils/JsonValue$a;");
                    return;
                }
            }
            int[] iArr = new int[ValueType.values().length];
            a = iArr;
            try {
                iArr[ValueType.stringValue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ValueType.doubleValue.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ValueType.longValue.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ValueType.booleanValue.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ValueType.nullValue.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Iterator<JsonValue>, Iterable<JsonValue> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JsonValue a;
        public JsonValue b;
        public final /* synthetic */ JsonValue c;

        public b(JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsonValue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jsonValue;
            this.a = this.c.f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: b */
        public JsonValue next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JsonValue jsonValue = this.a;
                this.b = jsonValue;
                if (jsonValue != null) {
                    this.a = jsonValue.h;
                    return jsonValue;
                }
                throw new NoSuchElementException();
            }
            return (JsonValue) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a != null : invokeV.booleanValue;
        }

        @Override // java.lang.Iterable
        public Iterator<JsonValue> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                JsonValue jsonValue = this.b;
                JsonValue jsonValue2 = jsonValue.i;
                if (jsonValue2 == null) {
                    JsonValue jsonValue3 = this.c;
                    JsonValue jsonValue4 = jsonValue.h;
                    jsonValue3.f = jsonValue4;
                    if (jsonValue4 != null) {
                        jsonValue4.i = null;
                    }
                } else {
                    jsonValue2.h = jsonValue.h;
                    JsonValue jsonValue5 = jsonValue.h;
                    if (jsonValue5 != null) {
                        jsonValue5.i = jsonValue2;
                    }
                }
                JsonValue jsonValue6 = this.c;
                jsonValue6.j--;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JsonWriter$OutputType a;
        public int b;
        public boolean c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public JsonValue(ValueType valueType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valueType};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.a = valueType;
    }

    public static boolean C(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                if (!jsonValue2.B()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void u(int i, h8 h8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, h8Var) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                h8Var.a('\t');
            }
        }
    }

    public static boolean y(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                if (jsonValue2.D() || jsonValue2.v()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a == ValueType.nullValue : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ValueType valueType = this.a;
            return valueType == ValueType.doubleValue || valueType == ValueType.longValue;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a == ValueType.object : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a == ValueType.stringValue : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = a.a[this.a.ordinal()];
            return i == 1 || i == 2 || i == 3 || i == 4 || i == 5;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: G */
    public b iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new b(this) : (b) invokeV.objValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String I(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            h8 h8Var = new h8(512);
            K(this, h8Var, 0, cVar);
            return h8Var.toString();
        }
        return (String) invokeL.objValue;
    }

    public String J(JsonWriter$OutputType jsonWriter$OutputType, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonWriter$OutputType, i)) == null) {
            c cVar = new c();
            cVar.a = jsonWriter$OutputType;
            cVar.b = i;
            return I(cVar);
        }
        return (String) invokeLI.objValue;
    }

    public final void K(JsonValue jsonValue, h8 h8Var, int i, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048585, this, jsonValue, h8Var, i, cVar) == null) {
            JsonWriter$OutputType jsonWriter$OutputType = cVar.a;
            if (jsonValue.D()) {
                if (jsonValue.f == null) {
                    h8Var.n(StringUtil.EMPTY_ARRAY);
                    return;
                }
                boolean z = !y(jsonValue);
                int length = h8Var.length();
                loop0: while (true) {
                    h8Var.n(z ? "{\n" : "{ ");
                    for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                        if (z) {
                            u(i, h8Var);
                        }
                        h8Var.n(jsonWriter$OutputType.quoteName(jsonValue2.e));
                        h8Var.n(": ");
                        K(jsonValue2, h8Var, i + 1, cVar);
                        if ((!z || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue2.h != null) {
                            h8Var.a(',');
                        }
                        h8Var.a(z ? '\n' : WebvttCueParser.CHAR_SPACE);
                        if (z || h8Var.length() - length <= cVar.b) {
                        }
                    }
                    h8Var.I(length);
                    z = true;
                }
                if (z) {
                    u(i - 1, h8Var);
                }
                h8Var.a('}');
            } else if (jsonValue.v()) {
                if (jsonValue.f == null) {
                    h8Var.n("[]");
                    return;
                }
                boolean z2 = !y(jsonValue);
                boolean z3 = cVar.c || !C(jsonValue);
                int length2 = h8Var.length();
                loop2: while (true) {
                    h8Var.n(z2 ? "[\n" : "[ ");
                    for (JsonValue jsonValue3 = jsonValue.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        if (z2) {
                            u(i, h8Var);
                        }
                        K(jsonValue3, h8Var, i + 1, cVar);
                        if ((!z2 || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue3.h != null) {
                            h8Var.a(',');
                        }
                        h8Var.a(z2 ? '\n' : WebvttCueParser.CHAR_SPACE);
                        if (!z3 || z2 || h8Var.length() - length2 <= cVar.b) {
                        }
                    }
                    h8Var.I(length2);
                    z2 = true;
                }
                if (z2) {
                    u(i - 1, h8Var);
                }
                h8Var.a(']');
            } else if (jsonValue.E()) {
                h8Var.n(jsonWriter$OutputType.quoteValue(jsonValue.k()));
            } else if (jsonValue.x()) {
                double d = jsonValue.d();
                double h = jsonValue.h();
                if (d == h) {
                    d = h;
                }
                h8Var.b(d);
            } else if (jsonValue.z()) {
                h8Var.g(jsonValue.h());
            } else if (jsonValue.w()) {
                h8Var.o(jsonValue.b());
            } else if (jsonValue.A()) {
                h8Var.n(StringUtil.NULL_STRING);
            } else {
                throw new SerializationException("Unknown object type: " + jsonValue);
            }
        }
    }

    public JsonValue L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            JsonValue jsonValue = this.f;
            while (jsonValue != null) {
                String str2 = jsonValue.e;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    break;
                }
                jsonValue = jsonValue.h;
            }
            if (jsonValue != null) {
                return jsonValue;
            }
            throw new IllegalArgumentException("Child not found with name: " + str);
        }
        return (JsonValue) invokeL.objValue;
    }

    public void M(double d, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d), str}) == null) {
            this.c = d;
            this.d = (long) d;
            this.b = str;
            this.a = ValueType.doubleValue;
        }
    }

    public void N(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            this.d = j;
            this.c = j;
            this.b = str;
            this.a = ValueType.longValue;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.b = str;
            this.a = str == null ? ValueType.nullValue : ValueType.stringValue;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z ? 1L : 0L;
            this.a = ValueType.booleanValue;
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.e = str;
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JsonValue jsonValue = this.g;
            String str = "[]";
            if (jsonValue == null) {
                ValueType valueType = this.a;
                return valueType == ValueType.array ? "[]" : valueType == ValueType.object ? StringUtil.EMPTY_ARRAY : "";
            }
            if (jsonValue.a == ValueType.array) {
                int i = 0;
                JsonValue jsonValue2 = jsonValue.f;
                while (true) {
                    if (jsonValue2 == null) {
                        break;
                    } else if (jsonValue2 == this) {
                        str = PreferencesUtil.LEFT_MOUNT + i + PreferencesUtil.RIGHT_MOUNT;
                        break;
                    } else {
                        jsonValue2 = jsonValue2.h;
                        i++;
                    }
                }
            } else if (this.e.indexOf(46) != -1) {
                str = ".\"" + this.e.replace("\"", "\\\"") + "\"";
            } else {
                str = IStringUtil.EXTENSION_SEPARATOR + this.e;
            }
            return this.g.R() + str;
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return this.c != 0.0d;
                } else if (i == 3) {
                    return this.d != 0;
                } else if (i == 4) {
                    return this.d != 0;
                } else {
                    throw new IllegalStateException("Value cannot be converted to boolean: " + this.a);
                }
            }
            return this.b.equalsIgnoreCase("true");
        }
        return invokeV.booleanValue;
    }

    public byte c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return this.d != 0 ? (byte) 1 : (byte) 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to byte: " + this.a);
                    }
                    return (byte) this.d;
                }
                return (byte) this.c;
            }
            return Byte.parseByte(this.b);
        }
        return invokeV.byteValue;
    }

    public double d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return this.d != 0 ? 1.0d : 0.0d;
                        }
                        throw new IllegalStateException("Value cannot be converted to double: " + this.a);
                    }
                    return this.d;
                }
                return this.c;
            }
            return Double.parseDouble(this.b);
        }
        return invokeV.doubleValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return this.d != 0 ? 1.0f : 0.0f;
                        }
                        throw new IllegalStateException("Value cannot be converted to float: " + this.a);
                    }
                    return (float) this.d;
                }
                return (float) this.c;
            }
            return Float.parseFloat(this.b);
        }
        return invokeV.floatValue;
    }

    public float[] f() {
        InterceptResult invokeV;
        float parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.a == ValueType.array) {
                float[] fArr = new float[this.j];
                int i = 0;
                JsonValue jsonValue = this.f;
                while (jsonValue != null) {
                    int i2 = a.a[jsonValue.a.ordinal()];
                    if (i2 == 1) {
                        parseFloat = Float.parseFloat(jsonValue.b);
                    } else if (i2 == 2) {
                        parseFloat = (float) jsonValue.c;
                    } else if (i2 == 3) {
                        parseFloat = (float) jsonValue.d;
                    } else if (i2 == 4) {
                        parseFloat = jsonValue.d != 0 ? 1.0f : 0.0f;
                    } else {
                        throw new IllegalStateException("Value cannot be converted to float: " + jsonValue.a);
                    }
                    fArr[i] = parseFloat;
                    jsonValue = jsonValue.h;
                    i++;
                }
                return fArr;
            }
            throw new IllegalStateException("Value is not an array: " + this.a);
        }
        return (float[]) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return this.d != 0 ? 1 : 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to int: " + this.a);
                    }
                    return (int) this.d;
                }
                return (int) this.c;
            }
            return Integer.parseInt(this.b);
        }
        return invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return this.d != 0 ? 1L : 0L;
                        }
                        throw new IllegalStateException("Value cannot be converted to long: " + this.a);
                    }
                    return this.d;
                }
                return (long) this.c;
            }
            return Long.parseLong(this.b);
        }
        return invokeV.longValue;
    }

    public short i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return this.d != 0 ? (short) 1 : (short) 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to short: " + this.a);
                    }
                    return (short) this.d;
                }
                return (short) this.c;
            }
            return Short.parseShort(this.b);
        }
        return invokeV.shortValue;
    }

    public short[] j() {
        InterceptResult invokeV;
        short parseShort;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.a == ValueType.array) {
                short[] sArr = new short[this.j];
                JsonValue jsonValue = this.f;
                int i2 = 0;
                while (jsonValue != null) {
                    int i3 = a.a[jsonValue.a.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            i = (int) jsonValue.c;
                        } else if (i3 == 3) {
                            i = (int) jsonValue.d;
                        } else if (i3 == 4) {
                            parseShort = jsonValue.d != 0 ? (short) 1 : (short) 0;
                        } else {
                            throw new IllegalStateException("Value cannot be converted to short: " + jsonValue.a);
                        }
                        parseShort = (short) i;
                    } else {
                        parseShort = Short.parseShort(jsonValue.b);
                    }
                    sArr[i2] = parseShort;
                    jsonValue = jsonValue.h;
                    i2++;
                }
                return sArr;
            }
            throw new IllegalStateException("Value is not an array: " + this.a);
        }
        return (short[]) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    String str = this.b;
                    return str != null ? str : Double.toString(this.c);
                } else if (i == 3) {
                    String str2 = this.b;
                    return str2 != null ? str2 : Long.toString(this.d);
                } else if (i == 4) {
                    return this.d != 0 ? "true" : "false";
                } else if (i == 5) {
                    return null;
                } else {
                    throw new IllegalStateException("Value cannot be converted to string: " + this.a);
                }
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public JsonValue l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            JsonValue jsonValue = this.f;
            while (jsonValue != null && i > 0) {
                i--;
                jsonValue = jsonValue.h;
            }
            return jsonValue;
        }
        return (JsonValue) invokeI.objValue;
    }

    public JsonValue m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            JsonValue jsonValue = this.f;
            while (jsonValue != null) {
                String str2 = jsonValue.e;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    break;
                }
                jsonValue = jsonValue.h;
            }
            return jsonValue;
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            JsonValue m = m(str);
            if (m == null) {
                return null;
            }
            return m.f;
        }
        return (JsonValue) invokeL.objValue;
    }

    public float o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            JsonValue l = l(i);
            if (l != null) {
                return l.e();
            }
            throw new IllegalArgumentException("Indexed value not found: " + this.e);
        }
        return invokeI.floatValue;
    }

    public float p(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048608, this, str, f)) == null) {
            JsonValue m = m(str);
            return (m == null || !m.F() || m.A()) ? f : m.e();
        }
        return invokeLF.floatValue;
    }

    public short q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            JsonValue l = l(i);
            if (l != null) {
                return l.i();
            }
            throw new IllegalArgumentException("Indexed value not found: " + this.e);
        }
        return invokeI.shortValue;
    }

    public String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            JsonValue m = m(str);
            if (m != null) {
                return m.k();
            }
            throw new IllegalArgumentException("Named value not found: " + str);
        }
        return (String) invokeL.objValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, str, str2)) == null) {
            JsonValue m = m(str);
            return (m == null || !m.F() || m.A()) ? str2 : m.k();
        }
        return (String) invokeLL.objValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) ? m(str) != null : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (F()) {
                if (this.e == null) {
                    return k();
                }
                return this.e + ": " + k();
            }
            StringBuilder sb = new StringBuilder();
            if (this.e == null) {
                str = "";
            } else {
                str = this.e + ": ";
            }
            sb.append(str);
            sb.append(J(JsonWriter$OutputType.minimal, 0));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.a == ValueType.array : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.a == ValueType.booleanValue : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.a == ValueType.doubleValue : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.a == ValueType.longValue : invokeV.booleanValue;
    }

    public JsonValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        O(str);
    }

    public JsonValue(double d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        M(d, null);
    }

    public JsonValue(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        N(j, null);
    }

    public JsonValue(double d, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M(d, str);
    }

    public JsonValue(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        N(j, str);
    }

    public JsonValue(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        P(z);
    }
}
