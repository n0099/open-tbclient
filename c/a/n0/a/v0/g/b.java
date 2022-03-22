package c.a.n0.a.v0.g;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f6615e;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.p2.g1.c<b> f6616b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0486b> f6617c;

    /* renamed from: d  reason: collision with root package name */
    public String f6618d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.n0.a.v0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0486b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<String> a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f6619b;

        /* renamed from: c  reason: collision with root package name */
        public String f6620c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f6621d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6622e;

        public /* synthetic */ C0486b(b bVar, a aVar) {
            this(bVar);
        }

        public synchronized C0486b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                synchronized (this) {
                    List<String> list = this.a;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    list.add(str);
                }
                return this;
            }
            return (C0486b) invokeL.objValue;
        }

        public C0486b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f6620c = str;
                return this;
            }
            return (C0486b) invokeL.objValue;
        }

        public synchronized C0486b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    d(this.f6621d.size());
                }
                return this;
            }
            return (C0486b) invokeV.objValue;
        }

        public synchronized C0486b d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                synchronized (this) {
                    if (i < 1) {
                        i = 1;
                    }
                    if (i > this.f6621d.size()) {
                        i = this.f6621d.size();
                    }
                    for (int i2 = 0; i2 < i; i2++) {
                        b bVar = this.f6622e;
                        bVar.e("[Trace]==> " + this.f6621d.get(i2).toString());
                    }
                }
                return this;
            }
            return (C0486b) invokeI.objValue;
        }

        public synchronized C0486b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    d(1);
                }
                return this;
            }
            return (C0486b) invokeV.objValue;
        }

        public C0486b(b bVar) {
            StackTraceElement[] stackTrace;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6622e = bVar;
            this.a = new ArrayList();
            this.f6619b = new ArrayList();
            this.f6621d = new ArrayList();
            int i3 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i3++;
                if (i3 > 2 && !stackTraceElement.getClassName().startsWith(bVar.f6618d)) {
                    this.f6621d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.p2.g1.c<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && b.f6615e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && b.f6615e) {
                for (C0486b c0486b : bVar.f6617c) {
                    for (String str : c0486b.a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0486b.f6620c) ? h2 : c0486b.f6620c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(368852897, "Lc/a/n0/a/v0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(368852897, "Lc/a/n0/a/v0/g/b;");
                return;
            }
        }
        f6615e = c.a.n0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6617c = new ArrayList();
        this.f6618d = b.class.getPackage().getName();
    }

    public synchronized C0486b d() {
        InterceptResult invokeV;
        C0486b c0486b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c0486b = new C0486b(this, null);
                this.f6617c.add(c0486b);
            }
            return c0486b;
        }
        return (C0486b) invokeV.objValue;
    }

    public synchronized C0486b e(String str) {
        InterceptResult invokeL;
        C0486b d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                d2 = d();
                d2.a(str);
            }
            return d2;
        }
        return (C0486b) invokeL.objValue;
    }

    public synchronized C0486b f(String str, String str2) {
        InterceptResult invokeLL;
        C0486b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            synchronized (this) {
                e2 = e(str2);
                e2.b(str);
            }
            return e2;
        }
        return (C0486b) invokeLL.objValue;
    }

    public b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public synchronized List<C0486b> i() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f6617c);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                k(this.f6616b);
            }
            return this;
        }
        return (b) invokeV.objValue;
    }

    public synchronized b k(c.a.n0.a.p2.g1.c<b> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            synchronized (this) {
                if (cVar == null) {
                    try {
                        cVar = new c(this, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                cVar.onCallback(this);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b l(c.a.n0.a.p2.g1.c<b> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            this.f6616b = cVar;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
