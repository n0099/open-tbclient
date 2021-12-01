package c.a.r0.d1.q2;

import android.os.MessageQueue;
import c.a.r0.t3.t;
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
    public FrsModelController a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<c.a.r0.t3.m> f15881b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, c.a.r0.t3.m> f15882c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, c.a.r0.t3.m> f15883d;

    /* renamed from: e  reason: collision with root package name */
    public t f15884e;

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
            this.a = frsModelController;
        }
    }

    public void b(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tVar) == null) {
            this.f15884e = tVar;
        }
    }

    public void c(MvcHttpMessage<FrsRequestData, c.a.r0.t3.m> mvcHttpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcHttpMessage) == null) {
            this.f15882c = mvcHttpMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, c.a.r0.t3.m> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f15883d = mvcNetMessage;
        }
    }

    public void e(MvcHttpResponsedMessage<c.a.r0.t3.m> mvcHttpResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcHttpResponsedMessage) == null) {
            this.f15881b = mvcHttpResponsedMessage;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.a;
            if (frsModelController == null) {
                return false;
            }
            frsModelController.A0(this.f15881b, this.f15882c, this.f15883d);
            t tVar = this.f15884e;
            if (tVar != null) {
                tVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
