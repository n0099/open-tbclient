package com.badlogic.gdx.utils;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.j0;
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class JsonValue implements Iterable<JsonValue> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ValueType f31629e;

    /* renamed from: f  reason: collision with root package name */
    public String f31630f;

    /* renamed from: g  reason: collision with root package name */
    public double f31631g;

    /* renamed from: h  reason: collision with root package name */
    public long f31632h;

    /* renamed from: i  reason: collision with root package name */
    public String f31633i;

    /* renamed from: j  reason: collision with root package name */
    public JsonValue f31634j;

    /* renamed from: k  reason: collision with root package name */
    public JsonValue f31635k;
    public JsonValue l;
    public JsonValue m;
    public int n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

        public ValueType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class b implements Iterator<JsonValue>, Iterable<JsonValue> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public JsonValue f31636e;

        /* renamed from: f  reason: collision with root package name */
        public JsonValue f31637f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JsonValue f31638g;

        public b(JsonValue jsonValue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jsonValue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31638g = jsonValue;
            this.f31636e = this.f31638g.f31634j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: b */
        public JsonValue next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JsonValue jsonValue = this.f31636e;
                this.f31637f = jsonValue;
                if (jsonValue != null) {
                    this.f31636e = jsonValue.l;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31636e != null : invokeV.booleanValue;
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
                JsonValue jsonValue = this.f31637f;
                JsonValue jsonValue2 = jsonValue.m;
                if (jsonValue2 == null) {
                    JsonValue jsonValue3 = this.f31638g;
                    JsonValue jsonValue4 = jsonValue.l;
                    jsonValue3.f31634j = jsonValue4;
                    if (jsonValue4 != null) {
                        jsonValue4.m = null;
                    }
                } else {
                    jsonValue2.l = jsonValue.l;
                    JsonValue jsonValue5 = jsonValue.l;
                    if (jsonValue5 != null) {
                        jsonValue5.m = jsonValue2;
                    }
                }
                JsonValue jsonValue6 = this.f31638g;
                jsonValue6.n--;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JsonWriter$OutputType a;

        /* renamed from: b  reason: collision with root package name */
        public int f31639b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31640c;

        public c() {
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
    }

    public JsonValue(ValueType valueType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valueType};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.f31629e = valueType;
    }

    public static boolean C(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f31634j; jsonValue2 != null; jsonValue2 = jsonValue2.l) {
                if (!jsonValue2.B()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void u(int i2, j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i2, j0Var) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                j0Var.a('\t');
            }
        }
    }

    public static boolean y(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f31634j; jsonValue2 != null; jsonValue2 = jsonValue2.l) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31629e == ValueType.nullValue : invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ValueType valueType = this.f31629e;
            return valueType == ValueType.doubleValue || valueType == ValueType.longValue;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31629e == ValueType.object : invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31629e == ValueType.stringValue : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31633i : (String) invokeV.objValue;
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

    public String J(JsonWriter$OutputType jsonWriter$OutputType, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonWriter$OutputType, i2)) == null) {
            c cVar = new c();
            cVar.a = jsonWriter$OutputType;
            cVar.f31639b = i2;
            return I(cVar);
        }
        return (String) invokeLI.objValue;
    }

    public final void K(JsonValue jsonValue, j0 j0Var, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048585, this, jsonValue, j0Var, i2, cVar) == null) {
            JsonWriter$OutputType jsonWriter$OutputType = cVar.a;
            if (jsonValue.D()) {
                if (jsonValue.f31634j == null) {
                    j0Var.n(StringUtil.EMPTY_ARRAY);
                    return;
                }
                boolean z = !y(jsonValue);
                int length = j0Var.length();
                loop0: while (true) {
                    j0Var.n(z ? "{\n" : "{ ");
                    for (JsonValue jsonValue2 = jsonValue.f31634j; jsonValue2 != null; jsonValue2 = jsonValue2.l) {
                        if (z) {
                            u(i2, j0Var);
                        }
                        j0Var.n(jsonWriter$OutputType.quoteName(jsonValue2.f31633i));
                        j0Var.n(": ");
                        K(jsonValue2, j0Var, i2 + 1, cVar);
                        if ((!z || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue2.l != null) {
                            j0Var.a(',');
                        }
                        j0Var.a(z ? '\n' : ' ');
                        if (z || j0Var.length() - length <= cVar.f31639b) {
                        }
                    }
                    j0Var.I(length);
                    z = true;
                }
                if (z) {
                    u(i2 - 1, j0Var);
                }
                j0Var.a(ExtendedMessageFormat.END_FE);
            } else if (jsonValue.v()) {
                if (jsonValue.f31634j == null) {
                    j0Var.n("[]");
                    return;
                }
                boolean z2 = !y(jsonValue);
                boolean z3 = cVar.f31640c || !C(jsonValue);
                int length2 = j0Var.length();
                loop2: while (true) {
                    j0Var.n(z2 ? "[\n" : "[ ");
                    for (JsonValue jsonValue3 = jsonValue.f31634j; jsonValue3 != null; jsonValue3 = jsonValue3.l) {
                        if (z2) {
                            u(i2, j0Var);
                        }
                        K(jsonValue3, j0Var, i2 + 1, cVar);
                        if ((!z2 || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue3.l != null) {
                            j0Var.a(',');
                        }
                        j0Var.a(z2 ? '\n' : ' ');
                        if (!z3 || z2 || j0Var.length() - length2 <= cVar.f31639b) {
                        }
                    }
                    j0Var.I(length2);
                    z2 = true;
                }
                if (z2) {
                    u(i2 - 1, j0Var);
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
            JsonValue jsonValue = this.f31634j;
            while (jsonValue != null) {
                String str2 = jsonValue.f31633i;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    break;
                }
                jsonValue = jsonValue.l;
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
            this.f31631g = d2;
            this.f31632h = (long) d2;
            this.f31630f = str;
            this.f31629e = ValueType.doubleValue;
        }
    }

    public void N(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j2, str) == null) {
            this.f31632h = j2;
            this.f31631g = j2;
            this.f31630f = str;
            this.f31629e = ValueType.longValue;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f31630f = str;
            this.f31629e = str == null ? ValueType.nullValue : ValueType.stringValue;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f31632h = z ? 1L : 0L;
            this.f31629e = ValueType.booleanValue;
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.f31633i = str;
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JsonValue jsonValue = this.f31635k;
            String str = "[]";
            if (jsonValue == null) {
                ValueType valueType = this.f31629e;
                return valueType == ValueType.array ? "[]" : valueType == ValueType.object ? StringUtil.EMPTY_ARRAY : "";
            }
            if (jsonValue.f31629e == ValueType.array) {
                int i2 = 0;
                JsonValue jsonValue2 = jsonValue.f31634j;
                while (true) {
                    if (jsonValue2 == null) {
                        break;
                    } else if (jsonValue2 == this) {
                        str = PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT;
                        break;
                    } else {
                        jsonValue2 = jsonValue2.l;
                        i2++;
                    }
                }
            } else if (this.f31633i.indexOf(46) != -1) {
                str = ".\"" + this.f31633i.replace("\"", "\\\"") + "\"";
            } else {
                str = '.' + this.f31633i;
            }
            return this.f31635k.R() + str;
        }
        return (String) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return this.f31631g != 0.0d;
                } else if (i2 == 3) {
                    return this.f31632h != 0;
                } else if (i2 == 4) {
                    return this.f31632h != 0;
                } else {
                    throw new IllegalStateException("Value cannot be converted to boolean: " + this.f31629e);
                }
            }
            return this.f31630f.equalsIgnoreCase("true");
        }
        return invokeV.booleanValue;
    }

    public byte c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f31632h != 0 ? (byte) 1 : (byte) 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to byte: " + this.f31629e);
                    }
                    return (byte) this.f31632h;
                }
                return (byte) this.f31631g;
            }
            return Byte.parseByte(this.f31630f);
        }
        return invokeV.byteValue;
    }

    public double d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f31632h != 0 ? 1.0d : 0.0d;
                        }
                        throw new IllegalStateException("Value cannot be converted to double: " + this.f31629e);
                    }
                    return this.f31632h;
                }
                return this.f31631g;
            }
            return Double.parseDouble(this.f31630f);
        }
        return invokeV.doubleValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f31632h != 0 ? 1.0f : 0.0f;
                        }
                        throw new IllegalStateException("Value cannot be converted to float: " + this.f31629e);
                    }
                    return (float) this.f31632h;
                }
                return (float) this.f31631g;
            }
            return Float.parseFloat(this.f31630f);
        }
        return invokeV.floatValue;
    }

    public float[] f() {
        InterceptResult invokeV;
        float parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.f31629e == ValueType.array) {
                float[] fArr = new float[this.n];
                int i2 = 0;
                JsonValue jsonValue = this.f31634j;
                while (jsonValue != null) {
                    int i3 = a.a[jsonValue.f31629e.ordinal()];
                    if (i3 == 1) {
                        parseFloat = Float.parseFloat(jsonValue.f31630f);
                    } else if (i3 == 2) {
                        parseFloat = (float) jsonValue.f31631g;
                    } else if (i3 == 3) {
                        parseFloat = (float) jsonValue.f31632h;
                    } else if (i3 == 4) {
                        parseFloat = jsonValue.f31632h != 0 ? 1.0f : 0.0f;
                    } else {
                        throw new IllegalStateException("Value cannot be converted to float: " + jsonValue.f31629e);
                    }
                    fArr[i2] = parseFloat;
                    jsonValue = jsonValue.l;
                    i2++;
                }
                return fArr;
            }
            throw new IllegalStateException("Value is not an array: " + this.f31629e);
        }
        return (float[]) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f31632h != 0 ? 1 : 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to int: " + this.f31629e);
                    }
                    return (int) this.f31632h;
                }
                return (int) this.f31631g;
            }
            return Integer.parseInt(this.f31630f);
        }
        return invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f31632h != 0 ? 1L : 0L;
                        }
                        throw new IllegalStateException("Value cannot be converted to long: " + this.f31629e);
                    }
                    return this.f31632h;
                }
                return (long) this.f31631g;
            }
            return Long.parseLong(this.f31630f);
        }
        return invokeV.longValue;
    }

    public short i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return this.f31632h != 0 ? (short) 1 : (short) 0;
                        }
                        throw new IllegalStateException("Value cannot be converted to short: " + this.f31629e);
                    }
                    return (short) this.f31632h;
                }
                return (short) this.f31631g;
            }
            return Short.parseShort(this.f31630f);
        }
        return invokeV.shortValue;
    }

    public short[] j() {
        InterceptResult invokeV;
        short parseShort;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.f31629e == ValueType.array) {
                short[] sArr = new short[this.n];
                JsonValue jsonValue = this.f31634j;
                int i3 = 0;
                while (jsonValue != null) {
                    int i4 = a.a[jsonValue.f31629e.ordinal()];
                    if (i4 != 1) {
                        if (i4 == 2) {
                            i2 = (int) jsonValue.f31631g;
                        } else if (i4 == 3) {
                            i2 = (int) jsonValue.f31632h;
                        } else if (i4 == 4) {
                            parseShort = jsonValue.f31632h != 0 ? (short) 1 : (short) 0;
                        } else {
                            throw new IllegalStateException("Value cannot be converted to short: " + jsonValue.f31629e);
                        }
                        parseShort = (short) i2;
                    } else {
                        parseShort = Short.parseShort(jsonValue.f31630f);
                    }
                    sArr[i3] = parseShort;
                    jsonValue = jsonValue.l;
                    i3++;
                }
                return sArr;
            }
            throw new IllegalStateException("Value is not an array: " + this.f31629e);
        }
        return (short[]) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            int i2 = a.a[this.f31629e.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    String str = this.f31630f;
                    return str != null ? str : Double.toString(this.f31631g);
                } else if (i2 == 3) {
                    String str2 = this.f31630f;
                    return str2 != null ? str2 : Long.toString(this.f31632h);
                } else if (i2 == 4) {
                    return this.f31632h != 0 ? "true" : "false";
                } else if (i2 == 5) {
                    return null;
                } else {
                    throw new IllegalStateException("Value cannot be converted to string: " + this.f31629e);
                }
            }
            return this.f31630f;
        }
        return (String) invokeV.objValue;
    }

    public JsonValue l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            JsonValue jsonValue = this.f31634j;
            while (jsonValue != null && i2 > 0) {
                i2--;
                jsonValue = jsonValue.l;
            }
            return jsonValue;
        }
        return (JsonValue) invokeI.objValue;
    }

    public JsonValue m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            JsonValue jsonValue = this.f31634j;
            while (jsonValue != null) {
                String str2 = jsonValue.f31633i;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    break;
                }
                jsonValue = jsonValue.l;
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
            return m.f31634j;
        }
        return (JsonValue) invokeL.objValue;
    }

    public float o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            JsonValue l = l(i2);
            if (l != null) {
                return l.e();
            }
            throw new IllegalArgumentException("Indexed value not found: " + this.f31633i);
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

    public short q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i2)) == null) {
            JsonValue l = l(i2);
            if (l != null) {
                return l.i();
            }
            throw new IllegalArgumentException("Indexed value not found: " + this.f31633i);
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
                if (this.f31633i == null) {
                    return k();
                }
                return this.f31633i + ": " + k();
            }
            StringBuilder sb = new StringBuilder();
            if (this.f31633i == null) {
                str = "";
            } else {
                str = this.f31633i + ": ";
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.f31629e == ValueType.array : invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.f31629e == ValueType.booleanValue : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f31629e == ValueType.doubleValue : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.f31629e == ValueType.longValue : invokeV.booleanValue;
    }

    public JsonValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        M(d2, null);
    }

    public JsonValue(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        N(j2, null);
    }

    public JsonValue(double d2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M(d2, str);
    }

    public JsonValue(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        N(j2, str);
    }

    public JsonValue(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65542, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65542, newInitContext);
                return;
            }
        }
        P(z);
    }
}
