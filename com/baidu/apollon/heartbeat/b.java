package com.baidu.apollon.heartbeat;

import com.baidu.apollon.a.a;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37965a = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.a.a f37966b;

    /* loaded from: classes5.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f37972a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f37973b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f37974c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f37975d = 4;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f37976e;

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
                    return;
                }
            }
            this.f37976e = bVar;
        }
    }

    /* renamed from: com.baidu.apollon.heartbeat.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C1615b {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f37977a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f37978b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f37979c = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f37980d;

        public C1615b(b bVar) {
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
            this.f37980d = bVar;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-793707350, "Lcom/baidu/apollon/heartbeat/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-793707350, "Lcom/baidu/apollon/heartbeat/b;");
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
        this.f37966b = null;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.baidu.apollon.a.a aVar = new com.baidu.apollon.a.a(1);
            this.f37966b = aVar;
            aVar.getClass();
            aVar.a(new a.b(aVar, 1, 3, 1, new a.InterfaceC1613a(this) { // from class: com.baidu.apollon.heartbeat.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37967a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37967a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC1613a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f37965a;
                        LogUtil.i(str, b.f37965a + " Idle ---> Active.");
                        HeartBeatManager.getInstance().a(0L);
                        HeartBeatManager.getInstance().startHeartBeat();
                    }
                }
            }));
            com.baidu.apollon.a.a aVar2 = this.f37966b;
            aVar2.getClass();
            aVar2.a(new a.b(aVar2, 3, 1, 2, new a.InterfaceC1613a(this) { // from class: com.baidu.apollon.heartbeat.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37968a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37968a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC1613a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f37965a;
                        LogUtil.i(str, b.f37965a + " Active ---> Idle.");
                        HeartBeatManager.getInstance().stopHeartBeat();
                    }
                }
            }));
            com.baidu.apollon.a.a aVar3 = this.f37966b;
            aVar3.getClass();
            aVar3.a(new a.b(aVar3, 3, 2, 3, new a.InterfaceC1613a(this) { // from class: com.baidu.apollon.heartbeat.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37969a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37969a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC1613a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f37965a;
                        LogUtil.i(str, b.f37965a + " Active ---> HalfActive.");
                        HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
                    }
                }
            }));
            com.baidu.apollon.a.a aVar4 = this.f37966b;
            aVar4.getClass();
            aVar4.a(new a.b(aVar4, 2, 3, 4, new a.InterfaceC1613a(this) { // from class: com.baidu.apollon.heartbeat.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37970a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37970a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC1613a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f37965a;
                        LogUtil.i(str, b.f37965a + " HalfActive ---> Active.");
                        HeartBeatManager.getInstance().a(0L);
                        HeartBeatManager.getInstance().startHeartBeat();
                    }
                }
            }));
            com.baidu.apollon.a.a aVar5 = this.f37966b;
            aVar5.getClass();
            aVar5.a(new a.b(aVar5, 2, 1, 2, new a.InterfaceC1613a(this) { // from class: com.baidu.apollon.heartbeat.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37971a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f37971a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC1613a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f37965a;
                        LogUtil.i(str, b.f37965a + " HalfActive ---> Idle.");
                        HeartBeatManager.getInstance().stopHeartBeat();
                    }
                }
            }));
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 >= 1 && i2 <= 4) {
                com.baidu.apollon.a.a aVar = this.f37966b;
                if (aVar != null) {
                    aVar.b(i2);
                    return;
                }
                throw new RuntimeException(f37965a + " sendEvent but the mStateMachine is null.");
            }
            throw new IllegalArgumentException(f37965a + " invalid params eventId:" + i2);
        }
    }
}
