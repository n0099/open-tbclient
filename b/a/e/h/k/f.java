package b.a.e.h.k;

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

    /* renamed from: e  reason: collision with root package name */
    public int f2343e;

    /* renamed from: f  reason: collision with root package name */
    public int f2344f;

    /* renamed from: g  reason: collision with root package name */
    public int f2345g;

    /* renamed from: h  reason: collision with root package name */
    public int f2346h;

    /* renamed from: i  reason: collision with root package name */
    public int f2347i;
    public int j;

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
            int i2 = this.f2343e;
            int i3 = fVar.f2343e;
            if (i2 - i3 > 0) {
                return 1;
            }
            if (i2 - i3 < 0) {
                return -1;
            }
            int i4 = this.f2344f;
            int i5 = fVar.f2344f;
            if (i4 - i5 > 0) {
                return 1;
            }
            if (i4 - i5 < 0) {
                return -1;
            }
            int i6 = this.f2345g;
            int i7 = fVar.f2345g;
            if (i6 - i7 > 0) {
                return 1;
            }
            if (i6 - i7 < 0) {
                return -1;
            }
            int i8 = this.f2346h;
            int i9 = fVar.f2346h;
            if (i8 - i9 > 0) {
                return 1;
            }
            if (i8 - i9 < 0) {
                return -1;
            }
            int i10 = this.f2347i;
            int i11 = fVar.f2347i;
            if (i10 - i11 > 0) {
                return 1;
            }
            if (i10 - i11 < 0) {
                return -1;
            }
            int i12 = this.j;
            int i13 = fVar.j;
            if (i12 - i13 > 0) {
                return 1;
            }
            return i12 - i13 < 0 ? -1 : 0;
        }
        return invokeL.intValue;
    }

    public final void b(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f2343e = i2;
            this.f2344f = i3;
            this.f2345g = i4;
            this.f2346h = i5;
            this.f2347i = i6;
            this.j = i7;
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
            return this.f2343e + "-" + this.f2344f + "-" + this.f2345g + " " + this.f2346h + ":" + this.f2347i + ":" + this.j;
        }
        return (String) invokeV.objValue;
    }
}
