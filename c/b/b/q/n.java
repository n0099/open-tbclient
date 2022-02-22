package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f27682b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27683c;

    /* renamed from: d  reason: collision with root package name */
    public final float f27684d;

    /* renamed from: e  reason: collision with root package name */
    public int f27685e;

    /* renamed from: f  reason: collision with root package name */
    public int f27686f;

    /* renamed from: g  reason: collision with root package name */
    public int f27687g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n() {
        this(51, 0.8f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 == 0) {
                if (this.f27683c) {
                    return false;
                }
                this.f27683c = true;
                this.a++;
                return true;
            }
            int d2 = d(i2);
            if (d2 >= 0) {
                return false;
            }
            int i3 = -(d2 + 1);
            int[] iArr = this.f27682b;
            iArr[i3] = i2;
            int i4 = this.a + 1;
            this.a = i4;
            if (i4 >= this.f27685e) {
                g(iArr.length << 1);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            int[] iArr = this.f27682b;
            int e2 = e(i2);
            while (iArr[e2] != 0) {
                e2 = (e2 + 1) & this.f27687g;
            }
            iArr[e2] = i2;
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == 0) {
                return this.f27683c;
            }
            return d(i2) >= 0;
        }
        return invokeI.booleanValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048579, this, i2)) != null) {
            return invokeI.intValue;
        }
        int[] iArr = this.f27682b;
        int e2 = e(i2);
        while (true) {
            int i3 = iArr[e2];
            if (i3 == 0) {
                return -(e2 + 1);
            }
            if (i3 == i2) {
                return e2;
            }
            e2 = (e2 + 1) & this.f27687g;
        }
    }

    public int e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? (int) ((i2 * (-7046029254386353131L)) >>> this.f27686f) : invokeI.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj instanceof n) {
                n nVar = (n) obj;
                if (nVar.a == this.a && nVar.f27683c == this.f27683c) {
                    int[] iArr = this.f27682b;
                    int length = iArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (iArr[i2] != 0 && !nVar.c(iArr[i2])) {
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

    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048582, this, i2)) != null) {
            return invokeI.booleanValue;
        }
        if (i2 == 0) {
            if (this.f27683c) {
                this.f27683c = false;
                this.a--;
                return true;
            }
            return false;
        }
        int d2 = d(i2);
        if (d2 < 0) {
            return false;
        }
        int[] iArr = this.f27682b;
        int i3 = this.f27687g;
        int i4 = d2 + 1;
        while (true) {
            int i5 = i4 & i3;
            int i6 = iArr[i5];
            if (i6 != 0) {
                int e2 = e(i6);
                if (((i5 - e2) & i3) > ((d2 - e2) & i3)) {
                    iArr[d2] = i6;
                    d2 = i5;
                }
                i4 = i5 + 1;
            } else {
                iArr[d2] = 0;
                this.a--;
                return true;
            }
        }
    }

    public final void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int length = this.f27682b.length;
            this.f27685e = (int) (i2 * this.f27684d);
            int i3 = i2 - 1;
            this.f27687g = i3;
            this.f27686f = Long.numberOfLeadingZeros(i3);
            int[] iArr = this.f27682b;
            this.f27682b = new int[i2];
            if (this.a > 0) {
                for (int i4 = 0; i4 < length; i4++) {
                    int i5 = iArr[i4];
                    if (i5 != 0) {
                        b(i5);
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
            int i2 = this.a;
            for (int i3 : this.f27682b) {
                if (i3 != 0) {
                    i2 += i3;
                }
            }
            return i2;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048585, this)) != null) {
            return (String) invokeV.objValue;
        }
        if (this.a == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        int[] iArr = this.f27682b;
        int length = iArr.length;
        if (this.f27683c) {
            sb.append("0");
            i2 = length - 1;
            if (length > 0) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append(i3);
                }
                length = i2;
                i2 = length - 1;
                if (length > 0) {
                }
            } else {
                sb.append(']');
                return sb.toString();
            }
        } else {
            while (true) {
                i2 = length - 1;
                if (length > 0) {
                    int i4 = iArr[i2];
                    if (i4 != 0) {
                        sb.append(i4);
                        break;
                    }
                    length = i2;
                } else {
                    break;
                }
            }
            length = i2;
            i2 = length - 1;
            if (length > 0) {
            }
        }
    }

    public n(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f2 > 0.0f && f2 < 1.0f) {
            this.f27684d = f2;
            int h2 = x.h(i2, f2);
            this.f27685e = (int) (h2 * f2);
            int i5 = h2 - 1;
            this.f27687g = i5;
            this.f27686f = Long.numberOfLeadingZeros(i5);
            this.f27682b = new int[h2];
            return;
        }
        throw new IllegalArgumentException("loadFactor must be > 0 and < 1: " + f2);
    }
}
