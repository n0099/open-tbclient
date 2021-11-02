package b.a.r0.x0.p2;

import android.os.MessageQueue;
import b.a.r0.l3.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f26155a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<b.a.r0.l3.m, ?> f26156b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, b.a.r0.l3.m> f26157c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, b.a.r0.l3.m> f26158d;

    /* renamed from: e  reason: collision with root package name */
    public t f26159e;

    public n() {
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

    public void a(FrsModelController frsModelController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frsModelController) == null) {
            this.f26155a = frsModelController;
        }
    }

    public void b(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar) == null) {
            this.f26159e = tVar;
        }
    }

    public void c(MvcSocketMessage<FrsRequestData, b.a.r0.l3.m> mvcSocketMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketMessage) == null) {
            this.f26157c = mvcSocketMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, b.a.r0.l3.m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f26158d = mvcNetMessage;
        }
    }

    public void e(MvcSocketResponsedMessage<b.a.r0.l3.m, ?> mvcSocketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcSocketResponsedMessage) == null) {
            this.f26156b = mvcSocketResponsedMessage;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f26155a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.C0(this.f26156b, this.f26157c, this.f26158d);
            t tVar = this.f26159e;
            if (tVar != null) {
                tVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
