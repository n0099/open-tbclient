package c.f.a.d;

import c.f.a.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.heartbeat.HeartBeatManager;
import com.dxmpay.apollon.utils.LogUtil;
import java.util.Calendar;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f28125b = "b";
    public transient /* synthetic */ FieldHolder $fh;
    public c.f.a.a.a a;

    /* loaded from: classes9.dex */
    public class a implements a.InterfaceC1634a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(b bVar) {
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

        @Override // c.f.a.a.a.InterfaceC1634a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f28125b;
                LogUtil.i(str, b.f28125b + " Idle ---> Active.");
                HeartBeatManager.getInstance().c(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }
    }

    /* renamed from: c.f.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1638b implements a.InterfaceC1634a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1638b(b bVar) {
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

        @Override // c.f.a.a.a.InterfaceC1634a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f28125b;
                LogUtil.i(str, b.f28125b + " Active ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.InterfaceC1634a {
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

        @Override // c.f.a.a.a.InterfaceC1634a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f28125b;
                LogUtil.i(str, b.f28125b + " Active ---> HalfActive.");
                HeartBeatManager.getInstance().c(Calendar.getInstance().getTimeInMillis() / 1000);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.InterfaceC1634a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(b bVar) {
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

        @Override // c.f.a.a.a.InterfaceC1634a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f28125b;
                LogUtil.i(str, b.f28125b + " HalfActive ---> Active.");
                HeartBeatManager.getInstance().c(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements a.InterfaceC1634a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(b bVar) {
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

        @Override // c.f.a.a.a.InterfaceC1634a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f28125b;
                LogUtil.i(str, b.f28125b + " HalfActive ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1490843181, "Lc/f/a/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1490843181, "Lc/f/a/d/b;");
        }
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
        this.a = null;
        c();
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 >= 1 && i2 <= 4) {
                c.f.a.a.a aVar = this.a;
                if (aVar != null) {
                    aVar.a(i2);
                    return;
                }
                throw new RuntimeException(f28125b + " sendEvent but the mStateMachine is null.");
            }
            throw new IllegalArgumentException(f28125b + " invalid params eventId:" + i2);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.f.a.a.a aVar = new c.f.a.a.a(1);
            this.a = aVar;
            aVar.getClass();
            aVar.b(new a.b(aVar, 1, 3, 1, new a(this)));
            c.f.a.a.a aVar2 = this.a;
            aVar2.getClass();
            aVar2.b(new a.b(aVar2, 3, 1, 2, new C1638b(this)));
            c.f.a.a.a aVar3 = this.a;
            aVar3.getClass();
            aVar3.b(new a.b(aVar3, 3, 2, 3, new c(this)));
            c.f.a.a.a aVar4 = this.a;
            aVar4.getClass();
            aVar4.b(new a.b(aVar4, 2, 3, 4, new d(this)));
            c.f.a.a.a aVar5 = this.a;
            aVar5.getClass();
            aVar5.b(new a.b(aVar5, 2, 1, 2, new e(this)));
        }
    }
}
