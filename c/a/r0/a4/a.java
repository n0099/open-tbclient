package c.a.r0.a4;

import c.a.q0.t.c.l0;
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
    public long f15844a;

    /* renamed from: b  reason: collision with root package name */
    public long f15845b;

    /* renamed from: c  reason: collision with root package name */
    public long f15846c;

    /* renamed from: d  reason: collision with root package name */
    public long f15847d;

    /* renamed from: e  reason: collision with root package name */
    public l0 f15848e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f15849f;

    /* renamed from: c.a.r0.a4.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0757a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f15850a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0757a(a aVar, int i2) {
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
            this.f15850a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f15850a.f();
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
        this.f15849f = new C0757a(this, 2001371);
        c();
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f15844a != 0 && this.f15845b != 0 && this.f15846c != 0) {
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
            this.f15847d = c.a.q0.s.d0.b.j().l("key_video_splash_last_show_time", 0L);
            MessageManager.getInstance().registerListener(this.f15849f);
        }
    }

    public final boolean d(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, date)) == null) ? date != null && date.getTime() >= this.f15844a && date.getTime() <= this.f15845b : invokeL.booleanValue;
    }

    public final boolean e(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, date)) == null) ? date != null && date.getTime() - this.f15847d >= this.f15846c : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f15848e == null) {
                this.f15848e = new l0();
            }
            this.f15848e.g(c.a.q0.s.d0.b.j().p("key_video_splash_config", ""));
            this.f15844a = this.f15848e.e();
            this.f15845b = this.f15848e.a();
            this.f15846c = this.f15848e.d();
        }
    }

    public void g(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.f15847d = j2;
            c.a.q0.s.d0.b.j().w("key_video_splash_last_show_time", j2);
        }
    }
}
