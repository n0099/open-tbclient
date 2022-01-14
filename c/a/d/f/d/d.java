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
    public final e f2710b;

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
        this.f2710b = eVar;
        this.a = z;
    }

    @Override // c.a.d.f.d.k
    public T a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            g<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            return k.f2713b;
        }
        return (T) invokeLL.objValue;
    }

    @Override // c.a.d.f.d.k
    public e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f2710b : (e) invokeV.objValue;
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
            g<T> k = k(str, str2);
            if (k == null) {
                return null;
            }
            l.b<T> bVar = new l.b<>();
            bVar.a = str2;
            bVar.f2728b = k.f2713b;
            long j2 = k.f2717f;
            bVar.f2729c = k.f2715d;
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
            gVar.f2714c = str;
            gVar.f2717f = j2;
            gVar.f2713b = t;
            gVar.f2716e = System.currentTimeMillis();
            gVar.f2715d = System.currentTimeMillis();
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
            } else if (i2.f2717f < System.currentTimeMillis()) {
                m(h2);
                BdLog.isDebugMode();
                return null;
            } else {
                if (this.f2710b.a()) {
                    i2.f2716e = System.currentTimeMillis();
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
