package c.a.p0;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.l.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;

    /* renamed from: b  reason: collision with root package name */
    public static String f4681b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4682c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0231a {
        void onFinish(String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4683e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4684f;

        public b(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4684f = aVar;
            this.f4683e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f4684f.e(this.f4683e);
                    c.a.p0.e.c.j().d(this.f4683e);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4685e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f4686f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0231a f4687g;

        public c(a aVar, Context context, long j2, InterfaceC0231a interfaceC0231a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0231a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4685e = context;
            this.f4686f = j2;
            this.f4687g = interfaceC0231a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.p0.e.c.j().e(this.f4685e, 0, null, this.f4686f, this.f4687g);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4688e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f4689f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0231a f4690g;

        public d(a aVar, Context context, long j2, InterfaceC0231a interfaceC0231a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0231a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4688e = context;
            this.f4689f = j2;
            this.f4690g = interfaceC0231a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.p0.e.c.j().f(this.f4688e, this.f4689f, this.f4690g);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4691e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f4692f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0231a f4693g;

        public e(a aVar, Context context, long j2, InterfaceC0231a interfaceC0231a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0231a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4691e = context;
            this.f4692f = j2;
            this.f4693g = interfaceC0231a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.p0.e.c.j().l(this.f4691e, this.f4692f, this.f4693g);
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
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

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            int intValue = ((Integer) k.d(context).second).intValue();
            if (intValue == 1) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_MOBILE;
            }
            if (intValue == 3) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_TELECOM;
            }
            if (intValue == 2) {
                return OneKeyLoginSdkCall.OPERATOR_CHINA_UNICOM;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public synchronized void d(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2) == null) {
            synchronized (this) {
                try {
                    f4681b = str;
                    f4682c = str2;
                    c.a.p0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    c.a.p0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = c.a.p0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                c.a.p0.b.a.h(context).j();
            }
            f4681b = split[0];
            f4682c = split[1];
        }
    }

    public void f(Context context, long j2, InterfaceC0231a interfaceC0231a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), interfaceC0231a}) == null) {
            try {
                c.a.p0.k.b.a().post(new d(this, context, j2, interfaceC0231a));
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j2, InterfaceC0231a interfaceC0231a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), interfaceC0231a}) == null) {
            try {
                c.a.p0.k.b.a().post(new c(this, context, j2, interfaceC0231a));
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                c.a.p0.b.a.h(context).R(z);
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j2, InterfaceC0231a interfaceC0231a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j2), interfaceC0231a}) == null) {
            try {
                c.a.p0.k.b.a().post(new e(this, context, j2, interfaceC0231a));
            } catch (Throwable th) {
                c.a.p0.l.c.d(th);
            }
        }
    }
}
