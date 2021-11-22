package b.a.r0.a4;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f15941a;

    /* renamed from: b  reason: collision with root package name */
    public String f15942b;

    /* renamed from: c  reason: collision with root package name */
    public String f15943c;

    /* renamed from: d  reason: collision with root package name */
    public String f15944d;

    /* renamed from: e  reason: collision with root package name */
    public int f15945e;

    /* renamed from: f  reason: collision with root package name */
    public int f15946f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1650225414, "Lb/a/r0/a4/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1650225414, "Lb/a/r0/a4/g;");
        }
    }

    public g(String str, String str2, String str3, String str4, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f15941a = str;
        this.f15942b = str2;
        this.f15943c = str3;
        this.f15944d = str4;
        this.f15945e = i2;
        this.f15946f = i3;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15944d : (String) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15945e : invokeV.intValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15946f : invokeV.intValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f15943c : (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15941a : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof g) {
                    g gVar = (g) obj;
                    return Intrinsics.areEqual(this.f15941a, gVar.f15941a) && Intrinsics.areEqual(this.f15942b, gVar.f15942b) && Intrinsics.areEqual(this.f15943c, gVar.f15943c) && Intrinsics.areEqual(this.f15944d, gVar.f15944d) && this.f15945e == gVar.f15945e && this.f15946f == gVar.f15946f;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f15942b : (String) invokeV.objValue;
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f15944d = str;
        }
    }

    public final void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f15945e = i2;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String str = this.f15941a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f15942b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f15943c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f15944d;
            return ((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.f15945e) * 31) + this.f15946f;
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f15946f = i2;
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f15943c = str;
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f15941a = str;
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f15942b = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return "VideoAdUiData(name=" + this.f15941a + ", portrait=" + this.f15942b + ", description=" + this.f15943c + ", buttonDesc=" + this.f15944d + ", buttonType=" + this.f15945e + ", channel=" + this.f15946f + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ g(String str, String str2, String str3, String str4, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) == 0 ? str3 : "", (i4 & 8) != 0 ? "了解详情" : str4, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g() {
        this("", null, null, null, 0, 0, 62, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), (DefaultConstructorMarker) objArr[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
