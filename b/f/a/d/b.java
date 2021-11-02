package b.f.a.d;

import b.f.a.a.a;
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
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static final String f30690b = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.f.a.a.a f30691a;

    /* loaded from: classes6.dex */
    public class a implements a.InterfaceC1456a {
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

        @Override // b.f.a.a.a.InterfaceC1456a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f30690b;
                LogUtil.i(str, b.f30690b + " Idle ---> Active.");
                HeartBeatManager.getInstance().c(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }
    }

    /* renamed from: b.f.a.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1460b implements a.InterfaceC1456a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1460b(b bVar) {
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

        @Override // b.f.a.a.a.InterfaceC1456a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f30690b;
                LogUtil.i(str, b.f30690b + " Active ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements a.InterfaceC1456a {
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

        @Override // b.f.a.a.a.InterfaceC1456a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f30690b;
                LogUtil.i(str, b.f30690b + " Active ---> HalfActive.");
                HeartBeatManager.getInstance().c(Calendar.getInstance().getTimeInMillis() / 1000);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements a.InterfaceC1456a {
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

        @Override // b.f.a.a.a.InterfaceC1456a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f30690b;
                LogUtil.i(str, b.f30690b + " HalfActive ---> Active.");
                HeartBeatManager.getInstance().c(0L);
                HeartBeatManager.getInstance().startHeartBeat();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements a.InterfaceC1456a {
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

        @Override // b.f.a.a.a.InterfaceC1456a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = b.f30690b;
                LogUtil.i(str, b.f30690b + " HalfActive ---> Idle.");
                HeartBeatManager.getInstance().stopHeartBeat();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1294329676, "Lb/f/a/d/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1294329676, "Lb/f/a/d/b;");
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
        this.f30691a = null;
        c();
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 >= 1 && i2 <= 4) {
                b.f.a.a.a aVar = this.f30691a;
                if (aVar != null) {
                    aVar.a(i2);
                    return;
                }
                throw new RuntimeException(f30690b + " sendEvent but the mStateMachine is null.");
            }
            throw new IllegalArgumentException(f30690b + " invalid params eventId:" + i2);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.f.a.a.a aVar = new b.f.a.a.a(1);
            this.f30691a = aVar;
            aVar.getClass();
            aVar.b(new a.b(aVar, 1, 3, 1, new a(this)));
            b.f.a.a.a aVar2 = this.f30691a;
            aVar2.getClass();
            aVar2.b(new a.b(aVar2, 3, 1, 2, new C1460b(this)));
            b.f.a.a.a aVar3 = this.f30691a;
            aVar3.getClass();
            aVar3.b(new a.b(aVar3, 3, 2, 3, new c(this)));
            b.f.a.a.a aVar4 = this.f30691a;
            aVar4.getClass();
            aVar4.b(new a.b(aVar4, 2, 3, 4, new d(this)));
            b.f.a.a.a aVar5 = this.f30691a;
            aVar5.getClass();
            aVar5.b(new a.b(aVar5, 2, 1, 2, new e(this)));
        }
    }
}
