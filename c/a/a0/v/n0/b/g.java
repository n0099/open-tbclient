package c.a.a0.v.n0.b;

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
    public final int f1824b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1825c;

    /* renamed from: d  reason: collision with root package name */
    public final String f1826d;

    /* renamed from: e  reason: collision with root package name */
    public final String f1827e;

    /* renamed from: f  reason: collision with root package name */
    public final String f1828f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1829g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1830h;
    public final int i;
    public final double j;
    public final int k;
    public final double l;
    public final int m;
    public final boolean n;

    public g(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, int i4, double d2, int i5, double d3, int i6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Double.valueOf(d2), Integer.valueOf(i5), Double.valueOf(d3), Integer.valueOf(i6), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f1824b = i;
        this.f1825c = str2;
        this.f1826d = str3;
        this.f1827e = str4;
        this.f1828f = str5;
        this.f1829g = i2;
        this.f1830h = i3;
        this.i = i4;
        this.j = d2;
        this.k = i5;
        this.l = d3;
        this.m = i6;
        this.n = z;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f1828f : (String) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1829g : invokeV.intValue;
    }

    public final double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.l : invokeV.doubleValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1827e : (String) invokeV.objValue;
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
                    return Intrinsics.areEqual(this.a, gVar.a) && this.f1824b == gVar.f1824b && Intrinsics.areEqual(this.f1825c, gVar.f1825c) && Intrinsics.areEqual(this.f1826d, gVar.f1826d) && Intrinsics.areEqual(this.f1827e, gVar.f1827e) && Intrinsics.areEqual(this.f1828f, gVar.f1828f) && this.f1829g == gVar.f1829g && this.f1830h == gVar.f1830h && this.i == gVar.i && Double.compare(this.j, gVar.j) == 0 && this.k == gVar.k && Double.compare(this.l, gVar.l) == 0 && this.m == gVar.m && this.n == gVar.n;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v14, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.a;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.f1824b) * 31;
            String str2 = this.f1825c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f1826d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f1827e;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.f1828f;
            int hashCode5 = str5 != null ? str5.hashCode() : 0;
            long doubleToLongBits = Double.doubleToLongBits(this.j);
            long doubleToLongBits2 = Double.doubleToLongBits(this.l);
            int i = (((((((((((((((hashCode4 + hashCode5) * 31) + this.f1829g) * 31) + this.f1830h) * 31) + this.i) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.k) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.m) * 31;
            boolean z = this.n;
            int i2 = z;
            if (z != 0) {
                i2 = 1;
            }
            return i + i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f1824b : invokeV.intValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1825c : (String) invokeV.objValue;
    }

    public final String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1826d : (String) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f1830h : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "VideoRepresentation(key=" + this.a + ", rank=" + this.f1824b + ", title=" + this.f1825c + ", url=" + this.f1826d + ", downloadUrl=" + this.f1827e + ", airPlayUrl=" + this.f1828f + ", bps=" + this.f1829g + ", width=" + this.f1830h + ", height=" + this.i + ", size=" + this.j + ", moovSize=" + this.k + ", clarityScore=" + this.l + ", prefetchSize=" + this.m + ", frmAlignRepresentation=" + this.n + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
