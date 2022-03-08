package c.a.p0.r.a.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class f<K, V> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Object[] f11217h;

    /* renamed from: i  reason: collision with root package name */
    public static int f11218i;

    /* renamed from: j  reason: collision with root package name */
    public static Object[] f11219j;
    public static int k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int[] f11220e;

    /* renamed from: f  reason: collision with root package name */
    public Object[] f11221f;

    /* renamed from: g  reason: collision with root package name */
    public int f11222g;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11220e = b.a;
        this.f11221f = b.f11200b;
        this.f11222g = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, iArr, objArr, i2) == null) {
            if (iArr.length == 8) {
                synchronized (a.class) {
                    if (k < 10) {
                        objArr[0] = f11219j;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f11219j = objArr;
                        k++;
                    }
                }
            } else if (iArr.length == 4) {
                synchronized (a.class) {
                    if (f11218i < 10) {
                        objArr[0] = f11217h;
                        objArr[1] = iArr;
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        f11217h = objArr;
                        f11218i++;
                    }
                }
            }
        }
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 8) {
                synchronized (a.class) {
                    if (f11219j != null) {
                        Object[] objArr = f11219j;
                        this.f11221f = objArr;
                        f11219j = (Object[]) objArr[0];
                        this.f11220e = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        k--;
                        return;
                    }
                }
            } else if (i2 == 4) {
                synchronized (a.class) {
                    if (f11217h != null) {
                        Object[] objArr2 = f11217h;
                        this.f11221f = objArr2;
                        f11217h = (Object[]) objArr2[0];
                        this.f11220e = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f11218i--;
                        return;
                    }
                }
            }
            this.f11220e = new int[i2];
            this.f11221f = new Object[i2 << 1];
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            int[] iArr = this.f11220e;
            if (iArr.length < i2) {
                Object[] objArr = this.f11221f;
                a(i2);
                int i3 = this.f11222g;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.f11220e, 0, i3);
                    System.arraycopy(objArr, 0, this.f11221f, 0, this.f11222g << 1);
                }
                c(iArr, objArr, this.f11222g);
            }
        }
    }

    public void clear() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (i2 = this.f11222g) == 0) {
            return;
        }
        c(this.f11220e, this.f11221f, i2);
        this.f11220e = b.a;
        this.f11221f = b.f11200b;
        this.f11222g = 0;
    }

    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? e(obj) >= 0 : invokeL.booleanValue;
    }

    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? g(obj) >= 0 : invokeL.booleanValue;
    }

    public int d(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, obj, i2)) == null) {
            int i3 = this.f11222g;
            if (i3 == 0) {
                return -1;
            }
            int a = b.a(this.f11220e, i3, i2);
            if (a >= 0 && !obj.equals(this.f11221f[a << 1])) {
                int i4 = a + 1;
                while (i4 < i3 && this.f11220e[i4] == i2) {
                    if (obj.equals(this.f11221f[i4 << 1])) {
                        return i4;
                    }
                    i4++;
                }
                for (int i5 = a - 1; i5 >= 0 && this.f11220e[i5] == i2; i5--) {
                    if (obj.equals(this.f11221f[i5 << 1])) {
                        return i5;
                    }
                }
                return ~i4;
            }
            return a;
        }
        return invokeLI.intValue;
    }

    public int e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? obj == null ? f() : d(obj, obj.hashCode()) : invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.f11222g; i2++) {
                    try {
                        K h2 = h(i2);
                        V k2 = k(i2);
                        Object obj2 = map.get(h2);
                        if (k2 == null) {
                            if (obj2 != null || !map.containsKey(h2)) {
                                return false;
                            }
                        } else if (!k2.equals(obj2)) {
                            return false;
                        }
                    } catch (ClassCastException | NullPointerException unused) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f11222g;
            if (i2 == 0) {
                return -1;
            }
            int a = b.a(this.f11220e, i2, 0);
            if (a >= 0 && this.f11221f[a << 1] != null) {
                int i3 = a + 1;
                while (i3 < i2 && this.f11220e[i3] == 0) {
                    if (this.f11221f[i3 << 1] == null) {
                        return i3;
                    }
                    i3++;
                }
                for (int i4 = a - 1; i4 >= 0 && this.f11220e[i4] == 0; i4--) {
                    if (this.f11221f[i4 << 1] == null) {
                        return i4;
                    }
                }
                return ~i3;
            }
            return a;
        }
        return invokeV.intValue;
    }

    public int g(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            int i2 = this.f11222g * 2;
            Object[] objArr = this.f11221f;
            if (obj == null) {
                for (int i3 = 1; i3 < i2; i3 += 2) {
                    if (objArr[i3] == null) {
                        return i3 >> 1;
                    }
                }
                return -1;
            }
            for (int i4 = 1; i4 < i2; i4 += 2) {
                if (obj.equals(objArr[i4])) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            int e2 = e(obj);
            if (e2 >= 0) {
                return (V) this.f11221f[(e2 << 1) + 1];
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public K h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? (K) this.f11221f[i2 << 1] : (K) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int[] iArr = this.f11220e;
            Object[] objArr = this.f11221f;
            int i2 = this.f11222g;
            int i3 = 1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                Object obj = objArr[i3];
                i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
                i4++;
                i3 += 2;
            }
            return i5;
        }
        return invokeV.intValue;
    }

    public V i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            Object[] objArr = this.f11221f;
            int i3 = i2 << 1;
            V v = (V) objArr[i3 + 1];
            int i4 = this.f11222g;
            if (i4 <= 1) {
                c(this.f11220e, objArr, i4);
                this.f11220e = b.a;
                this.f11221f = b.f11200b;
                this.f11222g = 0;
            } else {
                int[] iArr = this.f11220e;
                if (iArr.length > 8 && i4 < iArr.length / 3) {
                    int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                    int[] iArr2 = this.f11220e;
                    Object[] objArr2 = this.f11221f;
                    a(i5);
                    this.f11222g--;
                    if (i2 > 0) {
                        System.arraycopy(iArr2, 0, this.f11220e, 0, i2);
                        System.arraycopy(objArr2, 0, this.f11221f, 0, i3);
                    }
                    int i6 = this.f11222g;
                    if (i2 < i6) {
                        int i7 = i2 + 1;
                        System.arraycopy(iArr2, i7, this.f11220e, i2, i6 - i2);
                        System.arraycopy(objArr2, i7 << 1, this.f11221f, i3, (this.f11222g - i2) << 1);
                    }
                } else {
                    int i8 = this.f11222g - 1;
                    this.f11222g = i8;
                    if (i2 < i8) {
                        int[] iArr3 = this.f11220e;
                        int i9 = i2 + 1;
                        System.arraycopy(iArr3, i9, iArr3, i2, i8 - i2);
                        Object[] objArr3 = this.f11221f;
                        System.arraycopy(objArr3, i9 << 1, objArr3, i3, (this.f11222g - i2) << 1);
                    }
                    Object[] objArr4 = this.f11221f;
                    int i10 = this.f11222g;
                    objArr4[i10 << 1] = null;
                    objArr4[(i10 << 1) + 1] = null;
                }
            }
            return v;
        }
        return (V) invokeI.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f11222g <= 0 : invokeV.booleanValue;
    }

    public V j(int i2, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, v)) == null) {
            int i3 = (i2 << 1) + 1;
            Object[] objArr = this.f11221f;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        return (V) invokeIL.objValue;
    }

    public V k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? (V) this.f11221f[(i2 << 1) + 1] : (V) invokeI.objValue;
    }

    public V put(K k2, V v) {
        InterceptResult invokeLL;
        int i2;
        int d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, k2, v)) == null) {
            if (k2 == null) {
                d2 = f();
                i2 = 0;
            } else {
                int hashCode = k2.hashCode();
                i2 = hashCode;
                d2 = d(k2, hashCode);
            }
            if (d2 >= 0) {
                int i3 = (d2 << 1) + 1;
                Object[] objArr = this.f11221f;
                V v2 = (V) objArr[i3];
                objArr[i3] = v;
                return v2;
            }
            int i4 = ~d2;
            int i5 = this.f11222g;
            if (i5 >= this.f11220e.length) {
                int i6 = 4;
                if (i5 >= 8) {
                    i6 = (i5 >> 1) + i5;
                } else if (i5 >= 4) {
                    i6 = 8;
                }
                int[] iArr = this.f11220e;
                Object[] objArr2 = this.f11221f;
                a(i6);
                int[] iArr2 = this.f11220e;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f11221f, 0, objArr2.length);
                }
                c(iArr, objArr2, this.f11222g);
            }
            int i7 = this.f11222g;
            if (i4 < i7) {
                int[] iArr3 = this.f11220e;
                int i8 = i4 + 1;
                System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
                Object[] objArr3 = this.f11221f;
                System.arraycopy(objArr3, i4 << 1, objArr3, i8 << 1, (this.f11222g - i4) << 1);
            }
            this.f11220e[i4] = i2;
            Object[] objArr4 = this.f11221f;
            int i9 = i4 << 1;
            objArr4[i9] = k2;
            objArr4[i9 + 1] = v;
            this.f11222g++;
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            int e2 = e(obj);
            if (e2 >= 0) {
                return i(e2);
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f11222g : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (isEmpty()) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.f11222g * 28);
            sb.append(ExtendedMessageFormat.START_FE);
            for (int i2 = 0; i2 < this.f11222g; i2++) {
                if (i2 > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                K h2 = h(i2);
                if (h2 != this) {
                    sb.append(h2);
                } else {
                    sb.append("(this Map)");
                }
                sb.append(com.alipay.sdk.encrypt.a.f29503h);
                V k2 = k(i2);
                if (k2 != this) {
                    sb.append(k2);
                } else {
                    sb.append("(this Map)");
                }
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
