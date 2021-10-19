package c.a.r0.b4;

import c.a.q0.t.c.m0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f16010a;

    /* renamed from: b  reason: collision with root package name */
    public long f16011b;

    /* renamed from: c  reason: collision with root package name */
    public long f16012c;

    /* renamed from: d  reason: collision with root package name */
    public long f16013d;

    /* renamed from: e  reason: collision with root package name */
    public m0 f16014e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f16015f;

    /* renamed from: c.a.r0.b4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0763a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16016a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0763a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16016a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f16016a.f();
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
                return;
            }
        }
        this.f16015f = new C0763a(this, 2001371);
        c();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f16010a != 0 && this.f16011b != 0 && this.f16012c != 0) {
                Date date = new Date();
                if (d(date) && e(date)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f();
            this.f16013d = c.a.q0.s.d0.b.j().l("key_video_splash_last_show_time", 0L);
            MessageManager.getInstance().registerListener(this.f16015f);
        }
    }

    public final boolean d(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, date)) == null) ? date != null && date.getTime() >= this.f16010a && date.getTime() <= this.f16011b : invokeL.booleanValue;
    }

    public final boolean e(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) ? date != null && date.getTime() - this.f16013d >= this.f16012c : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f16014e == null) {
                this.f16014e = new m0();
            }
            this.f16014e.g(c.a.q0.s.d0.b.j().p("key_video_splash_config", ""));
            this.f16010a = this.f16014e.e();
            this.f16011b = this.f16014e.a();
            this.f16012c = this.f16014e.d();
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f16013d = j2;
            c.a.q0.s.d0.b.j().w("key_video_splash_last_show_time", j2);
        }
    }
}
