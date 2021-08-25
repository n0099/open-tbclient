package c.a.e.c.h;

import androidx.core.view.InputDeviceCompat;
import c.a.e.c.e.c.g;
import c.a.e.c.f.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class d extends c<SocketMessage, SocketMessageTask, k, SocketResponsedMessage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public g f2077i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MessageManager messageManager) {
        super(messageManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {messageManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MessageManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2077i = null;
        this.f2077i = new g(messageManager);
        this.f2074e = c.a.e.c.j.c.c();
    }

    @Override // c.a.e.c.b
    public LinkedList<SocketMessage> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) ? this.f2077i.e(i2, bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // c.a.e.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bdUniqueId) == null) {
            this.f2077i.h(i2, bdUniqueId);
        }
    }

    public LinkedList<SocketMessage> v(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdUniqueId)) == null) ? this.f2077i.n(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public g w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f2077i : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.c.h.c
    /* renamed from: x */
    public SocketMessage l(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, socketMessage, socketMessageTask)) == null) ? this.f2070a.getController().m(socketMessage, socketMessageTask) : (SocketMessage) invokeLL.objValue;
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.f2077i.C(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.c.b
    /* renamed from: z */
    public void f(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, socketMessage, socketMessageTask) == null) {
            this.f2077i.f(socketMessage, socketMessageTask);
        }
    }
}
