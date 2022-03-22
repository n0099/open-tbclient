package com.badlogic.gdx.utils;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.j0;
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
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes3.dex */
public class JsonValue implements Iterable<JsonValue> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueType a;

    /* renamed from: b  reason: collision with root package name */
    public String f23790b;

    /* renamed from: c  reason: collision with root package name */
    public double f23791c;

    /* renamed from: d  reason: collision with root package name */
    public long f23792d;

    /* renamed from: e  reason: collision with root package name */
    public String f23793e;

    /* renamed from: f  reason: collision with root package name */
    public JsonValue f23794f;

    /* renamed from: g  reason: collision with root package name */
    public JsonValue f23795g;

    /* renamed from: h  reason: collision with root package name */
    public JsonValue f23796h;
    public JsonValue i;
    public int j;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements Iterator<JsonValue>, Iterable<JsonValue> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JsonValue a;

        /* renamed from: b  reason: collision with root package name */
        public JsonValue f23797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ JsonValue f23798c;

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
            this.f23798c = jsonValue;
            this.a = this.f23798c.f23794f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: b */
        public JsonValue next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JsonValue jsonValue = this.a;
                this.f23797b = jsonValue;
                if (jsonValue != null) {
                    this.a = jsonValue.f23796h;
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
                JsonValue jsonValue = this.f23797b;
                JsonValue jsonValue2 = jsonValue.i;
                if (jsonValue2 == null) {
                    JsonValue jsonValue3 = this.f23798c;
                    JsonValue jsonValue4 = jsonValue.f23796h;
                    jsonValue3.f23794f = jsonValue4;
                    if (jsonValue4 != null) {
                        jsonValue4.i = null;
                    }
                } else {
                    jsonValue2.f23796h = jsonValue.f23796h;
                    JsonValue jsonValue5 = jsonValue.f23796h;
                    if (jsonValue5 != null) {
                        jsonValue5.i = jsonValue2;
                    }
                }
                JsonValue jsonValue6 = this.f23798c;
                jsonValue6.j--;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JsonWriter$OutputType a;

        /* renamed from: b  reason: collision with root package name */
        public int f23799b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f23800c;

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
            for (JsonValue jsonValue2 = jsonValue.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
                if (!jsonValue2.B()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void u(int i, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, j0Var) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                j0Var.a('\t');
            }
        }
    }

    public static boolean y(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23793e : (String) invokeV.objValue;
    }

    public String I(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            j0 j0Var = new j0(512);
            K(this, j0Var, 0, cVar);
            return j0Var.toString();
        }
        return (String) invokeL.objValue;
    }

    public String J(JsonWriter$OutputType jsonWriter$OutputType, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonWriter$OutputType, i)) == null) {
            c cVar = new c();
            cVar.a = jsonWriter$OutputType;
            cVar.f23799b = i;
            return I(cVar);
        }
        return (String) invokeLI.objValue;
    }

    public final void K(JsonValue jsonValue, j0 j0Var, int i, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048585, this, jsonValue, j0Var, i, cVar) == null) {
            JsonWriter$OutputType jsonWriter$OutputType = cVar.a;
            if (jsonValue.D()) {
                if (jsonValue.f23794f == null) {
                    j0Var.n(StringUtil.EMPTY_ARRAY);
                    return;
                }
                boolean z = !y(jsonValue);
                int length = j0Var.length();
                loop0: while (true) {
                    j0Var.n(z ? "{\n" : "{ ");
                    for (JsonValue jsonValue2 = jsonValue.f23794f; jsonValue2 != null; jsonValue2 = jsonValue2.f23796h) {
                        if (z) {
                            u(i, j0Var);
                        }
                        j0Var.n(jsonWriter$OutputType.quoteName(jsonValue2.f23793e));
                        j0Var.n(": ");
                        K(jsonValue2, j0Var, i + 1, cVar);
                        if ((!z || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue2.f23796h != null) {
                            j0Var.a(',');
                        }
                        j0Var.a(z ? '\n' : WebvttCueParser.CHAR_SPACE);
                        if (z || j0Var.length() - length <= cVar.f23799b) {
                        }
                    }
                    j0Var.I(length);
                    z = true;
                }
                if (z) {
                    u(i - 1, j0Var);
                }
                j0Var.a('}');
            } else if (jsonValue.v()) {
                if (jsonValue.f23794f == null) {
                    j0Var.n("[]");
                    return;
                }
                boolean z2 = !y(jsonValue);
                boolean z3 = cVar.f23800c || !C(jsonValue);
                int length2 = j0Var.length();
                loop2: while (true) {
                    j0Var.n(z2 ? "[\n" : "[ ");
                    for (JsonValue jsonValue3 = jsonValue.f23794f; jsonValue3 != null; jsonValue3 = jsonValue3.f23796h) {
                        if (z2) {
                            u(i, j0Var);
                        }
                        K(jsonValue3, j0Var, i + 1, cVar);
                        if ((!z2 || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue3.f23796h != null) {
                            j0Var.a(',');
                        }
                        j0Var.a(z2 ? '\n' : WebvttCueParser.CHAR_SPACE);
                        if (!z3 || z2 || j0Var.length() - length2 <= cVar.f23799b) {
                        }
                    }
                    j0Var.I(length2);
                    z2 = true;
                }
                if (z2) {
                    u(i - 1, j0Var);
                }
                j0Var.a(']');
            } else if (jsonValue.E()) {
                j0Var.n(jsonWriter$OutputType.quoteValue(jsonValue.k()));
            } else if (jsonValue.x()) {
                double d2 = jsonValue.d();
                double h2 = jsonValue.h();
                if (d2 == h2) {
                    d2 = h2;
                }
                j0Var.b(d2);
            } else if (jsonValue.z()) {
                j0Var.g(jsonValue.h());
            } else if (jsonValue.w()) {
                j0Var.o(jsonValue.b());
            } else if (jsonValue.A()) {
                j0Var.n(StringUtil.NULL_STRING);
            } else {
                throw new SerializationException("Unknown object type: " + jsonValue);
            }
        }
    }

    public JsonValue L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            JsonValue jsonValue = this.f23794f;
            while (jsonValue != null) {
                String str2 = jsonValue.f23793e;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    break;
                }
                jsonValue = jsonValue.f23796h;
            }
            if (jsonValue != null) {
                return jsonValue;
            }
            throw new IllegalArgumentException("Child not found with name: " + str);
        }
        return (JsonValue) invokeL.objValue;
    }

    public void M(double d2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d2), str}) == null) {
            this.f23791c = d2;
            this.f23792d = (long) d2;
            this.f23790b = str;
            this.a = ValueType.doubleValue;
        }
    }

    public void N(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            this.f23792d = j;
            this.f23791c = j;
            this.f23790b = str;
            this.a = ValueType.longValue;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f23790b = str;
            this.a = str == null ? ValueType.nullValue : ValueType.stringValue;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f23792d = z ? 1L : 0L;
            this.a = ValueType.booleanValue;
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f23793e = str;
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JsonValue jsonValue = this.f23795g;
            String str = "[]";
            if (jsonValue == null) {
                ValueType valueType = this.a;
                return valueType == ValueType.array ? "[]" : valueType == ValueType.object ? StringUtil.EMPTY_ARRAY : "";
            }
            if (jsonValue.a == ValueType.array) {
                int i = 0;
                JsonValue jsonValue2 = jsonValue.f23794f;
                while (true) {
                    if (jsonValue2 == null) {
                        break;
                    } else if (jsonValue2 == this) {
                        str = PreferencesUtil.LEFT_MOUNT + i + PreferencesUtil.RIGHT_MOUNT;
                        break;
                    } else {
                        jsonValue2 = jsonValue2.f23796h;
                        i++;
                    }
                }
            } else if (this.f23793e.indexOf(46) != -1) {
                str = ".\"" + this.f23793e.replace("\"", "\\\"") + "\"";
            } else {
                str = IStringUtil.EXTENSION_SEPARATOR + this.f23793e;
            }
            return this.f23795g.R() + str;
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
                    return this.f23791c != 0.0d;
                } else if (i == 3) {
                    return this.f23792d != 0;
                } else if (i == 4) {
                    return this.f23792d != 0;
                } else {
                    throw new IllegalStateException("Value cannot be converted to boolean: " + this.a);
                }
            }
            return this.f23790b.equalsIgnoreCase("true");
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
                            return this.f23792d != 0 ? (byte) 1 : (byte) 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to byte: " + this.a);
                    }
                    return (byte) this.f23792d;
                }
                return (byte) this.f23791c;
            }
            return Byte.parseByte(this.f23790b);
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
                            return this.f23792d != 0 ? 1.0d : 0.0d;
                        }
                        throw new IllegalStateException("Value cannot be converted to double: " + this.a);
                    }
                    return this.f23792d;
                }
                return this.f23791c;
            }
            return Double.parseDouble(this.f23790b);
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
                            return this.f23792d != 0 ? 1.0f : 0.0f;
                        }
                        throw new IllegalStateException("Value cannot be converted to float: " + this.a);
                    }
                    return (float) this.f23792d;
                }
                return (float) this.f23791c;
            }
            return Float.parseFloat(this.f23790b);
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
                JsonValue jsonValue = this.f23794f;
                while (jsonValue != null) {
                    int i2 = a.a[jsonValue.a.ordinal()];
                    if (i2 == 1) {
                        parseFloat = Float.parseFloat(jsonValue.f23790b);
                    } else if (i2 == 2) {
                        parseFloat = (float) jsonValue.f23791c;
                    } else if (i2 == 3) {
                        parseFloat = (float) jsonValue.f23792d;
                    } else if (i2 == 4) {
                        parseFloat = jsonValue.f23792d != 0 ? 1.0f : 0.0f;
                    } else {
                        throw new IllegalStateException("Value cannot be converted to float: " + jsonValue.a);
                    }
                    fArr[i] = parseFloat;
                    jsonValue = jsonValue.f23796h;
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
                            return this.f23792d != 0 ? 1 : 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to int: " + this.a);
                    }
                    return (int) this.f23792d;
                }
                return (int) this.f23791c;
            }
            return Integer.parseInt(this.f23790b);
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
                            return this.f23792d != 0 ? 1L : 0L;
                        }
                        throw new IllegalStateException("Value cannot be converted to long: " + this.a);
                    }
                    return this.f23792d;
                }
                return (long) this.f23791c;
            }
            return Long.parseLong(this.f23790b);
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
                            return this.f23792d != 0 ? (short) 1 : (short) 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to short: " + this.a);
                    }
                    return (short) this.f23792d;
                }
                return (short) this.f23791c;
            }
            return Short.parseShort(this.f23790b);
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
                JsonValue jsonValue = this.f23794f;
                int i2 = 0;
                while (jsonValue != null) {
                    int i3 = a.a[jsonValue.a.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            i = (int) jsonValue.f23791c;
                        } else if (i3 == 3) {
                            i = (int) jsonValue.f23792d;
                        } else if (i3 == 4) {
                            parseShort = jsonValue.f23792d != 0 ? (short) 1 : (short) 0;
                        } else {
                            throw new IllegalStateException("Value cannot be converted to short: " + jsonValue.a);
                        }
                        parseShort = (short) i;
                    } else {
                        parseShort = Short.parseShort(jsonValue.f23790b);
                    }
                    sArr[i2] = parseShort;
                    jsonValue = jsonValue.f23796h;
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
                    String str = this.f23790b;
                    return str != null ? str : Double.toString(this.f23791c);
                } else if (i == 3) {
                    String str2 = this.f23790b;
                    return str2 != null ? str2 : Long.toString(this.f23792d);
                } else if (i == 4) {
                    return this.f23792d != 0 ? "true" : "false";
                } else if (i == 5) {
                    return null;
                } else {
                    throw new IllegalStateException("Value cannot be converted to string: " + this.a);
                }
            }
            return this.f23790b;
        }
        return (String) invokeV.objValue;
    }

    public JsonValue l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i)) == null) {
            JsonValue jsonValue = this.f23794f;
            while (jsonValue != null && i > 0) {
                i--;
                jsonValue = jsonValue.f23796h;
            }
            return jsonValue;
        }
        return (JsonValue) invokeI.objValue;
    }

    public JsonValue m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            JsonValue jsonValue = this.f23794f;
            while (jsonValue != null) {
                String str2 = jsonValue.f23793e;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    break;
                }
                jsonValue = jsonValue.f23796h;
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
            return m.f23794f;
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
            throw new IllegalArgumentException("Indexed value not found: " + this.f23793e);
        }
        return invokeI.floatValue;
    }

    public float p(String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048608, this, str, f2)) == null) {
            JsonValue m = m(str);
            return (m == null || !m.F() || m.A()) ? f2 : m.e();
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
            throw new IllegalArgumentException("Indexed value not found: " + this.f23793e);
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
                if (this.f23793e == null) {
                    return k();
                }
                return this.f23793e + ": " + k();
            }
            StringBuilder sb = new StringBuilder();
            if (this.f23793e == null) {
                str = "";
            } else {
                str = this.f23793e + ": ";
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

    public JsonValue(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        M(d2, null);
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

    public JsonValue(double d2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M(d2, str);
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
