package c.a.t0.s.l0.u;

import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f13655b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13656c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13657d;

    /* renamed from: e  reason: collision with root package name */
    public int f13658e;

    /* renamed from: f  reason: collision with root package name */
    public int f13659f;

    /* renamed from: g  reason: collision with root package name */
    public int f13660g;

    public c(List<n> list, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13658e = 2;
        this.f13659f = 2;
        this.f13660g = 1;
        this.a = list;
        this.f13657d = z;
        this.f13659f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f13656c) {
                int size = this.f13655b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f13660g;
                }
                int i3 = this.f13660g;
                return i2 == size - i3 ? i3 : i2;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<n> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f13656c ? i2 - this.f13660g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f13656c) {
                return this.f13660g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13655b : (List) invokeV.objValue;
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> list = this.a;
            if (list != null) {
                if (this.f13656c) {
                    if (list.size() > this.f13659f && this.a.size() >= this.f13660g) {
                        arrayList.addAll(this.a.subList(0, this.f13659f));
                        List<n> list2 = this.a;
                        int i2 = this.f13659f;
                        arrayList.addAll(0, list2.subList(i2 - this.f13660g, i2));
                        arrayList.addAll(this.a.subList(0, this.f13660g));
                    } else {
                        arrayList.addAll(this.a);
                        List<n> list3 = this.a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f13660g, this.a.size()));
                        arrayList.addAll(this.a.subList(0, this.f13660g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.a.size();
                    int i3 = this.f13660g;
                    if (size >= i3) {
                        arrayList.addAll(this.a.subList(0, i3));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f13660g = i2;
            j(this.a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f13659f = i2;
            j(this.a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f13658e = i2;
            j(this.a);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.f13658e && list.size() <= this.f13659f) {
                this.f13656c = true;
            } else if (list.size() > this.f13659f && this.f13657d) {
                this.f13656c = true;
            } else {
                this.f13656c = false;
            }
            this.f13655b = f();
        }
    }
}
