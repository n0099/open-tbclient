package c.a.d.c.f;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.FrameHelper;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<d> a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<k> f2438b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedList<b> f2439c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<c> f2440d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<j> f2441e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<a> f2442f;

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<e> f2443g;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedList<>();
        this.f2438b = new LinkedList<>();
        this.f2439c = new LinkedList<>();
        this.f2440d = new LinkedList<>();
        this.f2441e = new LinkedList<>();
        this.f2442f = new LinkedList<>();
        this.f2443g = new LinkedList<>();
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f2443g.add(eVar);
        }
    }

    public void b(f<?, ?> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) || fVar == null) {
            return;
        }
        n.c();
        if (fVar instanceof d) {
            FrameHelper.insert(this.a, (d) fVar);
        } else if (fVar instanceof k) {
            FrameHelper.insert(this.f2438b, (k) fVar);
        } else if (fVar instanceof b) {
            FrameHelper.insert(this.f2439c, (b) fVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void c(g<?> gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) || gVar == null) {
            return;
        }
        n.c();
        if (gVar instanceof c) {
            FrameHelper.insert(this.f2440d, (c) gVar);
        } else if (gVar instanceof j) {
            FrameHelper.insert(this.f2441e, (j) gVar);
        } else if (gVar instanceof a) {
            FrameHelper.insert(this.f2442f, (a) gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void d(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.f2443g.remove(eVar);
        }
    }

    public void e(f<?, ?> fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) || fVar == null) {
            return;
        }
        n.c();
        if (fVar instanceof d) {
            this.a.remove(fVar);
        } else if (fVar instanceof k) {
            this.f2438b.remove(fVar);
        } else if (fVar instanceof b) {
            this.f2439c.remove(fVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public void f(g<?> gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) || gVar == null) {
            return;
        }
        n.c();
        if (gVar instanceof c) {
            this.f2440d.remove(gVar);
        } else if (gVar instanceof j) {
            this.f2441e.remove(gVar);
        } else if (gVar instanceof a) {
            this.f2442f.remove(gVar);
        } else {
            BdLog.e("rule invalid");
        }
    }

    public CustomMessage<?> g(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, customMessage, customMessageTask)) == null) ? (CustomMessage) k(this.f2439c, customMessage, customMessageTask) : (CustomMessage) invokeLL.objValue;
    }

    public CustomResponsedMessage<?> h(CustomResponsedMessage<?> customResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, customResponsedMessage)) == null) ? (CustomResponsedMessage) l(this.f2442f, customResponsedMessage) : (CustomResponsedMessage) invokeL.objValue;
    }

    public HttpMessage i(HttpMessage httpMessage, HttpMessageTask httpMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, httpMessage, httpMessageTask)) == null) ? (HttpMessage) k(this.a, httpMessage, httpMessageTask) : (HttpMessage) invokeLL.objValue;
    }

    public HttpResponsedMessage j(HttpResponsedMessage httpResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, httpResponsedMessage)) == null) ? (HttpResponsedMessage) l(this.f2440d, httpResponsedMessage) : (HttpResponsedMessage) invokeL.objValue;
    }

    public final <M extends Message<?>, T extends MessageTask> M k(LinkedList<? extends f<M, T>> linkedList, M m, T t) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, linkedList, m, t)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size && m != null; i2++) {
                try {
                    m = linkedList.get(i2).rule(m, t);
                } catch (Exception e2) {
                    BdLog.e(e2, true);
                }
            }
            return m;
        }
        return (M) invokeLLL.objValue;
    }

    public final <M extends ResponsedMessage<?>> M l(LinkedList<? extends g<M>> linkedList, M m) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, linkedList, m)) == null) {
            if (linkedList == null) {
                return null;
            }
            int size = linkedList.size();
            for (int i2 = 0; i2 < size && m != null; i2++) {
                try {
                    m = linkedList.get(i2).b(m);
                } catch (Exception e2) {
                    BdLog.e("rule error = " + e2.getMessage());
                }
            }
            return m;
        }
        return (M) invokeLL.objValue;
    }

    public SocketMessage m(SocketMessage socketMessage, SocketMessageTask socketMessageTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, socketMessage, socketMessageTask)) == null) ? (SocketMessage) k(this.f2438b, socketMessage, socketMessageTask) : (SocketMessage) invokeLL.objValue;
    }

    public SocketResponsedMessage n(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, socketResponsedMessage)) == null) ? (SocketResponsedMessage) l(this.f2441e, socketResponsedMessage) : (SocketResponsedMessage) invokeL.objValue;
    }

    public void o(int i2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, bdUniqueId) == null) {
            int size = this.f2443g.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f2443g.get(i3).a(i2, bdUniqueId);
            }
        }
    }

    public void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            int size = this.f2443g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2443g.get(i2).b(bdUniqueId);
            }
        }
    }
}
