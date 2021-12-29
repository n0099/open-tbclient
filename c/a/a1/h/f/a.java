package c.a.a1.h.f;

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
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterfaceC0011a a;

    /* renamed from: b  reason: collision with root package name */
    public int f1151b;

    /* renamed from: c  reason: collision with root package name */
    public a f1152c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a1.h.c f1153d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f1154e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f1155f;

    /* renamed from: g  reason: collision with root package name */
    public String f1156g;

    /* renamed from: c.a.a1.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0011a {
        void a(a aVar);

        void b(a aVar);

        void c(int i2, int i3);

        void d(String str, a aVar);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (TextUtils.isEmpty(this.f1156g)) {
                sb = new StringBuilder();
                fileNameWithOutExtention = FileUtils.removeExtention(str);
            } else {
                fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                sb = new StringBuilder();
                sb.append(this.f1156g);
            }
            sb.append(fileNameWithOutExtention);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public abstract void b();

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f1151b = i2;
        }
    }

    public abstract void d(c.a.a1.h.c cVar);

    public void e(InterfaceC0011a interfaceC0011a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC0011a) == null) {
            this.a = interfaceC0011a;
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f1152c = aVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f1155f) {
            return;
        }
        this.f1154e = true;
        InterfaceC0011a interfaceC0011a = this.a;
        if (interfaceC0011a != null) {
            interfaceC0011a.d(getClass().getName() + str, this);
        }
    }

    public abstract void h();

    public void i(int i2) {
        InterfaceC0011a interfaceC0011a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (interfaceC0011a = this.a) == null) {
            return;
        }
        interfaceC0011a.c(this.f1151b, i2);
    }

    public boolean j(c.a.a1.h.c cVar) {
        InterceptResult invokeL;
        List<c.a.a1.h.a> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            if (cVar != null && cVar.c() != null && cVar.c().size() == 1 && cVar.c().get(0).a() != null && (a = cVar.c().get(0).a()) != null && a.size() == 1) {
                c.a.a1.h.a aVar = a.get(0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f1151b : invokeV.intValue;
    }

    public void l(c.a.a1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f1153d = cVar;
            InterfaceC0011a interfaceC0011a = this.a;
            if (interfaceC0011a != null) {
                interfaceC0011a.c(this.f1151b, 100);
                this.a.b(this);
            }
            a aVar = this.f1152c;
            if (aVar != null) {
                aVar.d(cVar);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f1152c == null : invokeV.booleanValue;
    }

    public c.a.a1.h.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f1153d : (c.a.a1.h.c) invokeV.objValue;
    }

    public void o() {
        InterfaceC0011a interfaceC0011a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (interfaceC0011a = this.a) == null) {
            return;
        }
        interfaceC0011a.a(this);
    }
}
