package b.a.e.c.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class a extends c<CustomMessage<?>, CustomMessageTask, b.a.e.c.f.b, CustomResponsedMessage<?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public b.a.e.c.e.b f1550i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MessageManager messageManager) {
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
        this.f1550i = null;
        this.f1550i = new b.a.e.c.e.b(messageManager);
        this.f1557e = b.a.e.c.j.a.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.c.b
    /* renamed from: A */
    public void f(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, customMessage, customMessageTask) == null) {
            this.f1550i.f(customMessage, customMessageTask);
        }
    }

    @Override // b.a.e.c.b
    public LinkedList<CustomMessage<?>> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bdUniqueId)) == null) ? this.f1550i.e(i2, bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // b.a.e.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, bdUniqueId) == null) {
            this.f1550i.h(i2, bdUniqueId);
        }
    }

    public LinkedList<CustomMessage<?>> w(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdUniqueId)) == null) ? this.f1550i.i(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.c.h.c
    /* renamed from: x */
    public CustomMessage<?> m(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, customMessage, customMessageTask)) == null) ? this.f1553a.getController().g(customMessage, customMessageTask) : (CustomMessage) invokeLL.objValue;
    }

    public void y(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.f1550i.j(bdUniqueId);
        }
    }

    public <T> CustomResponsedMessage<T> z(CustomMessage<?> customMessage, CustomMessageTask customMessageTask, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, customMessage, customMessageTask, cls)) == null) ? this.f1550i.k(customMessage, customMessageTask, cls) : (CustomResponsedMessage) invokeLLL.objValue;
    }
}
