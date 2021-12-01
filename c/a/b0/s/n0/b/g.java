package c.a.b0.s.n0.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2055b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2056c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2057d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2058e;

    /* renamed from: f  reason: collision with root package name */
    public final String f2059f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2060g;

    /* renamed from: h  reason: collision with root package name */
    public final int f2061h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2062i;

    /* renamed from: j  reason: collision with root package name */
    public final double f2063j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2064k;
    public final double l;
    public final int m;
    public final boolean n;

    public g(String str, int i2, String str2, String str3, String str4, String str5, int i3, int i4, int i5, double d2, int i6, double d3, int i7, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2, str3, str4, str5, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d2), Integer.valueOf(i6), Double.valueOf(d3), Integer.valueOf(i7), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i8 = newInitContext.flag;
            if ((i8 & 1) != 0) {
                int i9 = i8 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f2055b = i2;
        this.f2056c = str2;
        this.f2057d = str3;
        this.f2058e = str4;
        this.f2059f = str5;
        this.f2060g = i3;
        this.f2061h = i4;
        this.f2062i = i5;
        this.f2063j = d2;
        this.f2064k = i6;
        this.l = d3;
        this.m = i7;
        this.n = z;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f2059f : (String) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2060g : invokeV.intValue;
    }

    public final double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.doubleValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2058e : (String) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    return Intrinsics.areEqual(this.a, gVar.a) && this.f2055b == gVar.f2055b && Intrinsics.areEqual(this.f2056c, gVar.f2056c) && Intrinsics.areEqual(this.f2057d, gVar.f2057d) && Intrinsics.areEqual(this.f2058e, gVar.f2058e) && Intrinsics.areEqual(this.f2059f, gVar.f2059f) && this.f2060g == gVar.f2060g && this.f2061h == gVar.f2061h && this.f2062i == gVar.f2062i && Double.compare(this.f2063j, gVar.f2063j) == 0 && this.f2064k == gVar.f2064k && Double.compare(this.l, gVar.l) == 0 && this.m == gVar.m && this.n == gVar.n;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2062i : invokeV.intValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f2064k : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f2055b) * 31;
            String str2 = this.f2056c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f2057d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f2058e;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f2059f;
            int hashCode5 = str5 != null ? str5.hashCode() : 0;
            long doubleToLongBits = Double.doubleToLongBits(this.f2063j);
            long doubleToLongBits2 = Double.doubleToLongBits(this.l);
            int i2 = (((((((((((((((hashCode4 + hashCode5) * 31) + this.f2060g) * 31) + this.f2061h) * 31) + this.f2062i) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f2064k) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.m) * 31;
            boolean z = this.n;
            int i3 = z;
            if (z != 0) {
                i3 = 1;
            }
            return i2 + i3;
        }
        return invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.intValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f2055b : invokeV.intValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f2056c : (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f2057d : (String) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f2061h : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "VideoRepresentation(key=" + this.a + ", rank=" + this.f2055b + ", title=" + this.f2056c + ", url=" + this.f2057d + ", downloadUrl=" + this.f2058e + ", airPlayUrl=" + this.f2059f + ", bps=" + this.f2060g + ", width=" + this.f2061h + ", height=" + this.f2062i + ", size=" + this.f2063j + ", moovSize=" + this.f2064k + ", clarityScore=" + this.l + ", prefetchSize=" + this.m + ", frmAlignRepresentation=" + this.n + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
