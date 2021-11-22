package b.a.q0.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.FutureTask;
/* loaded from: classes4.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<FutureTask<Boolean>> f12936a;

    /* renamed from: b  reason: collision with root package name */
    public List<g> f12937b;

    /* renamed from: c  reason: collision with root package name */
    public ErrorData f12938c;

    public h() {
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

    public void a(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, errorData) == null) && this.f12938c == null) {
            this.f12938c = errorData;
            for (FutureTask<Boolean> futureTask : this.f12936a) {
                futureTask.cancel(true);
            }
            for (g gVar : this.f12937b) {
                gVar.a();
            }
        }
    }

    public void b(List<g> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f12937b = list;
        }
    }

    public void c(List<FutureTask<Boolean>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f12936a = list;
        }
    }
}
