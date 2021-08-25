package c.a.o0.a.u.f.b.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends BasePendingOperation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC0421a f9126e;

    /* renamed from: c.a.o0.a.u.f.b.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0421a {
        void a();
    }

    public a(InterfaceC0421a interfaceC0421a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC0421a};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9126e = interfaceC0421a;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public BasePendingOperation.OperationType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST : (BasePendingOperation.OperationType) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC0421a interfaceC0421a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (interfaceC0421a = this.f9126e) == null) {
            return;
        }
        interfaceC0421a.a();
    }
}
