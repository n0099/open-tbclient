package c.a.e.c.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b extends c<HttpMessage, HttpMessageTask, c.a.e.c.f.d, HttpResponsedMessage> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public HttpClient f2068i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(MessageManager messageManager) {
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
        this.f2068i = null;
        this.f2068i = new HttpClient(messageManager);
        this.f2074e = c.a.e.c.j.b.d();
    }

    @Override // c.a.e.c.b
    public LinkedList<HttpMessage> e(int i2, BdUniqueId bdUniqueId) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bdUniqueId)) == null) ? this.f2068i.e(i2, bdUniqueId) : (LinkedList) invokeIL.objValue;
    }

    @Override // c.a.e.c.b
    public void h(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bdUniqueId) == null) {
            this.f2068i.h(i2, bdUniqueId);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
    @Override // c.a.e.c.h.c
    public /* bridge */ /* synthetic */ HttpMessage l(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        HttpMessage httpMessage2 = httpMessage;
        w(httpMessage2, httpMessageTask);
        return httpMessage2;
    }

    public LinkedList<HttpMessage> v(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bdUniqueId)) == null) ? this.f2068i.i(bdUniqueId) : (LinkedList) invokeL.objValue;
    }

    public HttpMessage w(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, httpMessage, httpMessageTask)) == null) ? httpMessage : (HttpMessage) invokeLL.objValue;
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            this.f2068i.k(bdUniqueId);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.c.b
    /* renamed from: y */
    public void f(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, httpMessage, httpMessageTask) == null) {
            if (httpMessageTask.getConnectTimeOut() == null) {
                httpMessageTask.setConnectTimeOut(((c.a.e.c.j.b) this.f2074e).c());
            }
            this.f2068i.f(httpMessage, httpMessageTask);
        }
    }
}
