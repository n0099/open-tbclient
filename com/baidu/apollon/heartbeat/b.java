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
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f3752a = "b";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.baidu.apollon.a.a f3753b;

    /* loaded from: classes.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f3759a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3760b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3761c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f3762d = 4;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3763e;

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
            this.f3763e = bVar;
        }
    }

    /* renamed from: com.baidu.apollon.heartbeat.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0061b {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static final int f3764a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f3765b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f3766c = 3;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f3767d;

        public C0061b(b bVar) {
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
            this.f3767d = bVar;
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
        this.f3753b = null;
        b();
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.baidu.apollon.a.a aVar = new com.baidu.apollon.a.a(1);
            this.f3753b = aVar;
            aVar.getClass();
            aVar.a(new a.b(aVar, 1, 3, 1, new a.InterfaceC0059a(this) { // from class: com.baidu.apollon.heartbeat.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f3754a;

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
                    this.f3754a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC0059a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f3752a;
                        LogUtil.i(str, b.f3752a + " Idle ---> Active.");
                        HeartBeatManager.getInstance().a(0L);
                        HeartBeatManager.getInstance().startHeartBeat();
                    }
                }
            }));
            com.baidu.apollon.a.a aVar2 = this.f3753b;
            aVar2.getClass();
            aVar2.a(new a.b(aVar2, 3, 1, 2, new a.InterfaceC0059a(this) { // from class: com.baidu.apollon.heartbeat.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f3755a;

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
                    this.f3755a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC0059a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f3752a;
                        LogUtil.i(str, b.f3752a + " Active ---> Idle.");
                        HeartBeatManager.getInstance().stopHeartBeat();
                    }
                }
            }));
            com.baidu.apollon.a.a aVar3 = this.f3753b;
            aVar3.getClass();
            aVar3.a(new a.b(aVar3, 3, 2, 3, new a.InterfaceC0059a(this) { // from class: com.baidu.apollon.heartbeat.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f3756a;

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
                    this.f3756a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC0059a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f3752a;
                        LogUtil.i(str, b.f3752a + " Active ---> HalfActive.");
                        HeartBeatManager.getInstance().a(Calendar.getInstance().getTimeInMillis() / 1000);
                    }
                }
            }));
            com.baidu.apollon.a.a aVar4 = this.f3753b;
            aVar4.getClass();
            aVar4.a(new a.b(aVar4, 2, 3, 4, new a.InterfaceC0059a(this) { // from class: com.baidu.apollon.heartbeat.b.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f3757a;

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
                    this.f3757a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC0059a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f3752a;
                        LogUtil.i(str, b.f3752a + " HalfActive ---> Active.");
                        HeartBeatManager.getInstance().a(0L);
                        HeartBeatManager.getInstance().startHeartBeat();
                    }
                }
            }));
            com.baidu.apollon.a.a aVar5 = this.f3753b;
            aVar5.getClass();
            aVar5.a(new a.b(aVar5, 2, 1, 2, new a.InterfaceC0059a(this) { // from class: com.baidu.apollon.heartbeat.b.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f3758a;

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
                    this.f3758a = this;
                }

                @Override // com.baidu.apollon.a.a.InterfaceC0059a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str = b.f3752a;
                        LogUtil.i(str, b.f3752a + " HalfActive ---> Idle.");
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
                com.baidu.apollon.a.a aVar = this.f3753b;
                if (aVar != null) {
                    aVar.b(i2);
                    return;
                }
                throw new RuntimeException(f3752a + " sendEvent but the mStateMachine is null.");
            }
            throw new IllegalArgumentException(f3752a + " invalid params eventId:" + i2);
        }
    }
}
