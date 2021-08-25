package c.a.q0.c1;

import c.a.e.c.f.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c() {
        super(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
    @Override // c.a.e.c.f.g
    public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        c(socketResponsedMessage2);
        return socketResponsedMessage2;
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
            if (socketResponsedMessage != null && socketResponsedMessage.getError() == 1990055 && !a.c(socketResponsedMessage.getCmd())) {
                a.d();
            }
            return socketResponsedMessage;
        }
        return (SocketResponsedMessage) invokeL.objValue;
    }
}
