package c.a.p0.v.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.s.q.c2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<c2> f25272a;

    /* renamed from: b  reason: collision with root package name */
    public List<c2> f25273b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25274c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25275d;

    /* renamed from: e  reason: collision with root package name */
    public int f25276e;

    /* renamed from: f  reason: collision with root package name */
    public int f25277f;

    /* renamed from: g  reason: collision with root package name */
    public int f25278g;

    public b(List<c2> list, boolean z, int i2) {
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
        this.f25276e = 2;
        this.f25277f = 2;
        this.f25278g = 1;
        this.f25275d = z;
        this.f25277f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f25274c) {
                int size = this.f25273b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f25278g;
                }
                int i3 = this.f25278g;
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
            List<c2> list = this.f25272a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f25274c ? i2 - this.f25278g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f25274c) {
                return this.f25278g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<c2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25273b : (List) invokeV.objValue;
    }

    public final List<c2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<c2> list = this.f25272a;
            if (list != null) {
                if (this.f25274c) {
                    if (list.size() > this.f25277f && this.f25272a.size() >= this.f25278g) {
                        arrayList.addAll(this.f25272a.subList(0, this.f25277f));
                        List<c2> list2 = this.f25272a;
                        int i2 = this.f25277f;
                        arrayList.addAll(0, list2.subList(i2 - this.f25278g, i2));
                        arrayList.addAll(this.f25272a.subList(0, this.f25278g));
                    } else {
                        arrayList.addAll(this.f25272a);
                        List<c2> list3 = this.f25272a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f25278g, this.f25272a.size()));
                        arrayList.addAll(this.f25272a.subList(0, this.f25278g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f25272a.size();
                    int i3 = this.f25278g;
                    if (size >= i3) {
                        arrayList.addAll(this.f25272a.subList(0, i3));
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
            this.f25278g = i2;
            j(this.f25272a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f25277f = i2;
            j(this.f25272a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f25276e = i2;
            j(this.f25272a);
        }
    }

    public void j(List<c2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.f25272a = list;
        if (list != null && list.size() >= this.f25276e && list.size() <= this.f25277f) {
            this.f25274c = true;
        } else if (list.size() > this.f25277f && this.f25275d) {
            this.f25274c = true;
        } else {
            this.f25274c = false;
        }
        this.f25273b = f();
    }
}
