package b.a.e0.k.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface a {

    /* renamed from: b.a.e0.k.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f2673a;

        /* renamed from: b  reason: collision with root package name */
        public String f2674b;

        /* renamed from: c  reason: collision with root package name */
        public long f2675c;

        /* renamed from: d  reason: collision with root package name */
        public String f2676d;

        public C0057a() {
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
            this.f2673a = 2;
        }
    }

    void a(C0057a c0057a);
}
