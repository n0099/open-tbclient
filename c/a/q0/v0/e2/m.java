package c.a.q0.v0.e2;

import android.os.MessageQueue;
import c.a.q0.i3.s;
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
/* loaded from: classes4.dex */
public class m implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsModelController f26017a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<c.a.q0.i3.m> f26018b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, c.a.q0.i3.m> f26019c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, c.a.q0.i3.m> f26020d;

    /* renamed from: e  reason: collision with root package name */
    public s f26021e;

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
            this.f26017a = frsModelController;
        }
    }

    public void b(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar) == null) {
            this.f26021e = sVar;
        }
    }

    public void c(MvcHttpMessage<FrsRequestData, c.a.q0.i3.m> mvcHttpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcHttpMessage) == null) {
            this.f26019c = mvcHttpMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, c.a.q0.i3.m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f26020d = mvcNetMessage;
        }
    }

    public void e(MvcHttpResponsedMessage<c.a.q0.i3.m> mvcHttpResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcHttpResponsedMessage) == null) {
            this.f26018b = mvcHttpResponsedMessage;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f26017a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.A0(this.f26018b, this.f26019c, this.f26020d);
            s sVar = this.f26021e;
            if (sVar != null) {
                sVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
