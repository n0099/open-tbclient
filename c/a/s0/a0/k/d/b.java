package c.a.s0.a0.k.d;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.r.d2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<d2> a;

    /* renamed from: b  reason: collision with root package name */
    public List<d2> f14755b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14756c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14757d;

    /* renamed from: e  reason: collision with root package name */
    public int f14758e;

    /* renamed from: f  reason: collision with root package name */
    public int f14759f;

    /* renamed from: g  reason: collision with root package name */
    public int f14760g;

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
        this.f14758e = 2;
        this.f14759f = 2;
        this.f14760g = 1;
        this.f14757d = z;
        this.f14759f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f14756c) {
                int size = this.f14755b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f14760g;
                }
                int i3 = this.f14760g;
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
            List<d2> list = this.a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f14756c ? i2 - this.f14760g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f14756c) {
                return this.f14760g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<d2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14755b : (List) invokeV.objValue;
    }

    public final List<d2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<d2> list = this.a;
            if (list != null) {
                if (this.f14756c) {
                    if (list.size() > this.f14759f && this.a.size() >= this.f14760g) {
                        arrayList.addAll(this.a.subList(0, this.f14759f));
                        List<d2> list2 = this.a;
                        int i2 = this.f14759f;
                        arrayList.addAll(0, list2.subList(i2 - this.f14760g, i2));
                        arrayList.addAll(this.a.subList(0, this.f14760g));
                    } else {
                        arrayList.addAll(this.a);
                        List<d2> list3 = this.a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f14760g, this.a.size()));
                        arrayList.addAll(this.a.subList(0, this.f14760g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.a.size();
                    int i3 = this.f14760g;
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
            this.f14760g = i2;
            j(this.a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f14759f = i2;
            j(this.a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f14758e = i2;
            j(this.a);
        }
    }

    public void j(List<d2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.a = list;
        if (list != null && list.size() >= this.f14758e && list.size() <= this.f14759f) {
            this.f14756c = true;
        } else if (list.size() > this.f14759f && this.f14757d) {
            this.f14756c = true;
        } else {
            this.f14756c = false;
        }
        this.f14755b = f();
    }
}
