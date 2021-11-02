package b.a.q0.s.g0.u;

import androidx.core.view.InputDeviceCompat;
import b.a.e.l.e.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<n> f13084a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f13085b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13086c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13087d;

    /* renamed from: e  reason: collision with root package name */
    public int f13088e;

    /* renamed from: f  reason: collision with root package name */
    public int f13089f;

    /* renamed from: g  reason: collision with root package name */
    public int f13090g;

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
        this.f13088e = 2;
        this.f13089f = 2;
        this.f13090g = 1;
        this.f13084a = list;
        this.f13087d = z;
        this.f13089f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f13086c) {
                int size = this.f13085b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f13090g;
                }
                int i3 = this.f13090g;
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
            List<n> list = this.f13084a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f13086c ? i2 - this.f13090g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f13086c) {
                return this.f13090g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13085b : (List) invokeV.objValue;
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> list = this.f13084a;
            if (list != null) {
                if (this.f13086c) {
                    if (list.size() > this.f13089f && this.f13084a.size() >= this.f13090g) {
                        arrayList.addAll(this.f13084a.subList(0, this.f13089f));
                        List<n> list2 = this.f13084a;
                        int i2 = this.f13089f;
                        arrayList.addAll(0, list2.subList(i2 - this.f13090g, i2));
                        arrayList.addAll(this.f13084a.subList(0, this.f13090g));
                    } else {
                        arrayList.addAll(this.f13084a);
                        List<n> list3 = this.f13084a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f13090g, this.f13084a.size()));
                        arrayList.addAll(this.f13084a.subList(0, this.f13090g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f13084a.size();
                    int i3 = this.f13090g;
                    if (size >= i3) {
                        arrayList.addAll(this.f13084a.subList(0, i3));
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
            this.f13090g = i2;
            j(this.f13084a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f13089f = i2;
            j(this.f13084a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f13088e = i2;
            j(this.f13084a);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.f13088e && list.size() <= this.f13089f) {
                this.f13086c = true;
            } else if (list.size() > this.f13089f && this.f13087d) {
                this.f13086c = true;
            } else {
                this.f13086c = false;
            }
            this.f13085b = f();
        }
    }
}
