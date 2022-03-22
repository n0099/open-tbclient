package c.a.v0.h.f;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC1599a a;

    /* renamed from: b  reason: collision with root package name */
    public int f21565b;

    /* renamed from: c  reason: collision with root package name */
    public a f21566c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.v0.h.c f21567d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f21568e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f21569f;

    /* renamed from: g  reason: collision with root package name */
    public String f21570g;

    /* renamed from: c.a.v0.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1599a {
        void a(a aVar);

        void b(a aVar);

        void c(int i, int i2);

        void d(String str, a aVar);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        String fileNameWithOutExtention;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str2 == null) {
                str2 = "";
            }
            if (TextUtils.isEmpty(this.f21570g)) {
                sb = new StringBuilder();
                fileNameWithOutExtention = FileUtils.removeExtention(str);
            } else {
                fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                sb = new StringBuilder();
                sb.append(this.f21570g);
            }
            sb.append(fileNameWithOutExtention);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public abstract void b();

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.f21565b = i;
        }
    }

    public abstract void d(c.a.v0.h.c cVar);

    public void e(InterfaceC1599a interfaceC1599a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1599a) == null) {
            this.a = interfaceC1599a;
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f21566c = aVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f21569f) {
            return;
        }
        this.f21568e = true;
        InterfaceC1599a interfaceC1599a = this.a;
        if (interfaceC1599a != null) {
            interfaceC1599a.d(getClass().getName() + str, this);
        }
    }

    public abstract void h();

    public void i(int i) {
        InterfaceC1599a interfaceC1599a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (interfaceC1599a = this.a) == null) {
            return;
        }
        interfaceC1599a.c(this.f21565b, i);
    }

    public boolean j(c.a.v0.h.c cVar) {
        InterceptResult invokeL;
        List<c.a.v0.h.a> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            if (cVar != null && cVar.c() != null && cVar.c().size() == 1 && cVar.c().get(0).a() != null && (a = cVar.c().get(0).a()) != null && a.size() == 1) {
                c.a.v0.h.a aVar = a.get(0);
                if (aVar.b() != null && !aVar.b().isNeedEdit()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f21565b : invokeV.intValue;
    }

    public void l(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f21567d = cVar;
            InterfaceC1599a interfaceC1599a = this.a;
            if (interfaceC1599a != null) {
                interfaceC1599a.c(this.f21565b, 100);
                this.a.b(this);
            }
            a aVar = this.f21566c;
            if (aVar != null) {
                aVar.d(cVar);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f21566c == null : invokeV.booleanValue;
    }

    public c.a.v0.h.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f21567d : (c.a.v0.h.c) invokeV.objValue;
    }

    public void o() {
        InterfaceC1599a interfaceC1599a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (interfaceC1599a = this.a) == null) {
            return;
        }
        interfaceC1599a.a(this);
    }
}
