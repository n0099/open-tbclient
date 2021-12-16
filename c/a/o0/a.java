package c.a.o0;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.l.k;
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
    public static String f4182b;

    /* renamed from: c  reason: collision with root package name */
    public static String f4183c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0189a {
        void onFinish(String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4184e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4185f;

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
            this.f4185f = aVar;
            this.f4184e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f4185f.e(this.f4184e);
                    c.a.o0.e.c.j().d(this.f4184e);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4186e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f4187f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0189a f4188g;

        public c(a aVar, Context context, long j2, InterfaceC0189a interfaceC0189a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0189a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4186e = context;
            this.f4187f = j2;
            this.f4188g = interfaceC0189a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.o0.e.c.j().e(this.f4186e, 0, null, this.f4187f, this.f4188g);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f4190f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0189a f4191g;

        public d(a aVar, Context context, long j2, InterfaceC0189a interfaceC0189a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0189a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4189e = context;
            this.f4190f = j2;
            this.f4191g = interfaceC0189a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.o0.e.c.j().f(this.f4189e, this.f4190f, this.f4191g);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4192e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f4193f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0189a f4194g;

        public e(a aVar, Context context, long j2, InterfaceC0189a interfaceC0189a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, Long.valueOf(j2), interfaceC0189a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4192e = context;
            this.f4193f = j2;
            this.f4194g = interfaceC0189a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    c.a.o0.e.c.j().l(this.f4192e, this.f4193f, this.f4194g);
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
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
                    f4182b = str;
                    f4183c = str2;
                    c.a.o0.k.b.a().post(new b(this, context));
                } catch (Throwable th) {
                    c.a.o0.l.c.d(th);
                }
            }
        }
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            String l0 = c.a.o0.b.a.h(context).l0();
            if (TextUtils.isEmpty(l0)) {
                return;
            }
            String[] split = l0.split("_");
            if (split.length != 2) {
                c.a.o0.b.a.h(context).j();
            }
            f4182b = split[0];
            f4183c = split[1];
        }
    }

    public void f(Context context, long j2, InterfaceC0189a interfaceC0189a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j2), interfaceC0189a}) == null) {
            try {
                c.a.o0.k.b.a().post(new d(this, context, j2, interfaceC0189a));
            } catch (Throwable th) {
                c.a.o0.l.c.d(th);
            }
        }
    }

    public void g(Context context, long j2, InterfaceC0189a interfaceC0189a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Long.valueOf(j2), interfaceC0189a}) == null) {
            try {
                c.a.o0.k.b.a().post(new c(this, context, j2, interfaceC0189a));
            } catch (Throwable th) {
                c.a.o0.l.c.d(th);
            }
        }
    }

    public void h(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            try {
                c.a.o0.b.a.h(context).R(z);
            } catch (Throwable th) {
                c.a.o0.l.c.d(th);
            }
        }
    }

    public void i(Context context, long j2, InterfaceC0189a interfaceC0189a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Long.valueOf(j2), interfaceC0189a}) == null) {
            try {
                c.a.o0.k.b.a().post(new e(this, context, j2, interfaceC0189a));
            } catch (Throwable th) {
                c.a.o0.l.c.d(th);
            }
        }
    }
}
