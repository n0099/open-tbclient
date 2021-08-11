package c.a.l0;

import android.content.Context;
import android.text.TextUtils;
import c.a.l0.l.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f3655a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3656b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3657c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void onFinish(String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3658e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3659f;

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
            this.f3659f = aVar;
            this.f3658e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3659f.e(this.f3658e);
                    c.a.l0.e.c.j().d(this.f3658e);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3660e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f3661f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0089a f3662g;

        public c(a aVar, Context context, long j2, InterfaceC0089a interfaceC0089a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0089a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3660e = context;
            this.f3661f = j2;
            this.f3662g = interfaceC0089a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.l0.e.c.j().e(this.f3660e, 0, null, this.f3661f, this.f3662g);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3663e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f3664f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0089a f3665g;

        public d(a aVar, Context context, long j2, InterfaceC0089a interfaceC0089a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0089a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3663e = context;
            this.f3664f = j2;
            this.f3665g = interfaceC0089a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.l0.e.c.j().f(this.f3663e, this.f3664f, this.f3665g);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f3667f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0089a f3668g;

        public e(a aVar, Context context, long j2, InterfaceC0089a interfaceC0089a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0089a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3666e = context;
            this.f3667f = j2;
            this.f3668g = interfaceC0089a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.l0.e.c.j().l(this.f3666e, this.f3667f, this.f3668g);
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
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
            if (f3655a == null) {
                synchronized (a.class) {
                    if (f3655a == null) {
                        f3655a = new a();
                    }
                }
            }
            return f3655a;
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
                    f3656b = str;
                    f3657c = str2;
                    c.a.l0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    c.a.l0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = c.a.l0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                c.a.l0.b.a.h(context).j();
            }
            f3656b = split[0];
            f3657c = split[1];
        }
    }

    public void f(Context context, long j2, InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), interfaceC0089a}) == null) {
            try {
                c.a.l0.k.b.a().post(new d(this, context, j2, interfaceC0089a));
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j2, InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), interfaceC0089a}) == null) {
            try {
                c.a.l0.k.b.a().post(new c(this, context, j2, interfaceC0089a));
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                c.a.l0.b.a.h(context).R(z);
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j2, InterfaceC0089a interfaceC0089a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j2), interfaceC0089a}) == null) {
            try {
                c.a.l0.k.b.a().post(new e(this, context, j2, interfaceC0089a));
            } catch (Throwable th) {
                c.a.l0.l.c.d(th);
            }
        }
    }
}
