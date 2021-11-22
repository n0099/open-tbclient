package b.a.n0;

import android.content.Context;
import android.text.TextUtils;
import b.a.n0.l.k;
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
    public static volatile a f3580a;

    /* renamed from: b  reason: collision with root package name */
    public static String f3581b;

    /* renamed from: c  reason: collision with root package name */
    public static String f3582c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0099a {
        void onFinish(String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3583e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f3584f;

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
            this.f3584f = aVar;
            this.f3583e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3584f.e(this.f3583e);
                    b.a.n0.e.c.j().d(this.f3583e);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3585e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f3586f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0099a f3587g;

        public c(a aVar, Context context, long j, InterfaceC0099a interfaceC0099a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0099a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3585e = context;
            this.f3586f = j;
            this.f3587g = interfaceC0099a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.a.n0.e.c.j().e(this.f3585e, 0, null, this.f3586f, this.f3587g);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3588e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f3589f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0099a f3590g;

        public d(a aVar, Context context, long j, InterfaceC0099a interfaceC0099a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0099a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3588e = context;
            this.f3589f = j;
            this.f3590g = interfaceC0099a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.a.n0.e.c.j().f(this.f3588e, this.f3589f, this.f3590g);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f3592f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0099a f3593g;

        public e(a aVar, Context context, long j, InterfaceC0099a interfaceC0099a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j), interfaceC0099a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3591e = context;
            this.f3592f = j;
            this.f3593g = interfaceC0099a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.a.n0.e.c.j().l(this.f3591e, this.f3592f, this.f3593g);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
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
            if (f3580a == null) {
                synchronized (a.class) {
                    if (f3580a == null) {
                        f3580a = new a();
                    }
                }
            }
            return f3580a;
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
                    f3581b = str;
                    f3582c = str2;
                    b.a.n0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = b.a.n0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                b.a.n0.b.a.h(context).j();
            }
            f3581b = split[0];
            f3582c = split[1];
        }
    }

    public void f(Context context, long j, InterfaceC0099a interfaceC0099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), interfaceC0099a}) == null) {
            try {
                b.a.n0.k.b.a().post(new d(this, context, j, interfaceC0099a));
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j, InterfaceC0099a interfaceC0099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j), interfaceC0099a}) == null) {
            try {
                b.a.n0.k.b.a().post(new c(this, context, j, interfaceC0099a));
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                b.a.n0.b.a.h(context).R(z);
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j, InterfaceC0099a interfaceC0099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j), interfaceC0099a}) == null) {
            try {
                b.a.n0.k.b.a().post(new e(this, context, j, interfaceC0099a));
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
            }
        }
    }
}
