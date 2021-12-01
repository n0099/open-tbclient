package c.a.b0.g0.p;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface k {
    public static final ServiceReference a = new ServiceReference("nad.core", "webViewInit");

    /* renamed from: b  reason: collision with root package name */
    public static final k f1567b = new a();

    /* loaded from: classes.dex */
    public static class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // c.a.b0.g0.p.k
        public int a(Context context, b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, bVar)) == null) {
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    int a(Context context, b bVar);
}
