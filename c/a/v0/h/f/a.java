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
/* loaded from: classes4.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1406a f30188a;

    /* renamed from: b  reason: collision with root package name */
    public int f30189b;

    /* renamed from: c  reason: collision with root package name */
    public a f30190c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.v0.h.c f30191d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f30192e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f30193f;

    /* renamed from: g  reason: collision with root package name */
    public String f30194g;

    /* renamed from: c.a.v0.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1406a {
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
            if (TextUtils.isEmpty(this.f30194g)) {
                sb = new StringBuilder();
                fileNameWithOutExtention = FileUtils.removeExtention(str);
            } else {
                fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                sb = new StringBuilder();
                sb.append(this.f30194g);
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
            this.f30189b = i2;
        }
    }

    public abstract void d(c.a.v0.h.c cVar);

    public void e(InterfaceC1406a interfaceC1406a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interfaceC1406a) == null) {
            this.f30188a = interfaceC1406a;
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f30190c = aVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f30193f) {
            return;
        }
        this.f30192e = true;
        InterfaceC1406a interfaceC1406a = this.f30188a;
        if (interfaceC1406a != null) {
            interfaceC1406a.d(getClass().getName() + str, this);
        }
    }

    public abstract void h();

    public void i(int i2) {
        InterfaceC1406a interfaceC1406a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (interfaceC1406a = this.f30188a) == null) {
            return;
        }
        interfaceC1406a.c(this.f30189b, i2);
    }

    public boolean j(c.a.v0.h.c cVar) {
        InterceptResult invokeL;
        List<c.a.v0.h.a> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cVar)) == null) {
            if (cVar != null && cVar.c() != null && cVar.c().size() == 1 && cVar.c().get(0).a() != null && (a2 = cVar.c().get(0).a()) != null && a2.size() == 1) {
                c.a.v0.h.a aVar = a2.get(0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30189b : invokeV.intValue;
    }

    public void l(c.a.v0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.f30191d = cVar;
            InterfaceC1406a interfaceC1406a = this.f30188a;
            if (interfaceC1406a != null) {
                interfaceC1406a.c(this.f30189b, 100);
                this.f30188a.b(this);
            }
            a aVar = this.f30190c;
            if (aVar != null) {
                aVar.d(cVar);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f30190c == null : invokeV.booleanValue;
    }

    public c.a.v0.h.c n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30191d : (c.a.v0.h.c) invokeV.objValue;
    }

    public void o() {
        InterfaceC1406a interfaceC1406a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (interfaceC1406a = this.f30188a) == null) {
            return;
        }
        interfaceC1406a.a(this);
    }
}
