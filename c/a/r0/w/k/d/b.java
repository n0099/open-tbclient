package c.a.r0.w.k.d;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.q.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d2> f26281a;

    /* renamed from: b  reason: collision with root package name */
    public List<d2> f26282b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f26283c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f26284d;

    /* renamed from: e  reason: collision with root package name */
    public int f26285e;

    /* renamed from: f  reason: collision with root package name */
    public int f26286f;

    /* renamed from: g  reason: collision with root package name */
    public int f26287g;

    public b(List<d2> list, boolean z, int i2) {
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
        this.f26285e = 2;
        this.f26286f = 2;
        this.f26287g = 1;
        this.f26284d = z;
        this.f26286f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f26283c) {
                int size = this.f26282b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f26287g;
                }
                int i3 = this.f26287g;
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
            List<d2> list = this.f26281a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f26283c ? i2 - this.f26287g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f26283c) {
                return this.f26287g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<d2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f26282b : (List) invokeV.objValue;
    }

    public final List<d2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<d2> list = this.f26281a;
            if (list != null) {
                if (this.f26283c) {
                    if (list.size() > this.f26286f && this.f26281a.size() >= this.f26287g) {
                        arrayList.addAll(this.f26281a.subList(0, this.f26286f));
                        List<d2> list2 = this.f26281a;
                        int i2 = this.f26286f;
                        arrayList.addAll(0, list2.subList(i2 - this.f26287g, i2));
                        arrayList.addAll(this.f26281a.subList(0, this.f26287g));
                    } else {
                        arrayList.addAll(this.f26281a);
                        List<d2> list3 = this.f26281a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f26287g, this.f26281a.size()));
                        arrayList.addAll(this.f26281a.subList(0, this.f26287g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f26281a.size();
                    int i3 = this.f26287g;
                    if (size >= i3) {
                        arrayList.addAll(this.f26281a.subList(0, i3));
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
            this.f26287g = i2;
            j(this.f26281a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f26286f = i2;
            j(this.f26281a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f26285e = i2;
            j(this.f26281a);
        }
    }

    public void j(List<d2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.f26281a = list;
        if (list != null && list.size() >= this.f26285e && list.size() <= this.f26286f) {
            this.f26283c = true;
        } else if (list.size() > this.f26286f && this.f26284d) {
            this.f26283c = true;
        } else {
            this.f26283c = false;
        }
        this.f26282b = f();
    }
}
