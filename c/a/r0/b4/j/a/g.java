package c.a.r0.b4.j.a;

import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
/* loaded from: classes3.dex */
public class g implements Comparable<g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f16267e;

    /* renamed from: f  reason: collision with root package name */
    public final int f16268f;

    /* renamed from: g  reason: collision with root package name */
    public int f16269g;

    public g(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16269g = 30;
        this.f16267e = i2;
        this.f16268f = i3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            int i2 = this.f16267e;
            int i3 = this.f16268f;
            int i4 = i2 * i3;
            int i5 = gVar.f16267e;
            int i6 = gVar.f16268f;
            return i4 == i5 * i6 ? this.f16269g - gVar.f16269g : (i2 * i3) - (i5 * i6);
        }
        return invokeL.intValue;
    }

    public CamcorderProfile b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f16267e == 720 && this.f16268f == 480) {
                return CamcorderProfile.get(4);
            }
            if (this.f16267e == 1280 && this.f16268f == 720) {
                return CamcorderProfile.get(5);
            }
            if (this.f16267e == 1920 && this.f16268f == 1080) {
                return CamcorderProfile.get(6);
            }
            if (this.f16267e == 3840 && this.f16268f == 2160) {
                return CamcorderProfile.get(8);
            }
            return CamcorderProfile.get(5);
        }
        return (CamcorderProfile) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16269g : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f16268f : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16267e : invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (obj instanceof g) {
                g gVar = (g) obj;
                return this.f16267e == gVar.f16267e && this.f16268f == gVar.f16268f && this.f16269g == gVar.f16269g;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? g(this, i2) : invokeI.booleanValue;
    }

    public boolean g(g gVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar, i2)) == null) {
            if (gVar.e() == 720 && gVar.d() == 480) {
                return CamcorderProfile.hasProfile(i2, 2002);
            }
            if (gVar.e() == 1280 && gVar.d() == 720) {
                return CamcorderProfile.hasProfile(i2, 2003);
            }
            if (gVar.e() == 1920 && gVar.d() == 1080) {
                return CamcorderProfile.hasProfile(i2, 2004);
            }
            if (gVar.e() == 3840 && gVar.d() == 2160) {
                return CamcorderProfile.hasProfile(i2, 2005);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f16269g = i2;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Objects.hash(Integer.valueOf(e()), Integer.valueOf(d()), Integer.valueOf(c())) : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f16267e + "x" + this.f16268f + " " + this.f16269g + "p";
        }
        return (String) invokeV.objValue;
    }

    public g(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f16269g = 30;
        this.f16267e = i2;
        this.f16268f = i3;
        this.f16269g = i4;
    }
}
