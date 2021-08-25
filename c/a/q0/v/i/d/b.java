package c.a.q0.v.i.d;

import androidx.core.view.InputDeviceCompat;
import c.a.p0.s.q.c2;
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
    public List<c2> f25605a;

    /* renamed from: b  reason: collision with root package name */
    public List<c2> f25606b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f25607c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f25608d;

    /* renamed from: e  reason: collision with root package name */
    public int f25609e;

    /* renamed from: f  reason: collision with root package name */
    public int f25610f;

    /* renamed from: g  reason: collision with root package name */
    public int f25611g;

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
        this.f25609e = 2;
        this.f25610f = 2;
        this.f25611g = 1;
        this.f25608d = z;
        this.f25610f = i2;
        j(list);
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (this.f25607c) {
                int size = this.f25606b.size();
                if (i2 == 0) {
                    return (size - 1) - this.f25611g;
                }
                int i3 = this.f25611g;
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
            List<c2> list = this.f25605a;
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f25607c ? i2 - this.f25611g : i2 : invokeI.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f25607c) {
                return this.f25611g;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public List<c2> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f25606b : (List) invokeV.objValue;
    }

    public final List<c2> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<c2> list = this.f25605a;
            if (list != null) {
                if (this.f25607c) {
                    if (list.size() > this.f25610f && this.f25605a.size() >= this.f25611g) {
                        arrayList.addAll(this.f25605a.subList(0, this.f25610f));
                        List<c2> list2 = this.f25605a;
                        int i2 = this.f25610f;
                        arrayList.addAll(0, list2.subList(i2 - this.f25611g, i2));
                        arrayList.addAll(this.f25605a.subList(0, this.f25611g));
                    } else {
                        arrayList.addAll(this.f25605a);
                        List<c2> list3 = this.f25605a;
                        arrayList.addAll(0, list3.subList(list3.size() - this.f25611g, this.f25605a.size()));
                        arrayList.addAll(this.f25605a.subList(0, this.f25611g));
                    }
                } else if (list != null && list.size() > 0) {
                    int size = this.f25605a.size();
                    int i3 = this.f25611g;
                    if (size >= i3) {
                        arrayList.addAll(this.f25605a.subList(0, i3));
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
            this.f25611g = i2;
            j(this.f25605a);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f25610f = i2;
            j(this.f25605a);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f25609e = i2;
            j(this.f25605a);
        }
    }

    public void j(List<c2> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null) {
            return;
        }
        this.f25605a = list;
        if (list != null && list.size() >= this.f25609e && list.size() <= this.f25610f) {
            this.f25607c = true;
        } else if (list.size() > this.f25610f && this.f25608d) {
            this.f25607c = true;
        } else {
            this.f25607c = false;
        }
        this.f25606b = f();
    }
}
