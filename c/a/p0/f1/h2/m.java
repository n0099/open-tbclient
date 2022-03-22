package c.a.p0.f1.h2;

import android.os.MessageQueue;
import c.a.p0.a4.u;
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
/* loaded from: classes2.dex */
public class m implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsModelController a;

    /* renamed from: b  reason: collision with root package name */
    public MvcHttpResponsedMessage<c.a.p0.a4.n> f14052b;

    /* renamed from: c  reason: collision with root package name */
    public MvcHttpMessage<FrsRequestData, c.a.p0.a4.n> f14053c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, c.a.p0.a4.n> f14054d;

    /* renamed from: e  reason: collision with root package name */
    public u f14055e;

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public void b(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar) == null) {
            this.f14055e = uVar;
        }
    }

    public void c(MvcHttpMessage<FrsRequestData, c.a.p0.a4.n> mvcHttpMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcHttpMessage) == null) {
            this.f14053c = mvcHttpMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, c.a.p0.a4.n> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f14054d = mvcNetMessage;
        }
    }

    public void e(MvcHttpResponsedMessage<c.a.p0.a4.n> mvcHttpResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcHttpResponsedMessage) == null) {
            this.f14052b = mvcHttpResponsedMessage;
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
            frsModelController.B0(this.f14052b, this.f14053c, this.f14054d);
            u uVar = this.f14055e;
            if (uVar != null) {
                uVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
