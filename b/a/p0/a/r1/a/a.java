package b.a.p0.a.r1.a;

import b.a.p0.a.f1.e.f.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8134a = new C0379a();

    /* renamed from: b.a.p0.a.r1.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0379a implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0379a() {
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

        @Override // b.a.p0.a.r1.a.a
        public <T extends c<T>> void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                t.x("rescue_refractory_period", 0L);
                t.x("suspend_delay_time", -1L);
                t.t("should_suspend_master_timer", false);
                t.t("should_suspend_all", false);
                t.t("should_suspend_slave_timer", false);
                t.t("should_suspend_web_view_timer", false);
                t.t("should_suspend_v8_timer", false);
            }
        }
    }

    <T extends c<T>> void a(T t);
}
