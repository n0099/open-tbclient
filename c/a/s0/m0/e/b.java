package c.a.s0.m0.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes7.dex */
public final class b implements Comparable<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final a t;
    public static final b u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final long f19293e;

    /* renamed from: f  reason: collision with root package name */
    public final long f19294f;

    /* renamed from: g  reason: collision with root package name */
    public final String f19295g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f19296h;

    /* renamed from: i  reason: collision with root package name */
    public final int f19297i;

    /* renamed from: j  reason: collision with root package name */
    public final int f19298j;

    /* renamed from: k  reason: collision with root package name */
    public final int f19299k;
    public final int l;
    public final int m;
    public final int n;
    public Long o;
    public PostData p;
    public int q;
    public float r;
    public float s;

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b b(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? new b(Long.MIN_VALUE, j2, "", "", 0, 0, 0, 0, 0, 0, null, null, 0, 0.0f, 16256, null) : (b) invokeJ.objValue;
        }

        public final b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? b.u : (b) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2027823837, "Lc/a/s0/m0/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2027823837, "Lc/a/s0/m0/e/b;");
                return;
            }
        }
        a aVar = new a(null);
        t = aVar;
        u = aVar.b(Long.MAX_VALUE);
    }

    public b(long j2, long j3, String content, CharSequence contentSpan, int i2, int i3, int i4, int i5, int i6, int i7, Long l, PostData postData, int i8, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), content, contentSpan, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), l, postData, Integer.valueOf(i8), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i9 = newInitContext.flag;
            if ((i9 & 1) != 0) {
                int i10 = i9 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(contentSpan, "contentSpan");
        Intrinsics.checkNotNullParameter(postData, "postData");
        this.f19293e = j2;
        this.f19294f = j3;
        this.f19295g = content;
        this.f19296h = contentSpan;
        this.f19297i = i2;
        this.f19298j = i3;
        this.f19299k = i4;
        this.l = i5;
        this.m = i6;
        this.n = i7;
        this.o = l;
        this.p = postData;
        this.q = i8;
        this.r = f2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(b other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return (int) (this.f19294f - other.f19294f);
        }
        return invokeL.intValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f19295g : (String) invokeV.objValue;
    }

    public final CharSequence d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19296h : (CharSequence) invokeV.objValue;
    }

    public final float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.s : invokeV.floatValue;
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f19293e : invokeV.longValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : invokeV.intValue;
    }

    public final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.r : invokeV.floatValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19297i : invokeV.intValue;
    }

    public final long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19294f : invokeV.longValue;
    }

    public final PostData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : (PostData) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f19299k : invokeV.intValue;
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f19298j : invokeV.intValue;
    }

    public final Long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : (Long) invokeV.objValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.l > 0 : invokeV.booleanValue;
    }

    public final void q(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.s = f2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return "Danmaku{id: " + this.f19293e + ", content: " + StringsKt___StringsKt.take(this.f19295g, 5) + ", position: " + this.f19294f + ", mode: " + this.f19297i + ", rank: " + this.n + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ b(long j2, long j3, String str, CharSequence charSequence, int i2, int i3, int i4, int i5, int i6, int i7, Long l, PostData postData, int i8, float f2, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, str, charSequence, i2, i3, i4, (i9 & 128) != 0 ? 0 : i5, (i9 & 256) != 0 ? 1 : i6, (i9 & 512) != 0 ? 0 : i7, (i9 & 1024) != 0 ? null : l, (i9 & 2048) != 0 ? new PostData() : postData, (i9 & 4096) != 0 ? 0 : i8, (i9 & 8192) != 0 ? 0.0f : f2);
    }
}
