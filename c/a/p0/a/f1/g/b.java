package c.a.p0.a.f1.g;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
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
    public static final boolean f5709e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f5710a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.v2.e1.b<b> f5711b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0188b> f5712c;

    /* renamed from: d  reason: collision with root package name */
    public String f5713d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.p0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0188b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f5714a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f5715b;

        /* renamed from: c  reason: collision with root package name */
        public String f5716c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f5717d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5718e;

        public /* synthetic */ C0188b(b bVar, a aVar) {
            this(bVar);
        }

        public synchronized C0188b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                synchronized (this) {
                    List<String> list = this.f5714a;
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    list.add(str);
                }
                return this;
            }
            return (C0188b) invokeL.objValue;
        }

        public C0188b b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.f5716c = str;
                return this;
            }
            return (C0188b) invokeL.objValue;
        }

        public synchronized C0188b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    d(this.f5717d.size());
                }
                return this;
            }
            return (C0188b) invokeV.objValue;
        }

        public synchronized C0188b d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                synchronized (this) {
                    if (i2 < 1) {
                        i2 = 1;
                    }
                    if (i2 > this.f5717d.size()) {
                        i2 = this.f5717d.size();
                    }
                    for (int i3 = 0; i3 < i2; i3++) {
                        b bVar = this.f5718e;
                        bVar.e("[Trace]==> " + this.f5717d.get(i3).toString());
                    }
                }
                return this;
            }
            return (C0188b) invokeI.objValue;
        }

        public synchronized C0188b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                synchronized (this) {
                    d(1);
                }
                return this;
            }
            return (C0188b) invokeV.objValue;
        }

        public C0188b(b bVar) {
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
            this.f5718e = bVar;
            this.f5714a = new ArrayList();
            this.f5715b = new ArrayList();
            this.f5717d = new ArrayList();
            int i4 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i4++;
                if (i4 > 2 && !stackTraceElement.getClassName().startsWith(bVar.f5713d)) {
                    this.f5717d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.v2.e1.b<b> {
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
                boolean unused = b.f5709e;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) && b.f5709e) {
                for (C0188b c0188b : bVar.f5712c) {
                    for (String str : c0188b.f5714a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0188b.f5716c) ? h2 : c0188b.f5716c;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-659509522, "Lc/a/p0/a/f1/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-659509522, "Lc/a/p0/a/f1/g/b;");
                return;
            }
        }
        f5709e = k.f7077a;
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
        this.f5712c = new ArrayList();
        this.f5713d = b.class.getPackage().getName();
    }

    public synchronized C0188b d() {
        InterceptResult invokeV;
        C0188b c0188b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c0188b = new C0188b(this, null);
                this.f5712c.add(c0188b);
            }
            return c0188b;
        }
        return (C0188b) invokeV.objValue;
    }

    public synchronized C0188b e(String str) {
        InterceptResult invokeL;
        C0188b d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                d2 = d();
                d2.a(str);
            }
            return d2;
        }
        return (C0188b) invokeL.objValue;
    }

    public synchronized C0188b f(String str, String str2) {
        InterceptResult invokeLL;
        C0188b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            synchronized (this) {
                e2 = e(str2);
                e2.b(str);
            }
            return e2;
        }
        return (C0188b) invokeLL.objValue;
    }

    public b g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f5710a = str;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5710a : (String) invokeV.objValue;
    }

    public synchronized List<C0188b> i() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList(this.f5712c);
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
                k(this.f5711b);
            }
            return this;
        }
        return (b) invokeV.objValue;
    }

    public synchronized b k(c.a.p0.a.v2.e1.b<b> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            synchronized (this) {
                if (bVar == null) {
                    try {
                        bVar = new c(this, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                bVar.onCallback(this);
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b l(c.a.p0.a.v2.e1.b<b> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar)) == null) {
            this.f5711b = bVar;
            return this;
        }
        return (b) invokeL.objValue;
    }
}
