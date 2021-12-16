package c.a.d.f.d;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class d<T> implements k<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final e f2304b;

    public d(e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2304b = eVar;
        this.a = z;
    }

    @Override // c.a.d.f.d.k
    public T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            g<T> k2 = k(str, str2);
            if (k2 == null) {
                return null;
            }
            return k2.f2307b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // c.a.d.f.d.k
    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2304b : (e) invokeV.objValue;
    }

    @Override // c.a.d.f.d.k
    public void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            l(h(str, str2));
        }
    }

    @Override // c.a.d.f.d.k
    public l.b<T> e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            g<T> k2 = k(str, str2);
            if (k2 == null) {
                return null;
            }
            l.b<T> bVar = new l.b<>();
            bVar.a = str2;
            bVar.f2322b = k2.f2307b;
            long j2 = k2.f2311f;
            bVar.f2323c = k2.f2309d;
            return bVar;
        }
        return (l.b) invokeLL.objValue;
    }

    @Override // c.a.d.f.d.k
    public void f(String str, String str2, T t, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, t, Long.valueOf(j2)}) == null) {
            g<T> gVar = new g<>();
            gVar.a = h(str, str2);
            gVar.f2308c = str;
            gVar.f2311f = j2;
            gVar.f2307b = t;
            gVar.f2310e = System.currentTimeMillis();
            gVar.f2309d = System.currentTimeMillis();
            j(gVar);
        }
    }

    public String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (this.a) {
                return str + "@" + str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public abstract g<T> i(String str);

    public abstract void j(g<T> gVar);

    public g<T> k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            String h2 = h(str, str2);
            g<T> i2 = i(h2);
            if (i2 == null) {
                BdLog.isDebugMode();
                return null;
            } else if (i2.f2311f < System.currentTimeMillis()) {
                m(h2);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.f2304b.a()) {
                    i2.f2310e = System.currentTimeMillis();
                    j(i2);
                }
                BdLog.isDebugMode();
                return i2;
            }
        }
        return (g) invokeLL.objValue;
    }

    public abstract void l(String str);

    public abstract void m(String str);
}
