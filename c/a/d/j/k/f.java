package c.a.d.j.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f implements Comparable<f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f2522b;

    /* renamed from: c  reason: collision with root package name */
    public int f2523c;

    /* renamed from: d  reason: collision with root package name */
    public int f2524d;

    /* renamed from: e  reason: collision with root package name */
    public int f2525e;

    /* renamed from: f  reason: collision with root package name */
    public int f2526f;

    public f() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            int i = this.a;
            int i2 = fVar.a;
            if (i - i2 > 0) {
                return 1;
            }
            if (i - i2 < 0) {
                return -1;
            }
            int i3 = this.f2522b;
            int i4 = fVar.f2522b;
            if (i3 - i4 > 0) {
                return 1;
            }
            if (i3 - i4 < 0) {
                return -1;
            }
            int i5 = this.f2523c;
            int i6 = fVar.f2523c;
            if (i5 - i6 > 0) {
                return 1;
            }
            if (i5 - i6 < 0) {
                return -1;
            }
            int i7 = this.f2524d;
            int i8 = fVar.f2524d;
            if (i7 - i8 > 0) {
                return 1;
            }
            if (i7 - i8 < 0) {
                return -1;
            }
            int i9 = this.f2525e;
            int i10 = fVar.f2525e;
            if (i9 - i10 > 0) {
                return 1;
            }
            if (i9 - i10 < 0) {
                return -1;
            }
            int i11 = this.f2526f;
            int i12 = fVar.f2526f;
            if (i11 - i12 > 0) {
                return 1;
            }
            return i11 - i12 < 0 ? -1 : 0;
        }
        return invokeL.intValue;
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.a = i;
            this.f2522b = i2;
            this.f2523c = i3;
            this.f2524d = i4;
            this.f2525e = i5;
            this.f2526f = i6;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (obj instanceof f) && compareTo((f) obj) == 0 : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a + "-" + this.f2522b + "-" + this.f2523c + " " + this.f2524d + ":" + this.f2525e + ":" + this.f2526f;
        }
        return (String) invokeV.objValue;
    }
}
