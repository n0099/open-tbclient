package c.d.b;

import androidx.core.view.InputDeviceCompat;
import c.d.b.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.apache.http.client.methods.HttpDelete;
/* loaded from: classes9.dex */
public final class z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final s a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28265b;

    /* renamed from: c  reason: collision with root package name */
    public final r f28266c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final a0 f28267d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<Class<?>, Object> f28268e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public volatile d f28269f;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public s a;

        /* renamed from: b  reason: collision with root package name */
        public String f28270b;

        /* renamed from: c  reason: collision with root package name */
        public r.a f28271c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public a0 f28272d;

        /* renamed from: e  reason: collision with root package name */
        public Map<Class<?>, Object> f28273e;

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
                    return;
                }
            }
            this.f28273e = Collections.emptyMap();
            this.f28270b = "GET";
            this.f28271c = new r.a();
        }

        public a a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                this.f28271c.a(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public z b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a != null) {
                    return new z(this);
                }
                throw new IllegalStateException("url == null");
            }
            return (z) invokeV.objValue;
        }

        public a c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
                this.f28271c.g(str, str2);
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a d(r rVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rVar)) == null) {
                this.f28271c = rVar.f();
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a delete(@Nullable a0 a0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a0Var)) == null) {
                e(HttpDelete.METHOD_NAME, a0Var);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str, @Nullable a0 a0Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, a0Var)) == null) {
                if (str != null) {
                    if (str.length() != 0) {
                        if (a0Var != null && !c.d.b.e0.i.f.b(str)) {
                            throw new IllegalArgumentException("method " + str + " must not have a request body.");
                        } else if (a0Var == null && c.d.b.e0.i.f.e(str)) {
                            throw new IllegalArgumentException("method " + str + " must have a request body.");
                        } else {
                            this.f28270b = str;
                            this.f28272d = a0Var;
                            return this;
                        }
                    }
                    throw new IllegalArgumentException("method.length() == 0");
                }
                throw new NullPointerException("method == null");
            }
            return (a) invokeLL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f28271c.f(str);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(s sVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar)) == null) {
                if (sVar != null) {
                    this.a = sVar;
                    return this;
                }
                throw new NullPointerException("url == null");
            }
            return (a) invokeL.objValue;
        }

        public a delete() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? delete(c.d.b.e0.e.f27901d) : (a) invokeV.objValue;
        }

        public a(z zVar) {
            Map<Class<?>, Object> linkedHashMap;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f28273e = Collections.emptyMap();
            this.a = zVar.a;
            this.f28270b = zVar.f28265b;
            this.f28272d = zVar.f28267d;
            if (zVar.f28268e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(zVar.f28268e);
            }
            this.f28273e = linkedHashMap;
            this.f28271c = zVar.f28266c.f();
        }
    }

    public z(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar.a;
        this.f28265b = aVar.f28270b;
        this.f28266c = aVar.f28271c.d();
        this.f28267d = aVar.f28272d;
        this.f28268e = c.d.b.e0.e.u(aVar.f28273e);
    }

    @Nullable
    public a0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28267d : (a0) invokeV.objValue;
    }

    public d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f28269f;
            if (dVar != null) {
                return dVar;
            }
            d k = d.k(this.f28266c);
            this.f28269f = k;
            return k;
        }
        return (d) invokeV.objValue;
    }

    @Nullable
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f28266c.c(str) : (String) invokeL.objValue;
    }

    public r d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f28266c : (r) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.m() : invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f28265b : (String) invokeV.objValue;
    }

    public a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new a(this) : (a) invokeV.objValue;
    }

    public s h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (s) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "Request{method=" + this.f28265b + ", url=" + this.a + ", tags=" + this.f28268e + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
