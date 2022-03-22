package c.a.p0.q4.l.a;

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
/* loaded from: classes2.dex */
public class g implements Comparable<g> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17796b;

    /* renamed from: c  reason: collision with root package name */
    public int f17797c;

    public g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17797c = 30;
        this.a = i;
        this.f17796b = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            int i = this.a;
            int i2 = this.f17796b;
            int i3 = i * i2;
            int i4 = gVar.a;
            int i5 = gVar.f17796b;
            return i3 == i4 * i5 ? this.f17797c - gVar.f17797c : (i * i2) - (i4 * i5);
        }
        return invokeL.intValue;
    }

    public CamcorderProfile b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == 720 && this.f17796b == 480) {
                return CamcorderProfile.get(4);
            }
            if (this.a == 1280 && this.f17796b == 720) {
                return CamcorderProfile.get(5);
            }
            if (this.a == 1920 && this.f17796b == 1080) {
                return CamcorderProfile.get(6);
            }
            if (this.a == 3840 && this.f17796b == 2160) {
                return CamcorderProfile.get(8);
            }
            return CamcorderProfile.get(5);
        }
        return (CamcorderProfile) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17797c : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f17796b : invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
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
                return this.a == gVar.a && this.f17796b == gVar.f17796b && this.f17797c == gVar.f17797c;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? g(this, i) : invokeI.booleanValue;
    }

    public boolean g(g gVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar, i)) == null) {
            if (gVar.e() == 720 && gVar.d() == 480) {
                return CamcorderProfile.hasProfile(i, 2002);
            }
            if (gVar.e() == 1280 && gVar.d() == 720) {
                return CamcorderProfile.hasProfile(i, 2003);
            }
            if (gVar.e() == 1920 && gVar.d() == 1080) {
                return CamcorderProfile.hasProfile(i, 2004);
            }
            if (gVar.e() == 3840 && gVar.d() == 2160) {
                return CamcorderProfile.hasProfile(i, 2005);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f17797c = i;
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
            return this.a + "x" + this.f17796b + " " + this.f17797c + "p";
        }
        return (String) invokeV.objValue;
    }

    public g(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17797c = 30;
        this.a = i;
        this.f17796b = i2;
        this.f17797c = i3;
    }
}
