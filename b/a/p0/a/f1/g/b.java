package b.a.p0.a.f1.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
    public static final boolean f4844e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f4845a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.z2.g1.c<b> f4846b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0171b> f4847c;

    /* renamed from: d  reason: collision with root package name */
    public String f4848d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: b.a.p0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0171b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f4849a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f4850b;

        /* renamed from: c  reason: collision with root package name */
        public String f4851c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f4852d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4853e;

        public /* synthetic */ C0171b(b bVar, a aVar) {
            this(bVar);
        }

        public synchronized C0171b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                synchronized (this) {
                    List<String> list = this.f4849a;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    list.add(str);
                }
                return this;
            }
            return (C0171b) invokeL.objValue;
        }

        public C0171b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f4851c = str;
                return this;
            }
            return (C0171b) invokeL.objValue;
        }

        public synchronized C0171b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    d(this.f4852d.size());
                }
                return this;
            }
            return (C0171b) invokeV.objValue;
        }

        public synchronized C0171b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                synchronized (this) {
                    if (i2 < 1) {
                        i2 = 1;
                    }
                    if (i2 > this.f4852d.size()) {
                        i2 = this.f4852d.size();
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        b bVar = this.f4853e;
                        bVar.e("[Trace]==> " + this.f4852d.get(i3).toString());
                    }
                }
                return this;
            }
            return (C0171b) invokeI.objValue;
        }

        public synchronized C0171b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    d(1);
                }
                return this;
            }
            return (C0171b) invokeV.objValue;
        }

        public C0171b(b bVar) {
            StackTraceElement[] stackTrace;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4853e = bVar;
            this.f4849a = new ArrayList();
            this.f4850b = new ArrayList();
            this.f4852d = new ArrayList();
            int i4 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i4++;
                if (i4 > 2 && !stackTraceElement.getClassName().startsWith(bVar.f4848d)) {
                    this.f4852d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.z2.g1.c<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                boolean unused = b.f4844e;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && b.f4844e) {
                for (C0171b c0171b : bVar.f4847c) {
                    for (String str : c0171b.f4849a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0171b.f4851c) ? h2 : c0171b.f4851c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-148975345, "Lb/a/p0/a/f1/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-148975345, "Lb/a/p0/a/f1/g/b;");
                return;
            }
        }
        f4844e = k.f6863a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4847c = new ArrayList();
        this.f4848d = b.class.getPackage().getName();
    }

    public synchronized C0171b d() {
        InterceptResult invokeV;
        C0171b c0171b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c0171b = new C0171b(this, null);
                this.f4847c.add(c0171b);
            }
            return c0171b;
        }
        return (C0171b) invokeV.objValue;
    }

    public synchronized C0171b e(String str) {
        InterceptResult invokeL;
        C0171b d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                d2 = d();
                d2.a(str);
            }
            return d2;
        }
        return (C0171b) invokeL.objValue;
    }

    public synchronized C0171b f(String str, String str2) {
        InterceptResult invokeLL;
        C0171b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            synchronized (this) {
                e2 = e(str2);
                e2.b(str);
            }
            return e2;
        }
        return (C0171b) invokeLL.objValue;
    }

    public b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f4845a = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f4845a : (String) invokeV.objValue;
    }

    public synchronized List<C0171b> i() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f4847c);
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
                k(this.f4846b);
            }
            return this;
        }
        return (b) invokeV.objValue;
    }

    public synchronized b k(b.a.p0.a.z2.g1.c<b> cVar) {
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

    public b l(b.a.p0.a.z2.g1.c<b> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar)) == null) {
            this.f4846b = cVar;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
