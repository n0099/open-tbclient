package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f22796b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f22797c;

    /* renamed from: d  reason: collision with root package name */
    public final float f22798d;

    /* renamed from: e  reason: collision with root package name */
    public int f22799e;

    /* renamed from: f  reason: collision with root package name */
    public int f22800f;

    /* renamed from: g  reason: collision with root package name */
    public int f22801g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i == 0) {
                if (this.f22797c) {
                    return false;
                }
                this.f22797c = true;
                this.a++;
                return true;
            }
            int d2 = d(i);
            if (d2 >= 0) {
                return false;
            }
            int i2 = -(d2 + 1);
            int[] iArr = this.f22796b;
            iArr[i2] = i;
            int i3 = this.a + 1;
            this.a = i3;
            if (i3 >= this.f22799e) {
                g(iArr.length << 1);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int[] iArr = this.f22796b;
            int e2 = e(i);
            while (iArr[e2] != 0) {
                e2 = (e2 + 1) & this.f22801g;
            }
            iArr[e2] = i;
        }
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (i == 0) {
                return this.f22797c;
            }
            return d(i) >= 0;
        }
        return invokeI.booleanValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048579, this, i)) != null) {
            return invokeI.intValue;
        }
        int[] iArr = this.f22796b;
        int e2 = e(i);
        while (true) {
            int i2 = iArr[e2];
            if (i2 == 0) {
                return -(e2 + 1);
            }
            if (i2 == i) {
                return e2;
            }
            e2 = (e2 + 1) & this.f22801g;
        }
    }

    public int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? (int) ((i * (-7046029254386353131L)) >>> this.f22800f) : invokeI.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof n) {
                n nVar = (n) obj;
                if (nVar.a == this.a && nVar.f22797c == this.f22797c) {
                    int[] iArr = this.f22796b;
                    int length = iArr.length;
                    for (int i = 0; i < length; i++) {
                        if (iArr[i] != 0 && !nVar.c(iArr[i])) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048582, this, i)) != null) {
            return invokeI.booleanValue;
        }
        if (i == 0) {
            if (this.f22797c) {
                this.f22797c = false;
                this.a--;
                return true;
            }
            return false;
        }
        int d2 = d(i);
        if (d2 < 0) {
            return false;
        }
        int[] iArr = this.f22796b;
        int i2 = this.f22801g;
        int i3 = d2 + 1;
        while (true) {
            int i4 = i3 & i2;
            int i5 = iArr[i4];
            if (i5 != 0) {
                int e2 = e(i5);
                if (((i4 - e2) & i2) > ((d2 - e2) & i2)) {
                    iArr[d2] = i5;
                    d2 = i4;
                }
                i3 = i4 + 1;
            } else {
                iArr[d2] = 0;
                this.a--;
                return true;
            }
        }
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            int length = this.f22796b.length;
            this.f22799e = (int) (i * this.f22798d);
            int i2 = i - 1;
            this.f22801g = i2;
            this.f22800f = Long.numberOfLeadingZeros(i2);
            int[] iArr = this.f22796b;
            this.f22796b = new int[i];
            if (this.a > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    if (i4 != 0) {
                        b(i4);
                    }
                }
            }
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.a;
            for (int i2 : this.f22796b) {
                if (i2 != 0) {
                    i += i2;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0031 -> B:18:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048585, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.a == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        int[] iArr = this.f22796b;
        int length = iArr.length;
        if (this.f22797c) {
            sb.append("0");
            i = length - 1;
            if (length > 0) {
                int i2 = iArr[i];
                if (i2 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(i2);
                }
                length = i;
                i = length - 1;
                if (length > 0) {
                }
            } else {
                sb.append(']');
                return sb.toString();
            }
        } else {
            while (true) {
                i = length - 1;
                if (length > 0) {
                    int i3 = iArr[i];
                    if (i3 != 0) {
                        sb.append(i3);
                        break;
                    }
                    length = i;
                } else {
                    break;
                }
            }
            length = i;
            i = length - 1;
            if (length > 0) {
            }
        }
    }

    public n(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f22798d = f2;
            int h2 = x.h(i, f2);
            this.f22799e = (int) (h2 * f2);
            int i4 = h2 - 1;
            this.f22801g = i4;
            this.f22800f = Long.numberOfLeadingZeros(i4);
            this.f22796b = new int[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
