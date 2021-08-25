package c.a.e.e.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f2245a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f2246b;

    /* renamed from: c  reason: collision with root package name */
    public int f2247c;

    /* renamed from: d  reason: collision with root package name */
    public String f2248d;

    /* renamed from: e  reason: collision with root package name */
    public a f2249e;

    /* renamed from: f  reason: collision with root package name */
    public int f2250f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f2251g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2252h;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2245a = 0;
        this.f2246b = null;
        this.f2247c = 0;
        this.f2248d = null;
        this.f2249e = null;
        this.f2250f = 0;
        this.f2251g = null;
        this.f2252h = false;
        if (str != null) {
            this.f2248d = str;
            this.f2249e = aVar;
            this.f2250f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f2249e) == null) {
            return;
        }
        aVar.a(this.f2248d, i2, z);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2250f : invokeV.intValue;
    }

    public String[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2246b : (String[]) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f2245a : invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f2248d : (String) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2247c : invokeV.intValue;
    }

    public String[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f2251g : (String[]) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f2252h : invokeV.booleanValue;
    }

    public void i(int i2, String[] strArr, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), strArr, Integer.valueOf(i3)}) == null) {
            this.f2245a = i2;
            this.f2246b = strArr;
            this.f2247c = i3;
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f2252h = z;
        }
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strArr) == null) {
            this.f2251g = strArr;
        }
    }
}
