package c.a.p0.f1.h2;

import android.os.MessageQueue;
import c.a.p0.a4.u;
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
/* loaded from: classes2.dex */
public class n implements MessageQueue.IdleHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsModelController a;

    /* renamed from: b  reason: collision with root package name */
    public MvcSocketResponsedMessage<c.a.p0.a4.n, ?> f14056b;

    /* renamed from: c  reason: collision with root package name */
    public MvcSocketMessage<FrsRequestData, c.a.p0.a4.n> f14057c;

    /* renamed from: d  reason: collision with root package name */
    public MvcNetMessage<FrsRequestData, c.a.p0.a4.n> f14058d;

    /* renamed from: e  reason: collision with root package name */
    public u f14059e;

    public n() {
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
            this.f14059e = uVar;
        }
    }

    public void c(MvcSocketMessage<FrsRequestData, c.a.p0.a4.n> mvcSocketMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketMessage) == null) {
            this.f14057c = mvcSocketMessage;
        }
    }

    public void d(MvcNetMessage<FrsRequestData, c.a.p0.a4.n> mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mvcNetMessage) == null) {
            this.f14058d = mvcNetMessage;
        }
    }

    public void e(MvcSocketResponsedMessage<c.a.p0.a4.n, ?> mvcSocketResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mvcSocketResponsedMessage) == null) {
            this.f14056b = mvcSocketResponsedMessage;
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
            frsModelController.D0(this.f14056b, this.f14057c, this.f14058d);
            u uVar = this.f14059e;
            if (uVar != null) {
                uVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
