package c.a.o0.r.l0.u;

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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f10713b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10714c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10715d;

    /* renamed from: e  reason: collision with root package name */
    public int f10716e;

    /* renamed from: f  reason: collision with root package name */
    public int f10717f;

    /* renamed from: g  reason: collision with root package name */
    public int f10718g;

    public c(List<n> list, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10716e = 2;
        this.f10717f = 2;
        this.f10718g = 1;
        this.a = list;
        this.f10715d = z;
        this.f10717f = i;
        j(list);
    }

    public int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.f10714c) {
                int size = this.f10713b.size();
                if (i == 0) {
                    return (size - 1) - this.f10718g;
                }
                int i2 = this.f10718g;
                return i == size - i2 ? i2 : i;
            }
            return i;
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

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? this.f10714c ? i - this.f10718g : i : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f10714c) {
                return this.f10718g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10713b : (List) invokeV.objValue;
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> list = this.a;
            if (list != null) {
                if (this.f10714c) {
                    if (list.size() > this.f10717f && this.a.size() >= this.f10718g) {
                        arrayList.addAll(this.a.subList(0, this.f10717f));
                        List<n> list2 = this.a;
                        int i = this.f10717f;
                        arrayList.addAll(0, list2.subList(i - this.f10718g, i));
                        arrayList.addAll(this.a.subList(0, this.f10718g));
                    } else {
                        arrayList.addAll(this.a);
                        List<n> list3 = this.a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f10718g, this.a.size()));
                        arrayList.addAll(this.a.subList(0, this.f10718g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.a.size();
                    int i2 = this.f10718g;
                    if (size >= i2) {
                        arrayList.addAll(this.a.subList(0, i2));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.f10718g = i;
            j(this.a);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.f10717f = i;
            j(this.a);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f10716e = i;
            j(this.a);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.f10716e && list.size() <= this.f10717f) {
                this.f10714c = true;
            } else if (list.size() > this.f10717f && this.f10715d) {
                this.f10714c = true;
            } else {
                this.f10714c = false;
            }
            this.f10713b = f();
        }
    }
}
