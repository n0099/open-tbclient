package b.a.r0.x0.p2;

import android.os.MessageQueue;
import b.a.r0.l3.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f26150a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<b.a.r0.l3.m> f26151b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, b.a.r0.l3.m> f26152c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, b.a.r0.l3.m> f26153d;

    /* renamed from: e  reason: collision with root package name */
    public t f26154e;

    public m() {
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
            this.f26150a = frsModelController;
        }
    }

    public void b(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar) == null) {
            this.f26154e = tVar;
        }
    }

    public void c(MvcHttpMessage<FrsRequestData, b.a.r0.l3.m> mvcHttpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcHttpMessage) == null) {
            this.f26152c = mvcHttpMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, b.a.r0.l3.m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f26153d = mvcNetMessage;
        }
    }

    public void e(MvcHttpResponsedMessage<b.a.r0.l3.m> mvcHttpResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcHttpResponsedMessage) == null) {
            this.f26151b = mvcHttpResponsedMessage;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f26150a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.A0(this.f26151b, this.f26152c, this.f26153d);
            t tVar = this.f26154e;
            if (tVar != null) {
                tVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
