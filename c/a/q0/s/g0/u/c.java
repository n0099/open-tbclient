package c.a.q0.s.g0.u;

import androidx.core.view.InputDeviceCompat;
import c.a.d.m.e.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n> a;

    /* renamed from: b  reason: collision with root package name */
    public List<n> f12740b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12741c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12742d;

    /* renamed from: e  reason: collision with root package name */
    public int f12743e;

    /* renamed from: f  reason: collision with root package name */
    public int f12744f;

    /* renamed from: g  reason: collision with root package name */
    public int f12745g;

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
        this.f12743e = 2;
        this.f12744f = 2;
        this.f12745g = 1;
        this.a = list;
        this.f12742d = z;
        this.f12744f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f12741c) {
                int size = this.f12740b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f12745g;
                }
                int i3 = this.f12745g;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f12741c ? i2 - this.f12745g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f12741c) {
                return this.f12745g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f12740b : (List) invokeV.objValue;
    }

    public final List<n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<n> list = this.a;
            if (list != null) {
                if (this.f12741c) {
                    if (list.size() > this.f12744f && this.a.size() >= this.f12745g) {
                        arrayList.addAll(this.a.subList(0, this.f12744f));
                        List<n> list2 = this.a;
                        int i2 = this.f12744f;
                        arrayList.addAll(0, list2.subList(i2 - this.f12745g, i2));
                        arrayList.addAll(this.a.subList(0, this.f12745g));
                    } else {
                        arrayList.addAll(this.a);
                        List<n> list3 = this.a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f12745g, this.a.size()));
                        arrayList.addAll(this.a.subList(0, this.f12745g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.a.size();
                    int i3 = this.f12745g;
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
            this.f12745g = i2;
            j(this.a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f12744f = i2;
            j(this.a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f12743e = i2;
            j(this.a);
        }
    }

    public void j(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            if (list != null && list.size() >= this.f12743e && list.size() <= this.f12744f) {
                this.f12741c = true;
            } else if (list.size() > this.f12744f && this.f12742d) {
                this.f12741c = true;
            } else {
                this.f12741c = false;
            }
            this.f12740b = f();
        }
    }
}
