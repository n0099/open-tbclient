package b.a.r0.i3.g;

import b.a.q0.t.c.n0;
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
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f19480a;

    /* renamed from: b  reason: collision with root package name */
    public long f19481b;

    /* renamed from: c  reason: collision with root package name */
    public long f19482c;

    /* renamed from: d  reason: collision with root package name */
    public long f19483d;

    /* renamed from: e  reason: collision with root package name */
    public n0 f19484e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f19485f;

    /* renamed from: b.a.r0.i3.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0985a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f19486a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0985a(a aVar, int i2) {
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
            this.f19486a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f19486a.f();
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
        this.f19485f = new C0985a(this, 2001371);
        c();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f19480a != 0 && this.f19481b != 0 && this.f19482c != 0) {
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
            this.f19483d = b.a.q0.s.e0.b.j().l("key_video_splash_last_show_time", 0L);
            MessageManager.getInstance().registerListener(this.f19485f);
        }
    }

    public final boolean d(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, date)) == null) ? date != null && date.getTime() >= this.f19480a && date.getTime() <= this.f19481b : invokeL.booleanValue;
    }

    public final boolean e(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) ? date != null && date.getTime() - this.f19483d >= this.f19482c : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f19484e == null) {
                this.f19484e = new n0();
            }
            this.f19484e.g(b.a.q0.s.e0.b.j().p("key_video_splash_config", ""));
            this.f19480a = this.f19484e.e();
            this.f19481b = this.f19484e.a();
            this.f19482c = this.f19484e.d();
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.f19483d = j;
            b.a.q0.s.e0.b.j().w("key_video_splash_last_show_time", j);
        }
    }
}
