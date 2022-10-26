package com.badlogic.gdx.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.k8;
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
/* loaded from: classes.dex */
public class JsonValue implements Iterable {
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
    public final class ValueType {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ValueType) Enum.valueOf(ValueType.class, str);
            }
            return (ValueType) invokeL.objValue;
        }

        public static ValueType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ValueType[]) $VALUES.clone();
            }
            return (ValueType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class a {
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
    public class b implements Iterator, Iterable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JsonValue a;
        public JsonValue b;
        public final /* synthetic */ JsonValue c;

        @Override // java.lang.Iterable
        public Iterator iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (Iterator) invokeV.objValue;
        }

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
        /* renamed from: a */
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
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
    public class c {
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
        L(d, null);
    }

    public JsonValue K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
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

    public float n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            JsonValue k = k(i);
            if (k != null) {
                return k.d();
            }
            throw new IllegalArgumentException("Indexed value not found: " + this.e);
        }
        return invokeI.floatValue;
    }

    public short p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            JsonValue k = k(i);
            if (k != null) {
                return k.h();
            }
            throw new IllegalArgumentException("Indexed value not found: " + this.e);
        }
        return invokeI.shortValue;
    }

    public String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            JsonValue l = l(str);
            if (l != null) {
                return l.j();
            }
            throw new IllegalArgumentException("Named value not found: " + str);
        }
        return (String) invokeL.objValue;
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
        L(d, str);
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
        M(j, null);
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
        M(j, str);
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

    public static boolean B(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                if (!jsonValue2.A()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean x(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jsonValue)) == null) {
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                if (jsonValue2.C() || jsonValue2.u()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String H(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
            k8 k8Var = new k8(512);
            J(this, k8Var, 0, cVar);
            return k8Var.toString();
        }
        return (String) invokeL.objValue;
    }

    public void N(String str) {
        ValueType valueType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b = str;
            if (str == null) {
                valueType = ValueType.nullValue;
            } else {
                valueType = ValueType.stringValue;
            }
            this.a = valueType;
        }
    }

    public void O(boolean z) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            if (z) {
                j = 1;
            } else {
                j = 0;
            }
            this.d = j;
            this.a = ValueType.booleanValue;
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.e = str;
        }
    }

    public JsonValue k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            JsonValue jsonValue = this.f;
            while (jsonValue != null && i > 0) {
                i--;
                jsonValue = jsonValue.h;
            }
            return jsonValue;
        }
        return (JsonValue) invokeI.objValue;
    }

    public JsonValue l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
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

    public JsonValue m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            JsonValue l = l(str);
            if (l == null) {
                return null;
            }
            return l.f;
        }
        return (JsonValue) invokeL.objValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            if (l(str) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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
        N(str);
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
        O(z);
    }

    public static void t(int i, k8 k8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, k8Var) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                k8Var.a('\t');
            }
        }
    }

    public String I(JsonWriter$OutputType jsonWriter$OutputType, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, jsonWriter$OutputType, i)) == null) {
            c cVar = new c();
            cVar.a = jsonWriter$OutputType;
            cVar.b = i;
            return H(cVar);
        }
        return (String) invokeLI.objValue;
    }

    public void L(double d, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Double.valueOf(d), str}) == null) {
            this.c = d;
            this.d = (long) d;
            this.b = str;
            this.a = ValueType.doubleValue;
        }
    }

    public void M(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) {
            this.d = j;
            this.c = j;
            this.b = str;
            this.a = ValueType.longValue;
        }
    }

    public float o(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048607, this, str, f)) == null) {
            JsonValue l = l(str);
            if (l != null && l.E() && !l.z()) {
                return l.d();
            }
            return f;
        }
        return invokeLF.floatValue;
    }

    public String r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, str, str2)) == null) {
            JsonValue l = l(str);
            if (l != null && l.E() && !l.z()) {
                return l.j();
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ValueType valueType = this.a;
            if (valueType != ValueType.doubleValue && valueType != ValueType.longValue) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == ValueType.object) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == ValueType.stringValue) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Iterable
    /* renamed from: F */
    public b iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new b(this);
        }
        return (b) invokeV.objValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.a == ValueType.array) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.a == ValueType.booleanValue) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.a == ValueType.doubleValue) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.a == ValueType.longValue) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.a == ValueType.nullValue) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void J(JsonValue jsonValue, k8 k8Var, int i, c cVar) {
        boolean z;
        String str;
        char c2;
        String str2;
        char c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonValue, k8Var, i, cVar) == null) {
            JsonWriter$OutputType jsonWriter$OutputType = cVar.a;
            if (jsonValue.C()) {
                if (jsonValue.f == null) {
                    k8Var.n(StringUtil.EMPTY_ARRAY);
                    return;
                }
                boolean z2 = !x(jsonValue);
                int length = k8Var.length();
                loop0: while (true) {
                    if (z2) {
                        str2 = "{\n";
                    } else {
                        str2 = "{ ";
                    }
                    k8Var.n(str2);
                    for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                        if (z2) {
                            t(i, k8Var);
                        }
                        k8Var.n(jsonWriter$OutputType.quoteName(jsonValue2.e));
                        k8Var.n(": ");
                        J(jsonValue2, k8Var, i + 1, cVar);
                        if ((!z2 || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue2.h != null) {
                            k8Var.a(',');
                        }
                        if (z2) {
                            c3 = '\n';
                        } else {
                            c3 = WebvttCueParser.CHAR_SPACE;
                        }
                        k8Var.a(c3);
                        if (z2 || k8Var.length() - length <= cVar.b) {
                        }
                    }
                    k8Var.I(length);
                    z2 = true;
                }
                if (z2) {
                    t(i - 1, k8Var);
                }
                k8Var.a('}');
            } else if (jsonValue.u()) {
                if (jsonValue.f == null) {
                    k8Var.n("[]");
                    return;
                }
                boolean z3 = !x(jsonValue);
                if (!cVar.c && B(jsonValue)) {
                    z = false;
                } else {
                    z = true;
                }
                int length2 = k8Var.length();
                loop2: while (true) {
                    if (z3) {
                        str = "[\n";
                    } else {
                        str = "[ ";
                    }
                    k8Var.n(str);
                    for (JsonValue jsonValue3 = jsonValue.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        if (z3) {
                            t(i, k8Var);
                        }
                        J(jsonValue3, k8Var, i + 1, cVar);
                        if ((!z3 || jsonWriter$OutputType != JsonWriter$OutputType.minimal) && jsonValue3.h != null) {
                            k8Var.a(',');
                        }
                        if (z3) {
                            c2 = '\n';
                        } else {
                            c2 = WebvttCueParser.CHAR_SPACE;
                        }
                        k8Var.a(c2);
                        if (!z || z3 || k8Var.length() - length2 <= cVar.b) {
                        }
                    }
                    k8Var.I(length2);
                    z3 = true;
                }
                if (z3) {
                    t(i - 1, k8Var);
                }
                k8Var.a(']');
            } else if (jsonValue.D()) {
                k8Var.n(jsonWriter$OutputType.quoteValue(jsonValue.j()));
            } else if (jsonValue.w()) {
                double c4 = jsonValue.c();
                double g = jsonValue.g();
                if (c4 == g) {
                    c4 = g;
                }
                k8Var.b(c4);
            } else if (jsonValue.y()) {
                k8Var.g(jsonValue.g());
            } else if (jsonValue.v()) {
                k8Var.o(jsonValue.a());
            } else if (jsonValue.z()) {
                k8Var.n(StringUtil.NULL_STRING);
            } else {
                throw new SerializationException("Unknown object type: " + jsonValue);
            }
        }
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JsonValue jsonValue = this.g;
            String str = "[]";
            if (jsonValue == null) {
                ValueType valueType = this.a;
                if (valueType == ValueType.array) {
                    return "[]";
                }
                if (valueType == ValueType.object) {
                    return StringUtil.EMPTY_ARRAY;
                }
                return "";
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
            return this.g.Q() + str;
        }
        return (String) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d != 0) {
                                return true;
                            }
                            return false;
                        }
                        throw new IllegalStateException("Value cannot be converted to boolean: " + this.a);
                    } else if (this.d != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (this.c != 0.0d) {
                    return true;
                } else {
                    return false;
                }
            }
            return this.b.equalsIgnoreCase("true");
        }
        return invokeV.booleanValue;
    }

    public float[] e() {
        InterceptResult invokeV;
        float parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.a == ValueType.array) {
                float[] fArr = new float[this.j];
                int i = 0;
                JsonValue jsonValue = this.f;
                while (jsonValue != null) {
                    int i2 = a.a[jsonValue.a.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 == 4) {
                                    if (jsonValue.d != 0) {
                                        parseFloat = 1.0f;
                                    } else {
                                        parseFloat = 0.0f;
                                    }
                                } else {
                                    throw new IllegalStateException("Value cannot be converted to float: " + jsonValue.a);
                                }
                            } else {
                                parseFloat = (float) jsonValue.d;
                            }
                        } else {
                            parseFloat = (float) jsonValue.c;
                        }
                    } else {
                        parseFloat = Float.parseFloat(jsonValue.b);
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

    public short[] i() {
        InterceptResult invokeV;
        short parseShort;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.a == ValueType.array) {
                short[] sArr = new short[this.j];
                JsonValue jsonValue = this.f;
                int i2 = 0;
                while (jsonValue != null) {
                    int i3 = a.a[jsonValue.a.ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    if (jsonValue.d != 0) {
                                        parseShort = 1;
                                    } else {
                                        parseShort = 0;
                                    }
                                } else {
                                    throw new IllegalStateException("Value cannot be converted to short: " + jsonValue.a);
                                }
                            } else {
                                i = (int) jsonValue.d;
                            }
                        } else {
                            i = (int) jsonValue.c;
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

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return null;
                            }
                            throw new IllegalStateException("Value cannot be converted to string: " + this.a);
                        } else if (this.d != 0) {
                            return "true";
                        } else {
                            return "false";
                        }
                    }
                    String str = this.b;
                    if (str == null) {
                        return Long.toString(this.d);
                    }
                    return str;
                }
                String str2 = this.b;
                if (str2 == null) {
                    return Double.toString(this.c);
                }
                return str2;
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (E()) {
                if (this.e == null) {
                    return j();
                }
                return this.e + ": " + j();
            }
            StringBuilder sb = new StringBuilder();
            if (this.e == null) {
                str = "";
            } else {
                str = this.e + ": ";
            }
            sb.append(str);
            sb.append(I(JsonWriter$OutputType.minimal, 0));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public byte b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d != 0) {
                                return (byte) 1;
                            }
                            return (byte) 0;
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

    public double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d != 0) {
                                return 1.0d;
                            }
                            return 0.0d;
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

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d != 0) {
                                return 1.0f;
                            }
                            return 0.0f;
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

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d != 0) {
                                return 1;
                            }
                            return 0;
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

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d == 0) {
                                return 0L;
                            }
                            return 1L;
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

    public short h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i = a.a[this.a.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            if (this.d != 0) {
                                return (short) 1;
                            }
                            return (short) 0;
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
}
